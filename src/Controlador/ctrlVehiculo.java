package controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.mdlVehiculo; // Asegúrate de que este es el nombre correcto del modelo
import Vista.PanelVehiculo1; // Cambia esto al nombre correcto de tu vista

public class ctrlVehiculo implements MouseListener, KeyListener {

    //////////////////////////2- Parámetros
    private mdlVehiculo modelo;
    private PanelVehiculo1 vista;

    //////////////////////////3- Constructor de la clase
    public ctrlVehiculo(mdlVehiculo modelo, PanelVehiculo1 vista) {
        this.modelo = modelo;
        this.vista = vista;

        // Siempre poner todos los botones que vamos a detectar
        vista.btnAgregarVehiculo.addMouseListener(this);
        vista.btnEliminarVehiculo.addMouseListener(this);
        vista.btnActualizarVehiculo.addMouseListener(this);
        vista.btnLimpiarVehiculos.addMouseListener(this);
        vista.txtBuscarVehiculo.addKeyListener(this);
        vista.tablaVehiculo.addMouseListener(this);

        modelo.Mostrar(vista.tablaVehiculo);
    }

    ///////////////////////////////////////// Eventos
    @Override
    public void mouseClicked(MouseEvent e) {
        //////////////////////////4- Detección de clicks en la vista
        if (e.getSource() == vista.btnAgregarVehiculo) {
            if (vista.txtMatricula.getText().isEmpty() || vista.txtMarca.getText().isEmpty() || 
                vista.txtModelo.getText().isEmpty() || vista.txtTipo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Debes llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    // Asignar lo de la vista al modelo
                    modelo.setMatricula(vista.txtMatricula.getText());
                    modelo.setMarca(vista.txtMarca.getText());
                    modelo.setModelo(vista.txtModelo.getText());
                    modelo.setTipo(vista.txtTipo.getText());
                    modelo.setPais((String) vista.ComboBoxPais.getSelectedItem());
                    modelo.setEstado(vista.txtEstado.getText());
                    modelo.setProyecto(vista.txtProyecto.getText());
                    modelo.setDepartamento((String) vista.ComboBoxDepartamento.getSelectedItem());

                    // Ejecutar el método 
                    modelo.Guardar();
                    modelo.Mostrar(vista.tablaVehiculo);
                    modelo.limpiar(vista);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(vista, "Error al agregar vehículo: " + ex.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        }

        if (e.getSource() == vista.btnEliminarVehiculo) {
            if (vista.tablaVehiculo.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(vista, "Debes seleccionar un registro para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                modelo.Eliminar(vista.tablaVehiculo);
                modelo.Mostrar(vista.tablaVehiculo);
                modelo.limpiar(vista);
            }
        }

        if (e.getSource() == vista.btnActualizarVehiculo) {
            if (vista.tablaVehiculo.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(vista, "Debes seleccionar un registro para actualizar", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    // Asignar lo de la vista al modelo al momento de darle clic a actualizar
                    modelo.setMatricula(vista.txtMatricula.getText());
                    modelo.setMarca(vista.txtMarca.getText());
                    modelo.setModelo(vista.txtModelo.getText());
                    modelo.setTipo(vista.txtTipo.getText());
                    modelo.setPais((String) vista.ComboBoxPais.getSelectedItem());
                    modelo.setEstado(vista.txtEstado.getText());
                    modelo.setProyecto(vista.txtProyecto.getText());
                    modelo.setDepartamento((String) vista.ComboBoxDepartamento.getSelectedItem());

                    // Ejecutar el método    
                    modelo.Actualizar(vista.tablaVehiculo);
                    modelo.Mostrar(vista.tablaVehiculo);
                    modelo.limpiar(vista);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(vista, "Error al actualizar vehículo: " + ex.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        }

        if (e.getSource() == vista.btnLimpiarVehiculos) {
            modelo.limpiar(vista);
        }

       if (e.getSource() == vista.tablaVehiculo) {
    modelo.cargarDatosTabla(vista); // Llama al método correcto para cargar datos
}
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == vista.txtBuscarVehiculo) {
            // Implementa la búsqueda si es necesario
            //modelo.Buscar(vista.tablaVehiculo, vista.txtBuscar); // Si decides implementar búsqueda
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}
    
    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {}
}