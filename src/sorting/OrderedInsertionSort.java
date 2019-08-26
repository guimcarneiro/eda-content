package sorting;

import java.util.Arrays;
import java.util.Scanner;

public class OrderedInsertionSort {

	public static void sort(int[] v) {
		for(int i=0;i<v.length-1;i++) {
			for(int j=0;j<v.length-1-i;j++) {
				if(v[j+1]<v[j]) {
					int aux=v[j+1];
					v[j+1]=v[j];
					v[j]=aux;
				}				
			}
		}
		System.out.println(Arrays.toString(v));
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
