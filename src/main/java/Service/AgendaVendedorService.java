package Service;

import DAO.AgendaVendedorDAO;
import Model.AgendaVendedor;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AgendaVendedorService {
    private static AgendaVendedorDAO  agendaVendedorDAO = new AgendaVendedorDAO();

    private static final String CSV_HEADER = "CODCLI;CLIENTE;CGCENT;CODREDE;REDE;CODPRACA;CODATV1;RAMO;ENDERENT;NUMEROENT;CEPENT;BAIRROENT;MUNICENT;ESTENT;TELENT;BLOQUEIO;FORGA_PG;CODPLPAG;DTBLOQ;DTULTCOMP;CODRCA;VENDEDOR1;CODSUPER1;VEND_VISITA;VEND_DIASEMANA;VEND_PERIO;VEND_SEQUENCIA;";

    private static final LocalDateTime now = LocalDateTime.now();
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy.MM.dd");
    private static final String currentDay = now.format(formatter);
    private static final String firstDay = now.withDayOfMonth(1).format(formatter);
    private static final String timestamp = firstDay + "_a_" + currentDay;

    private static final String directoryPath = "C:\\Users\\aplicacoes\\Dropbox\\Vendas - Caboclo\\1_Agenda_Vendedor\\";
    private static final String baseFileName = "1_caboclo_agenda_vendedor - ";
    private static final String fileExtension = ".csv";
    private static final String fileName = baseFileName + timestamp + fileExtension;
    private static final String fullPath = directoryPath + fileName;

    public List<AgendaVendedor> listarAgendaVendedores() throws SQLException {
        return agendaVendedorDAO.listarAgendaVendedores();
    }

    public static boolean generateCSV(List<AgendaVendedor> agendaVendedores) {
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
