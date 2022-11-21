package model;

public class Podcast extends Audio implements IPlay {

    private String description;
    private TypeCategory category;

    /**
     * Constructor of the class
     * 
     * @param name
     * @param url
     * @param duration
     * @param idCreator
     * @param description
     * @param optionCategory
     */
    public Podcast(String name, String url, int duration, String idCreator, String description, int optionCategory) {
        super(name, url, duration, idCreator);
        this.description = description;
        category = TypeCategory.values()[optionCategory];

    }

    public String play() {
        return "Reproduciendo el podcast: " + getName();
    }

    /**
     * @return String return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return TypeCategory return the category
     */
    public TypeCategory getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(TypeCategory category) {
        this.category = category;
    }

}
