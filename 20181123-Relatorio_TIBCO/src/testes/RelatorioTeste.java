package testes;

import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import relatorio.ClientesRelat;

public class RelatorioTeste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			List<Cliente> clientes = new ArrayList<Cliente>();
			
			Cliente Cliente1 = new Cliente();
			Cliente1.setNome("Tati");
			Cliente1.setEndereco("Rua Guaranis, Ipatinga");
			Cliente1.setComplemento("Sala 105");
			Cliente1.setTelefone("8888-5566");
			Cliente1.setUf("MG");
			
			Cliente Cliente2 = new Cliente();
			Cliente2.setNome("Vini");
			Cliente2.setEndereco("Av Uruguai, Belo Horizonte");
			Cliente2.setComplemento("3º Andar");
			Cliente2.setUf("MG");
			
			Cliente Cliente3 = new Cliente();
			Cliente3.setNome("Teresa");
			Cliente3.setEndereco("Rua Aricanduva, São Paulo");
			Cliente3.setComplemento("Sala 23");
			Cliente1.setTelefone("98523-1234");
			Cliente3.setUf("SP");
			
			
			clientes.add(Cliente1);
			clientes.add(Cliente2);
			clientes.add(Cliente3);
			
			
			ClientesRelat relatorio = new ClientesRelat();
			relatorio.imprimir(clientes);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}

	}

}
