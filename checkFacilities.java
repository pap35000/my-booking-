import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;

public class checkFacilities implements Serializable {
    JFrame checkFrame;
    private JPanel checkPanel;
    private JButton nextButton;
    private JButton closeButton;
    private JLabel printInf;
    private int count;

    public checkFacilities(ArrayList <accommodation> acc) {
        count=1;
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(count<acc.size()){
                    printInf.setText("<html>name:"+ acc.get(count).getName()+"<br/>"+" location:"+acc.get(count).getLocation()+"<br/>"+" price:"+acc.get(count).getPrice()+"<br/>"+" square metres:"+acc.get(count).getSquareMetres()+"<br/>"+" capacity:"+acc.get(count).getCapacity()+"<html>");
                    count++;
                }
                else{
                    JOptionPane.showMessageDialog(null,"There are no more facilities to see.");
                    JOptionPane.getRootFrame().dispose();
                    checkFrame.dispose();
                }

            }
        });
        CreateFrame(acc);
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkFrame.dispose();
            }
        });
    }

    private void CreateFrame(ArrayList <accommodation> acc){
        checkFrame=new JFrame("See your facilities.");
        printInf.setText("<html>name:"+ acc.get(0).getName()+"<br/>"+" location:"+acc.get(0).getLocation()+"<br/>"+" price:"+acc.get(0).getPrice()+"<br/>"+" square metres:"+acc.get(0).getSquareMetres()+"<br/>"+" capacity:"+acc.get(0).getCapacity()+"<html>");
        checkFrame.add(checkPanel);
        checkFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        checkFrame.setPreferredSize(new Dimension(200,100));
        checkFrame.setBounds(700,250,300,200);

        checkFrame.setVisible(true);
    }
}
