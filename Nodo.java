public abstract class Nodo {
    private int cordX, cordY;
    static final int nodoSize = 16;
    
    public Nodo(int cordX, int cordY) {
        this.cordX = cordX;
        this.cordY = cordY;
    }
    
    public int getNodoSize() {
        return nodoSize;
    }
    public int getCordX() {
        return cordX;
    }

    public void setCordX(int cordX) {
        this.cordX = cordX;
    }

    public int getCordY() {
        return cordY;
    }

    public void setCordY(int cordY) {
        this.cordY = cordY;
    }

}
