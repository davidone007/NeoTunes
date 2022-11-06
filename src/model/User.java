package model;

import java.time.LocalDate;

public abstract class User {

    private String nickname;
    private String id;
    private LocalDate bondingDate;

    /**
     * Constructor of the class
     * 
     * @param nickname
     * @param id
     */
    public User(String nickname, String id) {
        this.nickname = nickname;
        this.id = id;
        bondingDate = LocalDate.now();
    }

    /**
     * @return String return the nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname the nickname to set
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * @return String return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return LocalDate return the bondingDate
     */
    public LocalDate getBondingDate() {
        return bondingDate;
    }

    /**
     * @param bondingDate the bondingDate to set
     */
    public void setBondingDate(LocalDate bondingDate) {
        this.bondingDate = bondingDate;
    }

}
