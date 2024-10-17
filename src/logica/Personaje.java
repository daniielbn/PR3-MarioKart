package logica;

import javax.swing.JLabel;
import javax.swing.JProgressBar;
/**
 *
 * @author Daniel Brito Negrín
 * @version 1.0
 */
public class Personaje implements Runnable {
    // Atributos
    private JProgressBar progressBar; // JProgressBar asociado al personaje.
    private String nombre; // Nombre del personaje.
    private boolean caparazon; // Booleano que indica si ha sido golpeado por un caparazón.
    private int nVueltas; // Número de vueltas actuales.
    private JLabel vueltas; // JLabel que muestra las vueltas que lleva.
    private volatile boolean boxes; // Booleano que establece si el personaje está en boxes.
    private volatile static boolean terminado; // Booleano estático que indica si alguna instancia ha terminado la carrera o no.
    private JLabel mensajeGanador; // JLabel para poner mensaje ganador (si es que gana).
    private ventanaPrincipal ventana; // Ventana principal del programa.
    
    /**
     * Constructor de la clase.
     * @param progressBar JProgressBar asociada.
     * @param nombre Nombre del personaje.
     * @param caparazon Booleano del caparazón.
     * @param nVueltas Número de vueltas.
     * @param vueltas JLabel de las vueltas.
     * @param boxes Booleano que indica si está en boxes.
     * @param terminado // Booleano que indica si ha terminado la carrera.
     * @param mensajeGanador // JLabel asociado.
     * @param ventana // Ventana principal.
     */
    public Personaje(JProgressBar progressBar, String nombre, boolean caparazon, int nVueltas, JLabel vueltas, boolean boxes, boolean terminado, JLabel mensajeGanador, ventanaPrincipal ventana) {
        this.progressBar = progressBar;
        this.nombre = nombre;
        this.caparazon = caparazon;
        this.nVueltas = nVueltas;
        this.vueltas = vueltas;
        this.boxes = boxes;
        this.terminado = terminado;
        this.mensajeGanador = mensajeGanador;
        this.ventana = ventana;
    }
    
    /**
     * Método getter para obtener la JProgressBar.
     * @return Devuelve la JProgressBar asociada al personaje.
     */
    public JProgressBar getProgressBar() {
        return this.progressBar;
    }
    
    /**
     * Método getter para obtener el nombre.
     * @return String del nombre.
     */
    public String getNombre() {
        return this.nombre;
    }
    
    /**
     * Método getter para obtener si ha sido golpeado por un caparazón.
     * @return Booleano.
     */
    public boolean getCaparazon() {
        return this.caparazon;
    }
    
    /**
     * Método getter para obtener el número de vueltas.
     * @return Entero.
     */
    public int getNVueltas() {
        return this.nVueltas;
    }
    
    /**
     * Método getter para obtener el JLabel asociado al número de vueltas.
     * @return 
     */
    public JLabel getVueltas() {
        return this.vueltas;
    }
    
    /**
     * Método getter para obtener si está en boxes.
     * @return Booleano.
     */
    public boolean getBoxes() {
        return this.boxes;
    }
    
    /**
     * Método getter para obtener si ha terminado la carrera.
     * @return Booleano.
     */ 
    public boolean getTerminado() {
        return this.terminado;
    }
    
    /**
     * Método getter para obtener el JLabel asociado al mensaje ganador.
     * @return JLabel asociado.
     */
    public JLabel getMensajeGanador() {
        return this.mensajeGanador;
    }
    
    /**
     * Método getter para obtener la ventana asociada.
     * @return ventanaPrincipal.
     */
    public ventanaPrincipal getVentana() {
        return this.ventana;
    }
    
    /**
     * Método setter para establecer la JProgressBar asociada al personaje.
     * @param progressBar JProgressBar a establecer.
     */
    public void setProgressBar(JProgressBar progressBar) {
        this.progressBar = progressBar;
    }
    
    /**
     * Método setter para establecer el nombre del personaje.
     * @param nombre String a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Método setter para establecer si el personaje ha sido golpeado por un caparazón.
     * @param caparazon Booleano a establecer.
     */
    public void setCaparazon(boolean caparazon) {
        this.caparazon = caparazon;
    }
    
    /**
     * Método setter para establecer el número de vueltas del personaje.
     * @param nVueltas Entero a establecer.
     */
    public void setNVueltas(int nVueltas) {
        this.nVueltas = nVueltas;
    }
    
    /**
     * Método setter para establecer el JLabel asociado al número de vueltas.
     * @param vueltas JLabel a establecer.
     */
    public void setVueltas(JLabel vueltas) {
        this.vueltas = vueltas;
    }
    
    /**
     * Método setter para establecer si el personaje está en boxes.
     * @param boxes Booleano a establecer.
     */
    public void setBoxes(boolean boxes) {
        this.boxes = boxes;
    }
    
    /**
     * Método setter para establecer si el personaje ha terminado la carrera.
     * @param terminado Booleano a establecer.
     */
    public void setTerminado(boolean terminado) {
        this.terminado = terminado;
    }
    
    /**
     * Método setter para establecer el JLabel asociado.
     * @param mensajeGanador JLabel a establecer.
     */
    public void setMensajeGanador(JLabel mensajeGanador) {
        this.mensajeGanador = mensajeGanador;
    }
    
    /**
     * Método setter para establecer la ventana asociada.
     * @param ventana ventanaPrincipal a establecer.
     */
    public void setVentana(ventanaPrincipal ventana) {
        this.ventana = ventana;
    }
    
    /**
     * Método que reinicia a los valores predeterminado los atributos de la clase.
     */
    public void reiniciar() {
        this.terminado = false;
        this.nVueltas = 0;
        this.progressBar.setValue(0);
        this.vueltas.setText("1/3");
    }
    
    /**
     * Método publico que aumenta el progreso en la carrera del personaje. Mientras el atributo "terminado" sea falso, y no se hayan superado las 3 vueltas necesarias, se seguirá
     * aumentando el valor del JProgressBar. Cuando este se completa, se suma una vuelta, y el JProgressBar se reinicia.
     */
    @Override
    public void run() {
        while(!terminado && nVueltas < 3) {
            try {
                Thread.sleep(100);
                if (!boxes) {
                    progressBar.setValue(progressBar.getValue() + 1);
                    if (progressBar.getValue() >= progressBar.getMaximum()) {
                        if (nVueltas < 3) {
                            nVueltas++;
                            progressBar.setValue(0);  // Reinicia la barra de progreso

                            // Actualiza el contador de vueltas solo si no se ha alcanzado el límite
                            String[] split = vueltas.getText().split("/");
                            vueltas.setText(String.valueOf(Integer.parseInt(split[0]) + 1) + "/3");
                        }

                    }
                    if (nVueltas == 3) {
                        terminado = true;
                        mensajeGanador.setText(nombre.toUpperCase() + " HA GANADO!");
                        ventana.carreraEnCurso = false;
                    }
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        vueltas.setText("3/3");
    }

}
