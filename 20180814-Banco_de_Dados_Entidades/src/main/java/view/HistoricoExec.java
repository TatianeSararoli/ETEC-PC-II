package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.HistoricoJdbcDAO;
import controller.JdbUtil;
import model.Historico;

public class HistoricoExec extends JFrame {
	JTextField txtMatricula = new JTextField();
	JLabel matricula = new JLabel("MATRÍCULA: ");
	
	JTextField txtId_disciplina = new JTextField();
	JLabel id_disciplina = new JLabel("SIGLA DISCIPLINA: ");
	
	JTextField txtAno = new JTextField();
	JLabel ano = new JLabel("ANO: ");
	
	JTextField txtSemestre = new JTextField();
	JLabel semestre = new JLabel("SEMESTRE: ");
	
	JTextField txtNota = new JTextField();
	JLabel nota = new JLabel("NOTA: ");
	
	JTextField txtFrequencia = new JTextField();
	JLabel frequencia = new JLabel("FREQUÊNCIA: ");
	
	JButton btnSalvar = new JButton("Salvar");
	
	JButton btnAlterar = new JButton("Alterar");
	
	JButton btnListar = new JButton("Listar");
	
	JButton btnExcluir = new JButton("Excluir");
	
	JButton btnVoltar = new JButton("Voltar");
	
	public HistoricoExec() {
		super ("Cadastro de Históricos");
		
		Container paine = this.getContentPane();
		
		paine.add(matricula);
		paine.add(txtMatricula);
		matricula.setBounds(10, 15, 120, 30);
		txtMatricula.setBounds(125, 15, 125, 30);
		
		paine.add(id_disciplina);
		paine.add(txtId_disciplina);
		id_disciplina.setBounds(10, 50, 120, 30);
		txtId_disciplina.setBounds(125, 50, 125, 30);
		
		paine.add(ano);
		paine.add(txtAno);
		ano.setBounds(10, 85, 120, 30);
		txtAno.setBounds(125, 85, 125, 30);
		
		paine.add(semestre);
		paine.add(txtSemestre);
		semestre.setBounds(10, 120, 120, 30);
		txtSemestre.setBounds(125, 120, 125, 30);
		
		paine.add(nota);
		paine.add(txtNota);
		nota.setBounds(10, 155, 120, 30);
		txtNota.setBounds(125, 155, 125, 30);
		
		paine.add(frequencia);
		paine.add(txtFrequencia);
		frequencia.setBounds(10, 190, 120, 30);
		txtFrequencia.setBounds(125, 190, 125, 30);
		
		paine.add(btnSalvar);
		btnSalvar.setBounds(10, 250, 100, 30);
		btnSalvar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
				Historico historico = new Historico();
				historico.setMatricula(Integer.parseInt(txtMatricula.getText()));
				historico.setId_disciplina(txtId_disciplina.getText());
				historico.setAno(Integer.parseInt(txtAno.getText()));
				historico.setSemestre(Integer.parseInt(txtSemestre.getText()));
				historico.setNota(Double.parseDouble(txtNota.getText()));
				historico.setFrequencia(Integer.parseInt(txtFrequencia.getText()));
				
				Connection connection = JdbUtil.getConnection();
				HistoricoJdbcDAO historicoJdbcDao = new HistoricoJdbcDAO(connection);
				
				historicoJdbcDao.salvar(historico);
				
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
				Historico historico = new Historico();
				historico.setMatricula(Integer.parseInt(txtMatricula.getText()));
				historico.setId_disciplina(txtId_disciplina.getText());
				historico.setAno(Integer.parseInt(txtAno.getText()));
				historico.setSemestre(Integer.parseInt(txtSemestre.getText()));
				historico.setNota(Double.parseDouble(txtNota.getText()));
				historico.setFrequencia(Integer.parseInt(txtFrequencia.getText()));
				
				Connection connection = JdbUtil.getConnection();
				HistoricoJdbcDAO historicoJdbcDao = new HistoricoJdbcDAO(connection);
				
				historicoJdbcDao.salvar(historico);
				
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		
		paine.add(btnListar);
		btnListar.setBounds(230, 250, 100, 30);
		
		paine.add(btnExcluir);
		btnExcluir.setBounds(340, 250, 100, 30);
		
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
		this.setSize(600, 330);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		HistoricoExec historicoexec = new HistoricoExec();

	}

}
