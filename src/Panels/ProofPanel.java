package Panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ProofPanel extends JPanel implements ActionListener {
    private final int Height = 1000;
    private final int Width =800;
    private static ProofPanel proofPanel;
    private int curDepth = 0;
    private int cury = 0;
    public static ProofSentences activeTestField = null;
    private ArrayList<ProofSentences> steps = new ArrayList<>();
    public ProofPanel(){
        setSize(800,1000);
        //setPreferredSize(new Dimension(Width,Height));
        this.setMaximumSize(new Dimension(Integer.MAX_VALUE,Height));
        this.setMinimumSize(new Dimension(0,Height));
        //this.setPreferredSize(new Dimension(Width,Height));
        setBackground(Color.WHITE);
        setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
        revalidate();
    }

    public static ProofPanel getInstance() {
        if(proofPanel==null) proofPanel = new ProofPanel();
        return proofPanel;
    }

    public void addStep(){
        ProofSentences proofSentences = new ProofSentences(curDepth*20);
        //proofSentences.setMaximumSize(new Dimension(Width- curDepth*20,50));
        //proofSentences.setMinimumSize(new Dimension(Width- curDepth*20,50));
        //proofSentences.setPreferredSize(new Dimension(Width - curDepth*20,50));
        add(proofSentences);
        proofSentences.addActionListener(this);
       //proofSentences.setBounds(curDepth*20, cury,Width- curDepth*20,50);
        proofSentences.setVisible(true);
        cury +=50;
        activeTestField = proofSentences;
        steps.add(proofSentences);
        this.revalidate();
        //MainPanel.getInstance().pack();
    }



    public void addSubProof(){
        curDepth++;
        addStep();
    }

    public void deleteStep(){
        if(activeTestField!=null && steps.contains(activeTestField)){
            int i = steps.indexOf(activeTestField);
            for(;i<steps.size();i++){
                ProofSentences t = steps.get(i);
                t.setBounds(t.getBounds().x,t.getBounds().y-20,t.getBounds().width,t.getBounds().height);
            }

            i = steps.indexOf(activeTestField);
            steps.remove(activeTestField);
            this.remove(activeTestField);
            if(i!=0)
            activeTestField = steps.get(i-1);
            else
                activeTestField = null;
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source instanceof TextField && steps.contains((ProofSentences) source)){
            activeTestField = (ProofSentences) source;
        }
    }
}
