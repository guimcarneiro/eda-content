package data_structures;

import java.util.Scanner;

public class DoubleLinkedList {

	private Node head;
	
	public DoubleLinkedList() {
		this.head = null;
	}
	
	public boolean isEmpty() {
		return (this.head == null);
	}
	
	public void addLast(int value) {
		Node newNode = new Node(value);
		
		if(this.isEmpty()) {
			this.head = newNode;
		}else {
			Node aux = this.head;
			while(aux.next != null) {
				aux = aux.next;
			}			
			aux.next = newNode;
			newNode.previous = aux;
		}
	}
	
	public void removeFirst() {
		if(!this.isEmpty()) {
			if(this.head.next == null) {
				this.head = null;
			}else {
				this.head = this.head.next;
				this.head.previous = null;
			}
		}
	}
	
	public int getHead() {
		return this.head.value;
	}
	
	public int search(int value) {
		if(this.isEmpty()) {
			return -1;
		}else if(this.head.value == value){
			return 0;
		}else {
			Node aux = this.head;
			int i=0;
			boolean found = false;
			
			while(aux.next != null && aux.value != value) {
				i++;
				aux = aux.next;
				if(aux.value == value) {
					found = true;
				}
			}
			
			if(found) {
				return i;
			}
			return -1;
		}
	}
	
	public String print() {
		return this.print(this.head).trim();
	}
	
	private String print(Node n) {
		if(n == null) {
			return "";
		}
		return n.value + " " + print(n.next);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String entrada;
		
		DoubleLinkedList dll = new DoubleLinkedList();
		
		do {
			entrada = sc.nextLine();
			String comando = entrada.split(" ")[0];
			
			switch(comando) {
			case "print":
				if(dll.isEmpty()) {
					System.out.println("empty");
				}else {
					System.out.println(dll.print());
				}
				break;
			case "element":
				if(dll.isEmpty()) {
					System.out.println("empty");
				}else {
					System.out.println(dll.getHead());
				}
				break;
			case "search":
				System.out.println(dll.search(Integer.parseInt(entrada.split(" ")[1])));
				break;
			case "remove":
				if(dll.isEmpty()) {
					System.out.println("empty");
				}else {
					dll.removeFirst();
				}
				break;
			case "add":
				dll.addLast(Integer.parseInt(entrada.split(" ")[1]));
				break;
			}
		}while(!entrada.equals("end"));
	}
	
}

class Node {
	
	int value;
	Node next;
	Node previous;
	
	public Node(int value) {
		this.value = value;
		this.next = null;
		this.previous = null;
	}
	
}