public class Ponto extends Nodo {

    private int pontuacao;
    private int cordXPonto,cordYPonto;

    public Ponto(int cordX, int cordY) {
        super(cordX, cordY);
        this.cordXPonto = cordX;
        this.cordYPonto = cordY;
        pontuacao = 0;
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
        this.pontuacao = pontuacao;
    }

    public void incrementPontos(int ponto){
        this.setPontuacao(this.getPontuacao()+ponto);
    }
}
