package src.juego;
import java.util.LinkedList;

public class Torre extends Pieza{
	
	Torre (int renglon, char columna) {
		esValida(renglon, columna);
	}

	LinkedList<Tupla> posiblesMovimiento = new LinkedList<>();

	@Override
	public void esValida ( int x, char y){
		int renglon = x;
		int columna = (int)y;
		boolean vertical1,vertical2, horizontal1, horizontal2;
		vertical1 = vertical2 = horizontal1 = horizontal2 = true;

		if (renglon<=0 || renglon>=9) return;
		if ((int)columna<= 96 || (int)columna>= 105) return;

        for (int i = 1; i <= 8; i++) {
			if (vertical1) {
				if (renglon +i <= 8 && !super.casillaOcupada(--renglon+i, columna-97)) {
					posiblesMovimiento.add(new Tupla(renglon + i, columna));
				} else {
					vertical1 = false;
				}
			}
			if (vertical2) {
				if (renglon - i > 0 && !super.casillaOcupada(renglon-i, columna-97)) {
					posiblesMovimiento.add(new Tupla(renglon - i, columna));
				} else {
					vertical2 = false;
				}
			}
			if (horizontal1) {
				if (columna + i < 105 && !super.casillaOcupada(renglon, (columna+ i)-97)) {
					posiblesMovimiento.add(new Tupla(renglon, columna + i));
				} else {
					horizontal1 = false;
				}
			}
			if (horizontal2) {
				if (columna-i >= 97 && !super.casillaOcupada(renglon, (columna-i)-97)) {
					posiblesMovimiento.add(new Tupla(renglon, columna -i));
				} else {
					horizontal2 = false;
				}
			}
        }
	}

	@Override
	public String toString(){
		String s = "Torre: \n";
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
		Torre a = new Torre(8, 'a');
		System.out.println(a.toString());
	}

//	@Override
	public int getSumaDominacion(int renglon, int columna) {
		return 0;
	}
}