package models;

import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author ManutencaoEtec
 */
public abstract class Cliente implements IMetodosPadrao {

    private int codCli;
    private String Nome;
    private String Endereco;
    private String Cidade;
    private String Bairro;
    private String Uf;
    private String Cep;
    private String Telefone;
    private Date DataNasc;

    public Cliente() {
        this(0, "", "", "", "", "", "", "", new Date());
    }

    public int getCodCli() {
        return codCli;
    }

    public void setCodCli(int codCli) {
        this.codCli = codCli;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String Bairro) {
        this.Bairro = Bairro;
    }

    public Cliente(int codCli, String Nome, String Endereco, String Cidade, String Bairro, String Uf, String Cep, String Telefone, Date DataNasc) {
        this.codCli = codCli;
        this.Nome = Nome;
        this.Endereco = Endereco;
        this.Cidade = Cidade;
        this.Bairro = Bairro;
        this.Uf = Uf;
        this.Cep = Cep;
        this.Telefone = Telefone;
        this.DataNasc = DataNasc;
    }

    public String getUf() {
        return Uf;
    }

    public void setUf(String Uf) {
        this.Uf = Uf;
    }

    public String getCep() {
        return Cep;
    }

    public void setCep(String Cep) {
        this.Cep = Cep;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public Date getDataNasc() {
        return DataNasc;
    }

    public void setDataNasc(Date DataNasc) {
        this.DataNasc = DataNasc;
    }

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
