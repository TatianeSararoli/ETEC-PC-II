package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Curso;

public class CursoJdbcDAO {
	private Connection conn;
	
	public CursoJdbcDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void salvar(Curso c) throws SQLException {
		String sql = "insert into curso (nr_curso, nome_curso) values ('"+c.getNr_curso()+"','"+c.getNome_curso()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close(); 
	}
	
	public void alterar(Curso c) {
		String sql = "update curso set nr_curso='"+c.getNr_curso()+"',nome_curso='"+c.getNome_curso()+"';";
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
	
	public List<Curso> listar() {
		String sql = "select * from curso";
		System.out.println(sql);
		List<Curso> curso = new ArrayList<Curso>();
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while (rs.next()) {
				int nr_curso = rs.getInt("nr_curso");
				String nome_curso = rs.getString("nome_curso");
				Curso curs = new Curso();
				curs.setNr_curso(nr_curso);
				curs.setNome_curso(nome_curso);
			}
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return curso;
	}
	
	public void excluir(int id) throws SQLException {
		String sql = "delete from alunos where id =" +id;
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close(); 
	}

}
