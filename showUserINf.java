import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class showUserINf {
    private ArrayList <user> users;
    private int count;
    private JPanel infPanel;
    private JButton next;
    private JLabel showLabel;
    JFrame infFrame;

    public showUserINf(ArrayList<user> a){
        count=1;
        this.users=a;
        CreateFrame();


        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(count<users.size()){
                    showLabel.setText("<html>name:"+users.get( count).getName()+"<br/>"+"surname:"+users.get( count).getSurname()+"<br/>"+"age:"+users.get( count).getAge()+"<br/>"+"gender:"+users.get( count).getGender()+"<br/>"+"password:"+users.get( count).getPassword()+"<br/>"+"id:"+users.get( count).getId()+"<br/>"+"type:"+convertType(users.get( count).getType()));
                    count++;

                }
                else{
                    JOptionPane.showMessageDialog(null,"There are no more users to see.");
                    JOptionPane.getRootFrame().dispose();
                    infFrame.dispose();
                }
            }
        });
    }

    public void CreateFrame(){
        infFrame=new JFrame("Users:");
        showLabel.setText("<html>name:"+users.get(0).getName()+"<br/>"+"surname:"+users.get(0).getSurname()+"<br/>"+"age:"+users.get(0).getAge()+"<br/>"+"gender:"+users.get(0).getGender()+"<br/>"+"password:"+users.get(0).getPassword()+"<br/>"+"id:"+users.get(0).getId()+"<br/>"+"type:"+convertType(users.get(0).getType()));
        infFrame.add(infPanel);
        infFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        infFrame.setBounds(700,250,100000,1000);
        infFrame.setPreferredSize(new Dimension(300,250));

//        AccommodationFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        infFrame.pack();
        infFrame.setVisible(true);
    }
    private  String convertType(int a){
        if(a==1){
            return "provider";

        }
        else if(a==2){
            return "customer";
        }
        else{
            return "admin";
        }
    }
}
