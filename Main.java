package com.company; import java.util.*; import java.io.*;

public class Main {
    static String file = "/Users/ishanpanpaliya/IdeaProjects/AlsoHuffmanEncoding/src/com/company/test.txt";
    static HashMap<Character, String> encoding;
    public static void main(String[] args) throws IOException{
        String s3 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Integer feugiat scelerisque varius morbi enim. Cras adipiscing enim eu turpis egestas pretium aenean. Ut tellus elementum sagittis vitae et leo duis. Et tortor consequat id porta";
        String s12 = "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.";
        String s = "There are many variations of passages of Lorem Ipsum available";
        String s111 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Consequat nisl vel pretium lectus quam. Elit at imperdiet dui accumsan. Elementum integer enim neque volutpat ac. Faucibus scelerisque eleifend donec pretium vulputate sapien nec. Varius duis at consectetur lorem. Sit amet consectetur adipiscing elit duis tristique sollicitudin nibh sit. Dictum non consectetur a erat. Urna porttitor rhoncus dolor purus non enim praesent elementum facilisis. Eu feugiat pretium nibh ipsum consequat nisl.\n" +
                "\n" +
                "Nam aliquam sem et tortor consequat id porta. Eros donec ac odio tempor orci dapibus. Ultricies integer quis auctor elit sed vulputate mi. Amet massa vitae tortor condimentum lacinia. Turpis massa tincidunt dui ut ornare lectus sit. Ut eu sem integer vitae justo. Neque sodales ut etiam sit amet nisl purus. Quam nulla porttitor massa id neque. Malesuada fames ac turpis egestas integer. Tincidunt nunc pulvinar sapien et. Sollicitudin tempor id eu nisl nunc mi. Nibh venenatis cras sed felis eget velit aliquet sagittis id. Tempus quam pellentesque nec nam aliquam sem. Consequat id porta nibh venenatis cras sed felis eget. Justo donec enim diam vulputate. Ultrices in iaculis nunc sed augue lacus viverra vitae. Nisl suscipit adipiscing bibendum est.\n" +
                "\n" +
                "Neque viverra justo nec ultrices dui sapien eget mi proin. Adipiscing commodo elit at imperdiet dui accumsan sit amet. Aliquam sem fringilla ut morbi tincidunt augue. Cras fermentum odio eu feugiat pretium nibh ipsum consequat nisl. Bibendum neque egestas congue quisque egestas. Sit amet risus nullam eget felis eget nunc. Neque ornare aenean euismod elementum nisi quis eleifend. Egestas diam in arcu cursus euismod quis viverra nibh cras. Phasellus vestibulum lorem sed risus. Elementum sagittis vitae et leo duis ut diam.\n" +
                "\n" +
                "Mattis rhoncus urna neque viverra justo nec. Etiam non quam lacus suspendisse faucibus interdum posuere lorem. Laoreet suspendisse interdum consectetur libero. Amet tellus cras adipiscing enim. Nibh mauris cursus mattis molestie a. Amet massa vitae tortor condimentum lacinia quis vel eros. Mattis rhoncus urna neque viverra justo nec ultrices dui sapien. Donec adipiscing tristique risus nec feugiat in fermentum. Suscipit adipiscing bibendum est ultricies integer. Egestas diam in arcu cursus euismod quis viverra nibh. Libero enim sed faucibus turpis in eu mi. In pellentesque massa placerat duis ultricies lacus. Dictumst quisque sagittis purus sit.\n" +
                "\n" +
                "Sed risus pretium quam vulputate dignissim. Pellentesque id nibh tortor id aliquet lectus. Purus in mollis nunc sed id semper. Iaculis eu non diam phasellus vestibulum lorem. Quis varius quam quisque id diam. Enim nunc faucibus a pellentesque sit amet porttitor eget. Facilisis magna etiam tempor orci eu lobortis elementum nibh. Habitant morbi tristique senectus et netus et malesuada. Vitae purus faucibus ornare suspendisse sed nisi. Commodo sed egestas egestas fringilla phasellus. At augue eget arcu dictum varius duis. Nulla facilisi nullam vehicula ipsum a arcu cursus vitae congue. Elit pellentesque habitant morbi tristique senectus. Eu non diam phasellus vestibulum lorem sed risus. Sit amet luctus venenatis lectus magna.\n" +
                "\n" +
                "Phasellus egestas tellus rutrum tellus pellentesque eu tincidunt. Quisque egestas diam in arcu cursus. Vulputate dignissim suspendisse in est ante in. Neque ornare aenean euismod elementum nisi. Feugiat vivamus at augue eget arcu dictum varius duis at. Id donec ultrices tincidunt arcu. Maecenas pharetra convallis posuere morbi leo urna molestie. Dignissim convallis aenean et tortor at risus viverra. Cras fermentum odio eu feugiat pretium. Suspendisse potenti nullam ac tortor. Et odio pellentesque diam volutpat commodo sed egestas egestas fringilla. Lacus sed viverra tellus in hac. Non tellus orci ac auctor augue mauris. Ullamcorper eget nulla facilisi etiam dignissim. Vulputate eu scelerisque felis imperdiet proin fermentum leo.\n" +
                "\n" +
                "Ultrices dui sapien eget mi. Tristique et egestas quis ipsum. Nulla pellentesque dignissim enim sit amet. Scelerisque in dictum non consectetur a erat nam. Fermentum et sollicitudin ac orci phasellus. Vivamus at augue eget arcu dictum. Id volutpat lacus laoreet non. Sagittis vitae et leo duis. Duis at tellus at urna condimentum mattis pellentesque. Porttitor eget dolor morbi non arcu risus quis varius. Etiam sit amet nisl purus in mollis nunc sed. Vel eros donec ac odio. Diam quis enim lobortis scelerisque fermentum dui faucibus in ornare.\n" +
                "\n" +
                "Ultricies integer quis auctor elit sed vulputate mi. Nunc mi ipsum faucibus vitae aliquet nec ullamcorper sit. Eu augue ut lectus arcu bibendum at varius. Cursus turpis massa tincidunt dui ut ornare lectus sit. Diam donec adipiscing tristique risus nec feugiat in fermentum posuere. Ac turpis egestas integer eget aliquet nibh praesent tristique magna. Dolor sed viverra ipsum nunc. Id porta nibh venenatis cras sed felis. Ante metus dictum at tempor. At lectus urna duis convallis convallis tellus id interdum velit. Fermentum dui faucibus in ornare quam viverra orci sagittis. Amet dictum sit amet justo donec. A arcu cursus vitae congue mauris rhoncus aenean. Tincidunt augue interdum velit euismod in pellentesque massa placerat duis. Quam id leo in vitae turpis massa sed elementum tempus. Diam vulputate ut pharetra sit amet aliquam. Tristique senectus et netus et malesuada fames ac turpis egestas. Mattis ullamcorper velit sed ullamcorper morbi tincidunt.\n" +
                "\n" +
                "Aliquet eget sit amet tellus. Cras sed felis eget velit aliquet sagittis id consectetur purus. Vestibulum lorem sed risus ultricies tristique nulla aliquet enim. Vitae turpis massa sed elementum tempus egestas sed sed. Cras fermentum odio eu feugiat pretium nibh ipsum consequat. Sollicitudin aliquam ultrices sagittis orci a scelerisque purus semper. Commodo elit at imperdiet dui accumsan sit. Ultrices gravida dictum fusce ut placerat orci nulla. Ultrices neque ornare aenean euismod elementum nisi. Faucibus pulvinar elementum integer enim neque volutpat ac tincidunt vitae. Tincidunt eget nullam non nisi est sit amet. Volutpat ac tincidunt vitae semper quis lectus nulla. Leo urna molestie at elementum eu.\n" +
                "\n" +
                "Sapien eget mi proin sed libero enim sed faucibus turpis. Scelerisque fermentum dui faucibus in ornare quam viverra orci sagittis. Vivamus at augue eget arcu dictum varius. Donec enim diam vulputate ut pharetra sit. Sed tempus urna et pharetra pharetra massa massa. Sit amet cursus sit amet dictum sit amet justo. Id interdum velit laoreet id donec. Eget felis eget nunc lobortis mattis aliquam faucibus purus in. Gravida cum sociis natoque penatibus et magnis dis parturient montes. Commodo ullamcorper a lacus vestibulum sed arcu non. Dictum fusce ut placerat orci nulla pellentesque dignissim enim sit. Vitae auctor eu augue ut lectus arcu. Mattis aliquam faucibus purus in massa tempor. Turpis tincidunt id aliquet risus. Ut pharetra sit amet aliquam id diam maecenas. Et tortor consequat id porta nibh. Platea dictumst vestibulum rhoncus est pellentesque elit. Volutpat commodo sed egestas egestas. Diam sollicitudin tempor id eu nisl nunc mi. Aliquet lectus proin nibh nisl condimentum id.\n" +
                "\n" +
                "Molestie at elementum eu facilisis. Dictum non consectetur a erat nam. Tristique senectus et netus et malesuada fames ac turpis egestas. Vitae tortor condimentum lacinia quis vel eros. Feugiat nisl pretium fusce id velit. Convallis aenean et tortor at risus viverra adipiscing. Viverra mauris in aliquam sem fringilla ut morbi tincidunt augue. Mi sit amet mauris commodo quis imperdiet massa tincidunt nunc. Gravida arcu ac tortor dignissim convallis aenean et tortor at. Molestie a iaculis at erat pellentesque adipiscing commodo elit at. Duis ut diam quam nulla porttitor massa. Parturient montes nascetur ridiculus mus mauris vitae ultricies leo integer. Sagittis id consectetur purus ut faucibus. Purus faucibus ornare suspendisse sed nisi lacus sed viverra tellus. Cursus eget nunc scelerisque viverra mauris in. Eleifend quam adipiscing vitae proin sagittis. Massa enim nec dui nunc mattis enim ut tellus. Lectus mauris ultrices eros in cursus turpis massa.\n" +
                "\n" +
                "Ante in nibh mauris cursus. Integer malesuada nunc vel risus commodo viverra. Convallis a cras semper auctor neque vitae tempus quam. Sapien nec sagittis aliquam malesuada bibendum arcu vitae. Imperdiet massa tincidunt nunc pulvinar sapien. In fermentum posuere urna nec. Pellentesque massa placerat duis ultricies lacus sed turpis tincidunt id. Risus ultricies tristique nulla aliquet enim. Lacus vestibulum sed arcu non odio euismod. Suspendisse faucibus interdum posuere lorem ipsum dolor sit amet. Quisque egestas diam in arcu cursus euismod quis viverra. Et netus et malesuada fames ac turpis egestas. Mauris sit amet massa vitae tortor. Enim nulla aliquet porttitor lacus luctus accumsan tortor posuere ac. Donec pretium vulputate sapien nec sagittis aliquam malesuada bibendum. Scelerisque fermentum dui faucibus in ornare quam.\n" +
                "\n" +
                "Hac habitasse platea dictumst quisque sagittis purus sit amet. Felis eget velit aliquet sagittis id. Nunc scelerisque viverra mauris in aliquam sem fringilla ut. Nam aliquam sem et tortor consequat id porta nibh venenatis. Amet nisl purus in mollis. Neque sodales ut etiam sit amet. Vitae proin sagittis nisl rhoncus mattis rhoncus urna. Aliquam ut porttitor leo a diam sollicitudin tempor id eu. Justo laoreet sit amet cursus sit. Auctor elit sed vulputate mi sit amet. Aliquam eleifend mi in nulla. Massa enim nec dui nunc mattis enim ut tellus elementum. Velit aliquet sagittis id consectetur purus ut faucibus. Vulputate ut pharetra sit amet aliquam id diam. Venenatis tellus in metus vulputate eu scelerisque felis imperdiet proin. Vivamus arcu felis bibendum ut tristique et egestas. Odio tempor orci dapibus ultrices. Id semper risus in hendrerit gravida. Eget sit amet tellus cras adipiscing enim.\n" +
                "\n" +
                "Pellentesque elit ullamcorper dignissim cras. Sapien nec sagittis aliquam malesuada bibendum arcu vitae elementum. Sed tempus urna et pharetra pharetra massa massa ultricies mi. Nisi est sit amet facilisis magna etiam tempor orci. Iaculis eu non diam phasellus vestibulum lorem. Arcu felis bibendum ut tristique et egestas quis. Metus vulputate eu scelerisque felis imperdiet proin. Tempor orci eu lobortis elementum nibh tellus. Tortor aliquam nulla facilisi cras fermentum odio eu feugiat. Pellentesque id nibh tortor id aliquet lectus proin nibh nisl. Arcu odio ut sem nulla pharetra diam sit amet nisl.\n" +
                "\n" +
                "Habitasse platea dictumst vestibulum rhoncus est pellentesque. Facilisis leo vel fringilla est. Gravida arcu ac tortor dignissim convallis aenean. Massa id neque aliquam vestibulum morbi blandit cursus risus at. Ipsum faucibus vitae aliquet nec ullamcorper. Mauris in aliquam sem fringilla. Faucibus purus in massa tempor. Sed felis eget velit aliquet sagittis id consectetur. Ac tortor dignissim convallis aenean et tortor at risus. Non blandit massa enim nec dui nunc mattis. Viverra justo nec ultrices dui sapien.";
        System.out.println("original length: " + s.length());

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
        System.out.println("compressed character huffman main with size " + compressed.length());
        System.out.println("converted to ASCii representation: " + new ASCiiConverter(compressed).convert());

        int normalEncodingBlockLen = (int) (Math.ceil(Math.log(alphabet.size())/Math.log(2)));
        System.out.println( "regular variable block encoding: " + normalEncodingBlockLen * s.length()  );
        System.out.println( "regular ASCII encoding length: " + 8 * s.length()  );



        System.out.println( new EliasGammaRunLengthCompressor(compressed).giveCompressed().length() );
        //decoding code
//        HashMap<String, Character> decoding = new HashMap<>();
//        for(char c : encoding.keySet()) decoding.put(encoding.get(c), c);
//
//        String uncompressed=""; int startInd=0;
//        for (int i = 0; i < compressed.length(); i++) {
//            if(  decoding.containsKey(compressed.substring(startInd, i+1))  ){
//                uncompressed += decoding.get(compressed.substring(startInd, i+1)); startInd=i+1;
//            }
//        }
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
//create new mychar class, implements comparable based on freq
class mychar implements Comparable<mychar>{
    int freq; char c;
    public mychar(char c, int freq){
        this.c=c; this.freq=freq;
    }
    @Override
    public int compareTo(mychar o) {
        return o.freq - freq;
    }
}

//variable-length converison code


//    int normalEncodingBlockLen = (int) (Math.ceil(Math.log(alphabet.size())/Math.log(2)));
//        String runToCompress = "";
//        HashMap<Character, Integer> ID = new HashMap<>(); int maxID=0;
//        for (char c : counts.keySet()) {
//            ID.put(c, maxID); maxID++;
//        }
//        System.out.println("ID: " + ID.toString());
//        for (int i = 0; i < s.length(); i++) {
////            System.out.println(i);
//            char curr = s.charAt(i);
//            System.out.println("ID of " + curr + ": " + ID.get(curr) + ", binary: " + bin(ID.get(curr), normalEncodingBlockLen));
//            runToCompress += bin(ID.get(curr), normalEncodingBlockLen);
//        }
//        System.out.println("runtocompress is made: " + runToCompress);
//        runLengthCompressor runmuncher = new runLengthCompressor(runToCompress);
//        String runcompressed = runmuncher.giveCompressed();
//        System.out.println("RLE on chars: " + runcompressed.length());









//subtree class, holds symbolset (leaves), sum of encodings of symbols, overall root


//class subtree implements Comparable<subtree>{
//    public treenode root;
//
//    public subtree(TreeSet<Character> symbols, HashMap<Character, String> encoding){ //only used at start when size of set=1
//        this.
//    }
//    public subtree(subtree p1, subtree p2, HashMap<Character, String> encoding){
//        this.symbols = new TreeSet<>();
//
//        Iterator it = p1.symbols.iterator();
//        while(it.hasNext()){
//            Character next = (Character) it.next();
//            this.symbols.add(next);
//        }
//        it = p2.symbols.iterator();
//        while(it.hasNext()){
//            Character next = (Character) it.next();
//            this.symbols.add(next);
//        }
//        this.sum = p1.sum + p2.sum;
//    }
//
//
//    public static int dec(String binary){
//        int ret = 0; int pow = 0;
//        for (int i = binary.length()-1; i >= 0; i--) {
//            if(binary.charAt(i) == '1')
//                ret += (int) (Math.pow(2, pow));
//            pow++;
//        }
//        return ret;
//    }
//    @Override
//    public int compareTo(subtree o) {
//        return -(sum - o.sum);
//    }
//}



//class subtree implements Comparable<subtree>{
//    public TreeSet<Character> symbols; public int sum; public HashMap<Character, String> encoding; public treenode root;
//
//    public subtree(TreeSet<Character> symbols, HashMap<Character, String> encoding){ //only used at start when size of set=1
//        this.symbols = symbols; this.encoding = encoding;
//        Iterator it = this.symbols.iterator();
//        int runningSum=0;
//        while(it.hasNext()){
//            Character next = (Character) it.next();
//            runningSum += dec(this.encoding.get(next));
//        }
//        this.sum = runningSum;
//        this.root = new treenode(runningSum); //does the treenode need to have the symbolset as well
//    }
//    public subtree(subtree p1, subtree p2, HashMap<Character, String> encoding){
//        this.symbols = new TreeSet<>();
//
//        Iterator it = p1.symbols.iterator();
//        while(it.hasNext()){
//            Character next = (Character) it.next();
//            this.symbols.add(next);
//        }
//        it = p2.symbols.iterator();
//        while(it.hasNext()){
//            Character next = (Character) it.next();
//            this.symbols.add(next);
//        }
//        this.sum = p1.sum + p2.sum;
//    }
//
//
//    public static int dec(String binary){
//        int ret = 0; int pow = 0;
//        for (int i = binary.length()-1; i >= 0; i--) {
//            if(binary.charAt(i) == '1')
//                ret += (int) (Math.pow(2, pow));
//            pow++;
//        }
//        return ret;
//    }
//    @Override
//    public int compareTo(subtree o) {
//        return -(sum - o.sum);
//    }
//}












//    HashMap<Character, String> encoding = new HashMap<>();
//    int currcode = 0; int len = 1;
//        for (char c : id.keySet()) {
//                System.out.println("char: " + c);
//                if(currcode == 0){
//                System.out.println("Since currcode == 0 and len = " + len + ", the code is " + bin(0, len));
//                encoding.put(c, bin(0, len)); //did this because I dont know how log function will handle 0
//                }
//                else{
//                System.out.println("code is not 0 ");
//                int log2ceil = (int) Math.ceil(Math.log(currcode)/Math.log(2));
//                if( ( (int) Math.pow(2,log2ceil) - currcode == 1) && currcode != 1 ){
//                len++; currcode = 0;
//                System.out.println(" code is  2^n-1, so code becomes 0 with len " + len);
//                }
//                System.out.println("code is " + bin(currcode, len));
//                String codestr = bin(currcode, len);
//                encoding.put(c, codestr);
//                }
//                currcode++;
//                System.out.println("code incerments to " + currcode);
//                System.out.println();
//                }
//        String uncompressed = "";
//        while(compressed.length() > 0){
//            String encodingForNextChar = "";
//            System.out.println("compressed: " + compressed);
//            for (int i = 1; i <= compressed.length() - delim.length(); i++) { //start at 0/1 no matter
//                System.out.println("i: " + i);
//                String maybeDelim = compressed.substring(i, i + delim.length());
//                System.out.println("maybe delim: " + maybeDelim);
//                if(maybeDelim.equals(delim)){
//                    System.out.println("equals to delim");
//
//                    if( i == compressed.length() - delim.length() ){
//                        encodingForNextChar = compressed.substring(0, i + delim.length());
//                        compressed = compressed.substring(i + delim.length(), compressed.length());
//                        System.out.println("at the end so encoding is " + encodingForNextChar);
//                        break;
//                    }
//
//                    else if(compressed.charAt(i + delim.length()) =='1'){
//                        System.out.println("still more 1s so continue");
//                        continue;
//                    }
//
//                    else{
//                        encodingForNextChar = compressed.substring(0, i + delim.length());
//                        compressed = compressed.substring(i + delim.length(), compressed.length());
//                        System.out.println("at the end so encoding is " + encodingForNextChar);
//                        break;
//                    }
//                }
//            }
//            System.out.println("encoding: " + encodingForNextChar);
//            uncompressed += decoding.get(encodingForNextChar);
//        }
//        String currSegTillDelim;
//        int lastIndOfSeg = 0; int frontOfWind = 0;
//        for (int i = 0; i <= compressed.length() - delim.length(); i++) {
//            String active = compressed.substring(i, i + delim.length());
//            if(i == compressed.length() - delim.length()) currSegTillDelim = compressed.substring()
//        }



//make pair classes of each <{symbol set}, sum of symbol IDs> pair, implements comparable
//class pair implements Comparable<pair>{
//    public TreeSet<Character> symbols; public int sum; public HashMap<Character, String> encoding;
//
//    public pair(TreeSet<Character> symbols, HashMap<Character, String> encoding){
//        this.symbols = symbols; this.encoding = encoding;
//        Iterator it = this.symbols.iterator();
//        int runningSum=0;
//        while(it.hasNext()){
//            Character next = (Character) it.next();
//            runningSum += dec(this.encoding.get(next));
//        }
//        this.sum = runningSum;
//    }
//    public pair(pair p1, pair p2, HashMap<Character, String> encoding){
//        this.symbols = new TreeSet<>();
//
//        Iterator it = p1.symbols.iterator();
//        while(it.hasNext()){
//            Character next = (Character) it.next();
//            this.symbols.add(next);
//        }
//        it = p2.symbols.iterator();
//        while(it.hasNext()){
//            Character next = (Character) it.next();
//            this.symbols.add(next);
//        }
//        this.sum = p1.sum + p2.sum;
//    }
//
//
//    public static int dec(String binary){
//        int ret = 0; int pow = 0;
//        for (int i = binary.length()-1; i >= 0; i--) {
//            if(binary.charAt(i) == '1')
//                ret += (int) (Math.pow(2, pow));
//            pow++;
//        }
//        return ret;
//    }
//    @Override
//    public int compareTo(pair o) {
//        return -(sum - o.sum);
//    }
//}

