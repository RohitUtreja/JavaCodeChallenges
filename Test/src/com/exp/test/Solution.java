package com.exp.test;

import java.util.Scanner;

public class Solution {


    static boolean isAnagram(String a, String b) {
        int length1 = a.length();
        int length2 = b.length();
        if(length1!=length2){
            return false;
        }
        char[] ch1 = new char[length1];
        char[] ch2 = new char[length2];
        for(int i=0;i<length1;i++){
            ch1[i]=Character.toLowerCase(a.charAt(i));
            ch2[i]=Character.toLowerCase(b.charAt(i));
        }
        
        java.util.Arrays.sort(ch1);
        java.util.Arrays.sort(ch2);
        
        for(int i=0;i<length1;i++){
            if(Character.toLowerCase(ch1[i])!=Character.toLowerCase(ch2[i])){
                return false;
            }
        }
        return true;
    }

  public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}

