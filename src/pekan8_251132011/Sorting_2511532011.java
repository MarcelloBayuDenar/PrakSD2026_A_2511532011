package pekan8_251132011;


public class Sorting_2511532011 {
	Lagu_2511532011[] listLagu_2011 = new Lagu_2511532011[20];
	int jumlah_2011 = 0;

	public void inputData_2011() {
		listLagu_2011[0] = new Lagu_2511532011("Neon Rain", "Neoni", 165);
		listLagu_2011[1] = new Lagu_2511532011("Take Off", "Quavo & Offset", 195);
		listLagu_2011[2] = new Lagu_2511532011("Fake It", "Seether", 235);
		listLagu_2011[3] = new Lagu_2511532011("Anti Hero", "Taylor Swift", 200);
		listLagu_2011[4] = new Lagu_2511532011("Back To Be Friend", "Noah Cyrus", 210);
		listLagu_2011[5] = new Lagu_2511532011("Stay With Me", "Sam Smith", 172);
		listLagu_2011[6] = new Lagu_2511532011("Clarity", "Zedd ft. Foxes", 271);
		jumlah_2011 = 7;
	}

	public void tampilData_2011() {
		for (int i_2011 = 0; i_2011 < jumlah_2011; ++i_2011) {
			System.out.println((i_2011 + 1) + ". " + listLagu_2011[i_2011].toString_2011());
		}
	}
	
	static void swap_2011(Lagu_2511532011[] arr_2011, int i_2011, int j_2011) {
		Lagu_2511532011 temp_2011 = arr_2011[i_2011];
		arr_2011[i_2011] = arr_2011[j_2011];
		arr_2011[j_2011] = temp_2011;
	}

	static void medianOfThree_2011(Lagu_2511532011[] arr_2011, int low_2011, int high_2011) {
		int mid_2011 = low_2011 + (high_2011 - low_2011) / 2;

		if (arr_2011[low_2011].getD_2011() > arr_2011[mid_2011].getD_2011()) {
			swap_2011(arr_2011, low_2011, mid_2011);
		}
		if (arr_2011[low_2011].getD_2011() > arr_2011[high_2011].getD_2011()) {
			swap_2011(arr_2011, low_2011, high_2011);
		}
		if (arr_2011[mid_2011].getD_2011() > arr_2011[high_2011].getD_2011()) {
			swap_2011(arr_2011, mid_2011, high_2011);
		}
		swap_2011(arr_2011, mid_2011, high_2011);
	}

	static int partition_2011(Lagu_2511532011[] arr_2011, int low_2011, int high_2011) {
		medianOfThree_2011(arr_2011, low_2011, high_2011);

		int pivot_2011 = arr_2011[high_2011].getD_2011(); 
		int i_2011 = (low_2011 - 1);

		for (int j_2011 = low_2011; j_2011 <= high_2011 - 1; j_2011++) {
			if (arr_2011[j_2011].getD_2011() < pivot_2011) {
				i_2011++;
				swap_2011(arr_2011, i_2011, j_2011);
			}
		}
		swap_2011(arr_2011, i_2011 + 1, high_2011);
		return (i_2011 + 1);
	}

	static void quickSort_2011(Lagu_2511532011[] arr_2011, int low_2011, int high_2011) {
		if (low_2011 < high_2011) {
			int pi_2011 = partition_2011(arr_2011, low_2011, high_2011);
			quickSort_2011(arr_2011, low_2011, pi_2011 - 1);
			quickSort_2011(arr_2011, pi_2011 + 1, high_2011);
		}
	}

	public void quickSort_2011() {
		if (jumlah_2011 > 1) {
			quickSort_2011(listLagu_2011, 0, jumlah_2011 - 1);
		}
	}

	public static void main(String[] args) {
		Sorting_2511532011 playlist_2011 = new Sorting_2511532011();

		System.out.println("=== Sorting Playlist NIM: 2511532011 ===");
		System.out.println("Pilih Algoritma (1=Shell, 2=Quick, 3=Merge): 2");
		playlist_2011.inputData_2011();

		System.out.println("\nData Sebelum Sorting:");
		playlist_2011.tampilData_2011();

		playlist_2011.quickSort_2011();

		System.out.println("\nData Setelah Quick Sort (Durasi Asc):");
		playlist_2011.tampilData_2011();
	}
}