package ae12;

public class VetorCircular {

	public static String vetorCircular(int[] array, int quantidadeElementos) {
		
		String saida = "";
		for(int i=0;i<quantidadeElementos;i++) {
			saida += " " + array[i%array.length];
		}
		return saida;
	}
	
	public static void main(String[] args) {
		int[] vetor = new int[] {4, 5, 6, 1};
		System.out.println(vetorCircular(vetor, 6));
	}
	
}
