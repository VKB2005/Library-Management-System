import javax.swing.*;
import java.awt.*;

class RemoveBookGUI{
public RemoveBookGUI(Library library){
JFrame removeBookFrame = new JFrame("Remove Book");
removeBookFrame.setSize(300, 200);
removeBookFrame.setLayout(new GridLayout(3, 1, 10, 10));

JLabel idLabel = new JLabel("Enter Book ID:");
JTextField idField = new JTextField();
JButton removeButton = new JButton("Remove");
JButton cancelButton = new JButton("Cancel");

removeButton.addActionListener(e->{
String bookId = idField.getText();
library.removeBook(bookId);
JOptionPane.showMessageDialog(removeBookFrame, "Book removed successfully (if it exists).", "Success", JOptionPane.INFORMATION_MESSAGE);
removeBookFrame.dispose();
});
cancelButton.addActionListener(e->removeBookFrame.dispose());

removeBookFrame.add(idLabel);
removeBookFrame.add(idField);
removeBookFrame.add(removeButton);
removeBookFrame.add(cancelButton);
removeBookFrame.setVisible(true);
}
}
