package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.AlunosJdbcDAO;
import controller.JdbUtil;
import model.Alunos;

public class AlunosExec extends JFrame {	
	JTextField txtMatricula = new JTextField();
	JLabel matricula = new JLabel("MATRÍCULA: ");
	
	JTextField txtNome = new JTextField();
	JLabel nome = new JLabel("NOME: ");
	
	JTextField txtEnd = new JTextField();
	JLabel end = new JLabel("ENDEREÇO: ");
	
	JTextField txtBairro = new JTextField();
	JLabel bairro = new JLabel("BAIRRO: ");
	
	JTextField txtCep = new JTextField();
	JLabel cep = new JLabel("CEP: ");
	
	JTextField txtNr_curso = new JTextField();
	JLabel nr_curso = new JLabel("Nº DO CURSO: ");

	JButton btnSalvar = new JButton("Salvar");
	
	JButton btnAlterar = new JButton("Alterar");
	
	JButton btnListar = new JButton("Listar");
	
	JButton btnExcluir = new JButton("Excluir");
	
	JButton btnVoltar = new JButton("Voltar");
	
	public AlunosExec() {
		super ("Cadastro de Alunos");
		
		Container paine = this.getContentPane();
		
		paine.add(matricula);
		paine.add(txtMatricula);
		matricula.setBounds(10, 15, 100, 30);
		txtMatricula.setBounds(125, 15, 125, 30);
		
		paine.add(nome);
		paine.add(txtNome);
		nome.setBounds(10, 50, 100, 30);
		txtNome.setBounds(125, 50, 450, 30);
		
		paine.add(end);
		paine.add(txtEnd);
		end.setBounds(10, 85, 100, 30);
		txtEnd.setBounds(125, 85, 450, 30);
		
		paine.add(bairro);
		paine.add(txtBairro);
		bairro.setBounds(10, 120, 100, 30);
		txtBairro.setBounds(125, 120, 225, 30);
		
		paine.add(cep);
		paine.add(txtCep);
		cep.setBounds(10, 155, 100, 30);
		txtCep.setBounds(125, 155, 125, 30);
		
		paine.add(nr_curso);
		paine.add(txtNr_curso);
		nr_curso.setBounds(10, 190, 100, 30);
		txtNr_curso.setBounds(125, 190, 125, 30);
		
		paine.add(btnSalvar);
		btnSalvar.setBounds(10, 250, 100, 30);
		btnSalvar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
				Alunos alunos = new Alunos();
				alunos.setMatricula(Integer.parseInt(txtMatricula.getText()));
				alunos.setNome(txtNome.getText());
				alunos.setEndereco(txtEnd.getText());
				alunos.setBairro(txtBairro.getText());
				alunos.setCep(Integer.parseInt(txtCep.getText()));
				alunos.setNr_curso(Integer.parseInt(txtNr_curso.getText()));
				
				Connection connection = JdbUtil.getConnection();
				AlunosJdbcDAO alunosJdbcDao = new AlunosJdbcDAO(connection);
				
				alunosJdbcDao.salvar(alunos);
				
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
				Alunos alunos = new Alunos();
								
				Connection connection = JdbUtil.getConnection();
				AlunosJdbcDAO alunosJdbcDao = new AlunosJdbcDAO(connection);
				
				alunosJdbcDao.alterar(alunos);
				
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
				AlunosJdbcDAO alunosJdbcDao = new AlunosJdbcDAO(connection);
				
				System.out.print(alunosJdbcDao.listar());
				
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
				Alunos alunos = new Alunos();
								
				Connection connection = JdbUtil.getConnection();
				AlunosJdbcDAO alunosJdbcDao = new AlunosJdbcDAO(connection);
				
				alunosJdbcDao.excluir(alunos);
				
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
		AlunosExec alunosexec = new AlunosExec();

	}

}
