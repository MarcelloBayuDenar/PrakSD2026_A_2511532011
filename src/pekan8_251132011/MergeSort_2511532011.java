package pekan8_251132011;

public class MergeSort_2511532011 {
	void Merge_2011(int arr_2011[], int l_2011, int m_2011, int r_2011) {
		int n1_2011 = m_2011 - l_2011 + 1;
		int n2_2011 = r_2011 - m_2011;
		
		int L_2011[] = new int[n1_2011];
		int R_2011[] = new int[n2_2011];
		
		for (int i_2011 = 0; i_2011 < n1_2011; ++i_2011) {
			L_2011[i_2011] = arr_2011[l_2011 + i_2011];
		}
		
		for (int j_2011 = 0; j_2011 < n2_2011; ++j_2011) {
			R_2011[j_2011] = arr_2011[m_2011 + 1 + j_2011]; 
		}
		
		int i_2011 = 0, j_2011 = 0;
		
		int k_2011 = l_2011; 
		
		while(i_2011 < n1_2011 && j_2011 < n2_2011) {
			if (L_2011[i_2011] <= R_2011[j_2011]) {
				arr_2011[k_2011] = L_2011[i_2011];
				i_2011++;
			} else {
				arr_2011[k_2011] = R_2011[j_2011];
				j_2011 ++;
			}
			k_2011++;
		}
		
		while (i_2011 < n1_2011) {
			arr_2011[k_2011] = L_2011[i_2011];
			i_2011++;
			k_2011++;
		}
		
		while (j_2011 < n2_2011) {
			arr_2011[k_2011] = R_2011[j_2011];
			j_2011++;
			k_2011++;
		}
	}
	
	void sort_2011(int arr[], int l_2011, int r_2011) {
		if (l_2011 < r_2011) {
			
			int m_2011 = (l_2011 + r_2011) / 2;
			
			sort_2011(arr, l_2011, m_2011);
			sort_2011(arr, m_2011 + 1, r_2011); 
			
			Merge_2011(arr, l_2011, m_2011, r_2011);
		}
	}

	
	static void printArray_2011(int arr_2011[]) {
		int n_2011 = arr_2011.length;
		for (int i_2011 = 0; i_2011 < n_2011; i_2011++) {
			System.out.print(arr_2011[i_2011] + " ");
		}
		System.out.println();
	}
	
	public static void main(String args[]) {
		int arr_2011[] = {12, 11, 13, 5, 6, 7};
		System.out.println("Sebelum Terurut");
		printArray_2011(arr_2011);
		MergeSort_2511532011 ob_2011 = new MergeSort_2511532011();
		ob_2011.sort_2011(arr_2011, 0, arr_2011.length - 1);
		System.out.println("\nSudah Terurut menggunakan merge sort");
		printArray_2011(arr_2011);
		
	}
	
	
}
