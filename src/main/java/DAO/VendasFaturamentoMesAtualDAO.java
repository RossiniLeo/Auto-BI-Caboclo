package DAO;

import Model.VendasFaturamentoMesAtual;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VendasFaturamentoMesAtualDAO {
    public List<VendasFaturamentoMesAtual> listarVendasFaturamentoMesAtual() throws SQLException {
        List<VendasFaturamentoMesAtual> ListaVendasFaturamentoMesAtual = new ArrayList<>();
        String sql = "select\n" +
                " :dtini as dtini         ,\n" +
                " :dtfim as dtfim         ,\n" +
                " m.dtmov        ,\n" +
                " m.numnota      ,\n" +
                " m.codoper      ,\n" +
                " m.status       ,\n" +
                " m.codcli       ,\n" +
                " c.cliente      ,\n" +
                " c.cgcent       ,\n" +
                " m.codusur      ,\n" +
                " u.nome         ,\n" +
                " u.codsupervisor,\n" +
                " m.codprod      ,\n" +
                " m.descricao    ,\n" +
                " m.codfornec    ,\n" +
                " m.codfiscal    ,\n" +
                " m.qt           ,\n" +
                " m.punit        ,\n" +
                " m.qt*m.punit   as vendatot     ,\n" +
                " m.custoreal    ,\n" +
                " m.qt*m.custoreal   as custotot,\n" +
                " d.descricao as depto\n" +
                " \n" +
                " \n" +
                "\n" +
                "\n" +
                "from \n" +
                " pcmov      m       ,\n" +
                " pcclient   c       ,\n" +
                " pcusuari   u       ,\n" +
                " pcprodut   p       ,\n" +
                " pcdepto    d\n" +
                "\n" +
                "where\n" +
                "     m.dtmov between :dtini and :dtfim  \n" +
                " and m.status    =  'AB'\n" +
                " and m.codoper in ( 'E' , 'EB' , 'ED' ,  --ENTRADA\n" +
                "                    'S' , 'SB' , 'SD' )  --SAIDA\n" +
                " and m.codcli    = c.codcli\n" +
                " and m.codusur   = u.codusur\n" +
                " and p.codepto   = d.codepto\n" +
                " and m.codprod   = p.codprod\n";

        sql = sql.replace(":dtini", "?").replace(":dtfim", "?");

        try (Connection conn = ConnectionFactory.obtemConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDate(1, Date.valueOf(LocalDate.now().withDayOfMonth(1)));
            stmt.setDate(2, Date.valueOf(LocalDate.now()));

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                VendasFaturamentoMesAtual vendasFaturamentoMesAtual = new VendasFaturamentoMesAtual(
                        rs.getDate("DTMOV"),
                        rs.getInt("NUMNOTA"),
                        rs.getString("CODOPER"),
                        rs.getString("STATUS"),
                        rs.getInt("CODCLI"),
                        rs.getString("CLIENTE"),
                        rs.getString("CGCENT"),
                        rs.getInt("CODUSUR"),
                        rs.getString("NOME"),
                        rs.getInt("CODSUPERVISOR"),
                        rs.getInt("CODPROD"),
                        rs.getString("DESCRICAO"),
                        rs.getInt("CODFORNEC"),
                        rs.getInt("CODFISCAL"),
                        rs.getInt("QT"),
                        rs.getDouble("PUNIT"),
                        rs.getDouble("VENDATOT"),
                        rs.getDouble("CUSTOREAL"),
                        rs.getDouble("CUSTOTOT"),
                        rs.getString("DEPTO")
                );
                ListaVendasFaturamentoMesAtual.add(vendasFaturamentoMesAtual);
            }
        }
        return ListaVendasFaturamentoMesAtual;
    }
}
