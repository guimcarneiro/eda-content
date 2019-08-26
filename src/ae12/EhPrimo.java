package ae12;

public class EhPrimo {

	public static boolean eh_primo(int n) {
		boolean ehPrimo = true;
		if(n != 1) {
			for(int i=2;i<n;i++) {
				if(n%i == 0) {
					ehPrimo = false;
					break;
				}
			}
		}
		return ehPrimo;
	}
	
	public static void main(String[] args) {
		
		int a = 3, b = 7, c = 10, d = 11;
		System.out.println(a + " " + eh_primo(a));
		System.out.println(b + " " + eh_primo(b));
		System.out.println(c + " " + eh_primo(c));
		System.out.println(d + " " + eh_primo(d));
	}

}
