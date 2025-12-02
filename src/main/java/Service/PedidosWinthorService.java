package Service;

import Model.PedidosWinthor;
import DAO.PedidosWinthorDAO;

import java.io.File;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PedidosWinthorService {
    private static PedidosWinthorDAO pedidosWinthorDAO = new PedidosWinthorDAO();

    private static final String CSV_HEADER = "NUMPED;NUMPEDRCA;CODUSUR;NOME;CGCCLI;CODCLI;CLIENTE;DTFECHAMENTOPEDRCA;DTINCLUSAO;DTENTREGA;CODFILIAL;CODCOB;CODPLPAG;CONDVENDA;ORIGEMPED;OBS1;POSICAO_ATUAL;VLR_PEDIDO;";

    private static final LocalDateTime now = LocalDateTime.now();
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy.MM.dd");
    private static final String currentDay = now.format(formatter);
    private static final String firstDay = now.withDayOfMonth(1).format(formatter);
    private static final String timestamp = firstDay + "_a_" + currentDay;

    private static final String directoryPath = "C:\\Users\\aplicacoes\\Dropbox\\Vendas - Caboclo\\2_Pedidos_Whintor\\";
    private static final String baseFileName = "1_caboclo_pedidos - ";
    private static final String fileExtension = ".csv";
    private static final String fileName = baseFileName + timestamp + fileExtension;
    private static final String fullPath = directoryPath + fileName;

    public List<PedidosWinthor> listarPedidosWinthor() throws SQLException {
        return  pedidosWinthorDAO.listarPedidosWinthor();
    }

    public static boolean generateCSV(List<PedidosWinthor> listaPedidosWinthor) {
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
