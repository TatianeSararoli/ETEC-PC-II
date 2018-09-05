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
import model.Disciplina;



public class DisciplinaExec extends JFrame {
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
	
	public DisciplinaExec() {
		super ("Cadastro Alunos");
		
		Container paine = this.getContentPane();
		
		paine.add(matricula);
		paine.add(txtMatricula);
		matricula.setBounds(10, 15, 100, 30);
		txtMatricula.setBounds(125, 15, 225, 30);
		
		paine.add(nome);
		paine.add(txtNome);
		nome.setBounds(10, 50, 100, 30);
		txtNome.setBounds(125, 50, 225, 30);
		
		paine.add(end);
		paine.add(txtEnd);
		end.setBounds(10, 85, 100, 30);
		txtEnd.setBounds(125, 85, 225, 30);
		
		paine.add(bairro);
		paine.add(txtBairro);
		bairro.setBounds(10, 120, 100, 30);
		txtBairro.setBounds(125, 120, 225, 30);
		
		paine.add(cep);
		paine.add(txtCep);
		cep.setBounds(10, 155, 100, 30);
		txtCep.setBounds(125, 155, 225, 30);
		
		paine.add(nr_curso);
		paine.add(txtNr_curso);
		nr_curso.setBounds(10, 190, 100, 30);
		txtNr_curso.setBounds(125, 190, 225, 30);
		
		paine.add(btnSalvar);
		btnSalvar.setBounds(250, 250, 130, 30);
		btnSalvar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
				Disciplina disciplina = new Disciplina();
				disciplina.setMatricula(txtMatricula.getText());
				disciplina.setNome(txtNome.getText());
				disciplina.setEndereco(txtEnd.getText());
				disciplina.setBairro(txtBairro.getText());
				disciplina.setCep(txtCep.getText());
				disciplina.setNr_curso(txtNr_curso.getText());
				
				Connection connection = JdbUtil.getConnection();
				DisciplinaJdbcDAO disciplinaJdbcDao = new DisciplinaJdbcDAO(connection);
				
				disciplinaJdbcDao.salvar(disciplina);
				
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
		DisciplinaExec disciplinasexec = new DisciplinaExec();

	}

}
