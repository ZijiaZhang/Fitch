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

    public MainPanel(){
        super("  ");
        m = this;
        setSize(width,height);
        setTitle("Main Menu");
        setLayout(new BoxLayout(getContentPane(),BoxLayout.PAGE_AXIS));
        this.add(InputPanel.getInstance());

        addStep.setLabel("Add Step");
        addStep.setPreferredSize(new Dimension(200,100));
        addStep.setVisible(true);
        addStep.addActionListener(this);
        this.add(addStep);

        addSubproof.setLabel("Add SubProof");
        addSubproof.setPreferredSize(new Dimension(200,100));
        addSubproof.setVisible(true);
        addSubproof.addActionListener(this);
        this.add(addSubproof);

        this.add(ProofPanel.getInstance());

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
    }
}
