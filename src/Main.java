
public class Main {

	public static void main(String[] args) {		
		No no300 = new No(300);
		No no280 = new No(280);
		No no2 = new No(2);
		No no1 = new No(1);
		No no299 = new No(299);
		No no305= new No(305);
		No no302 = new No(302);
		No no475 = new No(475);
		No no472 = new No(472);
		No no476 = new No(476); //
		No no60 = new No(60);
		No no59 = new No(59);
		No no75 = new No(75); //
		No no38 = new No(38);
		No no36 = new No(36);

        ArvoreBinaria arvore = new ArvoreBinaria();

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
		
		arvore.removerNo(305);
		

	}

}
