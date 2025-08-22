package travel.management.system;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;   // ✅ from rs2xml.jar

public class ViewCustomers extends JFrame {
    private JPanel contentPane;
    private JTable table;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                ViewCustomers frame = new ViewCustomers();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public ViewCustomers() throws SQLException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(580, 220, 900, 680);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout());

        // JTable inside JScrollPane
        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        // Fetch data from database
        try {
            Conn c = new Conn();
            String sql = "SELECT * FROM customer";
            ResultSet rs = c.s.executeQuery(sql);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Bottom panel
        JPanel bottomPanel = new JPanel(null);
        bottomPanel.setPreferredSize(new Dimension(900, 230));

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(390, 10, 120, 30);
        btnBack.setBackground(Color.BLACK);
        btnBack.setForeground(Color.WHITE);
        btnBack.addActionListener(e -> setVisible(false));
        bottomPanel.add(btnBack);

        // Left image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/viewall.jpg"));
        Image i3 = i1.getImage().getScaledInstance(626, 201, Image.SCALE_SMOOTH);
        JLabel l1 = new JLabel(new ImageIcon(i3));
        l1.setBounds(0, 50, 626, 201);
        bottomPanel.add(l1);

        // Right image
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/viewall.jpg"));
        Image i5 = i4.getImage().getScaledInstance(626, 201, Image.SCALE_SMOOTH);
        JLabel l2 = new JLabel(new ImageIcon(i5));
        l2.setBounds(615, 50, 626, 201);
        bottomPanel.add(l2);

        contentPane.add(bottomPanel, BorderLayout.SOUTH);

        getContentPane().setBackground(Color.WHITE);
    }
}
