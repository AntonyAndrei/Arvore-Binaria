
public class Main {

	public static void main(String[] args) {

		//inserção de nós na Arvore Binaria sem modificação
		No no300 = new No(300);
		No no280 = new No(280);
		No no2 = new No(2);
		No no1 = new No(1);
		No no299 = new No(299);
		No no305= new No(305);
		No no302 = new No(302);
		No no475 = new No(475);
		No no472 = new No(472);
		No no476 = new No(476); 

		//Vetor de nós para inserção nas ordens solicitadas.
		int[] listaInOrdem = {1,2,280,299,300,302,305,472,475,476};
		int[] listaPreOrdem = {300,280,2,1,299,305,302,475,472,476};
		int[] listaPosOrdem = {1,2,299,280,302,472,476,475,305,300};

		ArvoreBinaria arvore = new ArvoreBinaria();

		//instanciaçao da arvore abb modificada para inserir os nós como parametro
		ArvoreBinariaDeBusca arvoreB = new ArvoreBinariaDeBusca();
		ArvoreBinariaDeBusca arvoreC = new ArvoreBinariaDeBusca();
		ArvoreBinariaDeBusca arvoreD = new ArvoreBinariaDeBusca();

		//adiciona a lista de nós na arvore
		arvoreB.adicionarInOrdem(listaInOrdem);
		arvoreC.adicionarPosOrdem(listaPosOrdem);
		arvoreD.adicionarInOrdem(listaPreOrdem);

		//inserção dos valores na arvore nao modificada
		arvore.inserir(no300);
		arvore.inserir(no280);
		arvore.inserir(no2);
		arvore.inserir(no1);
		arvore.inserir(no299);
		arvore.inserir(no305);
		arvore.inserir(no302);
		arvore.inserir(no475);
		arvore.inserir(no472);
		arvore.inserir(no476); 

		/*
		System.out.println();
		arvore.informacoesDoNo(no300);

		System.out.println("A Altura da Arvore é: " + arvore.getAlturaDaArvore());

		System.out.println();
		System.out.println("A Quantidade de Nós da arvore é: " + arvore.getQuantidadeDeNos());
		System.out.println();

		System.out.println("Pos Ordem: (LRN)");
		arvore.imprimirPosOrdem();
		System.out.println();
		System.out.println("Pre Ordem: (NLR)");
		arvore.imprimirPreOrdem();
		System.out.println();
		System.out.println("Ordem simetrica: (LNR)");
		arvore.imprimirEmOrdemSimetrica();

		//arvore.removerNo(305);
		 */

		System.out.println();
		System.out.println("Imprimir Menores nós");
		//Chamada de metodo para imprimir os menores
		arvore.imprimirMenores();


		System.out.println();
		System.out.println();

		//chamada de metodo para imprimir arvore simetrica
		arvoreB.imprimirEmOrdemSimetrica();
		arvoreC.imprimirEmOrdemSimetrica();
		arvoreD.imprimirEmOrdemSimetrica();
		System.out.println();


		//verificar se a arvore esta cheia
		System.out.println("A arvore é cheia?");
		System.out.println(arvore.cheio());
		System.out.println();

		//imprimir no pai e maior filho
		arvore.imprimirPaieFilhoMaior();
	}
}