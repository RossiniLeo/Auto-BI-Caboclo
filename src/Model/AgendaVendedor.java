package Model;

public class AgendaVendedor {

    private int CodCliente;
    private String Cliente;
    private String CGCENT;
    private int CodRede;
    private String Rede;
    private int CodPraca;
    private int CodATV1;
    private String Ramo;
    private String EnderecoENT;
    private String Numero;
    private int CEPENT;
    private String BairroENT;
    private String MunicipioENT;
    private String EstadoENT;
    private String TelefoneENT;
    private String Bloqueio;
    private String FormaPG;
    private int CodPG;
    private String DataBloqueio;
    private String DataUltimaCompra;
    private int CodRCA;
    private String Vendedor;
    private int CodSupervisor;
    private String DataProxVisita;
    private String DiaSemanaVisita;
    private int PeriodicidadeVisita;
    private int SequenciaVisita;

    public AgendaVendedor(int codCliente, String cliente, String CGCENT, int codRede, String rede, int codPraca, int codATV1, String ramo, String enderecoENT, String numero, int CEPENT, String bairroENT, String municipioENT, String estadoENT, String telefoneENT, String bloqueio, String formaPG, int codPG, String dataBloqueio, String dataUltimaCompra, int codRCA, String vendedor, int codSupervisor, String dataProxVisita, String diaSemanaVisita, int periodicidadeVisita, int sequenciaVisita) {
        CodCliente = codCliente;
        Cliente = cliente;
        this.CGCENT = CGCENT;
        CodRede = codRede;
        Rede = rede;
        CodPraca = codPraca;
        CodATV1 = codATV1;
        Ramo = ramo;
        EnderecoENT = enderecoENT;
        Numero = numero;
        this.CEPENT = CEPENT;
        BairroENT = bairroENT;
        MunicipioENT = municipioENT;
        EstadoENT = estadoENT;
        TelefoneENT = telefoneENT;
        Bloqueio = bloqueio;
        FormaPG = formaPG;
        CodPG = codPG;
        DataBloqueio = dataBloqueio;
        DataUltimaCompra = dataUltimaCompra;
        CodRCA = codRCA;
        Vendedor = vendedor;
        CodSupervisor = codSupervisor;
        DataProxVisita = dataProxVisita;
        DiaSemanaVisita = diaSemanaVisita;
        PeriodicidadeVisita = periodicidadeVisita;
        SequenciaVisita = sequenciaVisita;
    }

    public int getCodCliente() {
        return CodCliente;
    }

    public void setCodCliente(int codCliente) {
        CodCliente = codCliente;
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

    public int getCodRede() {
        return CodRede;
    }

    public void setCodRede(int codRede) {
        CodRede = codRede;
    }

    public String getRede() {
        return Rede;
    }

    public void setRede(String rede) {
        Rede = rede;
    }

    public int getCodPraca() {
        return CodPraca;
    }

    public void setCodPraca(int codPraca) {
        CodPraca = codPraca;
    }

    public int getCodATV1() {
        return CodATV1;
    }

    public void setCodATV1(int codATV1) {
        CodATV1 = codATV1;
    }

    public String getRamo() {
        return Ramo;
    }

    public void setRamo(String ramo) {
        Ramo = ramo;
    }

    public String getEnderecoENT() {
        return EnderecoENT;
    }

    public void setEnderecoENT(String enderecoENT) {
        EnderecoENT = enderecoENT;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String numero) {
        Numero = numero;
    }

    public int getCEPENT() {
        return CEPENT;
    }

    public void setCEPENT(int CEPENT) {
        this.CEPENT = CEPENT;
    }

    public String getBairroENT() {
        return BairroENT;
    }

    public void setBairroENT(String bairroENT) {
        BairroENT = bairroENT;
    }

    public String getMunicipioENT() {
        return MunicipioENT;
    }

    public void setMunicipioENT(String municipioENT) {
        MunicipioENT = municipioENT;
    }

    public String getEstadoENT() {
        return EstadoENT;
    }

    public void setEstadoENT(String estadoENT) {
        EstadoENT = estadoENT;
    }

    public String getTelefoneENT() {
        return TelefoneENT;
    }

    public void setTelefoneENT(String telefoneENT) {
        TelefoneENT = telefoneENT;
    }

    public String getBloqueio() {
        return Bloqueio;
    }

    public void setBloqueio(String bloqueio) {
        Bloqueio = bloqueio;
    }

    public String getFormaPG() {
        return FormaPG;
    }

    public void setFormaPG(String formaPG) {
        FormaPG = formaPG;
    }

    public int getCodPG() {
        return CodPG;
    }

    public void setCodPG(int codPG) {
        CodPG = codPG;
    }

    public String getDataBloqueio() {
        return DataBloqueio;
    }

    public void setDataBloqueio(String dataBloqueio) {
        DataBloqueio = dataBloqueio;
    }

    public String getDataUltimaCompra() {
        return DataUltimaCompra;
    }

    public void setDataUltimaCompra(String dataUltimaCompra) {
        DataUltimaCompra = dataUltimaCompra;
    }

    public int getCodRCA() {
        return CodRCA;
    }

    public void setCodRCA(int codRCA) {
        CodRCA = codRCA;
    }

    public String getVendedor() {
        return Vendedor;
    }

    public void setVendedor(String vendedor) {
        Vendedor = vendedor;
    }

    public int getCodSupervisor() {
        return CodSupervisor;
    }

    public void setCodSupervisor(int codSupervisor) {
        CodSupervisor = codSupervisor;
    }

    public String getDataProxVisita() {
        return DataProxVisita;
    }

    public void setDataProxVisita(String dataProxVisita) {
        DataProxVisita = dataProxVisita;
    }

    public String getDiaSemanaVisita() {
        return DiaSemanaVisita;
    }

    public void setDiaSemanaVisita(String diaSemanaVisita) {
        DiaSemanaVisita = diaSemanaVisita;
    }

    public int getPeriodicidadeVisita() {
        return PeriodicidadeVisita;
    }

    public void setPeriodicidadeVisita(int periodicidadeVisita) {
        PeriodicidadeVisita = periodicidadeVisita;
    }

    public int getSequenciaVisita() {
        return SequenciaVisita;
    }

    public void setSequenciaVisita(int sequenciaVisita) {
        SequenciaVisita = sequenciaVisita;
    }

    @Override
    public String toString() {
        return "AgendaVendedor{" +
                "CodCliente=" + CodCliente +
                ", Cliente='" + Cliente + '\'' +
                ", CGCENT='" + CGCENT + '\'' +
                ", CodRede=" + CodRede +
                ", Rede='" + Rede + '\'' +
                ", CodPraca=" + CodPraca +
                ", CodATV1=" + CodATV1 +
                ", Ramo='" + Ramo + '\'' +
                ", EnderecoENT='" + EnderecoENT + '\'' +
                ", Numero='" + Numero + '\'' +
                ", CEPENT=" + CEPENT +
                ", BairroENT='" + BairroENT + '\'' +
                ", MunicipioENT='" + MunicipioENT + '\'' +
                ", EstadoENT='" + EstadoENT + '\'' +
                ", TelefoneENT='" + TelefoneENT + '\'' +
                ", Bloqueio='" + Bloqueio + '\'' +
                ", FormaPG='" + FormaPG + '\'' +
                ", CodPG=" + CodPG +
                ", DataBloqueio='" + DataBloqueio + '\'' +
                ", DataUltimaCompra='" + DataUltimaCompra + '\'' +
                ", CodRCA=" + CodRCA +
                ", Vendedor='" + Vendedor + '\'' +
                ", CodSupervisor=" + CodSupervisor +
                ", DataProxVisita='" + DataProxVisita + '\'' +
                ", DiaSemanaVisita='" + DiaSemanaVisita + '\'' +
                ", PeriodicidadeVisita=" + PeriodicidadeVisita +
                ", SequenciaVisita=" + SequenciaVisita +
                '}';
    }
}
