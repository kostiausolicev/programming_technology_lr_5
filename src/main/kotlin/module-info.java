module ru.kosti.lr5 {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;


    opens ru.kosti.lr5 to javafx.fxml;
    exports ru.kosti.lr5;
}