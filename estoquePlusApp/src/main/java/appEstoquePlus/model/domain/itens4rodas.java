package appEstoquePlus.model.domain;

public class itens4rodas extends itens{
	
	private int anoCarro;
	private String fabricanteCarro;
	private int modeloCarro;
	
	
	@Override
	public String toString() {
		return super.toString() + ", Carro: " + modeloCarro;
	}


	public int getAnoCarro() {
		return anoCarro;
	}

	public void setAnoCarro(int anoCarro) {
		this.anoCarro = anoCarro;
	}

	public String getFabricanteCarro() {
		return fabricanteCarro;
	}

	public void setFabricanteCarro(String fabricanteCarro) {
		this.fabricanteCarro = fabricanteCarro;
	}

	public int getModeloCarro() {
		return modeloCarro;
	}

	public void setModeloCarro(int modeloCarro) {
		this.modeloCarro = modeloCarro;
	}
}
