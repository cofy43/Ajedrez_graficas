package src.juego;

import java.util.LinkedList;


public class Tablero {

    /**
     * Clase que permitira llevar el registro de los movimientos
     * de una pieza de ambos jugadores.
     */
    public class piezaTablero {
        Pieza p;
        char pieza;
        int x;
        int y;

        public piezaTablero(char pieza, int x, int y) {
            this.pieza = pieza;
            this.x = x;
            this.y = y;
            creaPieza(pieza);
        }


        private void creaPieza(char pieza) {
            char columna = (char) (y+97);
            switch(pieza) {
                //Alfil
            case 'a':
                p = new Alfil(x, columna);
                break;
            //Caballo
            case 'c':
                p = new Caballo(x, columna);
                break;
            //Torre
            case 't':
                p = new Torre(x, columna);
                break;
			//Rey
            case 'r': 
                p = new Rey(x, columna);
                break;
			//Dama
			case 'd': 
                p = new Dama(x, columna);
                break;
            //Peón
			default: 
				p = new Peon(x, columna);
            }
        }

        public String toString() {
            return pieza + " " + x + " " +y;
        }
    }

    //Listas de piezas de ambos bandos con las coordenadas actuales de 
    //cada pieza.
    LinkedList<piezaTablero> blancas = new LinkedList<>();
    LinkedList<piezaTablero> negras = new LinkedList<>();

    boolean[][] tablero = new boolean[8][8];

    /**
     * Método encargado de la inicialización del juego que posiciona
     * las piezas en su lugar de origen, además de crear las listas de
     * las piezas de cada jugador.
     */
    public void creaTablero() {
        for (int i = 0; i < 8; i++) {
            if (i == 0 || i == 1 || i == 6 | i == 7) {
                for (int j = 0; j < 8; j++) {
                    //Agrego las posiciones iniciales de cada pieza.
                    if (i < 2) {
                        if (i == 0) {
                            blancas.add(new piezaTablero(getPieza(j), i, j));
                        } else {
                            blancas.add(new piezaTablero(getPieza(-1), i, j));
                        }
                    } else {
                        if (i == 7) {
                            negras.add(new piezaTablero(getPieza(j), i, j));
                        } else {
                            negras.add(new piezaTablero(getPieza(-1), i, j));
                        }
                    }
                    tablero[i][j] = true;
                }
            }
        }
    } 

    /**
     * Método encargado de regresar la representación en cadena del ascci de la
     * pieza de acuerdo a la coordenada correspondiente a la lista de piezas de 
     * cada jugador.
     * @param x Coordenada del eje x del tablero.
     * @param y Coordenada del eje y del tablero.
     * @return tableroCadena Representación en cadena de la pieza en Ascci.
     */
    private String registraMovimiento(int x, int y) {
        boolean color = false;
        String tableroCadena = "";
        for (piezaTablero pt : blancas) {
            if (pt.x == x && pt.y == y) {
                return tableroCadena += creaPieza(pt.pieza, color);
            }
        }

        color = true;
        for (piezaTablero pt : negras) {
            if (pt.x == x && pt.y == y) {
                tableroCadena += creaPieza(pt.pieza, color);
            }
        }

        return tableroCadena;
    }

    /**
     * Método auxiliar que dada una coordenada x de posición inicial 
     * se encarga de devolver la inicial de la pieza que corresponde en el lugar.
     * NO es el encargado de la asignación del color de la pieza.
     * @param j Coordenada x del tablero.
     * @return Incial de la pieza.
     */
    private char getPieza(int j) {
        switch(j) {
            //Alfil
            case 5:
			case 2: 
				return 'a';
            //Caballo
            case 6:
			case 1: 
				return 'c';
            //Torre
            case 7:
			case 0: 
				return 't';
			//Rey
			case 4: 
				return 'r';
			//Dama
			case 3: 
				return 'd';
			//Peón
			default: 
				return 'p';
		}
    }

    /**
     * Método auxiliar encargado de devolver la representació Ascci de la pieza
     * a traves de la incial de la pieza, y un una variable booleana, la cual dependiendo
     * de su valor será el color. Verdadero son piezas blancas, caso contrario negras.
     * @param j Incial de la pieza a dibujar en el tablero.
     * @param color Boolenao encargado de indicar el color de la pieza.
     * @return Representación en cadesa del Asscii de la pieza.
     */
    private String creaPieza(char j, boolean color) {
        String tableroCadena = "";
        if (color) {
            switch (j) {
                case 't': 
                    tableroCadena +=  "║ " + "♖ ";        
                    break;
                case 'c': 
                    tableroCadena +=  "║ " + "♘ ";
                    break;
                case 'a': 
                    tableroCadena +=  "║ " + "♗ ";
                    break;
                case 'd': 
                    tableroCadena +=  "║ " + "♕ ";
                    break;
                case 'r': 
                    tableroCadena +=  "║ " + "♔ ";
                    break;
                case 'p':
                    tableroCadena +=  "║ " + "♙ ";
                    break;   
            }
        } else {
            switch (j) {
                case 't': 
                    tableroCadena +=  "║ " + "♜ ";        
                    break;
                case 'c': 
                    tableroCadena +=  "║ " + "♞ ";
                    break;
                case 'a': 
                    tableroCadena +=  "║ " + "♝ ";
                    break;
                case 'd': 
                    tableroCadena +=  "║ " + "♛ ";
                    break;
                case 'r': 
                    tableroCadena +=  "║ " + "♚ ";
                    break;
                case 'p':
                    tableroCadena +=  "║ " + "♟ ";
                    break;
            }
        }
        return tableroCadena;
    }

    /**
     * Método auxiliar que indica en base a coordenadas proporcionadas si la casilla 
     * es central. Esto para su furturo utilización en la suma de puntos de dominación
     * para la mejor toma de desición de movimientos por parte de la computadora.
     * @param x Coordenada correspondiente al eje x del tablero.
     * @param y Coordenada correspondiente al eje y del tablero.
     * @return Verdadero si es una casiila central, Falso en caso contrario.
     */
    private boolean esCasillaCentral(int x, int y) {
        if (x == 3 || x == 4) {
            if (y == 3 || y == 4) {
                return true;
            }
        }

        return false;
    }

    /**
     * Método auxiliar que indica en base a coordenadas proporcionadas si la casilla 
     * del contorno central. Esto para su furturo utilización en la suma de puntos de dominación
     * para la mejor toma de desición de movimientos por parte de la computadora.
     * @param x Coordenada correspondiente al eje x del tablero.
     * @param y Coordenada correspondiente al eje y del tablero.
     * @return Verdadero si es una casiila del contorno central, Falso en caso contrario.
     */
    private boolean esCasillaContorno(int x, int y) {
        if (x == 3 || x == 4) {
            if (y == 2 || y == 5) {
                return true;
            }
        }

        if (y == 3 || y == 4) {
            if (x == 2 || x == 5) {
                return true;
            }
        }

        return false;
    }

    private Pieza busquedaEnPiezas(int x, int y) {
        //Busqueda en las piezas blancas
        for (piezaTablero pt : blancas) {
            if (pt.x == x && pt.y == y) {
                return pt.p;
            }
        }

        //Busqueda en las piezas negras
        for (piezaTablero pt : negras) {
            if (pt.x == x && pt.y == y) {
                return pt.p;
            }
        }

        //En caso de que la posición no coincida con las
        //posiciones de las piezas del alguno de los jugadores.
        return null;
    }

    /**
     * Método encargado de la actualización de la posicón de una ficha tanto en 
     * el tablero como en las lista de las piezas del jugador correspondiente.
     * @param momiviemto Representación en cadena del movimineto realizado siguiendo
     * el sistema columna incial (Indicada con letras de la a-h), fila incial (indicadada
     * con números del 1-8), columna final(Indicada con letras de la a-h), fila incial (indicadada
     * con números del 1-8), separadas por un espació.
     * @return Booleano indicando si el movimiento se realizó de manera correcta.
     */
    public boolean actualizaMovimiento(String momiviemto) {
        String[] moviminetos = momiviemto.toLowerCase().split(" ");
        int columna = (int)moviminetos[0].charAt(0) - 97;
        System.out.println("columna: " + columna);
        int fila = Integer.valueOf(moviminetos[0].substring(1));
        System.out.println("fila: " + fila);
        Pieza p = busquedaEnPiezas(--fila, columna);
        if (p != null) {
            //Creación de lista de posibles movimientos.
            System.out.println("fila "+(fila) + " columna" + (columna));
            p.esValida(columna, (char)(fila+98));
            //Actualización del tablero
            if (p.contiene(fila, (char)(columna+97))) {
                tablero[fila][columna] = false;
                int columna2 = (int)moviminetos[1].charAt(0) - 97;
                int fila2 = Integer.valueOf(moviminetos[1].substring(1));
                tablero[--fila2][columna2] = true;
                //Actualización del movimiento en la lista de las piezas
                for (piezaTablero pt : blancas) {
                    if (pt.p.equals(p)) {
                        System.out.println("jalo en blancas");
                        pt.x = fila2;
                        pt.y = columna2;
                        return true;
                    }
                }
                for (piezaTablero pt : negras) {
                    if (pt.p.equals(p)) {
                        System.out.println("jalo en negras");
                        pt.x = fila2;
                        pt.y = columna2;
                        return true;
                    }
                }
            } else {
                System.out.println(p.toString());
                System.out.println("Error, movimiento invalido");
                return false;
            }
        }
        return false;
    }

    /**
     * Método encargado de mostrar en la terminal el tablero con los cambios
     * de las piezas.
     * @return Representación del tablero.
     */
    public String toString() {
        boolean linea = true;
        String tableroCadena = "";
        tableroCadena += "\n╔═══╦═══╦═══╦═══╦═══╦═══╦═══╦═══╗";
        for (int i = 0; i < tablero.length; i++) {
            tableroCadena += "\n";
            if (i % 2 == 0) {
                linea = false;
            } else {
                linea = true;
            }
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] == false) {
                    if (linea) {
                        if (j % 2 == 0) {
                            tableroCadena +=  "║   ";    
                        } else {
                            tableroCadena +=  "║███";
                        }
                    } else {
                        if (j % 2 != 0) {
                            tableroCadena +=  "║   ";    
                        } else {
                            tableroCadena +=  "║███";
                        }
                    }
                }
                else {
                    tableroCadena += registraMovimiento(i, j);
                }
            }
            if (i < 7) {
                tableroCadena += "║ "+(i+1) + "\n╠═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╣" ;
            } else {
                tableroCadena += "║ 8\n╚═══╩═══╩═══╩═══╩═══╩═══╩═══╩═══╝";
                tableroCadena += "\n  a   b   c   d   e   f   g   h";        

            }
        }
        return tableroCadena + "\n";
    }

    /**
     * Método auxiliar que nos indica se encuentra una pieza en aquella 
     * parte del tablero.
     * @param x Coordenada del eje de las x del tablero.
     * @param y Coordenada del eje de las y del tablero.
     * @return Verdadero si la casilla esta ocupada, Falso en caso contrario.
     */
    protected boolean casillaOcupada(int x, int y){
        return (tablero[x][y]);
    }

    public String muestaListas() {
        String s = "blancas:\n";

        for (piezaTablero p : blancas) {
            s += p.toString() + "\n";
        }

        s += "Negras:\n";
        for (piezaTablero p : negras) {
            s += p.toString() + "\n";
        }

        return s;
    }

    public static void main(String[] args) {
        Tablero t =  new Tablero();
        t.creaTablero();
        t.actualizaMovimiento("b1 3a");
        System.out.println(t.toString());
    }

}