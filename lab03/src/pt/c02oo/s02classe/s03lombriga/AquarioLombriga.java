package pt.c02oo.s02classe.s03lombriga;

public class AquarioLombriga {
	int tamaq; 
	int tamlom; 
	int pos;
	boolean esquerda;
	int ini;
	int fim;

	AquarioLombriga(int tamaq, int tamlom, int pos) {
		
		this.tamaq = tamaq;
		this.esquerda = true;
		
		if (tamlom > tamaq) {
			this.tamlom = tamaq;
		} else {
			this.tamlom = tamlom;
		}
	
		if (pos + tamlom - 1 > tamaq || pos < 1) {
			this.pos = 1;
		} else  {
			this.pos = pos;
		}

		this.ini = this.pos;
		this.fim = this.pos + this.tamlom - 1; 
	}
	
	void crescer() {
		if (esquerda && fim < tamaq) {
			tamlom++;
			fim++;
		}
		if (!esquerda && ini > 1) {
			tamlom++;
			ini--;
		}
	}
	
	void virar() {
		if (esquerda) {
			esquerda = false;
			pos = fim;
		} else {
			esquerda = true;
			pos = ini;
		}
	}
	
	void mover() {
		if (esquerda && ini > 1) {
			ini--;
			fim--;
			pos--;
		} else if (esquerda) {
			virar();
		} else if (fim < tamaq) {
			ini++;
			fim++;
			pos++;
		} else {
			virar();
		}
	}

	String apresenta() {
		String aquario = "";
		
		for (int i = 1; i <= tamaq; i++) {
			if (i == pos) {
				aquario += "O";
			}
			else if (i < ini || i > fim) {
				aquario += "#";
			}
			else {
				aquario += "@";
			}
		}
		return aquario;
	}
}
