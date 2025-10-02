package DAO;

import Model.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    public List<Cliente> ListarCliente() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT\n" +
                "PCCLIENT.CGCENT                            \n" +
                ",PCCLIENT.TIPOFJ                           \n" +
                ",PCCLIENT.CLIENTE                          \n" +
                ",PCCLIENT.CODREDE                          \n" +
                ",PCREDECLIENTE.DESCRICAO\n" +
                ",PCCLIENT.FANTASIA\n" +
                ",PCCLIENT.CODCLI\n" +
                ",PCCLIENT.DTULTALTER\n" +
                ",PCCLIENT.IEENT\n" +
                ",PCCLIENT.DTCADASTRO\n" +
                ",PCCLIENT.CODATV1                          \n" +
                ",PCATIVI.RAMO                              \n" +
                ",PCCLIENT.DTULTCOMP\n" +
                ",PCCLIENT.ESTENT\n" +
                ",PCCLIENT.CODFILIALNF\n" +
                ",PCCLIENT.TELCELENT\n" +
                ",PCCLIENT.PREDIOPROPRIO\n" +
                ",PCCLIENT.CODCIDADE\n" +
                ",PCCLIENT.CODPRACA\n" +
                ",PCPRACA.PRACA\n" +
                ",PCCLIENT.EMAIL\n" +
                ",PCCLIENT.ENDERENT\n" +
                ",PCCLIENT.NUMEROENT\n" +
                ",PCCLIENT.BAIRROENT\n" +
                ",PCCLIENT.MUNICENT\n" +
                ",PCCLIENT.CEPENT\n" +
                ",PCCLIENT.OBSERVACAO\n" +
                ",PCCLIENT.BLOQUEIO\n" +
                ",PCCLIENT.DTBLOQ\n" +
                ",PCCLIENT.CODUSUR1\n" +
                ",PCCLIENT.CODUSUR2\n" +
                ",PCCLIENT.MOTIVOEXCLUSAO\n" +
                ",PCCLIENT.MOTIVOBLOQ\n" +
                "FROM PCCLIENT\n" +
                "INNER JOIN PCATIVI ON (PCCLIENT.CODATV1 = PCATIVI.CODATIV )\n" +
                "LEFT JOIN PCREDECLIENTE ON (PCCLIENT.CODREDE = PCREDECLIENTE.CODREDE)\n" +
                "LEFT JOIN PCPRACA ON (PCCLIENT.CODPRACA = PCPRACA.CODPRACA) ";

        try (Connection conn = ConnectionFactory.obtemConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getString("PCCLIENT.CGCENT"),
                        rs.getInt("PCCLIENT.TIPOFJ"),
                        rs.getString("PCCLIENT.CLIENTE"),
                        rs.getInt("PCCLIENT.CODREDE"),
                        rs.getString("PCCLIENT.DESCICAO"),
                        rs.getString("PCCLIENT.FANTASIA"),
                        rs.getInt("PCCLIENT.CODCLI"),
                        rs.getDate("PCCLIENT.DTULTALTER"),
                        rs.getString("PCCLIENT.IEENT"),
                        rs.getDate("PCCLIENT.DTCADASTRO"),
                        rs.getInt("PCCLIENT.CODATV1"),
                        rs.getString("PCCLIENT.RAMO"),
                        rs.getDate("PCCLIENT.DTULTCOMP"),
                        rs.getString("PCCLIENT.ESTENT"),
                        rs.getInt("PCCLIENT.CODFILIALNF"),
                        rs.getString("PCCLIENT.TELCELENT"),
                        rs.getString("PCCLIENT.PREDIOPROPRIO"),
                        rs.getInt("PCCLIENT.CODCIDADE"),
                        rs.getInt("PCCLIENT.CODPRACA"),
                        rs.getString("PCCLIENT.PRACA"),
                        rs.getString("PCCLIENT.EMAIL"),
                        rs.getString("PCCLIENT.ENDERENT"),
                        rs.getInt("PCCLIENT.NUMEROENT"),
                        rs.getString("PCCLIENT.BAIRROENT"),
                        rs.getString("PCCLIENT.MUNICENT"),
                        rs.getString("PCCLIENT.CEPENT"),
                        rs.getString("PCCLIENT.OBSERVACAO"),
                        rs.getString("PCCLIENT.BLOQUEIO"),
                        rs.getDate("PCCLIENT.DTBOQ"),
                        rs.getInt("PCCLIENT.CODUSUR1"),
                        rs.getInt("PCCLIENT.CODUSUR2"),
                        rs.getString("PCCLIENT.MOTIVOEXCLUSAO"),
                        rs.getString("PCCLIENT.MOTIVOBLOQ")
                );
                clientes.add(cliente);
            }
        }
        return clientes;
    }
}
