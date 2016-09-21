
public class Pilha {
	
	private Object[] elementos;
	private int tamanho = 0;

	public Pilha(int maximo) {
		this.elementos = new Object[maximo];
	}

	public boolean estaVazia() {		
		return this.tamanho == 0;
	}

	public int tamanho() {		
		return this.tamanho;
	}

	public void empilhar(Object elemento) {
		if(tamanho == elementos.length)
			throw new PilhaCheiaException(elemento);
		
		this.elementos[tamanho] = elemento;		
		this.tamanho++;
	}

	public Object topo() {
		return this.elementos[tamanho-1];
	}

	public Object desempilhar() {
		if(this.tamanho == 0)
			throw new PilhaVaziaException();
		
		this.tamanho--;
		return this.elementos[tamanho];
	}

}
