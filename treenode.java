package com.company; import java.util.*;
//these are not really treenodes, but more represntational nodes of a subtree
//could consider making freqs probabilities instead, but...

public class treenode implements Comparable<treenode>{
    public treenode left; public treenode right; //treenode usual characteristics
    public int subTreeSumFreqs; public TreeSet<Character> symbolSet;  //describing info about subtree
    public HashMap<Character, Integer> counts;
    public HashMap<Character, String> encoding;

    public treenode(treenode left, treenode right, TreeSet<Character> symbolSet, HashMap<Character, Integer> counts){
        this.left=left; this.right=right; this.symbolSet=symbolSet; this.counts=counts;
        Iterator it = this.symbolSet.iterator(); int runningSumFreq=0;
        while(it.hasNext()){
            runningSumFreq += counts.get((Character) it.next()); //we need the character's frequency so pass in counts
        }
        this.subTreeSumFreqs = runningSumFreq;
    }
    public treenode(TreeSet<Character> symbolSet, HashMap<Character, Integer> counts){
        this.symbolSet=symbolSet; this.counts=counts;
        Iterator it = this.symbolSet.iterator(); int runningSumFreq=0;
        while(it.hasNext()){
            runningSumFreq += counts.get((Character) it.next());
        }
        this.subTreeSumFreqs = runningSumFreq;
    }

    //helper methods
    public void print(){
        if(this.left != null) this.left.print();
        System.out.println(this.symbolSet.toString() + ", ");
        if(this.right != null) this.right.print();
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

    public String getBinaryString(Character targetChar){ //be careful when there is only 1 node in the entire tree, meaning only 1 char in alphabet
        return getBinaryString(targetChar, "");
    }
    private String getBinaryString(Character targetChar, String currBinaryString){
        //will return "" if character not present

        //check whether this is the character
        if(this.symbolSet.size() == 1 && this.symbolSet.contains(targetChar)){
            return currBinaryString;
        }

        //check whether no left and right meaning it is a leaf
        if(this.left==null && this.right==null){
            return "";
        }

        if(this.left == null){
            String s =  this.right.getBinaryString(targetChar, "1"+currBinaryString);
            return s;
        }
        else if(this.right == null){
            String s = this.left.getBinaryString(targetChar, "0"+currBinaryString);
            return s;
        }
        else{
            String s1 = this.left.getBinaryString(targetChar, currBinaryString+"0");
            String s2 = this.right.getBinaryString(targetChar, currBinaryString+"1");
            if(s1.equals("") && s2.equals("")){
                return "";
            }
            else if(s1.equals("")){
                return s2;
            }
            else if(s2.equals("")){
                return s1;
            }
            else{
                //this case does not happen, since both sides cannot have the character
            }
        }
        return ""; //should never get here
    }

    public String inOrderStructure(){
        return this.inOrderStructure("");
    }
    private String inOrderStructure(String res){
        if(this.left == null){
            res += "0";
        }
        else{
            res += this.left.inOrderStructure("");
        }
        res += "1";
        if(this.right == null){
            res += "0";
        }
        else{
            res += this.right.inOrderStructure("");
        }
        return res;
    }

    //sorting method
    @Override
    public int compareTo(treenode o) {
        return (subTreeSumFreqs - o.subTreeSumFreqs);
    }
}
