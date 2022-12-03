/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Pedido;
import model.Usuario;

/**
 *
 * @author victor
 */
public class PedidoDAO {
    private final Connection connection;

    public PedidoDAO(Connection connection) {
        this.connection = connection;
    }
    
    public Pedido insert(Pedido pedido) throws SQLException{
        String sql = "INSERT INTO pedido (descricao,valor,categoria_id) VALUES (?,?,?)" ;
            
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1,pedido.getDescricao());
        statement.setFloat(2, pedido.getValor_pedido());
        statement.setInt(3, pedido.getUsuario().getId());
        
        statement.execute();
        
        ResultSet resultSet =  statement.getGeneratedKeys();
        
          if (resultSet.next()){
                int id = resultSet.getInt("id");
                pedido.setId(id);
            }
            return pedido;
        
    }
    
    public void delete(Pedido pedido) throws SQLException{
        
            String sql = "delete from pedido where id = ?" ;
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setInt(1, pedido.getId());
            
            statement.execute();
    }
    
    public ArrayList<Pedido> selectAll() throws SQLException{
        
            String sql = "select * from pedido" ;
            PreparedStatement statement = connection.prepareStatement(sql);
            
            return pesquisa(statement);
    }
    
    private ArrayList<Pedido> pesquisa(PreparedStatement statement) throws SQLException {
        ArrayList<Pedido> pedidos = new ArrayList<>();
        
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        
        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String  descricao = resultSet.getString("descricao");
            float valor = resultSet.getFloat("valor");
            int categoria_id = resultSet.getInt("categoria_id");
            
            Usuario usuario = new Usuario(categoria_id);
            
            Pedido pedidoDadosBanco = new Pedido(id, descricao, valor, usuario);
            pedidos.add(pedidoDadosBanco);
        }
        return pedidos;
    }
    
    public ArrayList<Pedido> selectID(Pedido pedido) throws SQLException{
        //select * from pedido p inner join usuario u on u.id = p.categoria_id    
        
            String sql = "select * from pedido where categoria_id = ?" ;
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, pedido.getUsuario().getId());
                
            ArrayList<Pedido> pedidos = pesquisa(statement);
            return pedidos;

    }
    
    public boolean existeNoBancoPedidoID(Pedido pedido) throws SQLException {
        String sql = "select * from pedido p inner join usuario u on u.id = ?";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setInt(1, pedido.getUsuario().getId());
        
        statement.execute();
        
        ResultSet resultSet = statement.getResultSet();
        
        return resultSet.next();
    }
    

}
