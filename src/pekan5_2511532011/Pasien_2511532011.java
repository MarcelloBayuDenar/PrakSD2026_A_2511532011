package pekan5_2511532011;

public class Pasien_2511532011 {
	String nama_2011;
	String keluhan_2011;
	int Antrian_2011;
	
	Pasien_2511532011 next_2011;
	
	public Pasien_2511532011(int a, String n, String k) {
		this.Antrian_2011 = a;
		this.nama_2011 = n;
		this.keluhan_2011 = k;
		this.next_2011 = null;
	}
	
	public void setN_2011( String n){
		this.nama_2011 = n;
	}
	
	public void setK_2011( String k){
		this.keluhan_2011 = k;
	}
	
	public void setA_2011( int a){
		this.Antrian_2011 = a;
	}
	
	public String getN_2011() {
		return nama_2011;
	}
	
	public String getK_2011() {
		return keluhan_2011;
	}
	
	public int getA_2011() {
		return Antrian_2011;
	}
	
}
