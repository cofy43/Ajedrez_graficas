package src.juego;

import java.util.*;

public class Posicion{
	
	static Tablero t = new Tablero();
	private int renglon;
	private char columna;
	private char pieza;
	
	public Posicion (){

	}

	private int coordenadaIncial(String inicial) {
		String number = String.valueOf(inicial.charAt(2));
		int coordenada = Integer.valueOf(number);
		return coordenada;
	}

	private char columna(String inicial) {
		String aux = inicial.toLowerCase();
		char pieza = aux.charAt(1);
		return pieza;
	}

	private static char getPieza(String jugada) {
		return jugada.charAt(0);
	}

	private static boolean esPieza(String inicial) {
		String aux = inicial.toLowerCase();
		char pieza = aux.charAt(0);
		switch(pieza) {
			//Alfil
			case 'a': 
				return true;
			//Caballo
			case 'c': 
				return true;
			//Torre
			case 't': 
				return true;
			//Rey
			case 'r': 
				return true;
			//Dama
			case 'd': 
				return true;
			//Peón
			case 'p': 
				return true;
			default: 
				return false;
		}
	}

	public static void main(String[] args) {
		Posicion p = new Posicion();
		Scanner sc = new Scanner(System.in);
		String movimineto = "";
		boolean continuar = true;

		//Verificación de validez del movimineto
		//Esto es, no salirse del tablero
		/* while (continuar) {

			movimineto = sc.nextLine();
			System.out.println(getPieza(movimineto));
			System.out.println(p.columna(movimineto));
			System.out.println(p.coordenadaIncial(movimineto));
	
			//La jugada no puede ser menor o mayor a tres caracteres
			//Siguiendo la notación Pieza (indicada con la inicial e.i. c = caballo),
			//Columna (indicada con letras de la a - h),
			//Fila (indicada con números del 1 al 8).
			while (movimineto.length() != 3) {
				System.out.println("Longitud invalida");
				System.out.println("Error, jugada invalida");
				movimineto = sc.nextLine();
			}

			//Verificación de que la Fila se encuentre dentro del tablero.
			while (p.coordenadaIncial(movimineto) < 1 ||
				p.coordenadaIncial(movimineto) > 8) {	
				System.out.println("Fila fuera del rango");
				System.out.println("Error, jugada invalida");
				movimineto = sc.nextLine();
			}

			//Verificación de que la Columna se encuentre dentro del tablero.
			while (((int)p.columna(movimineto)) < 97
			|| ((int)p.columna(movimineto)) > 104) {
				System.out.println("Columna fuera del rango");
				System.out.println("Error, jugada invalida");
				movimineto = sc.nextLine();
			}

			//Verificación que la pieza sea correcta.
			while (esPieza(movimineto) != true) {
				System.out.println("Pieza invalida");
				System.out.println("Error, jugada invalida");
				movimineto = sc.nextLine();
			}

			continuar = false;
		} */
		System.out.println(t.toString());
		System.out.println(t.muestaListas());
	}
}