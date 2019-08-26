package sorting;

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {
	public static void sort(int v[]) {
		for(int i=0;i<v.length-1;i++) {
			int lowest_i=i;
			for(int j=i+1;j<v.length;j++) {
				if(v[j]<v[lowest_i]) {
					lowest_i=j;
				}
			}
			if(lowest_i!=i) {
				int aux=v[lowest_i];
				v[lowest_i]=v[i];
				v[i]=aux;
				System.out.println(Arrays.toString(v));
			}
		}
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
