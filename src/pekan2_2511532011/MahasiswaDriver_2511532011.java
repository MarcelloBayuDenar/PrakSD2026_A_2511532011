package pekan2_2511532011;
import java.util.Scanner;
import java.util.ArrayList;

public class MahasiswaDriver_2511532011 {
	
	public static void tampilkanMenu_2511532011() {
		System.out.println("1 Tambah Mahasiswa");
		System.out.println("2 Tampilkan semua Mahasiswa");
		System.out.println("3 Hapus Mahasiswa Berdasarkan NIM");
		System.out.println("4 Cari Mahasiswa Berdasarkan NIM");
		System.out.println("5 Keluar");
	}
	
	public static void tambahMahasiswa_2511532011(ArrayList<Mahasiswa_2511532011> list, Scanner sc) {		
		System.out.println("Masukkan Nim");
		String nim = sc.nextLine();
		System.out.println("Masukkan Nama");
		String nama = sc.nextLine();
		System.out.println("Masukkan Prodi");
		String prodi = sc.nextLine();
		
		list.add(new Mahasiswa_2511532011(nama, nim, prodi));
		System.out.println("Mahasiswa berhasil ditambahkan");
	}
	
	public static void tampilkanSemuaMahasiswa_2511532011(ArrayList<Mahasiswa_2511532011> list) {
		if (list.isEmpty()) {
			System.out.println("Daftar Mahasiswa Kosong");
		} else {
			System.out.println("Data Mahasiswa");
			for ( Mahasiswa_2511532011 mhs : list) {
				System.out.println(mhs);
			}
		}
	}
	
	public static void hapusMahasiswa_2511532011(ArrayList<Mahasiswa_2511532011> list, Scanner sc) {
		System.out.println("Masukkan Nim yang akan dihapus:");
		String nimHapus = sc.nextLine();
		boolean removed = list.removeIf(mhs -> mhs.nim.equals(nimHapus));
		
		if (removed) {
			System.out.println("Data dengan Nim " + nimHapus + "berhasil dihapus");
		} else {			
			System.out.println("Nim tidak ditemukan");
		}
	}
	
	public static void cariMahasiswa_2511532011(ArrayList<Mahasiswa_2511532011> list, Scanner sc) {
		System.out.println("Masukkan Nim yang dicari");
		String nimCari = sc.nextLine();
		
		boolean ditemukan = false;
		
		for (Mahasiswa_2511532011 mhs : list) {
			if (mhs.nim.equals(nimCari)) {
				System.out.println("Hasil Pencarian" + mhs);
				ditemukan = true;
				break;
			}
		}
		
		if (!ditemukan) {
			System.out.println("Nim tidak ada");
		}
		
	}

	public static void main(String[] args) {
		ArrayList<Mahasiswa_2511532011> mahasiswaList_2511532011 = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		int choice;
		
		do {
			tampilkanMenu_2511532011();
			System.out.println("pilih menu:  ");
			choice = scanner.nextInt();
			scanner.nextLine();
			
			switch (choice) {
				case 1:
					tambahMahasiswa_2511532011(mahasiswaList_2511532011, scanner);
					System.out.println(" ");
					break;
				case 2:
					tampilkanSemuaMahasiswa_2511532011(mahasiswaList_2511532011);
					System.out.println(" ");
					break;
				case 3:
					hapusMahasiswa_2511532011(mahasiswaList_2511532011, scanner);
					System.out.println(" ");
					break;
				case 4:
					cariMahasiswa_2511532011(mahasiswaList_2511532011, scanner);
					System.out.println(" ");
					break;
				case 5:
					System.out.println("Keluar dari program");
					System.out.println(" ");
					break;
				default:
					System.out.println("Pilihan tidak valid");
			}
			
		} while (choice != 5);
		scanner.close();
	}

}
