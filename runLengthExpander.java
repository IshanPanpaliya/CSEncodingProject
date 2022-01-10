package com.company;

import java.util.ArrayList;

public class runLengthExpander {
    String bitstring; int dblocklen;
    public runLengthExpander(String bitstring, int dblocklen){this.bitstring=bitstring; this.dblocklen=dblocklen;}

    public String decode(){
        System.out.println("block len: " + dblocklen);
        String res = "";
        String curr = bitstring.substring(0,1);
        for (int i = 1; i < bitstring.length(); i+=dblocklen) {
            int times = dec(bitstring.substring(i, i+dblocklen))+1; //plus 1 for weird reasons look in comments in compressor
            for (int j = 0; j < times; j++) {
                res += curr;
            }
            if(curr.equals("0")) curr = "1";
            else curr = "0";
        }
        return res;
    }
    public static String bin(int i){
        String ret = "";
        while(i != 0){
            if(i % 2 == 0) ret = "0" + ret;
            else ret = "1" + ret;
            i /= 2;
        }
        if(ret.equals("")) ret = "0";
        return ret;
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
    public static int dec(String binary){
        int ret = 0; int pow = 0;
        for (int i = binary.length()-1; i >= 0; i--) {
            if(binary.charAt(i) == '1')
                ret += (int) (Math.pow(2, pow));
            pow++;
        }
        return ret;
    }
    public double log(int base, int x){
        return Math.log(x) / Math.log(base);
    }
    public int ceil(int x){
        return (int) Math.ceil(x);
    }
    public int ceil(double x){
        return (int) Math.ceil(x);
    }
}
