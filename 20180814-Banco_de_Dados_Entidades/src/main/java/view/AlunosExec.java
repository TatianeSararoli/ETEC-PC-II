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
	
	public AlunosExec() {
		super ("Cadastro Alunos");
		
		Container paine = this.getContentPane();
		
		paine.add(nome);
		paine.add(txtNome);
		nome.setBounds(10, 15, 70, 30);
		txtNome.setBounds(90, 15, 225, 30);
		
		paine.add(end);
		paine.add(txtEnd);
		end.setBounds(10, 50, 70, 30);
		txtEnd.setBounds(90, 50, 225, 30);
		
		paine.add(bairro);
		paine.add(txtBairro);
		bairro.setBounds(10, 85, 70, 30);
		txtBairro.setBounds(90, 85, 225, 30);
		
		paine.add(cep);
		paine.add(txtCep);
		cep.setBounds(10, 120, 70, 30);
		txtCep.setBounds(90, 120, 225, 30);
		
		paine.add(nr_curso);
		paine.add(txtNr_curso);
		nr_curso.setBounds(10, 155, 70, 30);
		txtNr_curso.setBounds(90, 155, 225, 30);
		
		paine.add(btnSalvar);
		btnSalvar.setBounds(250, 250, 130, 30);
		btnSalvar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
				Alunos alunos = new Alunos();
				alunos.setNome(txtNome.getText());
				alunos.setEndereco(txtEnd.getText());
				alunos.setBairro(txtBairro.getText());
				
				Connection connection = JdbUtil.getConnection();
				AlunosJdbcDAO alunosJdbcDao = new AlunosJdbcDAO(connection);
				
				alunosJdbcDao.salvar(alunos);
				
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
		AlunosExec alunosexec = new AlunosExec();

	}

}
