package Model;

import java.util.Date;

public class Cliente {
    private String CGCENT;
    private int TipoFJ;
    private String Cliente;
    private int CodRede;
    private String Descricao;
    private String Fantasia;
    private int CodCliente;
    private Date DataUltAlter;
    private String IEENT;
    private Date DataCadastro;
    private int CodAtv1;
    private String Ramo;
    private Date DataUltComp;
    private String EstENT;
    private int CodFilialNF;
    private String TelCelENT;
    private String PredioProprio;
    private int CodCidade;
    private int CodPraca;
    private String Praca;
    private String Email;
    private String EnderENT;
    private int NumeroENT;
    private String BairroENT;
    private String MunicENT;
    private String CEPENT;
    private String Observacao;
    private String Bloqueio;
    private Date DataBloq;
    private int CodUsur1;
    private int CodUsur2;
    private String MotivoExclusao;
    private String MotivoBloq;

    public Cliente(String CGCENT, int tipoFJ, String cliente, int codRede, String descricao, String fantasia, int codCliente, Date dataUltAlter, String IEENT, Date dataCadastro, int codAtv1, String ramo, Date dataUltComp, String estENT, int codFilialNF, String telCelENT, String predioProprio, int codCidade, int codPraca, String praca, String email, String enderENT, int numeroENT, String bairroENT, String municENT, String CEPENT, String observacao, String bloqueio, Date dataBloq, int codUsur1, int codUsur2, String motivoExclusao, String motivoBloq) {
        this.CGCENT = CGCENT;
        TipoFJ = tipoFJ;
        Cliente = cliente;
        CodRede = codRede;
        Descricao = descricao;
        Fantasia = fantasia;
        CodCliente = codCliente;
        DataUltAlter = dataUltAlter;
        this.IEENT = IEENT;
        DataCadastro = dataCadastro;
        CodAtv1 = codAtv1;
        Ramo = ramo;
        DataUltComp = dataUltComp;
        EstENT = estENT;
        CodFilialNF = codFilialNF;
        TelCelENT = telCelENT;
        PredioProprio = predioProprio;
        CodCidade = codCidade;
        CodPraca = codPraca;
        Praca = praca;
        Email = email;
        EnderENT = enderENT;
        NumeroENT = numeroENT;
        BairroENT = bairroENT;
        MunicENT = municENT;
        this.CEPENT = CEPENT;
        Observacao = observacao;
        Bloqueio = bloqueio;
        DataBloq = dataBloq;
        CodUsur1 = codUsur1;
        CodUsur2 = codUsur2;
        MotivoExclusao = motivoExclusao;
        MotivoBloq = motivoBloq;
    }

    public String getCGCENT() {
        return CGCENT;
    }

    public void setCGCENT(String CGCENT) {
        this.CGCENT = CGCENT;
    }

    public int getTipoFJ() {
        return TipoFJ;
    }

    public void setTipoFJ(int tipoFJ) {
        TipoFJ = tipoFJ;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String cliente) {
        Cliente = cliente;
    }

    public int getCodRede() {
        return CodRede;
    }

    public void setCodRede(int codRede) {
        CodRede = codRede;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public String getFantasia() {
        return Fantasia;
    }

    public void setFantasia(String fantasia) {
        Fantasia = fantasia;
    }

    public int getCodCliente() {
        return CodCliente;
    }

    public void setCodCliente(int codCliente) {
        CodCliente = codCliente;
    }

    public Date getDataUltAlter() {
        return DataUltAlter;
    }

    public void setDataUltAlter(Date dataUltAlter) {
        DataUltAlter = dataUltAlter;
    }

    public String getIEENT() {
        return IEENT;
    }

    public void setIEENT(String IEENT) {
        this.IEENT = IEENT;
    }

    public Date getDataCadastro() {
        return DataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        DataCadastro = dataCadastro;
    }

    public int getCodAtv1() {
        return CodAtv1;
    }

    public void setCodAtv1(int codAtv1) {
        CodAtv1 = codAtv1;
    }

    public String getRamo() {
        return Ramo;
    }

    public void setRamo(String ramo) {
        Ramo = ramo;
    }

    public Date getDataUltComp() {
        return DataUltComp;
    }

    public void setDataUltComp(Date dataUltComp) {
        DataUltComp = dataUltComp;
    }

    public String getEstENT() {
        return EstENT;
    }

    public void setEstENT(String estENT) {
        EstENT = estENT;
    }

    public int getCodFilialNF() {
        return CodFilialNF;
    }

    public void setCodFilialNF(int codFilialNF) {
        CodFilialNF = codFilialNF;
    }

    public String getTelCelENT() {
        return TelCelENT;
    }

    public void setTelCelENT(String telCelENT) {
        TelCelENT = telCelENT;
    }

    public String getPredioProprio() {
        return PredioProprio;
    }

    public void setPredioProprio(String predioProprio) {
        PredioProprio = predioProprio;
    }

    public int getCodCidade() {
        return CodCidade;
    }

    public void setCodCidade(int codCidade) {
        CodCidade = codCidade;
    }

    public int getCodPraca() {
        return CodPraca;
    }

    public void setCodPraca(int codPraca) {
        CodPraca = codPraca;
    }

    public String getPraca() {
        return Praca;
    }

    public void setPraca(String praca) {
        Praca = praca;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getEnderENT() {
        return EnderENT;
    }

    public void setEnderENT(String enderENT) {
        EnderENT = enderENT;
    }

    public int getNumeroENT() {
        return NumeroENT;
    }

    public void setNumeroENT(int numeroENT) {
        NumeroENT = numeroENT;
    }

    public String getBairroENT() {
        return BairroENT;
    }

    public void setBairroENT(String bairroENT) {
        BairroENT = bairroENT;
    }

    public String getMunicENT() {
        return MunicENT;
    }

    public void setMunicENT(String municENT) {
        MunicENT = municENT;
    }

    public String getCEPENT() {
        return CEPENT;
    }

    public void setCEPENT(String CEPENT) {
        this.CEPENT = CEPENT;
    }

    public String getObservacao() {
        return Observacao;
    }

    public void setObservacao(String observacao) {
        Observacao = observacao;
    }

    public String getBloqueio() {
        return Bloqueio;
    }

    public void setBloqueio(String bloqueio) {
        Bloqueio = bloqueio;
    }

    public Date getDataBloq() {
        return DataBloq;
    }

    public void setDataBloq(Date dataBloq) {
        DataBloq = dataBloq;
    }

    public int getCodUsur1() {
        return CodUsur1;
    }

    public void setCodUsur1(int codUsur1) {
        CodUsur1 = codUsur1;
    }

    public int getCodUsur2() {
        return CodUsur2;
    }

    public void setCodUsur2(int codUsur2) {
        CodUsur2 = codUsur2;
    }

    public String getMotivoExclusao() {
        return MotivoExclusao;
    }

    public void setMotivoExclusao(String motivoExclusao) {
        MotivoExclusao = motivoExclusao;
    }

    public String getMotivoBloq() {
        return MotivoBloq;
    }

    public void setMotivoBloq(String motivoBloq) {
        MotivoBloq = motivoBloq;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "CGCENT='" + CGCENT + '\'' +
                ", TipoFJ=" + TipoFJ +
                ", Cliente='" + Cliente + '\'' +
                ", CodRede=" + CodRede +
                ", Descricao='" + Descricao + '\'' +
                ", Fantasia='" + Fantasia + '\'' +
                ", CodCliente=" + CodCliente +
                ", DataUltAlter=" + DataUltAlter +
                ", IEENT='" + IEENT + '\'' +
                ", DataCadastro=" + DataCadastro +
                ", CodAtv1=" + CodAtv1 +
                ", Ramo=" + Ramo +
                ", DataUltComp=" + DataUltComp +
                ", EstENT='" + EstENT + '\'' +
                ", CodFilialNF=" + CodFilialNF +
                ", TelCelENT='" + TelCelENT + '\'' +
                ", PredioProprio='" + PredioProprio + '\'' +
                ", CodCidade=" + CodCidade +
                ", CodPraca=" + CodPraca +
                ", Praca='" + Praca + '\'' +
                ", Email='" + Email + '\'' +
                ", EnderENT='" + EnderENT + '\'' +
                ", NumeroENT=" + NumeroENT +
                ", BairroENT='" + BairroENT + '\'' +
                ", MunicENT='" + MunicENT + '\'' +
                ", CEPENT='" + CEPENT + '\'' +
                ", Observacao='" + Observacao + '\'' +
                ", Bloqueio='" + Bloqueio + '\'' +
                ", DataBloq=" + DataBloq +
                ", CodUsur1=" + CodUsur1 +
                ", CodUsur2=" + CodUsur2 +
                ", MotivoExclusao='" + MotivoExclusao + '\'' +
                ", MotivoBloq='" + MotivoBloq + '\'' +
                '}';
    }
}
