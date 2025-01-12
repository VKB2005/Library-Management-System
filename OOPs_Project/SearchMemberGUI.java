import javax.swing.*;
import java.awt.*;

class SearchMemberGUI{
public SearchMemberGUI(Search search){
JFrame searchFrame = new JFrame("Search Member");
searchFrame.setSize(400, 300);
searchFrame.setLayout(new BorderLayout(10, 10));

JPanel searchPanel = new JPanel(new BorderLayout());
JLabel label = new JLabel("Enter Member Name:");
JTextField nameField = new JTextField();
JButton searchButton = new JButton("Search");

searchPanel.add(label, BorderLayout.WEST);
searchPanel.add(nameField, BorderLayout.CENTER);
searchPanel.add(searchButton, BorderLayout.EAST);

JTextArea resultArea = new JTextArea();
resultArea.setEditable(false);
JScrollPane scrollPane = new JScrollPane(resultArea);

searchButton.addActionListener(e->{
Members member = search.findMemberByName(nameField.getText());
if(member != null){
resultArea.setText("Member Details:\n");
resultArea.append("Name: " + member.getName() + "\n");
resultArea.append("Contact Info: " + member.getContactInfo() + "\n");
resultArea.append("Borrowed Books:\n");
for (Books book : member.getBorrowedBooks()){
resultArea.append("- " + book.getTitle() + " by " + book.getAuthor() + "\n");
}
} 
else{
resultArea.setText("Member not found.");
}
});

searchFrame.add(searchPanel, BorderLayout.NORTH);
searchFrame.add(new JScrollPane(resultArea), BorderLayout.CENTER);
searchFrame.setVisible(true);
}
}
