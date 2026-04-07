package pekan2_2511532011;
import java.util.ArrayList;

public class DaftarKata_2511532011 {
	private final ArrayList<String> data;
	
	public DaftarKata_2511532011(){
		this.data = new ArrayList<String>();
	}
	
	public void tambah_2511532011(String elemen) {
		data.add(elemen);
	}
	
	public void tambahPada_2511532011(int index, String elemen) {
		data.add(index, elemen);
	}
	
	public void ubahElemen_2511532011(int index, String nilaiBaru) {
		data.set(index, nilaiBaru);
	}
	
	public String hapusElemen_2511532011(int index) {
		return data.remove(index);
	}
	
	public void iterasiCetak_2511532011() {
		for (int i = 0; i < data.size(); i++) {
			System.out.println(data.get(i) + " ");
		}
	}
	
	public String get_2511532011(int index) {
		return data.get(index);
	}
	
	public String toString() {
		return data.toString();
	}
}
