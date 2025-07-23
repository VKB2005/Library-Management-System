import javax.swing.*;
import java.awt.*;

class RemoveMemberGUI{
public RemoveMemberGUI(Library library){
JFrame removeMemberFrame = new JFrame("Remove Member");
removeMemberFrame.setSize(300, 200);
removeMemberFrame.setLayout(new GridLayout(3, 1, 10, 10));

JLabel idLabel = new JLabel("Enter Member ID:");
JTextField idField = new JTextField();
JButton removeButton = new JButton("Remove");
JButton cancelButton = new JButton("Cancel");

removeButton.addActionListener(e->{
String memberId = idField.getText();
library.removeMember(memberId);
JOptionPane.showMessageDialog(removeMemberFrame, "Member removed successfully (if it exists).", "Success", JOptionPane.INFORMATION_MESSAGE);
removeMemberFrame.dispose();
});
 cancelButton.addActionListener(e -> removeMemberFrame.dispose());

removeMemberFrame.add(idLabel);
removeMemberFrame.add(idField);
removeMemberFrame.add(removeButton);
removeMemberFrame.add(cancelButton);
removeMemberFrame.setVisible(true);
}
}
