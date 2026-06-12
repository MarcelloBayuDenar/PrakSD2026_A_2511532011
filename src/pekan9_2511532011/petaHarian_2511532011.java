package pekan9_2511532011;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class petaHarian_2511532011 extends JFrame {

    private JComboBox<String> comboBoxAwal_2011;
    private JComboBox<String> comboBoxAkhir_2011;
    private JButton btnBfs_2011;
    private JButton btnDfs_2011;
    private JButton btnReset_2011;
    private JLabel lblJalur_2011;
    private JLabel lblNodeDikunjungi_2011;
    private JLabel lblJumlahNode_2011;
    private GraphPanel_2011 panelGrafik_2011;

    private Map<String, Vertex_2011> vertices_2011;
    private Map<String, List<String>> adjacencyList_2011;
    private List<String> visitedNodes_2011;
    private List<String> pathNodes_2011;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                petaHarian_2511532011 frame = new petaHarian_2511532011();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public petaHarian_2511532011() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(583, 700);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        initializeGraph_2011();

        JLabel lblLokasiAwal_2011 = new JLabel("Lokasi Awal:");
        lblLokasiAwal_2011.setBounds(10, 11, 80, 14);
        getContentPane().add(lblLokasiAwal_2011);

        comboBoxAwal_2011 = new JComboBox<>();
        comboBoxAwal_2011.setBounds(90, 7, 150, 22);
        for (String vertex : vertices_2011.keySet()) {
            comboBoxAwal_2011.addItem(vertex);
        }
        getContentPane().add(comboBoxAwal_2011);

        JLabel lblLokasiAkhir_2011 = new JLabel("Lokasi Tujuan:");
        lblLokasiAkhir_2011.setBounds(10, 36, 80, 14);
        getContentPane().add(lblLokasiAkhir_2011);

        comboBoxAkhir_2011 = new JComboBox<>();
        comboBoxAkhir_2011.setBounds(90, 32, 150, 22);
        for (String vertex : vertices_2011.keySet()) {
            comboBoxAkhir_2011.addItem(vertex);
        }
        getContentPane().add(comboBoxAkhir_2011);

        btnBfs_2011 = new JButton("BFS");
        btnBfs_2011.setBounds(260, 7, 80, 23);
        btnBfs_2011.addActionListener(e -> BFS_2011());
        getContentPane().add(btnBfs_2011);

        btnDfs_2011 = new JButton("DFS");
        btnDfs_2011.setBounds(350, 7, 80, 23);
        btnDfs_2011.addActionListener(e -> DFS_2011());
        getContentPane().add(btnDfs_2011);

        btnReset_2011 = new JButton("RESET");
        btnReset_2011.setBounds(440, 7, 80, 23);
        btnReset_2011.addActionListener(e -> resetGraph_2011());
        getContentPane().add(btnReset_2011);

        panelGrafik_2011 = new GraphPanel_2011();
        panelGrafik_2011.setBounds(10, 61, 500, 500);
        getContentPane().add(panelGrafik_2011);

        JLabel lblHasilPencarian_2011 = new JLabel("Hasil Pencarian:");
        lblHasilPencarian_2011.setBounds(10, 563, 150, 14);
        getContentPane().add(lblHasilPencarian_2011);

        lblJalur_2011 = new JLabel("Jalur: -");
        lblJalur_2011.setBounds(10, 577, 780, 14);
        getContentPane().add(lblJalur_2011);

        lblNodeDikunjungi_2011 = new JLabel("Node Dikunjungi: -");
        lblNodeDikunjungi_2011.setBounds(10, 595, 780, 14);
        getContentPane().add(lblNodeDikunjungi_2011);

        lblJumlahNode_2011 = new JLabel("Jumlah Node Dikunjungi: 0");
        lblJumlahNode_2011.setBounds(10, 612, 780, 14);
        getContentPane().add(lblJumlahNode_2011);
        
        displayGraph_2011();
    }

private void initializeGraph_2011() {
    vertices_2011 = new HashMap<>();
    adjacencyList_2011 = new HashMap<>();
    
    addVertex_2011("Kantin DPR", 240, 60);         
    addVertex_2011("ATB", 100, 110);                
    addVertex_2011("DTI", 380, 110);                
    
    addVertex_2011("Gedung Audit", 240, 190);       
    addVertex_2011("FISIP", 100, 280);            
    addVertex_2011("Gedung H", 380, 280);          
    
    addVertex_2011("Kos A", 80, 390);               
    addVertex_2011("Kos B", 200, 390);              
    addVertex_2011("Aciak Mart", 320, 390);        
    addVertex_2011("Feb Mart", 440, 390);           

    addEdge_2011("Kantin DPR", "ATB");             
    addEdge_2011("Kantin DPR", "DTI");             
    addEdge_2011("Kantin DPR", "Gedung Audit");                 
    
    addEdge_2011("ATB", "Gedung Audit");            
    addEdge_2011("DTI", "Gedung H");                
    addEdge_2011("DTI", "FISIP");                 
    
    addEdge_2011("Gedung Audit", "Gedung H");       
    addEdge_2011("Gedung Audit", "Kos B");         
    
    addEdge_2011("FISIP", "Kos A");                
    addEdge_2011("FISIP", "Kos B");                
    
    addEdge_2011("Kos A", "Kos B");                 
    addEdge_2011("Kos B", "Aciak Mart");            
    addEdge_2011("Aciak Mart", "Feb Mart");         
    addEdge_2011("Feb Mart", "Gedung H");           
    addEdge_2011("Aciak Mart", "Gedung H");        
}

    private void addVertex_2011(String name_2011, int x_2011, int y_2011) {
        vertices_2011.put(name_2011, new Vertex_2011(name_2011, x_2011, y_2011));
        adjacencyList_2011.put(name_2011, new ArrayList<>());
    }

    private void addEdge_2011(String v1_2011, String v2_2011) {
        adjacencyList_2011.get(v1_2011).add(v2_2011);
        adjacencyList_2011.get(v2_2011).add(v1_2011); 
    }


    public void BFS_2011() {
        String start_2011 = (String) comboBoxAwal_2011.getSelectedItem();
        String goal_2011 = (String) comboBoxAkhir_2011.getSelectedItem();
        
        if (start_2011 == null || goal_2011 == null || start_2011.equals(goal_2011)) {
            JOptionPane.showMessageDialog(this, "Pilih lokasi awal dan tujuan yang berbeda!");
            return;
        }

        Queue<String> queue_2011 = new LinkedList<>();
        Set<String> visited_2011 = new LinkedHashSet<>();
        Map<String, String> parent_2011 = new HashMap<>();

        queue_2011.add(start_2011);
        visited_2011.add(start_2011);
        boolean found_2011 = false;

        while (!queue_2011.isEmpty()) {
            String current_2011 = queue_2011.poll();

            if (current_2011.equals(goal_2011)) {
                found_2011 = true;
                break;
            }

            List<String> neighbors_2011 = new ArrayList<>(adjacencyList_2011.get(current_2011));
            Collections.sort(neighbors_2011); 

            for (String neighbor_2011 : neighbors_2011) {
                if (!visited_2011.contains(neighbor_2011)) {
                    visited_2011.add(neighbor_2011);
                    parent_2011.put(neighbor_2011, current_2011);
                    queue_2011.add(neighbor_2011);
                }
            }
        }

        if (found_2011) {
            List<String> path_2011 = new ArrayList<>();
            String curr_2011 = goal_2011;
            while (curr_2011 != null) {
                path_2011.add(curr_2011);
                curr_2011 = parent_2011.get(curr_2011);
            }
            Collections.reverse(path_2011);
            visitedNodes_2011 = new ArrayList<>(visited_2011);
            pathNodes_2011 = path_2011;
            displayPath_2011("BFS", path_2011, visitedNodes_2011);
        } else {
            JOptionPane.showMessageDialog(this, "Jalur tidak ditemukan!");
        }
    }

    public void DFS_2011() {
        String start_2011 = (String) comboBoxAwal_2011.getSelectedItem();
        String goal_2011 = (String) comboBoxAkhir_2011.getSelectedItem();
        
        if (start_2011 == null || goal_2011 == null || start_2011.equals(goal_2011)) {
            JOptionPane.showMessageDialog(this, "Pilih lokasi awal dan tujuan yang berbeda!");
            return;
        }

        Stack<String> stack_2011 = new Stack<>();
        Set<String> visited_2011 = new LinkedHashSet<>();
        Map<String, String> parent_2011 = new HashMap<>();

        stack_2011.push(start_2011);
        visited_2011.add(start_2011);
        boolean found_2011 = false;

        while (!stack_2011.isEmpty()) {
            String current_2011 = stack_2011.pop();

            if (current_2011.equals(goal_2011)) {
                found_2011 = true;
                break;
            }

            List<String> neighbors_2011 = new ArrayList<>(adjacencyList_2011.get(current_2011));
            Collections.sort(neighbors_2011);
            Collections.reverse(neighbors_2011); 

            for (String neighbor_2011 : neighbors_2011) {
                if (!visited_2011.contains(neighbor_2011)) {
                    visited_2011.add(neighbor_2011);
                    parent_2011.put(neighbor_2011, current_2011);
                    stack_2011.push(neighbor_2011);
                }
            }
        }

        if (found_2011) {
            List<String> path_2011 = new ArrayList<>();
            String curr_2011 = goal_2011;
            while (curr_2011 != null) {
                path_2011.add(curr_2011);
                curr_2011 = parent_2011.get(curr_2011);
            }
            Collections.reverse(path_2011);
            visitedNodes_2011 = new ArrayList<>(visited_2011);
            pathNodes_2011 = path_2011;
            displayPath_2011("DFS", path_2011, visitedNodes_2011);
        } else {
            JOptionPane.showMessageDialog(this, "Jalur tidak ditemukan!");
        }
    }

    public void displayGraph_2011() {
        panelGrafik_2011.repaint();
    }

    public void displayPath_2011(String method_2011, List<String> path_2011, List<String> visited_2011) {
        StringBuilder hasil_2011 = new StringBuilder();
        hasil_2011.append("<html><body style='width: 250px;'>");
        hasil_2011.append("<b>Metode: </b>").append(method_2011).append("<br><br>");
        hasil_2011.append("<b>Jalur Ditemukan:</b><br>");
        hasil_2011.append(String.join(" &rarr; ", path_2011)).append("<br><br>");
        hasil_2011.append("<b>Urutan Node Dikunjungi:</b><br>");
        hasil_2011.append(String.join(", ", visited_2011)).append("<br><br>");
        hasil_2011.append("<b>Jumlah Node Dikunjungi:</b> ").append(visited_2011.size());
        hasil_2011.append("</body></html>");
        
        lblJalur_2011.setText("Jalur: " + String.join(" -> ", path_2011));
        lblNodeDikunjungi_2011.setText("Node Dikunjungi: " + String.join(", ", visited_2011));
        lblJumlahNode_2011.setText("Jumlah Node Dikunjungi: " + visited_2011.size());
        
        displayGraph_2011();
    }

    public void resetGraph_2011() {
        visitedNodes_2011 = new ArrayList<>();
        pathNodes_2011 = new ArrayList<>();
        lblJalur_2011.setText("Jalur: -");
        lblNodeDikunjungi_2011.setText("Node Dikunjungi: -");
        lblJumlahNode_2011.setText("Jumlah Node Dikunjungi: 0");
        displayGraph_2011();
    }


    private static class Vertex_2011 {
        String name_2011;
        int x_2011, y_2011;
        Color color_2011 = Color.WHITE;

        Vertex_2011(String name_2011, int x_2011, int y_2011) {
            this.name_2011 = name_2011;
            this.x_2011 = x_2011;
            this.y_2011 = y_2011;
        }
    }

    private class GraphPanel_2011 extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d_2011 = (Graphics2D) g;
            g2d_2011.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            g2d_2011.setColor(Color.GRAY);
            g2d_2011.setStroke(new BasicStroke(2));
            for (String v1_2011 : adjacencyList_2011.keySet()) {
                Vertex_2011 vertex1_2011 = vertices_2011.get(v1_2011);
                for (String v2_2011 : adjacencyList_2011.get(v1_2011)) {
                    Vertex_2011 vertex2_2011 = vertices_2011.get(v2_2011);
                    g2d_2011.drawLine(vertex1_2011.x_2011, vertex1_2011.y_2011, vertex2_2011.x_2011, vertex2_2011.y_2011);
                }
            }

            for (Vertex_2011 v_2011 : vertices_2011.values()) {
                if (pathNodes_2011 != null && pathNodes_2011.contains(v_2011.name_2011)) {
                    v_2011.color_2011 = Color.GREEN; 
                } else if (visitedNodes_2011 != null && visitedNodes_2011.contains(v_2011.name_2011)) {
                    v_2011.color_2011 = Color.YELLOW;
                } else {
                    v_2011.color_2011 = Color.WHITE; 
                }

                g2d_2011.setColor(v_2011.color_2011);
                g2d_2011.fillOval(v_2011.x_2011 - 25, v_2011.y_2011 - 25, 50, 50);
                g2d_2011.setColor(Color.BLACK);
                g2d_2011.setStroke(new BasicStroke(2));
                g2d_2011.drawOval(v_2011.x_2011 - 25, v_2011.y_2011 - 25, 50, 50);

                g2d_2011.setFont(new Font("SansSerif", Font.BOLD, 11));
                FontMetrics fm_2011 = g2d_2011.getFontMetrics();
                int textWidth_2011 = fm_2011.stringWidth(v_2011.name_2011);
                g2d_2011.drawString(v_2011.name_2011, v_2011.x_2011 - (textWidth_2011 / 2), v_2011.y_2011 + 40);
            }
        }
    }
}