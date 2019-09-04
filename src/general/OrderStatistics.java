package general;

import java.util.Arrays;

public class OrderStatistics {

	public static int getOrderStatistics(int[] array, int k) {
		int minor = array[0];
		int bigger = array[0];
		
		for(int i=0;i<array.length;i++) {
			if(array[i] < minor) {
				minor = array[i];
			}
			if(array[i]> bigger) {
				bigger = array[i];
			}
		}
		return selection(array, minor, bigger, k);
	}
	
	private static int selection(int[] array, int minor, int bigger, int k) {
		int menor_atual = minor;
		
		if(k>0) {
			menor_atual=bigger;
			for(int i=0;i<array.length;i++) {
				if(array[i] > minor && array[i] < menor_atual) {
					menor_atual = array[i];
				}
			}
			menor_atual = selection(array, menor_atual, bigger, k-1);
			if(menor_atual == minor) {
				//return null;
				menor_atual = -500;
			}
		}
		return menor_atual;
	}
	
	public static void main(String[] args) {
		
		int[] array = new int[] {6, 42, 23, 54, 753, 23, 7};
		int k = 4;
		
		System.out.println("Array: " + Arrays.toString(array));
		System.out.println("Estatistica de ordem " + k + ": " + getOrderStatistics(array, k));

	}

}
