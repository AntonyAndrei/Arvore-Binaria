public class No {

	int dado;
	No pai;
	No noFilhoEsquerdo;
	No noFilhoDireito;
	private int profundidade;

	public No() {
	}

	public No(int dado) {
		super();
		this.dado = dado;
		this.pai = null;
		this.noFilhoDireito = null;
		this.noFilhoEsquerdo = null;
	}

	public int getDado() {
		return dado;
	}

	public void setDado(int dado) {
		this.dado = dado;
	}

	public No getPai() {
		return pai;
	}

	public void setPai(No pai) {
		this.pai = pai;
	}

	public No getNoFilhoEsquerdo() {
		return noFilhoEsquerdo;
	}

	public void setNoFilhoEsquerdo(No noFilhoEsquerdo) {
		this.noFilhoEsquerdo = noFilhoEsquerdo;
	}

	public No getNoFilhoDireito() {
		return noFilhoDireito;
	}

	public void setNoFilhoDireito(No noFilhoDireito) {
		this.noFilhoDireito = noFilhoDireito;
	}


	public int getProfundidade() {
		return profundidade;
	}

	public void setProfundidade(int profundidade) {
		this.profundidade = profundidade;
	}

	public int nivelNo() {
		return this.getProfundidade();
	}
	
	@Override
	public boolean equals(Object no) {
		
		if (no instanceof No) {
			return ((No) no).dado == this.dado;
		} else {
			return super.equals(no);
		}
	}
}	