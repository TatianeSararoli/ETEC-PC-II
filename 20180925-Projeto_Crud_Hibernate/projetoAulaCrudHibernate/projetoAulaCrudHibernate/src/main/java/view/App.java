package view;

import controller.ClienteJpaDAO;
import model.Cliente;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
    	Cliente cliente = new Cliente();
        cliente.setCpf("999.999.999-99");
        cliente.setIdCliente(1);
        cliente.setNome("Tatiane Sararoli");
        cliente.setRg("99.999.999-9");
        ClienteJpaDAO.getInstance().merge(cliente);
        System.out.println("Objetos salvo com sucesso!!!");
    }
}
