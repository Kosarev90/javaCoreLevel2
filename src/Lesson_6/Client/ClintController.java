package Lesson_6.Client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ClintController {
    @FXML
    private TextArea textArea;
    @FXML
    private TextField textField;
    @FXML
    private Button sendButton;
    @FXML
    public ListView<String> userList;

    public void sendMessage() {
        if (!textField.getText().isEmpty()) {
            textArea.appendText(textField.getText());
            textArea.appendText(System.lineSeparator());
            textField.clear();
        }
    }
}