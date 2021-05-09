package com.exp.test;


/*
Input Format
The first line of the input consists of the virus composition, V
The second line of he input consists of the number of people, N
Next N lines each consist of the blood composition of the ith person, Bi

Constraints
1<= N <=10
1<= |B|<= |V|<= 10^5


Output Format
For each person, print POSITIVE or NEGATIVE in a separate line

Sample TestCase 1

Input
coronavirus
3
abcde
crnas
onarous
Output
NEGATIVE
POSITIVE
NEGATIVE

*/
import java.util.Scanner;
public class StringSequenceComparison {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
		String targetString = sc.nextLine();
		int numberOfInputStrings = sc.nextInt();
		sc.nextLine();
		String[] inputStrings = new String[numberOfInputStrings];
		for(int i=0;i<numberOfInputStrings;i++) {
			inputStrings[i] = sc.nextLine();
		}
        sc.close();
		String[] resultStrings = new String[numberOfInputStrings];
		resultStrings = checkSequence(numberOfInputStrings, targetString, inputStrings);
		for(int i=0;i<resultStrings.length;i++) {
			System.out.println(resultStrings[i]);
		}
   }

	private static String[] checkSequence(int numberOfInputStrings, String targetString, String[] inputString) {
        String[] resultStrings = new String[numberOfInputStrings];
        for(int temp=0;temp<numberOfInputStrings;temp++){
            if(targetString.contains(inputString[temp])) {
                resultStrings[temp]= "POSITIVE";
            }else if(targetString.length()< inputString[temp].length()){
                resultStrings[temp]= "NEGATIVE";
            }else{
                int i = 0,j=0;
                while(i<targetString.length() && j<inputString[temp].length()) {
                    if(targetString.charAt(i)==inputString[temp].charAt(j)) {
                        j=j+1;	
                    }else {
                        i=i+1;
                    }
                }
                if(j==inputString[temp].length()) {
                    resultStrings[temp]= "POSITIVE";
                }else{
                    resultStrings[temp]= "NEGATIVE";
                }
            }

            
        }
        return resultStrings;
	}
}
