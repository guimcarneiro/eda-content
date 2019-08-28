package sorting;

import java.util.Arrays;

public class MergeRecursiveSort {

	private static void merge(int[] v, int inicio, int meio, int fim) {
		
		int[] v_aux = new int[v.length];
		
		for(int i=0; i<v.length;i++) {
			v_aux[i] = v[i];
		}
		
		int i=inicio, j=meio+1, k=inicio;
		
		while(i <= meio && j <= fim) {
			if(v_aux[i]<v_aux[j]) {
				v[k]=v_aux[i];
				i++;
			}else {
				v[k]=v_aux[j];
				j++;
			}
			k++;
		}
		while(i <= meio) {
			v[k] = v_aux[i];
			k++;
			i++;
		}
		while(j <= fim) {
			v[k] = v_aux[j];
			k++;
			j++;
		}
	}
	
	private static void mergeSort(int[] v, int inicio, int fim) {
		if(inicio<fim) {
			int meio = (inicio + fim)/2;
			mergeSort(v, inicio, meio);
			mergeSort(v, meio+1, fim);
			merge(v, inicio, meio, fim);
		}
	}
	
	public static void sort(int[] v) {
		mergeSort(v, 0, v.length-1);
	}
	
	public static void main(String[] args) {
		
		int[] v = new int[]{34,56,3,2,6,8,9,8,767,86,74,243,653,3426,23,54,1513,542,65,666, 64};
		System.out.println("Desordenado: ");
		System.out.println(Arrays.toString(v));
		sort(v);
		System.out.println("Ordenado: ");
		System.out.println(Arrays.toString(v));

	}

}
