import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class showInformation extends customer {
    private JButton closeButton;
    private JLabel monArrLabel;
    private JLabel dateDLabel;
    private JPanel showPanel;
    JFrame showFrame;

    public showInformation() {
        super();
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showFrame.dispose();
            }
        });
        CreateFrame();
        monArrLabel.setText("You arrive at "+getDateAr()+ " of "+getMonAr()+"!!");
        dateDLabel.setText("Your stay at our amenities ends at "+getDateD()+" of "+getMonD()+"!!We will be happy to hostel you again!");
    }
    public void CreateFrame(){
         showFrame=new JFrame("Your days of relaxation are:");
        showFrame.add(showPanel);
        showFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        showFrame.setBounds(700,250,100000,1000);
//        AccommodationFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        showFrame.pack();
        showFrame.setVisible(true);
    }
}
