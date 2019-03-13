package Panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ProofSentences extends JPanel implements ActionListener{
    private JTextField textField = new JTextField(20);
    private MethodSelection methodSelection = new MethodSelection();

    public ProofSentences( int left){
        SpringLayout layout = new SpringLayout();
        this.setLayout(layout);
        this.add(textField);
        this.add(methodSelection);
        layout.putConstraint(SpringLayout.WEST,textField,left,SpringLayout.WEST,this);
        layout.putConstraint(SpringLayout.NORTH,textField,0,SpringLayout.NORTH,this);
        layout.putConstraint(SpringLayout.EAST,this,5,SpringLayout.EAST,methodSelection);
        layout.putConstraint(SpringLayout.SOUTH,this,5,SpringLayout.SOUTH,textField);
        layout.putConstraint(SpringLayout.WEST, methodSelection, 5, SpringLayout.EAST, textField);
        layout.putConstraint(SpringLayout.NORTH, methodSelection, 0, SpringLayout.NORTH, this);
        this.setVisible(true);
        this.setBackground(Color.BLACK);
        this.setMaximumSize((new Dimension(Integer.MAX_VALUE,50)));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public synchronized void addActionListener(ActionListener a){
        textField.addActionListener(a);
    }

    public void setText(String text){
        textField.setText(text);
    }

    public String getText(){
        return textField.getText();
    }
}
