import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class CFilPrincipal  {
	
	public static ArrayList<ArrayList<Integer>> valoresDePotencia = new ArrayList<>();
	public static int  index = 0;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Random rn = new Random();
		int n = 0;
		
		System.out.println("ELIGE LA PARTE DE LA TAREA: 1 / 2 / 3");
		n = sc.nextInt();
		
		if (n == 1) {
		
			System.out.println("Introduzca la cantidad de hilos que quiera crear: ");
			int procesos = sc.nextInt();
			
			CFil [] hilos = new CFil[procesos];
			
			for (int i = 0; i < procesos ; i++) {
				
				System.out.println("Hilo " + i +". De que numero quiere saber el factorial? ");
				
				int numeros = sc.nextInt();
				
				hilos[i] = new CFil(numeros);
						
				hilos[i].start();
				
			}
			
			try {
				
				for (CFil hilo : hilos) {
					hilo.join();
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for (int i = 0;  i < procesos; i++) {
				System.out.println("Hilo " + i + ". El factorial de " + hilos[i].numero + " es: " + hilos[i].getResultado());	
			}
			
			sc.close();
			
		} else  if (n == 2) {

			int numero = 0;
			
			System.out.println("Cuantos hilos quieres:");
			numero = sc.nextInt();
			
			Potencia [] hilos = new Potencia[numero];
	
			for (int i = 0; i < hilos.length; i++) {
				
				int num = 0;
				
				System.out.println("Hilo " + i + ": Que numero quieres la potencias:");
				num = sc.nextInt();
				
				hilos[i] = new Potencia(num);
				
				hilos[i].start();
				
				try {
					hilos[i].join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}	
				index++;
			}
			
			for (int i = 0; i < valoresDePotencia.size(); i++) {
			    System.out.print("Hilo " + i + ": ");
	
			    for (int j = 0; j < valoresDePotencia.get(i).size(); j++) {
			        System.out.print(valoresDePotencia.get(i).get(j) + " ");
			    }
	
			    System.out.println(); 
			}

        }else  if (n == 3) {
        	
        	
        	 Scanner scanner = new Scanner(System.in);

             System.out.print("Introduce el tamaño del vector: ");
             int tamañoVector = scanner.nextInt();

             System.out.print("Introduce el valor a buscar: ");
             int valorBuscado = scanner.nextInt();

             System.out.print("Introduce el número de hilos: ");
             int numHilos = scanner.nextInt();

             int[] vecRand = new int [tamañoVector];
             
             for (int i = 0; i < tamañoVector; i++) {
                 int nuevoNumero;
                 do {
                     nuevoNumero = rn.nextInt(tamañoVector);
                 } while (contiene(vecRand, nuevoNumero, i));

                 vecRand[i] = nuevoNumero;
             }
             
             SearchThread[] hilos = new SearchThread[numHilos];
             int segmento = tamañoVector / numHilos;
             int inicio = 0;
             int fin = segmento;

             for (int i = 0; i < numHilos; i++) {

             	if(i != 0) {
             		fin += segmento;
             		inicio += segmento;
             	}
             	
                 hilos[i] = new SearchThread(inicio, fin, valorBuscado, i, vecRand);
                 hilos[i].start();
             }

             for (SearchThread hilo : hilos) {
                 try {
                     hilo.join();
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
        	
        }
			
	}
	private static boolean contiene(int[] array, int numero, int longitud) {
        for (int i = 0; i < longitud; i++) {
            if (array[i] == numero) {
                return true;
            }
        }
        return false;
    }
		
}
