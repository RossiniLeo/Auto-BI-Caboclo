package Service;

import DAO.AgendaVendedorDAO;
import Model.AgendaVendedor;

import java.sql.SQLException;
import java.util.List;

public class AgendaVendedorService {
    private AgendaVendedorDAO  agendaVendedorDAO = new AgendaVendedorDAO();

    private static final String CSV_HEADER = "CODCLI,CLIENTE,CGCENT,CODREDE,REDE,CODPRACA,CODATV1,RAMO,ENDERENT,NUMEROENT,CEPENT,BAIRROENT,MUNICENT,ESTENT,TELENT,BLOQUEIO,FORGA_PG,CODPLPAG,DTBLOQ,DTULTCOMP,CODRCA,VENDEDOR1,CODSUPER1,VEND_VISITA,VEND_DIASEMANA,VEND_PERIO,VEND_SEQUENCIA";

    public List<AgendaVendedor> listarAgendaVendedores() throws SQLException {
        return agendaVendedorDAO.listarAgendaVendedores();
    }

    public String generateCSV(List<AgendaVendedor> agendaVendedores) {
        StringBuilder csvContent = new StringBuilder();
        csvContent.append(CSV_HEADER);

        for (AgendaVendedor av : agendaVendedores) {
            csvContent.append(av.getCodCliente()).append(",")
                    .append(av.getCliente()).append(",")
                    .append(av.getCGCENT()).append(",")
                    .append(av.getCodRede()).append(",")
                    .append(av.getRede()).append(",")
                    .append(av.getCodPraca()).append(",")
                    .append(av.getCodATV1()).append(",")
                    .append(av.getRamo()).append(",")
                    .append(av.getEnderecoENT()).append(",")
                    .append(av.getNumero()).append(",")
                    .append(av.getCEPENT()).append(",")
                    .append(av.getBairroENT()).append(",")
                    .append(av.getMunicipioENT()).append(",")
                    .append(av.getEstadoENT()).append(",")
                    .append(av.getTelefoneENT()).append(",")
                    .append(av.getBloqueio()).append(",")
                    .append(av.getFormaPG()).append(",")
                    .append(av.getCodPG()).append(",")
                    .append(av.getDataBloqueio()).append(",")
                    .append(av.getDataUltimaCompra()).append(",")
                    .append(av.getCodRCA()).append(",")
                    .append(av.getVendedor()).append(",")
                    .append(av.getCodSupervisor()).append(",")
                    .append(av.getDataProxVisita()).append(",")
                    .append(av.getDiaSemanaVisita()).append(",")
                    .append(av.getPeriodicidadeVisita()).append(",")
                    .append(av.getSequenciaVisita()).append("\n");
        }
        return csvContent.toString();
    }
}
