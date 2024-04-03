package appEstoquePlus.model.domain;

public class itens {
	
	private int codigoDaPeca;
	private float valorDeCompra;
	private float ValorDeVenda;
	
	
	@Override
	public String toString() {
		return "itens [codigoDaPeca=" + codigoDaPeca + ", valorDeCompra=" + valorDeCompra + ", ValorDeVenda="
				+ ValorDeVenda + "]";
	}


	public int getCodigoDaPeca() {
		return codigoDaPeca;
	}


	public void setCodigoDaPeca(int codigoDaPeca) {
		this.codigoDaPeca = codigoDaPeca;
	}


	public float getValorDeCompra() {
		return valorDeCompra;
	}


	public void setValorDeCompra(float valorDeCompra) {
		this.valorDeCompra = valorDeCompra;
	}


	public float getValorDeVenda() {
		return ValorDeVenda;
	}


	public void setValorDeVenda(float valorDeVenda) {
		ValorDeVenda = valorDeVenda;
	}
	
	
	

}
