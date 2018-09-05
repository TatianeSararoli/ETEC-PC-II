package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.CursoJdbcDAO;
import controller.JdbUtil;
import model.Curso;

public class CursoExec extends JFrame {
	JTextField txtNome_curso = new JTextField();
	JLabel nome_curso = new JLabel("NOME DO CURSO: ");

	JButton btnSalvar = new JButton("Salvar");
	
	public CursoExec() {
		super ("Cadastro Alunos");
		
		Container paine = this.getContentPane();
		
		paine.add(nome_curso);
		paine.add(txtNome_curso);
		nome_curso.setBounds(10, 50, 100, 30);
		txtNome_curso.setBounds(125, 50, 225, 30);
		
		paine.add(btnSalvar);
		btnSalvar.setBounds(250, 250, 130, 30);
		btnSalvar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
				Curso curso = new Curso();
				curso.setMatricula(txtMatricula.getText());
				curso.setNome(txtNome.getText());
				curso.setEndereco(txtEnd.getText());
				curso.setBairro(txtBairro.getText());
				curso.setCep(txtCep.getText());
				curso.setNr_curso(txtNr_curso.getText());
				
				Connection connection = JdbUtil.getConnection();
				CursoJdbcDAO cursoJdbcDao = new CursoJdbcDAO(connection);
				
				cursoJdbcDao.salvar(curso);
				
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		
		this.setLayout(null);
		this.setVisible(true);
		this.setSize(600, 330);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		CursoExec cursoexec = new CursoExec();

	}

}
