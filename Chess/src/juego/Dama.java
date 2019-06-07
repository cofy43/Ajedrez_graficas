package src.juego;
import java.util.LinkedList;

public class Dama extends Pieza{

	Dama (int renglon, char columna) {
		esValida(renglon, columna);
	}

	LinkedList<Tupla> posiblesMovimiento = new LinkedList<>();

    @Override
    public void esValida ( int x, char y){
		int renglon = x;
		int columna = (int)y;

		if (renglon<=0 || renglon>=9) return;
		if ((int)columna<= 96 || (int)columna>= 105) return;

        //Alfil
        for (int i = 1; i <=8; i++) {
            if (renglon+i <= 8) {
                if (columna + i < 105 && !super.casillaOcupada(--renglon+i, (columna+ i)-97)){
                    posiblesMovimiento.add(new Tupla(renglon + i, columna + i));
                }
                if (columna-i >= 97 && !super.casillaOcupada(renglon+i, (columna-i)-97)) {
                    posiblesMovimiento.add(new Tupla(renglon + i, columna - i));
                }
            }
            if (renglon - i > 0) {
                if (columna + i < 105 && !super.casillaOcupada(renglon-i, (columna+ i)-97)) {
                    posiblesMovimiento.add(new Tupla(renglon - i, columna + i));
                }
                if (columna-i >= 97 && !super.casillaOcupada(renglon-i, (columna-i)-97)) {
                    posiblesMovimiento.add(new Tupla(renglon - i, columna - i));
                }
            } 
        }

        //Torre
        for (int i = 1; i <= 8; i++) {
            if (renglon +i <= 8 && !super.casillaOcupada(--renglon+i, columna-97)) {
                posiblesMovimiento.add(new Tupla(renglon + i, columna));
            }
            if (renglon - i > 0 && !super.casillaOcupada(renglon-i, columna-97)) {
                posiblesMovimiento.add(new Tupla(renglon - i, columna));
            } 
            if (columna + i < 105 && !super.casillaOcupada(++renglon, (columna+ i)-97)) {
                posiblesMovimiento.add(new Tupla(renglon, columna + i));
            }
            if (columna-i >= 97 && !super.casillaOcupada(renglon, (columna-i)-97)) {
                posiblesMovimiento.add(new Tupla(renglon, columna -i));
            }
        }
	}

    @Override
    public String toString(){
		String s = "Dama: \n";
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
		Dama a = new Dama(4, 'e');
		System.out.println(a.toString());
	}

    //@Override
    public int getSumaDominacion(int renglon, int columna) {
        return 0;
    }
}