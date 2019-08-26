package sorting;

import java.util.Arrays;
import java.util.Scanner;

public class SelectionRecursiveSort {
	
	public static void selectionSort(int v[], int start, int end) {
		int lowest_i = start;
		for(int i=lowest_i+1; i<end; i++) {
			if(v[i]<v[lowest_i]) {
				lowest_i = i;
			}
		}
		if(lowest_i != start) {
			int aux = v[lowest_i];
			v[lowest_i] = v[start];
			v[start] = aux;
		}
		System.out.println(Arrays.toString(v));
		
		//Stopping or calling again
		if(start + 1 < end - 1) {
			selectionSort(v, start+1, end);
		}
	}
	
	public static void sort(int[] v) {
		selectionSort(v, 0, v.length);
	}
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		String[] arrayStr = sc.nextLine().split(" ");
		int[] arrayInt = new int[arrayStr.length];
		for(int i=0;i<arrayStr.length;i++) {
			arrayInt[i]=Integer.parseInt(arrayStr[i]);
		}	
		sort(arrayInt);
		
	}
	
}
