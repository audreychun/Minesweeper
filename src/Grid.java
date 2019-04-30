import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;



public class Grid extends Application {
    GridPane myGrid = new GridPane();
    Tile[][] tiles = new Tile[20][20];
    //Button test = new Button();


    public void start(Stage stage) {
        startGrid();
        createMines();
        for (int r = 0; r < 20; r++) {
            for (int c = 0; c < 20; c++) {
                if (!tiles[r][c].getMine()) {
                    checkMines(r, c);
                }

            }
        }

        myGrid.setGridLinesVisible(true);


        Scene scene = new Scene(myGrid, 600, 600, Color.ORANGE);

        stage.setTitle("GRID");
        stage.setScene(scene);
        stage.show();
    }

    public void processClick(ActionEvent event) {
        Tile t = (Tile) event.getSource();
        //myGrid.getChildren().remove(t);
        if(t.getContent().equals("0")) {
            removeZeroes(t.getTileC(), t.getTileR());
        }
        else{
            t.setText(t.getContent());
        }
        //run if statement
    }

    public void createMines() {
        int m = 30;
        while (m > 0) {
            for (int r = 0; r < 20; r++) {
                for (int c = 0; c < 20; c++) {
                    if (Math.random() * 100 > 99 && !tiles[r][c].getMine() && m != 0) {   // Need to make sure that the mines go EVERYWHERE, and not just the first 6 tiles.
                        tiles[r][c].setMineState(true);
                        tiles[r][c].setContent("m");
                        m--;
                    }

                }
            }
        }
    }

    public void startGrid() {
        for (int r = 0; r < 20; r++) {


            for (int c = 0; c < 20; c++) {

                Tile tile = new Tile();
                tile.setOnAction(this::processClick);

                tile.setTileC(c);
                tile.setTileR(r);
                tile.setMineState(false);
                tile.setContent("  ");
                //          tile.setText(" " + checkMines(r,c));

                myGrid.add(tile, r, c);
                tiles[r][c] = tile;

            }

        }

    }

    public int checkMines(int x, int y) {
        //if((tile.getTileR() >= (tiles[tile.getTileR()-1][tile.getTileC()]).getTileR() && (tile.getTileR() >= (tiles[tile.getTileR()+1][tile.getTileC()]).getTileR()) && (tile.getTileC() >= (tiles[tile.getTileR()][tile.getTileC()-1]).getTileC() && (tile.getTileC() >= (tiles[tile.getTileR()][tile.getTileC()+1]).getTileC())))){
        int counter = 0;
        for (int r = -1; r <= 1; r++) {
            for (int c = -1; c <= 1; c++) {                                                // This is for printing out the numbers on each tile
                if (x + r < 20 && x + r >= 0 && y + c < 20 && y + c >= 0) {
                    if (tiles[x + r][y + c].getMine()) {
                        tiles[x][y].setContent("" + counter);
                        counter++;
                    }
                }
            }
        }
        return counter;


    }


    public void removeZeroes(int x, int y) {

        if (tiles[y][x].getContent().equals("0") && !tiles[y][x].getContent().equals(":)")){
            tiles[y][x].setText(tiles[y][x].getContent());
            tiles[y][x].setContent(":)");
            for (int i = -1; i < 2; i++){
                for (int j = -1; j < 2; j++){
                    if (!(i == 0 && j == 0) && (x + i > 0) && (x + i < 20) && (y + j > 0) && (y + j < 20)){
                            removeZeroes(x+i,y+j);
                    }
                }
            }
        }
    }
}

