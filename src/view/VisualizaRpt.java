/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.BancoSql;
import java.sql.Connection;
import java.util.Map;

/**
 *
 * @author otavi
 */
public class VisualizaRpt {
    public static void GeraRelatorio(String arquivoRpt, Map parameter, String titulo) throws Exception{
        Connection conn = BancoSql.getConnection();
        //JasperPrint jp = JasperFillManager.fillReport("src/view/reports/" + arquivoRpt , parameter, conn);
        //JasperView viewer = new JasperViewer(jp, false);
        //viewer.setTitle(titulo);
        //viewer.setVisible(true);
    }
}
