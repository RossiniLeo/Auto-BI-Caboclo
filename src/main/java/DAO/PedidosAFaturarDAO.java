package DAO;

import Model.PedidosAFaturar;

import java.math.BigInteger;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PedidosAFaturarDAO {
    public List<PedidosAFaturar> listarPedidosAFaturar() throws SQLException{
        List<PedidosAFaturar> listaPedidosAFaturar = new ArrayList<>();
        String sql = "   select\n" +
                "       codfilial \"Filial\"\n" +
                "      ,dtemissao \"Data Emissão\"\n" +
                "      ,dtentrada \"Data Entrada\"\n" +
                "      ,datacancel \"Data Cancelamento\"\n" +
                "      ,numnota \"N° Nota\"\n" +
                "      ,codparceiro \"Cód. Parceiro\"\n" +
                "      ,razaosocial \"Razão Social\"\n" +
                "      ,cpfcnpj \"CPF/CNPJ\"\n" +
                "      ,ramo \"Ramo\"\n" +
                "      ,dataped \"Data Pedido\"\n" +
                "      ,pedido \"N° Pedido\"\n" +
                "      ,codrca \"Cód. Vendedor\"\n" +
                "      ,rca \"Vendedor\"\n" +
                "      ,codsuperv \"Cód. Supervisor\"\n" +
                "      ,supervisor \"Supervisor\"\n" +
                "      ,codinterno \"Cód. Produto\"  \n" +
                "      ,codfab \"Cód. Fábrica\"\n" +
                "      ,ean \"Cód. Barras\"\n" +
                "      ,descricao \"Descrição\"\n" +
                "      ,custo \"Vl. Custo\"\n" +
                "      ,precobruto \"Preço Tabela\"\n" +
                "      ,desconto \"Vl. Desconto\"\n" +
                "      ,precoliq \"Preço Venda\"\n" +
                "      ,quantidade \"Qtde\"\n" +
                "      ,totprecobruto \"Tot. Preço Tabela\"\n" +
                "      ,totprecoliq \"Total Venda\"\n" +
                "      ,cfop \"CFOP\"\n" +
                "      ,departamento \"Departamento\"\n" +
                "      ,secao \"Seção\"\n" +
                "      ,categoria \"Categoria\"\n" +
                "      ,decode(operacao,'V','Venda','E','Entrada','ED','Devolução Cliente') \"Operação\" \n" +
                "      ,(case when datacancel is not null  then \n" +
                "                'Cancelado'      \n" +
                "                else   \n" +
                "                decode(posicao,'F','Faturado','L','Liberado', 'M', 'Montado', 'P','Pendente Estoque','B','Bloqueado','C','Cancelado','','')\n" +
                "      end)\"Posição\"\n" +
                "      , pesoliqunit \"Peso Liquido Unitario\"\n" +
                "from (\n" +
                "-- Vendas Faturadas\n" +
                "select\n" +
                "             nf.codfilial           as codfilial\n" +
                "            ,nf.dtsaida             as dtemissao\n" +
                "            ,to_date('')            as dtentrada\n" +
                "            ,nf.dtcancel            as datacancel\n" +
                "            ,nf.numnota             as numnota\n" +
                "            ,nf.codcli              as codparceiro\n" +
                "            ,nf.cliente             as razaosocial\n" +
                "            ,decode(cl.tipofj,'J',regexp_replace(LPAD(nf.cgc, 18),'([0-9]{2})([0-9]{3})([0-9]{3})([0-9]{4})','\\1.\\2.\\3/\\4-'),\n" +
                "                              'F',regexp_replace(LPAD('00000000191', 14),'([0-9]{3})([0-9]{3})([0-9]{3})','\\1.\\2.\\3-')) \n" +
                "                                    as cpfcnpj\n" +
                "            ,ramo.ramo              as ramo                  \n" +
                "            ,ped.data               as dataped\n" +
                "            ,ped.numped             as pedido\n" +
                "            ,ped.codusur            as codrca   \n" +
                "            ,usur.nome              as rca\n" +
                "            ,ped.codsupervisor      as codsuperv\n" +
                "            ,superv.nome            as supervisor\n" +
                "            ,nvl(prod.codinterno,prod.codprod) as codinterno\n" +
                "            ,prod.codfab            as codfab\n" +
                "            ,prod.codauxiliar       as ean   \n" +
                "            ,prod.descricao         as descricao\n" +
                "            ,est.valorultent        as custo\n" +
                "            ,mov.ptabela            as precobruto\n" +
                "            ,mov.vldesconto         as desconto\n" +
                "            ,mov.punit              as precoliq\n" +
                "            ,mov.qt                 as quantidade\n" +
                "            ,(mov.qt*mov.ptabela)   as totprecobruto\n" +
                "            ,(mov.qt*mov.punit)     as totprecoliq\n" +
                "            ,mov.codfiscal          as cfop\n" +
                "            ,depto.descricao        as departamento\n" +
                "            ,secao.descricao        as secao\n" +
                "            ,cat.categoria          as categoria\n" +
                "            ,'F'                    as posicao\n" +
                "            ,'V'                    as operacao\n" +
                "            ,prod.pesoliq          as pesoliqunit\n" +
                "from         pcnfsaid nf\n" +
                "join         pcmov mov\n" +
                "on           nf.numtransvenda = mov.numtransvenda\n" +
                "left join    pcpedc ped\n" +
                "on           nf.numtransvenda = ped.numtransvenda\n" +
                "join         pcclient cl\n" +
                "on           nf.codcli = cl.codcli\n" +
                "join         pcativi ramo\n" +
                "on           cl.codatv1 = ramo.codativ\n" +
                "left join    pcusuari usur\n" +
                "on           ped.codusur = usur.codusur\n" +
                "left join    pcsuperv superv\n" +
                "on           ped.codsupervisor = superv.codsupervisor\n" +
                "join         pcprodut prod\n" +
                "on           mov.codprod = prod.codprod\n" +
                "join         pcdepto depto\n" +
                "on           prod.codepto = depto.codepto\n" +
                "join         pcsecao secao\n" +
                "on           prod.codsec = secao.codsec\n" +
                "             and prod.codepto = secao.codepto                      \n" +
                "join         pccategoria cat\n" +
                "on           prod.codcategoria = cat.codcategoria\n" +
                "             and prod.codsec = cat.codsec                          \n" +
                "join         pcest est\n" +
                "on           prod.codprod = est.codprod\n" +
                "and          nf.codfilial = est.codfilial\n" +
                "where        1 = 1\n" +
                "and          ped.data between :dataini and :datafim     \n" +
                "and          ped.codfilial in (1)\n" +
                "and          nf.codfiscal not in (522, 622, 722, 532, 632, 732)\n" +
                "and          nf.condvenda not in (4, 8, 10, 13, 20, 98, 99)\n" +
                "and          mov.codoper <> 'SR'\n" +
                "and          mov.codoper <> 'SO'\n" +
                "and          nvl(nf.tipovenda,'X') not in ('SR', 'DF')\n" +
                "and          mov.qt > 0\n" +
                "\n" +
                "union all\n" +
                "\n" +
                "-- Vendas Não Faturadas\n" +
                "select \n" +
                "            ped.codfilial           as codfilial\n" +
                "           ,to_date('')             as dtemissao\n" +
                "           ,to_date('')             as dtentrada  \n" +
                "           ,to_date('')             as datacancel\n" +
                "           ,ped.numnota             as numnota\n" +
                "           ,ped.codcli              as codparceiro\n" +
                "           ,cl.cliente              as razaosocial\n" +
                "           ,decode(cl.tipofj,'J',regexp_replace(LPAD(cl.cgcent, 18),'([0-9]{2})([0-9]{3})([0-9]{3})([0-9]{4})','\\1.\\2.\\3/\\4-'),\n" +
                "                              'F',regexp_replace(LPAD('00000000191', 14),'([0-9]{3})([0-9]{3})([0-9]{3})','\\1.\\2.\\3-')) \n" +
                "                                    as cpfcnpj\n" +
                "           ,ramo.ramo              as ramo    \n" +
                "           ,ped.data               as dataped\n" +
                "           ,ped.numped             as pedido\n" +
                "           ,ped.codusur            as codrca    \n" +
                "           ,usur.nome              as rca\n" +
                "           ,ped.codsupervisor      as codsuperv\n" +
                "           ,superv.nome            as supervisor \n" +
                "           ,nvl(prod.codinterno,prod.codprod) as codinterno\n" +
                "           ,prod.codfab            as codfab\n" +
                "           ,prod.codauxiliar       as ean\n" +
                "           ,prod.descricao         as descricao\n" +
                "           ,est.valorultent        as custo\n" +
                "           ,item.ptabela           as precobruto\n" +
                "           ,item.ptabela-item.pvenda  as desconto\n" +
                "           ,item.pvenda            as precoliq\n" +
                "           ,item.qt                as quantidade\n" +
                "           ,(item.qt*item.ptabela) as totprecobruto\n" +
                "           ,(item.qt*item.pvenda)  as totprecoliq\n" +
                "           ,to_number('')          as codfiscal\n" +
                "           ,depto.descricao        as departamento\n" +
                "           ,secao.descricao        as secao\n" +
                "           ,cat.categoria          as categoria\n" +
                "           ,ped.posicao            as posicao\n" +
                "           ,'V'                    as operacao                  \n" +
                "           ,prod.pesoliq           as pesoliqunit\n" +
                "from        pcpedc ped\n" +
                "join        pcpedi item\n" +
                "on          ped.numped = item.numped\n" +
                "join        pcclient cl\n" +
                "on          ped.codcli = cl.codcli\n" +
                "join        pcativi ramo\n" +
                "on          cl.codatv1 = ramo.codativ\n" +
                "left join   pcusuari usur\n" +
                "on          ped.codusur = usur.codusur\n" +
                "left join   pcsuperv superv\n" +
                "on          ped.codsupervisor = superv.codsupervisor\n" +
                "join        pcprodut prod\n" +
                "on          item.codprod = prod.codprod\n" +
                "join         pcdepto depto\n" +
                "on           prod.codepto = depto.codepto\n" +
                "join         pcsecao secao\n" +
                "on           prod.codsec = secao.codsec\n" +
                "             and prod.codepto = secao.codepto                   \n" +
                "join         pccategoria cat\n" +
                "on           prod.codcategoria = cat.codcategoria\n" +
                "             and prod.codsec = cat.codsec                       \n" +
                "join        pcest est\n" +
                "on          prod.codprod = est.codprod\n" +
                "and         ped.codfilial = est.codfilial\n" +
                "where       ped.posicao not in ('F','C')\n" +
                "and         ped.condvenda NOT IN (13,10)\n" +
                "and         ped.data between :dataini and :datafim\n" +
                "and         ped.codfilial in (1)\n" +
                "\n" +
                "\n" +
                "union all\n" +
                "\n" +
                "-- Entradas de Compras\n" +
                "\n" +
                "select\n" +
                "            ent.codfilial               as codfilial\n" +
                "           ,ent.dtemissao               as dtemissao\n" +
                "           ,ent.dtent                   as dtentrada \n" +
                "           ,ent.dtcancel                as datacancel\n" +
                "           ,ent.numnota                 as numnota\n" +
                "           ,ent.codfornec               as codparceiro\n" +
                "           ,ent.fornecedor              as razaosocial\n" +
                "           ,decode(fr.tipopessoa,'J',regexp_replace(LPAD(ent.cgc, 18),'([0-9]{2})([0-9]{3})([0-9]{3})([0-9]{4})','\\1.\\2.\\3/\\4-'),\n" +
                "                              'F',regexp_replace(LPAD('00000000191', 14),'([0-9]{3})([0-9]{3})([0-9]{3})','\\1.\\2.\\3-')) \n" +
                "                                        as cpfcnpj\n" +
                "           ,''                          as ramo\n" +
                "           ,ped.dtemissao               as dataped         \n" +
                "           ,ped.numped                  as numped      \n" +
                "           ,to_number('')               as codusur\n" +
                "           ,''                          as rca\n" +
                "           ,to_number('')               as codsuperv\n" +
                "           ,''                          as supervisor      \n" +
                "           ,nvl(prod.codinterno,prod.codprod) as codinterno\n" +
                "           ,prod.codfab                 as codfab\n" +
                "           ,prod.codauxiliar            as ean\n" +
                "           ,prod.descricao              as descricao\n" +
                "           ,est.valorultent             as custo\n" +
                "           ,to_number('')               as precobruto\n" +
                "           ,to_number('')               as desconto\n" +
                "           ,mov.punit                   as precoliq\n" +
                "           ,mov.qt                      as quantidade\n" +
                "           ,to_number('')               as totprecobruto\n" +
                "           ,(mov.qt*mov.punit)          as totprecoliq\n" +
                "           ,mov.codfiscal               as cfop\n" +
                "           ,depto.descricao             as departamento\n" +
                "           ,secao.descricao             as secao\n" +
                "           ,cat.categoria               as categoria\n" +
                "           ,''                          as posicao\n" +
                "           ,'E'                         as operacao\n" +
                "           ,prod.pesoliq                as pesoliqunit\n" +
                "from        pcnfent ent\n" +
                "join        pcmov mov\n" +
                "on          ent.numtransent = mov.numtransent\n" +
                "join        pcfornec fr\n" +
                "on          ent.codfornec = fr.codfornec\n" +
                "join        pcpedido ped\n" +
                "on          mov.numped = ped.numped\n" +
                "join        pcprodut prod\n" +
                "on          mov.codprod = prod.codprod\n" +
                "join         pcdepto depto\n" +
                "on           prod.codepto = depto.codepto\n" +
                "join         pcsecao secao\n" +
                "on           prod.codsec = secao.codsec\n" +
                "             and prod.codepto = secao.codepto                    \n" +
                "join         pccategoria cat\n" +
                "on           prod.codcategoria = cat.codcategoria\n" +
                "             and prod.codsec = cat.codsec                        \n" +
                "join        pcest est\n" +
                "on          prod.codprod = est.codprod\n" +
                "and         ent.codfilial = est.codfilial\n" +
                "and         ent.codfilial in (1)\n" +
                "and         ent.dtemissao between :dataini and :datafim\n" +
                "and         mov.qt > 0\n" +
                "\n" +
                "\n" +
                "union all\n" +
                "\n" +
                "-- Devoluções\n" +
                "\n" +
                "select\n" +
                "            ent.codfilial           as codfilial\n" +
                "           ,ent.dtemissao           as dtemissao\n" +
                "           ,ent.dtent               as dtentrada \n" +
                "           ,ent.dtcancel            as datacancel\n" +
                "           ,ent.numnota             as numnota\n" +
                "           ,ent.codfornec           as codparceiro\n" +
                "           ,ent.fornecedor          as razaosocial\n" +
                "           ,decode(cl.tipofj,'J',regexp_replace(LPAD(ent.cgc, 18),'([0-9]{2})([0-9]{3})([0-9]{3})([0-9]{4})','\\1.\\2.\\3/\\4-'),\n" +
                "                              'F',regexp_replace(LPAD('00000000191', 14),'([0-9]{3})([0-9]{3})([0-9]{3})','\\1.\\2.\\3-')) \n" +
                "                                    as cpfcnpj\n" +
                "           ,ramo.ramo               as ramo                  \n" +
                "           ,to_date('')             as dataped\n" +
                "           ,to_number('')           as pedido\n" +
                "           ,ent.codusurdevol        as codrca   \n" +
                "           ,usur.nome               as rca\n" +
                "           ,usur.codsupervisor      as codsuperv\n" +
                "           ,superv.nome             as supervisor  \n" +
                "           ,nvl(prod.codinterno,prod.codprod) as codinterno\n" +
                "           ,prod.codfab             as codfab\n" +
                "           ,prod.codauxiliar        as ean\n" +
                "           ,prod.descricao          as descricao\n" +
                "           ,est.valorultent         as custo\n" +
                "           ,to_number('')           as precobruto\n" +
                "           ,to_number('')           as desconto\n" +
                "           ,mov.punit               as precoliq\n" +
                "           ,mov.qt                  as quantidade\n" +
                "           ,to_number('')           as totprecobruto\n" +
                "           ,(mov.qt*mov.punit)      as totprecoliq\n" +
                "           ,mov.codfiscal           as cfop\n" +
                "           ,depto.descricao         as departamento\n" +
                "           ,secao.descricao         as secao\n" +
                "           ,cat.categoria           as categoria\n" +
                "           ,''                      as posicao\n" +
                "           ,'ED'                    as operacao                           \n" +
                "            ,prod.pesoliq           as pesoliqunit\n" +
                "from        pcnfent ent\n" +
                "join        pcmov mov\n" +
                "on          ent.numtransent = mov.numtransent\n" +
                "join        pcclient cl\n" +
                "on          ent.codfornec = cl.codcli\n" +
                "join        pcativi ramo\n" +
                "on          cl.codatv1 = ramo.codativ\n" +
                "left join   pcusuari usur\n" +
                "on          ent.codusurdevol = usur.codusur\n" +
                "left join   pcsuperv superv\n" +
                "on          usur.codsupervisor = superv.codsupervisor\n" +
                "join        pcprodut prod\n" +
                "on          mov.codprod = prod.codprod\n" +
                "join         pcdepto depto\n" +
                "on           prod.codepto = depto.codepto\n" +
                "join         pcsecao secao\n" +
                "on           prod.codsec = secao.codsec\n" +
                "             and prod.codepto = secao.codepto                    \n" +
                "join         pccategoria cat\n" +
                "on           prod.codcategoria = cat.codcategoria\n" +
                "             and prod.codsec = cat.codsec                      \n" +
                "join        pcest est\n" +
                "on          prod.codprod = est.codprod\n" +
                "and         ent.codfilial = est.codfilial\n" +
                "where       mov.codoper = 'ED'\n" +
                "and         mov.qt > 0\n" +
                "and         ent.codfilial in (1)\n" +
                "and         ent.dtemissao between :dataini and :datafim\n" +
                " )       \n" +
                "order by     codfilial, operacao, dataped, pedido, descricao";

        sql = sql.replace(":dtini", "?").replace(":dtfin", "?");

        try (Connection conn = ConnectionFactory.obtemConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDate(1, Date.valueOf(LocalDate.now().withDayOfMonth(1)));
            stmt.setDate(2, Date.valueOf(LocalDate.now()));
            stmt.setDate(3, Date.valueOf(LocalDate.now().withDayOfMonth(1)));
            stmt.setDate(4, Date.valueOf(LocalDate.now()));
            stmt.setDate(5, Date.valueOf(LocalDate.now().withDayOfMonth(1)));
            stmt.setDate(6, Date.valueOf(LocalDate.now()));
            stmt.setDate(7, Date.valueOf(LocalDate.now().withDayOfMonth(1)));
            stmt.setDate(8, Date.valueOf(LocalDate.now()));

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                PedidosAFaturar pedidosAFaturar = new PedidosAFaturar(
                        rs.getInt("Filial"),
                        rs.getDate("Data Emissão"),
                        rs.getDate("Data Entrada"),
                        rs.getDate("Data Cancelamento"),
                        rs.getInt("N° Nota"),
                        rs.getInt("Cód. Parceiro"),
                        rs.getString("Razão Social"),
                        rs.getString("CPF/CNPJ"),
                        rs.getString("Ramo"),
                        rs.getDate("Data Pedido"),
                        rs.getLong("N° Pedido"),
                        rs.getInt("Cód. Vendedor"),
                        rs.getString("Vendedor"),
                        rs.getInt("Cód. Supervisor"),
                        rs.getString("Supervisor"),
                        rs.getInt("Cód. Produto"),
                        rs.getInt("Cód. Fábrica"),
                        rs.getBigDecimal("Cód. Barras") != null ? rs.getBigDecimal("Cód. Barras").toBigInteger() : BigInteger.valueOf(0),
                        rs.getString("Descrição"),
                        rs.getDouble("Vl. Custo"),
                        rs.getDouble("Preço Tabela"),
                        rs.getDouble("Vl. Desconto"),
                        rs.getDouble("Preço Venda"),
                        rs.getInt("Qtde"),
                        rs.getDouble("Tot. Preço Tabela"),
                        rs.getDouble("Total Venda"),
                        rs.getInt("CFOP"),
                        rs.getString("Departamento"),
                        rs.getString("Seção"),
                        rs.getString("Categoria"),
                        rs.getString("Operação"),
                        rs.getString("Posição"),
                        rs.getDouble("Peso Liquido Unitario")
                );
                listaPedidosAFaturar.add(pedidosAFaturar);
            }
        }
        return listaPedidosAFaturar;
    }
}
