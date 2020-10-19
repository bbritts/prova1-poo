package prova2;

public class Comorbidade {
	
	private String nomeComorbidade;
	private int anosAcometido;
	
	public Comorbidade(String nomeComorbidade, int anosAcometido) {
		
		setNomeComorbidade(nomeComorbidade);
		setAnosAcometido(anosAcometido);
	}

	public String getNomeComorbidade() {
		return nomeComorbidade;
	}

	public void setNomeComorbidade(String nomeComorbidade) {
		this.nomeComorbidade = nomeComorbidade;
	}

	public int getAnosAcometido() {
		return anosAcometido;
	}

	public void setAnosAcometido(int anosAcometido) {
		if (anosAcometido >= 0 && anosAcometido <= 140) 
			this.anosAcometido = anosAcometido;
	}
	
	public void imprimeComorbidades() {
		System.out.print("Nome da comorbidade: " + getNomeComorbidade() + "\n");
		System.out.print("Convive com a doença há quantos anos? " + getAnosAcometido() + "\n\n");
	}
}
