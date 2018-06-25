package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import models.Venda;

/**
 *
 * @author otavi
 */
public class DaoVenda extends Venda {

    private Connection conexao;
    private PreparedStatement comandoSql;
    private Date data;

    @Override
    public void Incluir() throws SQLException, ClassNotFoundException {
        String sql = "set dateformat dmy Insert into pc_venda "
                + "(codcli, datavenda, dataEntrega, obs) "
                + "values "
                + "(?,?,?,?) ";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        this.conexao = BancoSql.getConnection();
        comandoSql = conexao.prepareStatement(sql);
        comandoSql.setInt(1, this.getCodCli());
        comandoSql.setString(2, sdf.format(this.getDataVenda()));
        comandoSql.setString(3, sdf.format(this.getDataEntrega()));
        comandoSql.setString(4, this.getObs());

        comandoSql.execute();
        comandoSql.close();
        this.conexao.close();

    }

    @Override
    public void Alterar() throws SQLException, ClassNotFoundException {
        String sql = "set dateformat dmy update pc_venda set "
                + "codcli = ?, "
                + "datavenda = ?, "
                + "dataEntrega = ?, "
                + "obs = ? "
                + "where numVenda = ? ";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        this.conexao = BancoSql.getConnection();
        comandoSql = conexao.prepareStatement(sql);
        comandoSql.setInt(1, this.getCodCli());
        comandoSql.setString(2, sdf.format(this.getDataVenda()));
        comandoSql.setString(3, sdf.format(this.getDataEntrega()));
        comandoSql.setString(4, this.getObs());
        comandoSql.setInt(5, this.getNumVenda());
        comandoSql.execute();
        comandoSql.close();
        this.conexao.close();

    }
    @Override
    public boolean Excluir() throws SQLException, ClassNotFoundException {
        String sql = "Delete from pc_venda "
                + "where numvenda = ?";
        this.conexao = BancoSql.getConnection();
        comandoSql = conexao.prepareStatement(sql);
        comandoSql.setInt(1, this.getNumVenda());
        boolean apagou = comandoSql.execute();
        comandoSql.close();
        this.conexao.close();
        return apagou;
    }
    public ArrayList<DaoVenda> Pesquisar(DaoVenda venda) throws SQLException, ClassNotFoundException {
        DaoVenda vendaRetorno;
        String sql;
        
        if(venda.getNumVenda() > 0){
            sql = "set dateformat dmy select numVenda, pc_venda.codcli, nome, datavenda, dataentrega, obs "
                    + "from pc_venda inner join pc_clientes on pc_venda.codcli = pc_clientes.codcli "
                    + "where numvenda = ?";
        }else{
            sql = "set dateformat dmy select numVenda, pc_venda.codcli, nome, datavenda, dataentrega, obs "
                    + "from pc_venda inner join pc_clientes on pc_venda.codcli = pc_clientes.codcli ";
        }

        ArrayList<DaoVenda> listavendas = new ArrayList<DaoVenda>();

        this.conexao = BancoSql.getConnection();
        comandoSql = conexao.prepareStatement(sql);
        if(venda.getNumVenda() > 0){
            comandoSql.setInt(1, venda.getNumVenda());
        }
        ResultSet rs = comandoSql.executeQuery();
        
        while (rs.next()) {            
            vendaRetorno = new DaoVenda();
            vendaRetorno.setNumVenda(rs.getInt("NUMVenda"));
            vendaRetorno.setCodCli(rs.getInt("codcli"));
            vendaRetorno.setNome(rs.getString("NOME"));
            vendaRetorno.setDataVenda(rs.getDate("datavenda"));
            vendaRetorno.setDataEntrega(rs.getDate("dataentrega"));
            vendaRetorno.setObs(rs.getString("obs"));
            
            listavendas.add(vendaRetorno);
        }
        rs.close();
        this.comandoSql.close();
        return listavendas;
    }
}
