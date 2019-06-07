package src.juego;

import java.util.LinkedList;

public class Peon extends Pieza {
    boolean primeraJugada = true;

    Peon (int renglon, char columna) {
		esValida(renglon, columna);
	}

	LinkedList<Tupla> posiblesMovimiento = new LinkedList<>();

	@Override
	public void esValida (int x, char y){
		int renglon = x;
		int columna = (int)y;

		if (renglon <=0 || renglon >= 9) return;
		if ((int)columna <= 96 || (int)columna >= 105) return;

        if (primeraJugada) {
            if (renglon + 2 < 9 && !super.casillaOcupada(--renglon+2, columna-97)) {
                posiblesMovimiento.add(new Tupla(renglon + 2, columna));
                primeraJugada = false;
            }
        } 
        
        if (renglon + 1 < 9) {
            if (super.casillaOcupada(renglon+1, columna-97)) {
                posiblesMovimiento.add(new Tupla(renglon + 1, columna));
            }
        }
        
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

	@Override
	public String toString(){
		String s = "Peon: \n";
		for (Tupla t : posiblesMovimiento) {
			s += t.x + ", " + (char)t.y + "\n";
		}
		return s;
	}

	@Override
	public LinkedList<Tupla> posiblesMovimientos(int renglon, char columna) {
		return this.posiblesMovimiento;
	}

}