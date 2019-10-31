package bullsandcows;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableView;

public class PrimaryController {
    private int turnCounter;
    public Spinner<Integer> num1;
    public Spinner<Integer> num2;
    public Spinner<Integer> num3;
    public Spinner<Integer> num4;
    public TableView turns;

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    public void doTurn(ActionEvent actionEvent) {
        turnCounter++;
        int n1 = num1.getValue();
        int n2 = num2.getValue();
        int n3 = num3.getValue();
        int n4 = num4.getValue();
        String guess = "" + n1 + n2 +n3 + n4;


        Turn turn = new Turn();
        turn.setGuess(guess);
        turn.setTurnNr(turnCounter);


        turns.getItems().add(turn);

        turns.sort();
        System.out.println("Button pressed! " + guess);
    }
}
