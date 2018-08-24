package model;

public class Historico {
	private int matricula;
	private char id_disciplina;
	private int ano;
	private int semestre;
	private double nota;
	private int frequencia;
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public char getId_disciplina() {
		return id_disciplina;
	}
	public void setId_disciplina(char id_disciplina) {
		this.id_disciplina = id_disciplina;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public int getSemestre() {
		return semestre;
	}
	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	public int getFrequencia() {
		return frequencia;
	}
	public void setFrequencia(int frequencia) {
		this.frequencia = frequencia;
	}

}
