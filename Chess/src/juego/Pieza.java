package src.juego;
import java.util.*;

public abstract class Pieza extends Tablero{
	
	/**
	 * Clase protegida que almacenará los datos del mejores posibles
	 * movimientos de una pieza en base a la suma generada de casillas
	 * en dominación así como por las posibles piezas atacada mas la
	 * diferencia de puntos por piezas en riesgo de perder
	 */
	public class Datos {
		int x;
		int y;
		int suma;
		
		public Datos(int x, int y, int suma) {
			this.x = x;
			this.y = y;
			this.suma = suma;
		}
	}

	/**
	 * Clase utiizada para la lista de posibles movimientos de una pieza.
	 */
	public class Tupla {
		int x;
		int y;
		
		public Tupla(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public boolean casillaOcupada(int x, int y) {
		System.out.println(x + " " +y);
		if (super.tablero[x][y]) {
			return true;
		}
		return false;
	}

	public abstract boolean contiene(int renglon , char columna);

	//public abstract int getSumaDominacion(int renglon, int columna);

	public abstract void esValida(int renglon, char columna);

	public abstract LinkedList<Tupla> posiblesMovimientos(int renglon, char columna);
 
}