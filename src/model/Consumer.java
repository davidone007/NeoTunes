package model;

import java.util.ArrayList;



public abstract class Consumer extends User {

   private String mostListenedGenre;
   private String mostListenedArtist;
   private String mostListenedCreator;
   private ArrayList<Playlist> playlists;
   private int reproductionTime;
   
    /**
     * Constructor of the class
     * @param nickname
     * @param id
     */
    public Consumer(String nickname, String id) {
        super(nickname, id);
        this.playlists = new ArrayList<Playlist>();
        
    }



    /**
     * @param newPlaylist
     * @return
     */
    public boolean addPlaylist(Playlist newPlaylist){
        return playlists.add(newPlaylist);
    }

    /**
     * searchEnemyByNameLevel: This method search a enemy from the enemy array of
     * the level
     * 
     * @param nameE String - Represents the name of the enemy to search
     * @return int: pos - The position of the enemy in the array of enemy of
     *         the level
     */
    public int searchPlaylistById(String id) {
        int pos = -1;
        boolean isFound = false;
        for (int i = 0; i < playlists.size() && !isFound; i++) {
            if (playlists.get(i) != null) {
                if (playlists.get(i).getAutoId().equalsIgnoreCase(id)) {
                    pos = i;
                    isFound = true;
                }
            }
        }

        return pos;
    }



    /**
     * @return int return the reproductionTime
     */
    public int getReproductionTime() {
        return reproductionTime;
    }

    /**
     * @param reproductionTime the reproductionTime to set
     */
    public void setReproductionTime(int reproductionTime) {
        this.reproductionTime = reproductionTime;
    }


    /**
     * @return String return the mostListenedGenre
     */
    public String getMostListenedGenre() {
        return mostListenedGenre;
    }

    /**
     * @param mostListenedGenre the mostListenedGenre to set
     */
    public void setMostListenedGenre(String mostListenedGenre) {
        this.mostListenedGenre = mostListenedGenre;
    }

    /**
     * @return String return the mostListenedArtist
     */
    public String getMostListenedArtist() {
        return mostListenedArtist;
    }

    /**
     * @param mostListenedArtist the mostListenedArtist to set
     */
    public void setMostListenedArtist(String mostListenedArtist) {
        this.mostListenedArtist = mostListenedArtist;
    }

    /**
     * @return String return the mostListenedCreator
     */
    public String getMostListenedCreator() {
        return mostListenedCreator;
    }

    /**
     * @param mostListenedCreator the mostListenedCreator to set
     */
    public void setMostListenedCreator(String mostListenedCreator) {
        this.mostListenedCreator = mostListenedCreator;
    }

    /**
     * @return ArrayList<Playlist> return the playlists
     */
    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    /**
     * @param playlists the playlists to set
     */
    public void setPlaylists(ArrayList<Playlist> playlists) {
        this.playlists = playlists;
    }

}

