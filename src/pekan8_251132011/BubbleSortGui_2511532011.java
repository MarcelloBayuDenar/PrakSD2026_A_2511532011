package pekan8_251132011;

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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BubbleSortGui_2511532011 extends JFrame {

    private JTextField inputField_2011;
    private JButton setButton_2011;
    private JButton stepButton_2011;
    private JButton resetButton_2011;
    private JTextArea stepArea_2011;
    private JPanel panelArray_2011;

    private int[] array_2011;
    private JLabel[] labelArray_2011;

    private int i_2011 = 0;
    private int j_2011 = 0;
    private int stepCount_2011 = 1;
    private boolean sorting_2011 = false;

    public BubbleSortGui_2511532011() {
        setTitle("Visualisasi Bubble Sort");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel inputPanel = new JPanel(new FlowLayout());

        JLabel inputLabel = new JLabel("Masukkan angka (pisahkan dengan koma):");
        inputField_2011 = new JTextField(30);

        setButton_2011 = new JButton("Set Array");
        stepButton_2011 = new JButton("Step");
        resetButton_2011 = new JButton("Reset");

        stepButton_2011.setEnabled(false);

        inputPanel.add(inputLabel);
        inputPanel.add(inputField_2011);
        inputPanel.add(setButton_2011);
        inputPanel.add(stepButton_2011);
        inputPanel.add(resetButton_2011);

        add(inputPanel, BorderLayout.NORTH);

        panelArray_2011 = new JPanel(new FlowLayout());
        panelArray_2011.setPreferredSize(new Dimension(750, 120));
        add(panelArray_2011, BorderLayout.CENTER);

        stepArea_2011 = new JTextArea();
        stepArea_2011.setEditable(false);
        stepArea_2011.setFont(new Font("Monospaced", Font.PLAIN, 14));

        JScrollPane scrollPane = new JScrollPane(stepArea_2011);
        scrollPane.setPreferredSize(new Dimension(750, 250));

        add(scrollPane, BorderLayout.SOUTH);

        setButton_2011.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setArrayFromInput();
            }
        });

        stepButton_2011.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performStep();
            }
        });

        resetButton_2011.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset();
            }
        });
    }

    private void setArrayFromInput() {
        String text = inputField_2011.getText().trim();

        if (text.isEmpty()) {
            return;
        }

        String[] parts_2011 = text.split(",");
        array_2011 = new int[parts_2011.length];

        try {
            for (int k_2011 = 0; k_2011 < parts_2011.length; k_2011++) {
                array_2011[k_2011] = Integer.parseInt(parts_2011[k_2011].trim());
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Masukkan hanya angka yang dipisahkan koma!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        i_2011 = 0;
        j_2011 = 0;
        stepCount_2011 = 1;
        sorting_2011 = true;

        stepButton_2011.setEnabled(true);
        stepArea_2011.setText("");
        panelArray_2011.removeAll();

        labelArray_2011 = new JLabel[array_2011.length];

        for (int k_2011 = 0; k_2011 < array_2011.length; k_2011++) {
            labelArray_2011[k_2011] = new JLabel(String.valueOf(array_2011[k_2011]));
            labelArray_2011[k_2011].setFont(new Font("Arial", Font.BOLD, 24));
            labelArray_2011[k_2011].setOpaque(true);
            labelArray_2011[k_2011].setBackground(Color.WHITE);
            labelArray_2011[k_2011].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            labelArray_2011[k_2011].setPreferredSize(new Dimension(50, 50));
            labelArray_2011[k_2011].setHorizontalAlignment(SwingConstants.CENTER);

            panelArray_2011.add(labelArray_2011[k_2011]);
        }

        panelArray_2011.revalidate();
        panelArray_2011.repaint();
    }

    private void performStep() {
        if (!sorting_2011 || i_2011 >= array_2011.length - 1) {
            sorting_2011 = false;
            stepButton_2011.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Sorting selesai!");
            return;
        }

        resetHighlights();

        StringBuilder stepLog_2011 = new StringBuilder();

        labelArray_2011[j_2011].setBackground(Color.CYAN);
        labelArray_2011[j_2011 + 1].setBackground(Color.CYAN);

        if (array_2011[j_2011] > array_2011[j_2011 + 1]) {
            int temp_2011 = array_2011[j_2011];
            array_2011[j_2011] = array_2011[j_2011 + 1];
            array_2011[j_2011 + 1] = temp_2011;

            labelArray_2011[j_2011].setBackground(Color.RED);
            labelArray_2011[j_2011 + 1].setBackground(Color.RED);

            stepLog_2011.append("Langkah ").append(stepCount_2011).append(": ")
                    .append("Menukar elemen ke-").append(j_2011)
                    .append(" (").append(array_2011[j_2011 + 1]).append(")")
                    .append(" dengan ke-").append(j_2011 + 1)
                    .append(" (").append(array_2011[j_2011]).append(")\n");

        } else {
            stepLog_2011.append("Langkah ").append(stepCount_2011).append(": ")
                    .append("Tidak ada pertukaran antara ke-")
                    .append(j_2011).append(" dan ke-")
                    .append(j_2011 + 1).append("\n");
        }

        stepLog_2011.append("Hasil: ").append(arrayToString(array_2011)).append("\n\n");
        stepArea_2011.append(stepLog_2011.toString());

        updateLabels();

        j_2011++;

        if (j_2011 >= array_2011.length - 1 - i_2011) {
            j_2011 = 0;
            i_2011++;
        }

        stepCount_2011++;

        if (i_2011 >= array_2011.length - 1) {
            sorting_2011 = false;
            stepButton_2011.setEnabled(false);
            resetHighlights();

            for (JLabel label_2011 : labelArray_2011) {
                label_2011.setBackground(Color.GREEN);
            }

            JOptionPane.showMessageDialog(this, "Sorting selesai!");
        }
    }

    private void updateLabels() {
        for (int k_2011 = 0; k_2011 < array_2011.length; k_2011++) {
            labelArray_2011[k_2011].setText(String.valueOf(array_2011[k_2011]));
        }
    }

    private void resetHighlights() {
        for (JLabel label_2011 : labelArray_2011) {
            label_2011.setBackground(Color.WHITE);
        }
    }

    private void reset() {
        inputField_2011.setText("");
        panelArray_2011.removeAll();
        panelArray_2011.revalidate();
        panelArray_2011.repaint();

        stepArea_2011.setText("");
        stepButton_2011.setEnabled(false);

        sorting_2011 = false;
        i_2011 = 0;
        j_2011 = 0;
        stepCount_2011 = 1;
    }

    private String arrayToString(int[] arr) {
        StringBuilder sb_2011 = new StringBuilder();

        for (int k_2011 = 0; k_2011 < arr.length; k_2011++) {
            sb_2011.append(arr[k_2011]);

            if (k_2011 < arr.length - 1) {
                sb_2011.append(", ");
            }
        }

        return sb_2011.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BubbleSortGui_2511532011().setVisible(true);
            }
        });
    }
}