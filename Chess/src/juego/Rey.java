package src.juego;
import java.util.LinkedList;

public class Rey extends Pieza{

	Rey (int renglon, char columna) {
		esValida(renglon, columna);
	}

	LinkedList<Tupla> posiblesMovimiento = new LinkedList<>();

	@Override
	public void esValida (int x, char y){
		int renglon = x;
		int columna = (int)y;

		if (renglon<=0 || renglon>=9) return;
		if ((int)columna<= 96 || (int)columna>= 105) return;

		if (renglon + 1 < 9 && !super.casillaOcupada(--renglon+1, columna-97)) {
			posiblesMovimiento.add(new Tupla(renglon + 1, columna));
		}
		if (renglon - 1 > 0 && !super.casillaOcupada(renglon-1, columna-97)) {
			posiblesMovimiento.add(new Tupla(renglon - 1, columna));
		}
		if (columna + 1 < 105 && !super.casillaOcupada(renglon, (columna+ 1)-97)) {
			posiblesMovimiento.add(new Tupla(renglon, columna + 1));
		}
		if (columna - 1 >= 97 && !super.casillaOcupada(renglon, (columna-1)-97)) {
				posiblesMovimiento.add(new Tupla(renglon, columna - 1));
		}

	}

	@Override
	public String toString(){
		String s = "Rey: \n";
		for (Tupla t : posiblesMovimiento) {
			s += t.x + ", " + (char)t.y + "\n";
		}
		return s;
	}

	@Override
	public LinkedList<Tupla> posiblesMovimientos(int renglon, char columna) {
		return this.posiblesMovimiento;
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


	public static void main(String[] args) {
		Rey a = new Rey(4, 'e');
		System.out.println(a.toString());
	}

//	@Override
	public int getSumaDominacion(int renglon, int columna) {
		return 0;
	}

}