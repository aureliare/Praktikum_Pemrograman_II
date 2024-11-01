package tugas6;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormMahasiswaPanel extends JPanel {
    private JTextField namaField;
    private JComboBox<String> jurusanCombo;
    private JRadioButton lakiRadio, perempuanRadio;
    private JCheckBox olahragaCheckBox, musikCheckBox, seniCheckBox;
    private JSlider umurSlider;
    private JTable tabelMahasiswa;
    private DefaultTableModel tableModel;
    private ButtonGroup genderGroup;

    public FormMahasiswaPanel() {
        setLayout(new BorderLayout());

        // Panel Form
        JPanel formPanel = new JPanel(new GridLayout(0, 2, 5, 5));

        // Nama
        formPanel.add(new JLabel("Nama:"));
        namaField = new JTextField();
        formPanel.add(namaField);

        // Jurusan
        formPanel.add(new JLabel("Jurusan:"));
        jurusanCombo = new JComboBox<>(new String[]{"Teknik Informatika", "Teknik Industri", "Teknik Mesin", "Teknologi Pangan"});
        formPanel.add(jurusanCombo);

        // Jenis Kelamin
        formPanel.add(new JLabel("Jenis Kelamin:"));
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        lakiRadio = new JRadioButton("Laki-laki");
        perempuanRadio = new JRadioButton("Perempuan");
        genderGroup = new ButtonGroup();  // Inisialisasi genderGroup
        genderGroup.add(lakiRadio);
        genderGroup.add(perempuanRadio);
        genderPanel.add(lakiRadio);
        genderPanel.add(perempuanRadio);
        formPanel.add(genderPanel);

        // Hobi
        formPanel.add(new JLabel("Hobi:"));
        JPanel hobiPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        olahragaCheckBox = new JCheckBox("Olahraga");
        musikCheckBox = new JCheckBox("Musik");
        seniCheckBox = new JCheckBox("Seni");
        hobiPanel.add(olahragaCheckBox);
        hobiPanel.add(musikCheckBox);
        hobiPanel.add(seniCheckBox);
        formPanel.add(hobiPanel);

        // Umur (Slider)
        formPanel.add(new JLabel("Umur:"));
        umurSlider = new JSlider(16, 60, 20);
        umurSlider.setMajorTickSpacing(10);
        umurSlider.setMinorTickSpacing(2);
        umurSlider.setPaintTicks(true);
        umurSlider.setPaintLabels(true);
        formPanel.add(umurSlider);

        // Tombol Submit
        JButton submitButton = new JButton("Simpan");
        submitButton.addActionListener(new SubmitAction());
        formPanel.add(submitButton);

        add(formPanel, BorderLayout.NORTH);

        // Tabel Data Mahasiswa
        tableModel = new DefaultTableModel(new Object[]{"Nama", "Jurusan", "Jenis Kelamin", "Hobi", "Umur"}, 0);
        tabelMahasiswa = new JTable(tableModel);
        add(new JScrollPane(tabelMahasiswa), BorderLayout.CENTER);
    }

    private class SubmitAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Ambil data dari form
            String nama = namaField.getText();
            String jurusan = (String) jurusanCombo.getSelectedItem();
            String gender = lakiRadio.isSelected() ? "Laki-laki" : (perempuanRadio.isSelected() ? "Perempuan" : "");
            String hobi = (olahragaCheckBox.isSelected() ? "Olahraga " : "") +
                          (musikCheckBox.isSelected() ? "Musik " : "") +
                          (seniCheckBox.isSelected() ? "Seni" : "");
            int umur = umurSlider.getValue();

            // Tambah data ke tabel
            tableModel.addRow(new Object[]{nama, jurusan, gender, hobi, umur});
            
            // Reset form input
            namaField.setText("");
            jurusanCombo.setSelectedIndex(0);
            genderGroup.clearSelection();
            olahragaCheckBox.setSelected(false);
            musikCheckBox.setSelected(false);
            seniCheckBox.setSelected(false);
            umurSlider.setValue(20);
        }
    }
}
