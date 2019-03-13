package Panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MethodSelection extends JPanel  implements ActionListener {
    private final String[] methods = {"And Elim","Or Elim"};
    private JComboBox<String> methodsSel = new JComboBox<>(methods);


    public MethodSelection(){
        this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
        this.add(methodsSel);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == methodsSel){
            System.out.println("Drop Box clicked");
        }
    }
}
