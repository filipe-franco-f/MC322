package pt.c02oo.s02classe.s03lombriga;

public class Animacao {
	String anima;
	AquarioLombriga aq;
	int posi;
	
	Animacao (String anima) {
		this.anima = anima;
		String AA = anima.substring(0, 2);
		String LL = anima.substring(2, 4);
		String PP = anima.substring(4, 6);
		int tamaq = Integer.parseInt(AA);
		int tamlom = Integer.parseInt(LL);
		int pos = Integer.parseInt(PP);
		this.aq = new AquarioLombriga(tamaq, tamlom, pos);
		this.posi = 6;
	}
	
	void passo() {
		if (anima.charAt(posi) == 'C') {
			aq.crescer();
		} else if (anima.charAt(posi) == 'M') {
			aq.mover();
		} else if (anima.charAt(posi) == 'V') {
			aq.virar();
		}
		posi++;
	}
	
	String apresenta() {
		return aq.apresenta();
	}
}
