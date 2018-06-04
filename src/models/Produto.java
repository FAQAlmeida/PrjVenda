package models;
 import java.sql.SQLException;
/**
 *
 * @author ManutencaoEtec
 */
public abstract class Produto implements  IMetodosPadrao {
    private int codProd;
    private String descricao;
    private int quantidade;
    public Produto () {
    this (0, "", 0,0);
    }

    public int getCodProd() {
        return codProd;
    }

    public void setCodProd(int codProd) {
        this.codProd = codProd;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoUnit() {
        return precoUnit;
    }

    public void setPrecoUnit(double precoUnit) {
        this.precoUnit = precoUnit;
    }

    public Produto(int codProd, String descricao, int quantidade, double precoUnit) {
        this.codProd = codProd;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.precoUnit = precoUnit;
    }
    private double precoUnit;

    @Override
    public void Incluir() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Alterar() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Excluir() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
