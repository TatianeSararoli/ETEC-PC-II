package view;

import org.hibernate.Session;

import controller.HibernateUtil;
import model.Alunos;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
        Alunos alunos = new Alunos();
    	alunos.setNome("Tatiane");
    	alunos.setEndereco("Av. Águia de Haia");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(alunos);
		session.getTransaction().commit();
    }
}
