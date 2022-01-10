package com.company; import java.util.TreeMap;

public class NormalBinaryEncoder {
    String chars; TreeMap<Character, Integer> code = new TreeMap<>(); //opposite of ASCii converter
    public NormalBinaryEncoder(String chars){
        this.chars=chars;
        int ind = 0;
        for (int i = 32; i <= 126; i++) {
            code.put((char) i, ind);
            ind++;
        }
        code.put((char) 128, ind); ind++;
        for (int i = 161; i <= 320; i++) {
            code.put((char) i, ind);
            ind++;
        }
    }
    public String encode(){
        String ret="";
        for (int i = 0; i < chars.length(); i++) {
            char curr = chars.charAt(i);
            if(curr == '\n') curr = ' ';
            ret += bin( code.get(curr), 8 ) ;
        }
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
}
