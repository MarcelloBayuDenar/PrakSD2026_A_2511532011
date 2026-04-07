package pekan2_2511532011;

public class DaftarKataDriver_2511532011 {
	public static void main ( String [] args) {
		DaftarKata_2511532011 al = new DaftarKata_2511532011();
		
		al.tambah_2511532011("kami");
		al.tambah_2511532011("Informatika");
		
		al.tambahPada_2511532011(1, "Mahasiswa");
		
		System.out.println("Awal    :" + al);
		
		al.ubahElemen_2511532011(1, "Departemen");
		System.out.println("Setelah Ubah:" + al);
		
		String terhapus = al.hapusElemen_2511532011(0);
		System.out.println("Terhapus   :" + terhapus);
		System.out.println("Setelah Hapus   :" + al);
		
		System.out.println("Iterasi");
		al.iterasiCetak_2511532011();
		System.out.println("");
	}
}
