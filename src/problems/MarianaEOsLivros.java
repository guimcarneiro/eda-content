package problems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * fonte: http://tst-eda.splab.ufcg.edu.br/#!/app/activity/mariana_e_os_livros
 * 
 * @author guimcarneiro
 *
 */
public class MarianaEOsLivros {

	//Use Insertion Sort to sort books in alphabetic order.
	
	public static void sort(String[] books) {
		for(int i=0;i<books.length;i++) {
			String book_atual = books[i];
			int j = i-1;
			while(j >= 0 && (book_atual.compareToIgnoreCase(books[j]) < 0)) {
				books[j+1]=books[j];
				j--;
			}
			books[j+1]=book_atual;
			System.out.println(Arrays.toString(books).substring(1, Arrays.toString(books).length()-1));
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] arrayStr = sc.nextLine().split(",");
		sort(arrayStr);
	}
}
