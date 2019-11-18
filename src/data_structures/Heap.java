package data_structures;

public class Heap {

	private int[] heap;
	private int tail;
	
	public Heap(int capacity) {
		this.heap = new int[capacity];
		this.tail = -1;
	}
	
	public Heap(int[] heap) {
		this.heap = heap;
		this.tail = this.heap.length-1;
		this.buildHeap(heap);
	}
	
	//Resize não implementado
	//Não existem valores guardados em índices maiores que a tail
	//Inserção sempre é feita na próxima posição livre do array, isto é, tail + 1
	//A remoção no Heap sempre acontece na raiz
	
	public boolean isEmpty() {
		return this.tail == -1;
	}
	
	public boolean isFull() {
		return this.tail == this.heap.length-1;
	}
	
	private int getLeft(int index) {
		return (2*index) + 1;
	}
	
	private int getRight(int index) {
		return 2*(index + 1);
	}
	
	private int getParent(int index) {
		return (index - 1)/2;
	}
	
	//Se o index for maior que o índice do último pai(pai do tail), e o índice for menor
	//que ou igual a tail, então é folha.
	private boolean isLeaf(int index) {
		return index > getParent(tail) && index <= tail;
	}
	
	private boolean isValidIndex(int index) {
		return index >= 0 && index <= tail;
	}
	
	//Retorna o índice que contem o maior valor no heap
	private int getMaxIndex(int index, int left, int right) {
		
		if(this.heap[index] > this.heap[left]) {
			if(isValidIndex(right)) {
				if(this.heap[index] < this.heap[right])
					return right;
			}
			return index;
		}else {
			if(isValidIndex(right)) {
				if(this.heap[left] < this.heap[right])
					return right;
			}
			return left;
		}
		
	}
	
	//Adiciona na posição tail e confere se o nó pai é menor que o valor inserido.
	//Se o for, troca os dois e repete o processo até chegar à raiz.
	public void add(int value) {
		if(!this.isFull()) {
			tail = tail + 1;
			this.heap[tail] = value;
			
			int i = tail;
			
			while(i > 0 && this.heap[getParent(i)] < this.heap[i]) {
				int aux = this.heap[i];
				this.heap[i] = this.heap[getParent(i)];
				this.heap[getParent(i)] = aux;
				i = getParent(i);
			}	
		}
	}
	
	//Troca o valor da raiz com o da folha, remove a folha. Executa o heapify na raiz.
	//A remoção acontece assim: tail = tail -1.
	public int remove() {
		if(this.isEmpty())
			throw new RuntimeException("Empty Heap");
		
		int elementToBeRemoved = this.heap[0];
		this.heap[0] = this.heap[tail];
		this.heap[tail] = elementToBeRemoved;
		this.tail -= 1;
		
		this.heapify(0);
		
		return elementToBeRemoved;
	}
	
	//A intenção é executar o heapify sucessivas vezes começando pelo pai da última folha,
	//indo até a raiz(começa pelo pai da última folha porque o heapify não faz sentido começar
	//de uma folha.
	public void buildHeap(int[] arr) {
		for(int i = getParent(this.tail); i >= 0; i--)
			heapify(i);
	}
	
	//Compara um elemento com seus filhos e o troca com o maior dessa comparação, se nece
	//sário. O algoritmo é recursivo, o critério de parada é não possui mais filhos ou o
	//elemento se tornar o maior na comparação.
	private void heapify(int index) {
		if(isLeaf(index) || !isValidIndex(index))
			return;
		
		int indexMax = getMaxIndex(index, getLeft(index), getRight(index));
		
		//Se o index_max não for o índice do próprio index
		if(indexMax != index) {
			
			//swap entre o index e o indexMax encontrado
			int aux = this.heap[index];
			this.heap[index] = this.heap[indexMax];
			this.heap[indexMax] = aux;
			
			//Chama recursivamente para o índice pelo qual trocou, novo índice onde está o
			//valor da chamada.
			heapify(indexMax);
		}
	}
	
}
