package logica_interna;

public class PlayerObjectTabla {
	String nommbre;
	String scorre;
	String ennKill;
	String datttte;
	
	

	public PlayerObjectTabla(String nommbre, String scorre, String ennKill, String datttte) {
		super();
		this.nommbre = nommbre;
		this.scorre = scorre;
		this.ennKill = ennKill;
		this.datttte = datttte;
	}

	public PlayerObjectTabla(){
		
		this.nommbre = "";
		this.scorre = "";
		this.ennKill = "";
		this.datttte = "";
	}

	public String getNommbre() {
		return nommbre;
	}

	public void setNommbre(String nommbre) {
		this.nommbre = nommbre;
	}

	public String getScorre() {
		return scorre;
	}

	public void setScorre(String scorre) {
		this.scorre = scorre;
	}

	public String getEnnKill() {
		return ennKill;
	}

	public void setEnnKill(String ennKill) {
		this.ennKill = ennKill;
	}

	public String getDatttte() {
		return datttte;
	}

	public void setDatttte(String datttte) {
		this.datttte = datttte;
	}
	


}
