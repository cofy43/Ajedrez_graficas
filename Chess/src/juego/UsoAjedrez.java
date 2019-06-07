package src.juego;

import java.util.*;

public class UsoAjedrez{
	private Scanner scanner;
	public UsoAjedrez(){
		scanner = new Scanner(System.in);
	}
	
	private int leerOpcion(String mensaje){
		System.out.println(mensaje);
		boolean error = false;
		int num = -1;
		try {
			num = scanner.nextInt();
		} catch (NullPointerException nfe){
			error = true;
			System.out.println("Por favor ingrese un valor valido");
		}
		if (error){
			num = leerOpcion(mensaje);
		}
		return num;
	}

	private char leerOpcionChar(String mensaje){
		System.out.println(mensaje);
		boolean error = false;
		char option =' ';
		try {
			option = scanner.next().charAt(0); 
			
		} catch (Exception nfe){
			error = true;
			System.out.println("Por favor ingrese un valor valido");
		}
		if (error){
			option = leerOpcionChar(mensaje);
		}
		return option;
	}

	private void imprimeMenu(){
		System.out.println("Posibles piezas");
		System.out.println("1) Caballo  ♞ ");
		System.out.println("2) Rey  ♚");
		System.out.println("3) Reyna  ♛");
		System.out.println("4) Salir");
	}

	private void menuPieza() {
		System.out.println("1) Validar posiciones");
		System.out.println("2) lista de posiciones");
		System.out.println("3) Sali");
	}
	
	public void run(){
	}
	
	public static void main(String[] args) {
		UsoAjedrez in = new UsoAjedrez();
		in.run();
		System.out.println("***Este es un programa que dada una***");
		System.out.println("*****pieza te indica los posibles ***");
		System.out.println("************movinientos**************");
		boolean con = true;
		int renglon;
		char columna;
		int opc;
		boolean esValida;
		while (con){
			in.imprimeMenu();
			int op = in.leerOpcion("Selecciona una opcion");
			switch (op){
				case 1 :
					in.menuPieza();	
					opc = in.leerOpcion("Selecciona una opcion");
					switch (opc){
						case 1:
							columna = in.leerOpcionChar("Selecciona una columna [a-h]");
							renglon = in.leerOpcion("Selecciona un renglon [1-8]");
							System.out.print("La posicion de la pieza ");
							System.out.println(" es valida");
							break;
						case 2:
							break;
						case 3:
							System.out.println("Regresando al menu anterior");
							break;
						default:
							System.out.println("opcion invalida");
							break;
					}	
					break;
				case 2 :
					in.menuPieza();	
					opc = in.leerOpcion("Selecciona una opcion");
					switch (opc){
						case 1:
							columna = in.leerOpcionChar("Selecciona una columna [a-h]");
							renglon = in.leerOpcion("Selecciona un renglon [1-8]");
							System.out.print("La posicion de la pieza ");
							System.out.println(" es valida");
							break;
						case 2:
							break;
						case 3:
							System.out.println("Regresando al menu anterior");
							break;
						default:
							System.out.println("opcion invalida");
							break;
					}	
					break;
				case 3 :
					in.menuPieza();	
					opc = in.leerOpcion("Selecciona una opcion");
					switch (opc){
						case 1:
							columna = in.leerOpcionChar("Selecciona una columna [a-h]");
							renglon = in.leerOpcion("Selecciona un renglon [1-8]");
							System.out.print("La posicion de la pieza ");
							System.out.println(" es valida");
							break;
						case 2:
							break;
						case 3:
							System.out.println("Regresando al menu anterior");
							break;
						default:
							System.out.println("opcion invalida");
							break;
					}	
					break;
				case 4:
					con = false;
					break;
				default:
					System.out.println("Opcion invalida");
			}
		}
	}
}