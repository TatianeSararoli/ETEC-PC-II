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
		String sql = "insert into historico (matricula, id_disciplina, ano, semestre, nota, frequencia) values ('"+c.getMatricula()+"','"+c.getId_disciplina()+"','"+c.getAno()+"','"+c.getSemestre()+"','"+c.getNota()+"','"+c.getFrequencia()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close(); 
	}
	
	public void alterar(Historico c) {
		String sql = "update historico set matricula='"+c.getMatricula()+"',id_disciplina='"+c.getId_disciplina()+"',ano='"+c.getAno()+"',semestre='"+c.getSemestre()+"',nota='"+c.getNota()+"',frequencia='"+c.getFrequencia()+"';";
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
				int matricula = rs.getInt("matricula");
				String x = rs.getString("id_disciplina");
				char id_disciplina = x.charAt(0);
				int ano = rs.getInt("ano");
				int semestre = rs.getInt("semestre");
				double nota = rs.getDouble("nota");
				int frequencia = rs.getInt("frequencia");
				Historico histor = new Historico();
				histor.setMatricula(matricula);
				histor.setId_disciplina(id_disciplina);
				histor.setAno(ano);
				histor.setSemestre(semestre);
				histor.setNota(nota);
				histor.setFrequencia(frequencia);
			}
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return historico;
	}
	
	public void excluir(int id) throws SQLException {
		String sql = "delete from historico where id =" +id;
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close(); 
	}

}
