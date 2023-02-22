import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.io.Serializable;



public class Interface implements Serializable {
    AccommodationManagement a;
    ArrayList<user> users ;
    public HashMap<String,String> login_info = new HashMap<>();
    ArrayList <customer> customers ;
    ArrayList <admin> admins;
    int id=0;



    private JButton logInButtton;
    private JTextField usernanameField;
    private JPasswordField passwordField1;
    private JButton createAccButton;
    private JLabel welcomeLabel;
    private JLabel fillLabel;
    private JLabel newcomerLabel;
    private JPanel interfacePanel;
    private JComboBox comboBox1;
    JFrame interfaceFrame;

    public static List<?> convertObjectToList(Object obj) {
        List<?> list = new ArrayList<>();
        if (obj.getClass().isArray()) {
            list = Arrays.asList((Object[])obj);
        } else if (obj instanceof Collection) {
            list = new ArrayList<>((Collection<?>)obj);
        }
        return list;
    }

    public  ArrayList<user> LoadUsers(String filename) {
        ArrayList<user> us = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream (new FileInputStream(filename))){
            us = (ArrayList<user>)convertObjectToList( ois.readObject());

        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

        return us;
    }

    public void SaveUsers(ArrayList<user> us, String filename){

        try (ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream(filename))){
            oos.writeObject(us);
        } catch (IOException e){
            e.printStackTrace();
        }
    }


    /**
     *This function takes all the characteristics of a provider and his hotel/airbnb and creates him.
     * @return the new provider
     */
    public provider createProvider(String name,int price,int squareMetres,int capacity,String location,HashSet<String> characteristics,String type,String username){
        ArrayList<accommodation> resorts=new ArrayList<>();
        hotel hotel;
        airbnb airbnb;
       // hotel f=new hotel();
        accommodation d=new accommodation(name,price,squareMetres,capacity,location,characteristics);
        if(type.equals("hotel")){
           hotel=new hotel (50,d);
           resorts.add(hotel);
        }
        else if(type.equals("airbnb")){
            airbnb=new airbnb(d);
            resorts.add(airbnb);
        }
        provider prov=new provider(username,type,resorts,id);
        id++;
        return prov;
    }

    /**
     * This is a constructor of the class {@link Interface} in which we initialize 3 providers with 1 hotel/airbnb each, 1 customer and 1 admin.
     *<p>
     * - Name: "nikos", Surname: "pappas", Username: "nikpap", Password:"pap1992", Type: provider, Gender: male, Age: 29<p>
     * - Name: "sakis", Surname: "tanimanidis", Username: "saktan", Password:"sakis111", Type: provider, Gender: male, Age: 43<p>
     * - Name: "eleanna", Surname: "kontou", Username: "helen", Password:"elekont", Type: provider, Gender: female, Age: 35<p>
     * - Name: "john", Surname: "karas", Username: "johnk", Password:"john123", Type: customer, Gender: male, Age: 45<p>
     * - Name: "maria", Surname: "theodorou", Username: "mtheo", Password:"123maria", Type: admin, Gender: female, Age: 37
     *
     */
    public Interface(){

        a=new AccommodationManagement();
        users=new ArrayList<>();
        customers = new ArrayList<>();

        for (int i=0; i<a.getProviders().size(); i++){
            System.out.println(a.getProviders().get(i).getUsername()+" = "+a.getProviders().get(i).getId());
        }

        admins =new ArrayList<>();
        addUser(29,1,"male","nikos","pappas","nikpap","pap1992",id);
        HashSet<String> characteristics=new HashSet<>();
        characteristics.add("pool");
        characteristics.add("parking");
        characteristics.add("wifi");
        a.addProvider(createProvider("palace",30,600,1000,"saint louis",characteristics,"hotel","nikpap"));
        addUser(43,1,"male","sakis","tanimanidis","saktan","sakis111",id);
       // characteristics.removeAll(characteristics);
        characteristics.add("wifi");
        characteristics.add("massage");
        characteristics.add("private chef");
        a.addProvider(createProvider("sun",70,1500,400,"bali",characteristics,"hotel","saktan"));
        addUser(35,1,"female","eleanna","kontou","helen","elekont",id);

        //characteristics.removeAll(characteristics);
       // characteristics.add("big rooms");
        //characteristics.add("central heat");
        //characteristics.add("quiet");
        a.addProvider(createProvider("wooden house",20,63,2,"kastoria",characteristics,"airbnb","elekont"));
        addUser(45,2,"male","john","karas","johnk","john123",id);
        customer cust=new customer(a.getProviders(),3,id);
        customers.add(cust);
        id++;
        addUser(37,3,"female","maria","theodorou","mtheo","123maria",id);
        admin adm=new admin(id,users );
        admins.add(adm);
        id++;
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// files


        SaveUsers(users, "users_info.bin");
        users=LoadUsers("users_info.bin");

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



        CreateFrame();
        logInButtton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String username=usernanameField.getText();
                String pass=String.valueOf(passwordField1.getPassword());
                String type=(String)comboBox1.getSelectedItem();
                int typeOfUser;
                if(type.equals("admin")){
                    typeOfUser=3;
                }
                else if(type.equals("provider")){
                    typeOfUser=1;
                }
                else{
                    typeOfUser=2;
                }
                boolean found=false;

                for(user i:users){
                    if (username==null || pass==null || username.length()==0 || pass.length()==0){
                        JOptionPane.showMessageDialog(null,"Enter valid input.Try again.");
                        JOptionPane.getRootFrame().dispose();
                        break;
                    }
                    else if (i.getUsername().contains(username) && i.getPassword().contains(pass) && i.getType()==typeOfUser){
                        found=true;
                        JOptionPane.showMessageDialog(null,"Successful log in !!");
                        JOptionPane.getRootFrame().dispose();
                        if(typeOfUser==1){
                            for(provider k:a.getProviders()){
                                if(i.getId()==k.getId()){
                                    k.CreateFrame();
                                    interfaceFrame.dispose();
                                }
                            }
                        }
                        else if(typeOfUser==2){
                            for(customer k:customers){
                                if(i.getId()==k.getId()){
                                    k.CreateFrame();
                                    interfaceFrame.dispose();

                                }
                            }

                        }
                        else {
                            for(admin k:admins){if(i.getId()==k.getId()){
                                k.CreateFrame();
                                interfaceFrame.dispose();
                            }

                            }
                        }
                    }



                }
                if(!found && pass!=null && username!=null && pass.length()!=0 && username.length()!=0){
                    JOptionPane.showMessageDialog(null,"Enter valid input.Try again.");
                    JOptionPane.getRootFrame().dispose();
                }
            }
        });


        createAccButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                interfaceFrame.dispose();
                user tmp=new user(id,a);
                if(tmp.getType()==1){
                    a.addProvider(tmp.getProv());
                }
                else if(tmp.getType()==2){
                    customers.add(tmp.getCustomer());
                }
                users.add(tmp);
                id++;
                tmp.setLogin(users);


            }
        });


    }





    /**
     *This function adds a new user at the array list of users, using the setters of the class {@link user}.
     * It also stores the new user's username and password in the hash map used for the login.
     *
     * @param age age of the user
     * @param type type of the user (admin, provider, customer)
     * @param gender gender of the user
     * @param name name of the user
     * @param surname surname of the user
     * @param username username of the user
     * @param password password of the user
     */

    public void addUser(int age, int type, String gender, String name, String surname, String username, String password,int id){

        user newUser = new user(name, surname, username, password, gender, type, age,id);
        users.add(newUser);
        login_info.put(newUser.getUsername(), newUser.getPassword());
    }

    /**
     * This function is about the login menu. We ask the user if he/she wants to log in or register and then we ask for the further information we need
     */


   public void CreateFrame(){
        interfaceFrame=new JFrame("Enter to our world!");
        interfaceFrame.add(interfacePanel);
        interfaceFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        interfaceFrame.setBounds(700,250,100000,1000);
//        AccommodationFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        interfaceFrame.pack();
        interfaceFrame.setVisible(true);
    }
    public static void main(String[] args){
         //Interface a=new Interface();

    }



}
