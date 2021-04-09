import java.util.Stack;

public class ArvoreBinariaDeBusca<Tipo> {
	private class No<Tipo> {
		Tipo valor;
		int  chave;
		
		No<Tipo> esquerdo;
		No<Tipo> direito;
		
		No(Tipo valor, int chave) {
			this.valor = valor;
			this.chave = chave;
		}
	}
	
	
	private No<Tipo> raiz;
	private int tamanho;
	
	public ArvoreBinariaDeBusca() {
		super();
		this.tamanho = 0;
	}
	
	public void adicionar(int chave, Tipo valor) {
		this.tamanho++;
		
		if (raiz == null) { 
			raiz = new No<Tipo>(valor, chave);
		} else {
			No<Tipo> atual = raiz;

			while (true) {
				if (chave < atual.chave) {
					if (atual.esquerdo == null) {
						atual.esquerdo = new No<Tipo>(valor, chave);
						break;
					} else {
						atual = atual.esquerdo;
					}
				} else if (chave > atual.chave) {
					if (atual.direito == null) {
						atual.direito = new No<Tipo>(valor, chave);
						break;
					} else {
						atual = atual.direito;
					}
				} else {
					atual.valor = valor;
					break;
				}
			}
			
		}
	}	
}
