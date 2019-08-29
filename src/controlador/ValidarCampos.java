/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author javam2019
 */
public class ValidarCampos {
    
    public void validarSoloLetras(JTextField campo){
        campo.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c= e.getKeyChar();
                if(Character.isDigit(c)){
                    e.consume();
                }
            }
        });
    }
    
    public void validarSoloNumeros(JTextField campo, int longitud){
        campo.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                int caracteres= campo.getText().length();
                char c= e.getKeyChar();
                if(!Character.isDigit(c)){
                    e.consume();
                }
                
                if(caracteres>=longitud){
                    e.consume();
                }
            }
        });
    }
}
