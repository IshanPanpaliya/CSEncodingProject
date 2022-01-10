package com.company;

public class tester {
    public static void main(String[] args) {
        String t = "10";
        String comp = new EliasGammaRunLengthCompressor(t).giveCompressed();
        System.out.println("compressed using Elias: " + comp);
        System.out.println("decoded: " + new EliasGammaRunLengthDecoder(comp).decode());
    }
}
//reasonable alphabet
//a-z (26), A-Z (26), 0-9 (10), -, –, :, ;, ', ,, ?, !, [, ], (, ), {, }, %, &, /, 26 + 26 + 10 + 17
//64 alphabet: a-z (26), A-Z (26), -, :, ;, ', ,, ?, !, [, ], (, ), /,

//
//
//
//
//