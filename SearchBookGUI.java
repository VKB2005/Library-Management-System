import javax.swing.*;
import java.awt.*;

class SearchBookGUI{
public SearchBookGUI(Search search){
JFrame searchFrame = new JFrame("Search Book");
searchFrame.setSize(400, 300);
searchFrame.setLayout(new BorderLayout(10, 10));

JPanel searchPanel = new JPanel(new BorderLayout());
JLabel label = new JLabel("Enter Book Title:");
JTextField titleField = new JTextField();
JButton searchButton = new JButton("Search");

searchPanel.add(label, BorderLayout.WEST);
searchPanel.add(titleField, BorderLayout.CENTER);
searchPanel.add(searchButton, BorderLayout.EAST);

JTextArea resultArea = new JTextArea();
resultArea.setEditable(false);

searchButton.addActionListener(e->{
String title = titleField.getText();
Books book = search.findBookByTitle(title);
if(book != null){
resultArea.setText("Book found:"+book.bookDetails());
} 
else{
resultArea.setText("Book not found.");
}
});

searchFrame.add(searchPanel, BorderLayout.NORTH);
searchFrame.add(new JScrollPane(resultArea), BorderLayout.CENTER);
searchFrame.setVisible(true);
}
}
