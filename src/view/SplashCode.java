/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JWindow;

/**
 *
 * @author otavi
 */
public class SplashCode extends JWindow {

    private int duration;

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration * 1000;
    }

    public SplashCode(int duration) {
        setDuration(duration);
    }

    public void ShowSplash() {
        JPanel content = (JPanel) getContentPane();
        content.setBackground(Color.WHITE);

        int width = 500;
        int height = 300;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

        int x = (screen.width - width) / 2;
        int y = (screen.height - height) / 2;

        setBounds(x, y, width, height);

        JLabel label = new JLabel(new ImageIcon("src/imagens/ninja_gainden_face.jpg"));
        JLabel copyrt = new JLabel("Exemplo splash", JLabel.CENTER);
        label.setSize(x / 2, y / 2);
        copyrt.setFont(new Font("Sans-Serif", Font.BOLD, 12));
        content.add(copyrt, BorderLayout.CENTER);
        content.add(label, BorderLayout.SOUTH);
        Color oraRed = new Color(165, 20, 20, 255);
        content.setBorder(BorderFactory.createLineBorder(oraRed, 5));
        setVisible(true);
        try{
            Thread.sleep(getDuration());
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Ocorreu um erro: "+ ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        setVisible(false);
    }
    public void ShowSplashAndExit() throws Exception{
        ShowSplash();
        FrmMenu frmMenu = new FrmMenu();
        try{
            frmMenu.setVisible(true);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Ocorreu um erro: "+ ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            throw ex;
        }
        this.dispose();
    }

}
