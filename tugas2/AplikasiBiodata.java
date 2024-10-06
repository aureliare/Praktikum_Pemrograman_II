import java.awt.event.*;
import javax.swing.*;

public class AplikasiBiodata extends JFrame {

    private boolean checkBoxSelected;

    public AplikasiBiodata() {
        this.checkBoxSelected = false;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labelInput = new JLabel("Nama :");
        labelInput.setBounds(15, 40, 350, 10);

        JTextField textField = new JTextField();
        textField.setBounds(15, 60, 350, 30);

        JLabel labelInput2 = new JLabel("Nomor HP :");
        labelInput2.setBounds(15, 100, 350, 10);

        JTextField textField2 = new JTextField();
        textField2.setBounds(15, 120, 350, 30);

        JLabel labelRadio = new JLabel("Jenis Kelamin :");
        labelRadio.setBounds(15, 160, 350, 10);

        JRadioButton radioButton1 = new JRadioButton("Laki-laki", true);
        radioButton1.setBounds(15, 185, 350, 30);

        JRadioButton radioButton2 = new JRadioButton("Perempuan", true);
        radioButton2.setBounds(15, 225, 350, 30);

        JCheckBox checkBox = new JCheckBox("Warga Negara Asing");
        checkBox.setBounds(15, 255, 350, 30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);

        JButton button = new JButton("Simpan");
        button.setBounds(15, 295, 100, 40);

        JTextArea txtOutput = new JTextArea("");
        txtOutput.setBounds(15, 340, 350, 100);

        checkBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                checkBoxSelected = e.getStateChange()==1;
            }
        });

        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String jenisKelamin = "";
                if(radioButton1.isSelected()){
                    jenisKelamin = radioButton1.getText();
                }
                if(radioButton2.isSelected()){
                    jenisKelamin = radioButton2.getText();
                }

                String nama = textField.getText();
                String nomorhp = textField2.getText();
                String warganegara = checkBoxSelected ? "YA" : "BUKAN";

                txtOutput.append("Nama : "+nama+"\n");
                txtOutput.append("Nomor HP : "+nomorhp+"\n");
                txtOutput.append("Jenis Kelamin : "+jenisKelamin+"\n");
                txtOutput.append("WNA : "+warganegara+"\n");
                textField.setText("");
            }
        });

        this.add(button);
        this.add(textField);
        this.add(textField2);
        this.add(labelRadio);
        this.add(radioButton1);
        this.add(radioButton2);
        this.add(checkBox);
        this.add(labelInput);
        this.add(labelInput2);
        this.add(txtOutput);

        this.setSize(400, 500);
        this.setLayout(null);
     }
  
     public static void main(String[] args) {
         javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                AplikasiBiodata h = new AplikasiBiodata();
                h.setVisible(true);
            }
         });
     }

}
