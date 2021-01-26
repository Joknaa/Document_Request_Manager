import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login implements ActionListener {

    private static JFrame frame = new JFrame();
    private static JPanel panel = new JPanel();
    private static JLabel userLabel = new JLabel("Username");
    private static JTextField userText = new JTextField(30);
    private static JLabel passwdLabel = new JLabel("Password");
    private static JPasswordField passwdField = new JPasswordField();
    private static JButton button = new JButton("Login");
    private static JLabel success = new JLabel();


    public static void main(String[] args) { showFrame(); }

    @Override
    public void actionPerformed(ActionEvent e) {

        admin newFrame = new admin();

        if (userText.getText().equals("admin") && passwdField.getText().equals("admina")){
        //success.setText("Login Success!");
            frame.setVisible(false);
            newFrame.showTable();
        }
        else success.setText("Login Failed!");
    }

    public static void showFrame(){
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        frame.setTitle("Login Admin");
        frame.add(panel);
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(null);


        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);


        userText.setBounds(100, 20, 165, 26);
        panel.add(userText);


        passwdLabel.setBounds(10, 80, 80, 25);
        panel.add(passwdLabel);


        passwdField.setBounds(100, 80, 165,26);
        panel.add(passwdField);


        button.setBounds(130, 140, 100, 30);
        panel.add(button);
        button.addActionListener(new login());


        success.setBounds(10, 170, 100, 30);
        panel.add(success);


        frame.setVisible(true);
    }

}
