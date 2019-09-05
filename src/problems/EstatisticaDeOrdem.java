package problems;

import java.util.Scanner;

/**
 * fonte: http://tst-eda.splab.ufcg.edu.br/#!/app/activity/estatistica_de_ordem
 * @author guimcarneiro
 *
 */
public class EstatisticaDeOrdem {

	public static int getOrder(int[] v) {
		
		int minor = v[0];
		int bigger = v[0];
		
		for(int i=0;i<v.length;i++) {
			if(v[i]<minor) {
				minor = v[i];
			}
			if(v[i]>bigger) {
				bigger = v[i];
			}
		}
		
		return selection(v, v[0], minor, bigger);
	}
	
	public static int selection(int[] v,int first_element, int minor, int bigger) {
		int superior_limit = bigger;
		if(minor != first_element) {
			for(int i=0;i<v.length;i++) {
				if(v[i]>minor && v[i]<superior_limit) {
					superior_limit = v[i];
				}
			}
			minor = superior_limit;
			return 1 + selection(v, first_element, minor, bigger);
		}
		return 1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] arrayStr = sc.nextLine().split(" ");
		int[] arrayInt = new int[arrayStr.length];
		for(int i=0;i<arrayStr.length;i++) {
			arrayInt[i]=Integer.parseInt(arrayStr[i]);
		}
		System.out.println(getOrder(arrayInt));
	}
}
