package tugas4;

import javax.swing.*;
import java.awt.event.*;

public class MouseListenerExample {
    public static void main(String[] args){
        //membuat frame
        JFrame frame = new JFrame("MouseListener Example");
        
        //membuat label untuk menampilkan pesan
        JLabel label = new JLabel("Arahkan dan klik mouse pada area ini.");
        
        //menambahkan mouselistener ke label
        label.addMouseListener(new MouseListener() {
            //dijalankan ketika mouse diklik (klik kiri, kanan, atau tengah)
            public void mouseClicked(MouseEvent e) {
                label.setText("Mouse Clicked at: (" + e.getX() + "," + e.getY() + ")");
            }
            
            //dijalankan ketika mouse diklik (klik kiri, kanan, atau tengah)
            public void mousePressed(MouseEvent e) {
                label.setText("Mouse Pressed at: (" + e.getX() + "," + e.getY() + ")");
            }
            
            //dijalankan ketika mouse diklik (klik kiri, kanan, atau tengah)
            public void mouseReleased(MouseEvent e) {
                label.setText("Mouse Released at: (" + e.getX() + "," + e.getY() + ")");
            }
            
            //dijalankan ketika mouse diklik (klik kiri, kanan, atau tengah)
            public void mouseEntered(MouseEvent e) {
                label.setText("Mouse Entered at: (" + e.getX() + "," + e.getY() + ")");
            }
            
            //dijalankan ketika mouse diklik (klik kiri, kanan, atau tengah)
            public void mouseExited(MouseEvent e) {
                label.setText("Mouse Exited at: (" + e.getX() + "," + e.getY() + ")");
            }
        });
        
        //menambahkan label ke frame
        frame.add(label);
        
        //setting frame
        frame.setSize(400, 200);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}