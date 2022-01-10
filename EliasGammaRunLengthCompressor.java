package com.company;

import java.util.ArrayList;

public class EliasGammaRunLengthCompressor {
    String bitstring; //wont work if starting thing is a 0
    public EliasGammaRunLengthCompressor(String bitstring){this.bitstring=bitstring;}

    public String giveCompressed(){
        String start = ""; String end = ""; //dont add but insert at start

        //find runs
        ArrayList<Integer> runs = new ArrayList<>(); int currRunLen = 1; int maxRun = 0;
        for (int i = 1; i <= bitstring.length(); i++) {
            if(i == bitstring.length()){
                runs.add(currRunLen);
            }
            else{
                if(bitstring.charAt(i) == bitstring.charAt(i-1)){
                    currRunLen++;
                }
                else{
                    runs.add(currRunLen); //1,
                    currRunLen = 1;
                }
            }
        }
        String currBit;
        if(bitstring.charAt(0) == '0') currBit = "0";
        else currBit = "1";
        for(int run : runs){
            int lowpow = (int) (Math.log(run) / Math.log(2)); //lowpow of 3 = 1 since 2^1 <= 3 but 2^2 > 3
            for (int i = 0; i < lowpow+1; i++) {
                start += currBit;
            }
            if(currBit.equals("1")) currBit = "0";
            else currBit = "1";

            end = bin( (int) (run - Math.pow(2, lowpow)), lowpow) + end;
        }
        return start + end;
    }
    public static String bin(int i, int len){
        String ret = "";
        while(i != 0){
            if(i % 2 == 0) ret = "0" + ret;
            else ret = "1" + ret;
            i /= 2;
        }
        //we dont want to make "" into "0" for this one
        int lendif = len - ret.length(); //**will do bad stuff if len < ret.length()
        for (int j = 0; j < lendif; j++) {
            ret = "0" + ret;
        }
        return ret;
    }
}
