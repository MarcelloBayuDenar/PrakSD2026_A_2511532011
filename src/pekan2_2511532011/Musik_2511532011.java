package pekan2_2511532011;

public class Musik_2511532011 {
	 private String judulLagu_2011;
	 private String penyanyi_2011;
	 private int durasi_2011;
	 
	 public Musik_2511532011(String judul, String penyanyi, int durasi) {
	        this.judulLagu_2011 = judul;
	        this.penyanyi_2011 = penyanyi;
	        this.durasi_2011 = durasi;
	  }
	 
	 public void setJudulLagu_2011(String j) { this.judulLagu_2011 = j; }
	 public void setPenyanyi_2011(String p) { this.penyanyi_2011 = p; }
	 public void setDurasi_2011(int d) { this.durasi_2011 = d; }
	 
	 public String getJudulLagu_2011() { return judulLagu_2011; }
	 public String getPenyanyi_2011() { return penyanyi_2011; }
	 public int getDurasi_2011() { return durasi_2011; }
	 
	 public String toString() {
	        return judulLagu_2011 + " - " + penyanyi_2011 + " (" + durasi_2011 + " detik)";
	   }
}
