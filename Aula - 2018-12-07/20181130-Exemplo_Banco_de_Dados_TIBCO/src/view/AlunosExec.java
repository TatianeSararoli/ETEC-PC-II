package view;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import controller.AlunosJdbcDAO;
import controller.JdbUtil;
import model.Aluno;
import relatorio.AlunosRelat;

public class AlunosExec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			List<Aluno> listar = new ArrayList<Aluno>();
			
			Aluno Aluno1 = new Aluno();
			Aluno1.setNome("Tatiane");
			Aluno1.setEndereco("Av. Águia de Haia");
			Aluno1.setBairro("Ponte Rasa");
			Aluno1.setCep("99999-999");
			
			Aluno Aluno2 = new Aluno();
			Aluno2.setNome("Vinicius");
			Aluno2.setEndereco("Av. Águia de Haia");
			Aluno2.setBairro("Ponte Rasa");
			Aluno2.setCep("88888-888");
			
			Aluno Aluno3 = new Aluno();
			Aluno3.setNome("Teresa");
			Aluno3.setEndereco("Av. Águia de Haia");
			Aluno3.setBairro("Ponte Rasa");
			Aluno3.setCep("77777-777");
			
			listar.add(Aluno1);
			listar.add(Aluno2);
			listar.add(Aluno3);
			
			Connection connection = JdbUtil.getConnection();
			AlunosJdbcDAO alunosJdbcDao = new AlunosJdbcDAO(connection);
			
			alunosJdbcDao.salvar(Aluno1);
			alunosJdbcDao.salvar(Aluno2);
			alunosJdbcDao.salvar(Aluno3);
			//alunosJdbcDao.alterar(alunos);
			alunosJdbcDao.listar();
			//alunosJdbcDao.excluir(2);
			
			AlunosRelat relatorio = new AlunosRelat();
			relatorio.imprimir(listar);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
