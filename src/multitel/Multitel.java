
package multitel;
import javax.swing.JFrame;
import Vista.PanelVehiculo1;
import modelo.mdlVehiculo;
import controlador.ctrlVehiculo;


public class Multitel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


        
        
        
        // Crear instancia del modelo
        mdlVehiculo modelo = new mdlVehiculo();

        // Crear instancia de la vista
        PanelVehiculo1 vista = new PanelVehiculo1();

        // Crear el controlador y enlazarlo al modelo y la vista
        ctrlVehiculo controlador = new ctrlVehiculo(modelo, vista);

        // Configurar la ventana principal
        JFrame frame = new JFrame("Aplicación de Vehículos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(vista);
        frame.setSize(1200, 800); // Tamaño de la ventana
        frame.setLocationRelativeTo(null); // Centrar en la pantalla
        frame.setVisible(true); // Hacer la ventana visible
    }
}
        
    
    

