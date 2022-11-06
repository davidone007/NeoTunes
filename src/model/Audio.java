package model;

public abstract class Audio {

    private String name;
    private String url;
    private int duration;
    private int numberReproductions;
    private String idCreator;


    
    /**
     * @param name
     * @param url
     * @param duration
     * @param idCreator
     */
    public Audio(String name, String url, int duration, String idCreator) {
        this.name = name;
        this.url = url;
        this.duration = duration;
        this.idCreator = idCreator;
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
     * @return String return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return double return the duration
     */
    public int getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * @return int return the numberReproductions
     */
    public int getNumberReproductions() {
        return numberReproductions;
    }

    /**
     * @param numberReproductions the numberReproductions to set
     */
    public void setNumberReproductions(int numberReproductions) {
        this.numberReproductions = numberReproductions;
    }


    /**
     * @return String return the idCreator
     */
    public String getIdCreator() {
        return idCreator;
    }

    /**
     * @param idCreator the idCreator to set
     */
    public void setIdCreator(String idCreator) {
        this.idCreator = idCreator;
    }

}