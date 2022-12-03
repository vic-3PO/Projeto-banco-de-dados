package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Pedido {

    public static boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
	
	private int id;
	private Date data_pedido;
	private float valor_pedido;
	private String descricao;
        private Usuario usuario;
	
	public Pedido(int id, String data_pedido, float valor_pedido, String descricao, Usuario usuario) {
		super();
		this.id = id;
		try {
			this.data_pedido = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(data_pedido);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.valor_pedido = valor_pedido;
		this.descricao = descricao;
                this.usuario = usuario;
	}

        public Pedido(String descricao, float valor_pedido, Usuario usuario) {
            this.valor_pedido = valor_pedido;
            this.descricao = descricao;
            this.usuario = usuario;
        }
        
        public Pedido(int id, String descricao, float valor_pedido, Usuario usuario) {
            this.id = id;
            this.valor_pedido = valor_pedido;
            this.descricao = descricao;
            this.usuario = usuario;
        }

        public Pedido(int id, String descricao, float valor_pedido) {
            this.id = id;
            this.valor_pedido = valor_pedido;
            this.descricao = descricao;
        }

        public Pedido(Usuario usuario) {
        this.usuario = usuario;
    }
        
        

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData_pedido() {
		return data_pedido;
	}

	public void setData_pedido(Date data_pedido) {
		this.data_pedido = data_pedido;
	}

	public float getValor_pedido() {
		return valor_pedido;
	}

	public void setValor_pedido(float valor_pedido) {
		this.valor_pedido = valor_pedido;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

        public Usuario getUsuario() {
            return usuario;
        }

        public void setUsuario(Usuario usuario) {
            this.usuario = usuario;
        }


   public String imprime() {
       return "Pedido [id do pedido=" + id + ", data do pedido=" + data_pedido + ", valor do pedido=" + valor_pedido + ", descricao=" + descricao+"]";
    }



}
