package problems;

import java.util.Arrays;


//Melhor fazer 
public class ContaOcorrenciasBinarySearch {

	public int contaOcorrencias(int[] v, int x, int leftIndex, int rightIndex) {
		int comeco = primeiraOcorrencia(v, x, leftIndex, rightIndex);
		if(comeco != -1) {
			int fim = ultimaOcorrencia(v, x, leftIndex, rightIndex);
			return fim - comeco + 1;
		}
		return comeco;
	}
	
	private int primeiraOcorrencia(int[] v, int x, int leftIndex, int rightIndex) {
		int bordaInferior = -1;
		
		while(leftIndex<=rightIndex) {
			int meio = (leftIndex + rightIndex)/2;
			
			if((meio == 0 || v[meio-1]<x) && v[meio]==x) {
				System.out.println("entrou no meio");
				bordaInferior = meio;
				leftIndex = rightIndex + 1;
			} else if(x < v[meio]) {
				rightIndex = meio-1;
			}else {
				leftIndex = meio+1;
			}
		}
		return bordaInferior;
	}
	
	private int ultimaOcorrencia(int[] v, int x, int leftIndex, int rightIndex) {
		while(leftIndex<=rightIndex) {
			int meio = (leftIndex + rightIndex)/2;
			if((meio == v.length-1 || v[meio+1]>x) && v[meio]==x) {
				return meio;
			} else if(x < v[meio]) {
				rightIndex = meio-1;
			}else {
				leftIndex = meio+1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		
		ContaOcorrenciasBinarySearch cobs = new ContaOcorrenciasBinarySearch();
		
		int[] arrayOrd = new int[] {1,1,1,4,4,4,5,5,5,5,5,7,8,9,10,10,11,13,13,13,13,13,13};
		System.out.println(Arrays.toString(arrayOrd));
		int numTeste = 4;
		System.out.println("O número "+numTeste+" aparece " + cobs.contaOcorrencias(arrayOrd, numTeste, 0, arrayOrd.length-1) + " vezes");
		
	}
}
