package models;
import java.sql.SQLException;
import java.util.Date;
/**
 *
 * @author ManutencaoEtec
 */
public abstract class Venda implements IMetodosPadrao{
    private int numVenda;
    private int codCli;
    private String nome;
    private Date dataVenda;
    private Date dataEntrega;
    private String obs;

    public int getNumVenda() {
        return numVenda;
    }

    public void setNumVenda(int numVenda) {
        this.numVenda = numVenda;
    }

    public int getCodCli() {
        return codCli;
    }

    public void setCodCli(int codCli) {
        this.codCli = codCli;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Venda(int numVenda, int codCli, String nome, Date dataVenda, Date dataEntrega, String obs) {
        this.numVenda = numVenda;
        this.codCli = codCli;
        this.nome = nome;
        this.dataVenda = dataVenda;
        this.dataEntrega = dataEntrega;
        this.obs = obs;
    }
    public Venda(){
        this(0,0,"",new Date(), new Date(), "");
    }
    @Override
    public String toString() {
        return String.format("Venda: %s"
                + "\nNúmero da Venda: %s"
                + "\nCódigo do Cliente: %s"
                + "\nNome do Cliente: %s"
                + "\ndata da Venda: %s"
                + "\ndata da Entrega: %s"
                + "\nObs: %s\n",
                numVenda, codCli, nome, dataVenda, dataEntrega, obs);
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
