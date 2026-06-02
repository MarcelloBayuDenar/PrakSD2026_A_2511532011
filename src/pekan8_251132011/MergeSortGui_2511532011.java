package pekan8_251132011;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import java.util.LinkedList;
import java.util.Queue;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class MergeSortGui_2511532011 extends JFrame {

    private static final long serialVersionUID_2011 = 1L;

    private int[] array_2011;
    private JLabel[] labelArray_2011;
    private JButton stepButton_2011, resetButton_2011, setButton_2011;
    private JTextField inputField_2011;
    private JPanel panelArray_2011;
    private JTextArea stepArea_2011;

    private int i_2011, j_2011, k_2011;
    private int left_2011, mid_2011, right_2011;
    private int[] temp_2011;

    private boolean isMerging_2011 = false;
    private boolean copying_2011 = false;
    private int stepCount_2011 = 1;

    private Queue<int[]> mergeQueue_2011 = new LinkedList<>();

    public MergeSortGui_2511532011() {
        setTitle("Merge Sort Langkah per Langkah");
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
            for (int i_2011 = 0; i_2011 < parts_2011.length; i_2011++) {
                array_2011[i_2011] = Integer.parseInt(parts_2011[i_2011].trim());
            }
        } catch (NumberFormatException e_2011) {
            JOptionPane.showMessageDialog(this, "Masukkan hanya angka!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        labelArray_2011 = new JLabel[array_2011.length];
        panelArray_2011.removeAll();

        for (int i_2011 = 0; i_2011 < array_2011.length; i_2011++) {
            labelArray_2011[i_2011] = new JLabel(String.valueOf(array_2011[i_2011]));
            labelArray_2011[i_2011].setFont(new Font("Arial", Font.BOLD, 24));
            labelArray_2011[i_2011].setOpaque(true);
            labelArray_2011[i_2011].setBackground(Color.WHITE);
            labelArray_2011[i_2011].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            labelArray_2011[i_2011].setPreferredSize(new Dimension(50, 50));
            labelArray_2011[i_2011].setHorizontalAlignment(SwingConstants.CENTER);
            panelArray_2011.add(labelArray_2011[i_2011]);
        }

        mergeQueue_2011.clear();
        generateMergeSteps_2011(0, array_2011.length - 1);

        stepButton_2011.setEnabled(true);
        stepArea_2011.setText("");
        stepCount_2011 = 1;
        isMerging_2011 = false;
        copying_2011 = false;

        panelArray_2011.revalidate();
        panelArray_2011.repaint();
    }

    private void generateMergeSteps_2011(int left_2011, int right_2011) {
        if (left_2011 < right_2011) {
            int mid_2011 = left_2011 + (right_2011 - left_2011) / 2;

            generateMergeSteps_2011(left_2011, mid_2011);
            generateMergeSteps_2011(mid_2011 + 1, right_2011);

            mergeQueue_2011.add(new int[] { left_2011, mid_2011, right_2011 });
        }
    }

    private void performStep_2011() {
        resetHighlights_2011();

        if (!isMerging_2011 && !mergeQueue_2011.isEmpty()) {
            int[] range_2011 = mergeQueue_2011.poll();

            left_2011 = range_2011[0];
            mid_2011 = range_2011[1];
            right_2011 = range_2011[2];

            temp_2011 = new int[right_2011 - left_2011 + 1];

            i_2011 = left_2011;
            j_2011 = mid_2011 + 1;
            k_2011 = 0;

            copying_2011 = false;
            isMerging_2011 = true;

            stepArea_2011.append(
                    "Langkah " + stepCount_2011++
                            + ": Mulai merge dari "
                            + left_2011 + " ke "
                            + right_2011 + "\n"
            );

            return;
        }

        if (isMerging_2011 && !copying_2011) {
            if (i_2011 <= mid_2011 && j_2011 <= right_2011) {
                labelArray_2011[i_2011].setBackground(Color.CYAN);
                labelArray_2011[j_2011].setBackground(Color.CYAN);

                if (array_2011[i_2011] <= array_2011[j_2011]) {
                    temp_2011[k_2011++] = array_2011[i_2011++];
                } else {
                    temp_2011[k_2011++] = array_2011[j_2011++];
                }

                stepArea_2011.append(
                        "Langkah " + stepCount_2011++
                                + ": Bandingkan dan salin elemen\n"
                );

                return;

            } else if (i_2011 <= mid_2011) {
                temp_2011[k_2011++] = array_2011[i_2011++];

                stepArea_2011.append(
                        "Langkah " + stepCount_2011++
                                + ": Salin sisa kiri\n"
                );

                return;

            } else if (j_2011 <= right_2011) {
                temp_2011[k_2011++] = array_2011[j_2011++];

                stepArea_2011.append(
                        "Langkah " + stepCount_2011++
                                + ": Salin sisa kanan\n"
                );

                return;

            } else {
                copying_2011 = true;
                k_2011 = 0;
                return;
            }
        }

        if (copying_2011 && k_2011 < temp_2011.length) {
            array_2011[left_2011 + k_2011] = temp_2011[k_2011];
            labelArray_2011[left_2011 + k_2011].setText(String.valueOf(temp_2011[k_2011]));
            labelArray_2011[left_2011 + k_2011].setBackground(Color.GREEN);
            k_2011++;

            stepArea_2011.append("Langkah " + stepCount_2011++ + ": Tempelkan ke array utama\n");
            return;
        }

        if (copying_2011 && k_2011 == temp_2011.length) {
            isMerging_2011 = false;
            copying_2011 = false;
        }

        if (mergeQueue_2011.isEmpty() && !isMerging_2011) {
            stepArea_2011.append("Selesai.\n");
            stepButton_2011.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Merge Sort selesai!");
        }
    }

    private void resetHighlights_2011() {
        if (labelArray_2011 == null) return;

        for (JLabel label_2011 : labelArray_2011) {
            label_2011.setBackground(Color.WHITE);
        }
    }

    private void reset_2011() {
        inputField_2011.setText("");
        panelArray_2011.removeAll();
        panelArray_2011.revalidate();
        panelArray_2011.repaint();
        stepArea_2011.setText("");
        stepButton_2011.setEnabled(false);
        mergeQueue_2011.clear();
        isMerging_2011 = false;
        copying_2011 = false;
        stepCount_2011 = 1;
    }

    public static void main(String[] args_2011) {
        SwingUtilities.invokeLater(() -> {
            MergeSortGui_2511532011 frame_2011 = new MergeSortGui_2511532011();
            frame_2011.setVisible(true);
        });
    }
}