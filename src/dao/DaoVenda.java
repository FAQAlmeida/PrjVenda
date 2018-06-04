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
        String sql = "set dateforma dmy Inset into pc_venda "
                + "(numvenda, cod_cli, datavenda, dataEntrega, obs) "
                + "values "
                + "(?,?,?,?,?) ";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        this.conexao = BancoSql.getConnection();
        comandoSql = conexao.prepareStatement(sql);
        comandoSql.setInt(1, this.getNumVenda());
        comandoSql.setInt(2, this.getCodCli());
        comandoSql.setString(3, sdf.format(this.getDataVenda()));
        comandoSql.setString(4, sdf.format(this.getDataEntrega()));
        comandoSql.setString(5, this.getObs());

        comandoSql.execute();
        comandoSql.close();
        this.conexao.close();

    }

    @Override
    public void Alterar() throws SQLException, ClassNotFoundException {
        String sql = "set dateforma dmy update pc_venda "
                + "cod_cli = ?, "
                + "datavenda = ?, "
                + "dataEntrega = ?, "
                + "obs = ?, "
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
            sql = "set dateformat dmy select numVenda, pc_venda.cod_cli, nome, datavenda, dataentrega, obs "
                    + "from pc_venda inner join pc_clientes on pc_venda.cod_cli = pc_clientes.cod_cli "
                    + "where numvenda = ?";
        }else{
            sql = "set dateformat dmy select numVenda, pc_venda.cod_cli, nome, datavenda, dataentrega, obs "
                    + "from pc_venda inner join pc_clientes on pc_venda.cod_cli = pc_clientes.cod_cli ";
        }

        ArrayList<DaoVenda> listavendas = new ArrayList<DaoVenda>();

        this.conexao = BancoSql.getConnection();
        comandoSql = conexao.prepareStatement(sql);
        if(venda.getNumVenda() > 0){
            comandoSql.setString(1, "%" + venda.getNome() + "%");
        }
        ResultSet rs = comandoSql.executeQuery();
        
        while (rs.next()) {            
            vendaRetorno = new DaoVenda();
            vendaRetorno.setNumVenda(rs.getInt("NUMVenda"));
            vendaRetorno.setCodCli(rs.getInt("cod_cli"));
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
