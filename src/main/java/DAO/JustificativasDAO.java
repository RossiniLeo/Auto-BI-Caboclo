package DAO;

import Model.Justificativas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JustificativasDAO {
    public List<Justificativas> listarJustificativas() throws SQLException {
        List<Justificativas> listaJustificativas = new ArrayList<>();
        String sql = "SELECT CODUSUR COD_VENDEDOR,VENDEDOR NOME_VENDEDOR,CODCLI COD_CLIENTE,\n" +
                "CLIENTE NOME_CLIENTE,END_DATE DATA,UPPER(LABEL) JUSTIFICATIVA,UPPER(NAME) TIPO\n" +
                "FROM WD_VW_POLIATIVIDADES\n" +
                "WHERE UPPER(NAME) LIKE '%JUSTI%' AND to_date(END_DATE, 'dd-mon-yyyy hh24:mi:ss') >= TRUNC(sysdate, 'MON')";

        try (Connection conn = ConnectionFactory.obtemConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Justificativas justificativas = new Justificativas(
                        rs.getInt("CODUSUR"),
                        rs.getString("VENDEDOR"),
                        rs.getInt("CODCLI"),
                        rs.getString("CLIENTE"),
                        rs.getDate("END_DATE"),
                        rs.getString("UPPER(LABEL)"),
                        rs.getString("UPPER(NAME)")
                );
                listaJustificativas.add(justificativas);
            }
        }
        return listaJustificativas;
    }
}
