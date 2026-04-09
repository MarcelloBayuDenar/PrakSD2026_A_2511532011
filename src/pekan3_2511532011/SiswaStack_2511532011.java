package pekan3_2511532011;
import java.util.ArrayList;

class Siswa_2011 {
	String nama_2011;
	int nim_2011;
	
	public Siswa_2011(String nama, int nim) {
		this.nama_2011 = nama;
		this.nim_2011 = nim;
	}
	
	public String toString() {
		return "Nim: " + nim_2011 + ", Nama: " + nama_2011;
	}
}

public class SiswaStack_2511532011 {
	private ArrayList<Siswa_2011> stack_2011;
	
	public SiswaStack_2511532011() {
		stack_2011 = new ArrayList<>();
	}
	
	public void push_2011(Siswa_2011 mhs) {
		stack_2011.add(mhs);
	}
	
	public Siswa_2011 pop_2011() {
		if (!isEmpty_2011()) {
			return stack_2011.remove(stack_2011.size()-1);
		}
		return null;
	}
	
	public Siswa_2011 peek_2011() {
		if (!isEmpty_2011()) {
			return stack_2011.get(stack_2011.size() - 1);
		}
		return null;
	}
	
	public boolean isEmpty_2011() {
		return stack_2011.isEmpty();
	}
	
	public void tampilkanSiswa_2011() {
		for ( int i = stack_2011.size() - 1; i >= 0; i--) {
			System.out.println(stack_2011.get(i));
		}
		
	}
	
	public static void main (String [] args) {
		SiswaStack_2511532011 studentStack_2011 = new SiswaStack_2511532011();
		
		Siswa_2011 mhs1 = new Siswa_2011("Ali", 1);
		Siswa_2011 mhs2 = new Siswa_2011("Boby", 2);
		Siswa_2011 mhs3 = new Siswa_2011("charles", 3);
		
		studentStack_2011.push_2011(mhs1);
		studentStack_2011.push_2011(mhs2);
		studentStack_2011.push_2011(mhs3);
		
		System.out.println("Siswa di dalam stack:");
		studentStack_2011.tampilkanSiswa_2011();
		
		System.out.println("Siswa teratas " + studentStack_2011.peek_2011());
		System.out.println("Mengeluarkan siswa teratas dari stack" + studentStack_2011.pop_2011());
		System.out.println("daftar siswa setelah di pop :");
		studentStack_2011.tampilkanSiswa_2011();
	}
}
