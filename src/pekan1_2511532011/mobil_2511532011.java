package pekan1_2511532011;

public class mobil_2511532011 {
    private String nama;
    private String tahun;
    private String cc;
    private String harga;
    private String merek;

    
    private static final int total = 10;
    private mobil_2511532011[] koleksiMobil = new mobil_2511532011[total];
    
    
    private int jumlahMobil = 0;

    public String toString() {
        return "Mobil{" +
               "nama='" + nama + '\'' +
               ", tahun='" + tahun + '\'' +
               ", cc='" + cc + '\'' +
               ", harga='" + harga + '\'' +
               ", merek='" + merek + '\'' +
               '}';
    }

    public mobil_2511532011(String n, String t, String c, String h, String m) {
        this.nama = n;
        this.tahun = t;
        this.cc = c;
        this.harga = h;
        this.merek = m;
    }

    public void infoMobil() {
        if (jumlahMobil == 0) {
            System.out.println("Tidak ada mobil dalam koleksi.");
            return;
        }

       
        for (int i = 0; i < jumlahMobil; i++) {
            mobil_2511532011 m = koleksiMobil[i];
            System.out.println("mobil :" + m.getN());
            System.out.println("tahun :" + m.getT());
            System.out.println("cc    :" + m.getC());
            System.out.println("harga :" + m.getH());
            System.out.println("merek :" + m.getM());
            System.out.println("-------------------------");
        }
    }

    
    public void setN(String n) { this.nama = n; }
    public void setT(String t) { this.tahun = t; }
    public void setC(String c) { this.cc = c; }
    public void setH(String h) { this.harga = h; }
    public void setM(String m) { this.merek = m; }

    public String getN() { return nama; }
    public String getT() { return tahun; }
    public String getC() { return cc; }
    public String getH() { return harga; }
    public String getM() { return merek; }

  
    private mobil_2511532011 inKoleksi(String n) {
        for (int i = 0; i < jumlahMobil; i++) {
            if (koleksiMobil[i].getN().equals(n)) {
                return koleksiMobil[i];
            }
        }
        return null;
    }
    
   
    private int getIndexKoleksi(String n) {
        for (int i = 0; i < jumlahMobil; i++) {
            if (koleksiMobil[i].getN().equals(n)) {
                return i;
            }
        }
        return -1;
    }

    public void tambahMobil(String n, String t, String c, String h, String m) {
      
        if (inKoleksi(n) != null) {
            System.out.println("mobil " + n + " ini sudah ada di dalam koleksi");
            return;
        } 
        
        
        if (jumlahMobil >= total) {
            System.out.println("Koleksi mobil sudah penuh (Maksimal " + total + ")");
            return;
        }

        mobil_2511532011 mobilbaru = new mobil_2511532011(n, t, c, h, m);
        koleksiMobil[jumlahMobil] = mobilbaru; 
        jumlahMobil++; 
        
        System.out.println("mobil " + mobilbaru.getN() + " ditambahkan ke dalam koleksi");
    }

    public void hapusMobil(String n) {
        if (jumlahMobil == 0) {
            System.out.print("anda tidak memiliki mobil");
            return;
        } 
        
        int index = getIndexKoleksi(n);
        
        if (index != -1) {
            mobil_2511532011 m = koleksiMobil[index];
            
            for (int i = index; i < jumlahMobil - 1; i++) {
                koleksiMobil[i] = koleksiMobil[i + 1];
            }
            
           
            koleksiMobil[jumlahMobil - 1] = null;
            jumlahMobil--;
            
            System.out.println(" Mobil yang berhasil dihapus" + m);
        } else {
            System.out.println("tidak ada mobil yang dihapus");
        }
    }

    public void ubahHargaMobil(String n, String h) {
        if (jumlahMobil == 0) {
            System.out.println("tidak ada mobil yang ada untuk diubah");
            return;
        } 
        
        mobil_2511532011 m = inKoleksi(n);
        
        if (m != null) {
            m.setH(h);
            System.out.println("Harga mobil " + n + " berhasil diubah menjadi " + h);
        } else {
            System.out.print("tidak ada mobil yang anda cari ");
        }
    }
}
