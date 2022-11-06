package model;

import java.util.ArrayList;

public class NeoTunesController {

    private ArrayList<User> users;
    private ArrayList<Audio> audios;

    /**
     * The rows of the matrix for generate the autoId of the playlist
     */
    public static final int ROWS = 6;

    /**
     * The colums of the matrix for generate the autoId of the playlist
     */
    public static final int COLUMNS = 6;

    /**
     * The matrix for generate the autoId of the playlist
     */
    int[][] matrixCode = new int[ROWS][COLUMNS];

    /**
     * The limit of the number of playlist of an standard user
     */
    public static final int PLAYLIST_LIMIT_STANDARD_USER = 20;

    /**
     * The limit of the number of songs to buy of an standard user
     */
    public static final int SONGS_LIMIT_STANDARD_USER = 100;

    /**
     * Constructor of the class
     */
    public NeoTunesController() {
        this.users = new ArrayList<User>();
        this.audios = new ArrayList<Audio>();

    }

    /**
     * addUser: What this method does is add a user to the Consumer
     * 
     * @param newUser User - The User to add to the consumer
     * @return users.add(newUser) - A boolean that show if the user
     *         could be added
     */
    public boolean addUser(User newUser) {
        return users.add(newUser);
    }

    /**
     * createProducer: This method create a producer and add it to the ArrayList
     * 
     * @param nickname: Of the producer
     * @param id:       Of the producer
     * @param name:     Of the producer
     * @param urlImage: Of the producer
     * @param option:   if it is a Artist of an Creator
     * @return msj: String - Represents a confirmation message
     */
    public String createProducer(String nickname, String id, String name, String urlImage, boolean option) {

        User newUser = null;
        String msj = "";
        int posUser = searchUserById(id);

        if (posUser == -1) {

            if (option == true) {
                newUser = new Artist(nickname, id, name, urlImage);
                msj = "Nuevo artista agregado";
            } else {
                newUser = new Creator(nickname, id, name, urlImage);
                msj = "Nuevo creador de contenido agregado";
            }

            addUser(newUser);

        } else {
            msj = "El id del usuario ya existe por favor elija otro";
        }
        return msj;
    }

    /**
     * 
     * createConsumer: This method create a consumer and add it to the ArrayList
     * 
     * @param nickname: Of the consumer
     * @param id:       Of the consumer
     * @param option:   if it is a Standard of a Premium
     * @return msj: String - Represents a confirmation message
     */
    public String createConsumer(String nickname, String id, boolean option) {

        User newConsumer = null;
        String msj = "";
        int posUser = searchUserById(id);

        if (posUser == -1) {

            if (option == true) {
                newConsumer = new Standard(nickname, id);
                msj = "Nuevo consumidor estandar agregado";
            } else {
                newConsumer = new Premium(nickname, id);
                msj = "Nuevo consumidor premium agregado";
            }

            addUser(newConsumer);
        } else {
            msj = "El id del usuario ya existe por favor elija otro";
        }
        return msj;
    }

    /**
     * searchUserById: This method search a user
     * 
     * @param id String - Represents the id of the user to search
     * @return int: pos - The position of the user in the ArrayList
     */
    public int searchUserById(String id) {
        int pos = -1;
        boolean isFound = false;
        for (int i = 0; i < users.size() && !isFound; i++) {
            if (users.get(i) != null) {
                if (users.get(i).getId().equalsIgnoreCase(id)) {
                    pos = i;
                    isFound = true;
                }
            }
        }

        return pos;
    }

    /**
     * addAudio: What this method does is add a audio to the Consumer
     * 
     * @param newAudio Audio - The audio to add to the consumer
     * @return audios.add(newAudio) - A boolean that show if the audio
     *         could be added
     */
    public boolean addAudio(Audio newAudio) {
        return audios.add(newAudio);
    }

    /**
     * createAudio: This method create a audio and add it to the ArrayList
     * 
     * @param name:           Of the audio
     * @param url:            Of the audio
     * @param duration:       Of the audio
     * @param idCreator:      Creator of the audio
     * @param description:    Of the audio
     * @param optionCategory: Category of the audio
     * @param album:          Of the audio
     * @param saleValue:      Of the audio
     * @param optionGenre:    Genre of the audio
     * @param option:         if it is a Song of a Podcast
     * @return msj: String - Represents a confirmation message
     */
    public String createAudio(String name, String url, int duration, String idCreator, String description,
            int optionCategory, String album, double saleValue, int optionGenre, boolean option) {

        Audio newAudio = null;
        String msj = "";
        int posUser = searchUserById(idCreator);

        if (posUser != -1) {

            if (option == true) {
                if (users.get(posUser) instanceof Artist) {
                    newAudio = new Song(name, url, duration, idCreator, album, saleValue, optionGenre);
                    msj = "Nueva cancion agregada";
                } else {
                    msj = "El id existe pero no es de un artista";
                }
            } else {
                if (users.get(posUser) instanceof Creator) {
                    newAudio = new Podcast(name, url, duration, idCreator, description, optionCategory);
                    msj = "Nuevo podcast agregado";
                } else {
                    msj = "El id existe pero no es de un creador de contenido";
                }
            }

            addAudio(newAudio);

        } else {
            msj = "El id del usuario creador no existe";
        }

        return msj;
    }

    /**
     * addPlaylistController: This method add a playlist to a Consumer
     * 
     * @param consumerId: The id of the consumer
     * @param name:       The name of the playlist
     * @return msj: String - Represents a confirmation message
     */
    public String addPlaylistController(String consumerId, String name) {
        String msj = "";
        int posUser = searchUserById(consumerId);

        if (posUser != -1) {
            if (users.get(posUser) instanceof Consumer) {
                if (users.get(posUser) instanceof Standard) {
                    if (((Consumer) users.get(posUser)).getPlaylists().size() <= PLAYLIST_LIMIT_STANDARD_USER) {
                        Playlist newPlaylist = new Playlist(name);
                        String matrix = addRandomNumbersMatrixAndPrint();
                        String autoId = generateDefaultAutoId();
                        newPlaylist.setAutoId(autoId);
                        ((Consumer) users.get(posUser)).addPlaylist(newPlaylist);
                        msj = "Nueva playlist agregada" + "\n" +
                                "La matriz usada para el codigo fue: " + "\n" + matrix + "\n" + "\n" +
                                "El codigo de su playlist es: " + newPlaylist.getAutoId();

                    } else {
                        msj = "El usuario estandar ya ha alcanzado el limite de playlists permitidas";
                    }
                }

                if (users.get(posUser) instanceof Premium) {
                    Playlist newPlaylist = new Playlist(name);
                    String matrix = addRandomNumbersMatrixAndPrint();
                    String autoId = generateDefaultAutoId();
                    newPlaylist.setAutoId(autoId);
                    ((Consumer) users.get(posUser)).addPlaylist(newPlaylist);

                    msj = "Nueva playlist agregada" + "\n" +
                            "La matriz usada para el codigo fue: " + "\n" + matrix + "\n" + "\n" +
                            "El codigo de su playlist es: " + newPlaylist.getAutoId();
                }

            } else {
                msj = "El id del usuario existe, pero no es el de un consumidor";
            }

        } else {
            msj = "El id del usuario no existe";
        }

        return msj;

    }

    /**
     * searchAudioByNameAndIdCreator: This method search a audio on the
     * ArrayList of the controller
     * 
     * @param name      String - Represents the name of the Audio to search
     * @param idCreator String - Represents the id of the creator of the Audio to
     *                  search
     * @return int: pos - The position of the Audio in the ArrayList
     */
    public int searchAudioByNameAndIdCreator(String name, String idCreator) {
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
     * editPlaylist: This method allow to edit a playlist (add, rename, erase)
     * 
     * @param playlistId      String - Of the playlist to edit
     * @param consumerId      String - Of the owner of the playlist
     * @param option          int - The action do to with the playlist (add, rename,
     *                        erase)
     * @param newNamePlaylist String - The new name of the playlist
     * @param audioName       String - The name of the audio to add or erase
     * @param idCreator       String - The id of the creator of the audio to add or
     *                        erase
     * @return msj: String - Represents a confirmation message
     */
    public String editPlaylist(String playlistId, String consumerId, int option, String newNamePlaylist,
            String audioName, String idCreator) {

        String msj = "";
        int posUser = searchUserById(consumerId);
        int posAudio = searchAudioByNameAndIdCreator(audioName, idCreator);

        Audio newAudioPlaylist = null;

        if (posUser != -1) {
            if (users.get(posUser) instanceof Consumer) {

                int posPlaylist = ((Consumer) users.get(posUser)).searchPlaylistById(playlistId);

                if (posPlaylist != -1) {

                    switch (option) {

                        // Add audio
                        case 0:

                            if (posAudio != -1) {

                                newAudioPlaylist = audios.get(posAudio);
                                ((Consumer) users.get(posUser)).getPlaylists().get(posPlaylist)
                                        .addAudioPlaylist(newAudioPlaylist);
                                if (audios.get(posAudio) instanceof Song) {

                                    msj = "Cancion añadida a la playlist" + "\n" +
                                            generateAutoIdPlaylistByConditions(playlistId, consumerId);

                                } else {

                                    msj = "Podcast añadido a la playlist" + "\n" +
                                            generateAutoIdPlaylistByConditions(playlistId, consumerId);

                                }

                            } else {
                                msj = "No se encontro el audio indicado";
                            }

                            break;

                        // Change name
                        case 1:

                            ((Consumer) users.get(posUser)).getPlaylists().get(posPlaylist)
                                    .setName(newNamePlaylist);

                            msj = "El nuevo nombre de la playlist es: "
                                    + ((Consumer) users.get(posUser)).getPlaylists().get(posPlaylist).getName();
                            break;

                        // Remove audio
                        case 2:

                            int posAudioPlaylist = ((Consumer) users.get(posUser)).getPlaylists().get(posPlaylist)
                                    .searchAudioByNameAndIdCreatorPlaylist(audioName, idCreator);

                            if (posAudioPlaylist != -1) {

                                if (audios.get(posAudioPlaylist) instanceof Song) {

                                    ((Consumer) users.get(posUser)).getPlaylists().get(posPlaylist).getAudios()
                                            .remove(posAudioPlaylist);
                                    msj = "Cancion borrada de la playlist" + "\n" +
                                            generateAutoIdPlaylistByConditions(playlistId, consumerId);

                                } else {

                                    ((Consumer) users.get(posUser)).getPlaylists().get(posPlaylist).getAudios()
                                            .remove(posAudioPlaylist);
                                    msj = "Podcast borrado de la playlist" + "\n" +
                                            generateAutoIdPlaylistByConditions(playlistId, consumerId);

                                }

                            } else {
                                msj = "La cancion no fue encontrada en la playlist";
                            }

                        default:
                            msj = "Ingrese una opcion valida";
                            break;
                    }

                } else {

                    msj = "El id de la playlist no existe dentro del usuario";

                }

            } else {
                msj = "El id del usuario existe, pero no es el de un consumidor";
            }

        } else {
            msj = "El id del usuario no existe";
        }

        return msj;

    }

    /**
     * generateDefaultAutoId: This method generate a id for the playlist when it is
     * created
     * 
     * @return autoId: String - the generated id
     */
    public String generateDefaultAutoId() {

        String autoId = "";

        for (int i = ROWS - 1; i >= 0; i--) {
            autoId += matrixCode[i][0];
        }

        for (int i = 1; i < ROWS - 1; i++) {
            for (int j = 1; j < COLUMNS; j++) {
                if (i == j) {
                    autoId += matrixCode[i][j];
                }
            }
        }

        for (int i = ROWS - 1; i >= 0; i--) {
            autoId += matrixCode[i][5];
        }

        return autoId;

    }

    /**
     * generateAutoIdPlaylistByConditions: This method generate and set the autoId
     * of a playlist using the conditions of the autoId
     * 
     * @param playlistId: The id of the playlist
     * @param consumerId: The id of the consumer who have the playlist
     * @return msj: String - This String show the matrix of the autoId an the autoId
     *         of the playlist
     */
    public String generateAutoIdPlaylistByConditions(String playlistId, String consumerId) {

        String autoId = "";
        String msj = "";
        String matrix = addRandomNumbersMatrixAndPrint();
        int posUser = searchUserById(consumerId);
        int posPlaylist = ((Consumer) users.get(posUser)).searchPlaylistById(playlistId);
        boolean hasSong = ((Consumer) users.get(posUser)).getPlaylists().get(posPlaylist).hasSong();
        boolean hasPodcast = ((Consumer) users.get(posUser)).getPlaylists().get(posPlaylist).hasPodcast();

        if (hasSong == true && hasPodcast == false) {

            for (int i = ROWS - 1; i >= 0; i--) {
                autoId += matrixCode[i][0];
            }

            for (int i = 1; i < ROWS - 1; i++) {
                for (int j = 1; j < COLUMNS; j++) {
                    if (i == j) {
                        autoId += matrixCode[i][j];
                    }
                }
            }

            for (int i = ROWS - 1; i >= 0; i--) {
                autoId += matrixCode[i][5];
            }

            ((Consumer) users.get(posUser)).getPlaylists()
                    .get(posPlaylist).setAutoId(autoId);

            msj = "La matriz usada para el codigo fue: " + "\n" + matrix + "\n" + "\n" +
                    "El codigo de su playlist quedo : " + ((Consumer) users.get(posUser)).getPlaylists()
                            .get(posPlaylist).getAutoId();

        }

        if (hasSong == false && hasPodcast == true) {

            for (int i = 0; i < COLUMNS - 4; i++) {
                autoId += matrixCode[0][i];
            }

            for (int i = 0; i < ROWS; i++) {
                for (int j = 1; j < COLUMNS; j++) {
                    if (j == (matrixCode.length / 2) - 1) {
                        autoId += matrixCode[i][j];
                    }

                }
            }

            for (int i = ROWS - 1; i >= 0; i--) {
                for (int j = 1; j < COLUMNS; j++) {
                    if (j == (matrixCode.length / 2)) {
                        autoId += matrixCode[i][j];
                    }

                }
            }

            for (int i = 4; i < COLUMNS; i++) {
                autoId += matrixCode[0][i];
            }

            ((Consumer) users.get(posUser)).getPlaylists()
                    .get(posPlaylist).setAutoId(autoId);

            msj = "La matriz usada para el codigo fue: " + "\n" + matrix + "\n" + "\n" +
                    "El codigo de su playlist quedo : " + ((Consumer) users.get(posUser)).getPlaylists()
                            .get(posPlaylist).getAutoId();

        }

        if (hasSong == true && hasPodcast == true) {

            for (int i = ROWS - 1; i >= 0; i--) {
                for (int j = COLUMNS - 1; j >= 0; j--) {

                    if (i <= 5 && i >= 2) {
                        if (i % 2 != 0 && j % 2 == 0) {
                            autoId += matrixCode[i][j];
                        } else if (i % 2 == 0 && j % 2 != 0) {
                            autoId += matrixCode[i][j];
                        }

                    } else {
                        if (i == 1 && j % 2 == 0 && j != 0) {
                            autoId += matrixCode[i][j];
                        } else if (i == 0 && j % 2 != 0 && j != 1) {
                            autoId += matrixCode[i][j];
                        }
                    }

                }
            }

            ((Consumer) users.get(posUser)).getPlaylists()
                    .get(posPlaylist).setAutoId(autoId);

            msj = "La matriz usada para el codigo fue: " + "\n" + matrix + "\n" + "\n" +
                    "El codigo de su playlist quedo : " + ((Consumer) users.get(posUser)).getPlaylists()
                            .get(posPlaylist).getAutoId();

        }

        if (hasSong == false && hasPodcast == false) {
            autoId = generateDefaultAutoId();
            ((Consumer) users.get(posUser)).getPlaylists().get(posPlaylist).setAutoId(autoId);
            msj = "La matriz usada para el codigo fue: " + "\n" + matrix + "\n" + "\n" +
                    "El codigo de su playlist quedo : " + ((Consumer) users.get(posUser)).getPlaylists()
                            .get(posPlaylist).getAutoId();

        }

        return msj;

    }

    /**
     * addRandomNumbersMatrixAndPrint: This method add random integer numbers of the
     * matrix of the autoId in a range of 0 to 9
     * 
     * @return msj: String - The matrix with random numbers
     */
    public String addRandomNumbersMatrixAndPrint() {
        String msj = "";
        int upperBound = 9;
        int lowerBound = 0;
        int range = (upperBound - lowerBound) + 1;

        for (int i = 0; i < ROWS; i++) {
            msj += "\n";
            for (int j = 0; j < COLUMNS; j++) {
                matrixCode[i][j] = (int) (Math.random() * range) + lowerBound;
                msj += matrixCode[i][j] + " ";
            }
        }
        return msj;

    }

    /**
     * listCategories: List the type of categories
     * 
     * @return msj - String: The types of categories
     */
    public String listCategories() {
        TypeCategory categories[] = TypeCategory.values();
        String msj = "Opciones: ";
        for (int i = 0; i < categories.length; i++) {
            msj += "\n" + (i) + ") " + categories[i];

        }

        return msj;
    }

    /**
     * listGenres: List the type of genres
     * 
     * @return msj - String: The types of genres
     */
    public String listGenres() {
        TypeGenre genre[] = TypeGenre.values();
        String msj = "Opciones: ";
        for (int i = 0; i < genre.length; i++) {
            msj += "\n" + (i) + ") " + genre[i];

        }

        return msj;
    }

    /**
     * @return ArrayList<User> return the users
     */
    public ArrayList<User> getUsers() {
        return users;
    }

    /**
     * @param users the users to set
     */
    public void setUsers(ArrayList<User> users) {
        this.users = users;
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

}
