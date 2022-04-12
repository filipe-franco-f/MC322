package pt.c02oo.s03relacionamento.s04restaum;

import java.lang.Math; 

public class Peca {
	int posx;
	int posy;
	Boolean viva;
	Tabuleiro t;
	
	Peca(int posx, int posy) {
		this.posx = posx;
		this.posy = posy;
		this.viva = true;
		t = null;
	}
	
	void conecta(Tabuleiro t) {
		this.t = t;
	}
	
	void morrer() {
		viva = false;
	}
	
	void mover(int destx, int desty) {
		posx = destx;
		posy = desty;
	}
	
	void permitirMov(int destinox, int destinoy) {
		Boolean permitido = true;
		int dx = Math.abs(posx - destinox);
		int dy = Math.abs(posy - destinoy);
		
		if (!((dx == 2 && dy == 0) || (dx == 0 && dy == 2))) {
			permitido = false;
		}
		
		int intermx = (posx + destinox) / 2;
		int	intermy = (posy + destinoy) / 2;
		int pos[] = {posx, posy};
		int destino[] = {destinox, destinoy};
		int interm[] = {intermx, intermy};
		String d = Tabuleiro.oQueTemAli(destino);
		String i = Tabuleiro.oQueTemAli(interm);
		if (i != "P" || d != "-") {
			permitido = false;
		}
		if (permitido) {
			t.mover(pos, destino, interm);
		}
	}
}
