package model;

import java.time.LocalDate;

public abstract class User implements Comparable<User> {

    private String nickname;
    private String id;
    private LocalDate bondingDate;
    private int amountReproduction;


   
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
        amountReproduction = 0;
    }
        
    

    
         /* (non-Javadoc)
         * @see java.lang.Comparable#compareTo(java.lang.Object)
         */
        @Override
    public int compareTo(User otherUser) {
        if (this.amountReproduction < otherUser.amountReproduction) {
            return 1;
        } else if (this.amountReproduction > otherUser.amountReproduction) {
            return -1;
        } else {
            return 0;
        }

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

}
