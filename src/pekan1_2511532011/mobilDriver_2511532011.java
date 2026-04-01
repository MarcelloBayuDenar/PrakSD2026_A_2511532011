package pekan1_2511532011;

public class mobilDriver_2511532011 {

	public static void main(String[] args) {
        mobil_2511532011 dealer = new mobil_2511532011("punya admin hahaha", "2024", "0", "0", "Admin");

        System.out.println("=== 1. Menambah Mobil ===");
        dealer.tambahMobil("Avanza", "2020", "1300cc", "200 Juta", "Toyota");
        dealer.tambahMobil("Brio", "2021", "1200cc", "180 Juta", "Honda");
        dealer.tambahMobil("Pajero", "2019", "2400cc", "500 Juta", "Mitsubishi");

        System.out.println("\n=== 2. Coba Tambah Mobil Duplikat ===");
        dealer.tambahMobil("Avanza", "2022", "1500cc", "250 Juta", "Toyota");

        System.out.println("\n=== 3. Lihat Semua Koleksi (Info) ===");
        dealer.infoMobil();

        System.out.println("\n=== 4. Ubah Harga Mobil ===");
        dealer.ubahHargaMobil("Brio", "175 Juta"); 
        dealer.ubahHargaMobil("Civic", "300 Juta"); 

        System.out.println("\n=== 5. Lihat Koleksi Setelah Ubah Harga ===");
        dealer.infoMobil();

        System.out.println("\n=== 6. Hapus Mobil ===");
        dealer.hapusMobil("Pajero"); 
        dealer.hapusMobil("Ferrari"); 

        System.out.println("\n=== 7. Lihat Koleksi Akhir ===");
        dealer.infoMobil();
    }

}
