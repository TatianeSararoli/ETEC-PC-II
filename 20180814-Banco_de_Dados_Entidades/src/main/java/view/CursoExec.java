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
	JTextField txtNr_curso = new JTextField();
	JLabel nr_curso = new JLabel("Nº DO CURSO: ");
	
	JTextField txtNome_curso = new JTextField();
	JLabel nome_curso = new JLabel("CURSO: ");

	JButton btnSalvar = new JButton("Salvar");
	
	JButton btnAlterar = new JButton("Alterar");
	
	JButton btnListar = new JButton("Listar");
	
	JButton btnExcluir = new JButton("Excluir");
	
	JButton btnVoltar = new JButton("Voltar");
	
	public CursoExec() {
		super ("Cadastro de Cursos");
		
		Container paine = this.getContentPane();
		
		paine.add(nr_curso);
		paine.add(txtNr_curso);
		nr_curso.setBounds(10, 15, 100, 30);
		txtNr_curso.setBounds(125, 15, 125, 30);
		
		paine.add(nome_curso);
		paine.add(txtNome_curso);
		nome_curso.setBounds(10, 50, 100, 30);
		txtNome_curso.setBounds(125, 50, 450, 30);
		
		paine.add(btnSalvar);
		btnSalvar.setBounds(10, 250, 100, 30);
		btnSalvar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
				Curso curso = new Curso();
				curso.setNr_curso(Integer.parseInt(txtNr_curso.getText()));
				curso.setNome_curso(txtNome_curso.getText());
				
				Connection connection = JdbUtil.getConnection();
				CursoJdbcDAO cursoJdbcDao = new CursoJdbcDAO(connection);
				
				cursoJdbcDao.salvar(curso);
				
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		
		paine.add(btnAlterar);
		btnAlterar.setBounds(120, 250, 100, 30);
		btnAlterar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
				Curso curso = new Curso();
				
				Connection connection = JdbUtil.getConnection();
				CursoJdbcDAO cursoJdbcDao = new CursoJdbcDAO(connection);
				
				cursoJdbcDao.alterar(curso);
				
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		
		paine.add(btnListar);
		btnListar.setBounds(230, 250, 100, 30);
		btnListar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
								
				Connection connection = JdbUtil.getConnection();
				CursoJdbcDAO cursoJdbcDao = new CursoJdbcDAO(connection);
				
				System.out.print(cursoJdbcDao.listar());
				
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		
		paine.add(btnExcluir);
		btnExcluir.setBounds(340, 250, 100, 30);
		btnExcluir.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
				Curso curso = new Curso();
								
				Connection connection = JdbUtil.getConnection();
				CursoJdbcDAO cursoJdbcDao = new CursoJdbcDAO(connection);
				
				cursoJdbcDao.excluir(curso);
				
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		
		paine.add(btnVoltar);
		btnVoltar.setBounds(470, 250, 100, 30);
		btnVoltar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
								
				EntidadesExec entidadesExec = new EntidadesExec();
				
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		
		paine.add(btnSalvar);
		btnSalvar.setBounds(10, 250, 100, 30);
		
		this.setLayout(null);
		this.setVisible(true);
		this.setSize(600, 630);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		CursoExec cursoexec = new CursoExec();

	}

}
