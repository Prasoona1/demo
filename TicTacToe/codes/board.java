package board;

public class Board {
    public int size;
    public char matrix[][];

    public Board(int size, char symbol) {
        this.size = size;
        matrix = new char[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = symbol;
            }
        }
    }

    public void setDefaultCharacters(char defaultSymbol) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = defaultSymbol;
            }
        }
    }

    public void printBoard() {
        int s = this.size;
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
