import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TecladoAdp extends KeyAdapter{
    Cobra c;
    public TecladoAdp(Cobra c) {
        this.c = c;
    }
    @Override
    public void keyPressed(KeyEvent e){
        c.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e){
        c.keyReleased(e);
    }
}
