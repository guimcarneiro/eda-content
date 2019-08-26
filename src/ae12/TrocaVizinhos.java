package ae12;

import java.util.Arrays;

public class TrocaVizinhos {

	public static void troca_vizinhos(int[] v) {
		for(int i=0;i<v.length;i+=2) {
			if(i+1 < v.length) {
				int aux = v[i+1];
				v[i+1] = v[i];
				v[i] = aux;
			}
		}
	}
	
	public static void main(String[] args) {
		
		int[] v = new int[] {1, 13, 3, 4, 5};
		
		System.out.println(Arrays.toString(v));
		troca_vizinhos(v);
		System.out.println(Arrays.toString(v));
		
	}
	
}
