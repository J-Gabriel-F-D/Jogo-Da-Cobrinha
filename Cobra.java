import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Cobra implements KeyListener{

    private ArrayList<Nodo> cobra;
    private boolean[] direction; // posição 0 = direita; posição 1 = esquerda; posição 2 = cima; posição 3 = baixo 
    public Cobra(){
        direction  = new boolean[4];
        cobra = new ArrayList<Nodo>();
        for (int i = 0; i < 1; i++) {
            cobra.add(new Nodo(0,0));
        }
    }
    public ArrayList<Nodo> getCobra() {
        return cobra;
    }
    public boolean[] getDirection() {
        return direction;
    }
    public void addSize(){
        Nodo tam = cobra.get(cobra.size()-1);
        cobra.add(new Nodo(tam.getCordX(), tam.getCordY()));
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP){
            for (int i = 0; i < direction.length; i++) {
                if(i == 2){
                    direction[i] = true;
                    
                }else{
                    direction[i] = false;
                }

            }
        }else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            for (int i = 0; i < direction.length; i++) {
                if(i == 3){
                    direction[i] = true;
                }else{
                    direction[i] = false;
                }
            }
        }else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            for (int i = 0; i < direction.length; i++) {
                if(i == 1){
                    direction[i] = true;
                }else{
                    direction[i] = false;
                }
            }
        }else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            for (int i = 0; i < direction.length; i++) {
                if(i == 0){
                    direction[i] = true;
                }else{
                    direction[i] = false;
                }
            }
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }
}
