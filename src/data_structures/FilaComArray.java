package data_structures;

import java.util.Scanner;

public class FilaComArray {

	private int size;
	private int[] array;
	private int tail;
	
	FilaComArray(int size){
		this.array = new int[size];
		this.size = size;
		this.tail = -1;
	}
	
	public boolean isEmpty() {
		return (this.tail == -1);
	}
	
	public boolean isFull() {
		return (this.tail == this.size-1);
	}
	
	public void add(int x) {
		if(!this.isFull()) {
			this.array[++this.tail] = x;
		}
	}
	
	public void shiftLeft() {
		for(int i=0;i<this.tail;i++) {
			this.array[i] = this.array[i+1];
		}
		this.tail--;
	}
	
	public int getHead() {
		if(this.isEmpty()) {
			throw new RuntimeException("empty");
		}
		return this.array[0];
	}
	
	public void remove() {
		if(!this.isEmpty()) {
			this.shiftLeft();
		}
	}
	
	public String print() {
		String str = "";
		
		if(this.isEmpty()) {
			return "empty";
		}else {
			for(int i=0;i<=this.tail;i++) {
				str += this.array[i] + " ";
			}
		}
		
		return str.substring(0, str.length()-1);
	}
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		String comando;
		
			int tamanho = sc.nextInt();
			FilaComArray fca = new FilaComArray(tamanho);
		do {			
			String entrada = sc.nextLine();
			comando = entrada.split(" ")[0];
			
			switch(comando) {
			case "print":
				System.out.println(fca.print());
				break;
			
			case "element":
				if(fca.isEmpty()) {
					System.out.println("empty");
				}else {
					System.out.println(fca.getHead());						
				}
				break;
			
			case "remove":
				if(fca.isEmpty()) {
					System.out.println("empty");
				}
				else {
					fca.remove();
				}
				break;
			
			case "add":
				if(fca.isFull()) {
					System.out.println("full");
				}else {
					int elemento = Integer.parseInt(entrada.split(" ")[1]);
					fca.add(elemento);
				}
				break;
		}
		
	}while(!comando.equals("end"));
		sc.close();
	}
}
