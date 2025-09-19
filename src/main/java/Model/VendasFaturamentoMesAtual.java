package Model;

import java.util.Date;

public class VendasFaturamentoMesAtual {

    private Date DTMov;
    private int NumNota;
    private String CodOper;
    private String Status;
    private int CodCli;
    private String Cliente;
    private String CGCENT;
    private int CodUsur;
    private String Nome;
    private int CodSupervisor;
    private int CodProd;
    private String Descricao;
    private int CodFornec;
    private int CodFiscal;
    private int QT;
    private double PUNIT;
    private double VendaTot;
    private double CustoReal;
    private double CustoTot;
    private String Depto;

    public Date getDTMov() {
        return DTMov;
    }

    public void setDTMov(Date DTMov) {
        this.DTMov = DTMov;
    }

    public int getNumNota() {
        return NumNota;
    }

    public void setNumNota(int numNota) {
        NumNota = numNota;
    }

    public String getCodOper() {
        return CodOper;
    }

    public void setCodOper(String codOper) {
        CodOper = codOper;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public int getCodCli() {
        return CodCli;
    }

    public void setCodCli(int codCli) {
        CodCli = codCli;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String cliente) {
        Cliente = cliente;
    }

    public String getCGCENT() {
        return CGCENT;
    }

    public void setCGCENT(String CGCENT) {
        this.CGCENT = CGCENT;
    }

    public int getCodUsur() {
        return CodUsur;
    }

    public void setCodUsur(int codUsur) {
        CodUsur = codUsur;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public int getCodSupervisor() {
        return CodSupervisor;
    }

    public void setCodSupervisor(int codSupervisor) {
        CodSupervisor = codSupervisor;
    }

    public int getCodProd() {
        return CodProd;
    }

    public void setCodProd(int codProd) {
        CodProd = codProd;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public int getCodFornec() {
        return CodFornec;
    }

    public void setCodFornec(int codFornec) {
        CodFornec = codFornec;
    }

    public int getCodFiscal() {
        return CodFiscal;
    }

    public void setCodFiscal(int codFiscal) {
        CodFiscal = codFiscal;
    }

    public int getQT() {
        return QT;
    }

    public void setQT(int QT) {
        this.QT = QT;
    }

    public double getPUNIT() {
        return PUNIT;
    }

    public void setPUNIT(double PUNIT) {
        this.PUNIT = PUNIT;
    }

    public double getVendaTot() {
        return VendaTot;
    }

    public void setVendaTot(double vendaTot) {
        VendaTot = vendaTot;
    }

    public double getCustoReal() {
        return CustoReal;
    }

    public void setCustoReal(double custoReal) {
        CustoReal = custoReal;
    }

    public double getCustoTot() {
        return CustoTot;
    }

    public void setCustoTot(double custoTot) {
        CustoTot = custoTot;
    }

    public String getDepto() {
        return Depto;
    }

    public void setDepto(String depto) {
        Depto = depto;
    }

    public VendasFaturamentoMesAtual(Date DTMov, int numNota, String codOper, String status, int codCli, String cliente, String CGCENT, int codUsur, String nome, int codSupervisor, int codProd, String descricao, int codFornec, int codFiscal, int QT, double PUNIT, double vendaTot, double custoReal, double custoTot, String depto) {
        this.DTMov = DTMov;
        NumNota = numNota;
        CodOper = codOper;
        Status = status;
        CodCli = codCli;
        Cliente = cliente;
        this.CGCENT = CGCENT;
        CodUsur = codUsur;
        Nome = nome;
        CodSupervisor = codSupervisor;
        CodProd = codProd;
        Descricao = descricao;
        CodFornec = codFornec;
        CodFiscal = codFiscal;
        this.QT = QT;
        this.PUNIT = PUNIT;
        VendaTot = vendaTot;
        CustoReal = custoReal;
        CustoTot = custoTot;
        Depto = depto;
    }

    @Override
    public String toString() {
        return "VendasFaturamentoMesAtual{" +
                "DTMov=" + DTMov +
                ", NumNota=" + NumNota +
                ", CodOper='" + CodOper + '\'' +
                ", Status='" + Status + '\'' +
                ", CodCli=" + CodCli +
                ", Cliente='" + Cliente + '\'' +
                ", CGCENT='" + CGCENT + '\'' +
                ", CodUsur=" + CodUsur +
                ", Nome='" + Nome + '\'' +
                ", CodSupervisor=" + CodSupervisor +
                ", CodProd=" + CodProd +
                ", Descricao='" + Descricao + '\'' +
                ", CodFornec=" + CodFornec +
                ", CodFiscal=" + CodFiscal +
                ", QT=" + QT +
                ", PUNIT=" + PUNIT +
                ", VendaTot=" + VendaTot +
                ", CustoReal=" + CustoReal +
                ", CustoTot=" + CustoTot +
                ", Depto='" + Depto + '\'' +
                '}';
    }
}
