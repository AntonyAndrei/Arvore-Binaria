public class ArvoreBinariaDeBusca {
	private class No {
		Integer valor;
		int  chave;
		No esquerdo;
		No direito;

		No(Integer valor, int chave) {
			this.valor = valor;
			this.chave = chave;
		}
	}

	private No raiz;
	@SuppressWarnings("unused")
	private int tamanho;

	public ArvoreBinariaDeBusca() {
		super();
		this.tamanho = 0;
	}

	//adicionar ABB comum
	public void adicionar(int chave, Integer valor) {
		this.tamanho++;

		if (raiz == null) { 
			raiz = new No (valor, chave);
		} else {
			No atual = raiz;

			while (true) {
				if (chave < atual.chave) {
					if (atual.esquerdo == null) {
						atual.esquerdo = new No (valor, chave);
						break;
					} else {
						atual = atual.esquerdo;
					}
				} else if (chave > atual.chave) {
					if (atual.direito == null) {
						atual.direito = new No (valor, chave);
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

	public void imprimirEmOrdemSimetrica() {
		imprimirEmOrdemSimetrica(raiz);
		System.out.println();
	}

	private void imprimirEmOrdemSimetrica(No raiz) {
		if (raiz.esquerdo != null) {
			imprimirEmOrdemSimetrica(raiz.esquerdo);
		} 
		System.out.print(raiz.valor.toString() + " ");

		if (raiz.direito != null) {
			imprimirEmOrdemSimetrica(raiz.direito);
		}
	}

	//metodo de geraçao de arvore atraves de nós parametros
	public void adicionarInOrdem(int[] listaInOrdem) {
		for (int i : listaInOrdem) {
			this.adicionar(i, i);
		}
	}

	//metodo de geraçao de arvore atraves de nós parametros
	public void adicionarPreOrdem(int[] listaPreOrdem) {
		this.adicionarInOrdem(listaPreOrdem);
	}

	//metodo de geraçao de arvore atraves de nós parametros
	public void adicionarPosOrdem(int[] listaPosOrdem) {
		for (int i=listaPosOrdem.length-1; i>=0; i--) {
			this.adicionar(listaPosOrdem[i], listaPosOrdem[i]);
		}
	}
}