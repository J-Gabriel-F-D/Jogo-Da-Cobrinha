import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Painel extends Canvas implements Runnable{
    private Cobra cobrinha;
    private Ponto ponto;
    public Painel(){
        ponto = new Ponto(new Random().nextInt(0,Tela.width-20)-Nodo.nodoSize, new Random().nextInt(0,Tela.width-20)-Nodo.nodoSize);
        cobrinha = new Cobra();
        addKeyListener(new TecladoAdp(cobrinha));
    }

    public void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }    
        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Tela.width, Tela.height);
        g.setColor(Color.GREEN);
        g.fillRect(ponto.getCordXPonto(),ponto.getCordYPonto(), Nodo.nodoSize, Nodo.nodoSize);
        for (int i = 0; i < cobrinha.getCobra().size(); i++) {
            g.setColor(Color.RED);
            g.fillRect(cobrinha.getCobra().get(i).getCordX(), cobrinha.getCobra().get(i).getCordY(), Nodo.nodoSize, Nodo.nodoSize);
        }
        g.dispose();
        bs.show();
    }
    public void tick(){
        for(int i = cobrinha.getCobra().size()-1; i > 0; i--){
            cobrinha.getCobra().get(i).setCordX(cobrinha.getCobra().get(i-1).getCordX());
            cobrinha.getCobra().get(i).setCordY(cobrinha.getCobra().get(i-1).getCordY());
        }

        if(cobrinha.getCobra().get(0).getCordX()+1<0){//esquerda para direita
            cobrinha.getCobra().get(0).setCordX(Tela.width);
        }else if(cobrinha.getCobra().get(0).getCordX() >=Tela.width){ // direita para esquerda
            cobrinha.getCobra().get(0).setCordX(-Nodo.nodoSize);
        }else if(cobrinha.getCobra().get(0).getCordY()+1<0){
            cobrinha.getCobra().get(0).setCordY(Tela.width);
        }else if(cobrinha.getCobra().get(0).getCordY() >=Tela.width){
            cobrinha.getCobra().get(0).setCordY(-Nodo.nodoSize);
        }

        if(cobrinha.getDirection()[0]){
            cobrinha.getCobra().get(0).setCordX(cobrinha.getCobra().get(0).getCordX()+Nodo.nodoSize);

        } else if(cobrinha.getDirection()[1]){
            cobrinha.getCobra().get(0).setCordX(cobrinha.getCobra().get(0).getCordX()-Nodo.nodoSize);

        }else if(cobrinha.getDirection()[2]){
            cobrinha.getCobra().get(0).setCordY(cobrinha.getCobra().get(0).getCordY()-Nodo.nodoSize);

        }else if(cobrinha.getDirection()[3]){
            cobrinha.getCobra().get(0).setCordY(cobrinha.getCobra().get(0).getCordY()+Nodo.nodoSize);

        }
        Rectangle col = new Rectangle(cobrinha.getCobra().get(0).getCordX(),cobrinha.getCobra().get(0).getCordY(),Nodo.nodoSize,Nodo.nodoSize);
        if(col.intersects(new Rectangle(ponto.getCordXPonto(),ponto.getCordYPonto(),Nodo.nodoSize,Nodo.nodoSize))){
            ponto.setCordXPonto(new Random().nextInt(Nodo.nodoSize,Tela.width)-Nodo.nodoSize);
            ponto.setCordYPonto(new Random().nextInt(Nodo.nodoSize,Tela.width)-Nodo.nodoSize);
            ponto.incrementPontos(1);
            cobrinha.addSize();
            System.out.println("Pontos: " + ponto.getPontuacao());
        }
    }

    @Override
    public void run() {
        while(true){
            tick();
            render();
            try {
                Thread.sleep(1000/20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}
