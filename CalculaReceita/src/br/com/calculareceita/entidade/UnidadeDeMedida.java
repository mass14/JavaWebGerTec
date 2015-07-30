package br.com.calculareceita.entidade;

public enum UnidadeDeMedida {

	KG(1,"kg"),
	G(2,"g"),
	L(3,"l"),
	ML(4,"ml");
	public int valor;
	public String descricao;
	
	UnidadeDeMedida(int valor, String descricao) {
		this.valor = valor;
		this.descricao = descricao;
	}
}
	
