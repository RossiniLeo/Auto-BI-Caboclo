package DAO;

import Model.Produto;

import java.math.BigInteger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    public List<Produto> listarProdutos() throws SQLException {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT \n" +
                "PCPRODUT.CODPROD AS CODPROD\n" +
                ",PCPRODUT.DESCRICAO AS DESCRICAO\n" +
                ",PCPRODUT.CODFORNEC AS CODFORNEC\n" +
                ",PCFORNEC.FORNECEDOR AS FORNECEDOR\n" +
                ",PCPRODUT.CODEPTO AS CODEPTO\n" +
                ",PCDEPTO.DESCRICAO AS DESCRICAO_1\n" +
                ",PCPRODUT.CODSEC AS CODSEC\n" +
                ",PCSECAO.DESCRICAO AS DESCRICAO_2\n" +
                ",PCPRODUT.CODMARCA AS CODMARCA\n" +
                ",PCMARCA.MARCA AS MARCA\n" +
                ",PCPRODUT.CODCATEGORIA AS CODCATEGORIA\n" +
                ",PCCATEGORIA.CATEGORIA AS CATEGORIA\n" +
                ",PCPRODUT.EMBALAGEM AS EMBALAGEM\n" +
                ",PCPRODUT.PESOLIQ AS PESOLIQ\n" +
                ",PCPRODUT.PESOBRUTO AS PESOBRUTO\n" +
                ",PCPRODUT.NBM AS NBM\n" +
                ",PCPRODUT.CODAUXILIAR AS CODAUXILIAR\n" +
                ",PCPRODUT.CODAUXILIAR2 AS CODAUXILIAR2\n" +
                ",PCPRODUT.CODFAB AS CODFAB\n" +
                ",PCPRODUT.OBS2 AS OBS2\n" +
                ",PCPRODUT.DTEXCLUSAO AS DTEXCLUSAO\n" +
                ",PCPRODUT.DTULTALTER AS DTULTALTER\n" +
                ",PCPRODUT.DTCADASTRO AS DTCADASTRO\n" +
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
                        rs.getInt("CODPROD"),
                        rs.getString("DESCRICAO"),
                        rs.getInt("CODFORNEC"),
                        rs.getString("FORNECEDOR"),
                        rs.getInt("CODEPTO"),
                        rs.getString("DESCRICAO_1"),
                        rs.getInt("CODSEC"),
                        rs.getString("DESCRICAO_2"),
                        rs.getInt("CODMARCA"),
                        rs.getString("MARCA"),
                        rs.getInt("CODCATEGORIA"),
                        rs.getString("CATEGORIA"),
                        rs.getString("EMBALAGEM"),
                        rs.getDouble("PESOLIQ"),
                        rs.getDouble("PESOBRUTO"),
                        rs.getInt("NBM"),
                        rs.getBigDecimal("CODAUXILIAR") != null ? rs.getBigDecimal("CODAUXILIAR").toBigInteger() : BigInteger.valueOf(0),
                        rs.getBigDecimal("CODAUXILIAR2") != null ? rs.getBigDecimal("CODAUXILIAR2").toBigInteger() : BigInteger.valueOf(0),
                        rs.getString("CODFAB"),
                        rs.getString("OBS2"),
                        rs.getDate("DTEXCLUSAO"),
                        rs.getDate("DTULTALTER"),
                        rs.getDate("DTCADASTRO")
                );
                produtos.add(produto);
            }
        }
        return produtos;
    }
}
