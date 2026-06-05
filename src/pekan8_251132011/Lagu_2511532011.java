package pekan8_251132011;

public class Lagu_2511532011 {
	private String judul_2011;
	private String penyanyi_2011;
	private int durasi_2011;
	
	public Lagu_2511532011(String j_2011, String p_2011, int d_2011 ) {
		this.judul_2011 = j_2011;
		this.penyanyi_2011 = p_2011;
		this.durasi_2011 = d_2011;
	}
	
    public String getJ_2011() {return judul_2011;}
	public String getP_2011() {return penyanyi_2011;}
	public int getD_2011() {return durasi_2011;}
	
	public void setJ_2011(String j_2011) {
		this.judul_2011 = j_2011;
	}
	
	public void setP_2011(String p_2011) {
		this.penyanyi_2011 = p_2011;
	}
	
	public void setD_2011(int d_2011) {
		this.durasi_2011 = d_2011;
	}
	
	public String toString_2011() {
		return judul_2011 + " - " + penyanyi_2011 + " (" + durasi_2011 + " detik)";
	}
	

}
