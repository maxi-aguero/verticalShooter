package mapa;
import javax.swing.JFrame;
public class MapaFrame extends JFrame {

   // private Mapatres zombiespanel; //panel de donde hay jugadores y infectados
    private Juego zombiespanel; //panel de donde hay jugadores y infectados

    public MapaFrame() {
       // this.zombiespanel = new Mapatres();
        this.zombiespanel = new Juego();
        this.add(zombiespanel);
        this.setTitle("Zombielandia");
        this.setResizable(false);
        this.setVisible(true);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    
    
}