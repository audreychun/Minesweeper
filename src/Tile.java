import javafx.scene.control.Button;

public class Tile extends Button {
    private String content = "  ";
    private int numMines;
    private boolean hasMine;
    private boolean isClicked;
    private int r;
    private int c;

    public Tile() {
        super();
        //super.setText(content);
        hasMine = false;
        setPrefSize(30,30);

    }

    public Tile(int r, int c, boolean mine, int bombs) {
        this.r = r;
        this.c = c;
        hasMine = mine;
        setPrefSize(30,30);
        //setText(content);

    }
    public void setBomb(int x){

    }

    public int getTileR() {
        return r;
    }

    public int getTileC() {
        return c;
    }

    public void setTileR(int r) {
        this.r = r;
    }

    public void setTileC(int c) {
        this.c = c;
    }

    public void setMineState(boolean mine) {
        hasMine = mine;
    }

    public boolean getMine() {
        return hasMine;
    }

    public void setContent(String string) {
        content = string;
        //setText(content);
    }


    public String getContent() {
        return content;
    }

}
