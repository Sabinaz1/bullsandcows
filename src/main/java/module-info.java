module bullsandcows {
    requires javafx.controls;
    requires javafx.fxml;

    opens bullsandcows to javafx.fxml;
    exports bullsandcows;
}