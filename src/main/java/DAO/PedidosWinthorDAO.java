package DAO;

import Model.PedidosWinthor;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PedidosWinthorDAO {
    public List<PedidosWinthor> listarPedidosWinthor() throws SQLException{
        List<PedidosWinthor> listaPedidosWinthor = new ArrayList<>();
        String sql = "SELECT \n" +
                "       C.NUMPED,\n" +
                "       C.NUMPEDRCA,\n" +
                "       C.CODUSUR,\n" +
                "       U.NOME,\n" +
                "       C.CGCCLI,\n" +
                "       C.CODCLI,\n" +
                "       A.CLIENTE,       \n" +
                "       C.DTFECHAMENTOPEDPALM,\n" +
                "       C.DTINCLUSAO,\n" +
                "       C.DTENTREGA,\n" +
                "       C.CODFILIAL,\n" +
                "       C.CODCOB,\n" +
                "       C.CODPLPAG,\n" +
                "       C.CONDVENDA,\n" +
                "       C.ORIGEMPED,\n" +
                "       C.OBS1,\n" +
                "       C.OBSERVACAO_PC,\n" +
                "       DECODE(C.POSICAO_ATUAL,\n" +
                "       'L','LIBERADO','M','MONTADO','F','FATURADO',\n" +
                "       'C','CANCELADO','P','PENDENTE','B','BLOQUEADO','R','REJEITADO') \"POSICAO_ATUAL\",\n" +
                "       (SELECT SUM(B.QT * B.PVENDA) \n" +
                "          FROM PCPEDIFV B\n" +
                "         WHERE B.NUMPEDRCA = C.NUMPEDRCA\n" +
                "           AND B.CODUSUR = C.CODUSUR\n" +
                "           AND B.CGCCLI = C.CGCCLI\n" +
                "           AND B.DTABERTURAPEDPALM = C.DTABERTURAPEDPALM) VLR_PEDIDO\n" +
                "  FROM PCPEDCFV C, PCCLIENT A, PCUSUARI U\n" +
                " WHERE (trim(replace(replace(replace(replace(replace(replace(C.CGCCLI,\n" +
                "         ' ', ''),'.', ''), ',', ''), '-', ''), '/', ''), '\\','')) = (trim(replace(replace(replace(replace(replace(replace(A.CGCENT, ' ', ''), '.', ''), ',', ''), '-', ''), '/', ''), '\\', '')))\n" +
                "   AND C.CODUSUR = U.CODUSUR\n" +
                "   AND C.IMPORTADO IN (2,3)\n" +
                "   AND C.OBSERVACAO_PC NOT LIKE '%REMOVIDO PELA ROTINA 2596%') --AND     C.NUMPED IN (1772246)\n" +
                "   AND TRUNC(C.DTINCLUSAO) BETWEEN :dtini and :dtfin" +
                "  ORDER BY   DTINCLUSAO,CODUSUR, NUMPEDRCA";

        sql = sql.replace(":dtini", "?").replace(":dtfin", "?");

        try (Connection conn = ConnectionFactory.obtemConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDate(1, Date.valueOf(LocalDate.now().withDayOfMonth(1)));
            stmt.setDate(2, Date.valueOf(LocalDate.now()));

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                PedidosWinthor pedidosWinthor = new PedidosWinthor(
                        rs.getLong("NUMPED"),
                        rs.getInt("NUMPEDRCA"),
                        rs.getInt("CODUSUR"),
                        rs.getString("NOME"),
                        rs.getString("CGCCLI"),
                        rs.getInt("CODCLI"),
                        rs.getString("CLIENTE"),
                        rs.getDate("DTFECHAMENTOPEDPALM"),
                        rs.getDate("DTINCLUSAO"),
                        rs.getDate("DTENTREGA"),
                        rs.getInt("CODFILIAL"),
                        rs.getString("CODCOB"),
                        rs.getInt("CODPLPAG"),
                        rs.getInt("CONDVENDA"),
                        rs.getString("ORIGEMPED"),
                        rs.getString("OBS1"),
                        rs.getString("OBSERVACAO_PC"),
                        rs.getString("POSICAO_ATUAL"),
                        rs.getDouble("VLR_PEDIDO")
                );
                listaPedidosWinthor.add(pedidosWinthor);
            }
        }
        return listaPedidosWinthor;
    }
}
