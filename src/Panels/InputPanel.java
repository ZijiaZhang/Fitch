package Panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;


public class InputPanel extends JPanel implements ActionListener {
    private static InputPanel inputPanel;
    private final int buttonSize_x = 20;
    private final int buttonSize_y = 40;
    private final String[] inputs = {"∧", "∨", "¬", "→", "↔", "⊥", "a", "b", "c", "d"
            , "e", "f", "∀", "∃", "=", "≠", "(", ")", "x", "y", "z", "u", "v", "w"};
    private Set<Button> buttons = new HashSet<>();

    public InputPanel(){
        setLayout(new GridLayout(4,6));
        for(String i: inputs){
            Button button = new Button();
            button.setLabel(i);
            button.setSize(buttonSize_x,buttonSize_y);
            this.add(button);
            buttons.add(button);
            button.addActionListener(this);
        }
        setSize(6*buttonSize_x,4*buttonSize_y);
        this.setMaximumSize(new Dimension(6*buttonSize_x,4*buttonSize_y));
        this.setMinimumSize(new Dimension(6*buttonSize_x,4*buttonSize_y));
        this.setPreferredSize(new Dimension(6*buttonSize_x,4*buttonSize_y));


        setVisible(true);

    }

    public static InputPanel getInstance(){
        if(inputPanel == null) inputPanel = new InputPanel();
        return inputPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source instanceof Button && buttons.contains(source))
            MainPanel.getInstance().addString(((Button) source).getLabel());
    }
}
