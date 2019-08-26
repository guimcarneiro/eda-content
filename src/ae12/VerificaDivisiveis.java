package ae12;

import java.util.Arrays;

public class VerificaDivisiveis {

	public static boolean verifica_divisiveis(int[] v) {
		boolean ehDivisivel = false;
		for(int i=0;i<v.length-1;i++) {
			for(int j=i+1;j<v.length;j++) {
				if(v[j]%v[i] == 0 || v[i]%v[j] == 0) {
					ehDivisivel = true;
					break;
				}
			}
			if(ehDivisivel) {
				break;
			}
		}
		return ehDivisivel;
	}
	
	public static void main(String[] args) {
		
		int[] v = new int[] {5, 13, 3, 4, 8};
		System.out.println(Arrays.toString(v)+" "+ verifica_divisiveis(v));
		
		int[] v1 = new int[] {5, 13, 3, 4, 7};
		System.out.println(Arrays.toString(v1)+" "+ verifica_divisiveis(v1));
		
		int[] v2 = new int[] {5, 13, 3, 8, 4};
		System.out.println(Arrays.toString(v2)+" "+ verifica_divisiveis(v2));
		
	}

}
