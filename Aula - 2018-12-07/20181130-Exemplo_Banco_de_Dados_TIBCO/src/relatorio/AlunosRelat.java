package relatorio;

import java.util.List;

import model.Aluno;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class AlunosRelat {
	private String path; // Caminho base

	private String pathToReportPackage; // Caminho para o package onde estão armazenados os relatorios Jarper

	// Recupera os caminhos para que a classe possa encontrar os relatórios
	public AlunosRelat() {
		this.path = this.getClass().getClassLoader().getResource("").getPath();
		this.pathToReportPackage = this.path + "relatorio/";
		System.out.println(path);
	}

	// Imprime/gera uma lista de Alunos
	public void imprimir(List<Aluno> alunos) throws Exception {
		JasperReport report = JasperCompileManager.compileReport(this.getPathToReportPackage() + "Alunos.jrxml");

		JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(alunos));

		JasperExportManager.exportReportToPdfFile(print, "D:/Relatorio_de_Alunos.pdf");
	}

	public String getPathToReportPackage() {
		return this.pathToReportPackage;
	}

	public String getPath() {
		return this.path;
	}

}
