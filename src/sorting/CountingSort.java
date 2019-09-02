package sorting;

import java.util.Arrays;

public class CountingSort {

	//Só aceita valores positivos
	public static void sort(int[] v) {
		
		int biggest_value = v[0];
		for(int i=0;i<v.length;i++) {
			if(v[i]>biggest_value) {
				biggest_value = v[i];
			}
		}
		
		int[] frequency = new int[biggest_value];
		for(int i=0;i<v.length;i++) {
			frequency[v[i]-1]+=1;
		}
		
		for(int i=1;i<frequency.length;i++) {
			frequency[i]+=frequency[i-1];
		}
		
		int[] ordered_array = new int[v.length];
		for(int i=ordered_array.length-1;i>-1;i--) {
			ordered_array[frequency[v[i]-1]-1] = v[i];
			frequency[v[i]-1]-=1;
		}
		
		for(int i=0;i<v.length;i++) {
			v[i]=ordered_array[i];
		}
	}
	
	public static void main(String[] args) {
		
		int[] v = new int[] {5,7,4,3,7,89,1,35,35,35,35,3,72};
		System.out.println("Ordenado: " + Arrays.toString(v));
		sort(v);
		System.out.println("Desordenado: " + Arrays.toString(v));
		
	}
	
}
