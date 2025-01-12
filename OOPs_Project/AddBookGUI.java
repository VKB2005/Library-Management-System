import javax.swing.*;
import java.awt.*;

class AddBookGUI{
public AddBookGUI(Library library){
JFrame addBookFrame = new JFrame("Add Book");
addBookFrame.setSize(400, 300);
addBookFrame.setLayout(new GridLayout(5, 2, 10, 10));

JLabel titleLabel = new JLabel("Title:");
JLabel authorLabel = new JLabel("Author:");
JLabel yearLabel = new JLabel("Published Year:");
JLabel genreLabel = new JLabel("Genre:");

JTextField titleField = new JTextField();
JTextField authorField = new JTextField();
JTextField yearField = new JTextField();
JTextField genreField = new JTextField();

JButton addButton = new JButton("Add");
JButton cancelButton = new JButton("Cancel");

addButton.addActionListener(e->{
String title = titleField.getText();
String author = authorField.getText();
int year = Integer.parseInt(yearField.getText());
String genre = genreField.getText();
Books newBook = new Books(title, author, year, genre);
library.addBook(newBook);

JOptionPane.showMessageDialog(addBookFrame, "Book added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
addBookFrame.dispose();
});
cancelButton.addActionListener(e->addBookFrame.dispose());

addBookFrame.add(titleLabel);
addBookFrame.add(titleField);
addBookFrame.add(authorLabel);
addBookFrame.add(authorField);
addBookFrame.add(yearLabel);
addBookFrame.add(yearField);
addBookFrame.add(genreLabel);
addBookFrame.add(genreField);
addBookFrame.add(addButton);
addBookFrame.add(cancelButton);
addBookFrame.setVisible(true);
}
}
