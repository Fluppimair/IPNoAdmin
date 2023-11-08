module com.mycompany.ipnoadmin {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.ipnoadmin to javafx.fxml;
    exports com.mycompany.ipnoadmin;
}
