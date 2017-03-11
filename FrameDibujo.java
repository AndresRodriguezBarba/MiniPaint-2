import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class FrameDibujo extends JFrame {
    private final JDesktopPane desktop;
    private final JMenuBar menu;
    private final JMenu archivo;
    private final JMenuItem nuevo;
    private final JMenuItem cerrar;
    private int numDibujos;
    
    public FrameDibujo() {
        super("Aplicacion de dibujo");
        final Caracteristicas c = new Caracteristicas();
        menu = new JMenuBar();
        archivo = new JMenu("Archivo");
        nuevo = new JMenuItem("Nuevo");
        cerrar = new JMenuItem("Cerrar Todo");
        archivo.add(nuevo);
        archivo.add(cerrar);
        menu.add(archivo);
        numDibujos = 0;
        desktop = new JDesktopPane();
        nuevo.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String x;
                        boolean valido = true;
                        do{
                            x = JOptionPane.showInputDialog("Nombre de dibujo");
                            if(numDibujos > 0){
                                for(int z = 0; z < numDibujos; z++){
                                    if(x.equals(c.getTitulo(z))){
                                        valido = false;
                                        JOptionPane.showMessageDialog(null, "Ese nombre ya existe");
                                        z = numDibujos;
                                    }
                                    else{
                                        valido = true;
                                    }
                                }
                            }
                        }
                        while(valido == false);
                        c.setDibujo(x, numDibujos);
                        desktop.add(c.getDibujo());
                        numDibujos = c.getNumDibujos();
                        numDibujos++;
                    }
                }
        );
        cerrar.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        c.Restablecer();
                        numDibujos = 0;
                    }
                }
        );
        
        desktop.add(c);
        getContentPane().add(menu, BorderLayout.NORTH);
        getContentPane().add(desktop);
    }
}