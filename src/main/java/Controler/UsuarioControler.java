/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controler;

import DAO.Conexao;
import DAO.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.Usuario;
import view.menuView;
import static view.menuView.Tabela;


/**
 *
 * @author victor
 */
public class UsuarioControler {
    private menuView view;
    
    public UsuarioControler(menuView view){
        this.view = view;
    }
    
    public void Deletar() throws SQLException{
        int id =  Integer.parseInt(view.getjTextFieldIDDELETE().getText());
        
        Usuario usuarioDelete = new Usuario(id);
        
        Connection conexao = new Conexao().getConnection();
        UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
    
        boolean existe = usuarioDao.existeNoBancoUsuarioID(usuarioDelete);
        
        if(existe){
           usuarioDao.delete(usuarioDelete);
           pree();
       } else {
           JOptionPane.showMessageDialog(view, "ID de Usuario não existe");
       }
    }
    
    public void selectid() throws SQLException{
        int id =  Integer.parseInt(view.getjTextFieldIDSELECT().getText());
        
        Usuario usuarioSelect = new Usuario(id);
        
        Connection conexao = new Conexao().getConnection();
        UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
        
        boolean existe = usuarioDao.existeNoBancoUsuarioID(usuarioSelect);
        
        if(existe){
           usuarioDao.selectID(usuarioSelect);

            DefaultTableModel model = (DefaultTableModel) Tabela.getModel();
            model.setNumRows(0);
            
            Object colunas[] = new Object[3];
            
            
            Usuario usuarios = usuarioDao.selectID(usuarioSelect);
        for(int i = 0; i < 1; i++){
            Usuario usuariosl = usuarios;
            
            colunas[0] = usuariosl.getId();
            colunas[1] = usuariosl.getUsuario();
            colunas[2] = usuariosl.getSenha();
            
            model.addRow(colunas);
        }
       } else {
           JOptionPane.showMessageDialog(view, "ID de Usuario não existe");
       }
    }
    
    public ArrayList<Usuario> selectall() throws SQLException{
        
        Connection conexao = new Conexao().getConnection();
        UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
        ArrayList<Usuario> usuarios = usuarioDao.selectAll();
        
        for(Usuario usuario : usuarios){
                System.out.println(usuario.getUsuario());
            }
        
        
        if(usuarios.isEmpty()){
            JOptionPane.showMessageDialog(view, "Lista vazia");
        } else {
            pree();
            usuarioDao.selectAll();
        }
        return null;
    }
    
    public void atualiza() throws SQLException{
        String UsuarioN =  view.getjTextFieldUPUSU().getText();
        String SenhaN =  view.getjTextFieldUPSENHA().getText();
        int id =  Integer.parseInt(view.getjTextFieldIDUPDATE().getText());    
        
        Usuario usuarioUpdateV = new Usuario(id);
        Usuario usuarioUpdate = new Usuario(id, UsuarioN, SenhaN);
        
        Connection conexao = new Conexao().getConnection();
        UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
            
        boolean existe = usuarioDao.existeNoBancoUsuarioID(usuarioUpdateV);
        
        if(existe){
           usuarioDao.update(usuarioUpdate);
           pree();
       } else {
           JOptionPane.showMessageDialog(view, "ID de Usuario não existe");
       }
    }
    
    public static void pree() throws SQLException{
        Connection conexao = new Conexao().getConnection();
            
            UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
            
            DefaultTableModel model = (DefaultTableModel) Tabela.getModel();
            model.setNumRows(0);
            
            Object colunas[] = new Object[3];
            
            ArrayList<Usuario> usuarios = usuarioDao.selectAll();

        for(int i = 0; i < usuarios.size(); i++){
            Usuario usuariosl = usuarios.get(i);
            
            colunas[0] = usuariosl.getId();
            colunas[1] = usuariosl.getUsuario();
            colunas[2] = usuariosl.getSenha();
            
            model.addRow(colunas);
        }
}
    
    
    
}
