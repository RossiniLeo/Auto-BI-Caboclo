package Service;

import DAO.VendasFaturamentoMesAtualDAO;
import Model.VendasFaturamentoMesAtual;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class VendasFaturamentoMesAtualService {
    private static VendasFaturamentoMesAtualDAO vendasFaturamentoMesAtualDAO = new VendasFaturamentoMesAtualDAO();

    private static final String CSV_HEADER = "DRMOV;NUMNOTA;CODOPER;STATUS;CODCLI;CLIENTE;CGCENT;CODUSUR;NOME;CODSUPERVISOR;CODPROD;DESCRICAO;CODFORNEC;CODFISCAL;QT;PUNIT;VENDATOT;CUSTOREAL;CUSTOTOT;DEPTO;";

    private static final LocalDateTime now = LocalDateTime.now();
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final String timestamp = now.format(formatter);

    private static final String directoryPath = "";
    private static final String baseFileName = "VendasFaturamentoMesAtual_";
    private static final String fileExtension = ".csv";
    private static final String fileName = baseFileName + timestamp + fileExtension;
    private static final String fullPath = directoryPath + fileName;

    public List<VendasFaturamentoMesAtual> ListarVendasFaturamentoMesAtual() throws SQLException{
        return vendasFaturamentoMesAtualDAO.listarVendasFaturamentoMesAtual();
    }

    public static void generateCSV(List<VendasFaturamentoMesAtual> listaVendasFaturamentoMesAtual) {
        StringBuilder csvContent = new StringBuilder();
        csvContent.append(CSV_HEADER);
        csvContent.append("\n");

        for (VendasFaturamentoMesAtual vf : listaVendasFaturamentoMesAtual) {
            csvContent.append(vf.getDTMov()).append(";")
                    .append(vf.getNumNota()).append(";")
                    .append(vf.getCodOper()).append(";")
                    .append(vf.getStatus()).append(";")
                    .append(vf.getCodCli()).append(";")
                    .append(vf.getCliente()).append(";")
                    .append(vf.getCGCENT()).append(";")
                    .append(vf.getCodUsur()).append(";")
                    .append(vf.getNome()).append(";")
                    .append(vf.getCodSupervisor()).append(";")
                    .append(vf.getCodProd()).append(";")
                    .append(vf.getDescricao()).append(";")
                    .append(vf.getCodFornec()).append(";")
                    .append(vf.getCodFiscal()).append(";")
                    .append(vf.getQT()).append(";")
                    .append(vf.getPUNIT()).append(";")
                    .append(vf.getVendaTot()).append(";")
                    .append(vf.getCustoReal()).append(";")
                    .append(vf.getCustoTot()).append(";")
                    .append(vf.getDepto()).append(";\n");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fullPath))) {
            writer.write(csvContent.toString());
            System.out.println(csvContent);
            System.out.println("Arquivo CSV exportado com sucesso para: " + fullPath);
        } catch (IOException e) {
            System.err.println("Erro ao exportar CSV: " + e.getMessage());
        }
    }
}
