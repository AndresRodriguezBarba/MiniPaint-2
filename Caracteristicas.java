import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Caracteristicas extends JInternalFrame{ 
    private Dibujo[] dibujo;
    private final JPanel menu;
    private final JButton Limpiar;
    private final JComboBox<String> Colores;
    private final JComboBox<String> Figuras;
    private final JCheckBox Relleno;
    private final String[] nameColores = {
        "Negro","Azul","Cyan","Gris Obscuro","Gris","Verde","Gris Claro",
        "Magenta","Naranja","Rosa","Rojo","Blanco","Amarillo"
    };
    private final String[] nameFiguras = {
        "Linea","Rectangulo","Ovalo","Triangulo","TrianguloRect"
    };
    private final Color[] colores = {
            Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY,
            Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE,
            Color.PINK, Color.RED, Color.WHITE, Color.YELLOW
    };
    private int numDibujo = -1;
    
    public Caracteristicas(){
        super("Opciones de dibujo");
        dibujo = new Dibujo[100];
        menu = new JPanel();
        Limpiar = new JButton("Borrar Todo");
        Limpiar.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        if(numDibujo == 0){
                            dibujo[0].setBorrarDibujo();
                        }
                        else{
                            for(int x = 0; x <= numDibujo; x++){
                                dibujo[x].setBorrarDibujo();
                            }
                        }
                    }
                }
        );
        Colores = new JComboBox<>(nameColores);
        Colores.setMaximumRowCount(3);
        Colores.addItemListener(
                new ItemListener(){
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        for(int x = 0; x <= numDibujo; x++){
                            dibujo[x].setColor(colores[Colores.getSelectedIndex()]);
                        }
                    }
                }
        );
        Figuras = new JComboBox<>(nameFiguras);
        Figuras.setMaximumRowCount(3);
        Figuras.addItemListener(
                new ItemListener(){
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        for(int x = 0; x <= numDibujo; x++){
                            dibujo[x].setFigura(Figuras.getSelectedIndex());
                        }
                    }
                }
        );
        Relleno = new JCheckBox("Relleno");
        Relleno.addItemListener(
                new ItemListener(){
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        for(int x = 0; x <= numDibujo; x++){
                            dibujo[x].setRelleno(Relleno.isSelected());
                        }
                    }
                }
        ); 
        
        menu.add(Limpiar);
        menu.add(Colores);
        menu.add(Figuras);
        menu.add(Relleno);
        add(menu);
        setSize(585,75);
        setIconifiable(true);
        setResizable(true);
        setVisible(true);
    }
    
    public void Restablecer(){
        for(int x = 0; x <= numDibujo; x++){
            dibujo[x].dispose();
        }
        dibujo = new Dibujo[100];
        numDibujo = -1;
    }
    
    public void setDibujo(String s, int x){
        if(numDibujo < x){
            dibujo[x] = new Dibujo(s,x,colores[Colores.getSelectedIndex()],
                    Figuras.getSelectedIndex(), Relleno.isSelected());
            numDibujo = x;
        }
        else{
            dibujo[numDibujo] = new Dibujo(s,x,colores[Colores.getSelectedIndex()],
                    Figuras.getSelectedIndex(), Relleno.isSelected());
            numDibujo++;
        }
    }
    
    public int getNumDibujos(){return numDibujo;}
    public Dibujo getDibujo(){return dibujo[numDibujo];}
    public String getTitulo(int x){return dibujo[x].getTitle();}
}