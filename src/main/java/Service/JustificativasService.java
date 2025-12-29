package Service;

import Model.Justificativas;
import DAO.JustificativasDAO;

import java.io.File;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class JustificativasService {
    private static JustificativasDAO JustificativasDAO = new JustificativasDAO();

    private static final String CSV_HEADER = "COD_VENDEDOR;NOME_VENDEDOR;COD_CLIENTE;NOME_CLIENTE;DATA;JUSTIFICATIVA;TIPO;";

    private static final LocalDateTime now = LocalDateTime.now();
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy.MM");
    private static final String timestamp = now.format(formatter);

    private static final String directoryPath = "C:\\Users\\aplicacoes\\Dropbox\\Vendas - Caboclo\\3_Visitas_Realizadas\\";
    private static final String baseFileName = "1_caboclo_visitas - ";
    private static final String fileExtension = ".csv";
    private static final String fileName = baseFileName + timestamp + fileExtension;
    private static final String fullPath = directoryPath + fileName;

    public List<Justificativas> listarJustificativas() throws SQLException {
        return JustificativasDAO.listarJustificativas();
    }

    public static boolean generateCSV(List<Justificativas> ListaJustificativas){
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

        Path dir = Paths.get(directoryPath);

        if (Files.exists(dir) && Files.isDirectory(dir)) {
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
                for (Path arquivo : stream) {
                    if (Files.isRegularFile(arquivo)) {
                        Files.deleteIfExists(arquivo);
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
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
