package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class EntidadesExec extends JFrame {
	
	JLabel acesso = new JLabel("Escolha uma das opções de acesso: ");
	
	JButton btnAlunos = new JButton("ALUNO");
	JButton btnCurso = new JButton("CURSO");
	JButton btnDisciplina = new JButton("DISCIPLINA");
	JButton btnHistorico = new JButton("HISTÓRICO");
	
	public EntidadesExec() {
		super ("OPÇÕES");
		
		Container paine = this.getContentPane();
		
		paine.add(acesso);
		acesso.setBounds(150, 15, 500, 30);
		
		paine.add(btnAlunos);
		btnAlunos.setBounds(200, 85, 100, 30);
		btnAlunos.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
								
				AlunosExec alunosExec = new AlunosExec();
				
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		
		paine.add(btnCurso);
		btnCurso.setBounds(200, 120, 100, 30);
		btnCurso.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
								
				CursoExec cursoExec = new CursoExec();
				
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		
		paine.add(btnDisciplina);
		btnDisciplina.setBounds(200, 155, 100, 30);
		btnDisciplina.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
								
					DisciplinaExec disciplinaExec = new DisciplinaExec();
				
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		
		paine.add(btnHistorico);
		btnHistorico.setBounds(200, 190, 100, 30);
		btnHistorico.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
								
				HistoricoExec historicoExec = new HistoricoExec();
				
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		
		this.setLayout(null);
		this.setVisible(true);
		this.setSize(500, 330);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		EntidadesExec entidadesexec = new EntidadesExec();

	}

}
