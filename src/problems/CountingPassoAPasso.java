package problems;

import java.util.Scanner;

/**
 * Fonte: http://tst-eda.splab.ufcg.edu.br/#!/app/activity/counting_sort_passo_a_passo
 * 
 * @author guimcarneiro
 *
 */
public class CountingPassoAPasso {

	public static String exibeArray(int[] array) {
		String saida = "";
		for(int i=0;i<array.length;i++) {
			saida +=array[i] +" ";
		}
		return saida.substring(0, saida.length()-1);
	}
	
public static void sort(int[] v,int k) {
		
		int biggest_value = k+1;
		
		int[] frequency = new int[biggest_value];
		for(int i=0;i<v.length;i++) {
			frequency[v[i]]+=1;
			System.out.println(exibeArray(frequency));
		}
		
		for(int i=1;i<frequency.length;i++) {
			frequency[i]+=frequency[i-1];
		}
		System.out.println("Cumulativa do vetor de contagem - " + exibeArray(frequency));
		
		int[] ordered_array = new int[v.length];
		for(int i=ordered_array.length-1;i>-1;i--) {
			ordered_array[frequency[v[i]]-1] = v[i];
			frequency[v[i]]-=1;
		}
		System.out.println(exibeArray(frequency));
		
		for(int i=0;i<v.length;i++) {
			v[i]=ordered_array[i];
		}
		System.out.println(exibeArray(v));
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String[] arrayStr = sc.nextLine().split(" ");
		int[] arrayInt = new int[arrayStr.length];
		for(int i=0;i<arrayStr.length;i++) {
			arrayInt[i]=Integer.parseInt(arrayStr[i]);
		}
		int bigger = sc.nextInt();
		sort(arrayInt, bigger);
		
	}

}
