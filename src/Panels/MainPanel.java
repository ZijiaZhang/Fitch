package Panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JFrame implements ActionListener {
    private static MainPanel m;
    private final int width = 450;
    private final int height = 600;
    private Button addStep = new Button();
    private Button addSubproof = new Button();
    private Button deleteStep = new Button();

    public MainPanel(){
        super("  ");
        m = this;
        setSize(width,height);
        setTitle("Main Menu");
        setLayout(new BoxLayout(getContentPane(),BoxLayout.PAGE_AXIS));
        this.add(InputPanel.getInstance());

        addStep.setLabel("Add Step");
        //addStep.setPreferredSize(new Dimension(200,100));
        addStep.setMaximumSize(new Dimension(Integer.MAX_VALUE,100));
        addStep.setVisible(true);
        addStep.addActionListener(this);
        this.add(addStep);

        addSubproof.setLabel("Add SubProof");
        //addSubproof.setPreferredSize(new Dimension(200,100));
        addSubproof.setMaximumSize(new Dimension(Integer.MAX_VALUE,100));
        addSubproof.setVisible(true);
        addSubproof.addActionListener(this);
        this.add(addSubproof);

        deleteStep.setLabel("Delete Step");
        //deleteStep.setPreferredSize(new Dimension(200,100));
        deleteStep.setMaximumSize(new Dimension(Integer.MAX_VALUE,100));
        deleteStep.setVisible(true);
        deleteStep.addActionListener(this);
        this.add(deleteStep);
        this.add(ProofPanel.getInstance());

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.revalidate();
        setVisible(true);
    }

    public static MainPanel getInstance(){
        if(m==null) m = new MainPanel();
        return m;
    }

    public void addString(String str){
        if(ProofPanel.activeTestField !=null)
            ProofPanel.activeTestField.setText(ProofPanel.activeTestField.getText() + str);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(addStep))
            ProofPanel.getInstance().addStep();
        else if(source.equals(addSubproof))
            ProofPanel.getInstance().addSubProof();
        else if(source.equals(deleteStep))
            ProofPanel.getInstance().deleteStep();
    }
}
