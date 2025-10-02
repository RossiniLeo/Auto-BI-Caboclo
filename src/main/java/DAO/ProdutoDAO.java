package DAO;

import Model.Produto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    public List<Produto> listarProdutos() throws SQLException {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT \n" +
                "PCPRODUT.CODPROD\n" +
                ",PCPRODUT.DESCRICAO\n" +
                ",PCPRODUT.CODFORNEC\n" +
                ",PCFORNEC.FORNECEDOR\n" +
                ",PCPRODUT.CODEPTO\n" +
                ",PCDEPTO.DESCRICAO\n" +
                ",PCPRODUT.CODSEC\n" +
                ",PCSECAO.DESCRICAO\n" +
                ",PCPRODUT.CODMARCA\n" +
                ",PCMARCA.MARCA\n" +
                ",PCPRODUT.CODCATEGORIA\n" +
                ",PCCATEGORIA.CATEGORIA\n" +
                ",PCPRODUT.EMBALAGEM\n" +
                ",PCPRODUT.PESOLIQ\n" +
                ",PCPRODUT.PESOBRUTO\n" +
                ",PCPRODUT.NBM\n" +
                ",PCPRODUT.CODAUXILIAR\n" +
                ",PCPRODUT.CODAUXILIAR2\n" +
                ",PCPRODUT.CODFAB\n" +
                ",PCPRODUT.OBS2\n" +
                ",PCPRODUT.DTEXCLUSAO\n" +
                ",PCPRODUT.DTULTALTER\n" +
                ",PCPRODUT.DTCADASTRO\n" +
                "FROM\n" +
                "PCPRODUT\n" +
                "INNER JOIN PCFORNEC   ON (PCPRODUT.CODFORNEC = PCFORNEC.CODFORNEC)\n" +
                "INNER JOIN PCDEPTO    ON (PCPRODUT.CODEPTO = PCDEPTO.CODEPTO)\n" +
                "LEFT JOIN PCSECAO     ON (PCPRODUT.CODEPTO = PCSECAO.CODEPTO AND PCPRODUT.CODSEC = PCSECAO.CODSEC)\n" +
                "LEFT JOIN PCCATEGORIA ON (PCPRODUT.CODCATEGORIA = PCCATEGORIA.CODCATEGORIA  AND PCCATEGORIA.CODSEC =PCPRODUT.CODSEC)\n" +
                "LEFT JOIN PCMARCA     ON (PCPRODUT.CODMARCA = PCMARCA.CODMARCA)\n" +
                "\n" +
                "ORDER BY PCPRODUT.DTEXCLUSAO DESC,PCPRODUT.CODEPTO,PCPRODUT.DESCRICAO\n";

        try (Connection conn = ConnectionFactory.obtemConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto(
                        rs.getInt("PCPRODUT.CODPROD"),
                        rs.getString("PCPRODUT.DESCRICAO"),
                        rs.getInt("PCPRODUT.CODFORNEC"),
                        rs.getString("PCPRODUT.FONECEDOR"),
                        rs.getInt("PCPRODUT.CODEPTO"),
                        rs.getString("PCPRODUT.DESCRICAO"),
                        rs.getInt("PCPRODUT.CODSEC"),
                        rs.getString("PCPRODUT.DESCRICAO"),
                        rs.getInt("PCPRODUT.CODMARCA"),
                        rs.getString("PCPRODUT.MARCA"),
                        rs.getInt("PCPRODUT.CODCATEGORIA"),
                        rs.getString("PCPRODUT.CATEGORIA"),
                        rs.getString("PCPRODUT.EMBALAGEM"),
                        rs.getDouble("PCPRODUT.PESOLIQ"),
                        rs.getDouble("PCPRODUT.PESOBRUTO"),
                        rs.getInt("PCPRODUT.NBM"),
                        rs.getInt("PCPRODUT.CODAUXILIAR"),
                        rs.getInt("PCPRODUT.CODAUXLIAR2"),
                        rs.getInt("PCPRODUT.CODFAB"),
                        rs.getString("PCPRODUT.OBS2"),
                        rs.getDate("PCPRODUT.DTEXCLUSAO"),
                        rs.getDate("PCPRODUT.DTULTALTER"),
                        rs.getDate("PCPRODUT.DTCADASTRO")
                );
            }
        }
        return produtos;
    }
}
