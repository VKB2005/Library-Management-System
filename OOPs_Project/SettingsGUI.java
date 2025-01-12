import javax.swing.*;
import java.awt.*;

class SettingsGUI{
private Settings settings;

SettingsGUI(Settings settings){
if(settings == null){
throw new IllegalArgumentException("Settings object cannot be null");
}
this.settings = settings;
createSettingsGUI();
}
private void createSettingsGUI() {
JFrame settingsFrame = new JFrame("Library Settings");
settingsFrame.setSize(400, 300);
settingsFrame.setLayout(new GridLayout(5, 2, 10, 10));
JLabel nameLabel = new JLabel("Library Name:");
JTextField nameField = new JTextField(settings.getLibraryName());
JLabel addressLabel = new JLabel("Address:");
JTextField addressField = new JTextField(settings.getAddress());
JLabel contactLabel = new JLabel("Contact Info:");
JTextField contactField = new JTextField(settings.getContactInfo());
JLabel fineLabel = new JLabel("Fine Rate:");
JTextField fineField = new JTextField(String.valueOf(settings.getFineRate()));

JButton saveButton = new JButton("Save");
JButton cancelButton = new JButton("Cancel");

saveButton.addActionListener(e -> {
settings.setLibraryName(nameField.getText());
settings.setAddress(addressField.getText());
settings.setContactInfo(contactField.getText());
try{
double fineRate = Double.parseDouble(fineField.getText());
settings.setFineRate(fineRate);
JOptionPane.showMessageDialog(settingsFrame, "Settings updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
}catch(NumberFormatException ex){
JOptionPane.showMessageDialog(settingsFrame, "Invalid fine rate value!", "Error", JOptionPane.ERROR_MESSAGE);
}
});
cancelButton.addActionListener(e -> settingsFrame.dispose());

settingsFrame.add(nameLabel);
settingsFrame.add(nameField);
settingsFrame.add(addressLabel);
settingsFrame.add(addressField);
settingsFrame.add(contactLabel);
settingsFrame.add(contactField);
settingsFrame.add(fineLabel);
settingsFrame.add(fineField);
settingsFrame.add(saveButton);
settingsFrame.add(cancelButton);
settingsFrame.setVisible(true);
}
}
