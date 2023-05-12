package com.example.contactsmodification;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

import java.util.Collections;
import java.util.Comparator;

public class ContactsModificationController {
    @FXML    private ListView<Contact> studentsListView;
    @FXML    private ImageView avatarImageView;
    @FXML    private TextField nameTextField;
    @FXML    private TextField secondNameTextField;
    @FXML    private TextField emailTextFiled;
    @FXML    private TextField phoneTextField;
    @FXML    private Button addButton;
    @FXML    private Button deleteButton;
    @FXML    private Button clearButton;
    @FXML    private TextField imagePathTextField;


    private final ObservableList<Contact> students = FXCollections.observableArrayList();

    public void initialize(){
        students.add(new Contact("Jungkook", "Jeon", "jean.jungkook_1997@gmail.com", "+1234567", "https://st1.bollywoodlife.com/wp-content/uploads/2021/07/Jungkook-BTS-BTS-ARMY-Jeon-Jungkook.png?impolicy=Medium_Widthonly&w=1280&h=900"));



        //Collections.sort(students);
        students.stream().sorted().map((s -> s.getLastName()));

        studentsListView.setItems(students);

        // when ListView selection changes, show large cover in ImageView
        studentsListView.getSelectionModel().selectedItemProperty().
                addListener(
                        new ChangeListener<Contact>() {
                            @Override
                            public void changed(ObservableValue<? extends Contact> ov, Contact oldValue, Contact t1) {
                                avatarImageView.setImage(new Image(t1.getImage()));
                                nameTextField.setText(t1.getName());
                                secondNameTextField.setText(t1.getLastName());
                                emailTextFiled.setText(t1.getEmail());
                                phoneTextField.setText(t1.getPhone());

                            }
                        }
                );

        // set custom ListView cell factory
        studentsListView.setCellFactory(
                new Callback<ListView<Contact>, ListCell<Contact>>() {
                    @Override
                    public ListCell<Contact> call(ListView<Contact> listView) {
                        return new ContactsImage();
                    }
                }
        );



    }



    @FXML    void onAddPressed(ActionEvent event) {
        students.add(new Contact(nameTextField.getText(), secondNameTextField.getText(), emailTextFiled.getText(),phoneTextField.getText(), imagePathTextField.getText()));
        studentsListView.setItems(students);
    }

    @FXML
    void onCLearPressed(ActionEvent event) {
        nameTextField.setText("");
        secondNameTextField.setText("");
        emailTextFiled.setText("");
        phoneTextField.setText("");
        imagePathTextField.setText("");

    }

    @FXML
    void onDeletePressed(ActionEvent event) {
        try {
            Contact newContact = new Contact(nameTextField.getText(), secondNameTextField.getText(),
                    emailTextFiled.getText(),phoneTextField.getText(),imagePathTextField.getText() );

            students.removeIf(i-> i.getName().equals(newContact.getName()) && i.getLastName().equals(newContact.getLastName()) && i.getEmail().equals(newContact.getEmail()) && i.getPhone().equals(newContact.getPhone()) && i.getImage().equals(newContact.getImage()));
            studentsListView.setItems(students);
            nameTextField.setText("");
            secondNameTextField.setText("");
            emailTextFiled.setText("");
            phoneTextField.setText("");
            imagePathTextField.setText("");


        }
        catch (NumberFormatException ex) {
            nameTextField.setText("Not found in the directory");
            secondNameTextField.setText("Not found in the directory");

        }

    }

}
