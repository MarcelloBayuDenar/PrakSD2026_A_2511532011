package pekan7_2511532011;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JTextArea;
import java.awt.Font;

public class InsertionSortGUI_2511532011 extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private int[] array_2011;
	private JLabel [] labelArray_2011;
	private JButton stepButton_2011, resetButton_2011, setButton_2011;
	private JTextField inputField_2011;
	private JPanel panelArray_2011;
	private JTextArea stepArea_2011;
	
	private int i_2011 = 1, j_2011;
	private boolean sorting_2011 = false;
	private int stepCount_2011 = 1;


	/**
	 * Create the frame.
	 */
	public InsertionSortGUI_2511532011() {
	    setTitle("Insertion Sort Langkah per Langkah");
	    setSize(750, 400);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationRelativeTo(null);
	    setLayout(new BorderLayout());

	    // Panel input
	    JPanel inputPanel_2011 = new JPanel(new FlowLayout());
	    inputField_2011 = new JTextField(30);
	    setButton_2011 = new JButton("Set Array");
	    inputPanel_2011.add(new JLabel("Masukkan angka (pisahkan dengan koma):"));
	    inputPanel_2011.add(inputField_2011);
	    inputPanel_2011.add(setButton_2011);

	    // Panel array visual
	    panelArray_2011 = new JPanel();
	    panelArray_2011.setLayout(new FlowLayout());

	    // Panel kontrol
	    JPanel controlPanel_2011 = new JPanel();
	    stepButton_2011 = new JButton("Langkah Selanjutnya");
	    resetButton_2011 = new JButton("Reset");
	    stepButton_2011.setEnabled(false);
	    controlPanel_2011.add(stepButton_2011);
	    controlPanel_2011.add(resetButton_2011);
	    
	 // Area teks untuk log langkah-langkah
	    stepArea_2011 = new JTextArea(8, 60);
	    stepArea_2011.setEditable(false);
	    stepArea_2011.setFont(new Font("Monospaced", Font.PLAIN, 14));
	    JScrollPane scrollPane_2011 = new JScrollPane(stepArea_2011);

	    // Tambahkan panel ke frame
	    add(inputPanel_2011, BorderLayout.NORTH);
	    add(panelArray_2011, BorderLayout.CENTER);
	    add(controlPanel_2011, BorderLayout.SOUTH);
	    add(scrollPane_2011, BorderLayout.EAST);

	    // Event Set Array
	    setButton_2011.addActionListener(e_2011 -> setArrayFromInput_2011());

	    // Event Langkah Selanjutnya
	    stepButton_2011.addActionListener(e_2011 -> performStep_2011());

	    // Event Reset
	    resetButton_2011.addActionListener(e_2011 -> reset_2011());
	    
	}
	
	private void setArrayFromInput_2011() {
	    String text_2011 = inputField_2011.getText().trim();
	    if (text_2011.isEmpty()) return;
	    String[] parts_2011 = text_2011.split(",");
	    array_2011 = new int[parts_2011.length];
	    try {
	        for (int k_2011 = 0; k_2011 < parts_2011.length; k_2011++) {
	            array_2011[k_2011] = Integer.parseInt(parts_2011[k_2011].trim());
	        }
	    } catch (NumberFormatException e_2011) {
	        JOptionPane.showMessageDialog(this, "Masukkan hanya angka yang dipisahkan "
	                + "dengan koma!", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    i_2011 = 1;
	    stepCount_2011 = 1;
	    sorting_2011 = true;
	    stepButton_2011.setEnabled(true);
	    stepArea_2011.setText("");
	    panelArray_2011.removeAll();
	    labelArray_2011 = new JLabel[array_2011.length];

	    for (int k_2011 = 0; k_2011 < array_2011.length; k_2011++) {
	        labelArray_2011[k_2011] = new JLabel(String.valueOf(array_2011[k_2011]));
	        labelArray_2011[k_2011].setFont(new Font("Arial", Font.BOLD, 24));
	        labelArray_2011[k_2011].setBorder(BorderFactory.createLineBorder(Color.BLACK));
	        labelArray_2011[k_2011].setPreferredSize(new Dimension(50, 50));
	        labelArray_2011[k_2011].setHorizontalAlignment(SwingConstants.CENTER);
	        panelArray_2011.add(labelArray_2011[k_2011]);
	    }

	    panelArray_2011.revalidate();
	    panelArray_2011.repaint();
	}
	
	private void performStep_2011() {
		if ( i_2011 < array_2011.length && sorting_2011 ) {
			int key_2011 = array_2011[i_2011];
			j_2011 = i_2011 - 1;
			
			StringBuilder stepLog_2011 = new StringBuilder();
			stepLog_2011.append("Langkah ").append(key_2011).append("\n");
			
			while (j_2011 >= 0 && array_2011[j_2011] > key_2011) {
				array_2011[j_2011 + 1] = array_2011[j_2011];
				j_2011 --;
			}
			array_2011[j_2011 + 1] = key_2011;
			
			updateLabels_2011();
			stepLog_2011.append("Hasil: ").append(arrayToString_2011(array_2011)).append("\n\n");
			stepArea_2011.append(stepLog_2011.toString());
			
			i_2011++;
			stepCount_2011++;
			
			if ( i_2011 == array_2011.length) {
				sorting_2011 = false;
				stepButton_2011.setEnabled(false);
				JOptionPane.showMessageDialog(this, "Sorting Selesai!");
			}
		}
	}
	
	private void updateLabels_2011() {
	    for (int k_2011 = 0; k_2011 < array_2011.length; k_2011++) {
	        labelArray_2011[k_2011].setText(String.valueOf(array_2011[k_2011]));
	    }
	}

	private void reset_2011() {
	    inputField_2011.setText("");
	    panelArray_2011.removeAll();
	    panelArray_2011.revalidate();
	    panelArray_2011.repaint();
	    stepArea_2011.setText("");
	    stepButton_2011.setEnabled(false);
	    sorting_2011 = false;
	    i_2011 = 1;
	    stepCount_2011 = 1;
	}

	private String arrayToString_2011(int[] arr_2011) {
	    StringBuilder sb_2011 = new StringBuilder();
	    for (int k_2011 = 0; k_2011 < arr_2011.length; k_2011++) {
	        sb_2011.append(arr_2011[k_2011]);
	        if (k_2011 < arr_2011.length - 1) sb_2011.append(", ");
	    }
	    return sb_2011.toString();
	}

	public static void main(String[] args_2011) {
	    SwingUtilities.invokeLater(() -> {
	        InsertionSortGUI_2511532011 gui_2011 = new InsertionSortGUI_2511532011();
	        gui_2011.setVisible(true);
	    });
	}
}
