package facebook; 
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;
import javafx.scene.control.ToggleButton;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.ContextMenu;

import java.util.List;













public class WritePostController extends MainController {
    @FXML
    private TextArea textArea;

    private ContextMenu mentionMenu;
    private final List<String> allNames = List.of("Alice", "Bob", "Charlie", "David", "Eve", "Frank");

    
    public void initialize() {
        
      
        mentionMenu = new ContextMenu();

        // Listener for key events in the TextArea
        textArea.addEventFilter(KeyEvent.KEY_TYPED, event -> {
            String currentText = textArea.getText();
            int caretPosition = textArea.getCaretPosition();

            // Check if user typed '@'
            if (event.getCharacter().equals("@")) {
                showMentionMenu();
            }
            // If menu is open, update dynamically based on the text
            else if (mentionMenu.isShowing() && caretPosition > 0) {
                String substring = getTextAfterAt(currentText, caretPosition);
                updateMentionMenu(substring);
            }
        });
    }
    
    
    private void showMentionMenu() {
        mentionMenu.getItems().clear();
        for (String name : allNames) {
            mentionMenu.getItems().add(createMenuItem(name));
        }
        mentionMenu.show(textArea, textArea.getScene().getWindow().getX() + textArea.getLayoutX(),
                textArea.getScene().getWindow().getY() + textArea.getLayoutY() + textArea.getCaretPosition());
    }

    private void updateMentionMenu(String textAfterAt) {
        mentionMenu.getItems().clear();
        if (textAfterAt.isEmpty()) {
            // If no text after '@', show all names
            for (String name : allNames) {
                mentionMenu.getItems().add(createMenuItem(name));
            }
        } else {
            // Filter names based on the text after '@'
            for (String name : allNames) {
                if (name.toLowerCase().startsWith(textAfterAt.toLowerCase())) {
                    mentionMenu.getItems().add(createMenuItem(name));
                }
            }
        }

        // Hide the menu if no items are left
        if (mentionMenu.getItems().isEmpty()) {
            mentionMenu.hide();
        }
    }

    private MenuItem createMenuItem(String name) {
        MenuItem item = new MenuItem(name);
        item.setOnAction(e -> insertMention(name));
        return item;
    }

    private void insertMention(String name) {
        String currentText = textArea.getText();
        int caretPosition = textArea.getCaretPosition();
        int atIndex = currentText.lastIndexOf("@", caretPosition - 1);

        // Replace text starting with '@' with the selected name
        String beforeAt = currentText.substring(0, atIndex + 1);
        String afterAt = currentText.substring(caretPosition);
        textArea.setText(beforeAt + name + " " + afterAt);
        textArea.positionCaret(beforeAt.length() + name.length() + 1); // Set caret position
        mentionMenu.hide();
    }

    private String getTextAfterAt(String text, int caretPosition) {
        int atIndex = text.lastIndexOf("@", caretPosition - 1);
        if (atIndex != -1) {
            return text.substring(atIndex + 1, caretPosition).trim();
        }
        return "";
    }

    
    
    
    
    
    
    
    
    @FXML
    private ToggleButton privateToggle;
    @FXML
    private void togglePrivate() {
        if (privateToggle.isSelected()) {
            privateToggle.setStyle("-fx-background-color: #3b5998; -fx-text-fill: white;");
            privateToggle.setText("ON");
        } else {
            privateToggle.setStyle("-fx-background-color: lightgray; -fx-text-fill: black;");
            privateToggle.setText("OFF");
        }
        
        
    }

    
   @Override
   public void write_post (  ) {
       
         try {
             
            Parent root = FXMLLoader.load(getClass().getResource("post.fxml"));
            
            //privateToggle.setText(toggle2.getText());// for save
            
            Facebook.scene = new Scene(root,Facebook.width , Facebook.height); 
            
            Facebook.stage.setScene(Facebook.scene );
            
            Facebook.stage.show(); 
            
            
            
        } catch (IOException e) {
             System.out.println(e);
        }
        
    }
   
   
   public void toRight () {
   
    textArea.setNodeOrientation(javafx.geometry.NodeOrientation.RIGHT_TO_LEFT);
    
    if (textArea.getText().equals("")){
   
      textArea.setPromptText("أكتب هنا..."); 
    
    }
   
   }
   public void toLeft () {
   
   
    textArea.setNodeOrientation(javafx.geometry.NodeOrientation.LEFT_TO_RIGHT);
    if (textArea.getText().equals("")){
   
      textArea.setPromptText("Write here..."); 
    
    }
   
   } 
   
   
  
    
}