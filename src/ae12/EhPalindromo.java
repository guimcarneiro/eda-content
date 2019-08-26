package ae12;

public class EhPalindromo {

	public static boolean ehPalindromo(char[] palavra) {
		boolean ehPalindromo = true;
		for(int i=0,j=palavra.length-1;i<j;i++,j--) {
			if(palavra[i] != palavra[j]) {
				ehPalindromo = false;
				break;
			}
		}
		return ehPalindromo;
	}
	
	public static void main(String[] args) {
		char[] palavra = new char[] {'a', 'b', 'c'};
		System.out.println(ehPalindromo(palavra));
		
		char[] palavra2 = new char[] {'a', 'b', 'a'};
		System.out.println(ehPalindromo(palavra2));
		
		char[] palavra3 = new char[] {'a', 'b','b', 'a'};
		System.out.println(ehPalindromo(palavra3));
		
		char[] palavra4 = new char[] {'a', 'b','c', 'a'};
		System.out.println(ehPalindromo(palavra4));
	}
	
}
