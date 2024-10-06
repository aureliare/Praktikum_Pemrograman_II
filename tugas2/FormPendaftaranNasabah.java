import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class FormPendaftaranNasabah extends JFrame {

    private JTextArea textAreaOutput;

    public FormPendaftaranNasabah() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel panelNama = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel labelNama = new JLabel("Nama: ");
        JTextField textFieldNama = new JTextField(20);
        panel.add(panelNama);
        panelNama.add(labelNama);
        panelNama.add(textFieldNama);

        JPanel panelHP = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel labelHP = new JLabel("Nomor HP: ");
        JTextField textFieldHP = new JTextField(20);
        panel.add(panelHP);
        panelHP.add(labelHP);
        panelHP.add(textFieldHP);

        JPanel panelJK = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel labelJK = new JLabel("Jenis Kelamin: ");
        JRadioButton radioButtonP = new JRadioButton("Perempuan", true);
        JRadioButton radioButtonL = new JRadioButton("Laki - laki");
        ButtonGroup bgJK = new ButtonGroup();
        bgJK.add(radioButtonP);
        bgJK.add(radioButtonL);
        panel.add(panelJK);
        panelJK.add(labelJK);
        panelJK.add(radioButtonP);
        panelJK.add(radioButtonL);
       
        JPanel panelWNA = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel labelWNA = new JLabel("Warga Negara Asing");
        JCheckBox checkBoxWNA = new JCheckBox();
        panel.add(panelWNA);
        panelWNA.add(labelWNA);
        panelWNA.add(checkBoxWNA);

        JPanel panelJT = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel labelJT = new JLabel("Jenis Tabungan: ");
        String[] optionJT = {"Tabungan Reguler", "Tabungan Berjangka", "Tabungan Giro", "Tabungan Pendidikan"};
        JList<String> listJT = new JList<>(optionJT);
        listJT.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(listJT);
        scrollPane.setPreferredSize(new Dimension(200, 60));
        panel.add(panelJT);
        panelJT.add(labelJT);
        panelJT.add(scrollPane);

        JPanel panelFK = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel labelFK = new JLabel("Frekuensi Transaksi: ");
        JSpinner spinnerFK = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
        panel.add(panelFK);
        panelFK.add(labelFK);
        panelFK.add(spinnerFK);

        JPanel panelPassword = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel labelPassword = new JLabel("Password: ");
        JPasswordField passwordField = new JPasswordField(20);
        panel.add(panelPassword);
        panelPassword.add(labelPassword);
        panelPassword.add(passwordField);

        JPanel panelPasswordConfirm = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel labelPasswordConfirm = new JLabel("Konfirmasi Password: ");
        JPasswordField passwordConfirmField = new JPasswordField(20);
        panel.add(panelPasswordConfirm);
        panelPasswordConfirm.add(labelPasswordConfirm);
        panelPasswordConfirm.add(passwordConfirmField);

        JPanel panelTL = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel labelTL = new JLabel("Tanggal lahir: ");
        Calendar calendar = Calendar.getInstance();
        SpinnerDateModel dateModel = new SpinnerDateModel(calendar.getTime(), null, null, Calendar.YEAR);
        JSpinner spinnerTL = new JSpinner(dateModel);
        spinnerTL.setEditor(new JSpinner.DateEditor(spinnerTL));
        panel.add(panelTL);
        panelTL.add(labelTL);
        panelTL.add(spinnerTL);

        textAreaOutput = new JTextArea(10, 30);
        textAreaOutput.setEditable(false);
        JScrollPane outputScrollPane = new JScrollPane(textAreaOutput);
        panel.add(outputScrollPane);

        JButton buttonSimpan = new JButton("Simpan");
        panel.add(buttonSimpan);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem reset = new JMenuItem("Reset");
        JMenuItem exit = new JMenuItem("Exit");
        this.setJMenuBar(menuBar);
        menuBar.add(menu);
        menu.add(reset);
        menu.add(exit);

        buttonSimpan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nama = textFieldNama.getText();
                String nomorHP = textFieldHP.getText();
                String jenisKelamin = radioButtonP.isSelected() ? "Perempuan" : "Perempuan";
                String WNA = checkBoxWNA.isSelected() ? "Ya" : "Tidak";
                String jenisTabungan = listJT.getSelectedValue();
                int frekuensiTransaksi = (int) spinnerFK.getValue();
                String password = new String(passwordField.getPassword());
                String passwordConfirm = new String(passwordConfirmField.getPassword());
               
                String passwordMassage = password.equals(passwordConfirm) ? "Password Cocok" : "Password Tidak Cocok";
                String tanggalLahir = ((JSpinner.DateEditor) spinnerTL.getEditor()).getFormat().format(spinnerTL.getValue());

                textAreaOutput.append("=====Biodata=====\n");
                textAreaOutput.append("Nama: " +nama+ "\n");
                textAreaOutput.append("Nomor HP: " +nomorHP+ "\n");
                textAreaOutput.append("Jenis Kelamin: "+jenisKelamin+"\n");
                textAreaOutput.append("Warga Negara Asing: "+WNA+"\n");
                textAreaOutput.append("Jenis Tabungan: "+jenisTabungan+"\n");
                textAreaOutput.append("Frekuensi Transaksi: "+frekuensiTransaksi+"\n");
                textAreaOutput.append("Tanggal Lahir: "+tanggalLahir+"\n");
                textAreaOutput.append(passwordMassage + "\n");
                textAreaOutput.append("=================\n\n");
                
            }
        });

        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textFieldNama.setText("");
                textFieldHP.setText("");
                passwordField.setText("");
                passwordConfirmField.setText("");
                listJT.clearSelection();
                spinnerFK.setValue(1);
                spinnerTL.setValue(calendar.getTime());
                checkBoxWNA.setSelected(false);
                textAreaOutput.setText(""); // buat clear output when reset
            }
        });

        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });

        this.add(panel);
        this.setTitle("From Pendaftaran Nasabah Bank");
        this.setSize(400, 600);
        this.setVisible(true);

     }
  
     public static void main(String[] args) {
         javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                FormPendaftaranNasabah h = new FormPendaftaranNasabah();
                h.setVisible(true);
            }
         });
     }

}
