package ae12;

import java.util.Arrays;

public class TemRepetido {

	public static boolean tem_repetido(int[] v) {
		boolean tem_repetido = false;
		for(int i=0;i<v.length;i++) {
			for(int j=i+1;j<v.length;j++) {
				if(v[i] == v[j]) {
					tem_repetido = true;
					break;
				}
			}
			if(tem_repetido) {
				break;
			}
		}
		return tem_repetido;
	}
	
	public static void main(String[] args) {
		
		int[] a1 = new int[] {1,3,4,5,6,7,1};
		int[] a2 = new int[] {1,3,4,5,6,7,2};
		System.out.println(Arrays.toString(a1) + " " + tem_repetido(a1));
		System.out.println(Arrays.toString(a2) + " " + tem_repetido(a2));
	}
	
}
