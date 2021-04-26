public class ArvoreBinaria{

	private No raiz;
	private int alturaDaArvore;
	private int quantidadeDeNos;
	@SuppressWarnings("unused")
	private int alturaEsquerda;
	@SuppressWarnings("unused")
	private int alturaDireita;

	public ArvoreBinaria() {
		this.alturaDaArvore = 0;
	}

	public void informacoesDoNo(No noPesquisado) {
		System.out.println("O Grau do nó selecionado é: " + grauDoNo(noPesquisado));
		System.out.println("A Profundidade do No Escolhido é: " + noPesquisado.getProfundidade());
		System.out.println("A Altura do Nó selecionado é: " + alturaDoNo(noPesquisado));
		System.out.println("O Nivel do Nó em questão é: " + noPesquisado.nivelNo());
		System.out.println("O No escolhido é no folha? " + noFolha(noPesquisado)); 
		System.out.println();
	}


	public int alturaDoNo(No noPesquisado) {

		if (noPesquisado.getNoFilhoDireito() == null && noPesquisado.getNoFilhoEsquerdo() == null) {
			return 0;
		} else if (noPesquisado.noFilhoDireito == null) {
			return alturaDoNo(noPesquisado.noFilhoEsquerdo) + 1;
		} else if (noPesquisado.noFilhoEsquerdo == null) {

			return alturaDoNo(noPesquisado.noFilhoDireito) + 1;
		} else {
			return Math.max(alturaDoNo(noPesquisado.noFilhoEsquerdo),
					alturaDoNo(noPesquisado.noFilhoDireito) + 1 );
		}
	}

	private void inserirRaiz(No novo) {
		if (this.raiz == null) {
			this.raiz = novo;
			this.raiz.setProfundidade(0);
			System.out.println("O Nó escolhido foi transformado em Raiz!");
		} else {
			System.out.println("Já existe um nó raiz!");
		}
	}

	public boolean noFolha(No no) {
		if (
				no.noFilhoDireito == null &&
				no.noFilhoEsquerdo == null) {
			return true;
		}
		return false;
	}

	public int grauDoNo(No no) {
		int contador = 0;
		if (no.getDado() == 0) {
			System.out.print("Nó Vazio");
			contador = 0;
		} else {
			if (no.noFilhoDireito != null) {
				contador++;
			}
			if (no.noFilhoEsquerdo != null) {
				contador++;
			}
		}
		return contador;
	}

	private void inserirNaEsquerda(No novo, No pai) {
		if (pai.getDado() == raiz.getDado()) {
			if (pai.noFilhoEsquerdo == null) {
				raiz.setNoFilhoEsquerdo(novo);
				novo.setPai(pai);
				novo.setProfundidade(pai.getProfundidade() + 1);
				if (this.alturaDaArvore < novo.getProfundidade()) {
					this.alturaDaArvore = novo.getProfundidade();
				}
				System.out.println("O Nó " + novo.getDado() + " Foi inserido a Esquerda da Raiz e tem Profundidade: "
						+ novo.getProfundidade());
			} else {
				inserirNaEsquerda(novo, pai.noFilhoEsquerdo);
			}
		} else {
			if (pai.noFilhoEsquerdo == null) {
				pai.setNoFilhoEsquerdo(novo);
				novo.setPai(pai);
				novo.setProfundidade(pai.getProfundidade() + 1);
				if (this.alturaDaArvore < novo.getProfundidade()) {
					this.alturaDaArvore = novo.getProfundidade();
				}
				System.out.println("O Nó " + novo.getDado() + " Foi inserido"
						+" a Esquerda do Nó " + pai.getDado() + ", "
						+"E tem profundidade: " + novo.getProfundidade());
			} else {
				novo.setProfundidade(pai.getProfundidade() + 1);
				inserirNaEsquerda(novo, pai.noFilhoEsquerdo);
			}
		}
	}

	private void inserirNaDireita(No novo, No pai) {
		if (pai.getDado() == raiz.getDado()) {
			if (pai.noFilhoDireito == null) {
				raiz.setNoFilhoDireito(novo);
				novo.setPai(pai);
				novo.setProfundidade(pai.getProfundidade() + 1);
				if (this.alturaDaArvore < novo.getProfundidade()) {
					this.alturaDaArvore = novo.getProfundidade();
				}
				System.out.println("O Nó " + novo.getDado() + " Foi inserido a Direita da Raiz e tem profundidade: "
						+ novo.getProfundidade());
			} else {
				inserirNaDireita(novo, pai.noFilhoDireito);
			}
		} else {
			if (pai.noFilhoDireito == null) {
				pai.setNoFilhoDireito(novo);
				novo.setPai(pai);
				novo.setProfundidade(pai.getProfundidade() + 1);
				if (this.alturaDaArvore < novo.getProfundidade()) {
					this.alturaDaArvore = novo.getProfundidade();
				}
				System.out.println("O Nó " + novo.getDado() + " Foi inserido"
						+" a Direita do Nó " + pai.getDado() + ", "
						+"E tem profundidade: " + novo.getProfundidade());
			} else {
				novo.setProfundidade(pai.getProfundidade() + 1);
				inserirNaDireita(novo, pai.noFilhoDireito);
			}
		}
	}

	public void inserir (No novo) {		
		if (this.raiz == null) {
			inserirRaiz(novo);
			this.quantidadeDeNos++;
		} else {
			inserir(novo, this.raiz);
		}
	}

	private void inserir(No novo, No pai) {
		if (novo.getDado() < pai.getDado()) {
			if (pai.getNoFilhoEsquerdo() == null) {
				inserirNaEsquerda(novo, pai);
				this.quantidadeDeNos++;
			} else {
				inserir(novo, pai.getNoFilhoEsquerdo());
			}
		} else {
			if (pai.getNoFilhoDireito() == null) {
				inserirNaDireita(novo, pai);
				this.quantidadeDeNos++;
			} else {
				inserir(novo, pai.getNoFilhoDireito());
			}
		}
	}

	public void removerNo(int x) {
		// Procurar Nó com valor
		No no = procurarNo(x, raiz);
		if (no == null) {
			return;
		}
		// Procurar próximo que pode ser colocado para cima
		No proximo = proximoSemFilhos(no);


		// Se já nó a ser removido for raiz, raiz será o próximo
		if (raiz == no) {
			raiz = proximo;

			// Se não, mudar conexão do pai de nó para o próximo
		} else {
			if (no.pai.noFilhoEsquerdo == no) {
				no.pai.noFilhoEsquerdo = proximo;
			} else {
				no.pai.noFilhoDireito = proximo;
			}
		}

		// Remover conexão do pai de próximo com próximo
		if (proximo.pai.noFilhoEsquerdo == proximo) {
			proximo.pai.noFilhoEsquerdo = null;
		} else {
			proximo.pai.noFilhoDireito = null;
		}

		// Copiar conexões de pai para próximo 
		proximo.pai = no.pai;
		proximo.noFilhoDireito = no.noFilhoDireito;
		proximo.noFilhoEsquerdo = no.noFilhoEsquerdo;

		// Altera conexões dos filhos de nó
		if (no.noFilhoDireito != null) {
			no.noFilhoDireito.pai = proximo;
		}
		if (no.noFilhoEsquerdo != null) {
			no.noFilhoEsquerdo.pai = proximo;
		}

		// Remover conxeões de nó
		no.pai = null;
		no.noFilhoDireito = null;
		no.noFilhoEsquerdo = null;
	}

	public No procurarNo(int x, No no) {
		if (no.getDado() == x) {
			return no;
		} else {
			if (no.noFilhoEsquerdo != null) {
				No p = procurarNo(x, no.noFilhoEsquerdo);
				if (p != null) {
					return p;
				}
			} 


			if (no.noFilhoDireito != null) {
				No p = procurarNo(x, no.noFilhoDireito);
				if (p != null) {
					return p;
				}
			} 


			return (No) null;
		}
	}

	public No proximoSemFilhos(No no) {
		if (no.noFilhoEsquerdo != null) {
			return proximoSemFilhos(no.noFilhoEsquerdo);
		} else if (no.noFilhoDireito != null) {
			return proximoSemFilhos(no.noFilhoDireito);
		} else {
			return no;
		}
	}



	public ArvoreBinariaDeBusca paraArvoreDeBusca() {
		ArvoreBinariaDeBusca arvore = new ArvoreBinariaDeBusca();
		arvore.adicionar(raiz.dado, raiz.dado);
		recAdicionar(arvore, raiz);

		return arvore;
	}

	private void recAdicionar(ArvoreBinariaDeBusca arvore, No no) {
		if (no.noFilhoEsquerdo != null) {
			arvore.adicionar(no.noFilhoEsquerdo.dado, no.noFilhoEsquerdo.dado);
			recAdicionar(arvore, no.noFilhoEsquerdo);
		}

		if (no.noFilhoDireito != null) {
			arvore.adicionar(no.noFilhoDireito.dado, no.noFilhoDireito.dado);
			recAdicionar(arvore, no.noFilhoDireito);
		}
	}



	//trecho de codigo adicionado, nao é necessario passar a raiz no main
	public void imprimirEmOrdemSimetrica() {
		imprimirEmOrdemSimetrica(raiz);
		System.out.println();
	}

	private void imprimirEmOrdemSimetrica(No raiz) {
		if (raiz.noFilhoEsquerdo != null) {
			imprimirEmOrdemSimetrica(raiz.noFilhoEsquerdo);
		} 
		System.out.print(raiz.getDado() + " ");

		if (raiz.noFilhoDireito != null) {
			imprimirEmOrdemSimetrica(raiz.noFilhoDireito);
		}
	}

	//trecho de codigo adicionado, nao é necessario passar a raiz no main
	public void imprimirPosOrdem() {
		imprimirPosOrdem(raiz);
		System.out.println();
	}

	private void imprimirPosOrdem (No raiz) {
		if (raiz.noFilhoEsquerdo != null) {
			imprimirPosOrdem(raiz.noFilhoEsquerdo);
		} 
		if (raiz.noFilhoDireito != null) {
			imprimirPosOrdem(raiz.noFilhoDireito);
		}

		System.out.print(raiz.getDado() + " ");
	}

	//trecho de codigo adicionado, nao é necessario passar a raiz no main
	public void imprimirPreOrdem() {
		imprimirPreOrdem(raiz);
		System.out.println();
	}

	private void imprimirPreOrdem (No raiz) {
		System.out.print(raiz.getDado() + " ");

		if (raiz.noFilhoEsquerdo != null) {
			imprimirPreOrdem(raiz.noFilhoEsquerdo);
		} 
		if (raiz.noFilhoDireito != null) {
			imprimirPreOrdem(raiz.noFilhoDireito);
		}

	}

	public void imprimirMenores() {
		imprimirMenores(raiz.noFilhoEsquerdo);
	}

	//metodo para exibir os menores valores da abb, sempre os mais a esquerda.
	private void imprimirMenores(No raiz) {
		if (raiz.noFilhoEsquerdo != null) {
			imprimirMenores(raiz.noFilhoEsquerdo);
		} 
		System.out.print(raiz.getDado() + " ");

		if (raiz.noFilhoDireito != null) {
			imprimirMenores(raiz.noFilhoDireito);
		}
	}


	public boolean cheio() {
		if (raiz != null) {
			return recCheio(raiz);
		}

		return true;
	}

	//verifica de forma recursiva se a arvore é cheia ou nao. retornando true or false.
	public boolean recCheio(No no) {
		if (no.noFilhoDireito == null && no.noFilhoEsquerdo == null) {
			return true; 
		} else if (no.noFilhoDireito != null && no.noFilhoEsquerdo != null) {
			return recCheio(no.noFilhoDireito) && recCheio(no.noFilhoEsquerdo); 
		}

		return false;
	}

	public void imprimirPaieFilhoMaior() {
		imprimirPaieFilhoMaior(raiz);
		System.out.println();
	}


	//metodo de busca de pai e folha com maior valor
	public void imprimirPaieFilhoMaior(No raiz) {
		if (raiz.noFilhoEsquerdo != null) {
			imprimirPaieFilhoMaior(raiz.noFilhoEsquerdo);
		} 
		if (raiz.noFilhoDireito != null) {
			imprimirPaieFilhoMaior(raiz.noFilhoDireito);
		}

		if (noFolha(raiz)) {

		} else {
			if (raiz.noFilhoDireito == null) {
				System.out.print("No Pai: " + raiz.getDado() + " No filho Maior: " + raiz.getNoFilhoEsquerdo().getDado());
				System.out.println();
			} else {
				System.out.print("No Pai: " + raiz.getDado() + " No filho Maior: " + raiz.getNoFilhoDireito().getDado());
				System.out.println();
			}
		}	
	}

	public int getQuantidadeDeNos() {
		return quantidadeDeNos;
	}

	public No getRaiz() {
		return raiz;
	}

	public int getAlturaDaArvore() {
		return alturaDaArvore;
	}
}