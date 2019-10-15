public class Queen extends Piece {

    private Position oldPosition;

    public Queen() {
        final int startRowPosition = 7;
        final int startColPosition = 2;
        this.oldPosition = new Position(startRowPosition, startColPosition);
    }
    
    public boolean isValidMove(final Position Position) {

        if (super.isValidMove(Position)) {

            final int rowDiff = Math.subtractExact(oldPosition.getRow(), Position.getRow());
            final int colDiff = Math.subtractExact(oldPosition.getCol(), Position.getCol());
            final int horizontal = Math.subtractExact(oldPosition.getRow(), Position.getRow());
            final int vertical = Math.subtractExact(oldPosition.getCol(), Position.getCol());

            if ((Math.abs(rowDiff) == Math.abs(colDiff)) || horizontal == 0 || vertical == 0) {
                return true;
            }

        }
        return false;
    }
}