package pekan5_2511532011;

import java.util.Scanner;


public class RumahSakit_2511532011 {
	private static int count_2011 = 0;
	
	public static Pasien_2511532011 DaftarkanPasien_2011(Pasien_2511532011 item_2011, String n_2011, String k_2011 ) {
		count_2011++;
		Pasien_2511532011  node_2011 = new Pasien_2511532011(count_2011, n_2011, k_2011 );
		
		if (item_2011 == null ) {
			return node_2011;
		}
		
		Pasien_2511532011 L_2011 = item_2011;
		
		while (L_2011.next_2011 != null) {
			L_2011 = L_2011.next_2011;
		}
		
		L_2011.next_2011 = node_2011;
		return item_2011;
	}
	
	public static Pasien_2511532011 PanggilPasien_2011(Pasien_2511532011 item_2011) {
		if (item_2011 == null ) {
			return null;
		}
		
		System.out.println("Dipanggil Pasien");
		System.out.println("No Antrian: " + item_2011.getA_2011());
		System.out.println("Nama: " + item_2011.getN_2011());
		System.out.println("Keluhan/Penyakit: " + item_2011.getK_2011());
		System.out.println("");
		
		item_2011 = item_2011.next_2011;
		return item_2011;
	}
	
	public static void TampilkanAntrian_2011(Pasien_2511532011 item_2011) {
		Pasien_2511532011 c_2011 = item_2011;
		int posisi_2011 = 1;
		
		while (c_2011 != null) {
			System.out.println("Posisi " + posisi_2011);
			System.out.println("No Antrian: " + c_2011.getA_2011());
			System.out.println("Nama: " + c_2011.getN_2011());
			System.out.println("Keluhan/Penyakit: " + c_2011.getK_2011());
			System.out.println("");
			c_2011 = c_2011.next_2011;
			posisi_2011++;
			
		}
	}
	
	public static boolean CariPasien_2011(Pasien_2511532011 item_2011, String n_2011) {
		Pasien_2511532011 c_2011 = item_2011;
		while (c_2011 != null) {
			if (c_2011.nama_2011.equalsIgnoreCase(n_2011)) {
				System.out.println("No Antrian: " + c_2011.getA_2011());
				System.out.println("Nama: " + c_2011.getN_2011());
				System.out.println("Keluhan/Penyakit: " + c_2011.getK_2011());
				System.out.println("");
				return true;
			}
			c_2011 = c_2011.next_2011;
		}
		System.out.println("tidak ada pasien dengan nama yang kamu inputkan");
		return false;
	}
	
	public static void CekStatusAntrian_2011(Pasien_2511532011 item_2011) {
		if ( item_2011 == null) {
			System.out.println("Antrian Kosong");
			return;
		}
		
		int ttl_2011 = 0;
		Pasien_2511532011 c_2011 = item_2011;
		while (c_2011 != null) {
			ttl_2011++;
			c_2011 = c_2011.next_2011;
		}
		
		System.out.println("Jumlah Pasien: " + ttl_2011);
		System.out.println("Pasien Terdepan");
		System.out.println("No Antrian: " + item_2011.getA_2011());
		System.out.println("Nama: " + item_2011.getN_2011());
		System.out.println("Keluhan/Penyakit: " + item_2011.getK_2011());
		System.out.println("");
	}
	
	
	
	 public static void main(String[] args) {
	        Scanner scanner_2011 = new Scanner(System.in);
	        Pasien_2511532011 o_2011 = null;
	        
	        int pilihan_2011 = 0;
	        
	        do {
	            System.out.println("\n=== Antrian Rumah Sakit Nim:2511532011 ===");
	            System.out.println("1. Daftarkan Pasien");
	            System.out.println("2. Panggil Pasien");
	            System.out.println("3. Tampilkan Antrian");
	            System.out.println("4. Cari Pasien");
	            System.out.println("5. Cek Status Antrian");
	            System.out.println("6. Keluar");
	            System.out.print("Pilihan: ");
	            
	            if (scanner_2011.hasNextInt()) {
	                pilihan_2011 = scanner_2011.nextInt();
	                scanner_2011.nextLine();
	            } else {
	                System.out.println("Input tidak valid. Masukkan angka.");
	                scanner_2011.nextLine();
	                continue;
	            }

	            switch (pilihan_2011) {
	                case 1:
	                    System.out.print("Masukkan nama pasien: ");
	                    String nama_2011 = scanner_2011.nextLine();
	                    System.out.print("Masukkan keluhan: ");
	                    String penyakit_2011 = scanner_2011.nextLine();
	                    
	                    o_2011 = DaftarkanPasien_2011(o_2011, nama_2011, penyakit_2011);
	                    System.out.print("Pasien berhasil didaftarkan dengan no. antrian: " + count_2011 + "\n");
//	                    
	                    break;
	                    
	                case 2:
	                    o_2011 = PanggilPasien_2011(o_2011);
	                    break;
	                    
	                case 3:
	                	 	TampilkanAntrian_2011(o_2011);
	                    break;
	                    
	                case 4:
	                    System.out.print("Masukkan nama pasien yang dicari: ");
	                    String n_2011 = scanner_2011.nextLine();
	                    CariPasien_2011(o_2011, n_2011);
	                    break;
	                    
	                case 5:
	                		CekStatusAntrian_2011(o_2011);
	                		break;
	                		
	                case 6:
	                    System.out.println("Program selesai");
	                    break;
	                    
	                default:
	                    System.out.println("Pilihan tidak valid.");
	                    break;
	            }
	        } while (pilihan_2011 != 6);
	        
	        scanner_2011.close();
	    }
}
