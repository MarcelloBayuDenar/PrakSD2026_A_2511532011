package pekan6_2511532011;

public class lagu_2511532011 {
	String judul_2011;
	String penyanyi_2011;
	lagu_2511532011 next_2011;
	lagu_2511532011 prev_2011;
	
	 public lagu_2511532011(String j_2011, String p_2011) {
		 this.judul_2011 = j_2011;
		 this.penyanyi_2011 = p_2011;
		 this.next_2011 = null;
		 this.prev_2011 = null;
	 }
	 
	 public void setJ_2011(String j_2011) {
		 this.judul_2011 = j_2011;
	 }
	 
	 public void setP_2011(String p_2011) {
		 this.penyanyi_2011 = p_2011;
	 }
	 
	 public String getj_2011() {
		 return judul_2011;
	 }
	 
	 public String getp_2011() {
		 return penyanyi_2011;
	 }
}
