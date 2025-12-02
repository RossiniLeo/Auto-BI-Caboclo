package Service;

import DAO.VendasFaturamentoMesAtualDAO;
import Model.VendasFaturamentoMesAtual;

import java.io.File;
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
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy.MM.dd");
    private static final String currentDay = now.format(formatter);
    private static final String firstDay = now.withDayOfMonth(1).format(formatter);
    private static final String timestamp = firstDay + "_a_" + currentDay;

    private static final String directoryPath = "C:\\Users\\aplicacoes\\Dropbox\\Vendas - Caboclo\\4_Vendas_Faturamento_Mês_Atual\\";
    private static final String baseFileName = now.format(DateTimeFormatter.ofPattern("yyyy_MM")) + " - Caboclo_Vendas - ";
    private static final String fileExtension = ".csv";
    private static final String fileName = baseFileName + timestamp + fileExtension;
    private static final String fullPath = directoryPath + fileName;

    public List<VendasFaturamentoMesAtual> ListarVendasFaturamentoMesAtual() throws SQLException{
        return vendasFaturamentoMesAtualDAO.listarVendasFaturamentoMesAtual();
    }

    public static boolean generateCSV(List<VendasFaturamentoMesAtual> listaVendasFaturamentoMesAtual) {
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

        File file = new File(fullPath);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(csvContent.toString());
        } catch (IOException e) {
            System.err.println("Falha ao escrever no arquivo CSV:");
            e.printStackTrace();
            return false;
        }

        // 4. Confirma se o arquivo realmente existe e tem tamanho > 0
        if (file.exists() && file.length() > 0) {
            System.out.println("✔ Arquivo criado com sucesso: " + file.getAbsolutePath());
            return true;
        } else {
            System.err.println("❌ Erro: Arquivo não foi criado ou ficou vazio!");
            return false;
        }
    }
}
