package com.company;

import java.util.ArrayList;

public class EliasGammaRunLengthDecoder {
    String bitstring;
    public EliasGammaRunLengthDecoder(String bitstring){this.bitstring=bitstring;}

    public String decode(){
        String ret=""; String currBit = bitstring.substring(0,1);
//        System.out.println("first bit of orig: " + currBit);
//        System.out.println();

        while(bitstring.length() > 0){
            //find run on left
            char firstbit = bitstring.charAt(0); int ind = 0; int indShouldNotExceed = bitstring.length()+10;
            int leftbitcheck = -1; //bits on last pass shouldn't be exceeded thing
            if(bitstring.length() % 2 == 1){
//                System.out.println("bitstring length: " + bitstring.length());
                leftbitcheck = (int) Math.ceil(bitstring.length() / 2.0);
//                System.out.println("left bit check: " + leftbitcheck);
                indShouldNotExceed = leftbitcheck-1;
//                System.out.println("since odd length, calculate ind should not exceed " + indShouldNotExceed);
            }
            //find run on left
            while(bitstring.charAt(ind) == firstbit){
                ind++;
                if(bitstring.length() % 2 == 1){
                    if(ind > indShouldNotExceed){
                        break;
                    }
                }
                if(ind == bitstring.length()){
                    break;
                }
            }
//            System.out.println("ind: " + ind);
            //get bits on right, there will be run-1 bits
            int numBitsOnLeft = ind; int numBitsOnRight = numBitsOnLeft-1;
//            System.out.println("num bits on right: " + numBitsOnRight);
            //convert bits on right to dec using dec method
            String bitsOnRight = bitstring.substring(bitstring.length() - numBitsOnRight, bitstring.length());
//            System.out.println("bits on right: " + bitsOnRight);
            //find run length in original using right bits
            int runLenInOrig = (int) Math.pow(2, numBitsOnLeft-1) + dec(bitsOnRight);
//            System.out.println("run length in orig: " + runLenInOrig);
            //append to ret
            for (int i = 0; i < runLenInOrig; i++) {
                ret += currBit;
            }
//            System.out.println("ret becomes " + ret);
            //change currBit
            if(currBit.equals("1")) currBit = "0";
            else currBit = "1";
            //chop bitstring
            bitstring = bitstring.substring(numBitsOnLeft, bitstring.length()-numBitsOnRight);
//            System.out.println("bitstring becomes " + bitstring);
//            System.out.println();
        }
        return ret;
    }
    public static int dec(String binary){
        int ret = 0; int pow = 0;
        for (int i = binary.length()-1; i >= 0; i--) {
            if(binary.charAt(i) == '1')
                ret += (int) (Math.pow(2, pow));
            pow++;
        }
        return ret;
    }
}
