package pekan6_2511532011;
import java.util.Scanner;

public class musik_2511532011 {
    
    public static lagu_2511532011 tambahLagu_2011(lagu_2511532011 l_2011, String j_2011, String p_2011) {
        lagu_2511532011 lg_2011 = new lagu_2511532011(j_2011, p_2011);
        
        if (l_2011 == null) return lg_2011;
        
        lagu_2511532011 curr_2011 = l_2011;
        while (curr_2011.next_2011 != null) {
            curr_2011 = curr_2011.next_2011;
        }
        
        curr_2011.next_2011 = lg_2011;
        lg_2011.prev_2011 = curr_2011;
        return l_2011;
    }

    public static lagu_2511532011 hapusLaguAwal_2011(lagu_2511532011 l_2011) {
        if (l_2011 == null) {
            return null;
        }
        
        lagu_2511532011 temp_2011 = l_2011;
        l_2011 = l_2011.next_2011;
        
        if (l_2011 != null) {
            l_2011.prev_2011 = null;
        }
        
        temp_2011.next_2011 = null;
        return l_2011;
    }

    public static void tampilMaju_2011(lagu_2511532011 l_2011) {
        if (l_2011 == null) {
            System.out.println("Playlist kosong.");
            return;
        }
        
        lagu_2511532011 curr_2011 = l_2011;
        while (curr_2011 != null) {
            System.out.print(curr_2011.getj_2011() + " " + curr_2011.getp_2011() + " <-> ");
            curr_2011 = curr_2011.next_2011;
        }
        System.out.println();
    }

    public static void tampilMundur_2011(lagu_2511532011 l_2011) {
        if (l_2011 == null) {
            System.out.println("Playlist kosong.");
            return;
        }
        
        lagu_2511532011 curr_2011 = l_2011;
        while (curr_2011.next_2011 != null) {
            curr_2011 = curr_2011.next_2011;
        }
        
        while (curr_2011 != null) {
            System.out.print(curr_2011.getj_2011() + " " + curr_2011.getp_2011() + " <-> ");
            curr_2011 = curr_2011.prev_2011;
        }
        System.out.println();
    }

    public static boolean cariLagu_2011(lagu_2511532011 l_2011, String j_2011) {
        lagu_2511532011 curr_2011 = l_2011;
        while (curr_2011 != null) {
            if (curr_2011.judul_2011.equalsIgnoreCase(j_2011)) {
                System.out.println("Judul Lagu: " + curr_2011.getj_2011());
                System.out.println("Penyanyi  : " + curr_2011.getp_2011());
                return true;
            }
            curr_2011 = curr_2011.next_2011;
        }
        System.out.println("tidak ada lagu yang anda cari di playlist");
        return false;
    }

    public static void main(String[] args) {
        lagu_2511532011 item_2011 = null;
        Scanner input_2011 = new Scanner(System.in);
        int pilihan_2011 = 0;
        
        do {
            System.out.println("\n=== playlist Musik Nim:2511532011 ===");
            System.out.println("1. Tambah lagu");
            System.out.println("2. Hapus lagu awal");
            System.out.println("3. lihat playlist (maju)");
            System.out.println("4. lihat playlist (mundur)");
            System.out.println("5. Cari lagu");
            System.out.println("6. Keluar");
            System.out.print("Pilihan: ");
            
            if (input_2011.hasNextInt()) {
                pilihan_2011 = input_2011.nextInt();
                input_2011.nextLine();
            } else {
                System.out.println("Input tidak valid. Masukkan angka.");
                input_2011.nextLine();
                continue;
            }
            
            switch (pilihan_2011) {
                case 1:
                    System.out.print("Masukkan Judul lagu: ");
                    String j_2011 = input_2011.nextLine();
                    System.out.print("Masukkan Nama Penyanyi: ");
                    String p_2011 = input_2011.nextLine();
                    
                    item_2011 = tambahLagu_2011(item_2011, j_2011, p_2011);
                    System.out.println("lagu berhasil ditambahkan");
                    break;
                    
                case 2:
                    item_2011 = hapusLaguAwal_2011(item_2011);
                    break;
                    
                case 3:
                    tampilMaju_2011(item_2011);
                    break;
                    
                case 4:
                    tampilMundur_2011(item_2011);
                    break;
                    
                case 5:
                    System.out.print("Masukkan judul lagu yang dicari: ");
                    String i_2011 = input_2011.nextLine();
                    cariLagu_2011(item_2011, i_2011);
                    break;
                    
                case 6:
                    System.out.println("Program selesai");
                    break;
                    
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
            
        } while (pilihan_2011 != 6);
        
        input_2011.close();
    }
}