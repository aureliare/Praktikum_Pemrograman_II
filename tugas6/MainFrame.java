package tugas6;

import javax.swing.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Aplikasi Manajemen Mahasiswa");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Membuat Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem tambahMahasiswaItem = new JMenuItem("Tambah Data Mahasiswa");

        // Tambahkan item menu ke menu bar
        tambahMahasiswaItem.addActionListener(e -> bukaFormMahasiswaPanel());
        menu.add(tambahMahasiswaItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    private void bukaFormMahasiswaPanel() {
        setContentPane(new FormMahasiswaPanel());
        revalidate();
    }
}
