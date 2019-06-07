package src.juego;
import java.util.LinkedList;

public class Alfil extends Pieza{

	Alfil (int renglon, char columna) {
		esValida(renglon, columna);
	}

	LinkedList<Tupla> posiblesMovimiento = new LinkedList<>();

	public void esValida ( int x, char y){
		int renglon = x;
		int columna = (int)y;
		boolean diagonal1, diagonal2, diagonal3, diagonal4;
		diagonal1 = diagonal2 = diagonal3 = diagonal4 = true;

		if (renglon<=0 || renglon>=9) return;
		if ((int)columna<= 96 || (int)columna>= 105) return;

        for (int i = 1; i <=8; i++) {
            if (renglon+i <  8) {
				if (diagonal1) {
					if (columna + i < 105 && !super.casillaOcupada(renglon+i, (columna+ i)-97)){
						//System.out.println("diagonal1: " + (renglon + i) + " " + ((columna + i)-97));
						posiblesMovimiento.add(new Tupla(renglon + i, columna + i));
					} else {
						diagonal1 = false;
					}
				}
				if (diagonal2) {
					if (columna-i >= 97 && !super.casillaOcupada(renglon+i, (columna-i)-97)) {
						//System.out.println("diagonal2: " + (renglon + i) + " " + ((columna - i)-97));
						posiblesMovimiento.add(new Tupla(renglon + i, columna - i));
					} else {
						diagonal2 = false;
					}
				}
			}
            if (renglon - i >= 0) {
				if (diagonal3) {
					if (columna + i < 105 && !super.casillaOcupada(renglon-i, (columna+ i)-97)) {
						//System.out.println("diagonal3: " + (renglon - i) + " " + ((columna + i)-97));
						posiblesMovimiento.add(new Tupla(renglon - i, columna + i));
					} else {
						diagonal3 = false;
					}

				}
				if (diagonal4) {
					if (columna-i >= 97 && !super.casillaOcupada(renglon-i, (columna-i)-97)) {
						//System.out.println("diagonal4: " + (renglon - i) + " " + ((columna - i)-97));
						posiblesMovimiento.add(new Tupla(renglon - i, columna - i));
					} else {
						diagonal4 = false;
					}
				}
            } 
        }
	}

	public String toString(){
		String s = "Alfil: \n";
		for (Tupla t : posiblesMovimiento) {
			s += t.x + ", " + (char)t.y + "\n";
		}
		return s;
	}

	public LinkedList<Tupla> posiblesMovimientos(int renglon, char columna) {
		return this.posiblesMovimiento;
	}

	public int sumaCasillasDominacion() {
		return 0;
	}

	public boolean esCasillaCentral() {
		return false;
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
		Tablero t = new Tablero();
		System.out.println(t.toString());
		t.creaTablero();
		Alfil a = new Alfil(1, 'f');
		System.out.println(a.toString());
		System.out.println(t.toString());
		System.out.println(t.muestaListas());
	}
}