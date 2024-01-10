import java.util.*;

public class Potencia extends Thread{
	
	int numero;
	
	public Potencia (int numero) {
		this.numero = numero;
	}
		
	public void run() {
		
		ArrayList<Integer> numeros = new ArrayList<>();
			
		
		for (int j = 0; j < this.numero; j++) {
			
	        int resultado = (int) Math.pow(2, j);

			numeros.add(resultado);
			
		}
		
		CFilPrincipal.valoresDePotencia.add(numeros);

	}
		
}
