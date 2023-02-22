import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class admin {
    private int id;
    ArrayList<user> users;
    private JButton informationButton;
    private JButton Logout;
    private JPanel adminPanel;
    JFrame adminFrame;

    public admin(int id,ArrayList<user> users) {
        this.users=users;
        this.id=id;

        Logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                adminFrame.dispose();
                Interface a=new Interface();
            }
        });
        informationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showUserINf a=new showUserINf(users);
            }
        });
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void CreateFrame(){
        adminFrame=new JFrame("Admins workplace!");
        adminFrame.add(adminPanel);
        adminFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        adminFrame.setBounds(700,250,500,1000);

        adminFrame.setPreferredSize(new Dimension(300,250));
//        AccommodationFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        adminFrame.pack();
        adminFrame.setVisible(true);
    }

}


