package Service;

import DAO.PedidosAFaturarDAO;
import Model.PedidosAFaturar;

import java.io.File;
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
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy.MM.dd");
    private static final String timestamp = now.format(formatter);

    private static final String directoryPath = "C:\\Users\\aplicacoes\\Dropbox\\Vendas - Caboclo\\5_Pedidos_A_Faturar\\";
    private static final String baseFileName = "Caboclo_Pedidos_a_Faturar - ";
    private static final String fileExtension = ".csv";
    private static final String fileName = baseFileName + timestamp + fileExtension;
    private static final String fullPath = directoryPath + fileName;

    public List<PedidosAFaturar> listarPedidosAFaturar() throws SQLException {
        return pedidosAFaturarDAO.listarPedidosAFaturar();
    }

    public static boolean generateCSV(List<PedidosAFaturar> listaPedidosAFaturar) {
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
