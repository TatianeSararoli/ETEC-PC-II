package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.DisciplinaJdbcDAO;
import controller.JdbUtil;
import model.Disciplina;

public class DisciplinaExec extends JFrame {
	JTextField txtId_disciplina = new JTextField();
	JLabel id_disciplina = new JLabel("SIGLA DISCIPLINA: ");
	
	JTextField txtNome_disciplina = new JTextField();
	JLabel nome_disciplina = new JLabel("DISCIPLINA: ");
	
	JTextField txtCarga_horaria = new JTextField();
	JLabel carga_horaria = new JLabel("CARGA HORÁRIA: ");
	
	JButton btnSalvar = new JButton("Salvar");
	
	JButton btnAlterar = new JButton("Alterar");
	
	JButton btnListar = new JButton("Listar");
	
	JButton btnExcluir = new JButton("Excluir");
	
	JButton btnVoltar = new JButton("Voltar");
	
	public DisciplinaExec() {
		super ("Cadastro de Disciplinas");
		
		Container paine = this.getContentPane();
		
		paine.add(id_disciplina);
		paine.add(txtId_disciplina);
		id_disciplina.setBounds(10, 15, 120, 30);
		txtId_disciplina.setBounds(125, 15, 125, 30);
		
		paine.add(nome_disciplina);
		paine.add(txtNome_disciplina);
		nome_disciplina.setBounds(10, 50, 120, 30);
		txtNome_disciplina.setBounds(125, 50, 450, 30);
		
		paine.add(carga_horaria);
		paine.add(txtCarga_horaria);
		carga_horaria.setBounds(10, 85, 120, 30);
		txtCarga_horaria.setBounds(125, 85, 125, 30);
		
		paine.add(btnSalvar);
		btnSalvar.setBounds(10, 250, 100, 30);
		btnSalvar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
				Disciplina disciplina = new Disciplina();
				disciplina.setId_disciplina(txtId_disciplina.getText());
				disciplina.setNome_disciplina(txtNome_disciplina.getText());
				disciplina.setCarga_horaria(Integer.parseInt(txtCarga_horaria.getText()));
								
				Connection connection = JdbUtil.getConnection();
				DisciplinaJdbcDAO disciplinaJdbcDao = new DisciplinaJdbcDAO(connection);
				
				disciplinaJdbcDao.salvar(disciplina);
				
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
				Disciplina disciplina = new Disciplina();
				
				Connection connection = JdbUtil.getConnection();
				DisciplinaJdbcDAO disciplinaJdbcDao = new DisciplinaJdbcDAO(connection);
				
				disciplinaJdbcDao.salvar(disciplina);
				
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
				DisciplinaJdbcDAO disciplinaJdbcDao = new DisciplinaJdbcDAO(connection);
				
				System.out.print(disciplinaJdbcDao.listar());
				
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
				Disciplina disciplina = new Disciplina();
								
				Connection connection = JdbUtil.getConnection();
				DisciplinaJdbcDAO disciplinaJdbcDao = new DisciplinaJdbcDAO(connection);
				
				disciplinaJdbcDao.excluir(disciplina);
				
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
		
		this.setLayout(null);
		this.setVisible(true);
		this.setSize(600, 630);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		DisciplinaExec disciplinasexec = new DisciplinaExec();

	}

}
