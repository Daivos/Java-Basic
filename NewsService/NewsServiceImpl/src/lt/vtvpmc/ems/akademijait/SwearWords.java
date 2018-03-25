package lt.vtvpmc.ems.akademijait;

public enum SwearWords {

  Miltai("rupūs miltai"), 
   Velnias("velnias"), 
  Velniais("velniais"),
Rautu("velniai rautų");


  private final String swearWord;    

	
	SwearWords (String swearWord) {
		this.swearWord=swearWord;
		
	}
	
	public String getSwearWord(){

		return swearWord.toLowerCase();
	}
}
