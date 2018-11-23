package relatorio;

import java.util.List;

import model.Cliente;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class ClientesRelat {
	private String path; // Caminho base

	private String pathToReportPackage; // Caminho para o package onde estão armazenados os relatorios Jarper

	// Recupera os caminhos para que a classe possa encontrar os relatórios
	public ClientesRelat() {
		this.path = this.getClass().getClassLoader().getResource("").getPath();
		this.pathToReportPackage = this.path + "report/";
		System.out.println(path);
	}

	// Imprime/gera uma lista de Clientes
	public void imprimir(List<Cliente> clientes) throws Exception {
		JasperReport report = JasperCompileManager.compileReport(this.getPathToReportPackage() + "Clientes.jrxml");

		JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(clientes));

		JasperExportManager.exportReportToPdfFile(print, "c:/Relatorio_de_Clientes.pdf");
	}

	public String getPathToReportPackage() {
		return this.pathToReportPackage;
	}

	public String getPath() {
		return this.path;
	}

}
