/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controler;

import DAO.Conexao;
import DAO.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Usuario;
import view.FormCadastro;
import view.login;
import view.menuView;

/**
 *
 * @author victor
 */
public class loginControler {
    private login view;

    public loginControler(login view) {
        this.view = view;
    }

    public void autenticar() throws SQLException {
        
       String usuario = view.getjTextFieldUsuarioL().getText();
       String senha = view.getjTextFieldSenhaL().getText();
       
       Usuario usuarioAutenticador = new Usuario(usuario, senha);
        
       Connection conexao = new Conexao().getConnection();
       UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
       
       boolean existe = usuarioDao.existeNoBancoUsuarioSenha(usuarioAutenticador);
       
       if(existe){
           menuView telaDeMenu = new menuView();
            telaDeMenu.setVisible(true);
       } else {
           JOptionPane.showMessageDialog(view, "Usuario ou Senha invalidos");
       }
       
       
    }
    
    
}
