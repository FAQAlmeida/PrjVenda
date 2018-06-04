package models;

import java.sql.SQLException;

/**
 *
 * @author ManutencaoEtec
 */
public interface IMetodosPadrao {
    public void Incluir() throws SQLException, ClassNotFoundException;
    public void Alterar() throws SQLException, ClassNotFoundException;
    public boolean Excluir() throws SQLException, ClassNotFoundException;
}
