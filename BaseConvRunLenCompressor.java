package com.company; import java.math.BigInteger;
import java.util.ArrayList;

public class BaseConvRunLenCompressor {
    String bitstring; int standardBitsAtStartDenotingBase = 5; int maxBaseToCheck= (int) Math.pow(2, standardBitsAtStartDenotingBase) - 1;
    int standardBitsAtDenotingExt = standardBitsAtStartDenotingBase;
    int chunkLength = 3;
    
    public BaseConvRunLenCompressor(String bitstring){this.bitstring=bitstring;}

    public String compressed(){
        String compressed = ""; String singlebits = "";
        for (int k = 0; k < bitstring.length()/chunkLength; k++) {
            String toCompress = bitstring.substring( k*chunkLength, (k+1)*(chunkLength) );

            ArrayList<Integer> runs = new ArrayList<>(); int currRunLen = 1; int maxRun = 0;
            for (int i = 1; i <= toCompress.length(); i++) {
                if(i == toCompress.length()){
                    runs.add(currRunLen);
                    maxRun = Math.max(maxRun, currRunLen);
                }
                else{
                    if(toCompress.charAt(i) == toCompress.charAt(i-1)){
                        currRunLen++;
                    }
                    else{
                        runs.add(currRunLen); //1,
                        maxRun = Math.max(maxRun, currRunLen); //1
                        currRunLen = 1;
                    }
                }
            }

            int base = maxRun+1; //could also make it maxRun if we're cheeky
            String makeIntoBigInt = "";
            for(int x : runs){
                String symbol = new BigInteger(Integer.toString(x), 10).toString(x+1);
                makeIntoBigInt += symbol;
            }
            BigInteger bi = new BigInteger(makeIntoBigInt, base);
            String currCompressed = bi.toString(2);
            compressed += currCompressed;
            if(currCompressed.length() == 2) singlebits += "0";
            else singlebits += "1";
        }
        System.out.println("single bits original length: " + singlebits.length());
        singlebits = new BitstringCompressor(singlebits, 15).compressedBitstring();
        System.out.println("singlebits of length " + singlebits.length() + " : " + singlebits);
        System.out.println("length of base conv RLE main: " + compressed.length());
        String ext = bitstring.substring(bitstring.length() - bitstring.length()%chunkLength, bitstring.length());
        return compressed + singlebits + ext;
    }
}
