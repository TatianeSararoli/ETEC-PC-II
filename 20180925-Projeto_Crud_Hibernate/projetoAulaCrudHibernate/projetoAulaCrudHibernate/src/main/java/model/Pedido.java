package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Pedido {
	@ManyToOne
	@JoinColumn(name = "idCliente")
	private Cliente cliente;
	
	@Id
    private int idPedido;
    @Id
    private int idCliente;
	@Column
    private String nomeDestinatario;
    @Column
    private String endDestinatario;
    @Column
    private String cidDestinatario;
    
    public int getIdPedido() {
              return idPedido;
    }
    public void setIdPedido(int idPedido) {
              this.idPedido = idPedido;
    }
    public int getIdCliente() {
        return idCliente;
	}
	public void setIdCliente(int idCliente) {
	        this.idCliente = idCliente;
	}
    public String getNomeDestinatario() {
              return nomeDestinatario;
    }
    public void setNomeDestinatario(String nomeDestinatario) {
              this.nomeDestinatario = nomeDestinatario;
    }
    public String getEndDestinatario() {
              return endDestinatario;
    }
    public void setEndDestinatario(String endDestinatario) {
              this.endDestinatario = endDestinatario;
    }
    public String getCidadeDestinatario() {
              return endDestinatario;
    }
    public void setCidDestinatario(String cidDestinatario) {
              this.cidDestinatario = cidDestinatario;
    }

}
