package src.juego;
import java.util.LinkedList;

public class Caballo  extends Pieza{

	Caballo (int renglon, char columna) {
		esValida(renglon, columna);
	}

	LinkedList<Tupla> posiblesMovimiento = new LinkedList<>();
	LinkedList<Datos> mejoresMovimiento = new LinkedList<>();

	@Override
	public void esValida ( int x, char y){
		int renglon = x;
		int columna = (int)y;

		if (renglon<=0 || renglon>=9) return;
		if ((int)columna<= 96 || (int)columna>= 105) return;

		if (renglon + 2 < 8) {
			if (columna + 1 < 105 && !super.casillaOcupada(renglon+2, (columna+1)-97)) {
				posiblesMovimiento.add(new Tupla(renglon +2 , columna+1));
			}
			if (columna - 1 >= 97 && !super.casillaOcupada(renglon+2, (columna-1)-97)) {
				posiblesMovimiento.add(new Tupla(renglon+2, columna-1));
			}
		}

		if (renglon - 2 > 0) {
			if (columna + 1 < 105 && !super.casillaOcupada(renglon-2, (columna+1)-97)) {
				posiblesMovimiento.add(new Tupla(renglon -2, columna+1));
			}
			if (columna - 1 >= 97 && !super.casillaOcupada(renglon-2, (columna-1)-97)) {
				posiblesMovimiento.add(new Tupla(renglon-2, columna-1));
			}
		}

		if (columna + 2 < 105) {
			System.out.println((renglon + 1) + " " + ((columna+2)-97));
			if (renglon + 1 < 8 && !super.casillaOcupada(renglon + 1, (columna+2)-97)) {
				posiblesMovimiento.add(new Tupla(renglon+1, columna+2));
			}
			if (renglon - 1 > 0 && !super.casillaOcupada(renglon-1, (columna+2)-97)) {
				posiblesMovimiento.add(new Tupla(renglon-1, columna+2));
			}
		}

		if (columna -2 >= 97) {
			if (renglon + 1 < 8 && !super.casillaOcupada(renglon+1, (columna-2)-97)) {
				posiblesMovimiento.add(new Tupla(renglon+1, columna-2));
			}
			if (renglon - 1 > 0 && !super.casillaOcupada(renglon-1, (columna-2)-97)) {
				posiblesMovimiento.add(new Tupla(renglon-1, columna-2));
			}
		}
	}

	@Override
	public String toString(){
		String s = "Caballo: \n";
		for (Tupla t : posiblesMovimiento) {
			s += t.x + ", " + (char)t.y + "\n";
		}
		return s;
	}

	@Override
	public LinkedList<Tupla> posiblesMovimientos(int renglon, char columna) {
		return this.posiblesMovimiento;
	}

	public static void main(String[] args) {
		Caballo c = new Caballo(9, 'i');
		System.out.println(c.toString());
	}

	public int getSumaDominacion(int renglon, int columna) {
		int suma = 0;
		
		//Suma de valor de casillas

		//Suma de piezas atacadas.

		//Resta de piezas no defendidas.

		return suma;
	}

	/**
	 * Método encargado de verificar que el movimiento del usuario se encuentra dentro
	 * de la lista de posible movimientos de la pieza.
	 * @param renglon 
	 * @param columna
	 * @return Vertdadero em caso de de que se encuentre, falso en caso contrario.
	 */
	@Override
	public boolean contiene(int renglon, char columna) {
		return this.posiblesMovimiento.contains(new Tupla(renglon, columna));
	}
}