package view;

import java.sql.Connection;

import controller.AlunosJdbcDAO;
import controller.JdbUtil;
import model.Alunos;

public class AlunosExec {

	public static void main(String[] args) {
		Alunos alunos = new Alunos();
		try {
			
			alunos.setNome("Tatiane");
			alunos.setEndereco("Av. Águia de Haia");
			alunos.setBairro("Jd. São Carlos");
			
			Connection connection = JdbUtil.getConnection();
			AlunosJdbcDAO alunosJdbcDao = new AlunosJdbcDAO(connection);
			
			alunosJdbcDao.salvar(alunos);
			//alunosJdbcDao.excluir(2);
			//alunosJdbcDao.alterar(alunos);
			//alunosJdbcDao.listar();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
