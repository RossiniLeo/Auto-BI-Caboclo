package Service;

import Model.Justificativas;
import DAO.JustificativasDAO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class JustificativasService {
    private static JustificativasDAO JustificativasDAO = new JustificativasDAO();

    private static final String CSV_HEADER = "";

    private static final LocalDateTime now = LocalDateTime.now();
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final String timestamp = now.format(formatter);

    private static final String directoryPath = "";
    private static final String baseFileName = "Justificativas_";
    private static final String fileExtension = ".csv";
    private static final String fileName = baseFileName + timestamp + fileExtension;
    private static final String fullPath = directoryPath + fileName;

    public List<Justificativas> listarJustificativas() throws SQLException {
        return JustificativasDAO.listarJustificativas();
    }

    public static void generateCSV(List<Justificativas> ListaJustificativas){
        StringBuilder csvContent = new StringBuilder();
        csvContent.append(CSV_HEADER);
        csvContent.append("\n");

        for (Justificativas av : ListaJustificativas){
            csvContent.append(av.getCodUsur()).append(";")
                    .append(av.getVendedor()).append(";")
                    .append(av.getCodCli()).append(";")
                    .append(av.getCliente()).append(";")
                    .append(av.getData()).append(";")
                    .append(av.getJustificativa()).append(";")
                    .append(av.getTipo()).append(";\n");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fullPath))) {
            writer.write(csvContent.toString());
            System.out.println(csvContent);
            System.out.println("Arquivo CSV exportado com sucesso para: " + "Justificativas.csv");
        } catch (IOException e) {
            System.err.println("Erro ao exportar CSV: " + e.getMessage());
        }
    }
}
