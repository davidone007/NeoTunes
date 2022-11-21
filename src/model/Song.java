package model;

import java.time.LocalDate;

public class Song extends Audio implements IPlay {

    private String album;
    private double saleValue;
    private int amountSale;
    private LocalDate buyDate;
    private TypeGenre genre;

    /**
     * Constructor of the class
     * 
     * @param name
     * @param url
     * @param duration
     * @param idCreator
     * @param album
     * @param saleValue
     * @param optionGenre
     */
    public Song(String name, String url, int duration, String idCreator, String album, double saleValue,
            int optionGenre) {
        super(name, url, duration, idCreator);
        this.album = album;
        this.saleValue = saleValue;
        genre = TypeGenre.values()[optionGenre];
        amountSale = 0;

    }

    
    public String play() {
        return "Reproduciendo la cancion: " +getName();
    }
    

    /**
     * @return the album
     */
    public String getAlbum() {
        return album;
    }

    /**
     * @param album the album to set
     */
    public void setAlbum(String album) {
        this.album = album;
    }

    /**
     * @return the saleValue
     */
    public double getSaleValue() {
        return saleValue;
    }

    /**
     * @param saleValue the saleValue to set
     */
    public void setSaleValue(double saleValue) {
        this.saleValue = saleValue;
    }

    /**
     * @return the amountSale
     */
    public int getAmountSale() {
        return amountSale;
    }

    /**
     * @param amountSale the amountSale to set
     */
    public void setAmountSale(int amountSale) {
        this.amountSale = amountSale;
    }

    /**
     * @return the buyDate
     */
    public LocalDate getBuyDate() {
        return buyDate;
    }

    /**
     * @param buyDate the buyDate to set
     */
    public void setBuyDate(LocalDate buyDate) {
        this.buyDate = buyDate;
    }

    /**
     * @return TypeGenre return the genre
     */
    public TypeGenre getGenre() {
        return genre;
    }

    /**
     * @param genre the genre to set
     */
    public void setGenre(TypeGenre genre) {
        this.genre = genre;
    }




    
    




    

}
