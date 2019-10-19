package ae23;

public class DoubleLinkedList {

	private Node head;
	
	//TODO: addLast() recursivo
	
	public void addLast(int value) {
		if(this.head == null) {
			this.head = new Node(value);
		}else {			
			addLast(this.head, value);
		}
	}
	
	private void addLast(Node node, int value) {
		if(node.next == null) {
			node.next = new Node(value);
			node.next.previous = node;
		}else {
			addLast(node.next, value);
		}
	}
	
	//TODO: size() recursivo
	
	public int size() {
		return size(this.head);
	}
	
	private int size(Node node) {
		if(node == null) {
			return 0;
		}else {
			return 1 + size(node.next);
		}
	}
	
	//TODO: soma() recursivo
	
	public int soma() {
		return soma(this.head);
	}
	
	private int soma(Node node) {
		if(node == null) {
			return 0;
		}else {
			return node.value + soma(node.next);
		}
	}
	
	//TODO: isSorted() recursivo

	public boolean isSorted() {
		return isSorted(this.head);
	}
	
	private boolean isSorted(Node node) {
		if(node == null) {
			return true;
		}
		if(node.next == null) {
			return true;
		}else if(node.value <= node.next.value) {
			return isSorted(node.next);
		}
		return false;
	}
	
	//TODO: add() iterativo (Adiciona naquele índice e o que estava vai para o próximo)
	
	public void add(int index, int value) {
		if(index < size() && index >= 0) {
			
			Node newNode = new Node(value);
			Node aux = this.head;

			if(index == 0) {
				newNode.next = aux;
				aux.previous = newNode;
				this.head = newNode;
				return;
			}
			
			int counter = index;
			while(counter > 0) {
				aux = aux.next;
				
				counter--;
			}
			newNode.next = aux;
			newNode.previous = aux.previous;
			
			aux.previous.next = newNode;
			aux.previous = newNode;
		}
	}
	
	//TODO: remove() iterativo
	
	public void remove(int index) {
		if(index < size()) {
			
			int counter = index;
			Node aux = this.head;
			
			while(counter > 0) {
				aux = aux.next;
				
				counter--;
			}
			
			if(aux != this.head) {
				aux.previous.next = aux.next;
			
				if(aux.next != null) {		
					aux.next = aux.previous;
				}
			}else {
				if(this.head != null) {
					this.head = this.head.next;
					if(this.head != null) {						
						this.head.previous = null;
					}
				}
			}
			
		}
	}
	
	public String toString() {
		String str = "";
		
		Node aux = this.head;
		while(aux != null) {
			str += aux.value + ", ";
			aux = aux.next;
		}
		if(str.length()>=2) {
			return "[" + str.substring(0, str.length()-2) + "]";			
		}
		return "[" + str + "]";
	}
}

class Node {
	
	int value;
	Node previous;
	Node next;
	
	public Node(int value) {
		this.value = value;
	}	
}
