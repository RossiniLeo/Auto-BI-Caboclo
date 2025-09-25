package Model;

import java.util.Date;

public class PedidosWinthor {
    private int numPedido;
    private int numPedidoRCA;
    private int CodUsur;
    private String Nome;
    private String CGCCli;
    private int CodCli;
    private String Cliente;
    private Date DTFechamentoPedPalm;
    private Date DTInclusao;
    private Date DTEntrega;
    private int CodFilial;
    private String CodCob;
    private int CodPlPag;
    private int CondVenda;
    private String OrigemPed;
    private String OBS1;
    private String ObservacaoPC;
    private String PosicaoAtual;
    private double VlrPedido;

    public PedidosWinthor(int numPedido, int numPedidoRCA, int codUsur, String nome, String CGCCli, int codCli, String cliente, Date DTFechamentoPedPalm, Date DTInclusao, Date DTEntrega, int codFilial, String codCob, int codPlPag, int condVenda, String origemPed, String OBS1, String observacaoPC, String posicaoAtual, double vlrPedido) {
        this.numPedido = numPedido;
        this.numPedidoRCA = numPedidoRCA;
        CodUsur = codUsur;
        Nome = nome;
        this.CGCCli = CGCCli;
        CodCli = codCli;
        Cliente = cliente;
        this.DTFechamentoPedPalm = DTFechamentoPedPalm;
        this.DTInclusao = DTInclusao;
        this.DTEntrega = DTEntrega;
        CodFilial = codFilial;
        CodCob = codCob;
        CodPlPag = codPlPag;
        CondVenda = condVenda;
        OrigemPed = origemPed;
        this.OBS1 = OBS1;
        ObservacaoPC = observacaoPC;
        PosicaoAtual = posicaoAtual;
        VlrPedido = vlrPedido;
    }

    public int getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(int numPedido) {
        this.numPedido = numPedido;
    }

    public int getNumPedidoRCA() {
        return numPedidoRCA;
    }

    public void setNumPedidoRCA(int numPedidoRCA) {
        this.numPedidoRCA = numPedidoRCA;
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

    public String getCGCCli() {
        return CGCCli;
    }

    public void setCGCCli(String CGCCli) {
        this.CGCCli = CGCCli;
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

    public Date getDTFechamentoPedPalm() {
        return DTFechamentoPedPalm;
    }

    public void setDTFechamentoPedPalm(Date DTFechamentoPedPalm) {
        this.DTFechamentoPedPalm = DTFechamentoPedPalm;
    }

    public Date getDTInclusao() {
        return DTInclusao;
    }

    public void setDTInclusao(Date DTInclusao) {
        this.DTInclusao = DTInclusao;
    }

    public Date getDTEntrega() {
        return DTEntrega;
    }

    public void setDTEntrega(Date DTEntrega) {
        this.DTEntrega = DTEntrega;
    }

    public int getCodFilial() {
        return CodFilial;
    }

    public void setCodFilial(int codFilial) {
        CodFilial = codFilial;
    }

    public String getCodCob() {
        return CodCob;
    }

    public void setCodCob(String codCob) {
        CodCob = codCob;
    }

    public int getCodPlPag() {
        return CodPlPag;
    }

    public void setCodPlPag(int codPlPag) {
        CodPlPag = codPlPag;
    }

    public int getCondVenda() {
        return CondVenda;
    }

    public void setCondVenda(int condVenda) {
        CondVenda = condVenda;
    }

    public String getOrigemPed() {
        return OrigemPed;
    }

    public void setOrigemPed(String origemPed) {
        OrigemPed = origemPed;
    }

    public String getOBS1() {
        return OBS1;
    }

    public void setOBS1(String OBS1) {
        this.OBS1 = OBS1;
    }

    public String getObservacaoPC() {
        return ObservacaoPC;
    }

    public void setObservacaoPC(String observacaoPC) {
        ObservacaoPC = observacaoPC;
    }

    public String getPosicaoAtual() {
        return PosicaoAtual;
    }

    public void setPosicaoAtual(String posicaoAtual) {
        PosicaoAtual = posicaoAtual;
    }

    public double getVlrPedido() {
        return VlrPedido;
    }

    public void setVlrPedido(double vlrPedido) {
        VlrPedido = vlrPedido;
    }

    @Override
    public String toString() {
        return "PedidosWinthor{" +
                "numPedido=" + numPedido +
                ", numPedidoRCA=" + numPedidoRCA +
                ", CodUsur=" + CodUsur +
                ", Nome='" + Nome + '\'' +
                ", CGCCli='" + CGCCli + '\'' +
                ", CodCli=" + CodCli +
                ", Cliente='" + Cliente + '\'' +
                ", DTFechamentoPedPalm=" + DTFechamentoPedPalm +
                ", DTInclusao=" + DTInclusao +
                ", DTEntrega=" + DTEntrega +
                ", CodFilial=" + CodFilial +
                ", CodCob='" + CodCob + '\'' +
                ", CodPlPag=" + CodPlPag +
                ", CondVenda=" + CondVenda +
                ", OrigemPed='" + OrigemPed + '\'' +
                ", OBS1='" + OBS1 + '\'' +
                ", ObservacaoPC='" + ObservacaoPC + '\'' +
                ", PosicaoAtual='" + PosicaoAtual + '\'' +
                ", VlrPedido=" + VlrPedido +
                '}';
    }
}
