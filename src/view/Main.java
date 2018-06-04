/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author otavi
 */
public class Main {
    public static void main(String[] args) {
        SplashCode frmSplash = new SplashCode(3);
        try{
            WindowsLookAndFeel windows = new WindowsLookAndFeel();
            UIManager.setLookAndFeel(windows);
            SwingUtilities.updateComponentTreeUI(frmSplash);
            frmSplash.ShowSplashAndExit();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Erro ao inicializar","Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
