/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * Classe de métodos úteis para gerenciamento de forms
 *
 * @author FQA
 * @author Luiz Flávio
 */
public class Util {

    /**
     * Limpa todos as linhas de uma JTable
     *
     * @param table JTable a ser limpa
     */
    public void limparTable(JTable table) {
        try{
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        while (dtm.getRowCount() > 0) {
            dtm.removeRow(0);
        } }
        catch(Exception ex){
            throw ex;
        }
        
    }

    /**
     * Define o status de habilitado de components presentes em um container
     *
     * @param status valor booleano que representará o status dos components
     * @param container container dos components
     */
    public void habilitarComponentes(boolean status, JComponent container) {
        for (Component jcomp : container.getComponents()) {
            jcomp.setEnabled(status);
        }
    }

    /**
     * Limpa todos os campos de input presentes em um container
     * <p>
     * Os components abrangidos são:
     * <blockquote>
     * <table border=1 summary="Components contidos no método">
     * <tr>
     * <th>Tipo Component</th>
     * <th>Link do Component</th>
     * </tr>
     * <tr>
     * <th>JTextField</th>
     * <th>{@link javax.swing.JTextField}</th>
     * </tr>
     * <tr>
     * <th>JTextArea</th>
     * <th>{@link javax.swing.JTextArea}</th>
     * </tr>
     * <tr>
     * <th>JComboBox</th>
     * <th>{@link javax.swing.JComboBox}</th>
     * </tr>
     * <tr>
     * <th>JFormattedTextField</th>
     * <th>{@link javax.swing.JFormattedTextField}</th>
     * </tr>
     * <tr>
     * <th>JSpinner</th>
     * <th>{@link javax.swing.JSpinner}</th>
     * </tr>
     * </table>
     * </blockquote>
     *
     * @param conteiner container dos components
     */
    public void limparCampos(JComponent conteiner) {
        for (Component jcomp : conteiner.getComponents()) {
            if (jcomp instanceof JTextField) {
                ((JTextField) jcomp).setText("");
            } else if (jcomp instanceof JTextArea) {
                ((JTextArea) jcomp).setText("");
            } else if (jcomp instanceof JComboBox) {
                if (((JComboBox) jcomp).getModel().getSize() > 0) {
                    ((JComboBox) jcomp).setSelectedIndex(0);
                }
            } else if (jcomp instanceof JFormattedTextField) {
                ((JFormattedTextField) jcomp).setText("");
            } else if (jcomp instanceof JSpinner) {
                ((JSpinner) jcomp).setValue(0);
            }
        }
    }

    /**
     * Define o status do botões presentes em um container
     * <p>
     * Os botões cancelar e gravar sempre terão status inverso
     *
     * @param status Valor booleano que representará o status dos botões
     * @param container Container dos botões
     */
    public void habilitarBotoes(boolean status, JComponent container) {
        for (Component jcomp : container.getComponents()) {
            if (jcomp instanceof JButton) {
                jcomp.setEnabled(status);
                if ((jcomp.getAccessibleContext().getAccessibleName().equals("Cancelar"))) {
                    jcomp.setEnabled(!status);
                }
                if ((jcomp.getAccessibleContext().getAccessibleName().equals("Gravar"))) {
                    jcomp.setEnabled(!status);
                }
            }
        }
    }

    /**
     * Retorna a posição de um caracter dentro de uma string
     *
     * @param character Caracter a ser buscado
     * @param text Texto no qual o caracter será buscado
     * @return Posição do caracter
     * @throws java.lang.Exception Lançado caso o caracter fornecido não exista
     * na string
     */
    public int getCharPosition(char character, String text) throws Exception {
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == character) {
                return i;
            }
        }
        throw new Exception(String.format("String não contém %s", character));
    }

    /**
     * Retorna a boolean caso um caracter pertensa a uma string
     *
     * @param character Caracter a ser buscado
     * @param text Texto no qual o caracter será buscado
     * @return Valor booleano se o caracter existe ou não na string
     */
    public boolean StringContainsChar(char character, String text) {
        char[] chars = text.toCharArray();
        for (char c : chars) {
            if (c == character) {
                return true;
            }
        }
        return false;
    }

    /**
     * Enum que determina a operação em execução no formulário no momento
     * <blockquote>
     * <table border=1 summary="Enum para determinar operações do form">
     * <tr>
     * <th>Operaçoes</th>
     * </tr>
     * <tr>
     * <th>GRAVAR</th>
     * </tr>
     * <tr>
     * <th>EDITAR</th>
     * </tr>
     * <tr>
     * <th>EXCLUIR</th>
     * </tr>
     * <tr>
     * <th>PESQUISAR</th>
     * </tr>
     * </table>
     * </blockquote>
     */
    public static enum Operacao {
        GRAVAR(1), EDITAR(2), EXCLUIR(3), PESQUISAR(4), OK(5);
        private final int valor;

        Operacao(int valorOpcao) {
            valor = valorOpcao;
        }

        public int getValor() {
            return valor;
        }
    }
}
