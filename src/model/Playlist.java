package model;

import java.util.ArrayList;

public class Playlist {

    private String name;
    private String autoId;
    private ArrayList<Audio> audios;

    /**
     * Constructor of the class
     * 
     * @param name
     */
    public Playlist(String name) {
        this.name = name;
        this.autoId = "";
        this.audios = new ArrayList<Audio>();
    }

    /**
     * addAudioPlaylist: What this method does is add a audio to the Playlist
     * 
     * @param newAudioPlaylist Audio - The audio to add to the playlist
     * @return audios.add(newAudioPlaylist) - A boolean that show if the audio
     *         could be added
     */
    public boolean addAudioPlaylist(Audio newAudioPlaylist) {
        return audios.add(newAudioPlaylist);
    }

    /**
     * searchAudioByNameAndIdCreatorPlaylist: This method search a audio on the
     * playlist
     * 
     * @param name      String - Represents the name of the Audio to search
     * @param idCreator String - Represents the id of the creator of the Audio to
     *                  search
     * @return int: pos - The position of the Audio in the ArrayList
     */
    public int searchAudioByNameAndIdCreatorPlaylist(String name, String idCreator) {
        int pos = -1;
        boolean isFound = false;
        for (int i = 0; i < audios.size() && !isFound; i++) {
            if (audios.get(i) != null) {
                if (audios.get(i).getName().equalsIgnoreCase(name)
                        && audios.get(i).getIdCreator().equalsIgnoreCase(idCreator)) {
                    pos = i;
                    isFound = true;
                }
            }
        }

        return pos;
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
     * @return String return the autoId
     */
    public String getAutoId() {
        return autoId;
    }

    /**
     * @param autoId the autoId to set
     */
    public void setAutoId(String autoId) {
        this.autoId = autoId;
    }

    /**
     * @return ArrayList<Audio> return the audios
     */
    public ArrayList<Audio> getAudios() {
        return audios;
    }

    /**
     * @param audios the audios to set
     */
    public void setAudios(ArrayList<Audio> audios) {
        this.audios = audios;
    }

    /**
     * hasSong: Search if the playlist have a song
     * 
     * @return hasSong: boolean - A boolean variable that show if the playlist have
     *         a song
     */
    public boolean hasSong() {
        boolean hasSong = false;
        for (int i = 0; i < audios.size() && !hasSong; i++) {

            if (audios.get(i) != null) {
                if (audios.get(i) instanceof Song) {
                    hasSong = true;

                }
            }

        }

        return hasSong;
    }

    /**
     * hasPodcast: Search if the playlist have a podcast
     * 
     * @return hasSong: boolean - A boolean variable that show if the playlist have
     *         a podcast
     */
    public boolean hasPodcast() {
        boolean hasPodcast = false;
        for (int i = 0; i < audios.size() && !hasPodcast; i++) {

            if (audios.get(i) != null) {
                if (audios.get(i) instanceof Podcast) {
                    hasPodcast = true;

                }
            }

        }

        return hasPodcast;
    }


    /**
     * listAudiosPlaylist: List the audios of a playlist
     * 
     * @return msj - String: The list of the audios
     */
    public String listAudiosPlaylist(){
        String msj = "";
        for (int i = 0; i < audios.size(); i++) {
            if(audios.get(i) != null){
                if(audios.get(i) instanceof Podcast){
                    msj += "-PLAYLIST- PODCAST #" + (i+1) + "\n" + "Nombre del podcast: " + audios.get(i).getName() + "\n" + "Id del creador: " + audios.get(i).getIdCreator() + "\n";
                }else{
                    msj += "-PLAYLIST- CANCION #" + (i + 1) + "\n" + "Nombre de la cancion: " + audios.get(i).getName()
                            + "\n" + "Id del creador: " + audios.get(i).getIdCreator() + "\n";
                }
            }
            
        }

        if (msj == ""){
            msj = "La playlist no tiene audios";
        }
        
        return msj;

    }

}