package pekan2_2511532011;
import java.util.ArrayList;
import java.util.Scanner;

public class Playlist_2511532011 {
	private ArrayList<Musik_2511532011> playlist_2011 = new ArrayList<>();
	private Scanner input = new Scanner(System.in);
	
	public void tambahLagu_2011(Musik_2511532011 lagu) {
        playlist_2011.add(lagu);
    }
	
	public void lihatPlaylist_2011() {
        if (playlist_2011.isEmpty()) {
            System.out.println("\nPlaylist kosong. Belum ada lagu yang ditambahkan.\n");
            return;
        }
        System.out.println("\n=== Daftar Playlist ===");
        for (int i = 0; i < playlist_2011.size(); i++) {
            System.out.println((i + 1) + ". " + playlist_2011.get(i));
        }
        System.out.println("=======================\n");
    }
	
	public void hapusLagu_2011(int index) {
        if (playlist_2011.isEmpty()) {
            System.out.println("\nTidak ada lagu yang ingin dihapus.\n");
            return;
        }
        
        if (index < 1 || index > playlist_2011.size()) {
            System.out.println("\nIndex tidak valid. Silakan pilih antara 1 dan " + playlist_2011.size() + ".\n");
            return;
        }
        Musik_2511532011 dihapus = playlist_2011.remove(index - 1);
        System.out.println("\nLagu '" + dihapus.getJudulLagu_2011() + "' berhasil dihapus.\n");
    }
	
	public int cekKapasitas_2011() {
        return playlist_2011.size();
    }
	
	public void tampilkanMenu_2011() {
        System.out.println("=== Playlist Manager NIM: 2511532011 ===\n");
        System.out.println("1. Tambah Lagu");
        System.out.println("2. Lihat Playlist");
        System.out.println("3. Hapus Lagu");
        System.out.println("4. Cek Kapasitas Playlist");
        System.out.println("5. Keluar");
        System.out.print("Pilihan: ");
    }
	
	public void jalankan_2011() {
        boolean berjalan_2011 = true;
        
        while (berjalan_2011) {
            tampilkanMenu_2011();
            int pilihan_2011 = input.nextInt();
            input.nextLine();
            
            switch (pilihan_2011) {
                case 1:
                    System.out.print("\nMasukkan Judul Lagu: ");
                    String judul = input.nextLine();
                    
                    System.out.print("Masukkan Nama Penyanyi: ");
                    String penyanyi = input.nextLine();
                    
                    System.out.print("Masukkan Durasi (detik): ");
                    int durasi = input.nextInt();
                    input.nextLine();
                    
                    Musik_2511532011 laguBaru = new Musik_2511532011(judul, penyanyi, durasi);
                    tambahLagu_2011(laguBaru);
                    System.out.println("\nLagu berhasil ditambahkan!\n");
                    break;
                    
                case 2:
                    lihatPlaylist_2011();
                    break;
                    
                case 3:
                    lihatPlaylist_2011();
                    System.out.print("Masukkan nomor lagu yang ingin dihapus: ");
                    int idx = input.nextInt();
                    input.nextLine();
                    hapusLagu_2011(idx);
                    break;
                    
                case 4:
                    System.out.println("\nKapasitas Playlist saat ini: " + cekKapasitas_2011() + " lagu.\n");
                    break;
                    
                case 5:
                    System.out.println("\nTerima kasih telah menggunakan Playlist Manager!");
                    berjalan_2011 = false;
                    break;
                    
                default:
                    System.out.println("\nPilihan tidak valid. Silakan coba lagi.\n");
                    break;
            }
        }
        input.close();
    }
	
	public static void main(String[] args) {
        Playlist_2511532011 lagu_2011 = new Playlist_2511532011();
        lagu_2011.jalankan_2011();
    }
	
}
