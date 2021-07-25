// https://leetcode.com/problems/sudoku-solver

class Solution {

    /**
     * State of a bitset where all digits [1..9] are present.
     */
    private static final int ALL_SET = 0b111_111_111_0;

    /**
     * Box indices by row and column. Don't recompute what can be a constant :-)
     */
    private static final int[][] BOX_INDICES = {
            {0, 0, 0, 1, 1, 1, 2, 2, 2},
            {0, 0, 0, 1, 1, 1, 2, 2, 2},
            {0, 0, 0, 1, 1, 1, 2, 2, 2},
            {3, 3, 3, 4, 4, 4, 5, 5, 5},
            {3, 3, 3, 4, 4, 4, 5, 5, 5},
            {3, 3, 3, 4, 4, 4, 5, 5, 5},
            {6, 6, 6, 7, 7, 7, 8, 8, 8},
            {6, 6, 6, 7, 7, 7, 8, 8, 8},
            {6, 6, 6, 7, 7, 7, 8, 8, 8}
    };

    /**
     * This helper object provides a convenient API to iterate over the not-yet-filled cells of the Sudoku board.
     */
    private final SudokuSequence sequence = new SudokuSequence();

    /**
     * Current Sudoku board.
     */
    private char[][] board;


    ////// THE SOLUTION //////
    public void solveSudoku(char[][] board) {
        this.board = board;
        // fill the sequence
        sequence.init();
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char c = board[row][col];
                if (c == '.') {
                    sequence.add(row, col);
                    continue;
                }
                sequence.flip(row, col, c - '0');
            }
        }
        if (!solve(0)) {
            throw new IllegalArgumentException("Unsolvable Sudoku!");
        }
    }

    /**
     * Performs DFS (with some optimization) to find the first valid solution of the Sudoku puzzle ({@link #board}).
     * <p>Invalid solutions (dead-ends) are reverted to the last valid state (backtracking), never to be considered again.
     *
     * @param position current position of a cell in the {@link #sequence}
     * @return true if solution was found, false if it can't be found for a given state of the board
     */
    private boolean solve(int position) {
        if (position == sequence.size) return true; // base case: we reached the end and all the cells can be filled

        int easiest = sequence.easiest(position);
        if (easiest < 0) {
            return false;
        }
        sequence.swap(position, easiest); // move the easiest cell to the current position

        int row = sequence.row(position);
        int col = sequence.col(position);
        int set = sequence.digits(position);

        for (int lo = 1, digit; lo <= 9; lo = digit + 1) {
            digit = nextDigit(set, lo);
            if (digit > 9) break;

            sequence.flip(row, col, digit); // place the digit

            // proceed with the DFS
            if (solve(position + 1)) {
                board[row][col] = (char) ('0' + digit); // fill the board as the recursion unwinds
                return true;
            }
            // if a solution is not found, backtrack and try the next digit

            sequence.flip(row, col, digit);
        }
        sequence.swap(position, easiest); // revert modification to the sequence
        return false;
    }


    /**
     * Calculates the next digit absent from a set.
     *
     * @param set    bitset of placed digits
     * @param lowest lowest digit to consider
     * @return digit [1..9] if available or some value > 9 if the all the bits [1..9] are 1-s
     */
    private static int nextDigit(int set, int lowest) {
        set >>>= lowest;
        return Integer.numberOfTrailingZeros(~set) + lowest;
    }

    /**
     * Calculates the box index for given cell on a board.
     *
     * @param row column index
     * @param col row index
     * @return box index
     */
    private static int box(int row, int col) {
        return BOX_INDICES[row][col];
    }

    /**
     * This auxiliary class represents a sequence of unfilled Sudoku cells.
     * It is implemented as a structure of arrays (SoA) to reduce the need for heap allocations.
     */
    private static final class SudokuSequence {

        /**
         * Bitmap of the present digits by row.
         *
         * @see #digits
         */
        int[] rows;

        /**
         * Bitmap of the present digits by column.
         */
        int[] cols;

        /**
         * Bitmap of the present digits by box.
         */
        int[] boxes;

        /**
         * Mapping of the sequence position to the row index on the board.
         */
        final int[] rowSeq = new int[81];

        /**
         * Mapping of the sequence position to the column index on the board.
         */
        final int[] colSeq = new int[81];

        /**
         * Actual size of the sequence (number of the unfilled cells on the initial board).
         */
        int size;

        /**
         * Resets the state of the sequence.
         * <p>{@link #rowSeq} and {@link #colSeq} and not re-allocated,
         * we will just overwrite old values as we add new onex.
         */
        void init() {
            rows = new int[9];
            cols = new int[9];
            boxes = new int[9];
            size = 0;
        }

        /**
         * Add a new entry into the sequence.
         *
         * @param row row index
         * @param col column index
         */
        void add(int row, int col) {
            rowSeq[size] = row;
            colSeq[size] = col;
            size++;
        }

        /**
         * Given a starting position in this sequence,
         * finds in its remaining part the position which is the easiest to fill.
         * <p>Easiest here meaning that it can be filled with the least amount of possible digits, ideally just 1
         * (meaning that the rest 8 digits are already present in the respective row, column and box).
         * <p>This rather basic heuristic allows us to dramatically prune the branches of our DFS.
         * Given that most sudoku puzzles have only 1 valid solution meant to be found by a human,
         * there should almost always be a cell on a board which has only 1 valid value.
         *
         * @param from lower bound of the search
         * @return position that is the easiest to fill, or -1 if it can't be found or if the sequence state is invalid
         */
        int easiest(int from) {
            int easiest = -1, maxPopulation = 0;
            for (int i = from; i < size; i++) {
                int set = digits(i);
                if (set == ALL_SET) return -1; // if all digits are taken, then current solution is invalid
                int population = Integer.bitCount(set);
				if (population == 8) return i;
                if (population > maxPopulation) {
                    easiest = i;
                    maxPopulation = population;
                }
            }
            return easiest;
        }

        /**
         * Swaps two values in the sequence.
         *
         * @param p1 position of the first cell in this sequence
         * @param p2 position of the second cell in this sequence
         */
        void swap(int p1, int p2) {
            int tmpR = rowSeq[p1], tmpC = colSeq[p1];
            rowSeq[p1] = rowSeq[p2];
            rowSeq[p2] = tmpR;
            colSeq[p1] = colSeq[p2];
            colSeq[p2] = tmpC;
        }

        /**
         * Builds a bitset that contains the digits that are present in the row, column and box of a given cell.
         * <p>Digits are stored as 1-flags in their respective positions e.g. set with value {@code 0b101_000_001_0}
         * indicates the presence of the digits '1', '7', and '9'.
         * <p>The usage of bitsets here allows for an extremely efficient checking of the problem's core constraint.
         * Using some trickery {@link #nextDigit(int, int)} we can even iterate over just the un-placed digits in such a set.
         *
         * @param position position of the cell in this sequence
         * @return bitset of present digits
         */
        int digits(int position) {
            int ri = rowSeq[position], ci = colSeq[position], bi = box(ri, ci);
            return rows[ri] | cols[ci] | boxes[bi];
        }

        /**
         * Returns a row index of a cell.
         *
         * @param position position of a cell in this sequence
         * @return row index
         */
        int row(int position) {
            return rowSeq[position];
        }

        /**
         * Returns a column index of a cell.
         *
         * @param position position of a cell in this sequence
         * @return column index
         */
        int col(int position) {
            return colSeq[position];
        }

        /**
         * Flips the bit that indicates the presence of a digit in the given row, column, and box.
         *
         * @param row row index
         * @param col column index
         * @param val digit to set/unset
         */
        void flip(int row, int col, int val) {
            int bit = 1 << val;
            rows[row] ^= bit;
            cols[col] ^= bit;
            boxes[box(row, col)] ^= bit;
        }
    }

}