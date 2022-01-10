package com.company; import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.util.*;

//Optimization 1 : could make it so that it encodes 2 run lengths in 1 chunk

//Optimization 2:
//could also not use a huge chunkLength(k) if there are a few rly big runs by making a reasonable k
// and then before the k-block put a bit signifiying if there is change or not
//To make this even better, stick all those change bits into 1 big (# runs ) length bitstring and then compress that
//will need to transmit k at the start in a standard x-bit string

public class runLengthCompressor {
    String bitstring; int blockLen;
    public runLengthCompressor(String bitstring){
        this.bitstring=bitstring;
    }

    public String giveCompressed(){
        String res = "";
        char target = bitstring.charAt(0);
        ArrayList<Integer> runs = new ArrayList<>(); int currRunLen = 1; int maxRun = 0;
        for (int i = 1; i <= bitstring.length(); i++) {
            if(i == bitstring.length()){
                runs.add(currRunLen);
                maxRun = Math.max(maxRun, currRunLen);
            }
            else{
                if(bitstring.charAt(i) == bitstring.charAt(i-1)){
                    currRunLen++;
                }
                else{
                    runs.add(currRunLen); //1,
                    maxRun = Math.max(maxRun, currRunLen); //1
                    currRunLen = 1;
                }
            }
        }
        System.out.println("maxrun: " + maxRun);

        blockLen = ceil(log(2, maxRun)); //be careful, if maxRun = blockLen = 2 but bits go from 0 to 3 so need to add 1
        System.out.println("block len: " + blockLen);
        if(blockLen == 0) blockLen = 1;
        for(int runLen : runs){
            res += bin(runLen-1, blockLen); //look at comment 2 above
        }
        String start = "0";
        if(bitstring.charAt(0) == '1') start = "1";

        return start + res;
    }
    public String bin(int i, int len){
        if(len == 0) return "";
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
