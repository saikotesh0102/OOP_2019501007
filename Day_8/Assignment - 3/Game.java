public class Game extends Piece {

    /**
     * chess board a 2D Array.
     */
    private Piece[][] chessBoard;
    /**
     * constructor.
     */
    public Game() {
        final int rowLimit = 8;
        final int columnLimit = 8;
        this.chessBoard = new Piece[rowLimit][columnLimit];
    }

    /**
     *
     * @param args command line arguments
     */
    public static void main(final String[] args) {
        Queen q = new Queen();
        final int row1 = 6;
        final int col1 = 1;
        Position test1 = new Position(row1, col1);
        System.out.println(q.isValidMove(test1));
        final int row2 = 6;
        final int col2 = 3;
        Position test2 = new Position(row2, col2);
        System.out.println(q.isValidMove(test2));
        final int row3 = 2;
        final int col3 = 3;
        Position test3 = new Position(row3, col3);
        System.out.println(q.isValidMove(test3));
        final int row4 = 1;
        final int col4 = 5;
        Position test4 = new Position(row4, col4);
        System.out.println(q.isValidMove(test4));
        final int row5 = 4;
        final int col5 = 2;
        Position test5 = new Position(row5, col5);
        System.out.println(q.isValidMove(test5));
        final int row6 = 6;
        final int col6 = 1;
        Position test6 = new Position(row6, col6);
        System.out.println(q.isValidMove(test6));
    }
}