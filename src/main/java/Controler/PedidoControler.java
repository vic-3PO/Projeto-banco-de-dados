/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controler;

import DAO.Conexao;
import DAO.PedidoDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Pedido;
import model.Usuario;
import view.menuView;
import static view.menuView.Tabela;

/**
 *
 * @author victor
 */
public class PedidoControler {
    private menuView view;
    
    public PedidoControler(menuView view){
        this.view = view;
    }
    
    public void insere() throws SQLException{
        String DescricaoP =  view.getjTextFieldDESCRICAO().getText();
        float ValorP =  Float.parseFloat(view.getjTextFieldVALORP().getText());
        int categoria_idP =  Integer.parseInt(view.getjTextFieldIDUSUARIOPEDIDO().getText());    
        
        Usuario usuarioP = new Usuario(categoria_idP);
       
        Pedido pedidoInsert = new Pedido( DescricaoP, ValorP, usuarioP);
        
        Connection conexao = new Conexao().getConnection();
        PedidoDAO pedidoDao = new PedidoDAO(conexao);
        
        pedidoDao.insert(pedidoInsert);
        pree();
           
       }
    
    public ArrayList<Pedido> selectall() throws SQLException{
        
        Connection conexao = new Conexao().getConnection();
        PedidoDAO pedidoDao = new PedidoDAO(conexao);
        ArrayList<Pedido> pedidos = pedidoDao.selectAll();
        
        if(pedidos.isEmpty()){
            JOptionPane.showMessageDialog(view, "Lista vazia");
        } else {
            pree();
            pedidoDao.selectAll();
        }
        return null;
    }
    
     public void selectid() throws SQLException{
        int id =  Integer.parseInt(view.getjTextFieldPESQUISAPEDIDOID().getText());
        
        Usuario usuarioSelect = new Usuario(id);
        Pedido pedidoSelect = new Pedido(usuarioSelect);
        
        Connection conexao = new Conexao().getConnection();
        PedidoDAO pedidoDao = new PedidoDAO(conexao);
        
        boolean existe = pedidoDao.existeNoBancoPedidoID(pedidoSelect);
        
        if(existe){
           pedidoDao.selectID(pedidoSelect);
           
           ArrayList<Pedido> pedidos = pedidoDao.selectID(pedidoSelect);
           
           DefaultTableModel model = (DefaultTableModel) menuView.Tabela_Pedido.getModel();
           model.setNumRows(0);
            
           Object colunas[] = new Object[4];
            
        for(int i = 0; i < pedidos.size(); i++){
            Pedido pedidosl = pedidos.get(i);
            
            colunas[0] = pedidosl.getId();
            colunas[1] = pedidosl.getDescricao();
            colunas[2] = pedidosl.getValor_pedido();
            colunas[3] = pedidosl.getUsuario().getId();
            
            model.addRow(colunas);
        }
       } else {
           JOptionPane.showMessageDialog(view, "ID de Usuario não existe");
       }
    }
    
    
    public static void pree() throws SQLException{
        Connection conexao = new Conexao().getConnection();
            
            PedidoDAO pedidoDao = new PedidoDAO(conexao);
            
            DefaultTableModel model = (DefaultTableModel) menuView.Tabela_Pedido.getModel();
            model.setNumRows(0);
            
            Object colunas[] = new Object[4];
            
            ArrayList<Pedido> pedidos = pedidoDao.selectAll();

        for(int i = 0; i < pedidos.size(); i++){
            Pedido pedidosl = pedidos.get(i);
            
            colunas[0] = pedidosl.getId();
            colunas[1] = pedidosl.getDescricao();
            colunas[2] = pedidosl.getValor_pedido();
            colunas[3] = pedidosl.getUsuario().getId();
            
            model.addRow(colunas);
        }
}
    
    }

