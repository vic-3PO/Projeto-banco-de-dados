package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Entrega {
	
	private int id;
	private Cliente cliente;
	private float valor;
	private Date data;
	private String observacao; 
	
	public Entrega(int id, Cliente cliente, float valor, String data) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.valor = valor;
		try {
			this.data = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
			
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
  

 public String imprime() {
       return "Entrega [id=" + id + ", cliente=" + cliente.imprime() + ", valor=" + valor + ", data=" + data + ", observacao=" + observacao + "]";
    }
}
