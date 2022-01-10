package com.company;

import java.util.*;

public class BitstringCompressor {
    LinkedHashSet<String> alphabet = new LinkedHashSet<>();
    String bitstring; int chunkLength;
    HashMap<String, Integer> alphabetIDs = new HashMap<>(); int currID=0;
    TreeMap<Integer, String> IDsInverse = new TreeMap<>();
    public BitstringCompressor(String bitstring, int chunkLength){
        this.bitstring=bitstring; this.chunkLength=chunkLength;
    }

    private void makeAlphabet(int length, String currStr){
        //want binary strings from 0 to 2^length-1
        if(length==0){
            alphabet.add(currStr);
            alphabetIDs.put(currStr, currID);
            IDsInverse.put(currID, currStr);
            currID++;
        }
        else{
            makeAlphabet(length-1, currStr+"0");
            makeAlphabet(length-1, currStr+"1");
        }
    }

    public String compressedBitstring(){
        System.out.println(); System.out.println();
        String res = "";
        int numChunks = bitstring.length() / chunkLength;
        String ext = bitstring.substring( bitstring.length() - (bitstring.length()%chunkLength), bitstring.length() );
        String toCompress = bitstring.substring(0, numChunks*chunkLength);

        makeAlphabet(chunkLength, "");

        HashMap<String, Integer> counts = new HashMap<>(); //wont have everything
        for (int i = 0; i < numChunks; i++) {
            String currChunk = toCompress.substring(chunkLength * i, chunkLength * (i+1));
            if(!counts.containsKey(currChunk)) counts.put(currChunk, 0);
            counts.put(currChunk, counts.get(currChunk)+1);
        }

        PriorityQueue<treenode2> queue = new PriorityQueue<>();
        for(String s : alphabet){
            if(!counts.containsKey(s)) continue;
            HashSet<String> symbolSet = new HashSet<>(); symbolSet.add(s);
            queue.add(new treenode2(symbolSet, counts));
        }

        //make binary tree structure, assuming at least 2 nodes
        while(queue.size() > 1){
            treenode2 smallestSumSubtree = queue.poll(); treenode2 secondSmallestSumSubtree = queue.poll();

            HashSet<String> mergedSymbolSet = new HashSet<>();

            Iterator it = smallestSumSubtree.symbolSet.iterator();
            while(it.hasNext()) mergedSymbolSet.add(  (String) it.next()  );

            it = secondSmallestSumSubtree.symbolSet.iterator();
            while(it.hasNext()) mergedSymbolSet.add(  (String) it.next()  );

            treenode2 newSubtree = new treenode2(smallestSumSubtree, secondSmallestSumSubtree, mergedSymbolSet, counts);
            queue.add(newSubtree);
        }
        treenode2 root = queue.poll();
        HashMap<String, String> encoding = new HashMap<>();
        for(String s : alphabet){
            if(!counts.containsKey(s)) continue;
            encoding.put(s, root.getBinaryString(s));
        }

        String mainCompressed="";
        for (int i = 0; i < numChunks; i++) {
            String currChunk = toCompress.substring(chunkLength * i, chunkLength * (i+1));
            mainCompressed += encoding.get(currChunk);
        }
        String treeStructure = root.inOrderStructure();
        String labelPermutation = "";
        ArrayList<String> orderOfNodes = root.NodeOrder();
        int[] perm = new int[orderOfNodes.size()]; //size == 2^chunklength

        int ind=0;
        for(String node : orderOfNodes){
            perm[ind] = alphabetIDs.get(node);
            ind++;
        }

        String permBitstring = "";
        for (int i = 0; i < Math.pow(2, chunkLength) * chunkLength; i++) {
            permBitstring += "0";
        }

        String subset = "";
        for (int i = 0; i < Math.pow(2, chunkLength); i++) {
            if(counts.containsKey( bin(i, chunkLength) )) subset += "1";
            else subset += "0";
        }
        if(subset.contains("0")) System.out.println("alphabet for 2nd huff not full");
        subset = new EliasGammaRunLengthCompressor(subset).giveCompressed();
        System.out.println("chunklength = " + chunkLength + " so initial subset is of length " + (int)Math.pow(2, chunkLength) + ", compressed bitstring huffman: " + mainCompressed.length() + ", subset of length " + subset.length() + ", subset: " + subset);
        return subset + mainCompressed + ext;
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
