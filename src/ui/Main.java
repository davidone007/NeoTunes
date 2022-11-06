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
        String consumerId = reader.next();

        System.out.println("Escoja una opcion" + "\n" +
                "0. Anadir audio a la playlist" + "\n" +
                "1. Editar nombre de la playlist" + "\n" +
                "2. borrar audio de la playlist" + "\n");

        int option = validateIntegerOption();

        switch (option) {
            case 0:
                System.out.println("Escriba el id de la playlist que desea editar");
                playlistId = reader.next();
                System.out.println("Escriba el nombre del audio que desea añadir (cancion/podcast)");
                audioName = reader.next();
                System.out.println("Escriba el id del creador del audio");
                idCreator = reader.next();
                msj = controller.editPlaylist(playlistId, consumerId, option, newNamePlaylist, audioName, idCreator);
                System.out.println(msj);

                break;

            case 1:

                System.out.println("Escriba el id de la playlist que desea editar");
                playlistId = reader.next();
                System.out.println("Escriba el nombre que desea ponerle");
                newNamePlaylist = reader.next();

                msj = controller.editPlaylist(playlistId, consumerId, option, newNamePlaylist, audioName, idCreator);
                System.out.println(msj);

                break;

            case 2:

                System.out.println("Escriba el id de la playlist que desea editar");
                playlistId = reader.next();
                System.out.println("Escriba el nombre del audio que desea borrar (cancion/podcast)");
                audioName = reader.next();
                System.out.println("Escriba el id del creador del audio");
                idCreator = reader.next();
                msj = controller.editPlaylist(playlistId, consumerId, option, newNamePlaylist, audioName, idCreator);
                System.out.println(msj);

            default:
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

                break;

            case 7:

                break;

            case 8:

                break;

            case 9:

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