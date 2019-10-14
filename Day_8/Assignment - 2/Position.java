public class Position {
    
    private int row;
    private int col;
    
    public Position(final int rowPosition, final int colPosition) {
        this.row = rowPosition;
        this.col = colPosition;
    }
    
    public void setRow(final int row) {
        this.row = row;
    }

    public int getRow() {
        return row;
    }

    public void setCol(final int col) {
        this.col = col;
    }

    public int getCol() {
        return col;
    }

}