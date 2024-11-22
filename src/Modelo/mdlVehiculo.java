package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.UUID;
import javax.swing.JTable;
import javax.swing.JTextField;
import Vista.PanelVehiculo1; // Asegúrate de que este es el nombre correcto de tu vista
import Modelo.ClaseConexion;
import javax.swing.JOptionPane;


public class mdlVehiculo {
    ////////////////////////1- Parámetros
    private String matricula;
    private String marca;
    private String tipo;
    private String modelo;
    private String pais;
    private String estado;
    private String proyecto;
    private String departamento;

    ////////////////////////2- Métodos get y set
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    ////////////////////////3- Métodos
    public void Guardar() {
        Connection conexion = ClaseConexion.getConexion();
        try {
            String sql = "INSERT INTO Vehiculo(Matricula, Marca, Tipo, Modelo, Pais, Estado, Proyecto, Departamento_Area) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conexion.prepareStatement(sql);
            pstmt.setString(1, getMatricula());
            pstmt.setString(2, getMarca());
            pstmt.setString(3, getTipo());
            pstmt.setString(4, getModelo());
            pstmt.setString(5, getPais());
            pstmt.setString(6, getEstado());
            pstmt.setString(7, getProyecto());
            pstmt.setString(8, getDepartamento());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Este es el error en el modelo: método guardar " + ex);
        }
    }

    public void Mostrar(JTable tabla) {
        Connection conexion = ClaseConexion.getConexion();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"Matricula", "Marca", "Tipo", "Modelo", "Pais", "Estado", "Proyecto", "Departamento_Area"});
        
        try {
            String query = "SELECT * FROM Vehiculo";
            Statement statement = conexion.createStatement();
            ResultSet rs = statement.executeQuery(query);
            
            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getString("Matricula"),
                    rs.getString("Marca"),
                    rs.getString("Tipo"),
                    rs.getString("Modelo"),
                    rs.getString("Pais"),
                    rs.getString("Estado"),
                    rs.getString("Proyecto"),
                    rs.getString("Departamento_Area")
                });
            }
            
            tabla.setModel(modelo);
            tabla.getColumnModel().getColumn(0).setMinWidth(0);
            tabla.getColumnModel().getColumn(0).setMaxWidth(0);
            tabla.getColumnModel().getColumn(0).setWidth(0);
            
        } catch (Exception e) {
            System.out.println("Este es el error en el modelo: método mostrar " + e);
        }
    }

    public void Eliminar(JTable tabla) {
        Connection conexion = ClaseConexion.getConexion();
        int filaSeleccionada = tabla.getSelectedRow();
        
        if (filaSeleccionada != -1) {
            String matriculaSeleccionada = tabla.getValueAt(filaSeleccionada, 0).toString();
            
            try {
                String sql = "DELETE FROM Vehiculo WHERE Matricula = ?";
                PreparedStatement deleteVehiculo = conexion.prepareStatement(sql);
                deleteVehiculo.setString(1, matriculaSeleccionada);
                deleteVehiculo.executeUpdate();
                
            } catch (Exception e) {
                System.out.println("Este es el error en el método eliminar: " + e);
            }
        }
    }

   public void Actualizar(JTable tabla) {
       Connection conexion = ClaseConexion.getConexion();
       int filaSeleccionada = tabla.getSelectedRow();
       
       if (filaSeleccionada != -1) {
           try {
               String sql = "UPDATE Vehiculo SET Marca=?, Tipo=?, Modelo=?, Pais=?, Estado=?, Proyecto=?, Departamento_Area=? WHERE Matricula=?";
               PreparedStatement updateVehiculo = conexion.prepareStatement(sql);
               updateVehiculo.setString(1, getMarca());
               updateVehiculo.setString(2, getTipo());
               updateVehiculo.setString(3, getModelo());
               updateVehiculo.setString(4, getPais());
               updateVehiculo.setString(5, getEstado());
               updateVehiculo.setString(6, getProyecto());
               updateVehiculo.setString(7, getDepartamento());
               updateVehiculo.setString(8, tabla.getValueAt(filaSeleccionada, 0).toString()); // Matricula de la fila seleccionada
               updateVehiculo.executeUpdate();
               
           } catch (Exception e) {
               System.out.println("Este es el error en el método actualizar: " + e);
           }
       }
   }

   public void Buscar(JTable tabla, JTextField txtBuscar) {
       Connection conexion = ClaseConexion.getConexion();
       DefaultTableModel modelo = new DefaultTableModel();
       modelo.setColumnIdentifiers(new Object[]{"Matricula", "Marca", "Tipo", "Modelo", "Pais", "Estado", "Proyecto", "Departamento_Area"});
       
       try {
           String sql = "SELECT * FROM Vehiculo WHERE Matricula LIKE ? OR Marca LIKE ?";
           PreparedStatement pstmt = conexion.prepareStatement(sql);
           String buscarTexto = txtBuscar.getText() + "%"; // Agregamos '%' para hacer una búsqueda parcial
           pstmt.setString(1, buscarTexto);
           pstmt.setString(2, buscarTexto);
           
           ResultSet rs = pstmt.executeQuery();

           while (rs.next()) {
               modelo.addRow(new Object[]{
                   rs.getString("Matricula"),
                   rs.getString("Marca"),
                   rs.getString("Tipo"),
                   rs.getString("Modelo"),
                   rs.getString("Pais"),
                   rs.getString("Estado"),
                   rs.getString("Proyecto"),
                   rs.getString("Departamento_Area")
               });
           }
           
           tabla.setModel(modelo);
           tabla.getColumnModel().getColumn(0).setMinWidth(0);
           tabla.getColumnModel().getColumn(0).setMaxWidth(0);
           tabla.getColumnModel().getColumn(0).setWidth(0);

       } catch (Exception e) {
           System.out.println("Este es el error en el modelo: método de buscar " + e);
       }
   }

   public void limpiar(PanelVehiculo1 vista) {
       vista.txtMatricula.setText("");
       vista.txtMarca.setText("");
       vista.txtModelo.setText("");
       vista.txtTipo.setText("");
       vista.txtEstado.setText("");
       vista.txtProyecto.setText("");
       vista.ComboBoxDepartamento.setSelectedIndex(0); // Reiniciar ComboBox
       vista.ComboBoxPais.setSelectedIndex(0); // Reiniciar ComboBox
   }

   public void cargarDatosTabla(PanelVehiculo1 vista) {
       int filaSeleccionada = vista.tablaVehiculo.getSelectedRow();

       if (filaSeleccionada != -1) {
           vista.txtMatricula.setText(vista.tablaVehiculo.getValueAt(filaSeleccionada, 0).toString());
           vista.txtMarca.setText(vista.tablaVehiculo.getValueAt(filaSeleccionada, 1).toString());
           vista.txtTipo.setText(vista.tablaVehiculo.getValueAt(filaSeleccionada, 2).toString());
           vista.txtModelo.setText(vista.tablaVehiculo.getValueAt(filaSeleccionada, 3).toString());
           vista.ComboBoxPais.setSelectedItem(vista.tablaVehiculo.getValueAt(filaSeleccionada, 4).toString());
           vista.txtEstado.setText(vista.tablaVehiculo.getValueAt(filaSeleccionada, 5).toString());
           vista.txtProyecto.setText(vista.tablaVehiculo.getValueAt(filaSeleccionada, 6).toString());
           vista.ComboBoxDepartamento.setSelectedItem(vista.tablaVehiculo.getValueAt(filaSeleccionada, 7).toString());
       } else {
           JOptionPane.showMessageDialog(vista, "Por favor, selecciona un vehículo.", "Error", JOptionPane.WARNING_MESSAGE);
       }
   }
}