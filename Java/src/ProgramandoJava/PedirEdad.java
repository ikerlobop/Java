package ProgramandoJava;

import java.util.Scanner;

public class PedirEdad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int edad; //aquí guardamos la edad actual del usuario
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Escriba su edad: ");
		edad = sc.nextInt();
		edad = edad + 1;
		System.out.println("El año que viene su edad será de: " + edad + " años");
		

	}
}
