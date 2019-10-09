public class Piece {
    Position position;

    public boolean isValidMove(Position newPosition) {
        if(newPosition.rowValue > 0 && newPosition.columnValue > 0
        && newPosition.rowValue < 8 && newPosition.columnValue < 8) {
            return true;
        } else {
            return false;
        }
    }
}