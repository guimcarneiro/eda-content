package problems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * fonte: http://tst-eda.splab.ufcg.edu.br/#!/app/activity/particionamento_lomuto
 * 
 * @author guimcarneiro
 *
 */
public class ParticionamentoLomuto {

	public static void particionamento(int[] v, int inicio, int fim) {
		
		int pivot = v[inicio];
		int counter = inicio;
		
		for(int i=inicio+1;i<=fim;i++) {
			if(v[i]<pivot) {
				counter+=1;
				int aux = v[i];
				v[i] = v[counter];
				v[counter] = aux;
				System.out.println(Arrays.toString(v));
			}
		}
		
		int aux = v[inicio];
		v[inicio] = v[counter];
		v[counter] = aux;
		
		System.out.println(Arrays.toString(v));
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String[] arrayStr = sc.nextLine().split(" ");
		int[] arrayInt = new int[arrayStr.length];
		for(int i=0;i<arrayStr.length;i++) {
			arrayInt[i]=Integer.parseInt(arrayStr[i]);
		}
		
		particionamento(arrayInt, 0, arrayInt.length-1);
		System.out.println(Arrays.toString(arrayInt));
	}
	
}
