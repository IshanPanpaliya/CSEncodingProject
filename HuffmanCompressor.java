package com.company; import java.util.*; import java.io.*;

public class HuffmanCompressor {
    HashMap<Character, String> encoding; String s;
    HashMap<Character, Integer> probabilities = new HashMap<>();
    public HuffmanCompressor(String bitstring){
        this.s=bitstring;
    }
    public void compress(){
        //frequency table
        HashMap<Character, Integer> counts = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if(!counts.containsKey(curr)){
                counts.put(curr, 0);
            }
            counts.put(curr, counts.get(curr)+1);
        }

        //make alphabet
        TreeSet<Character> alphabet = new TreeSet<>();
        for(char c : counts.keySet()) alphabet.add(c);

        //make class of chars to sort them by frequency to then assign id
        mychar[] mychars = new mychar[counts.size()];

        int ind = 0;
        for(char c : alphabet){
            mychars[ind] = new mychar(c, counts.get(c)); ind++;
        }
        Arrays.sort(mychars);

        //map char to num id based on counts (sorted)
        HashMap<Character, Integer> id = new HashMap<>();
        for (int i = 0; i < mychars.length; i++) id.put(mychars[i].c, i);

        //make binary tree + priority queue stuff
        PriorityQueue<treenode> queue = new PriorityQueue<>();
        for(char c : alphabet){
            TreeSet<Character> symbolSet = new TreeSet<>(); symbolSet.add(c);
            queue.add(new treenode(symbolSet, counts));
        }
        while(queue.size() > 1){
            treenode smallestSumSubtree = queue.poll(); treenode secondSmallestSumSubtree = queue.poll();

            TreeSet<Character> mergedSymbolSet = new TreeSet<>();

            Iterator it = smallestSumSubtree.symbolSet.iterator();
            while(it.hasNext()) mergedSymbolSet.add(  (Character) it.next()  );

            it = secondSmallestSumSubtree.symbolSet.iterator();
            while(it.hasNext()) mergedSymbolSet.add(  (Character) it.next()  );

            treenode newSubtree = new treenode(smallestSumSubtree, secondSmallestSumSubtree, mergedSymbolSet, counts);
            queue.add(newSubtree);
        }
        treenode root = queue.poll();

        //make encoding in binary of each character
        encoding = new HashMap<>();
        for(char c : alphabet) encoding.put(c, root.getBinaryString(c));

        String compressed = "";
        for (int i = 0; i < s.length(); i++) compressed += encoding.get(s.charAt(i));
        System.out.println("compressed character huffman main: " + "with size " + compressed.length());

        System.out.println("regular variable block encoding: " + (int) (Math.ceil(Math.log(alphabet.size())/Math.log(2)) * s.length())  );
        System.out.println("regular ASCII  encoding: " + 8 * s.length()  );

        int chunkLength = 4; //3278, 3314, 3394, 3529, 3897; main compressed: 3250, 3249, 3248, 3209, 3189, 3098, 4612
        BitstringCompressor muncher = new BitstringCompressor(compressed, chunkLength);
        String compressed2 = muncher.compressedBitstring();
        System.out.println("another huffman: " + compressed2.length());
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
}