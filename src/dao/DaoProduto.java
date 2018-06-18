package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import models.Produto;

/**
 *
 * @author otavi
 */
public class DaoProduto extends Produto {

    private Connection conexao;
    private PreparedStatement comandoSql;
    private Date data;

    @Override
    public void Incluir() throws SQLException, ClassNotFoundException {
        String sql = "Insert into pc_produto ("
                + "descricao, quantidade, precounit) "
                + "values (?, ?, ?)";
        this.conexao = BancoSql.getConnection();
        comandoSql = conexao.prepareStatement(sql);
        comandoSql.setString(1, this.getDescricao());
        comandoSql.setInt(2, this.getQuantidade());
        comandoSql.setDouble(3, this.getPrecoUnit());
        comandoSql.execute();
        comandoSql.close();
        this.conexao.close();

    }

    @Override
    public void Alterar() throws SQLException, ClassNotFoundException {
        String sql = "Update pc_produto set "
                + "descricao = ?, "
                + "quantidade = ?, "
                + "precounit = ? "
                + "where cod_pro = ?";
        this.conexao = BancoSql.getConnection();
        comandoSql = conexao.prepareStatement(sql);
        comandoSql.setString(1, this.getDescricao());
        comandoSql.setInt(2, this.getQuantidade());
        comandoSql.setDouble(3, this.getPrecoUnit());
        comandoSql.setInt(4, this.getCodProd());
        comandoSql.execute();
        comandoSql.close();
        this.conexao.close();
    }
    @Override
    public boolean Excluir() throws SQLException, ClassNotFoundException{
        String sql = "Delete from pc_produto "
                + "where cod_pro = ?";
        try{
            this.conexao = BancoSql.getConnection();
        comandoSql = conexao.prepareStatement(sql);
        comandoSql.setInt(1, this.getCodProd());
        boolean apagou = comandoSql.execute();
        comandoSql.close();
        this.conexao.close();
        return apagou;
        }catch(SQLException | ClassNotFoundException ex){
            throw ex;
        }
    }
    public ArrayList<DaoProduto> Pesquisar(DaoProduto produto) throws SQLException, ClassNotFoundException{
        DaoProduto produtoRetorno;
        String sql = "Select * from pc_produto where descricao like ?";
        ArrayList<DaoProduto> listaProduto = new ArrayList<DaoProduto>();
        this.conexao= BancoSql.getConnection();
        comandoSql = conexao.prepareStatement(sql);
        
        comandoSql.setString(1, "%" + this.getDescricao() + "%");
        ResultSet rs = comandoSql.executeQuery();
        while (rs.next()) {            
            produtoRetorno = new DaoProduto();
            produtoRetorno.setCodProd(rs.getInt("cod_pro"));
            produtoRetorno.setDescricao(rs.getString("descricao"));
            produtoRetorno.setQuantidade(rs.getInt("quantidade"));
            produtoRetorno.setPrecoUnit(rs.getDouble("precounit"));
            listaProduto.add(produtoRetorno);
        }
        rs.close();
        comandoSql.close();
        this.conexao.close();
        return listaProduto;
    }
    public ArrayList<DaoProduto> Pesquisar() throws SQLException, ClassNotFoundException{
        DaoProduto produtoRetorno;
        String sql = "Select * from pc_produto";
        ArrayList<DaoProduto> listaProduto = new ArrayList<DaoProduto>();
        this.conexao= BancoSql.getConnection();
        comandoSql = conexao.prepareStatement(sql);
        
        ResultSet rs = comandoSql.executeQuery();
        while (rs.next()) {            
            produtoRetorno = new DaoProduto();
            produtoRetorno.setCodProd(rs.getInt("cod_pro"));
            produtoRetorno.setDescricao(rs.getString("descricao"));
            produtoRetorno.setQuantidade(rs.getInt("quantidade"));
            produtoRetorno.setPrecoUnit(rs.getDouble("precounit"));
            listaProduto.add(produtoRetorno);
        }
        rs.close();
        comandoSql.close();
        this.conexao.close();
        return listaProduto;
    } 
}
