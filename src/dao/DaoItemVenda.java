/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;
import java.util.ArrayList;
import models.ItemVenda;

/**
 *
 * @author ManutencaoEtec
 */
public class DaoItemVenda extends ItemVenda {

    private Connection conexao;
    private PreparedStatement comandoSQL;
    private Date data;

    @Override
    public void Incluir() throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO pc_itemvenda "
                + "(numVenda, cod_pro, quantidade, precounit) "
                + " VALUES "
                + "(?, ?, ?, ?) ";
        this.conexao = BancoSql.getConnection();
        comandoSQL = conexao.prepareStatement(sql);
        comandoSQL.setInt(1, getNumVenda());
        comandoSQL.setInt(2, getCodPro());
        comandoSQL.setInt(3, getQuantidade());
        comandoSQL.setDouble(4, getPrecoUnit());
        comandoSQL.execute();
        comandoSQL.close();
        this.conexao.close();
    }

    @Override
    public void Alterar() throws SQLException, ClassNotFoundException {
        String sql = "update pc_itemvenda SET "
                + "cod_pro = ?, "
                + "quantidade = ?, "
                + "prcounit = ?, "
                + "WHERE numVenda = ? ";
        this.conexao = BancoSql.getConnection();
        comandoSQL = conexao.prepareStatement(sql);
        comandoSQL.setInt(1, this.getCodPro());
        comandoSQL.setInt(2, this.getQuantidade());
        comandoSQL.setDouble(3, this.getPrecoUnit());
        comandoSQL.setInt(4, this.getNumVenda());
        comandoSQL.execute();
        comandoSQL.close();
        this.conexao.close();
    }

    @Override
    public boolean Excluir() throws SQLException, ClassNotFoundException {
        String sql = "Delete from pc_itemvenda "
                + "where numvenda = ?";
        this.conexao = BancoSql.getConnection();
        comandoSQL = conexao.prepareStatement(sql);
        comandoSQL.setInt(1, this.getNumVenda());
        boolean apagou = comandoSQL.execute();
        comandoSQL.close();
        this.conexao.close();
        return apagou;
    }

    public ArrayList<DaoItemVenda> Pesquisar(DaoItemVenda item) throws SQLException, ClassNotFoundException {
        DaoItemVenda itemRetorno;
        String sql;
        if (item.getCodPro() > 0) {
            sql = "Select numVenda, pc_itemvenda.cod_pro, pc_produto.descricao, "
                    + "pc_itemvenda.quantidade, pc_itemvenda.precounit, "
                    + "(pc_itemvenda.quantidade * pc_itemvenda.precounit) as subtotal "
                    + "from pc_itemvenda inner join pc_produto on pc_produto.cod_pro = pc_itemvenda.cod_pro "
                    + "where pc_itemvenda.numvenda = ? and pc_itemvenda.cod_pro = ?";
        } else {
            sql = "Select numVenda, pc_itemvenda.cod_pro, pc_produto.descricao, "
                    + "pc_itemvenda.quantidade, pc_itemvenda.precounit, "
                    + "(pc_itemvenda.quantidade * pc_itemvenda.precounit) as subtotal "
                    + "from pc_itemvenda inner join pc_produto on pc_produto.cod_pro = pc_itemvenda.cod_pro "
                    + "where pc_itemvenda.numvenda = ?";
        }
        ArrayList<DaoItemVenda> listaItens = new ArrayList<DaoItemVenda>();

        this.conexao = BancoSql.getConnection();
        comandoSQL = conexao.prepareStatement(sql);
        if (item.getCodPro() > 0) {
            comandoSQL.setInt(1, item.getNumVenda());
            comandoSQL.setInt(2, item.getCodPro());
        } else {
            comandoSQL.setInt(1, item.getNumVenda());
        }
        ResultSet rs = comandoSQL.executeQuery();
        while (rs.next()) {
            itemRetorno = new DaoItemVenda();
            itemRetorno.setNumVenda(rs.getInt("numvenda"));
            itemRetorno.setCodPro(rs.getInt("cod_pro"));
            itemRetorno.setDescricao(rs.getString("descricao"));
            itemRetorno.setQuantidade(rs.getInt("quantidade"));
            itemRetorno.setPrecoUnit(rs.getDouble("precounit"));
            itemRetorno.setSubtotal(rs.getDouble("subtotal"));

            listaItens.add(itemRetorno);
        }
        rs.close();
        comandoSQL.close();
        this.conexao.close();
        return listaItens;
    }

    @Override
    public String toString() {
        return String.format(
                "Venda: %s\ncodPro: %s\n"
                + "Descricao: %s\nPrecoUnit: %s\nQuantidade: %s\nSubtotal: %s", 
                getNumVenda(), getCodPro(), getDescricao(), getPrecoUnit(), getQuantidade(), getSubtotal());
    }
    
}
