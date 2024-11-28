package controlador;

import Vista.frmIngresoCorreo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import java.util.UUID;
import modelo.Credenciales;
import modelo.EnviarCorreo;


public class ctrlIngresoCorreo implements MouseListener{
    
    private Credenciales modelo;
    private frmIngresoCorreo vista;
    
    public ctrlIngresoCorreo(Credenciales modelo, frmIngresoCorreo vista){
        this.modelo = modelo;
        this.vista = vista;
        
        vista.btnEnviarCodigo.addMouseListener(this);
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource() == vista.btnEnviarCodigo){
        
             Random random = new Random();
        
        // Genera un número aleatorio de 4 dígitos (1000 a 9999)
            int numeroAleatorio = 1000 + random.nextInt(9000);

            String recipient = vista.txtCorreo.getText();
            String subject = "Recuperacion de contraseña";
            String content = "Este es el codigo de recuperacion" + numeroAleatorio;

            EnviarCorreo.enviarCorreo(recipient, subject, content);

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
