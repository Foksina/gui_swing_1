package tb.soft;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Window extends JFrame implements ActionListener{
    private static JFrame frame;
    private static JPanel panel;
    private static JLabel label;
    private static JTextField userText;
    private static JLabel passwordLabel;
    private static JPasswordField passwordText;
    private static JButton loginButton;
    private static JButton clearButton;
    private static JLabel success;
    private int wrong =0;
    Data data = new Data();

    public Window() throws IOException {
        panel = new JPanel();
        frame = new JFrame();
        frame.setSize(350,250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);

        label = new JLabel("Nickname");
        label.setBounds(10, 20, 80, 25);
        panel.add(label);

        userText = new JTextField(20);
        userText.setBounds(100,20,165,25);
        panel.add(userText);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 70, 80, 25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField(20);
        passwordText.setBounds(100,70,165,25);
        panel.add(passwordText);

        loginButton = new JButton("Login");
        loginButton.setBounds(10,110, 80, 25);
        loginButton.addActionListener(this);
        panel.add(loginButton);

        clearButton = new JButton("Clear");
        clearButton.setBounds(200,110, 80, 25);
        clearButton.addActionListener(this);
        panel.add(clearButton);

        success = new JLabel("");
        success.setBounds(10,150,300,25);
        panel.add(success);

        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == loginButton){
            String user = userText.getText();
            char[] password = passwordText.getPassword();
            if(wrong <2){
                if(data.userData().containsKey(user)){
                    char[] goodPassword = data.userData().get(user);
                    int i =0;
                    int j=0;
                    if(password.length==goodPassword.length){
                        while(i<goodPassword.length){
                            if(password[i]==goodPassword[i]){
                                j=j+1;
                            }
                            i=i+1;
                        }
                        if(j==password.length){
                            success.setText("Login successful!");
                            panel.setBackground(Color.green);
                            wrong = 0;
                        }
                        else{
                            success.setText("Wrong password");
                            panel.setBackground(Color.red);
                            wrong = wrong +1;
                        }
                    }
                    else{
                        success.setText("Wrong password");
                        panel.setBackground(Color.red);
                        wrong = wrong +1;
                    }
                }
                else{
                    success.setText("Nickname doesn't exist");
                    panel.setBackground(Color.red);
                    wrong = wrong +1;
                }
            }
            else{
                System.exit(0);
            }
        }
        if(source==clearButton){
            passwordText.setText(null);
            userText.setText(null);
            panel.setBackground(null);
        }
    }
}