package pekan8_251132011;

public class ShellSort_2511532011 {
	public static void ShellSort_2011(int[] A_2011) {
		int n_2011 = A_2011.length;
		int gap_2011 = n_2011/2;
		while (gap_2011 > 0) {
			for (int i_2011 = gap_2011; i_2011 < n_2011; i_2011++) {
				int temp_2011 = A_2011[i_2011];
				int j_2011 = i_2011;
				while (j_2011 >= gap_2011 && A_2011[j_2011 - gap_2011] > temp_2011) {
					A_2011[j_2011] = A_2011[j_2011 - gap_2011];
					j_2011 = j_2011 - gap_2011;
				}
				A_2011[j_2011] = temp_2011;
			}
			gap_2011 = gap_2011 / 2;
		}
	}
	
	public static void main (String[] args) {
		int[] data_2011 = {3, 10, 4, 6, 8, 9, 7, 2, 1, 5};
		
		System.out.print("Sebelum : ");
		printArray_2011(data_2011);
		
		ShellSort_2011(data_2011);

		System.out.print("Sesudah (Shell Sort) : ");
		printArray_2011(data_2011);
	}
	
	public static void printArray_2011 (int[] arr_2011) {
		for ( int i_2011 : arr_2011) System.out.print(i_2011 + " ");
		System.out.println();
	}
	
}
