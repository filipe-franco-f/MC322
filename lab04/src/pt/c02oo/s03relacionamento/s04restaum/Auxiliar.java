package pt.c02oo.s03relacionamento.s04restaum;

public class Auxiliar {
	static int[] coordenadas (String pos) {
		char y = pos.charAt(0);
		int yNum = (int) y - 97;
		String x = pos.substring(1, 2);
		int xNum = Integer.parseInt(x) - 1;
		int c[] = {xNum, yNum};
		return c;
	}
	
	static Boolean coordenadasIniciais(int x, int y) {
		Boolean validas = true;
		if (x < 2 && y < 2) {
			validas = false;
		} else if (x > 4 && y < 2) {
			validas = false;
		} else if (x < 2 && y > 4) {
			validas = false;
		} else if (x > 4 && y > 4) {
			validas = false;
		} else if (x == 3 && y == 3) {
			validas = false;
		}	
		return validas;
	}
}
