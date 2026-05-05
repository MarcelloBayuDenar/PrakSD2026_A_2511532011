package pekan4_2511532011;
import java.util.Scanner;

public class AntrianLoket_2511532011 {
    
    int front_2011;
    int rear_2011;
    int max_2011;
    String queue_2011[];

    public AntrianLoket_2511532011(int kapasitas) {
        this.max_2011 = kapasitas;
        this.queue_2011 = new String[max_2011];
        this.front_2011 = 0;
        this.rear_2011 = -1;
    }


    public boolean isEmpty() {
        return rear_2011 < front_2011;
    }

    public boolean isFull() {
        return rear_2011 == max_2011 - 1;
    }

    public void enqueue(String data) {
        if (isFull()) {
            System.out.println("Antrian penuh!");
            return;
        }
        rear_2011++;
        queue_2011[rear_2011] = data;
        System.out.println("Data berhasil ditambahkan ke antrian");
    }

    
    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Antrian kosong!");
            return;
        }
        System.out.println(queue_2011[front_2011] + " telah dilayani");
        front_2011++;
        
        if (isEmpty()) {
            front_2011 = 0;
            rear_2011 = -1;
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("Isi antrian:");
        for (int i = front_2011; i <= rear_2011; i++) {
            System.out.println((i - front_2011 + 1) + ". " + queue_2011[i]);
        }
    }

    public void reverse() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        int left = front_2011;
        int right = rear_2011;
        
        while (left < right) {
            String temp = queue_2011[left];
            queue_2011[left] = queue_2011[right];
            queue_2011[right] = temp;
            left++;
            right--;
        }
        
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AntrianLoket_2511532011 antrian = new AntrianLoket_2511532011(10);
        
        int pilihan_2011 = 0;
        
        do {
            System.out.println("\n=== PROGRAM ANTRIAN LOKET ===");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Hapus Antrian");
            System.out.println("3. Tampilkan Antrian");
            System.out.println("4. Reverse");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            
            if (scanner.hasNextInt()) {
                pilihan_2011 = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Input tidak valid. Masukkan angka.");
                scanner.nextLine();
                continue;
            }

            switch (pilihan_2011) {
                case 1:
                    System.out.print("Masukkan nama pelanggan: ");
                    String nama = scanner.nextLine();
                    antrian.enqueue(nama);
                    break;
                case 2:
                    antrian.dequeue();
                    break;
                case 3:
                    antrian.display();
                    break;
                case 4:
                    antrian.reverse();
                    break;
                case 5:
                    System.out.println("Program selesai");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        } while (pilihan_2011 != 5);
        
        scanner.close();
    }
}