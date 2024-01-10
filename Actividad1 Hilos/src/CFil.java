import java.util.*;

public class CFil extends Thread{

	int numero;	
	int resultado;
	
	public CFil (int numero) {
		this.numero = numero;
	}
	
	//gets
	
	public int getResultado(){
		return resultado;
	}
	
	public void run() {
		resultado = funcion(numero);
	}
	
	
	public int funcion(int n) {
		
		if (n == 0 || n == 1) {
			return 1;
		} else {
			int factorial = 1;
			for (int i = 1; i <= n; i ++) {
				factorial *= i;
			}
			return factorial;
		}
		
	}
}
