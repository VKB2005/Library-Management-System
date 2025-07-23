import javax.swing.*;
import java.awt.*;

class AdminLoginGUI{
public AdminLoginGUI(){
Library library = Library.getInstance();
Settings settings = Settings.getInstance();

JFrame loginFrame = new JFrame("Admin Login");
loginFrame.setSize(300, 200);
loginFrame.setLayout(new GridLayout(3, 2, 10, 10));
loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

JLabel userLabel = new JLabel("Username:");
JLabel passLabel = new JLabel("Password:");
JTextField userField = new JTextField();
JPasswordField passField = new JPasswordField();
JButton loginButton = new JButton("Login");
JButton backButton = new JButton("Back");

loginButton.addActionListener(e -> {
String username = userField.getText();
String password = new String(passField.getPassword());
if(MainMenu.getAdminCredentials().containsKey(username) && MainMenu.getAdminCredentials().get(username).equals(password)){
new AdminPanelGUI(library,settings);
loginFrame.dispose();
}
else{
JOptionPane.showMessageDialog(loginFrame, "Invalid credentials.", "Error", JOptionPane.ERROR_MESSAGE);
}
});
backButton.addActionListener(e->{
new MainMenu(library, settings, new Search(library));
loginFrame.dispose();
});

loginFrame.add(userLabel);
loginFrame.add(userField);
loginFrame.add(passLabel);
loginFrame.add(passField);
loginFrame.add(loginButton);
loginFrame.add(backButton);

loginFrame.setVisible(true);
}
}
