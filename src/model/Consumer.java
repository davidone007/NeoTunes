package model;

import java.util.ArrayList;

public abstract class Consumer extends User {

    
    private ArrayList<Playlist> playlists;
    private ArrayList<Song> songsOfTheUser;
    private int amountReproductionGenre[];
   
    

    /**
     * Constructor of the class
     * 
     * @param nickname
     * @param id
     */
    public Consumer(String nickname, String id) {
        super(nickname, id);
        this.playlists = new ArrayList<Playlist>();
        this.songsOfTheUser = new ArrayList<Song>();
        amountReproductionGenre = new int [TypeGenre.values().length];
      

    }

    /**
     * addPlaylist: What this method does is add a playlist to the Consumer
     * 
     * @param newPlaylist Playlist - The playlist to add to the consumer
     * @return playlists.add(newPlaylist) - A boolean that show if the playlist
     *         could be added
     */
    public boolean addPlaylist(Playlist newPlaylist) {
        return playlists.add(newPlaylist);
    }

    /**
     * searchPlaylistById: This method search a playlist of a consumer
     * 
     * @param id String - Represents the id of the playlist to search
     * @return int: pos - The position of the playlist in the ArrayList
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
     * listSongsConsumer: List the songs of a consumer
     * 
     * @return msj - String: The list of the songs
     */
    public String listSongsConsumer() {
        String msj = "";
        for (int i = 0; i < songsOfTheUser.size(); i++) {
            if (songsOfTheUser.get(i) != null) {
                msj += "-CANCION #" + (i + 1) + "\n" + "Nombre de la cancion: " + songsOfTheUser.get(i).getName()
                        + "\n" + "Id del creador: " + songsOfTheUser.get(i).getIdCreator() + "\n"
                        + "Fecha de compra: " + songsOfTheUser.get(i).getBuyDate() + "\n";
            }

        }

        if (msj == "") {
            msj = "El usuario aun no ha comprado canciones";
        }

        return msj;

    }

    /**
     * searchSongByNameAndIdCreator: This method search a song on the
     * ArrayList of the controller
     * 
     * @param name      String - Represents the name of the Audio to search
     * @param idCreator String - Represents the id of the creator of the Audio to
     *                  search
     * @return int: pos - The position of the song in the ArrayList
     */
    public int searchSongByNameAndIdCreator(String name, String idCreator) {
        int pos = -1;
        boolean isFound = false;
        for (int i = 0; i < songsOfTheUser.size() && !isFound; i++) {
            if (songsOfTheUser.get(i) != null) {
                if (songsOfTheUser.get(i).getName().equalsIgnoreCase(name)
                        && songsOfTheUser.get(i).getIdCreator().equalsIgnoreCase(idCreator)) {
                    pos = i;
                    isFound = true;
                }
            }
        }

        return pos;
    }

    /**
     * listPlaylistConsumer: List the playlist of a consumer
     * 
     * @return msj - String: The list of the audios or a validation
     */
    public String listPlaylistConsumer() {
        String msj = "";
        for (int i = 0; i < playlists.size(); i++) {
            if (playlists.get(i) != null) {

                msj += "PLAYLIST #" + (i + 1) + "\n" + "Nombre de la playlist: " + playlists.get(i).getName() + "\n"
                        + "Id autogenerado de la playlist: " + playlists.get(i).getAutoId() + "\n";

            }

        }

        if (msj == "") {
            msj = "El usuario no tiene aun registradas playlists";
        }

        return msj;

    }

    /**
     * listPlaylistToShareConsumer: List the playlist of a consumer
     * 
     * @return msj - String: The list of the audios or a validation
     */
    public String listPlaylistToShareConsumer() {
        String msj = "";
        for (int i = 0; i < playlists.size(); i++) {
            if (playlists.get(i) != null) {

                msj += "PLAYLIST #" + (i + 1) + "\n" + "Nombre de la playlist: " + playlists.get(i).getName() + "\n"
                        + "\n";

            }

        }

        if (msj == "") {
            msj = "El usuario no tiene aun registradas playlists";
        }

        return msj;

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

    /**
     * @return ArrayList<Song> return the songsOfTheUser
     */
    public ArrayList<Song> getSongsOfTheUser() {
        return songsOfTheUser;
    }

    /**
     * @param songsOfTheUser the songsOfTheUser to set
     */
    public void setSongsOfTheUser(ArrayList<Song> songsOfTheUser) {
        this.songsOfTheUser = songsOfTheUser;
    }

    /**
     * @return int return the amountReproductionGenre[]
     */
    public int[] getAmountReproductionGenre() {
        return amountReproductionGenre;
    }

    
    /**
     * @param amountReproductionGenre[] the amountReproductionGenre[] to set
     */
    public void setAmountReproductionGenre(int[] amountReproductionGenre) {
        this.amountReproductionGenre = amountReproductionGenre;
    }

}
