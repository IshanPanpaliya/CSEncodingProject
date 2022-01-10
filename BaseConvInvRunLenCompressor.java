package com.company; import java.math.BigInteger;
import java.util.ArrayList;

public class BaseConvInvRunLenCompressor {
    String bitstring; int standardBitsAtStartDenotingBase = 5; int maxBaseToCheck= (int) Math.pow(2, standardBitsAtStartDenotingBase) - 1;
    public BaseConvInvRunLenCompressor(String bitstring){this.bitstring=bitstring;}

    public String compressed(){
        BigInteger bitstringInt = new BigInteger(bitstring, 2);
        int minCompressedLength = Integer.MAX_VALUE; int minCompressedLengthBase = -1; String minOriginalBinary = "";
        for (int base = 2; base <= maxBaseToCheck; base++) {
//            System.out.println();
            String convertedToBase = bitstringInt.toString(base);
//            System.out.println("converted To Base " + base + ": " + convertedToBase);

            if(convertedToBase.contains("0")) continue;

            String originalBinary = ""; String currBit = "1";
            for (int i = 0; i < convertedToBase.length(); i++) {
                int currRunLen = Integer.parseInt(new BigInteger(convertedToBase.substring(i, i+1), base).toString(10));
                // the string will use symbols like a,b,... for higher bases so cant get integer ,also dont use chars becuz it returns ASCII number ID,
                for (int j = 0; j < currRunLen; j++) {
                    originalBinary += currBit;
                }
                if(currBit.equals("1")) currBit = "0";
                else currBit = "1";
            }
//            System.out.println("Original Binary: " + originalBinary);

            //check whether maxRunLen = base-1
            int maxRunLenInOrig = 0; int currRunLenInOrig=1; //make sure to start at 1
            for (int i = 1; i <= originalBinary.length(); i++) {
                if(i == originalBinary.length()){
                    maxRunLenInOrig = Math.max(maxRunLenInOrig, currRunLenInOrig);
                }
                else{
                    if(originalBinary.charAt(i) == originalBinary.charAt(i-1)){
                        currRunLenInOrig++;
                    }
                    else{
                        maxRunLenInOrig = Math.max(maxRunLenInOrig, currRunLenInOrig); //1
                        currRunLenInOrig = 1;
                    }
                }
            }

            if(maxRunLenInOrig != base-1) continue;
//            System.out.println("base is acceptable: " + base);

            int currCompressedLength = originalBinary.length();
            if(currCompressedLength < minCompressedLength){
                minCompressedLength = currCompressedLength;
                minCompressedLengthBase = base;
                minOriginalBinary = originalBinary;
            }
        }
//        return bin(minCompressedLengthBase, standardBitsAtStartDenotingBase) + minOriginalBinary; //dont need base info to decode

        return minOriginalBinary;
    }
    public static String bin(int i, int len){
        String ret = "";
        while(i != 0){
            if(i % 2 == 0) ret = "0" + ret;
            else ret = "1" + ret;
            i /= 2;
        }
        if(ret.equals("")) ret = "0";
        int lendif = len - ret.length(); //**will do bad stuff if len < ret.length()
        for (int j = 0; j < lendif; j++) {
            ret = "0" + ret;
        }
        return ret;
    }
}
