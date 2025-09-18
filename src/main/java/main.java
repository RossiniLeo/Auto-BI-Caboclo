import Service.*;
import DAO.*;

import java.sql.SQLException;

public class main {
    AgendaVendedorDAO agendaVendedorDAO = new AgendaVendedorDAO();

    void main() throws SQLException {
        AgendaVendedorService.generateCSV(agendaVendedorDAO.listarAgendaVendedores());
    }
}
