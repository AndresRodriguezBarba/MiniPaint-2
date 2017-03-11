import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Dibujo extends JInternalFrame{
    private final JMenuBar menu;
    private final JMenu archivo;
    private final JMenuItem limpiar;
    private final JMenuItem deshacer;
    private final PanelDibujo panel;
    private final int numDibujo;
    private boolean select;
    private boolean guardar;
    
    public Dibujo(String x, int n, Color c, int f, boolean r){
        super(x);
        menu = new JMenuBar();
        archivo = new JMenu("Archivo");
        limpiar = new JMenuItem("Limpiar");
        limpiar.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        panel.borrarDibujo();
                    }
                }
        );
        deshacer = new JMenuItem("Deshacer");
        deshacer.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        panel.borrarUltimaFigura();
                    }
                }
        );
        archivo.add(deshacer);
        archivo.add(limpiar);
        menu.add(archivo);
        panel = new PanelDibujo(c,f,r);
        numDibujo = n;
        add(menu, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        add(panel.getEstado(), BorderLayout.SOUTH);
        setSize(200,200);
        setLocation(0, 100);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setVisible(true);
    }
    
    public void setBorrarDibujo(){
        panel.borrarDibujo();
    }
    
    public void setBorrarUltimaFigura(){
        panel.borrarUltimaFigura();
    }
    
    public void setColor(Color c){
        panel.setColor(c);
    }
    
    public void setFigura(int f){
        panel.setFigura(f);
    }
    
    public void setRelleno(boolean r){
        panel.setRelleno(r);
    }
}
