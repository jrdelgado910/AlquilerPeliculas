
package Controlador;

import Vista.*;
import Modelo.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Controlador implements ActionListener{
    DefaultTableModel modeloTabla;
    
    private VistaUno vista;
    private Modelo modelo;
    private String fechaP, fechaEn;
    private int con=0;


    public Controlador(VistaUno vista, Modelo modelo) {
        this.vista = vista;
        this.modelo = modelo;

        this.vista.jButton1.addActionListener(this);

    
        modeloTabla=new DefaultTableModel();
        
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Director");
        modeloTabla.addColumn("Genero");
        modeloTabla.addColumn("Prestamo");
        modeloTabla.addColumn("Entrega");
        modeloTabla.addColumn("Total");
        
        vista.jTable1.setModel(modeloTabla);

    }
    
     public void Iniciar(){
        vista.pack();
        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
     }
     
    ArrayList<Modelo> listpeli=new ArrayList<Modelo>();
    
    public void actionPerformed(ActionEvent e) {
           
        if(vista.jButton1==e.getSource()){
            if(vista.jTextField1.getText().isEmpty() || vista.jTextField2.getText().isEmpty() || 
                    vista.jTextField4.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Ingrese todos los valores");
            }else{
               
                fechaP=Integer.toString(vista.jDateChooser1.getCalendar().get(Calendar.DAY_OF_MONTH))+"/"+
                        Integer.toString(vista.jDateChooser1.getCalendar().get(Calendar.MONTH)+1)
                        +"/"+Integer.toString(vista.jDateChooser1.getCalendar().get(Calendar.YEAR));
                
                fechaEn=Integer.toString(vista.jDateChooser2.getCalendar().get(Calendar.DAY_OF_MONTH))+"/"+
                        Integer.toString(vista.jDateChooser2.getCalendar().get(Calendar.MONTH)+1)
                        +"/"+Integer.toString(vista.jDateChooser2.getCalendar().get(Calendar.YEAR));
                
                modelo.setNombre(vista.jTextField1.getText());
                modelo.setDirector(vista.jTextField2.getText());
                modelo.setGenero((String) vista.jComboBox1.getSelectedItem());
                modelo.setDiaEntre(fechaEn);
                modelo.setDiaPres(fechaP);
                modelo.setValor(Integer.parseInt(vista.jTextField4.getText()));

                listpeli.add(new Modelo(vista.jTextField1.getText(), vista.jTextField2.getText(), 
                        (String) vista.jComboBox1.getSelectedItem(), 
                        fechaP, fechaEn, Integer.parseInt(vista.jTextField4.getText())));
                
                   Object[] filas = new Object[modeloTabla.getColumnCount()];
                
               
                 filas[0]=listpeli.get(con).getNombre();
                 filas[1]=listpeli.get(con).getDirector();
                 filas[2]=listpeli.get(con).getGenero();
                 filas[3]=listpeli.get(con).getDiaPres();
                 filas[4]=listpeli.get(con).getDiaEntre();
                 filas[5]=listpeli.get(con).getValor();
 
                 modeloTabla.addRow(filas);    
                 con++;
               modelo.guardarPeliculas(modelo);
                vista.jTextField1.setText("");
                vista.jTextField2.setText("");
                vista.jTextField4.setText("");
                vista.jDateChooser1.setCalendar(null);
                vista.jDateChooser2.setCalendar(null);
            }     
    }
    }   
}