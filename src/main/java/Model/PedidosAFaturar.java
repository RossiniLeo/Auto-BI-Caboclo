package Model;

import java.math.BigInteger;
import java.util.Date;

public class PedidosAFaturar {
    private int Filial;
    private Date DataEmissao;
    private Date DataEntrada;
    private Date DataCancelamento;
    private int NumNota;
    private int CodParceiro;
    private String RazaoSocial;
    private String CPF_CNPJ;
    private String Ramo;
    private Date DataPedido;
    private long NumPedido;
    private int CodVendedor;
    private String Vendedor;
    private int CodSupervisor;
    private String Supervisor;
    private int CodProduto;
    private int CodFabrica;
    private BigInteger CodBarras;
    private String Descricao;
    private double ValorCusto;
    private double PrecoTabela;
    private double ValorDesconto;
    private double PrecoVenda;
    private int Quantidade;
    private double TotalPrecoTabela;
    private double TotalVenda;
    private int CFOP;
    private String Departamento;
    private String Secao;
    private String Categoria;
    private String Operacao;
    private String Posicao;
    private double PesoLiquido;

    public PedidosAFaturar(int filial, Date dataEmissao, Date dataEntrada, Date dataCancelamento, int numNota, int codParceiro, String razaoSocial, String CPF_CNPJ, String ramo, Date dataPedido, long numPedido, int codVendedor, String vendedor, int codSupervisor, String supervisor, int codProduto, int codFabrica, BigInteger codBarras, String descricao, double valorCusto, double precoTabela, double valorDesconto, double precoVenda, int quantidade, double totalPrecoTabela, double totalVenda, int CFOP, String departamento, String secao, String categoria, String operacao, String posicao, double pesoLiquido) {
        Filial = filial;
        DataEmissao = dataEmissao;
        DataEntrada = dataEntrada;
        DataCancelamento = dataCancelamento;
        NumNota = numNota;
        CodParceiro = codParceiro;
        RazaoSocial = razaoSocial;
        this.CPF_CNPJ = CPF_CNPJ;
        Ramo = ramo;
        DataPedido = dataPedido;
        NumPedido = numPedido;
        CodVendedor = codVendedor;
        Vendedor = vendedor;
        CodSupervisor = codSupervisor;
        Supervisor = supervisor;
        CodProduto = codProduto;
        CodFabrica = codFabrica;
        CodBarras = codBarras;
        Descricao = descricao;
        ValorCusto = valorCusto;
        PrecoTabela = precoTabela;
        ValorDesconto = valorDesconto;
        PrecoVenda = precoVenda;
        Quantidade = quantidade;
        TotalPrecoTabela = totalPrecoTabela;
        TotalVenda = totalVenda;
        this.CFOP = CFOP;
        Departamento = departamento;
        Secao = secao;
        Categoria = categoria;
        Operacao = operacao;
        Posicao = posicao;
        PesoLiquido = pesoLiquido;
    }

    public int getFilial() {
        return Filial;
    }

    public void setFilial(int filial) {
        Filial = filial;
    }

    public Date getDataEmissao() {
        return DataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        DataEmissao = dataEmissao;
    }

    public Date getDataEntrada() {
        return DataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        DataEntrada = dataEntrada;
    }

    public Date getDataCancelamento() {
        return DataCancelamento;
    }

    public void setDataCancelamento(Date dataCancelamento) {
        DataCancelamento = dataCancelamento;
    }

    public int getNumNota() {
        return NumNota;
    }

    public void setNumNota(int numNota) {
        NumNota = numNota;
    }

    public int getCodParceiro() {
        return CodParceiro;
    }

    public void setCodParceiro(int codParceiro) {
        CodParceiro = codParceiro;
    }

    public String getRazaoSocial() {
        return RazaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        RazaoSocial = razaoSocial;
    }

    public String getCPF_CNPJ() {
        return CPF_CNPJ;
    }

    public void setCPF_CNPJ(String CPF_CNPJ) {
        this.CPF_CNPJ = CPF_CNPJ;
    }

    public String getRamo() {
        return Ramo;
    }

    public void setRamo(String ramo) {
        Ramo = ramo;
    }

    public Date getDataPedido() {
        return DataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        DataPedido = dataPedido;
    }

    public long getNumPedido() {
        return NumPedido;
    }

    public void setNumPedido(long numPedido) {
        NumPedido = numPedido;
    }

    public int getCodVendedor() {
        return CodVendedor;
    }

    public void setCodVendedor(int codVendedor) {
        CodVendedor = codVendedor;
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

    public String getSupervisor() {
        return Supervisor;
    }

    public void setSupervisor(String supervisor) {
        Supervisor = supervisor;
    }

    public int getCodProduto() {
        return CodProduto;
    }

    public void setCodProduto(int codProduto) {
        CodProduto = codProduto;
    }

    public int getCodFabrica() {
        return CodFabrica;
    }

    public void setCodFabrica(int codFabrica) {
        CodFabrica = codFabrica;
    }

    public BigInteger getCodBarras() {
        return CodBarras;
    }

    public void setCodBarras(BigInteger codBarras) {
        CodBarras = codBarras;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public double getValorCusto() {
        return ValorCusto;
    }

    public void setValorCusto(double valorCusto) {
        ValorCusto = valorCusto;
    }

    public double getPrecoTabela() {
        return PrecoTabela;
    }

    public void setPrecoTabela(double precoTabela) {
        PrecoTabela = precoTabela;
    }

    public double getValorDesconto() {
        return ValorDesconto;
    }

    public void setValorDesconto(double valorDesconto) {
        ValorDesconto = valorDesconto;
    }

    public double getPrecoVenda() {
        return PrecoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        PrecoVenda = precoVenda;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int quantidade) {
        Quantidade = quantidade;
    }

    public double getTotalPrecoTabela() {
        return TotalPrecoTabela;
    }

    public void setTotalPrecoTabela(double totalPrecoTabela) {
        TotalPrecoTabela = totalPrecoTabela;
    }

    public double getTotalVenda() {
        return TotalVenda;
    }

    public void setTotalVenda(double totalVenda) {
        TotalVenda = totalVenda;
    }

    public int getCFOP() {
        return CFOP;
    }

    public void setCFOP(int CFOP) {
        this.CFOP = CFOP;
    }

    public String getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(String departamento) {
        Departamento = departamento;
    }

    public String getSecao() {
        return Secao;
    }

    public void setSecao(String secao) {
        Secao = secao;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public String getOperacao() {
        return Operacao;
    }

    public void setOperacao(String operacao) {
        Operacao = operacao;
    }

    public String getPosicao() {
        return Posicao;
    }

    public void setPosicao(String posicao) {
        Posicao = posicao;
    }

    public double getPesoLiquido() {
        return PesoLiquido;
    }

    public void setPesoLiquido(double pesoLiquido) {
        PesoLiquido = pesoLiquido;
    }

    @Override
    public String toString() {
        return "PedidosAFaturar{" +
                "Filial=" + Filial +
                ", DataEmissao=" + DataEmissao +
                ", DataEntrada=" + DataEntrada +
                ", DataCancelamento=" + DataCancelamento +
                ", NumNota=" + NumNota +
                ", CodParceiro=" + CodParceiro +
                ", RazaoSocial='" + RazaoSocial + '\'' +
                ", CPF_CNPJ='" + CPF_CNPJ + '\'' +
                ", Ramo='" + Ramo + '\'' +
                ", DataPedido=" + DataPedido +
                ", NumPedido=" + NumPedido +
                ", CodVendedor=" + CodVendedor +
                ", Vendedor='" + Vendedor + '\'' +
                ", CodSupervisor=" + CodSupervisor +
                ", Supervisor='" + Supervisor + '\'' +
                ", CodProduto=" + CodProduto +
                ", CodFabrica=" + CodFabrica +
                ", CodBarras=" + CodBarras +
                ", Descricao='" + Descricao + '\'' +
                ", ValorCusto=" + ValorCusto +
                ", PrecoTabela=" + PrecoTabela +
                ", ValorDesconto=" + ValorDesconto +
                ", PrecoVenda=" + PrecoVenda +
                ", Quantidade=" + Quantidade +
                ", TotalPrecoTabela=" + TotalPrecoTabela +
                ", TotalVenda=" + TotalVenda +
                ", CFOP=" + CFOP +
                ", Departamento='" + Departamento + '\'' +
                ", Secao='" + Secao + '\'' +
                ", Categoria='" + Categoria + '\'' +
                ", Operacao='" + Operacao + '\'' +
                ", Posicao='" + Posicao + '\'' +
                ", PesoLiquido=" + PesoLiquido +
                '}';
    }
}
