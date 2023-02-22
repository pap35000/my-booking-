import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class searchByType extends customer{
    JFrame searchFrame;
    private JComboBox comboBox1;
    private JTextField searchTextField;
    private JButton searchButton;
    private JLabel foundLabel;
    private JPanel searchPanel;
    private JLabel typeLabel;
    ArrayList<String> name1;



    public searchByType(ArrayList<provider> original) {
        super(original,3);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String typeSearch=(String)comboBox1.getSelectedItem();
                typeSearch=typeSearch.toLowerCase();
                String search=searchTextField.getText();
                search=search.toLowerCase();
                accommodation found;

                if(typeSearch.equals("name")){
                     found=searchAccommodationByName(search);
                     if(found==null){
                         foundLabel.setText("There is no facility with the specific name.Search again.");
                     }
                     else{
                         JOptionPane.showMessageDialog(null,"The "+found.getName()+" resort is under our services.You can now make a reservation.");
                         JOptionPane.getRootFrame().dispose();
                         searchFrame.setVisible(false);
                     }
                }
                else if(typeSearch.equals("location")){
                    name1=searchAccommodationLocation(search);
                    if(name1==null){
                        typeLabel.setText("There is no facility in this location.Try again.");
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"The "+name1+" resorts has the desirable location.You can now make a reservation.");
                        JOptionPane.getRootFrame().dispose();
                        searchFrame.setVisible(false);
                    }
                }
                else if(typeSearch.equals("square metres")){
                    try{
                        name1=searchAccommodationSquareMetres(Integer.parseInt(search));
                    }
                    catch (NullPointerException | NumberFormatException r){
                        JOptionPane.showMessageDialog(null,"Enter valid search type.");
                        JOptionPane.getRootFrame().dispose();
                    }
                    if(name1==null){
                        typeLabel.setText("There is no facility with the desirable square metres.Try again.");
                    }
                    else{

                        JOptionPane.showMessageDialog(null,"The "+name1+" resort has the desirable square metres.You can now make a reservation.");
                        JOptionPane.getRootFrame().dispose();
                        searchFrame.setVisible(false);
                        //custFrame.setVisible(true);
                    }
                }
                else if(typeSearch.equals("price")){
                    try{
                         name1=searchAccommodationByPriceRange(Integer.parseInt(search));
                    }
                    catch (NullPointerException | NumberFormatException r){
                        JOptionPane.showMessageDialog(null,"Enter valid search type.");
                        JOptionPane.getRootFrame().dispose();
                    }
                    if(name1==null){
                        typeLabel.setPreferredSize(new Dimension(40,40));
                        typeLabel.setText("There is no facility with the price range you ask for .Try again.");
                    }
                    else{

                        JOptionPane.showMessageDialog(null,"The "+name1+" resorts have the desirable price range.You can now make a reservation.");
                        JOptionPane.getRootFrame().dispose();
                        searchFrame.setVisible(false);
                        //custFrame.setVisible(true);
                    }
                }
                else if(typeSearch.equals("capacity")){
                    System.out.println(searchAccommodationByPriceRange(Integer.parseInt(search)));
                    try{
                        name1=searchAccommodationByCapacity(Integer.parseInt(search));
                    }
                    catch (NullPointerException | NumberFormatException r){
                        JOptionPane.showMessageDialog(null,"Enter valid search type.");
                        JOptionPane.getRootFrame().dispose();
                    }
                    if(name1==null){
                        typeLabel.setText("There is no facility with the capacity you ask for .Try again.");
                    }
                    else{

                        JOptionPane.showMessageDialog(null,"The "+name1+" resorts have the desirable capacity.You can now make a reservation.");
                        JOptionPane.getRootFrame().dispose();
                        searchFrame.setVisible(false);
                        //custFrame.setVisible(true);
                    }
                }
            }

        });
        CreateSearch();
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String type=(String) comboBox1.getSelectedItem();
                typeLabel.setVisible(true);
                typeLabel.setText("Now search accommodation by "+type+"!");
            }
        });
    }
    private void CreateSearch(){
        typeLabel.setText("Now search accommodation by name!");
        searchFrame=new JFrame("Search facilities.");
        searchFrame.add(searchPanel);
        searchFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        searchFrame.setBounds(700,250,10000000,10000000);
        searchFrame.setPreferredSize(new Dimension(800,300));
        //searchFrame.setSize(1000,1000);
//        AccommodationFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        searchFrame.pack();
        searchFrame.setVisible(true);
    }
}
