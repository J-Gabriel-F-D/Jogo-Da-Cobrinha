import javax.swing.JFrame;

public class Tela extends JFrame{
    static final int width = 512, height = 512;
    public Tela(){
        add(new Painel());
        setTitle("tela");
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}