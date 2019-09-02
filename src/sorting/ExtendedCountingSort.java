package sorting;

import java.util.Arrays;

public class ExtendedCountingSort {

	public static void sort(int[] v) {
		
		//Salva o menor e maior valores
		int biggest_value=v[0];
		int lowest_value =v[0];
		
		for(int i=0;i<v.length;i++) {
			if(v[i]>biggest_value) {
				biggest_value = v[i];
			}
			if(v[i]<lowest_value) {
				lowest_value = v[i];
			}
		}
		
		//Define a amplitude dos valores existentes no vetor
		int range = biggest_value - lowest_value;
		
		//Cria o vetor de frequência com o tamanho da amplitude+1, para que contenha todos os
		//valores existentes no vetor
		int[] frequency = new int[range+1];
		
		//Cria um normalizador, que será responsável por normalizar o posicionamento dos valores
		//no vetor de frequência
		int normalizer = lowest_value*(-1);
		
		//Faz a contagem de elementos existentes no vetor de entrada, salvando suas ocorrências
		//no vetor de frequência
		for(int i=0;i<v.length;i++) {
			frequency[normalizer+v[i]] += 1;
		}
		
		//Torna o vetor de frequência em cumulativo
		for(int i=1;i<frequency.length;i++) {
			frequency[i]+=frequency[i-1];
		}
		
		//Cria o vetor que será o ordenado
		int[] ordered_array = new int[v.length];
		
		//Distribui valores de frequência no array ordenado
		for(int i=v.length-1;i>-1;i--) {
			ordered_array[frequency[v[i]+normalizer]-1] = v[i];
			frequency[v[i]+normalizer]-=1;
		}
		
		//Redefine v pelo vetor ordenado
		for(int i=0;i<v.length;i++) {
			v[i]=ordered_array[i];
		}
	}
	
	public static void main(String[] args) {
		
		int[] v = new int[] {-40,0,120,120,120,-3,45,-6,-100,3243,34};
		
		System.out.println("Desordenado: " + Arrays.toString(v));
		sort(v);
		System.out.println("Ordenado: " + Arrays.toString(v));

	}

}
