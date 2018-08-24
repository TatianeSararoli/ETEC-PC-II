package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Historico;

public class HistoricoJdbcDAO {
private Connection conn;
	
	public DisciplinaJdbcDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void salvar(Disciplina c) throws SQLException {
		String sql = "insert into alunos (nome, endereco, bairro, cep) values ('"+c.getNome()+"','"+c.getEndereco()+"','"+c.getBairro()+"','"+c.getCep()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close(); 
	}
	
	public void alterar(Disciplina c) {
		String sql = "update alunos set nome='"+c.getNome()+"',endereco='"+c.getEndereco()+"',bairro='"+c.getBairro()+"';";
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
	
	public List<Disciplina> listar() {
		String sql = "select * from alunos";
		System.out.println(sql);
		List<Disciplina> disciplina = new ArrayList<Disciplina>();
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while (rs.next()) {
				String nome = rs.getString("nome");
				String endereco = rs.getString("endereco");
				String bairro = rs.getString("bairro");
				int cep = rs.getInt("cep"); 
				Disciplina disciplina = new Disciplina();
				disciplina.setNome(nome);
				disciplina.setEndereco(endereco);
				disciplina.setBairro(bairro);
				disciplina.setCep(cep);
			}
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Disciplina;
	}
	
	public void excluir(int id) throws SQLException {
		String sql = "delete from alunos where id =" +id;
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close(); 
	}

}
