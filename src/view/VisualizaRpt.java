/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.BancoSql;
import java.sql.Connection;
import java.util.Map;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author otavi
 */
public class VisualizaRpt {
    public static void GeraRelatorio(String arquivoRpt, Map parameter, String titulo) throws Exception{
        try{
        Connection conn = BancoSql.getConnection();
        JasperPrint jp = JasperFillManager.fillReport("src/view/reports/" + arquivoRpt , parameter, conn);
        JasperViewer viewer = new JasperViewer(jp, false);
        viewer.setTitle(titulo);
        viewer.setVisible(true);
        }
        catch(java.lang.NoClassDefFoundError ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}
