package com.practiceproblems;

import java.util.Scanner;



public class Practice_1 {
	public static void main(String[] args) {
	    Scanner xis = new Scanner(System.in);
	    System.out.println("Insira o deslocamento desejado.");
	    int d = xis.nextInt();
	    System.out.println("Digite a mensagem a ser enviada.");
	    String m = xis.nextLine();
	    for (int i = 0; i < m.length(); i++) 
	    {

	        int x = m.charAt(i) + d;
	        if(x > 'Z')
	        {
	            System.out.println((char)(x - 26));
	        }
	        System.out.println((char)x); 
	    }
	    xis.close();

	}
}
