package Controlador;

import Modelo.Usuario;
import Vista.jfrLogin;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import Vista.jfrRegistro.initjfrRegistro();

public class ctrlLogin implements MouseListener {
    // 1-Llamar a las otras capas
    Usuario modelo;
    jfrLogin vista;

    // 2-Constructor 
    public ctrlLogin(Usuario modelo, jfrLogin vista) {
        this.modelo = modelo;
        this.vista = vista;

        // Agregar los listeners a los botones
        vista.btnIngresar.addMouseListener(this); // Botón de Ingresar
        vista.btnRegistrar.addMouseListener(this); // Botón de Ir a Registro
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vista.btnIngresar) { // Botón Ingresar
            modelo.setCorreo(vista.txtUsuario.getText());
            modelo.setContraseña(modelo.convertirSHA256(new String(vista.pswUsuario.getPassword())));

            // Variable para verificar el resultado de iniciar sesión
            boolean comprobar = modelo.iniciarSesion();

            if (comprobar) {
                JOptionPane.showMessageDialog(vista, "Usuario existe, ¡Bienvenido!");
            } else {
                JOptionPane.showMessageDialog(vista, "Usuario no encontrado");
            }
        }

        if (e.getSource() == vista.btnRegistrar) { // Botón Ir a Registro
            // Suponiendo que `frmRegistro` es otra ventana que tienes para el registro
            Vista.jfrRegistro.initjfrRegistro();
            vista.dispose();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) { }

    @Override
    public void mouseReleased(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }
}

