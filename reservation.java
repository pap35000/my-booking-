import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class reservation extends customer{
    JFrame reservFrame;
    private JTextField textField1;
    private JButton reserveButton;
    private JPanel reservationPanel;

    public reservation(ArrayList<provider> original){
        super (original,1);
        CreateReservation();
        reserveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name1= textField1.getText();
                if(searchAccommodationByName(name1)==null){
                    JOptionPane.showMessageDialog(null,"The name of the facility does not exist.Try again.");
                    JOptionPane.getRootFrame().dispose();
                }
                else {
                    reservation(name1);
                    reservFrame.dispose();

                }
            }
        });
    }


    private void CreateReservation(){
        reservFrame=new JFrame("Enter name.");
        reservFrame.add(reservationPanel);
        reservFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        reservFrame.setBounds(700,250,100000,1000);
//        AccommodationFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        reservFrame.pack();
        reservFrame.setVisible(true);
    }
}
