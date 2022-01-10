package com.company;
import java.util.*;

public class treenode2 implements Comparable<treenode2>{
    public treenode2 left; public treenode2 right; //treenode usual characteristics
    public int subTreeSumFreqs; public HashSet<String> symbolSet;  //describing info about subtree
    public HashMap<String, Integer> counts;
    public HashMap<String, String> encoding;
    public ArrayList<String> nodeOrder = new ArrayList<>();

    public treenode2(treenode2 left, treenode2 right, HashSet<String> symbolSet, HashMap<String, Integer> counts){
        this.left=left; this.right=right; this.symbolSet=symbolSet; this.counts=counts;
        Iterator it = this.symbolSet.iterator(); int runningSumFreq=0;
        while(it.hasNext()){
            runningSumFreq += counts.get((String) it.next()); //we need the character's frequency so pass in counts
        }
        this.subTreeSumFreqs = runningSumFreq;
    }
    public treenode2(HashSet<String> symbolSet, HashMap<String, Integer> counts){
        this.symbolSet=symbolSet; this.counts=counts;
        Iterator it = this.symbolSet.iterator(); int runningSumFreq=0;
        while(it.hasNext()){
            runningSumFreq += counts.get((String) it.next());
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

    public String getBinaryString(String targetStr){ //be careful when there is only 1 node in the entire tree, meaning only 1 char in alphabet
        return getBinaryString(targetStr, "");
    }
    private String getBinaryString(String targetStr, String currBinaryString){
        if(this.symbolSet.size() == 1 && this.symbolSet.contains(targetStr)){
            return currBinaryString;
        }

        //check whether no left and right meaning it is a leaf
        if(this.left==null && this.right==null){
            return "";
        }

        if(this.left == null){
            String s =  this.right.getBinaryString(targetStr, "1"+currBinaryString);
            return s;
        }
        else if(this.right == null){
            String s = this.left.getBinaryString(targetStr, "0"+currBinaryString);
            return s;
        }
        else{
            String s1 = this.left.getBinaryString(targetStr, currBinaryString+"0");
            String s2 = this.right.getBinaryString(targetStr, currBinaryString+"1");
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
        String res = "";
        if(this.left == null){
            res += "0";
        }
        else{
            res += this.left.inOrderStructure();
        }
        res += "1";
        if(this.right == null){
            res += "0";
        }
        else{
            res += this.right.inOrderStructure();
        }
        return res;
    }

    public ArrayList<String> NodeOrder(){
        this.findNodeOrder();
        return this.nodeOrder;
    }
    private void findNodeOrder(){
        this.nodeOrder = new ArrayList<>();
        if(this.left == null && this.right==null){
            Iterator it = this.symbolSet.iterator();
            String symbol = (String) it.next();
            this.nodeOrder.add(symbol);
            return;
        }
        if(this.left != null){
            this.left.findNodeOrder();
            for(String s : this.left.nodeOrder){
                this.nodeOrder.add(s);
            }
        }
        if(this.right != null){
            this.right.findNodeOrder();
            this.nodeOrder.addAll(this.right.nodeOrder);
        }
    } //maybe works idk
    private ArrayList<String> findNodeOrder(ArrayList<String> currNodeOrder){

        if(this.left == null && this.right==null){
            //this has only 1 element in symbolset
            Iterator it = this.symbolSet.iterator();
            String symbol = (String) it.next();
            currNodeOrder.add(symbol);
            return currNodeOrder;
        }
        else {
            ArrayList<String> toReturn = new ArrayList<>();
            if(this.left != null){
                ArrayList<String> leftNodeOrder = this.left.findNodeOrder(new ArrayList<>());
                for(String s : leftNodeOrder) toReturn.add(s);
            }
            if(this.right != null){
                ArrayList<String> rightNodeOrder = this.left.findNodeOrder(new ArrayList<>());
                for(String s : rightNodeOrder) toReturn.add(s);
            }
            return toReturn;
        }
    } //does not work

    //sorting method
    @Override
    public int compareTo(treenode2 o) {
        return (subTreeSumFreqs - o.subTreeSumFreqs);
    }
}
