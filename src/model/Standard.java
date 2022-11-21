package model;

public class Standard extends Consumer {

    private int amountReproductionsSongs;

    /**
     * Constructor of the class
     * 
     * @param nickname
     * @param id
     */
    public Standard(String nickname, String id) {
        super(nickname, id);
        amountReproductionsSongs = 0;
    }


   


    /**
     * @return int return the amountReproductionsSongs
     */
    public int getAmountReproductionsSongs() {
        return amountReproductionsSongs;
    }

    /**
     * @param amountReproductionsSongs the amountReproductionsSongs to set
     */
    public void setAmountReproductionsSongs(int amountReproductionsSongs) {
        this.amountReproductionsSongs = amountReproductionsSongs;
    }

}