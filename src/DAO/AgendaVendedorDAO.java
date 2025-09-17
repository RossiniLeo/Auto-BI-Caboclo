package DAO;

import Model.AgendaVendedor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AgendaVendedorDAO {

    // Método para obter uma lista de AgendaVendedores com base na query fornecida
    public List<AgendaVendedor> listarAgendaVendedores() throws SQLException {
        List<AgendaVendedor> agendaVendedores = new ArrayList<>();
        String sql = "SELECT " +
                "R.CODCLI, C.CLIENTE, C.CGCENT, C.CODREDE, RD.DESCRICAO AS REDE, " +
                "C.CODPRACA, C.CODATV1, A.RAMO, C.ENDERENT, C.NUMEROENT, " +
                "C.CEPENT, C.BAIRROENT, C.MUNICENT, C.ESTENT, C.TELENT, C.BLOQUEIO, C.CODCOB AS FORMA_PG, " +
                "C.CODPLPAG, C.DTBLOQ, C.DTULTCOMP, " +
                "R.CODUSUR AS CODRCA, U.NOME AS VENDEDOR1, U.CODSUPERVISOR AS CODSUPER1, " +
                "R.DTPROXVISITA AS VEND_DTVISITA, R.DIASEMANA AS VEND_DIASEMANA, " +
                "R.PERIODICIDADE AS VEND_PERIO, R.SEQUENCIA AS VEND_SEQUENCIA " +
                "FROM PCCLIENT C " +
                "INNER JOIN PCROTACLI R ON (C.CODCLI = R.CODCLI) " +
                "LEFT JOIN PCUSUARI U ON (R.CODUSUR = U.CODUSUR) " +
                "INNER JOIN PCATIVI A ON (C.CODATV1 = A.CODATIV) " +
                "LEFT JOIN PCREDECLIENTE RD ON (C.CODREDE = RD.CODREDE)";

        try (Connection conn = ConnectionFactory.obtemConexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                AgendaVendedor agendaVendedor = new AgendaVendedor(
                        rs.getInt("CODCLI"),
                        rs.getString("CLIENTE"),
                        rs.getString("CGCENT"),
                        rs.getInt("CODREDE"),
                        rs.getString("REDE"),
                        rs.getInt("CODPRACA"),
                        rs.getInt("CODATV1"),
                        rs.getString("RAMO"),
                        rs.getString("ENDERENT"),
                        rs.getString("NUMEROENT"),
                        rs.getInt("CEPENT"),
                        rs.getString("BAIRROENT"),
                        rs.getString("MUNICENT"),
                        rs.getString("ESTENT"),
                        rs.getString("TELENT"),
                        rs.getString("BLOQUEIO"),
                        rs.getString("FORMA_PG"),
                        rs.getInt("CODPLPAG"),
                        rs.getString("DTBLOQ"),
                        rs.getString("DTULTCOMP"),
                        rs.getInt("CODRCA"),
                        rs.getString("VENDEDOR1"),
                        rs.getInt("CODSUPER1"),
                        rs.getString("VEND_DTVISITA"),
                        rs.getString("VEND_DIASEMANA"),
                        rs.getInt("VEND_PERIO"),
                        rs.getInt("VEND_SEQUENCIA")
                );
                agendaVendedores.add(agendaVendedor);
            }
        }
        return agendaVendedores;
    }
}
