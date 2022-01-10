package com.company;

import java.util.TreeMap;

public class ASCiiConverter {
    String bitstring;
    public ASCiiConverter(String bitstring){
        int rem = bitstring.length() % 8;
        int paddingLen = 8 - rem;
        String padding = "";
        for (int i = 0; i < paddingLen; i++) {
            padding += "0";
        }
        this.bitstring= padding + bitstring;
    }
    public String convert(){
        String ret = "";

        TreeMap<Integer, Character> code = new TreeMap<>();
        int ind = 0;
        for (int i = 32; i <= 126; i++) {
            code.put(ind, (char) i);
            ind++;
        }
        code.put(ind, (char) 128); ind++;
        for (int i = 161; i <= 320; i++) {
            code.put(ind, (char) i);
            ind++;
        }
        for (int i = 0; i < bitstring.length()/8; i++) {
            String currChunk = bitstring.substring(8*i, 8*(i+1));
            int decCurrChunk = dec(currChunk);
            ret += code.get(decCurrChunk);
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
