import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


public class customer implements Serializable {
    private String monAr,monD;
    private int dateAr,dateD,id;
    public ArrayList<provider> duplicate;
    HashMap<String,Integer> DaysPerMonth;
    JFrame custFrame;
    private transient JButton findButton;
    private transient JLabel searching;
    private transient JButton informationButton;
    private transient JPanel customerPanel;
    private transient JButton reserveButton;
    private transient JButton logOutButton;

    public customer(ArrayList<provider> original,int id){
        DaysPerMonth=new HashMap<>();
        DaysPerMonth.put("january",31);
        DaysPerMonth.put("february",28);
        DaysPerMonth.put("march",31);
        DaysPerMonth.put("april",30);
        DaysPerMonth.put("may",31);
        DaysPerMonth.put("june",30);
        DaysPerMonth.put("july",31);
        DaysPerMonth.put("august",31);
        DaysPerMonth.put("september",30);
        DaysPerMonth.put("october",31);
        DaysPerMonth.put("november",30);
        DaysPerMonth.put("december",31);
        duplicate=original;
        this.id=id;

        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchByType a=new searchByType(duplicate);
            }
        });
        //CreateFrame();
        reserveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reservation a=new reservation(duplicate);
                custFrame.dispose();
            }
        });

        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                custFrame.dispose();
                Interface b=new Interface();

            }
        });
    }

    public customer(ArrayList<provider> original,int a,int id) {
        duplicate = original;
        this.id = id;

        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchByType a = new searchByType(duplicate);
            }
        });

        reserveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reservation a = new reservation(duplicate);

            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                custFrame.dispose();
                Interface b=new Interface();

            }
        });


    }
    public customer(){


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<provider> getDuplicate() {
        return duplicate;
    }

    public String getMonD() {
        return monD;
    }

    public void setMonD(String monD) {
        this.monD = monD;
    }

    public int getDateAr() {
        return dateAr;
    }

    public void setDateAr(int dateAr) {
        this.dateAr = dateAr;
    }

    public int getDateD() {
        return dateD;
    }

    public void setDateD(int dateD) {
        this.dateD = dateD;
    }

    public String getMonAr() {
        return monAr;
    }

    public void setMonAr(String monAr) {
        this.monAr = monAr;
    }
/*
    public void setDuplicate(ArrayList<provider> duplicate) {
        this.duplicate = duplicate;
    }

 */

    /**
     * searching if the name of a specific hotel exist
     * @param name the name of the hote
     * @return true if the name exist,else returns false
     */
    public accommodation searchAccommodationByName(String name){
        for(provider i:duplicate){
            for(accommodation j:i.buildings){
                if(name.equals(j.getName())){
                    return j;
                }
            }
        }
       return null;
    }

    /**
     * searching if there is a hotel between two price ranges

     * @param min the maximum
     * @return true if the range of the price exists,else returns false
     */

    public ArrayList <String>  searchAccommodationSquareMetres(int min){
        ArrayList a=new ArrayList();
        for(provider i:duplicate){
            for(accommodation j:i.buildings){
                if(j.getSquareMetres()>=min && (!a.contains(j.getName()))){
                    a.add(j.getName());
                }
            }
        }
        if(a.isEmpty()){
            return null;
        }
        else{
            return a;
        }
    }

    public ArrayList <String> searchAccommodationByPriceRange(int maximum){
        ArrayList a=new ArrayList();

        for(provider i:duplicate){
            for(accommodation j:i.buildings){
                if( j.getPrice()<=maximum && !a.contains(j.getName())){
                    a.add(j.getName());
                }
            }
        }
        if(a.isEmpty()){
            return null;
        }
        else{
            return a;
        }
    }

    public ArrayList<String> searchAccommodationByCapacity(int min){
        ArrayList a=new ArrayList();

        for(provider i:duplicate){
            for(accommodation j:i.buildings){
                if( j.getCapacity()>=min && !a.contains(j.getName())){
                    a.add(j.getName());
                }
            }
        }
        if(a.isEmpty()){
            return null;
        }
        else{
            return a;
        }

    }
    /**
     *  searching through each building of each provider to see whether the specific characteristics exist
     * @param charact a HashSet that contains all the characteristics that the user needs(could be also 1)
     * @return returns true if ALL the characteristics exist,else returns false
     */
    /*
    public boolean searchAccommodationByCharacteristics(HashSet<String> charact){
        int found;
        boolean returnType=false;
        for(provider i:duplicate){
            for(accommodation j:i.buildings){
                found=0;
                for(String k:charact){
                    //System.out.println(j.characteristics.contains(k));
                    if(j.characteristics.contains(k)){
                        found++;
                        returnType=true;
                    }
                }

                /*for(String k:j.characteristics){
                    for(String l:charact){
                        if(k.equals(l)){
                            found++;
                            break;
                        }
                    }
                }
                //System.out.println(found);
                if(found==charact.size()){
                    System.out.println("The resort '"+j.getName()+"' offers the characteristics you ask for.");
                    returnType=true;
                }
            }
        }
        return returnType;
    }

     */


    /**
     * searching if in the current location there is at least one hotel
     * @param location the desirable location
     * @return returns true if there is at least on hotel exists in that location,else returns false
     */
    public ArrayList<String> searchAccommodationLocation(String location){
        ArrayList a=new ArrayList();

        for(provider i:duplicate){
            for(accommodation j:i.buildings){
                if(j.getLocation().equals(location) && !a.contains(j.getName())){
                    a.add(j.getName());
                }
            }
        }
        if(a.isEmpty()){
            return null;
        }
        else{
            return a;
        }
    }

    /**
     * this method makes a reservation according to the name of the hotel
     * @param name the name of the hotel that the reservation will be done
     */
    public void reservation(String name){
        for(provider i:duplicate){
            for(accommodation j:i.buildings){
                if(name.equals(j.getName())){
                    if(j.cal==null){
                         j.cal=new Calendar();
                    }

                }
            }
        }


    }
    public void CreateFrame(){
        custFrame=new JFrame("Choose your action!");
        custFrame.add(customerPanel);
        custFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        custFrame.setBounds(700,250,100000,1000);
//        AccommodationFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        custFrame.pack();
        custFrame.setVisible(true);
    }

    public static void main(String[] args){
        Interface a=new Interface();
        //customer b=new customer(a.a.getProviders());

    }


}
