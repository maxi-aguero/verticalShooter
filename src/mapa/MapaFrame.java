package mapa;
import javax.swing.JFrame;
public class MapaFrame extends JFrame {

    private ZombiesCaminantesPanel zombiespanel;

    public MapaFrame() {
        this.zombiespanel = new ZombiesCaminantesPanel();
        this.add(zombiespanel);
        this.setTitle("Zombielandia");
        this.setResizable(false);
        this.setVisible(true);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    
    
}