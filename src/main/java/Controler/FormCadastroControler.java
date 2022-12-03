/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controler;

import DAO.Conexao;
import DAO.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Usuario;
import view.FormCadastro;

/**
 *
 * @author victor
 */
public class FormCadastroControler {
    private FormCadastro view;

    public FormCadastroControler(FormCadastro view) {
        this.view = view;
    }
    
  public void salvaUsuario(){
             
      String usuario = view.getjTextFieldUsuario().getText();
      String senha = view.getjTextFieldSenha().getText();
        
        Usuario usuarioTeste = new Usuario(usuario, senha);
        
        try {
            Connection conexao = new Conexao().getConnection();
            UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
            usuarioDao.insert(usuarioTeste);
            
            JOptionPane.showMessageDialog(null,"usuario salvo com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(FormCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
  }  
}
