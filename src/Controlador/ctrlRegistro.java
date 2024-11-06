package Controlador;

import Modelo.Usuario;
import Vista.jfrRegistro;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

public class ctrlRegistro implements MouseListener{
    
    //1-Llamar a las otras capas
    Usuario modelo;
    jfrRegistro vista;
    
    //2-Constructor 
    public ctrlRegistro(Usuario Modelo, jfrRegistro Vista){
        this.modelo = Modelo;
        this.vista = Vista;
        
        vista.btnRegistrarme.addMouseListener(this);
        vista.btnIrALogin.addMouseListener(this);
    }
    

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource() == vista.btnRegistrarme){
            modelo.setNombre(vista.txtNombre.getText());
            modelo.setCorreo(vista.txtCorreo.getText());
            modelo.setContraseña(modelo.convertirSHA256(vista.txtContraseña.getText()));
            
            modelo.GuardarUsuario();
            
            //Muestro una alerta que el usuario se ha guardado
            JOptionPane.showMessageDialog(vista, "Usuario Guardado");
        }
        
         //Clic al botón de Ir Al Login
        if(e.getSource() == vista.btnIrALogin){
            Vista.frmLogin.initFrmLogin();
            vista.dispose();
        }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
