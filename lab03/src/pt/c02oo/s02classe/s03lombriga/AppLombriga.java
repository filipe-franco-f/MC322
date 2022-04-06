package pt.c02oo.s02classe.s03lombriga;

public class AppLombriga {

   public static void main(String[] args) {
      Toolkit tk = Toolkit.start();
      
      String lombrigas[] = tk.recuperaLombrigas();
      
      int tamAnimacao;
      
      for (int l = 0; l < lombrigas.length; l++) {
    	  tamAnimacao = lombrigas[l].length();
    	  Animacao a = new Animacao(lombrigas[l]);
    	  tk.gravaPasso("=====");
    	  tk.gravaPasso(a.apresenta());
    	  for (int i = 6; i < tamAnimacao; i++) {
    		  a.passo();
    		  tk.gravaPasso(a.apresenta());
    	  }
      }
      
      tk.stop();
   }

}
