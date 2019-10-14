public class Piece {
    
    private Position position;

    public boolean isValidMove(final Position newPosition) {
        final int rowStart = 0;
        final int rowEnd = 8;
        final int colStart = 0;
        final int colEnd = 8;

        if (newPosition.getRow() > rowStart && newPosition.getRow() < rowEnd
        && newPosition.getCol() > colStart && newPosition.getCol() < colEnd) {
            return true;
        }
        return false;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(final Position pos1) {
        this.position = position;
    }

    public final void move(final Position position) {
        if (isValidMove(position)) {
            setPosition(position);

        }
    }

}