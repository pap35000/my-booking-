public class airbnb extends accommodation {
    public airbnb(){

    }
    public airbnb(accommodation a){
        super(a.getName(),a.getPrice(),a.getSquareMetres(),a.getCapacity(),a.getLocation(),a.getCharacteristics());
    }

}
