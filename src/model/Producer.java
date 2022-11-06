package model;

import java.time.LocalTime;

public abstract class Producer extends User {

    private String name;
    private String urlImage;
    private int amountReproduction;
    private LocalTime totalReproductionTime;

    /**
     * 
     * Constructor of the class
     * 
     * @param nickname
     * @param id
     * @param name
     * @param urlImage
     */
    public Producer(String nickname, String id, String name, String urlImage) {
        super(nickname, id);
        this.name = name;
        this.urlImage = urlImage;

    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return String return the urlImage
     */
    public String getUrlImage() {
        return urlImage;
    }

    /**
     * @param urlImage the urlImage to set
     */
    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    /**
     * @return int return the amountReproduction
     */
    public int getAmountReproduction() {
        return amountReproduction;
    }

    /**
     * @param amountReproduction the amountReproduction to set
     */
    public void setAmountReproduction(int amountReproduction) {
        this.amountReproduction = amountReproduction;
    }

    /**
     * @return LocalTime return the totalReproductionTime
     */
    public LocalTime getTotalReproductionTime() {
        return totalReproductionTime;
    }

    /**
     * @param totalReproductionTime the totalReproductionTime to set
     */
    public void setTotalReproductionTime(LocalTime totalReproductionTime) {
        this.totalReproductionTime = totalReproductionTime;
    }

}