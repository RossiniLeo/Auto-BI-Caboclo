import Service.*;
import DAO.*;

import java.sql.SQLException;

public class main {

    public static void main(String[] args) throws SQLException {
        AgendaVendedorDAO agendaVendedorDAO = new AgendaVendedorDAO();
        AgendaVendedorService.generateCSV(agendaVendedorDAO.listarAgendaVendedores());

        VendasFaturamentoMesAtualDAO vendasFaturamentoMesAtualDAO = new VendasFaturamentoMesAtualDAO();
        VendasFaturamentoMesAtualService.generateCSV(vendasFaturamentoMesAtualDAO.listarVendasFaturamentoMesAtual());
    }
}
