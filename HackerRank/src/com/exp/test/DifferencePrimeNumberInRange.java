package com.exp.test;


//This code will find a difference of prime number in the provided range.
//Input
//Number of inputs
//number separted by space.
//input 
//2
//2 7
//3 5
//
//output
//
//5 (prime number: 2,3,5,7; diff :7-2=5)
//2 (prime number: 3 5; diff :5-3=2)
//
////Algorithm to calculate prime number
////
////Please note that there is no known efficient formula (mathematically proven) to determine a number is prime or not.
////
////Generally, we can determine a number is prime or not in below steps:
////
////2 is only prime number which is also even number. So, if given number N is 2 the it is PRIME number.
////If given number N is even number then it is NOT PRIME number.
////Find out square root on N. Traverse all odd numbers up to the sqrt(N) and try to devide the N with current odd number. If remainder is 0 for any odd number then number is NOT PRIME.
////Else – number is PRIME.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
public class DifferencePrimeNumberInRange {
    public static void main(String args[] ) throws Exception {
	
	    	Scanner sc = new Scanner(System.in);
	    	int noOfInputs = sc.nextInt();
	        String[] inputData = new String[noOfInputs];
	        sc.nextLine();
	        for(int i=0;i<noOfInputs;i++){
	            inputData[i]=sc.nextLine();
	        }
	        sc.close();
	        int[] diff = findDiff(inputData, noOfInputs);
	        for(int i=0;i<diff.length;i++) {
	        	System.out.println(diff[i]);
	        }

   }

		private static int[] findDiff(String[] inputData, int noOfInputs) {
			int[] result = new int[noOfInputs];
			for(int i=0;i<noOfInputs;i++) {
				String[] temp = inputData[i].split(" ");
				result[i] = findPrimeNumberDiff(temp[0], temp[1]);
			}
			return result;
		}
	
		private static int findPrimeNumberDiff(String start, String end) {
			int result = -1;;
			if(start.equals(end)) {
				return 0;
			}else {
				int startInt = Integer.parseInt(start);
				int endInt = Integer.parseInt(end);
				List<Integer> newList = new ArrayList<>();
				//logic 1
//				for(int i = startInt ; i <= endInt ; i++)
//				{
//					
//					//logic for checking number is prime or not
//					int count = 0;
//					for(int j = 1 ; j <= i ; j++)	
//					{
//						if(i % j == 0)
//							count = count+1;
//					}
//					if(count == 2) {
//						newList.add(i);
//					}
//					
//					
//				}
				
				for(int i = startInt ; i <= endInt ; i++)
				{
					int number = i;
					if(number == 2){
						newList.add(i);
					}else if( (number % 2) != 0
							&&
							IntStream.rangeClosed(3, (int) Math.sqrt(number))
							.filter(n -> n % 2 != 0)
							.noneMatch(n -> (number % n == 0))) {
						newList.add(i);
					}	
				}
				if(newList.size()==1) {
					result = 0;
				}else if(newList.size()>1) {
					result = newList.get(newList.size()-1)-newList.get(0);
				}
			}
	
			return result;
		}
}

