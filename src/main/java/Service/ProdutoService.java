package Service;

import DAO.ProdutoDAO;
import Model.Produto;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ProdutoService {
    private static ProdutoDAO  produtoDAO = new ProdutoDAO();

    private static final String CSV_HEADER = "CODPROD;DESCRICAO;CODFORNEC;FORNECEDOR;CODEPTO;DESCRICAODPTO;CODSEC;DESCRICAOSEC;CODMARCA;MARCA;CODCATEGORIA;CATEGORIA;EMBALAGEM;PESOLIQ;PESOBRUTO;NBM;CODAUXILIAR;CODAUXILIAR2;CODFAB;OBS2;DTEXCLUSAO;DTULTALTER;DTCADASTRO;";

    private static final LocalDateTime now = LocalDateTime.now();
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final String timestamp = now.format(formatter);

    private static final String directoryPath = "C:\\Users\\aplicacoes\\Downloads\\Auto-BI-Caboclo-main\\CSV\\";
    private static final String baseFileName = "Produto_";
    private static final String fileExtension = ".csv";
    private static final String fileName = baseFileName + timestamp + fileExtension;
    private static final String fullPath = directoryPath + fileName;

    public List<Produto> listarProdutos() throws SQLException {
        return produtoDAO.listarProdutos();
    }

    public static void generateCSV(List<Produto> produtos) {
        StringBuilder csvContent = new StringBuilder();
        csvContent.append(CSV_HEADER);
        csvContent.append("\n");

        for (Produto produto : produtos) {
            csvContent.append(produto.getCodProduto()).append(";")
                    .append(produto.getDescricao()).append(";")
                    .append(produto.getCodFornecedor()).append(";")
                    .append(produto.getFornecedor()).append(";")
                    .append(produto.getCoDepto()).append(";")
                    .append(produto.getDescricao_1()).append(";")
                    .append(produto.getCodSec()).append(";")
                    .append(produto.getDescricao_2()).append(";")
                    .append(produto.getCodMarca() != 0 ? produto.getCodMarca() : "").append(";")
                    .append(produto.getMarca() != null ? produto.getMarca() : "").append(";")
                    .append(produto.getCodCategoria()).append(";")
                    .append(produto.getCategoria()).append(";")
                    .append(produto.getEmbalagem()).append(";")
                    .append(produto.getPesoLiq()).append(";")
                    .append(produto.getPesoBruto()).append(";")
                    .append(produto.getNBM()).append(";")
                    .append(produto.getCodAuxiliar().equals(0) ? "" : produto.getCodAuxiliar()).append(";")
                    .append(produto.getCodAuxiliar2().equals(0) ? "" : produto.getCodAuxiliar2()).append(";")
                    .append(produto.getCodFab() != null ? produto.getCodFab() : "").append(";")
                    .append(produto.getOBS2() != null ? produto.getOBS2() : "").append(";")
                    .append(produto.getDataExclusao() != null ? produto.getDataExclusao() : "").append(";")
                    .append(produto.getDataUltAlter()).append(";")
                    .append(produto.getDataCadastro()).append(";\n");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("./Produto.csv"))) {
            writer.write(csvContent.toString());
            System.out.println(csvContent);
            System.out.println("Arquivo CSV exportado com sucesso para: " + fullPath);
        } catch (IOException e) {
            System.err.println("Erro ao exportar CSV: " + e.getMessage());
        }
    }
}
