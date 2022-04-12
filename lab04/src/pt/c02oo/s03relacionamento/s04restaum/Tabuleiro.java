package pt.c02oo.s03relacionamento.s04restaum;

public class Tabuleiro {
	static String[][] tab = {
	         {" ", " ", "P", "P", "P", " ", " "},
	         {" ", " ", "P", "P", "P", " ", " "},
	         {"P", "P", "P", "P", "P", "P", "P"},
	         {"P", "P", "P", "-", "P", "P", "P"},
	         {"P", "P", "P", "P", "P", "P", "P"},
	         {" ", " ", "P", "P", "P", " ", " "},
	         {" ", " ", "P", "P", "P", " ", " "}
	      };
	Peca vPecas[];
	
	Tabuleiro(Peca vPecas[]) {
		this.vPecas = vPecas;
	}
	
	void mover(int fonte[], int dest[], int cap[]) {
		tab[fonte[0]][fonte[1]] = "-";
		tab[dest[0]][dest[1]] = "P";
		tab[cap[0]][cap[1]] = "-";
		comunicarMorte(cap);
		comunicarMov(fonte, dest);
	}
	
	void comunicarMorte(int c[]) {
		for (int i = 0; i < vPecas.length; i++) {
			Peca p = vPecas[i];
			if (p.viva && p.posx == c[0] && p.posy == c[1]) {
				p.morrer();
			}
		}
	}
	
	void comunicarMov(int fonte[], int dest[]) {
		for (int i = 0; i < vPecas.length; i++) {
			Peca p = vPecas[i];
			if (p.viva && p.posx == fonte[0] && p.posy == fonte[1]) {
				p.mover(dest[0], dest[1]);
			}
		}
	}
	
	static String oQueTemAli(int c[]) {
		String s = tab[c[0]][c[1]];
		return s;
	}
	
	static String[][] mostrarTab() {
		return tab;
	}

}
