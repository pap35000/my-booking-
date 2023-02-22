import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.*;
public class provider implements Serializable {
    /**
     * @typeOfRental long or sort term rent
     * @typeOfAccommodation hotel,airbnb or anything else
     * @builings an array list that contains all the building of each provider
     */
    AddExtraFacility extra;
    private String typeOfAccommodation;
    private String username;
    public  ArrayList <accommodation> buildings;
    private JTextField textField1;
    private JLabel selectOption;
    private JButton addFac;
    private JButton checkFac;
    private JPanel providerPanel;
    private JComboBox comboBox1;
    private JButton logOutButton;
    JFrame frameProv;
    private int id;

    /**
     * default consructor
     * read the information about the facility that the provider wants to provide to our site
     *inserts everything in the array list buildings
     * the possible objects are hotel,airbnb or accommodation(hotel and airbnb inherit for accommodation
     */
    public provider(String username,int id){
        this.id=id;
        addFac.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(buildings==null){
                    buildings=new ArrayList<>();
                }
                accommodation a=new accommodation();
                buildings.add(a);

            }
        });
        //CreateFrame();
        checkFac.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(buildings==null){
                    JOptionPane.showMessageDialog(null,"There is no facility yet.Please enter a facility first.");
                }
                else {
                    checkFacilities a = new checkFacilities(buildings);
                }
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameProv.dispose();
                Interface a=new Interface();
            }
        });
    }
    public provider(){

    }

    /**
     * a constructor that initializes the parameters
     */

    public provider(String username,String typeOfAccommodation,ArrayList<accommodation> accommodations,int id) {
        this.typeOfAccommodation = typeOfAccommodation;
        this.username=username;
        buildings=accommodations;
        this.id=id;


        addFac.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(buildings==null){
                    buildings=new ArrayList<>();
                }
                accommodation a=new accommodation();
                buildings.add(a);

            }
        });

        checkFac.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkFacilities a=new checkFacilities(buildings);

            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameProv.dispose();
                Interface b=new Interface();


            }

        });
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ArrayList<accommodation> getBuildings() {
        return buildings;
    }

    public void setBuildings(ArrayList<accommodation> buildings) {
        this.buildings = buildings;
    }

    public String getTypeOfAccommodation() {
        return typeOfAccommodation;
    }

    public void setTypeOfAccommodation(String typeOfAccommodation) {
        this.typeOfAccommodation = typeOfAccommodation;
    }

    /**
     * reading the type of accommodation from the user
     * @return the type of the accommodation
     */


    public void CreateFrame(){
       frameProv=new JFrame("Choose your actions!");
       frameProv.add(providerPanel);
       frameProv.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       frameProv.setBounds(700,250,100000,1000);
//        AccommodationFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       frameProv.pack();
       frameProv.setVisible(true);
    }

    /**
     * reading the type of rental from the user
     * @return the type of rental
     */

    /*
    public String readTypeOfRental(){
        Scanner read=new Scanner(System.in);
        //System.out.println("Decide if your facilites will be rented for sort or long time(type sort or long)");
        String type=read.nextLine();
        this.typeOfRental=type;
        return type;
    }
    */

    /**
     * prints the information of the building of each provider
     */
    public void showBuildings(){
        for(accommodation i:buildings){
            i.printInformation();
        }
    }

}
