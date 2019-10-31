package bullsandcows;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Turn {
    SimpleIntegerProperty turnNr = new SimpleIntegerProperty(this, "turnNr");
    private SimpleStringProperty guess = new SimpleStringProperty(this, "guess");
    private SimpleIntegerProperty cows = new SimpleIntegerProperty(this, "cows");
    private SimpleIntegerProperty bulls = new SimpleIntegerProperty(this, "bulls");

    public int getTurnNr() {
        return turnNr.get();
    }

    public SimpleIntegerProperty turnNrProperty() {
        return turnNr;
    }

    public void setTurnNr(int turnNr) {
        this.turnNr.set(turnNr);
    }

    public String getGuess() {
        return guess.get();
    }

    public SimpleStringProperty guessProperty() {
        return guess;
    }

    public void setGuess(String guess) {
        this.guess.set(guess);
    }

    public int getCows() {
        return cows.get();
    }

    public SimpleIntegerProperty cowsProperty() {
        return cows;
    }

    public void setCows(int cows) {
        this.cows.set(cows);
    }

    public int getBulls() {
        return bulls.get();
    }

    public SimpleIntegerProperty bullsProperty() {
        return bulls;
    }

    public void setBulls(int bulls) {
        this.bulls.set(bulls);
    }
}
