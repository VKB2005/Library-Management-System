import javax.swing.*;
import java.awt.*;

class AddMemberGUI{
public AddMemberGUI(Library library){
JFrame addMemberFrame = new JFrame("Add Member");
addMemberFrame.setSize(400, 300);
addMemberFrame.setLayout(new GridLayout(3, 2, 10, 10));

JLabel nameLabel = new JLabel("Name:");
JLabel contactLabel = new JLabel("Contact Info:");
JTextField nameField = new JTextField();
JTextField contactField = new JTextField();
JButton addButton = new JButton("Add");
JButton cancelButton = new JButton("Cancel");

addButton.addActionListener(e -> {
String name = nameField.getText();
String contact = contactField.getText();

Members newMember = new Members(name, contact);
library.registerMember(newMember);

JOptionPane.showMessageDialog(addMemberFrame, "Member added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
addMemberFrame.dispose();
});

cancelButton.addActionListener(e -> addMemberFrame.dispose());

addMemberFrame.add(nameLabel);
addMemberFrame.add(nameField);
addMemberFrame.add(contactLabel);
addMemberFrame.add(contactField);
addMemberFrame.add(addButton);
addMemberFrame.add(cancelButton);
addMemberFrame.setVisible(true);
}
}
