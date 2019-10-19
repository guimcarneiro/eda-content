package data_structures;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BinarySearchTree {

	private BstNode root;
	
	
	private boolean isEmpty() {
		return (this.root == null);
	}
	
	public void add(int value) {
		if(isEmpty()) {
			this.root = new BstNode(value);
		}else {
			this.root.add(value);
		}
	}
	
	public String getMaxPath() {
		String path = "";
		if(!isEmpty()) {
			int max = this.root.getValue();
			
			BstNode auxNode = this.root;
			
			while(auxNode.getDireita() != null) {
				path += auxNode.getValue() + " ";
				auxNode = auxNode.getDireita();
			}
			
			path += auxNode.getValue();
		}
		
		return path;
	}
	
	public int getHeight() {
		return getHeight(this.root);
	}
	
	private int getHeight(BstNode node) {
		
		if(node.getDireita() == null && node.getEsquerda() == null) {
			return 0;
		} else {
			if(node.getDireita() == null) {
				return 1 + getHeight(node.getEsquerda());
			}else if(node.getEsquerda() == null) {
				return 1 + getHeight(node.getDireita());
			}else {
				return 1 + Math.max(getHeight(node.getEsquerda()), getHeight(node.getDireita()));
			}
		}
		
	}
	
	public String bfs() {
		String saida = "";
		if(!isEmpty()) {
			Deque<BstNode> fila = new LinkedList<BstNode>();
			
			fila.addLast(this.root);
			
			while(!fila.isEmpty()) {
				BstNode auxNode = fila.removeFirst();
				saida += auxNode.getValue() + " ";
			
				if(auxNode.getEsquerda() != null) {
					fila.addLast(auxNode.getEsquerda());
				}
			
				if(auxNode.getDireita() != null) {
					fila.addLast(auxNode.getDireita());
				}
			}	
		}
		return saida.substring(0, saida.length()-1);
	}
	
	public String getSearchPath(int value) {
		String path = "";
		if(!isEmpty()) {
			BstNode auxNode = this.root;
			
			while(auxNode != null) {
				if(auxNode.getValue() > value) {
					path += auxNode.getValue() + ", ";
					auxNode = auxNode.getEsquerda();
				}else if(auxNode.getValue() < value) {
					path += auxNode.getValue() + ", ";
					auxNode = auxNode.getDireita();
				} else {
					path += auxNode.getValue() + ", ";
					break;
				}
			}
		}
		
		return "["+path.substring(0, path.length()-2)+"]";
	}
	
	public static void main(String[] args) {
		
		BinarySearchTree bst = new BinarySearchTree();
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] arrayStr = str.split(" ");
		
		for(int i=0; i < arrayStr.length; i++) {
			bst.add(Integer.parseInt(arrayStr[i]));
		}
		
		System.out.println(bst.bfs());
		
	}

}

class BstNode {
	
	
	int value;
	BstNode esquerda;
	BstNode direita;
	
	public BstNode (int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public BstNode getEsquerda() {
		return esquerda;
	}

	private void setEsquerda(BstNode esquerda) {
		this.esquerda = esquerda;
	}
	
	public BstNode getDireita() {
		return direita;
	}

	private void setDireita(BstNode direita) {
		this.direita = direita;
	}
	
	public void add(int value) {
		if(value > this.value) {
			if(this.direita == null) {
				this.direita = new BstNode(value);
			}else {
				this.direita.add(value);
			}
		}else if(value < this.value) {
			if(this.esquerda == null) {
				this.esquerda = new BstNode(value);
			}else {
				this.esquerda.add(value);
			}
		}
	}
}
