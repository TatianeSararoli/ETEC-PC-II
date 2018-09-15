package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Alunos;

public class AlunosJdbcDAO {
	private Connection conn;
	
	public AlunosJdbcDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void salvar(Alunos c) throws SQLException {
		String sql = "insert into alunos (matricula, nome, endereco, bairro, cep, nr_curso) values ('"+c.getMatricula()+"','"+c.getNome()+"','"+c.getEndereco()+"','"+c.getBairro()+"','"+c.getCep()+"','"+c.getNr_curso()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close(); 
	}
	
	public void alterar(Alunos c) {
		String sql = "update alunos set nome='"+c.getNome()+"',endereco='"+c.getEndereco()+"',bairro='"+c.getBairro()+"',cep="+c.getCep()+",nr_curso="+c.getNr_curso()+";";
		System.out.println(sql);
		PreparedStatement prepareStatement;
		try {
			prepareStatement = this.conn.prepareStatement(sql);
			prepareStatement.executeUpdate();
            prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public List<Alunos> listar() {
		String sql = "select * from alunos";
		System.out.println(sql);
		List<Alunos> alunos = new ArrayList<Alunos>();
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while (rs.next()) {
				int matricula = rs.getInt("matricula");
				String nome = rs.getString("nome");
				String endereco = rs.getString("endereco");
				String bairro = rs.getString("bairro");
				int cep = rs.getInt("cep");
				int nr_curso = rs.getInt("nr_curso");
				Alunos aluno = new Alunos();
				aluno.setMatricula(matricula);
				aluno.setNome(nome);
				aluno.setEndereco(endereco);
				aluno.setBairro(bairro);
				aluno.setCep(cep);
				aluno.setNr_curso(nr_curso);
			}
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alunos;
	}
	
	public void excluir(Alunos aluno) throws SQLException {
		String sql = "delete from alunos where matricula =" +aluno.getMatricula();
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close(); 
	}

}
