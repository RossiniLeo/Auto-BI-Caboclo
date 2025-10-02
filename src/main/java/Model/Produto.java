package Model;

import java.math.BigInteger;
import java.util.Date;

public class Produto {
    private int CodProduto;
    private String Descricao;
    private int CodFornecedor;
    private String Fornecedor;
    private int CoDepto;
    private String Descricao_1;
    private int CodSec;
    private String Descricao_2;
    private int CodMarca;
    private String Marca;
    private int CodCategoria;
    private String Categoria;
    private String Embalagem;
    private double PesoLiq;
    private double PesoBruto;
    private int NBM;
    private BigInteger CodAuxiliar;
    private BigInteger CodAuxiliar2;
    private String CodFab;
    private String OBS2;
    private Date DataExclusao;
    private Date DataUltAlter;
    private Date DataCadastro;

    public int getCodProduto() {
        return CodProduto;
    }

    public void setCodProduto(int codProduto) {
        CodProduto = codProduto;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public int getCodFornecedor() {
        return CodFornecedor;
    }

    public void setCodFornecedor(int codFornecedor) {
        CodFornecedor = codFornecedor;
    }

    public String getFornecedor() {
        return Fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        Fornecedor = fornecedor;
    }

    public int getCoDepto() {
        return CoDepto;
    }

    public void setCoDepto(int coDepto) {
        CoDepto = coDepto;
    }

    public String getDescricao_1() {
        return Descricao_1;
    }

    public void setDescricao_1(String descricao_1) {
        Descricao_1 = descricao_1;
    }

    public int getCodSec() {
        return CodSec;
    }

    public void setCodSec(int codSec) {
        CodSec = codSec;
    }

    public String getDescricao_2() {
        return Descricao_2;
    }

    public void setDescricao_2(String descricao_2) {
        Descricao_2 = descricao_2;
    }

    public int getCodMarca() {
        return CodMarca;
    }

    public void setCodMarca(int codMarca) {
        CodMarca = codMarca;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public int getCodCategoria() {
        return CodCategoria;
    }

    public void setCodCategoria(int codCategoria) {
        CodCategoria = codCategoria;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public String getEmbalagem() {
        return Embalagem;
    }

    public void setEmbalagem(String embalagem) {
        Embalagem = embalagem;
    }

    public double getPesoLiq() {
        return PesoLiq;
    }

    public void setPesoLiq(double pesoLiq) {
        PesoLiq = pesoLiq;
    }

    public double getPesoBruto() {
        return PesoBruto;
    }

    public void setPesoBruto(double pesoBruto) {
        PesoBruto = pesoBruto;
    }

    public int getNBM() {
        return NBM;
    }

    public void setNBM(int NBM) {
        this.NBM = NBM;
    }

    public BigInteger getCodAuxiliar() {
        return CodAuxiliar;
    }

    public void setCodAuxiliar(BigInteger codAuxiliar) {
        CodAuxiliar = codAuxiliar;
    }

    public BigInteger getCodAuxiliar2() {
        return CodAuxiliar2;
    }

    public void setCodAuxiliar2(BigInteger codAuxiliar2) {
        CodAuxiliar2 = codAuxiliar2;
    }

    public String getCodFab() {
        return CodFab;
    }

    public void setCodFab(String codFab) {
        CodFab = codFab;
    }

    public String getOBS2() {
        return OBS2;
    }

    public void setOBS2(String OBS2) {
        this.OBS2 = OBS2;
    }

    public Date getDataExclusao() {
        return DataExclusao;
    }

    public void setDataExclusao(Date dataExclusao) {
        DataExclusao = dataExclusao;
    }

    public Date getDataUltAlter() {
        return DataUltAlter;
    }

    public void setDataUltAlter(Date dataUltAlter) {
        DataUltAlter = dataUltAlter;
    }

    public Date getDataCadastro() {
        return DataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        DataCadastro = dataCadastro;
    }

    public Produto(int codProduto, String descricao, int codFornecedor, String fornecedor, int coDepto, String descricao_1, int codSec, String descricao_2, int codMarca, String marca, int codCategoria, String categoria, String embalagem, double pesoLiq, double pesoBruto, int NBM, BigInteger codAuxiliar, BigInteger codAuxiliar2, String codFab, String OBS2, Date dataExclusao, Date dataUltAlter, Date dataCadastro) {
        CodProduto = codProduto;
        Descricao = descricao;
        CodFornecedor = codFornecedor;
        Fornecedor = fornecedor;
        CoDepto = coDepto;
        Descricao_1 = descricao_1;
        CodSec = codSec;
        Descricao_2 = descricao_2;
        CodMarca = codMarca;
        Marca = marca;
        CodCategoria = codCategoria;
        Categoria = categoria;
        Embalagem = embalagem;
        PesoLiq = pesoLiq;
        PesoBruto = pesoBruto;
        this.NBM = NBM;
        CodAuxiliar = codAuxiliar;
        CodAuxiliar2 = codAuxiliar2;
        CodFab = codFab;
        this.OBS2 = OBS2;
        DataExclusao = dataExclusao;
        DataUltAlter = dataUltAlter;
        DataCadastro = dataCadastro;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "CodProduto=" + CodProduto +
                ", Descricao='" + Descricao + '\'' +
                ", CodFornecedor=" + CodFornecedor +
                ", Fornecedor='" + Fornecedor + '\'' +
                ", CoDepto=" + CoDepto +
                ", Descricao_1='" + Descricao_1 + '\'' +
                ", CodSec=" + CodSec +
                ", Descricao_2='" + Descricao_2 + '\'' +
                ", CodMarca=" + CodMarca +
                ", Marca='" + Marca + '\'' +
                ", CodCategoria=" + CodCategoria +
                ", Categoria='" + Categoria + '\'' +
                ", Embalagem='" + Embalagem + '\'' +
                ", PesoLiq=" + PesoLiq +
                ", PesoBruto=" + PesoBruto +
                ", NBM=" + NBM +
                ", CodAuxiliar=" + CodAuxiliar +
                ", CodAuxiliar2=" + CodAuxiliar2 +
                ", CodFab=" + CodFab +
                ", OBS2='" + OBS2 + '\'' +
                ", DataExclusao=" + DataExclusao +
                ", DataUltAlter=" + DataUltAlter +
                ", DataCadastro=" + DataCadastro +
                '}';
    }
}
