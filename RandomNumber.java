/*
Question 3 :
Generate 500 random numbers and create a method to print the nth smallest number in a programming language of your choice.  
*/

import java.util.Collections;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Random;
	import java.util.Scanner;
	public class RandomNumber {

	public static void main(String[] args) {
	// TODO Auto-generated method stub
	List<Integer> lList = new ArrayList<Integer>();
	System.out.println("Generating 500 random numbers between range 0 - 999");
	// create instance of Random class
	        Random rand = new Random();
	        for (int i = 0; i < 500; i++) {
	         lList.add(rand.nextInt(1000));
	        }
	        //Collections can be used to sort the elements in the list
	        //https://stackoverflow.com/questions/20518078/how-to-sort-listinteger
	        Collections.sort(lList); //ascending
	        for(int i=0; i<lList.size();i++ )
	        {
	            System.out.println(lList.get(i));
	        }
	        Scanner input = new Scanner(System. in);
	        System.out.println("Enter the nth smallest number needed");
	        int n = input.nextInt();
	        //we subtract 1 as the index starts from 0
	        System.out.println("Nth smallest number is " + lList.get(n-1).toString());
	        input.close();
	}

	}

