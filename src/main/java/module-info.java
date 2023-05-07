module com.example.contactsmodification {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.contactsmodification to javafx.fxml;
    exports com.example.contactsmodification;
}