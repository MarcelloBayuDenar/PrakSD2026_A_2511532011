package pekan2_2511532011;

public class Mahasiswa_2511532011 {
	String nama;
	String nim;
	String prodi;
	
	Mahasiswa_2511532011(String nama, String nim, String prodi){
		this.nama = nama;
		this.nim = nim;
		this.prodi = prodi;
	}
	
	public String toString() {
		return "NIM:" + nim + ", Nama: " + nama + ", Prodi :" + prodi;
	}
}
