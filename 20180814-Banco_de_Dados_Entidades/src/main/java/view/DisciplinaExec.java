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
	JLabel id_disciplina = new JLabel("SIGLA DISCIPL.: ");
	
	JTextField txtNome_disciplina = new JTextField();
	JLabel nome_disciplina = new JLabel("DISCIPLINA: ");
	
	JTextField txtCarga_horaria = new JTextField();
	JLabel carga_horaria = new JLabel("CARGA HORÁRIA: ");
	
	JButton btnSalvar = new JButton("Salvar");
	
	public DisciplinaExec() {
		super ("Cadastro de Disciplinas");
		
		Container paine = this.getContentPane();
		
		paine.add(id_disciplina);
		paine.add(txtId_disciplina);
		id_disciplina.setBounds(10, 15, 100, 30);
		txtId_disciplina.setBounds(125, 15, 225, 30);
		
		paine.add(nome_disciplina);
		paine.add(txtNome_disciplina);
		nome_disciplina.setBounds(10, 50, 100, 30);
		txtNome_disciplina.setBounds(125, 50, 225, 30);
		
		paine.add(carga_horaria);
		paine.add(txtCarga_horaria);
		carga_horaria.setBounds(10, 85, 100, 30);
		txtCarga_horaria.setBounds(125, 85, 225, 30);
		
		paine.add(btnSalvar);
		btnSalvar.setBounds(250, 250, 130, 30);
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
		
		this.setLayout(null);
		this.setVisible(true);
		this.setSize(600, 330);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		DisciplinaExec disciplinasexec = new DisciplinaExec();

	}

}
