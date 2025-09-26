package Service;

import DAO.PedidosAFaturarDAO;
import Model.PedidosAFaturar;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PedidosAFaturarService {
    private static PedidosAFaturarDAO pedidosAFaturarDAO =  new PedidosAFaturarDAO();

    private static final String CSV_HEADER = "Filial;Data Emissão;Data Entrada; Data Cancelamento; Num Nota; Cod. Parceiro;Razao Social;CPF/CNPJ;Ramo;Data Pedido;Num Pedido;Cod. Vendedor;Vendedor;Cod. Supervisor;Supervisor;Cod. Produto;Cod. Fabrica;Cod. Barras;Descricao;Vl. Custo;Preço Tabela;Vl. Desconto;Preco Venda;Qtde;Tot. Preco Tabela;Total Venda;CFOP;Departamento;Secao;Categoria;Operação;Posicao;Peso Liquido Unitario;";

    private static final LocalDateTime now = LocalDateTime.now();
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final String timestamp = now.format(formatter);

    private static final String directoryPath = "C:\\Users\\aplicacoes\\Downloads\\Auto-BI-Caboclo-main\\CSV\\";
    private static final String baseFileName = "PedidosAFaturar_";
    private static final String fileExtension = ".csv";
    private static final String fileName = baseFileName + timestamp + fileExtension;
    private static final String fullPath = directoryPath + fileName;

    public List<PedidosAFaturar> listarPedidosAFaturar() throws SQLException {
        return pedidosAFaturarDAO.listarPedidosAFaturar();
    }

    public static void generateCSV(List<PedidosAFaturar> listaPedidosAFaturar) {
        StringBuilder csvContent = new StringBuilder();
        csvContent.append(CSV_HEADER);
        csvContent.append("\n");

        for (PedidosAFaturar p : listaPedidosAFaturar) {
            csvContent.append(p.getFilial()).append(";")
                    .append(p.getDataEmissao() != null ? p.getDataEmissao() : "").append(";")
                    .append(p.getDataEntrada() != null ? p.getDataEntrada() : "").append(";")
                    .append(p.getDataCancelamento() != null ? p.getDataCancelamento() : "").append(";")
                    .append(p.getNumNota()).append(";")
                    .append(p.getCodParceiro()).append(";")
                    .append(p.getRazaoSocial()).append(";")
                    .append(p.getCPF_CNPJ() != null ? p.getCPF_CNPJ() : "").append(";")
                    .append(p.getRamo() != null ? p.getRamo() : "").append(";")
                    .append(p.getDataPedido() != null ? p.getDataPedido() : "").append(";")
                    .append(p.getNumPedido()).append(";")
                    .append(p.getCodVendedor()).append(";")
                    .append(p.getVendedor() != null ? p.getVendedor() : "").append(";")
                    .append(p.getCodSupervisor()).append(";")
                    .append(p.getSupervisor() != null ? p.getSupervisor() : "").append(";")
                    .append(p.getCodProduto()).append(";")
                    .append(p.getCodFabrica()).append(";")
                    .append(p.getCodBarras()).append(";")
                    .append(p.getDescricao()).append(";")
                    .append(p.getValorCusto()).append(";")
                    .append(p.getPrecoTabela()).append(";")
                    .append(p.getValorDesconto()).append(";")
                    .append(p.getPrecoVenda()).append(";")
                    .append(p.getQuantidade()).append(";")
                    .append(p.getTotalPrecoTabela()).append(";")
                    .append(p.getTotalVenda()).append(";")
                    .append(p.getCFOP()).append(";")
                    .append(p.getDepartamento()).append(";")
                    .append(p.getSecao()).append(";")
                    .append(p.getCategoria()).append(";")
                    .append(p.getOperacao()).append(";")
                    .append(p.getPosicao() != null ? p.getPosicao() : "").append(";")
                    .append(p.getPesoLiquido()).append(";\n");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("PedidosAFaturar.csv"))) {
            writer.write(csvContent.toString());
            System.out.println(csvContent);
            System.out.println("Arquivo CSV exportado com sucesso para: " + fullPath);
        } catch (IOException e) {
            System.err.println("Erro ao exportar CSV: " + e.getMessage());
        }
    }
}
