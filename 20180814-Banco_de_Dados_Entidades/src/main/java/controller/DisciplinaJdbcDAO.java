package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Disciplina;

public class DisciplinaJdbcDAO {
	private Connection conn;
	
	public DisciplinaJdbcDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void salvar(Disciplina c) throws SQLException {
		String sql = "insert into disciplina (nome_disciplina, carga_horaria) values ('"+c.getNome_disciplina()+"','"+c.getCarga_horaria()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close(); 
	}
	
	public void alterar(Disciplina c) {
		String sql = "update disciplina set nome_disciplina='"+c.getNome_disciplina()+"',carga_horaria='"+c.getCarga_horaria()+"';";
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
		String sql = "select * from disciplina";
		System.out.println(sql);
		List<Disciplina> disciplina = new ArrayList<Disciplina>();
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while (rs.next()) {
				String nome_disciplina = rs.getString("nome_disciplina");
				int carga_horaria = rs.getInt("carga_horaria"); 
				Disciplina discipl = new Disciplina();
				discipl.setNome_disciplina(nome_disciplina);
				discipl.setCarga_horaria(carga_horaria);
			}
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return disciplina;
	}
	
	public void excluir(int id_disciplina) throws SQLException {
		String sql = "delete from disciplina where id =" +id_disciplina;
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close(); 
	}

}
