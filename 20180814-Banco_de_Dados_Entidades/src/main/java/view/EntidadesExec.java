package view;

import java.sql.Connection;

import controller.AlunosJdbcDAO;
import controller.JdbUtil;
import model.Alunos;

public class EntidadesExec {

	public static void main(String[] args) {
		Alunos alunos = new Alunos();
		try {
			
			alunos.setNome("Tatiane");
			alunos.setEndereco("Av. Águia de Haia");
			alunos.setBairro("Ponte Rasa");
			alunos.setCep(99999999);
			
			Connection connection = JdbUtil.getConnection();
			AlunosJdbcDAO alunosJdbcDao = new AlunosJdbcDAO(connection);
			
			//alunosJdbcDao.salvar(alunos);
			//alunosJdbcDao.alterar(alunos);
			//alunosJdbcDao.listar();
			alunosJdbcDao.excluir(2);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
