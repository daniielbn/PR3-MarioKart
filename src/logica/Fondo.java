package logica;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author Daniel Brito Negrín
 * @version 1.0
 */
public class Fondo implements Runnable {
    // Atributos
    private JFrame ventana; // ventana principal
    private volatile boolean activo; // atributo para saber si está activo o no.
    
    /**
     * Constructor de la clase.
     * @param ventana JFrame.
     * @param activo Booleano.
     */
    public Fondo(JFrame ventana, boolean activo) {
        this.ventana = ventana;
        this.activo = activo;
    }
    
    /**
     * Método getter para obtener la ventana de la clase
     * @return JFrame de la clase.
     */
    public JFrame getVentana() {
        return this.ventana;
    }
    
    /**
     * Método getter para obtener el booleano de la clase.
     * @return Booleano de la clase.
     */
    public boolean getActivo() {
        return this.activo;
    }
    
    /**
     * Método setter para establecer la ventana de la clase.
     * @param ventana JFrame que se quiere establecer.
     */
    public void setVentana(JFrame ventana) {
        this.ventana = ventana;
    }
    
    /**
     * Método setter para establecer el booleano de la clase.
     * @param activo Booleano que se quiere establecer.
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    /**
     * Método público que comprueba si el fondo está activo. Si lo está, el mismo va cambiando cada 3 segundos a un color aleatorio.
     */
    @Override
    public void run() {
        while (activo) {
            // Lógica para cambiar el fondo aquí
            ventana.getContentPane().setBackground(new Color((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255))); // Se establece un color aleatorio de fondo.
            try {
                Thread.sleep(3000); // Espera 3 segundos.
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
