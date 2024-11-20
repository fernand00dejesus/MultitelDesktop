package Controlador;

import Controlador.ctrlMenuPrincipal;
import Modelo.Usuario;
import Vista.jfrLogin;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import Vista.jfrMenuPrincipal;

import Vista.jfrMenuPrincipal;
import Vista.PanelCombustible3;
import Vista.PanelVehiculo1;
import Vista.PanelKilometraje2;
import Vista.PanelEmpleado4;
import Vista.PanelMantenimiento5;

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
          // Obtener el correo del campo de texto
modelo.setCorreo(vista.txtUsuario.getText());

// Obtener la contraseña en texto plano y luego convertirla a SHA-256
String password = new String(vista.pswUsuario.getPassword()); // Convertir char[] a String
modelo.setContraseña(modelo.convertirSHA256(password));

            // Variable para verificar el resultado de iniciar sesión
            boolean comprobar = modelo.iniciarSesion();

            if (comprobar) {
                JOptionPane.showMessageDialog(vista, "Usuario existe, ¡Bienvenido!");
                //quiero que se inicie otra pantalla 
                // Abrir la ventana principal
            jfrMenuPrincipal menuPrincipal = new jfrMenuPrincipal();
            menuPrincipal.setVisible(true);
            
              // Inicializar el controlador del menú principal
            PanelVehiculo1 panelVehiculo = new PanelVehiculo1(); // O cualquier otro panel que necesites
            ctrlMenuPrincipal controladorMenu = new ctrlMenuPrincipal(menuPrincipal, panelVehiculo);

            
            

            // Cerrar la ventana de login
            vista.dispose();
                
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
    //Creo una variable llamada "comprobar" 
            //que guardará el resultado de ejecutar el metodo iniciarSesion()            
            

    @Override
    public void mousePressed(MouseEvent e) { }

    @Override
    public void mouseReleased(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }
}

