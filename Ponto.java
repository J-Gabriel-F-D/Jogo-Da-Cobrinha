public class Ponto extends Nodo implements Pontuacao {

    static int pontuacao;
    private int cordXPonto,cordYPonto;

    public Ponto(int cordX, int cordY) {
        super(cordX, cordY);
        this.cordXPonto = cordX;
        this.cordYPonto = cordY;
        pontuacao = 0;
    }
    public Ponto(){
        this.cordXPonto = 0;
        this.cordYPonto = 0;
    }
    
    public int getCordYPonto() {
        return cordYPonto;
    }
    public void setCordYPonto(int cordYPonto) {
        this.cordYPonto = cordYPonto;
    }
    public int getCordXPonto() {
        return cordXPonto;
    }
    public void setCordXPonto(int cordXPonto) {
        this.cordXPonto = cordXPonto;
    }
    public int getPontuacao() {
        return pontuacao;
    }
    public void setPontuacao(int pontuacao) {
        Ponto.pontuacao = pontuacao;
    }
    @Override
    public void incrementPontos() {
        this.setPontuacao(this.getPontuacao()+1);
    }
    @Override
    public void incrementPontos(int ponto) {
        this.setPontuacao(this.getPontuacao()+ponto);    
    }
}
