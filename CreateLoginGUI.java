import javax.swing.*;
import java.awt.*;

class CreateLoginGUI{
public CreateLoginGUI(MainMenu mainMenu) {
JFrame frame = new JFrame("Create Login");
frame.setSize(400, 300);
frame.setLayout(new GridLayout(5, 2, 10, 10));
JLabel roleLabel = new JLabel("Role:");
JComboBox<String> roleComboBox = new JComboBox<>(new String[]{"Admin", "User"});
JLabel usernameLabel = new JLabel("Username:");
JTextField usernameField = new JTextField();
JLabel passwordLabel = new JLabel("Password:");
JPasswordField passwordField = new JPasswordField();
JButton createButton = new JButton("Create");
JButton backButton = new JButton("Back");

createButton.addActionListener(e->{
String role = (String) roleComboBox.getSelectedItem();
String username = usernameField.getText();
String password = new String(passwordField.getPassword());
if (role.equals("Admin")){
MainMenu.getAdminCredentials().put(username, password);
JOptionPane.showMessageDialog(frame, "Admin credentials created successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
} 
else{
MainMenu.getUserCredentials().put(username, password);
JOptionPane.showMessageDialog(frame, "User credentials created successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
}
});
backButton.addActionListener(e->{
frame.dispose();
new MainMenu(mainMenu.getLibrary(), mainMenu.getSettings(), mainMenu.getSearch());
});
frame.add(roleLabel);
frame.add(roleComboBox);
frame.add(usernameLabel);
frame.add(usernameField);
frame.add(passwordLabel);
frame.add(passwordField);
frame.add(createButton);
frame.add(backButton);
frame.setVisible(true);
}
}
