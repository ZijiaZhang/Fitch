package Panels;

import java.awt.*;

public class ProofPanel extends Panel {
    private final int Height = 1000;
    private final int Width =800;
    private static ProofPanel proofPanel;
    private int curDepth = 0;
    private int cury = 0;
    public static TextField activeTestField = null;
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
        textField.setBounds(curDepth*20, cury,Width- curDepth*20,20);
        cury +=20;
        activeTestField = textField;
    }

    public void addSubProof(){
        curDepth++;
        addStep();
    }



}
