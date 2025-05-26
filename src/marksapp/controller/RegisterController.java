/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package marksapp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import marksapp.dao.UserDao;
import marksapp.model.UserData;
import marksapp.view.LoginView;
import marksapp.view.RegisterView;

/**
 *
 * @author sangyakoirala
 */
public class RegisterController {
    RegisterView view = new RegisterView();
    public RegisterController(RegisterView view){
        this.view=view;
        RegisterUser register= new RegisterUser();
        LoginNavigation loginNav = new LoginNavigation();
        this.view.registerUser(register);        
        this.view.loginNavigation(loginNav);

    }
    public void open(){
        this.view.setVisible(true);
    }
    public void close(){
        this.view.dispose();
    }
    class LoginNavigation implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
             LoginView loginView = new LoginView();
                    LoginController controller = new LoginController(loginView);
                    controller.open();
                    close();
        }

        @Override
        public void mousePressed(MouseEvent e) {
               }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
        
    }
    class RegisterUser implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
//            assign required values to variables
            String name= view.getNameTextField().getText();
            String email = view.getEmailTextField().getText();
            String password = String.valueOf(view.getPasswordField().getPassword());
            String confirmPassword = String.valueOf(view.getConfirmPasswordField().getPassword());
            
            if (name.isEmpty()||email.isEmpty()||password.isEmpty()||confirmPassword.isEmpty()){
                JOptionPane.showMessageDialog(view, "Fill in all the fields");
            } else if (!password.equals(confirmPassword)){
                JOptionPane.showMessageDialog(view,"Passwords do not match");
            } else{
                UserData user = new UserData(name,email,password);
                UserDao userDao = new UserDao();
                boolean result = userDao.register(user);
                if (result){
                    JOptionPane.showMessageDialog(view, "Registered Successfully");
                    LoginView loginView = new LoginView();
                    LoginController controller = new LoginController(loginView);
                    controller.open();
                    close();
                } else {
                JOptionPane.showMessageDialog(view,"Failed to Register");
                    
                }
            }
                
                
            
        }
        
    }
}
