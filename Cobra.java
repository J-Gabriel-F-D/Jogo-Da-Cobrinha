import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Cobra implements KeyListener{

    private ArrayList<Nodo> cobra;
    private boolean[] direction; // posição 0 = direita; posição 1 = esquerda; posição 2 = cima; posição 3 = baixo 
    public Cobra(){
        direction  = new boolean[4];
        cobra = new ArrayList<Nodo>();
        for (int i = 0; i < 3; i++) {
            cobra.add(new Ponto(0,0));
        }
    }
    public ArrayList<Nodo> getCobra() {
        return cobra;
    }
    public boolean[] getDirection() {
        return direction;
    }
    public void addSize(){
        cobra.add(new Ponto());
    }
    
    @Override
    public void keyPressed(KeyEvent e) { // posição 0 = direita; posição 1 = esquerda; posição 2 = cima; posição 3 = baixo 
        switch (e.getKeyCode()){
            case KeyEvent.VK_UP:
                for (int i = 0; i < direction.length; i++) {
                    if(i == 2){
                        direction[i] = true;

                    }else{
                        direction[i] = false;
                    }
                }
                break;
            case KeyEvent.VK_DOWN:
                for (int i = 0; i < direction.length; i++) {
                    if(i == 3){
                        direction[i] = true;
                    }else{
                        direction[i] = false;
                    }
                }
                break;
            case KeyEvent.VK_LEFT:
                for (int i = 0; i < direction.length; i++) {
                    if(i == 1){
                        direction[i] = true;
                    }else{
                        direction[i] = false;
                    }
                }
                break;
            case KeyEvent.VK_RIGHT:
                for (int i = 0; i < direction.length; i++) {
                    if(i == 0){
                        direction[i] = true;
                    }else{
                        direction[i] = false;
                    }
                }
                break;
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }
}
