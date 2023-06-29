import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Painel extends Canvas implements Runnable{
    private Cobra cobrinha;
    private Ponto ponto;
    private int tipoPonto;
    private boolean start,inGame;
    public Painel(){
        start = false;
        inGame = true;
        ponto = new Ponto(new Random().nextInt(Nodo.nodoSize,465),new Random().nextInt(Nodo.nodoSize*2,465));
        cobrinha = new Cobra();
        this.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    start = true;
                }
            }
        });
        addKeyListener(new TecladoAdp(cobrinha));
    }

    public void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }    
        Graphics g = bs.getDrawGraphics();
        // pintando de preto o Jframe
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Tela.width, Tela.height);
        // Lógica para a seleção dos tipos de pontos
        if(Ponto.pontuacao < 10){
            g.setColor(Color.ORANGE);
            g.fillRect(ponto.getCordXPonto(),ponto.getCordYPonto(), Nodo.nodoSize, Nodo.nodoSize);
            tipoPonto = 2;
        }else if(Ponto.pontuacao < 20){
            g.setColor(Color.BLUE);
            g.fillRect(ponto.getCordXPonto(),ponto.getCordYPonto(), Nodo.nodoSize, Nodo.nodoSize);
            tipoPonto = 3;
        }else{
            g.setColor(Color.YELLOW);
            g.fillRect(ponto.getCordXPonto(),ponto.getCordYPonto(), Nodo.nodoSize, Nodo.nodoSize);
            tipoPonto = 4;
        }
        // imprimindo a cobrinha 
        for (int i = 0; i < cobrinha.getCobra().size(); i++) {
            g.setColor(Color.GREEN);
            g.fillRect(cobrinha.getCobra().get(i).getCordX(), cobrinha.getCobra().get(i).getCordY(), Nodo.nodoSize, Nodo.nodoSize);
            
        }
        if(!inGame){
            genGameOver(g);
        }else if(!start){
            genMenu(g);
        }
        // texto que aparecerá a pontuação 
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.setColor(Color.WHITE);
        g.drawString("Pontos: "+Ponto.pontuacao, 5, 465);
        g.dispose();
        bs.show();
    }
    public void genGameOver(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Tela.width, Tela.height);
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.setColor(Color.RED);
        g.drawString("GAME OVER", 175, 230);
        g.dispose();
    }
    public void genMenu(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Tela.width, Tela.height);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.setColor(Color.WHITE);
        g.drawString("Pressione Enter para começar", 100, 230);
        g.dispose();
    }
    public void tick(){
        
        for(int i = cobrinha.getCobra().size()-1; i > 0; i--){// Fazendo com que os nodos sigão o primeiro nodo geredo
            cobrinha.getCobra().get(i).setCordX(cobrinha.getCobra().get(i-1).getCordX());
            cobrinha.getCobra().get(i).setCordY(cobrinha.getCobra().get(i-1).getCordY());
        }
        // fazendo com que a cobrinha retorne ao lado oposto da tela ao atravesar os limites da tela 
        if(cobrinha.getCobra().get(0).getCordX()+1<0){//esquerda para direita
            inGame = false;
        }else if(cobrinha.getCobra().get(0).getCordX() >=Tela.width){ // direita para esquerda
            inGame = false;
        }else if(cobrinha.getCobra().get(0).getCordY()+1<0){ // cima para baixo
            inGame = false;
        }else if(cobrinha.getCobra().get(0).getCordY() >=Tela.width){ // baixo para cima
            inGame = false;
        }

        if(cobrinha.getDirection()[0]){// lógica para a movimentação da cobrinha 
            cobrinha.getCobra().get(0).setCordX(cobrinha.getCobra().get(0).getCordX()+Nodo.nodoSize-6);

        } else if(cobrinha.getDirection()[1]){
            cobrinha.getCobra().get(0).setCordX(cobrinha.getCobra().get(0).getCordX()-Nodo.nodoSize+6);

        }else if(cobrinha.getDirection()[2]){
            cobrinha.getCobra().get(0).setCordY(cobrinha.getCobra().get(0).getCordY()-Nodo.nodoSize+6);

        }else if(cobrinha.getDirection()[3]){
            cobrinha.getCobra().get(0).setCordY(cobrinha.getCobra().get(0).getCordY()+Nodo.nodoSize-6);

        }
        // Detectando a colisão com os pontos 
        Rectangle col = new Rectangle(cobrinha.getCobra().get(0).getCordX(), cobrinha.getCobra().get(0).getCordY(), Nodo.nodoSize, Nodo.nodoSize);
        if(col.intersects(new Rectangle(ponto.getCordXPonto(),ponto.getCordYPonto(),Nodo.nodoSize,Nodo.nodoSize))){
            switch (tipoPonto){
                case 2:
                    ponto.setCordXPonto(new Random().nextInt(Nodo.nodoSize,465));
                    ponto.setCordYPonto(new Random().nextInt(Nodo.nodoSize*2,465));
                    ponto.incrementPontos();
                    break;
                case 3:
                   ponto.setCordXPonto(new Random().nextInt(Nodo.nodoSize,465));
                    ponto.setCordYPonto(new Random().nextInt(Nodo.nodoSize*2,465));
                    ponto.incrementPontos(tipoPonto);
                    break;
                case 4:
                    ponto.setCordXPonto(new Random().nextInt(Nodo.nodoSize,465));
                    ponto.setCordYPonto(new Random().nextInt(Nodo.nodoSize*2,465));
                    ponto.incrementPontos(tipoPonto);
                    break;
            }
            cobrinha.addSize();
        }
    }
    @Override
    public void run() {
        while(true){
            if(inGame && start){
                render();
                tick();
                try {
                    Thread.sleep(1000/20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                render();
            }
        }
    }    
}
