package model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {
	@OneToMany (mappedBy = "cliente",
				targetEntity = Pedido.class,
				cascade = CascadeType.ALL)
	private Collection pedido;
	
	@Id
    private int idCliente;
    @Column
    private String nome;
    @Column
    private String cpf;
    @Column
    private String rg;
    
    public int getIdCliente() {
              return idCliente;
    }
    public void setIdCliente(int idCliente) {
              this.idCliente = idCliente;
    }
    public String getNome() {
              return nome;
    }
    public void setNome(String nome) {
              this.nome = nome;
    }
    public String getCpf() {
              return cpf;
    }
    public void setCpf(String cpf) {
              this.cpf = cpf;
    }
    public String getRg() {
              return rg;
    }
    public void setRg(String rg) {
              this.rg = rg;
    }

}
