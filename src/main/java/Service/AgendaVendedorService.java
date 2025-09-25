package Service;

import DAO.AgendaVendedorDAO;
import Model.AgendaVendedor;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AgendaVendedorService {
    private static AgendaVendedorDAO  agendaVendedorDAO = new AgendaVendedorDAO();

    private static final String CSV_HEADER = "CODCLI;CLIENTE;CGCENT;CODREDE;REDE;CODPRACA;CODATV1;RAMO;ENDERENT;NUMEROENT;CEPENT;BAIRROENT;MUNICENT;ESTENT;TELENT;BLOQUEIO;FORGA_PG;CODPLPAG;DTBLOQ;DTULTCOMP;CODRCA;VENDEDOR1;CODSUPER1;VEND_VISITA;VEND_DIASEMANA;VEND_PERIO;VEND_SEQUENCIA;";

    private static final LocalDateTime now = LocalDateTime.now();
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final String timestamp = now.format(formatter);

    private static final String directoryPath = "";
    private static final String baseFileName = "AgendaVendedor_";
    private static final String fileExtension = ".csv";
    private static final String fileName = baseFileName + timestamp + fileExtension;
    private static final String fullPath = directoryPath + fileName;

    public List<AgendaVendedor> listarAgendaVendedores() throws SQLException {
        return agendaVendedorDAO.listarAgendaVendedores();
    }

    public static void generateCSV(List<AgendaVendedor> agendaVendedores) {
        StringBuilder csvContent = new StringBuilder();
        csvContent.append(CSV_HEADER);
        csvContent.append("\n");

        for (AgendaVendedor av : agendaVendedores) {
            csvContent.append(av.getCodCliente()).append(";")
                    .append(av.getCliente()).append(";")
                    .append(av.getCGCENT()).append(";")
                    .append(av.getCodRede()).append(";")
                    .append(av.getRede() != null ? av.getRede() : "").append(";")
                    .append(av.getCodPraca()).append(";")
                    .append(av.getCodATV1()).append(";")
                    .append(av.getRamo()).append(";")
                    .append(av.getEnderecoENT()).append(";")
                    .append(av.getNumero() != null ? av.getNumero() : "S/N").append(";")
                    .append(av.getCEPENT()).append(";")
                    .append(av.getBairroENT()).append(";")
                    .append(av.getMunicipioENT()).append(";")
                    .append(av.getEstadoENT()).append(";")
                    .append(av.getTelefoneENT() != null ? av.getTelefoneENT() : "").append(";")
                    .append(av.getBloqueio()).append(";")
                    .append(av.getFormaPG()).append(";")
                    .append(av.getCodPG()).append(";")
                    .append(av.getDataBloqueio() != null ? av.getDataBloqueio() : "").append(";")
                    .append(av.getDataUltimaCompra() != null ? av.getDataUltimaCompra() : "").append(";")
                    .append(av.getCodRCA()).append(";")
                    .append(av.getVendedor()).append(";")
                    .append(av.getCodSupervisor()).append(";")
                    .append(av.getDataProxVisita()).append(";")
                    .append(av.getDiaSemanaVisita()).append(";")
                    .append(av.getPeriodicidadeVisita()).append(";")
                    .append(av.getSequenciaVisita()).append(";\n");
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
