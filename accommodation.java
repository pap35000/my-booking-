import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;
import java.util.*;

public class accommodation  implements Serializable {
    /**
     * @param name the name of the facility(hotel,airbnb or anything else)
     * @param price the price of each night
     * @param characteristics the characteristics of the resort(they are stored in a hash set</string>)
     * @param SquareMetre the size of the facility
     * @param capacity the number of people that can host
     * @param location the location of the facility
     * @param cal an object cal that show the availability of the facility
     */

    private String name;
    private int price;
    HashSet <String> characteristics;
    private double SquareMetres;
    private int capacity;
    private String location;
    public Calendar cal ;
    JFrame AccommodationFrame;
    private JTextField WriteName;
    protected JPanel accommodationPanel;
    private JLabel FillName;
    private JTextField WriteCapacity;
    private JLabel FillCapacity;
    private JTextField WritePrice;
    private JTextField WriteSquareMetres;
    private JLabel FillPrice;
    private JLabel FillSquareMetres;
    private JLabel FillLocation;
    private JTextField WriteLocation;
    private JButton SumbitButton;
    private JTextField WriteCharacteristics;
    private JLabel FillCharct;
    //HashSet <Image> img;
    /*
    JFrame frame = new JFrame();
  ImageIcon icon = new ImageIcon("androidBook.jpg");
  JLabel label = new JLabel(icon);
  frame.add(label);
  frame.setDefaultCloseOperation                                HOW TO SHOW AN IMAGE IN JAVA
         (JFrame.EXIT_ON_CLOSE);
  frame.pack();
  frame.setVisible(true);

     */

    /**
     * default constructor
     */
    public accommodation(){
        characteristics=new HashSet<String>();
        CreateFrame();
        SumbitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                    try {
                        if(WriteName.getText().length()==0 || WriteName.getText()==null || WriteLocation.getText().length()==0 || WriteLocation.getText()==null ||  WriteCharacteristics.getText().length()==0 ||  WriteCharacteristics.getText()==null ){
                            JOptionPane.showMessageDialog(null,"Please enter valid information.Thanks.");
                            JOptionPane.getRootFrame().dispose();
                        }
                        else {
                            setName(WriteName.getText());
                            setLocation(WriteLocation.getText());
                            setPrice(Integer.parseInt(WritePrice.getText()));
                            setSquareMetres(Integer.parseInt(WriteSquareMetres.getText()));
                            setCapacity(Integer.parseInt(WriteCapacity.getText()));
                            String tmp = WriteCharacteristics.getText();
                            String[] tmp1 = tmp.split(",");
                            for (String i : tmp1) {
                                addCharacteristics(i);
                            }
                            JOptionPane.showMessageDialog(null, "Your sumbision is successfull!");
                            JOptionPane.getRootFrame().dispose();
                            AccommodationFrame.dispose();
                        }
                    }
                    catch (NumberFormatException | NullPointerException r){
                        JOptionPane.showMessageDialog(null,"Please enter valid information.Thanks.");
                        JOptionPane.getRootFrame().dispose();
                    }





            }});



/*
        SumbitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                setName(WriteName.getText());
                setLocation(WriteLocation.getText());
                setPrice(Integer.parseInt(WritePrice.getText()));
                setSquareMetres(Integer.parseInt(WriteSquareMetres.getText()));
                setCapacity(Integer.parseInt(WriteCapacity.getText()));
                String tmp=WriteCharacteristics.getText();
                String [] tmp1=tmp.split(",");
                for (String i:tmp1){
                    addCharacteristics(i);
                }
                JOptionPane.showMessageDialog(null,"Your sumbision is successfull!");
                JOptionPane.getRootFrame().dispose();
                AccommodationFrame.dispose();
                AddExtraFacility c=new AddExtraFacility();
            }
        });
        */

    }




    /**
     * constructor that initializes the variables
     */
    public accommodation(String name,int price, double squareMetres, int capacity, String location,HashSet<String> characteristics) {

        this.name=name;
        this.price = price;
        this.characteristics=characteristics;
        SquareMetres = squareMetres;
        this.capacity = capacity;
        this.location = location;
        //cal=new Calendar();
        //img=new HashSet<Image>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public HashSet<String> getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(HashSet<String> characteristics) {
        this.characteristics = characteristics;
    }

    public double getSquareMetres() {
        return SquareMetres;
    }

    public void setSquareMetres(double squareMetres) {
        SquareMetres = squareMetres;
    }


    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        location=location.toLowerCase();
        this.location = location;
    }




    /**
     * converts all the letters of the word to lowercase and then adds them to the HashSet characteristic
     * @param s the characteristic that will be added
     */
    public void addCharacteristics(String s){
        s=s.toLowerCase();
        characteristics.add(s);
    }
    private void CreateFrame(){
        AccommodationFrame=new JFrame("Enter facility,");
        AccommodationFrame.add(accommodationPanel);
        AccommodationFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        AccommodationFrame.setBounds(700,250,100000,1000);
//        AccommodationFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        AccommodationFrame.pack();
        AccommodationFrame.setVisible(true);
    }
    /**
     * creates an accommodation object @duplicate
     * then start to read with the usage of @tmp1 ,@tmp2,@tmp3 the information about the resort and stores them with the usage of setter
     * @return
     */


    /**
     * prints all the information of each facility
     */
    public void printInformation(){
        System.out.println("The name of the facility is "+getName()+"!");
        System.out.println("The location is "+getLocation()+"!");
        System.out.println("The price of the night  is "+getPrice()+"!");
        System.out.println("The square metres are "+getSquareMetres()+"!");
        System.out.println("The capacity is "+getCapacity()+"!");
        System.out.println("The special characteristics of the resort are:");
        for(String i:characteristics){
            System.out.print(i+" ");

        }
        System.out.print("!");
        System.out.println();




    }


    public static void main(String[] args){
        accommodation a=new accommodation();
    }







}
