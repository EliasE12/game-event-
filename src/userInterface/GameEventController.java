package userInterface;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import exception.EmptyDataException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import model.GameEvent;
import java.util.ArrayList;

public class GameEventController {

    @FXML private BorderPane bpBanner;
    @FXML private JFXTextArea taJugadores;
    @FXML private BorderPane bpPhoto;
    @FXML private JFXTextField tfNombre;
    @FXML private JFXTextField tfApodo;
    @FXML private JFXTextField tfCategoria;
    @FXML private JFXTextField tfPuntaje;

    private GameEvent gameEvent;

    @FXML
    public void initialize(){

        gameEvent = new GameEvent(new ArrayList<>());


        ImageView banner = new ImageView(new Image("banner.jpg"));
        banner.setFitHeight(bpBanner.getHeight());
        banner.setFitWidth(bpBanner.getWidth());
        bpBanner.setCenter(banner);

        ImageView photo = new ImageView(new Image("photo.png"));
        photo.setFitHeight(170.0);
        photo.setFitWidth(200.0);
        bpPhoto.setCenter(photo);

        taJugadores.setStyle("-fx-text-alignment: center");
        taJugadores.setText(gameEvent.printPlayers());
    }

    @FXML
    void controlOrdenarNombre(ActionEvent event) {
        gameEvent.sortByName();
        taJugadores.setText(gameEvent.printPlayers());
    }

    @FXML
    void controlOrdenarPuntaje(ActionEvent event) {
        gameEvent.sortByScore();
        taJugadores.setText(gameEvent.printPlayers());
    }

    @FXML
    void controlRegistrarJugador(ActionEvent event) {
        try {
            gameEvent.addPlayer(
                    tfNombre.getText(),
                    tfApodo.getText(),
                    Integer.parseInt(tfCategoria.getText()),
                    Double.parseDouble(tfPuntaje.getText()));
            taJugadores.setText(gameEvent.printPlayers());
        }catch (EmptyDataException e){
            Alert men = new Alert(Alert.AlertType.WARNING);
            men.setTitle("Warning !!!");
            men.setHeaderText("Worthless");
            men.setContentText("You have not entered any value.");
            men.showAndWait();
        }
    }

    @FXML
    public void controlGuardarEstado(ActionEvent event){
        gameEvent.saveFile(GameEvent.PATH_FILE);
    }

}
