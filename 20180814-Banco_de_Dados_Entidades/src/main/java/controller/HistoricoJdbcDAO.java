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
	
	public HistoricoJdbcDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void salvar(Historico c) throws SQLException {
		String sql = "insert into historico (nome, endereco, bairro, cep) values ('"+c.getNome()+"','"+c.getEndereco()+"','"+c.getBairro()+"','"+c.getCep()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close(); 
	}
	
	public void alterar(Historico c) {
		String sql = "update historico set nome='"+c.getNome()+"',endereco='"+c.getEndereco()+"',bairro='"+c.getBairro()+"';";
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
	
	public List<Historico> listar() {
		String sql = "select * from historico";
		System.out.println(sql);
		List<Historico> historico = new ArrayList<Historico>();
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while (rs.next()) {
				String nome = rs.getString("nome");
				String endereco = rs.getString("endereco");
				String bairro = rs.getString("bairro");
				int cep = rs.getInt("cep"); 
				Historico histor = new Historico();
				histor.setNome(nome);
				histor.setEndereco(endereco);
				histor.setBairro(bairro);
				histor.setCep(cep);
			}
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Historico;
	}
	
	public void excluir(int id) throws SQLException {
		String sql = "delete from historico where id =" +id;
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close(); 
	}

}
