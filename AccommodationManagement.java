import java.io.*;
import java.util.ArrayList;

public class AccommodationManagement implements Serializable {
    // an array list that contains all the providers and each provider has it own accommodation
    public static ArrayList<provider> providers;


    /**
     * default constructor
     */
    public AccommodationManagement(){
        providers=new ArrayList<>();

    }


    public  ArrayList<provider> getProviders() {
        return providers;
    }
/*
    public  void setProviders(ArrayList<provider> providers) {
        AccommodationManagement.providers = providers;
    }

 */

    public void addProvider(provider tmp){
        providers.add(tmp);
        //SaveProviders(providers);
    }

    /**
     * shows the information of each building of each provider
     */
    /*
    public void showBuildingsPerProvider(){
        for(provider i:providers){
            System.out.println("This providers offers:");
            i.showBuildings();
            System.out.println("\n");
        }
     }



    public void showSpecificTypeOfAccommodation(String a){
        for(provider i:providers){
            for(accommodation j: i.buildings){
                if(a.equals("hotel")){
                     if(j instanceof hotel){
                         System.out.println("The "+j.getName()+" is a hotel type of accommodation");
                     }
                }
                else if(a.equals("airbnb")){
                    if(j instanceof airbnb){
                        System.out.println("The "+j.getName()+" is a airbnb type of accommodation");
                    }
                }
            }


        }



    }
    */



}
