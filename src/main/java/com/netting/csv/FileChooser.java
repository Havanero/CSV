package com.netting.csv;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author cubanguy
 */
public class FileChooser extends JFrame{
 
    private JTextField filename = new JTextField();

    private FileChooser(){
        JPanel p = new JPanel();
        JButton open = new JButton("Open");
        open.addActionListener(new OpenL());
        p.add(open);
        Container cp = getContentPane();
        cp.add(p, BorderLayout.SOUTH);
        filename.setEditable(false);
        p= new JPanel();
        p.setLayout(new GridLayout(2,1));
        p.add(filename);
        cp.add(p, BorderLayout.NORTH);
    }
    
    private class OpenL implements ActionListener{

        public void actionPerformed(ActionEvent ae) {
            JFileChooser c = new JFileChooser();
            int rVal=c.showOpenDialog(FileChooser.this);
            if(rVal == JFileChooser.APPROVE_OPTION){
                filename.setText(c.getSelectedFile().toString());
            }
        }

    }
    
    
   public static void main(String[] args){
       
    JFrame frame = new FileChooser();
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(250,110);
    frame.setVisible(true);
   }
   
   
}