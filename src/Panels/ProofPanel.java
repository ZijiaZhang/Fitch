package Panels;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ProofPanel extends Panel implements ActionListener {
    private final int Height = 1000;
    private final int Width =800;
    private static ProofPanel proofPanel;
    private int curDepth = 0;
    private int cury = 0;
    public static TextField activeTestField = null;
    private ArrayList<TextField> steps = new ArrayList<>();
    public ProofPanel(){
        setSize(800,1000);
        setPreferredSize(new Dimension(Width,Height));
        this.setMaximumSize(new Dimension(Width,Height));
        this.setMinimumSize(new Dimension(Width,Height));
        this.setPreferredSize(new Dimension(Width,Height));
        //setBackground(Color.WHITE);
        setLayout(null);
    }

    public static ProofPanel getInstance() {
        if(proofPanel==null) proofPanel = new ProofPanel();
        return proofPanel;
    }

    public void addStep(){
        TextField textField = new  TextField();
        textField.setMaximumSize(new Dimension(Width- curDepth*20,20));
        textField.setMinimumSize(new Dimension(Width- curDepth*20,20));
        textField.setPreferredSize(new Dimension(Width - curDepth*20,20));
        add(textField);
        textField.addActionListener(this);
        textField.setBounds(curDepth*20, cury,Width- curDepth*20,20);
        cury +=20;
        activeTestField = textField;
        steps.add(textField);
    }



    public void addSubProof(){
        curDepth++;
        addStep();
    }

    public void deleteStep(){
        if(activeTestField!=null && steps.contains(activeTestField)){
            int i = steps.indexOf(activeTestField);
            for(;i<steps.size();i++){
                TextField t = steps.get(i);
                t.setBounds(t.getBounds().x,t.getBounds().y-20,t.getBounds().width,t.getBounds().height);
            }

            i = steps.indexOf(activeTestField);
            steps.remove(activeTestField);
            this.remove(activeTestField);
            activeTestField = steps.get(i-1);

        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source instanceof TextField && steps.contains((TextField)source)){
            activeTestField = (TextField)source;
        }
    }
}
