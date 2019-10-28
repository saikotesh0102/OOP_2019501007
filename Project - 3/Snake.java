public class Snake {
    /**
     * Snake class fields Start and End
     */
    private int start;
    private int end;
    /**
     * Constructor for the class Snake
     * @param start
     * @param end
     */
    public Snake(final int start, final int end) {
        this.start = start;
        this.end = end;
    }
    /**
     * Setters and Getters
     * @return
     */
    public int getStart() {
        return start;
    }

    public void setStart(final int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(final int end) {
        this.end = end;
    }
}