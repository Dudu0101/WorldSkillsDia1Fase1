package controlador;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

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
