package DAO;

import Model.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    public List<Cliente> ListarCliente() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT\n" +
                "PCCLIENT.CGCENT AS CGCENT                            \n" +
                ",PCCLIENT.TIPOFJ AS TIPOFJ                           \n" +
                ",PCCLIENT.CLIENTE AS CLIENTE                          \n" +
                ",PCCLIENT.CODREDE AS CODREDE                          \n" +
                ",PCREDECLIENTE.DESCRICAO AS DESCRICAO\n" +
                ",PCCLIENT.FANTASIA AS FANTASIA\n" +
                ",PCCLIENT.CODCLI AS CODCLI\n" +
                ",PCCLIENT.DTULTALTER AS DTULTALTER\n" +
                ",PCCLIENT.IEENT AS IEENT\n" +
                ",PCCLIENT.DTCADASTRO AS DTCADASTRO\n" +
                ",PCCLIENT.CODATV1 AS CODATV1                          \n" +
                ",PCATIVI.RAMO AS RAMO                              \n" +
                ",PCCLIENT.DTULTCOMP AS DTULTCOMP\n" +
                ",PCCLIENT.ESTENT AS ESTENT\n" +
                ",PCCLIENT.CODFILIALNF CODFILIALNF\n" +
                ",PCCLIENT.TELCELENT AS TELCELENT\n" +
                ",PCCLIENT.PREDIOPROPRIO AS PREDIOPROPRIO\n" +
                ",PCCLIENT.CODCIDADE AS CODCIDADE\n" +
                ",PCCLIENT.CODPRACA AS CODPRACA\n" +
                ",PCPRACA.PRACA AS PRACA\n" +
                ",PCCLIENT.EMAIL AS EMAIL\n" +
                ",PCCLIENT.ENDERENT AS ENDERENT\n" +
                ",PCCLIENT.NUMEROENT AS NUMEROENT\n" +
                ",PCCLIENT.BAIRROENT AS BAIRROENT\n" +
                ",PCCLIENT.MUNICENT AS MUNICENT\n" +
                ",PCCLIENT.CEPENT AS CEPENT\n" +
                ",PCCLIENT.OBSERVACAO AS OBSERVACAO\n" +
                ",PCCLIENT.BLOQUEIO AS BLOQUEIO\n" +
                ",PCCLIENT.DTBLOQ AS DTBLOQ\n" +
                ",PCCLIENT.CODUSUR1 AS CODUSUR1\n" +
                ",PCCLIENT.CODUSUR2 AS CODUSUR2\n" +
                ",PCCLIENT.MOTIVOEXCLUSAO AS MOTIVOEXCLUSAO\n" +
                ",PCCLIENT.MOTIVOBLOQ AS MOTIVOBLOQ\n" +
                "FROM PCCLIENT\n" +
                "INNER JOIN PCATIVI ON (PCCLIENT.CODATV1 = PCATIVI.CODATIV )\n" +
                "LEFT JOIN PCREDECLIENTE ON (PCCLIENT.CODREDE = PCREDECLIENTE.CODREDE)\n" +
                "LEFT JOIN PCPRACA ON (PCCLIENT.CODPRACA = PCPRACA.CODPRACA) ";

        try (Connection conn = ConnectionFactory.obtemConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getString("CGCENT"),
                        rs.getString("TIPOFJ"),
                        rs.getString("CLIENTE"),
                        rs.getInt("CODREDE"),
                        rs.getString("DESCRICAO"),
                        rs.getString("FANTASIA"),
                        rs.getInt("CODCLI"),
                        rs.getDate("DTULTALTER"),
                        rs.getString("IEENT"),
                        rs.getDate("DTCADASTRO"),
                        rs.getInt("CODATV1"),
                        rs.getString("RAMO"),
                        rs.getDate("DTULTCOMP"),
                        rs.getString("ESTENT"),
                        rs.getInt("CODFILIALNF"),
                        rs.getString("TELCELENT"),
                        rs.getString("PREDIOPROPRIO"),
                        rs.getInt("CODCIDADE"),
                        rs.getInt("CODPRACA"),
                        rs.getString("PRACA"),
                        rs.getString("EMAIL"),
                        rs.getString("ENDERENT"),
                        rs.getString("NUMEROENT"),
                        rs.getString("BAIRROENT"),
                        rs.getString("MUNICENT"),
                        rs.getString("CEPENT"),
                        rs.getString("OBSERVACAO"),
                        rs.getString("BLOQUEIO"),
                        rs.getDate("DTBLOQ"),
                        rs.getInt("CODUSUR1"),
                        rs.getInt("CODUSUR2"),
                        rs.getString("MOTIVOEXCLUSAO"),
                        rs.getString("MOTIVOBLOQ")
                );
                clientes.add(cliente);
            }
        }
        return clientes;
    }
}
