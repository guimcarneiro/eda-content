package general;

import java.util.Arrays;

public class BuscaBinaria {

	public static int buscaBinaria(int[] v, int n, int index_inicio, int index_fim) {
		//Define elemento do meio a ser testado se é o que se procura
		int index_meio = (index_inicio + index_fim)/2;
		//Confere se o indice inicial já se tornou maior que o indice final, o que
		//quer dizer que não existe o item procurado no array
		if(index_inicio > index_fim) {
			return -1;
		}
		//testa se o elemento central é o que se procura
		if(v[index_meio] == n) {
			return index_meio;
		}
		//testa se o valor central é maior ou menor que o que se procura, para 
		//redefinir o intervalo de busca na próxima iteração
		if(v[index_meio] < n) {
			return buscaBinaria(v,n, index_meio+1, index_fim);
		}else {
			return buscaBinaria(v,n, index_inicio, index_meio-1);
		}
	}
	
	public static void main(String[] args) {
		
		int[] v = new int[] {1,2,3,4,5,6};
		
		System.out.println(Arrays.toString(v));
		System.out.println("Índice do 4 no array: " + buscaBinaria(v,4,0, v.length-1));
		
	}
	
}
