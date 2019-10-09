public class Queen extends Piece {
    public boolean isValidMove(Position newPosition) {
        if(newPosition.columnValue == this.columnValue || newPosition.rowValue == this.rowValue) {
            return true;
        } else {
            return false;
        }
    }
}