package appEstoquePlus.model.domain;

public class itens2rodas extends itens {
	private int anoMoto;
	private String fabricanteMoto;
	private String modeloMoto;
	
	
	@Override
	public String toString() {
		return super.toString() + ", Moto: " + modeloMoto;
	}


	public int getAnoMoto() {
		return anoMoto;
	}


	public void setAnoMoto(int anoMoto) {
		this.anoMoto = anoMoto;
	}


	public String getFabricanteMoto() {
		return fabricanteMoto;
	}


	public void setFabricanteMoto(String fabricanteMoto) {
		this.fabricanteMoto = fabricanteMoto;
	}


	public String getModeloMoto() {
		return modeloMoto;
	}


	public void setModeloMoto(String modeloMoto) {
		this.modeloMoto = modeloMoto;
	}
	
}
