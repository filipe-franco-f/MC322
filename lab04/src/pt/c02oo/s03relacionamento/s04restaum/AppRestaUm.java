package pt.c02oo.s03relacionamento.s04restaum;

public class AppRestaUm {

	   public static void main(String[] args) {
	      AppRestaUm.executaJogo(null, null);
	   }
	   
	   public static void executaJogo(String arquivoEntrada, String arquivoSaida) {
	      Toolkit tk = Toolkit.start(arquivoEntrada, arquivoSaida);
	      
	      String commands[] = tk.retrieveCommands();
	      
	      Peca vPecas[] = new Peca[32];
		  int contador = 0;
		  for (int i = 0; i < 7; i++) {
			  for (int j = 0; j < 7; j++) {
				  if (Auxiliar.coordenadasIniciais(i, j)) {
					  vPecas[contador] = new Peca(i, j);
					  contador++;
				  }
			  }
		  }
			
		  Tabuleiro t = new Tabuleiro(vPecas);
		  
		  for (int i = 0; i < vPecas.length; i++) {
				vPecas[i].conecta(t);
		  }
	      
		  String[][] board = t.mostrarTab();
		  tk.writeBoard("Tabuleiro inicial", board);
		  
		  for (int i = 0; i < commands.length; i++) {
			  String pos = commands[i].substring(0, 2);
			  String dest = commands[i].substring(3, 5);
			  int posc[] = Auxiliar.coordenadas(pos);	  
			  int destc[] = Auxiliar.coordenadas(dest);
			  
			  for (int j = 0; j < vPecas.length; j++) {
					if (vPecas[j].posx == posc[0] && vPecas[j].posy == posc[1] && vPecas[j].viva) {
						vPecas[j].permitirMov(destc[0], destc[1]);
						board = t.mostrarTab();
						String title = "source: " + pos + "; target: " + dest; 
						tk.writeBoard(title, board);
					}
			  }
		  }
		  
	      tk.stop();
	   }

}