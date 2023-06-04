import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class Painel extends JPanel{
    
    public Painel(){

    }

    public void paint(Graphics g){
        Ponto pontoR = new Ponto(new Random().nextInt(0,Tela.height-20),new Random().nextInt(0,Tela.width-20));
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Tela.width, Tela.height);
        g.setColor(Color.GREEN);
        g.fillRect(pontoR.getCordXPonto(),pontoR.getCordXPonto(), Nodo.nodoSize, Nodo.nodoSize);

    }

   
}
