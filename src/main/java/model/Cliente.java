package model;

public class Cliente extends Pessoa {

	protected String endereco;
	protected String cep;
        private Pedido pedido;
	
	public Cliente(int id, String cpf, String telefone, String nome, char sexo, String dataNascimento, String email, String endereco, String cep, Pedido pedido) {
		super(id, cpf, telefone, nome, sexo, dataNascimento, email);
		this.endereco = endereco;
		this.cep = cep;
    this.pedido = pedido;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

  public String imprime() {
       return "Cliente [cpf=" + cpf + ", telefone=" + telefone + ", nome=" + nome + ", cep=" + cep + ", pedido=" + pedido.imprime() + "]";
    }

}
