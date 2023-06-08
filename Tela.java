import javax.swing.JFrame;

public class Tela extends JFrame{
    static final int width = 512, height = 512;
    private Painel painel;

    public Tela(){
        painel = new Painel();
        add(painel);
        pack();
        setTitle("Cobrinha");
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        Thread td = new Thread(painel);
        td.start();
    }
}