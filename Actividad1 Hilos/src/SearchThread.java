import java.util.Random;
import java.util.Scanner;

class SearchThread extends Thread {
    private int minNum;
    private int maxNum;
    private int numS;
    private int numH;
    private int[] vecRand;

    public SearchThread(int minNum, int maxNum, int numS, int numH, int[] vecRand) {
        this.minNum = minNum;
    	this.maxNum = maxNum;
        this.numS = numS;
        this.numH = numH;
        this.vecRand = vecRand;

    }

    @Override
    public void run() {
    	
    	int com = 0;
    	
        for (int i = minNum; i <= maxNum; i++) {
        	
            if (vecRand[i] == numS) {
                System.out.println("El hilo "+numH+" a encontrado a " + numS);
                com++;
            } 
        }
        
        
        if (com == 0) {
            System.out.println("El hilo "+ numH +" no lo ha encontrado " +"\n");

		}
        
    }
    
    
}