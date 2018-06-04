/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.text.ParseException;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author otavi
 */
public class FormatRpt {
    public static String FormatCep(String valor) throws ParseException{
        MaskFormatter mfCep = new MaskFormatter("#####-###");
        mfCep.setPlaceholderCharacter('_');
        mfCep.setValueContainsLiteralCharacters(false);
        mfCep.setValueClass(String.class);
        return mfCep.valueToString(valor);
    }
    public static String FormatTelefone(String valor) throws ParseException{
        MaskFormatter mfTel = new MaskFormatter("(##)#####-####");
        mfTel.setPlaceholderCharacter('_');
        mfTel.setValueContainsLiteralCharacters(false);
        mfTel.setValueClass(String.class);
        return mfTel.valueToString(valor);
    }
}
