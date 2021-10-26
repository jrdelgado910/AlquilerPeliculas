
package alquilerpeliculas;

import Controlador.Controlador;
import Vista.*;
import Modelo.*;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class AlquilerPeliculas {

    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(UnsupportedLookAndFeelException e){
        }catch(ClassNotFoundException e){
        }catch(InstantiationException e){
        }catch(IllegalAccessException e){
        }
        Modelo modelo = new Modelo();
        VistaUno vista =new VistaUno();
        Controlador controlador = new Controlador(vista, modelo);
        controlador.Iniciar();
    }
    
}
