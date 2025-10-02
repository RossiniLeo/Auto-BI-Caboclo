package Service;

import DAO.ClienteDAO;
import Model.Cliente;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ClienteService {
    private static ClienteDAO clienteDao = new ClienteDAO();

    private static final String CSV_HEADER = "CGCENT;TIPOFJ;CLIENTE;CODREDE;DESCRICAO;FANTASIA;CODCLI;DTULTALTER;IEENT;DTCADASTRO;CODATV1;RAMO;DTULTCOMP;ESTENT;CODFILIALNF;TELCELENT;PREDIOPROPRIO;CODCIDADE;CODPRACA;PRACA;EMAIL;ENDRENT;NUMEROENT;BAIRROENT;MUNICENT;CEPENT;OBSERVACAO;BLOQUEIO;DTBLOQ;CODUSUR1;CODUSUR2;MOTIVOEXCLUSAO;MOTIVOBLOQ;";

    private static final LocalDateTime now = LocalDateTime.now();
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final String timestamp = now.format(formatter);

    private static final String directoryPath = "C:\\Users\\aplicacoes\\Downloads\\Auto-BI-Caboclo-main\\CSV\\";
    private static final String baseFileName = "Cliente_";
    private static final String fileExtension = ".csv";
    private static final String fileName = baseFileName + timestamp + fileExtension;
    private static final String fullPath = directoryPath + fileName;

    public List<Cliente> listarClientes() throws SQLException {
        return clienteDao.ListarCliente();
    }

    public static void generarCSV(List<Cliente> clientes){
        StringBuilder csvContent = new StringBuilder();
        csvContent.append(CSV_HEADER);
        csvContent.append("\n");

        for (Cliente cliente : clientes) {
            csvContent.append(cliente.getCGCENT()).append(";")
                    .append(cliente.getTipoFJ()).append(";")
                    .append(cliente.getCliente()).append(";")
                    .append(cliente.getCodRede() != 0 ? cliente.getCodRede() : "").append(";")
                    .append(cliente.getDescricao() != null ? cliente.getDescricao() : "").append(";")
                    .append(cliente.getFantasia() != null ? cliente.getFantasia() : "").append(";")
                    .append(cliente.getCodCliente()).append(";")
                    .append(cliente.getDataUltAlter() != null ? cliente.getDataUltAlter() : "").append(";")
                    .append(cliente.getIEENT() != null ? cliente.getIEENT() : "").append(";")
                    .append(cliente.getDataCadastro() != null ? cliente.getDataCadastro() : "").append(";")
                    .append(cliente.getCodAtv1()).append(";")
                    .append(cliente.getRamo()).append(";")
                    .append(cliente.getDataUltComp() != null ? cliente.getDataUltComp() : "").append(";")
                    .append(cliente.getEstENT()).append(";")
                    .append(cliente.getCodFilialNF() != 0 ? cliente.getCodFilialNF() : "").append(";")
                    .append(cliente.getTelCelENT() != null ? cliente.getTelCelENT() : "").append(";")
                    .append(cliente.getPredioProprio() != null ? cliente.getPredioProprio() : "").append(";")
                    .append(cliente.getCodCidade() != 0 ? cliente.getCodCidade() : "").append(";")
                    .append(cliente.getCodPraca()).append(";")
                    .append(cliente.getPraca() != null ? cliente.getPraca() : "").append(";")
                    .append(cliente.getEmail() != null ? cliente.getEmail() : "").append(";")
                    .append(cliente.getEnderENT() != null ? cliente.getEnderENT() : "").append(";")
                    .append(cliente.getNumeroENT()).append(";")
                    .append(cliente.getBairroENT()).append(";")
                    .append(cliente.getMunicENT() != null ? cliente.getMunicENT() : "").append(";")
                    .append(cliente.getCEPENT()).append(";")
                    .append(cliente.getObservacao() != null ? cliente.getObservacao().replaceAll("[\\r\\n]+", " ") : "").append(";")
                    .append(cliente.getBloqueio() != null ? cliente.getBloqueio() : "").append(";")
                    .append(cliente.getDataBloq() != null ? cliente.getDataBloq() : "").append(";")
                    .append(cliente.getCodUsur1() != 0 ? cliente.getCodUsur1() : "").append(";")
                    .append(cliente.getCodUsur2() != 0 ? cliente.getCodUsur2() : "").append(";")
                    .append(cliente.getMotivoExclusao() != null ? cliente.getMotivoExclusao().replaceAll("[\\r\\n]+", " ") : "").append(";")
                    .append(cliente.getMotivoBloq() != null ? cliente.getMotivoBloq().replaceAll("[\\r\\n]+", " ") : "").append(";\n");
        }

        try (FileOutputStream fos = new FileOutputStream("./Clientes.csv");
             OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
             BufferedWriter writer = new BufferedWriter(osw)) {

            // Escreve BOM manualmente
            fos.write(0xEF);
            fos.write(0xBB);
            fos.write(0xBF);

            // Conteúdo do CSV
            writer.write(csvContent.toString());

            System.out.println(csvContent);
            System.out.println("Arquivo CSV exportado com sucesso para: " + fullPath);
        } catch (IOException e) {
            System.err.println("Erro ao exportar CSV: " + e.getMessage());
        }
    }
}
