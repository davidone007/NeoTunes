package ui;

import java.util.Scanner;
import model.NeoTunesController;

public class Main {

    private Scanner reader;
    private NeoTunesController controller;

    /**
     * Main: constructor of Main class
     */
    public Main() {
        reader = new Scanner(System.in);
        controller = new NeoTunesController();

    }

    /**
     * @return NeoTunesController return the controller
     */
    public NeoTunesController getController() {
        return controller;
    }

    /**
     * @param controller the controller to set
     */
    public void setController(NeoTunesController controller) {
        this.controller = controller;
    }

    /**
     * @param reader the reader to set
     */
    public void setReader(Scanner reader) {
        this.reader = reader;
    }

    /**
     * @return Scanner return the reader
     */
    public Scanner getReader() {
        return reader;
    }

    public static void main(String[] args) {
        Main main = new Main();
        int option = 0;

        do {

            option = main.getOptionShowMenu();
            main.executeOption(option);

        } while (option != 0);

        main.getReader().close();
    }

    /**
     * getOptionShowMenu: Show the menu and get the option
     * 
     * @return option - int: The option chosen by the user
     */
    public int getOptionShowMenu() {
        int option = 0;
        System.out.println("<<<<< Bienvenido a NEOTUNES >>>>>");
        System.out.println(
                "1. Registrar productor\n" +
                        "2. Registrar consumidor\n" +
                        "3. Registrar canciones y podcast (Audios)\n" +
                        "4. Crear una lista de reproduccion\n" +
                        "5. Editar lista de reproduccion\n" +
                        "6. Compartir lista de reproduccion\n" +
                        "7. Reproducir cancion o podcast\n" +
                        "8. Comprar cancion\n" +
                        "9. Generar reporte con los datos registrados\n" +
                        "0. Salir de NeoTunes\n");

        option = validateIntegerOption();

        return option;
    }

    /**
     * validateIntegerOption: This method checks if a number is an integer
     * 
     * @return option - int: Returns the entered number if it is an integer or
     *         returns -1 if it is not an integer
     */
    public int validateIntegerOption() {
        int option = 0;

        if (reader.hasNextInt()) {
            option = reader.nextInt();
        } else {
            reader.nextLine();
            option = -1;
        }

        return option;
    }

    /**
     * validateDoubleOption: This method checks if a number is an double
     * 
     * @return option - int: Returns the entered number if it is an double or
     *         returns -1 if it is not an double
     */
    public double validateDoubleOption() {
        double option = 0;

        if (reader.hasNextDouble()) {
            option = reader.nextDouble();
        } else {
            reader.nextLine();
            option = -1;
        }

        return option;
    }

    /**
     * chooseOptionUser: This method print two option to choose and get the option
     * 
     * @param condition0False String - The false condition
     * @param condition1True  String - The true condition
     * @return Boleean - If option == 1 return true else return false
     */
    public boolean chooseOptionUser(String condition0False, String condition1True) {

        int option = 0;
        System.out.println("0." + condition0False + "\n" + "1." + condition1True);
        option = validateIntegerOption();
        while (option > 1 || option < 0 || option == -1) {
            System.out.println("Este apartado no acepta letras, ni numeros decimales. Escriba un dato valido");
            System.out.println("Recuerde que las opciones son 0 y 1");
            option = validateIntegerOption();

        }

        if (option == 0) {
            return false;
        } else {
            return true;
        }

    }

    /**
     * UI METHOD
     * Request the information and regist a producer
     */
    public void uiRegistProducer() {

        System.out.println("Escriba el nickname del usuario productor");
        String nickname = reader.next();
        System.out.println("Escriba el id");
        String id = reader.next();
        System.out.println("Escriba el nombre");
        String name = reader.next();
        System.out.println("Escriba la url de la foto o imagen distintiva");
        String urlImage = reader.next();
        System.out.println("Seleccione el tipo de usuario productor:" + "\n");
        boolean option = chooseOptionUser("Creador de contenido", "Artista");
        String msj = controller.createProducer(nickname, id, name, urlImage, option);
        System.out.println(msj);

    }

    /**
     * UI METHOD
     * Request the information and regist a consumer
     */
    public void uiRegistConsumer() {

        System.out.println("Escriba el nickname del usuario consumidor");
        String nickname = reader.next();
        System.out.println("Escriba el id");
        String id = reader.next();
        System.out.println("Seleccione el tipo de usuario consumidor:" + "\n");
        boolean option = chooseOptionUser("Premium", "Estandar");
        String msj = controller.createConsumer(nickname, id, option);
        System.out.println(msj);

    }

    /**
     * UI METHOD
     * Request the information and regist a audio
     */
    public void uiRegistAudio() {
        String name = "";
        String url = "";
        int duration = 0;
        String idCreator = "";
        String description = "";
        int optionCategory = 0;
        String album = "";
        double saleValue = 0;
        int optionGenre = 0;
        String msj = "";

        System.out.println("Seleccione el tipo de audio que desea crear: " + "\n");
        boolean option = chooseOptionUser("Podcast", "Cancion");
        if (option == false) {
            System.out.println("Escriba el nombre del podcast");
            name = reader.next();
            System.out.println("Escriba la URL de la imagen");
            url = reader.next();
            System.out.println("Escriba la duracion en segundos del podcast");
            duration = validateIntegerOption();
            while (duration == -1) {
                reader.next();
                System.out.println("Este apartado no acepta letras ni decimales. Escriba un dato valido");
                duration = validateIntegerOption();
            }
            System.out.println("Escriba el id del usuario CREADOR del podcast");
            idCreator = reader.next();
            System.out.println("Escriba la descripcion del podcast");
            description = reader.next();
            System.out.println("Seleccione una categoria del podcast: ");
            System.out.println(controller.listCategories());

            optionCategory = validateIntegerOption();
            while (optionCategory > 3 || optionCategory < 0 || optionCategory == -1) {
                System.out.println("Este apartado no acepta letras, ni numeros decimales. Escriba un dato valido");
                System.out.println("Recuerde elegir una opcion valida");
                optionCategory = validateIntegerOption();
            }

            msj = controller.createAudio(name, url, duration, idCreator, description, optionCategory, album, saleValue,
                    optionGenre, option);

            System.out.println(msj);

        } else {

            System.out.println("Escriba el nombre de la cancion");
            name = reader.next();
            System.out.println("Escriba la URL de la imagen");
            url = reader.next();
            System.out.println("Escriba la duracion en segundos de la cancion");
            duration = validateIntegerOption();
            while (duration == -1) {
                reader.next();
                System.out.println("Este apartado no acepta letras ni decimales. Escriba un dato valido");
                duration = validateIntegerOption();
            }
            System.out.println("Escriba el id del usuario CREADOR de la cancion");
            idCreator = reader.next();
            System.out.println("Escriba el album de la cancion");
            album = reader.next();
            System.out.println("Escriba el valor de venta de la cancion en dolares");
            saleValue = validateDoubleOption();
            while (saleValue == -1) {
                reader.next();
                System.out.println("Este apartado no acepta letras. Escriba un dato valido");
                saleValue = validateDoubleOption();
            }

            System.out.println("Seleccione el genero de la cancion: ");
            System.out.println(controller.listGenres());

            optionGenre = validateIntegerOption();
            while (optionGenre > 3 || optionGenre < 0 || optionGenre == -1) {
                System.out.println("Este apartado no acepta letras, ni numeros decimales. Escriba un dato valido");
                System.out.println("Recuerde elegir una opcion valida");
                optionGenre = validateIntegerOption();
            }

            msj = controller.createAudio(name, url, duration, idCreator, description, optionCategory, album, saleValue,
                    optionGenre, option);

            System.out.println(msj);

        }

    }

    /**
     * UI METHOD
     * Request the information and add a playlist to a consumer
     */
    public void uiAddPlaylist() {
        System.out.println("Escriba el nombre de la playlist");
        String name = reader.next();
        System.out.println("Escriba el id del usuario consumidor que va añadir la playlist");
        String consumerId = reader.next();
        String msj = controller.addPlaylistController(consumerId, name);
        System.out.println(msj);

    }

    /**
     * UI METHOD
     * Request the information and edit a playlist
     */
    public void uiEditPlaylist() {
        String playlistId = "";
        String newNamePlaylist = "";
        String audioName = "";
        String idCreator = "";
        String msj = "";

        System.out.println("Escriba el id del usuario que posee la playlist");
        System.out.println("\n");
        String consumerId = reader.next();

        int posConsumer = controller.searchConsumerById(consumerId);

        if (posConsumer == -1) {
            System.out.println("El usuario buscado no existe en el sistema \n");
        } else {

            System.out.println(controller.listPlaylistConsumer(consumerId));

            System.out.println("Escoja una opcion" + "\n" +
                    "0. Anadir audio a la playlist" + "\n" +
                    "1. Editar nombre de la playlist" + "\n" +
                    "2. borrar audio de la playlist" + "\n");

            int option = validateIntegerOption();

            switch (option) {
                case 0:
                    System.out.println("Audios de NeoTunes \n");
                    System.out.println(controller.listAudiosController());
                    System.out.println("Escriba el id del creador del audio");
                    idCreator = reader.next();
                    System.out.println("Escriba el nombre del audio que desea añadir (cancion/podcast)");
                    audioName = reader.next();
                    System.out.println("Escriba el id de la playlist que desea editar");
                    playlistId = reader.next();
                    msj = controller.editPlaylist(playlistId, consumerId, option, newNamePlaylist, audioName,
                            idCreator);
                    System.out.println(msj);

                    break;

                case 1:
                    System.out.println("Escriba el id de la playlist que desea editar");
                    playlistId = reader.next();
                    System.out.println("Escriba el nombre que desea ponerle");
                    newNamePlaylist = reader.next();

                    msj = controller.editPlaylist(playlistId, consumerId, option, newNamePlaylist, audioName,
                            idCreator);
                    System.out.println(msj);

                    break;

                case 2:
                    System.out.println("Escriba el id de la playlist que desea editar");
                    playlistId = reader.next();
                    System.out.println("\n");
                    int posPlaylist = controller.searchPlaylistById(consumerId, playlistId);

                    if (posPlaylist != -1) {

                        System.out.println(controller.listAudioPlaylistConsumer(consumerId, playlistId));
                        System.out.println("Escriba el nombre del audio que desea borrar (cancion/podcast)");
                        audioName = reader.next();
                        System.out.println("Escriba el id del creador del audio");
                        idCreator = reader.next();
                        msj = controller.editPlaylist(playlistId, consumerId, option, newNamePlaylist, audioName,
                                idCreator);
                        System.out.println(msj);
                    } else {
                        System.out.println("La playlist no fue encontrada");
                    }

                    break;

                default:
                    System.out.println("Escoja una opcion valida");

                    break;
            }

        }

    }

    /**
     * UI METHOD
     * Request the information and share a playlist
     */
    public void uiSharePlaylist() {
        System.out.println("Escriba el id del consumidor que posee la playlist");
        String idConsumer = reader.next();
        int posConsumer = controller.searchConsumerById(idConsumer);
        if (posConsumer != -1) {
            System.out.println("\n");
            System.out.println(controller.listPlaylistToShareConsumer(idConsumer));
            System.out.println("Escriba el # de la playlist que desea compartir");
            int posPlaylist = validateIntegerOption() - 1;
            while (posPlaylist == -1) {
                reader.next();
                System.out.println("Este apartado no acepta letras ni decimales. Escriba un dato valido");
                posPlaylist = validateIntegerOption() - 1;
            }
            String msj = controller.sharePlaylist(posPlaylist, idConsumer);
            System.out.println(msj);

        } else {
            System.out.println("El usuario no ha sido encontrado");
        }

    }

    /**
     * UI METHOD
     * Request the information and add a song to a consumer
     */
    public void uiBuySong() {
        System.out.println("Escriba el id del consumidor");
        String idConsumer = reader.next();
        int posConsumer = controller.searchConsumerById(idConsumer);
        if (posConsumer != -1) {
            System.out.println("Audios de NEOTUNES");
            System.out.println(controller.listAudiosController());
            System.out.println("\n" + "Canciones del usuario: ");
            System.out.println(controller.listSongsConsumer(idConsumer) + "\n");
            System.out.println("Escriba el nombre de la cancion");
            String audioName = reader.next();
            System.out.println("Escriba el id del creador de la cancion");
            String idCreator = reader.next();
            int posAudio = controller.searchSongConsumer(idConsumer, audioName, idCreator);
            if (posAudio == -1) {
                String msj = controller.buySongConsumer(audioName, idCreator, idConsumer);
                System.out.println(msj);
            } else {
                System.out.println("La cancion buscada ya la has comprado ¿NOS QUIERES REGALAR DINERO?");
            }

        } else {
            System.out.println("El usuario no ha sido encontrado");
        }

    }

    /**
     * UI METHOD
     * Request the information and reproduce a song by the user
     */
    public void uiReproduceAudio() {

        System.out.println("Escriba el id del consumidor");
        String idConsumer = reader.next();
        int posConsumer = controller.searchConsumerById(idConsumer);
        if (posConsumer != -1) {
            System.out.println("PLAYLIST DEL USUARIO");
            System.out.println(controller.listPlaylistConsumer(idConsumer));
            System.out.println("Escriba el # de la playlist que desea reproducir");
            int posPlaylist = validateIntegerOption() - 1;
            while (posPlaylist == -1) {
                reader.next();
                System.out.println("Este apartado no acepta letras ni decimales. Escriba un dato valido");
                posPlaylist = validateIntegerOption() - 1;
            }
            System.out.println("Escriba el id de la playlist");
            String playlistId = reader.next();
            int posPlaylistList = controller.searchPlaylistById(idConsumer, playlistId);
            if (posPlaylistList != -1) {
                System.out.println("AUDIOS DE LA PLAYLIST");
                System.out.println(controller.listAudioPlaylistConsumer(idConsumer, playlistId));
                System.out.println("Escriba el # del audio que desea reproducir");
                int posAudio = validateIntegerOption() - 1;
                while (posAudio == -1) {
                    reader.next();
                    System.out.println("Este apartado no acepta letras ni decimales. Escriba un dato valido");
                    posAudio = validateIntegerOption() - 1;
                }

                String msj = controller.playAudio(posPlaylist, posAudio, idConsumer);
                System.out.println(msj);
            } else {
                System.out.println("No se encontro la playlist verifique los datoss");
            }

        } else {
            System.out.println("El usuario no ha sido encontrado");
        }
    }

    /**
     * UI METHOD
     * Show the choosen report
     */
    public void uiGenerateReport() {

        System.out.println(
                "Elija una opcion:\n" +
                        "1. Acumulado total de reproducciones\n" +
                        "2. Genero de cancion mas escuchado\n" +
                        "3. Categoria de podcast mas escuchada\n" +
                        "4. Informar top 5 artistas y top 5 creadores (Si no hay usuarios suficientes para el top 5 se pondran los que haya)\n"
                        +
                        "5. Informar top 10 canciones y top 10 podcast (Si no hay audios suficientes para el top 10 se pondran los que haya)\n"
                        +
                        "6. Informar numero de ventas y el valor por genero\n" +
                        "7. Informar sobre la cancion mas vendida de la plataforma\n");

        int option = validateIntegerOption();

        String idConsumer = "";
        boolean individualOption = false;

        switch (option) {
            // Total reproductions
            case 1:

                System.out.println(controller.generateReport(option, individualOption, idConsumer));

                break;

            // Genre most listened
            case 2:

                individualOption = chooseOptionUser("Reporte general", "Reporte a un usuario especifico");
                if (individualOption == false) {
                    System.out.println(controller.generateReport(option, individualOption, idConsumer));
                } else {
                    System.out.println("Escriba el id del usuario consumidor para generar el reporte: ");
                    idConsumer = reader.next();
                    System.out.println(controller.generateReport(option, individualOption, idConsumer));
                }

                break;

            // Category most listened
            case 3:

                individualOption = chooseOptionUser("Reporte general", "Reporte a un usuario especifico");
                if (individualOption == false) {
                    System.out.println(controller.generateReport(option, individualOption, idConsumer));
                } else {
                    System.out.println("Escriba el id del usuario consumidor para generar el reporte: ");
                    idConsumer = reader.next();
                    System.out.println(controller.generateReport(option, individualOption, idConsumer));

                }

                break;

            // Top 5 users
            case 4:

                System.out.println(controller.generateReport(option, individualOption, idConsumer));
                break;

            // Top 10 audios
            case 5:

                System.out.println(controller.generateReport(option, individualOption, idConsumer));

                break;

            // Report by gender
            case 6:
                System.out.println(controller.generateReport(option, individualOption, idConsumer));

                break;

            // Best selling song
            case 7:
                System.out.println(controller.generateReport(option, individualOption, idConsumer));
                break;

            default:
                System.out.println("Elija una opcion valida");
                break;
        }

    }

    /**
     * executeOption: Execute the option
     * 
     * @param option int - The choosen option
     */
    public void executeOption(int option) {

        switch (option) {
            case 1:
                uiRegistProducer();

                break;

            case 2:
                uiRegistConsumer();

                break;

            case 3:
                uiRegistAudio();

                break;

            case 4:
                uiAddPlaylist();

                break;

            case 5:
                uiEditPlaylist();

                break;

            case 6:
                uiSharePlaylist();

                break;

            case 7:
                uiReproduceAudio();

                break;

            case 8:
                uiBuySong();

                break;

            case 9:
                uiGenerateReport();

                break;

            case 10:

                break;

            case 11:

                break;

            case 12:

                break;

            case 0:
                System.out.println("Gracias por usar NeoTunes");
                break;

            default:
                System.out.println("Opcion invalida");
                break;
        }
    }

}