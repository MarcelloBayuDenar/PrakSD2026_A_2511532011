package pekan7_2511532011;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class SortingGUI_2511532011 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField FName_2011;
	private JTextField FNim_2011;
	private JTextField FFakultas_2011;
	private JTextArea DMhs_2011;
	private JTextArea SMhs_2011;
	private ArrayList<Mahasiswa_2011> listMahasiswa_2011 = new ArrayList<Mahasiswa_2011>();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SortingGUI_2511532011 frame = new SortingGUI_2511532011();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SortingGUI_2511532011() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		FName_2011 = new JTextField();
		FName_2011.setBounds(10, 11, 96, 20);
		contentPane.add(FName_2011);
		FName_2011.setColumns(10);

		FNim_2011 = new JTextField();
		FNim_2011.setBounds(116, 11, 96, 20);
		contentPane.add(FNim_2011);
		FNim_2011.setColumns(10);

		FFakultas_2011 = new JTextField();
		FFakultas_2011.setBounds(222, 11, 96, 20);
		contentPane.add(FFakultas_2011);
		FFakultas_2011.setColumns(10);

		JButton btnInput_2011 = new JButton("Input");
		btnInput_2011.setBounds(337, 10, 89, 23);
		contentPane.add(btnInput_2011);

		JButton btnSort_2011 = new JButton("Sorting");
		btnSort_2011.setBounds(235, 148, 89, 23);
		contentPane.add(btnSort_2011);

		JButton btnReset_2011 = new JButton("Reset");
		btnReset_2011.setBounds(337, 148, 89, 23);
		contentPane.add(btnReset_2011);

		JComboBox<String> DDSorting_2011 = new JComboBox<String>();
		DDSorting_2011.setBounds(10, 148, 160, 22);
		contentPane.add(DDSorting_2011);

		DMhs_2011 = new JTextArea();
		DMhs_2011.setEditable(false);

		SMhs_2011 = new JTextArea();
		SMhs_2011.setEditable(false);

		JScrollPane scrollPaneDMhs_2011 = new JScrollPane(DMhs_2011);
		scrollPaneDMhs_2011.setBounds(10, 42, 416, 95);
		contentPane.add(scrollPaneDMhs_2011);

		JScrollPane scrollPaneSMhs_2011 = new JScrollPane(SMhs_2011);
		scrollPaneSMhs_2011.setBounds(10, 182, 416, 70);
		contentPane.add(scrollPaneSMhs_2011);

		setupComboBox_2011(DDSorting_2011);
		setupActionListeners_2011(btnInput_2011, btnSort_2011, btnReset_2011, DDSorting_2011);
	}

	private void setupComboBox_2011(JComboBox<String> combo_2011) {
		combo_2011.addItem("Insertion Sort");
		combo_2011.addItem("Selection Sort");
		combo_2011.addItem("Bubble Sort");
	}

	private void setupActionListeners_2011(final JButton btnInput_2011, final JButton btnSort_2011,
			final JButton btnReset_2011, final JComboBox<String> combo_2011) {

		btnInput_2011.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e_2011) {
				inputData_2011();
			}
		});

		btnSort_2011.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e_2011) {
				startSorting_2011(combo_2011);
			}
		});

		btnReset_2011.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e_2011) {
				resetData_2011();
			}
		});
	}

	private void inputData_2011() {
		String nama_2011 = FName_2011.getText().trim();
		String nim_2011 = FNim_2011.getText().trim();
		String fakultas_2011 = FFakultas_2011.getText().trim();

		if (nama_2011.isEmpty() || nim_2011.isEmpty() || fakultas_2011.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Semua field wajib diisi!", "Input Kosong", JOptionPane.WARNING_MESSAGE);
			return;
		}

		Mahasiswa_2011 m_2011 = new Mahasiswa_2011();
		m_2011.setNama_2011(nama_2011);
		m_2011.setNim_2011(nim_2011);
		m_2011.setFakultas_2011(fakultas_2011);
		
		listMahasiswa_2011.add(m_2011);
		updateDisplay_2011();

		FName_2011.setText("");
		FNim_2011.setText("");
		FFakultas_2011.setText("");
		FName_2011.requestFocus();
	}

	private void updateDisplay_2011() {
		StringBuilder sb_2011 = new StringBuilder("DATA MAHASISWA:\n");
		sb_2011.append("--------------------------------------------------\n");
		for (int i_2011 = 0; i_2011 < listMahasiswa_2011.size(); i_2011++) {
			Mahasiswa_2011 m_2011 = listMahasiswa_2011.get(i_2011);
			sb_2011.append(String.format("%-2d. %-12s | NIM: %-10s | %s\n",
					i_2011 + 1, m_2011.getNama_2011(), m_2011.getNim_2011(), m_2011.getFakultas_2011()));
		}
		DMhs_2011.setText(sb_2011.toString());
	}

	private void startSorting_2011(final JComboBox<String> combo_2011) {
		if (listMahasiswa_2011.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Data masih kosong!", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		final String pilihan_2011 = (String) combo_2011.getSelectedItem();
		SMhs_2011.setText("=== MEMULAI SORTING ===\nData Awal: " + formatList_2011() + "\n\n");

		Thread thread_2011 = new Thread(new Runnable() {
			public void run() {
				try {
					if ("Insertion Sort".equals(pilihan_2011)) {
						insertionSort_2011();
					} else if ("Selection Sort".equals(pilihan_2011)) {
						selectionSort_2011();
					} else if ("Bubble Sort".equals(pilihan_2011)) {
						bubbleSort_2011();
					}
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							SMhs_2011.append("\nProses Selesai!");
							updateDisplay_2011();
						}
					});
				} catch (InterruptedException ex_2011) {
					ex_2011.printStackTrace();
				}
			}
		});
		thread_2011.start();
	}

	private String formatList_2011() {
		StringBuilder sb_2011 = new StringBuilder("[");
		for (int i_2011 = 0; i_2011 < listMahasiswa_2011.size(); i_2011++) {
			sb_2011.append(listMahasiswa_2011.get(i_2011).getNama_2011());
			if (i_2011 < listMahasiswa_2011.size() - 1) sb_2011.append(", ");
		}
		sb_2011.append("]");
		return sb_2011.toString();
	}

	private void logStep_2011(final String msg_2011) throws InterruptedException {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				SMhs_2011.append(msg_2011 + "\n");
				SMhs_2011.setCaretPosition(SMhs_2011.getDocument().getLength());
			}
		});
		Thread.sleep(500);
	}

	private void resetData_2011() {
		listMahasiswa_2011.clear();
		DMhs_2011.setText("");
		SMhs_2011.setText("");
		FName_2011.setText("");
		FNim_2011.setText("");
		FFakultas_2011.setText("");
	}

	private void insertionSort_2011() throws InterruptedException {
		logStep_2011(">> INSERTION SORT");
		for (int i_2011 = 1; i_2011 < listMahasiswa_2011.size(); i_2011++) {
			Mahasiswa_2011 key_2011 = listMahasiswa_2011.get(i_2011);
			int j_2011 = i_2011 - 1;
			while (j_2011 >= 0 && listMahasiswa_2011.get(j_2011).getNama_2011().compareToIgnoreCase(key_2011.getNama_2011()) > 0) {
				listMahasiswa_2011.set(j_2011 + 1, listMahasiswa_2011.get(j_2011));
				j_2011--;
			}
			listMahasiswa_2011.set(j_2011 + 1, key_2011);
			logStep_2011("Langkah " + i_2011 + ": " + formatList_2011());
		}
	}

	private void selectionSort_2011() throws InterruptedException {
		logStep_2011(">> SELECTION SORT");
		for (int i_2011 = 0; i_2011 < listMahasiswa_2011.size() - 1; i_2011++) {
			int minIdx_2011 = i_2011;
			for (int j_2011 = i_2011 + 1; j_2011 < listMahasiswa_2011.size(); j_2011++) {
				if (listMahasiswa_2011.get(j_2011).getNama_2011().compareToIgnoreCase(listMahasiswa_2011.get(minIdx_2011).getNama_2011()) < 0) {
					minIdx_2011 = j_2011;
				}
			}
			Mahasiswa_2011 temp_2011 = listMahasiswa_2011.get(i_2011);
			listMahasiswa_2011.set(i_2011, listMahasiswa_2011.get(minIdx_2011));
			listMahasiswa_2011.set(minIdx_2011, temp_2011);
			logStep_2011("Pass " + (i_2011 + 1) + ": " + formatList_2011());
		}
	}

	private void bubbleSort_2011() throws InterruptedException {
		logStep_2011(">> BUBBLE SORT");
		int n_2011 = listMahasiswa_2011.size();
		for (int i_2011 = 0; i_2011 < n_2011 - 1; i_2011++) {
			boolean swapped_2011 = false;
			for (int j_2011 = 0; j_2011 < n_2011 - i_2011 - 1; j_2011++) {
				if (listMahasiswa_2011.get(j_2011).getNama_2011().compareToIgnoreCase(listMahasiswa_2011.get(j_2011 + 1).getNama_2011()) > 0) {
					Mahasiswa_2011 temp_2011 = listMahasiswa_2011.get(j_2011);
					listMahasiswa_2011.set(j_2011, listMahasiswa_2011.get(j_2011 + 1));
					listMahasiswa_2011.set(j_2011 + 1, temp_2011);
					swapped_2011 = true;
				}
			}
			logStep_2011("Pass " + (i_2011 + 1) + ": " + formatList_2011());
			if (!swapped_2011) break;
		}
	}

	static class Mahasiswa_2011 {
		private String nama_2011;
		private String nim_2011;
		private String fakultas_2011;

		public Mahasiswa_2011() {
		}

		public Mahasiswa_2011(String nama_2011, String nim_2011, String fakultas_2011) {
			this.nama_2011 = nama_2011;
			this.nim_2011 = nim_2011;
			this.fakultas_2011 = fakultas_2011;
		}

		public String getNama_2011() {
			return nama_2011;
		}

		public void setNama_2011(String nama_2011) {
			this.nama_2011 = nama_2011;
		}

		public String getNim_2011() {
			return nim_2011;
		}

		public void setNim_2011(String nim_2011) {
			this.nim_2011 = nim_2011;
		}

		public String getFakultas_2011() {
			return fakultas_2011;
		}

		public void setFakultas_2011(String fakultas_2011) {
			this.fakultas_2011 = fakultas_2011;
		}
	}
}