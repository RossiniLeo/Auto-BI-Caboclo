package Model;

import java.util.Date;

public class Justificativas {
    private int CodUsur;
    private String Vendedor;
    private int CodCli;
    private String Cliente;
    private Date Data;
    private String Justificativa;
    private String Tipo;

    public Justificativas(int codUsur, String vendedor, int codCli, String cliente, Date data, String justificativa, String tipo) {
        CodUsur = codUsur;
        Vendedor = vendedor;
        CodCli = codCli;
        Cliente = cliente;
        Data = data;
        Justificativa = justificativa;
        Tipo = tipo;
    }

    public int getCodUsur() {
        return CodUsur;
    }

    public void setCodUsur(int codUsur) {
        CodUsur = codUsur;
    }

    public String getVendedor() {
        return Vendedor;
    }

    public void setVendedor(String vendedor) {
        Vendedor = vendedor;
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

    public Date getData() {
        return Data;
    }

    public void setData(Date data) {
        Data = data;
    }

    public String getJustificativa() {
        return Justificativa;
    }

    public void setJustificativa(String justificativa) {
        Justificativa = justificativa;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    @Override
    public String toString() {
        return "Justificativas{" +
                "CodUsur=" + CodUsur +
                ", Vendedor='" + Vendedor + '\'' +
                ", CodCli=" + CodCli +
                ", Cliente='" + Cliente + '\'' +
                ", Data=" + Data +
                ", Justificativa='" + Justificativa + '\'' +
                ", Tipo='" + Tipo + '\'' +
                '}';
    }
}
