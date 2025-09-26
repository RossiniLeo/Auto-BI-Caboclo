package Service;

import Model.PedidosWinthor;
import DAO.PedidosWinthorDAO;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class PedidosWinthorService {
    private static PedidosWinthorDAO pedidosWinthorDAO = new PedidosWinthorDAO();

    private static final String CSV_HEADER = "NUMPED;NUMPEDRCA;CODUSUR;NOME;CGCCLI;CODCLI;CLIENTE;DTFECHAMENTOPEDRCA;DTINCLUSAO;DTENTREGA;CODFILIAL;CODCOB;CODPLPAG;CONDVENDA;ORIGEMPED;OBS1;POSICAO_ATUAL;VLR_PEDIDO;";

    private static final LocalDateTime now = LocalDateTime.now();
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final String timestamp = now.format(formatter);

    private static final String directoryPath = "C:\\Users\\aplicacoes\\Downloads\\Auto-BI-Caboclo-main\\CSV\\";
    private static final String baseFileName = "PedidosWinthor_";
    private static final String fileExtension = ".csv";
    private static final String fileName = baseFileName + timestamp + fileExtension;
    private static final String fullPath = directoryPath + fileName;

    public List<PedidosWinthor> listarPedidosWinthor() throws SQLException {
        return  pedidosWinthorDAO.listarPedidosWinthor();
    }

    public static void generateCSV(List<PedidosWinthor> listaPedidosWinthor) {
        StringBuilder csvContent = new StringBuilder();
        csvContent.append(CSV_HEADER);
        csvContent.append("\n");

        for  (PedidosWinthor p : listaPedidosWinthor) {
            csvContent.append(p.getNumPedido() != 0 ? p.getNumPedido() : "").append(";")
                    .append(p.getNumPedidoRCA()).append(";")
                    .append(p.getCodUsur()).append(";")
                    .append(p.getNome()).append(";")
                    .append(p.getCGCCli()).append(";")
                    .append(p.getCodCli()).append(";")
                    .append(p.getCliente()).append(";")
                    .append(p.getDTFechamentoPedPalm()).append(";")
                    .append(p.getDTInclusao()).append(";")
                    .append(p.getDTEntrega() != null ? p.getDTEntrega() : "").append(";")
                    .append(p.getCodFilial()).append(";")
                    .append(p.getCodCob()).append(";")
                    .append(p.getCodPlPag()).append(";")
                    .append(p.getCondVenda()).append(";")
                    .append(p.getOrigemPed()).append(";")
                    .append(p.getOBS1() != null ? p.getOBS1() : "").append(";")
                    .append(p.getPosicaoAtual()).append(";")
                    .append(p.getVlrPedido()).append(";\n");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("PedidosWinthor.csv"))) {
            writer.write(csvContent.toString());
            System.out.println(csvContent);
            System.out.println("Arquivo CSV exportado com sucesso para: " + fullPath);
        } catch (IOException e) {
            System.err.println("Erro ao exportar CSV: " + e.getMessage());
        }
    }
}
