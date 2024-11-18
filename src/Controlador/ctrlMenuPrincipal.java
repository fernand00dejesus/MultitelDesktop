package Controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Vista.jfrMenuPrincipal;
import Vista.PanelCombustible3;
import Vista.PanelVehiculo1;
import Vista.PanelKilometraje2;
import Vista.PanelEmpleado4;
import Vista.PanelMantenimiento5;




public class ctrlMenuPrincipal implements MouseListener{

    // Referencias a la vista principal y sus paneles
    private jfrMenuPrincipal vista;
    private PanelVehiculo1 Panel;
    
    
    
    
      public ctrlMenuPrincipal(jfrMenuPrincipal Vista, PanelVehiculo1 panel){
        this.vista = Vista;
        this.Panel = panel;
        
        vista.btnCombustible.addMouseListener(this);
        vista.btnEmpleado.addMouseListener(this);
        vista.btnKilometraje.addMouseListener(this);
        vista.btnMantenimiento.addMouseListener(this);
        vista.btnVehiculo.addMouseListener(this);
        
    }
    
    
    
   
    @Override
    public void mouseClicked(MouseEvent e) {
        
       
      
        if(e.getSource() == vista.btnVehiculo){
            //1-Creo un objeto del panel que quiero mostrar
            PanelVehiculo1 objVerde = new PanelVehiculo1();
            
            //2- Limpio el panel contendor (por si acaso)
            vista.jpContenedor.removeAll();
            //3- muestro el panel que quiero
            vista.jpContenedor.add(objVerde);
            
            //4- Refrescar todo
            vista.jpContenedor.revalidate();
            vista.jpContenedor.repaint();
        }
        
          if(e.getSource() == vista.btnKilometraje){
            PanelKilometraje2 objAmarillo = new PanelKilometraje2();
            
            vista.jpContenedor.removeAll();
            vista.jpContenedor.add(objAmarillo);
            
            vista.jpContenedor.revalidate();
            vista.jpContenedor.repaint();
        }
          
            if(e.getSource() == vista.btnCombustible){
            PanelCombustible3 objAmarillo1 = new PanelCombustible3();
            
            vista.jpContenedor.removeAll();
            vista.jpContenedor.add(objAmarillo1);
            
            vista.jpContenedor.revalidate();
            vista.jpContenedor.repaint();
        }
        if(e.getSource() == vista.btnEmpleado){
            PanelEmpleado4 objAmarillo2 = new PanelEmpleado4();
            
            vista.jpContenedor.removeAll();
            vista.jpContenedor.add(objAmarillo2);
            
            vista.jpContenedor.revalidate();
            vista.jpContenedor.repaint();
        }
        
          
        if(e.getSource() == vista.btnMantenimiento){
            PanelMantenimiento5 objAmarillo3 = new PanelMantenimiento5();
            
            vista.jpContenedor.removeAll();
            vista.jpContenedor.add(objAmarillo3);
            
            vista.jpContenedor.revalidate();
            vista.jpContenedor.repaint();
        }
        
               
         }
        

    
    @Override
    public void mousePressed(MouseEvent e) {
        // No implementado
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // No implementado
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // No implementado
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // No implementado
    }
}
