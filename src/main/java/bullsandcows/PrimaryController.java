package bullsandcows;

import java.io.IOException;
import java.util.*;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableView;

public class PrimaryController {

    private int turnCounter;
    public Spinner<Integer> num1;
    public Spinner<Integer> num2;
    public Spinner<Integer> num3;
    public Spinner<Integer> num4;
    public TableView <Turn> turns;
    public Button goButton;
    private List<Integer> myNumbers;
    Random rand = new Random();

    public void initialize(){
        generateRandomNumber();
      goButton.disableProperty().bind(
              Bindings.createBooleanBinding(this::invalidNumbers,
                      num1.valueProperty(),
                      num2.valueProperty(),
                      num3.valueProperty(),
                      num4.valueProperty())
      );
    }

    private void generateRandomNumber() {

        var rand = new Random();
        myNumbers = new ArrayList<>();
        while(myNumbers.size() <4) {
            int num = rand.nextInt(10);
            if(!myNumbers.contains(num)){
                myNumbers.add(num);
            }
        }

        // TODO remove this line after debug
        System.out.println(myNumbers);

    }

    private Boolean invalidNumbers() {
        var numSet = new HashSet<Integer>();
        numSet.add(num1.getValue());
        numSet.add(num2.getValue());
        numSet.add(num3.getValue());
        numSet.add(num4.getValue());
        return numSet.size() < 4;
    }

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    private int calculateBulls(List<Integer> userNumbers) {

        int result = 0;

        for (int i = 0; i < myNumbers.size(); i++) {
            int myNum = myNumbers.get(i);
            int userNum = userNumbers.get(i);
            if (myNum == userNum) {
                result++;
            }
        }
        return result;
    }

    private int calculateCows(List<Integer> userNumbers) {
        int result = 0;
        for (int ui = 0; ui < myNumbers.size(); ui++) {
            for (int mi = 0; mi < myNumbers.size(); mi++) {
                if (ui == mi) {
                    continue;
                }
                int myNum = myNumbers.get(mi);
                int userNum = userNumbers.get(ui);
                if(myNum == userNum) {
                    result++;
                }
            }

        }
        return result;
    }

    public void doTurn(ActionEvent actionEvent) throws IOException {
        turnCounter++;
        int n1 = num1.getValue();
        int n2 = num2.getValue();
        int n3 = num3.getValue();
        int n4 = num4.getValue();
        String guess = "" + n1 + n2 +n3 + n4;

        var userNumbers = List.of(n1,n2,n3,n4);
        var cows = calculateCows(userNumbers);
        var bulls = calculateBulls(userNumbers);


        Turn turn = new Turn();
        turn.setGuess(guess);
        turn.setTurnNr(turnCounter);
        turn.setCows(cows);
        turn.setBulls(bulls);


        turns.getItems().add(turn);

        turns.sort();
        System.out.println("Button pressed! " + guess);

        if(bulls == 4) {
            App.setRoot("secondary");
        }

    }
}
