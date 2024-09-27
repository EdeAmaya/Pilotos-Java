/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Pilotos;
import Vista.frmPilotos;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;


public class ctrlPiloto implements MouseListener,KeyListener {
    
    private frmPilotos vista;
    private Pilotos modelo;
    
    public ctrlPiloto(frmPilotos Vista, Pilotos Modelo){
        this.vista = Vista;
        this.modelo = Modelo;
        
        vista.btnGuardar.addMouseListener(this);
        vista.btnEliminar.addMouseListener(this);        
        vista.btnActualizar.addMouseListener(this);
        vista.jtbPilotos.addMouseListener(this);
        modelo.MostrarPiloto(vista.jtbPilotos);
        
               
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
       if(e.getSource() == vista.btnGuardar){
       boolean validacionesCorrectasG = true;
       if(vista.txtNombre.getText().isEmpty()||vista.txtEdad.getText().isEmpty()||vista.txtPeso.getText().isEmpty()||vista.txtCorreo.getText().isEmpty()){
                JOptionPane.showMessageDialog(vista, "Llene los campos");
                validacionesCorrectasG = false;
            } 
       
        else {
           try {
                double peso = Double.parseDouble(vista.txtPeso.getText());
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(vista, "Ingrese solo numeros en el peso en este formato 45.73");
                validacionesCorrectasG = false;
            }
           
           
            try {
                int edadNumerica = Integer.parseInt(vista.txtPeso.getText());
                if(edadNumerica > 100 || edadNumerica < 18){
                    JOptionPane.showMessageDialog(vista, "Ingrese una edad valida");
                    validacionesCorrectasG = false;
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(vista, "Ingrese solo numeros en la edad");
                validacionesCorrectasG = false;
            }
            
            if(!vista.txtCorreo.getText().contains("@") || !vista.txtCorreo.getText().contains(".com")){
                JOptionPane.showMessageDialog(vista, "Ingrese un correo valido como este correoelctronico.com");
                validacionesCorrectasG = false;
            }

       }
   
       if(validacionesCorrectasG){
       modelo.setNombre_Piloto(vista.txtNombre.getText());
       modelo.setEdad_Piloto(Integer.parseInt( vista.txtEdad.getText()));
       modelo.setPeso_Piloto(Double.parseDouble(vista.txtPeso.getText()));
       modelo.setCorreo_Piloto(vista.txtCorreo.getText());
       modelo.GuardarPiloto();
       modelo.MostrarPiloto(vista.jtbPilotos);
       modelo.cargarDatosTabla(vista);
       modelo.Limpiar(vista);
            }
        }
       
       
       
       if (e.getSource() == vista.btnEliminar) {
                modelo.Eliminar(vista.jtbPilotos);
                modelo.MostrarPiloto(vista.jtbPilotos);
        }
       
       if (e.getSource() == vista.jtbPilotos){
       modelo.cargarDatosTabla(vista);
       }
       
        if (e.getSource() == vista.btnLimpiar) {
                modelo.Limpiar(vista);
               
        }
       
       
        
       if (e.getSource() == vista.btnActualizar) {          
       //Asignar lo de la vista al modelo al momento de darle clic a actualizar
       boolean validacionesCorrectasA = true;
       if(vista.txtNombre.getText().isEmpty()||vista.txtEdad.getText().isEmpty()||vista.txtPeso.getText().isEmpty()||vista.txtCorreo.getText().isEmpty()){
                JOptionPane.showMessageDialog(vista, "Llene los campos");
                validacionesCorrectasA = false;
            } 
        else {
           try {
                double peso = Double.parseDouble(vista.txtPeso.getText());
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(vista, "Ingrese solo numeros en el peso");
                validacionesCorrectasA = false;
            }
           
           
            try {
                int edadNumerica = Integer.parseInt(vista.txtPeso.getText());
                if(edadNumerica > 100 || edadNumerica < 18){
                    JOptionPane.showMessageDialog(vista, "Ingrese una edad valida");
                    validacionesCorrectasA = false;
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(vista, "Ingrese solo numeros en la edad");
                validacionesCorrectasA = false;
            }
            
            if(!vista.txtCorreo.getText().contains("@") || !vista.txtCorreo.getText().contains(".com")){
                JOptionPane.showMessageDialog(vista, "Ingrese un correo valido como este correoelctronico.com");
                validacionesCorrectasA = false;
            }

       }
   
       if(validacionesCorrectasA){
       modelo.setNombre_Piloto(vista.txtNombre.getText());
       modelo.setEdad_Piloto(Integer.parseInt( vista.txtEdad.getText()));
       modelo.setPeso_Piloto(Double.parseDouble(vista.txtPeso.getText()));
       modelo.setCorreo_Piloto(vista.txtCorreo.getText());
       modelo.ActualizarPiloto(vista.jtbPilotos);
       modelo.MostrarPiloto(vista.jtbPilotos);
       modelo.Limpiar(vista);
            }

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

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
}
