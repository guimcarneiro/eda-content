package ae12;

import java.util.Arrays;

public class BubbleSort {

	public static int[] bubble_sort(int[] lista) {
		for(int i=0;i<lista.length;i++) {
			for(int j=0;j<lista.length;j++) {
				if(lista[i]<lista[j]) {
					int aux = lista[i];
					lista[i] = lista[j];
					lista[j] = aux;
				}
			}
		}
		return lista;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[] {5, 13, 3, 4, 8};
		System.out.println(Arrays.toString(array) + "\n");
		System.out.println(Arrays.toString(bubble_sort(array)));
		
	}

}
