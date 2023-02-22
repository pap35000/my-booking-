import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;


public class user implements Serializable{


    private int type, age,id; /* type: 1 for providers, 2 for customers, 3 for admins*/
    private String name, surname, username, password, gender;
    private transient JTextField nameField;
    private transient JTextField ageField;
    private transient JTextField usernameField;
    private transient JTextField surnameField;
    private transient JComboBox comboBox1;
    private transient JComboBox comboBox2;
    private transient JPasswordField passwordField1;
    private transient JPasswordField passwordConfirmField2;
    private transient JButton singupButton;
    private transient JPanel userPanel;
    JFrame userFrame;
    provider c;
    customer d;
    ArrayList<user> login;


    public user (int id,AccommodationManagement acc){
        this.id=id;
        user u=this;
        singupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    if(Arrays.equals(passwordField1.getPassword(),passwordConfirmField2.getPassword()) && passwordConfirmField2.getPassword().length!=0 && passwordField1.getPassword().length!=0){
                        name=nameField.getText();
                        surname=surnameField.getText();
                        age=Integer.parseInt(ageField.getText());
                        String tmp=(String) comboBox2.getSelectedItem();
                        if(tmp.equals("Provider")){
                            type=1;
                        }
                        else if(tmp.equals("Customer")){
                            type=2;
                        }
                        else {
                            type=3;
                        }
                        gender=(String)  comboBox1.getSelectedItem();
                        surname=surnameField.getText();
                        username=usernameField.getText();
                        password=String.valueOf(passwordField1.getPassword());
                        JOptionPane.showMessageDialog(null,"Successful registration!!!");
                        JOptionPane.getRootFrame().dispose();
                        userFrame.dispose();


                        if(getType()==1){
                            c= new provider(getUsername(),id);
                            JOptionPane.showMessageDialog(null,"You are now logged in as a provider.Press okay to continue.");
                            JOptionPane.getRootFrame().dispose();
                            c.CreateFrame();
                        }
                        else  if(getType()==2){
                            d=new customer(acc.getProviders(),id);
                            JOptionPane.showMessageDialog(null,"You are now logged in as a customer.Press okay to continue.");
                            JOptionPane.getRootFrame().dispose();
                            d.CreateFrame();
                        }

                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Please insert valid data.Try again.");
                        JOptionPane.getRootFrame().dispose();
                    }
                }
                catch (NumberFormatException r){
                    JOptionPane.showMessageDialog(null,"Enter valid information.Try again.");
                    JOptionPane.getRootFrame().dispose();
                }
/*
                login.add(u);
                for (user user : login) {
                    System.out.println(user.getUsername() + " = " + user.getPassword());
                }
                System.out.println("-----------------------------------------");
                SaveUsers(login,"users_info.bin");

 */
            }

        });
        CreateFrameUser();

    }
/*
    public void SaveUsers(ArrayList<user> us, String filename){

        try (ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream(filename))){
            oos.writeObject(us);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

 */

    public void setLogin(ArrayList<user> login){
        login = new ArrayList<>();
        this.login=login;
    }
    public ArrayList<user> getLogin(){
        return login;
    }

    /**
     *
     * a constructor that initializes the characteristics of a user
     * @param age age of the user
     * @param type type of the user (admin, provider, customer)
     * @param gender gender of the user
     * @param name name of the user
     * @param surname surname of the user
     * @param username username of the user
     * @param password password of the user
     *
     */

    public user(String name,String surname,String username,String password,String gender,int type,int age,int id){
        this.id=id;
        this.age = age;
        this.type = type;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.username = username;
        this.password = password;

    }

    public provider getProv(){
        return  c;
    }
    public customer getCustomer(){
        return d;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getGender() {
        return gender;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * a function that shows the characteristics of a specific user
     */

    /*
    public void showUser(){
        System.out.println("Name: "+name);
        System.out.println("Surname: "+surname);
        System.out.println("Username: "+username);
        System.out.println("Password: "+password);
        System.out.println("Age: "+age);
        System.out.println("Gender: "+gender);
        if (type==1)
            System.out.println("Type: Provider");
        else if(type==2)
            System.out.println("Type: Customer");
        else
            System.out.println("Type: Admin");
        System.out.println("\n");
    }

     */
    public void CreateFrameUser(){
        userFrame=new JFrame("Create a new user.");
        userFrame.add(userPanel);
        userFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        userFrame.setBounds(700,250,100000,1000);
//        AccommodationFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        userFrame.pack();
        userFrame.setVisible(true);
    }

}