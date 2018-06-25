package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import models.Cliente;

/**
 *
 * @author ManutencaoEtec
 */
public class DaoCliente extends Cliente {

    private Connection conexao;
    private PreparedStatement comandoSql;
    private Date data;

    @Override
    public void Incluir() throws SQLException, ClassNotFoundException {
        //Note que as ? são parâmetros
        // Set date format só funciona no SQL Server
        String sql = "set dateformat dmy INSERT INTO pc_clientes("
                + "Nome, Endereco, Cidade, Bairro, "
                + "UF, CEP, telefone, DataNasc) VALUES "
                + "(?,?,?,?,?,?,?,?)";
        //Usando o método static criado em BancoSQL
        this.conexao = BancoSql.getConnection();
        //Aplicando a instrução sql no PreparedStatement
        comandoSql = conexao.prepareStatement(sql);
        //Preechendo os Parâmetros
        comandoSql.setString(1, this.getNome());
        comandoSql.setString(2, this.getEndereco());
        comandoSql.setString(3, this.getCidade());
        comandoSql.setString(4, this.getBairro());
        comandoSql.setString(5, this.getUf());
        comandoSql.setString(6, this.getCep());
        comandoSql.setString(7, this.getTelefone());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        data = new Date(getDataNasc().getTime());
        comandoSql.setString(8, sdf.format(data));
        comandoSql.execute();
        comandoSql.close();
        this.conexao.close();
    }

    @Override
    public void Alterar() throws SQLException, ClassNotFoundException {
        String sql = "set dateformat dmy "
                + "Update pc_clientes Set "
                + "NOME=?, "
                + "Endereco=?, "
                + "Cidade=?, "
                + "Bairro=?, "
                + "UF=?, "
                + "CEP=?, "
                + "telefone=?, "
                + "DataNasc=? "
                + "where CodCli = ?";
        this.conexao = BancoSql.getConnection();
        comandoSql = conexao.prepareStatement(sql);
        comandoSql.setString(1, this.getNome());
        comandoSql.setString(2, this.getEndereco());
        comandoSql.setString(3, this.getCidade());
        comandoSql.setString(4, this.getBairro());
        comandoSql.setString(5, this.getUf());
        comandoSql.setString(6, this.getCep());
        comandoSql.setString(7, this.getTelefone());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        data = new Date(getDataNasc().getTime());
        comandoSql.setString(8, sdf.format(data));
        //O CodCli é o ultimo, pois está na cláusula "where" no final da instrução SQL
        comandoSql.setInt(9, this.getCodCli());
        comandoSql.execute();
        comandoSql.close();
        this.conexao.close();

    }

    @Override
    public boolean Excluir() throws SQLException, ClassNotFoundException {
        //Note que o bloco --try--catch é desnecessário, pois as excessôes já são lançadas na cláusula 'throws' na assinatura do método
        try {
            String sql = "Delete from pc_clientes "
                    + "where codCLi = ?";
            this.conexao = BancoSql.getConnection();
            comandoSql = conexao.prepareStatement(sql);
            comandoSql.setInt(1, this.getCodCli());
            boolean apagou = comandoSql.execute();
            comandoSql.close();
            this.conexao.close();
            return apagou;
        } catch (SQLException ex) {
            throw ex;
        } catch (ClassNotFoundException ex) {
            throw ex;
        }
    }

    public ArrayList<DaoCliente> Pesquisar(DaoCliente cliente) throws SQLException, ClassNotFoundException {
        DaoCliente clienteRetorno;
        String sql = "Select * from pc_clientes where nome like ?";

        ArrayList<DaoCliente> listaClientes = new ArrayList<DaoCliente>();

        this.conexao = BancoSql.getConnection();
        comandoSql = conexao.prepareStatement(sql);

        comandoSql.setString(1, "%" + cliente.getNome() + "%");
        
        ResultSet rs = comandoSql.executeQuery();
        
        while (rs.next()) {            
            clienteRetorno = new DaoCliente();
            clienteRetorno.setCodCli(rs.getInt("CODCLI"));
            clienteRetorno.setNome(rs.getString("NOME"));
            clienteRetorno.setEndereco(rs.getString("ENDERECO"));
            clienteRetorno.setCidade(rs.getString("CIDADE"));
            clienteRetorno.setBairro(rs.getString("BAIRRO"));
            clienteRetorno.setUf(rs.getString("UF"));
            clienteRetorno.setCep(rs.getString("CEP"));
            clienteRetorno.setTelefone(rs.getString("TELEFONE"));
            clienteRetorno.setDataNasc(rs.getDate("DATANASC"));
            
            listaClientes.add(clienteRetorno);
        }
        rs.close();
        this.comandoSql.close();
        return listaClientes;
    }
    public ArrayList<DaoCliente> Pesquisar() throws SQLException, ClassNotFoundException {
        DaoCliente clienteRetorno;
        String sql = "Select * from pc_clientes";

        ArrayList<DaoCliente> listaClientes = new ArrayList<DaoCliente>();

        this.conexao = BancoSql.getConnection();
        comandoSql = conexao.prepareStatement(sql);

        
        ResultSet rs = comandoSql.executeQuery();
        
        while (rs.next()) {            
            clienteRetorno = new DaoCliente();
            clienteRetorno.setCodCli(rs.getInt("CODCLI"));
            clienteRetorno.setNome(rs.getString("NOME"));
            clienteRetorno.setEndereco(rs.getString("ENDERECO"));
            clienteRetorno.setCidade(rs.getString("CIDADE"));
            clienteRetorno.setBairro(rs.getString("BAIRRO"));
            clienteRetorno.setUf(rs.getString("UF"));
            clienteRetorno.setCep(rs.getString("CEP"));
            clienteRetorno.setTelefone(rs.getString("TELEFONE"));
            clienteRetorno.setDataNasc(rs.getDate("DATANASC"));
            
            listaClientes.add(clienteRetorno);
        }
        rs.close();
        this.comandoSql.close();
        return listaClientes;
    }
}
