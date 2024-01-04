package ProgramandoJava;

import java.util.Scanner;

public class EscribeNumero{
	
	public static void main(String[] args){
		
		int num; //guardamos en esta variable el número que se introduzca
		
		System.out.println("Escribe un número: ");//mensaje por consola
		Scanner sc = new Scanner(System.in);
	    
		num = sc.nextInt();//Entrada por consola
		
		System.out.println ("El valor introducido es: " + num);
		
		
	}
}