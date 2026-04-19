package pekan3_2511532011;

import java.util.Scanner;
import java.util.Stack;

public class Browser_2511532011 {
	 private Stack<Website_2511532011> history_2011 = new Stack<>();
	 private Scanner input = new Scanner(System.in);
	 
	 public void KunjungiWeb_2011(Website_2511532011 w) {
	     history_2011.push(w);
	 }
	 
	 public void back_2011() {
	     if (history_2011.isEmpty()) {
	        System.out.println("\nStack kosong. Tidak ada halaman untuk dikembalikan.\n");
	        return;
	     }
	     
	     if (history_2011.size() == 1) {
	            System.out.println("\nTidak ada halaman sebelumnya. Anda sudah di halaman pertama.\n");
	            return;
	     }
	     
	     history_2011.pop();
	     
	     Website_2511532011 a_2011 = history_2011.peek();
	     
	     System.out.println("\nKembali ke page: " + a_2011.getJ_2011() + "\n");
	 }
	 
	 public void LihatHalamanSaatIni_2011() {
	      if (history_2011.isEmpty()) {
	          System.out.println("\nTidak ada halaman yang sedang dibuka.\n");
	          return;
	       }
	      
	       Website_2511532011 b_2011 = history_2011.peek();
	       System.out.println("\nHalaman saat ini: " + b_2011.getJ_2011());
	       System.out.println("URL: " + b_2011.getUrl_2011() + "\n");
	 }
	 
	 public void tampilkanHistory_2011() {
	        System.out.println("\n=== Riwayat Penjelajahan (History) ===");
	        
	        if (history_2011.isEmpty()) {
	            System.out.println("History kosong. Belum ada website yang dikunjungi.\n");
	            return;
	        }
	        
	        System.out.println("Total halaman dalam history: " + history_2011.size());
	        System.out.println("-------------------------------------------");
	        
	       
	        int no = 1;
	    
	        for (Website_2511532011 website : history_2011) {
	            System.out.println(no + ". " + website.getJ_2011());
	            System.out.println("   URL: " + website.getUrl_2011());
	            System.out.println();
	            no++;
	        }
	        
	        System.out.println("-------------------------------------------\n");
	    }
	 
	 
	 
	 public void tampilkanMenu() {
	        System.out.println("=== Browser History NIM: 2511532011 ===\n");
	        System.out.println("1. Kunjungi Website (Push)");
	        System.out.println("2. Tombol Back (Pop)");
	        System.out.println("3. Lihat Halaman Aktif (Peek)");
	        System.out.println("4. Tampilkan History");
	        System.out.println("5. Keluar");
	        System.out.print("Pilihan: ");
	 }
	 
	 
	 public void jalankan() {
	        boolean berjalan_2011 = true;
	        
	        while (berjalan_2011) {
	            tampilkanMenu();
	            int pilihan_2011 = input.nextInt();
	            input.nextLine();
	            
	            switch (pilihan_2011) {
	                case 1:
	                    System.out.print("\nMasukkan Judul: ");
	                    String judul = input.nextLine();
	                    
	                    System.out.print("Masukkan URL: ");
	                    String url = input.nextLine();
	                    
	                    Website_2511532011 website = new Website_2511532011(judul, url);
	                    KunjungiWeb_2011(website);
	                    
	                    System.out.println("\nBerhasil mengunjungi halaman!\n");
	                    break;
	                    
	                case 2:
	                    back_2011();
	                    break;
	                    
	                case 3:
	                    LihatHalamanSaatIni_2011();
	                    break;
	                    
	                case 4:
	                    tampilkanHistory_2011();
	                    break;
	                    
	                case 5:
	                    System.out.println("\nTerima kasih telah menggunakan browser ini!");
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
	        Browser_2511532011 browser_2011 = new Browser_2511532011();
	        browser_2011.jalankan();
	    }
	 
}
