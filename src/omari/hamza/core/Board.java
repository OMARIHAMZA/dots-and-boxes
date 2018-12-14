package omari.hamza.core;

public class Board {

    private Box[][] boxes;
    private int n; // n*n Board
    private boolean givePlayerAnotherMove;


    public Board(int dimension) {
        this.n = dimension - 1;
        givePlayerAnotherMove = false; // True when a box is Surrounded
        boxes = new Box[n][n];
        int boxesNo = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boxesNo += 1;
                boolean hasTop = false, hasBottom = false, hasLeft = false, hasRight = false;
                String owner = "";
                boxes[i][j] = new Box(hasTop, hasBottom, hasLeft, hasRight, owner, boxesNo);
            }
        }
    }


    public boolean applyMove(int move, String playerName) {
        givePlayerAnotherMove = false;
        int row, column;
        Box currentBox;
        if (move < ((n + 1) * n)) {
            //Horizontal
            column = move % n;
            if (move < n) {
                //Top
                row = 0;
                currentBox = boxes[row][column];
                if (currentBox.isHasTop()) {
                    System.out.println("Invalid move, Try again!");
                    return false;
                }
                currentBox.setHasTop(true);
                if (isBoxSurrounded(row, column)) {
                    currentBox.setOwner(playerName);
                    givePlayerAnotherMove = true;
                }
            } else if (move >= n * n) {
                //Bottom
                row = n - 1;
                currentBox = boxes[row][column];
                if (currentBox.isHasBottom()) {
                    System.out.println("Invalid move, Try again!");
                    return false;
                }
                currentBox.setHasBottom(true);
                if (isBoxSurrounded(row, column)) {
                    currentBox.setOwner(playerName);
                    givePlayerAnotherMove = true;
                }
            } else {
                //Middle -> Apply move to two Boxes
                row = (move / n);
                currentBox = boxes[row][column];
                if (currentBox.isHasTop()) {
                    System.out.println("Invalid move, Try again!");
                    return false;
                }
                currentBox.setHasTop(true);
                if (isBoxSurrounded(row, column)) {
                    currentBox.setOwner(playerName);
                    givePlayerAnotherMove = true;
                }
                row -= 1;
                currentBox = boxes[row][column];
                if (currentBox.isHasBottom()) {
                    System.out.println("Invalid move, Try again!");
                    return false;
                }
                currentBox.setHasBottom(true);
                if (isBoxSurrounded(row, column)) {
                    currentBox.setOwner(playerName);
                    givePlayerAnotherMove = true;
                }
            }
        } else {
            //Vertical
            row = (move - ((n + 1) * n)) % n;
            if (move - ((n + 1) * n) < n) {
                //Left
                column = 0;
                currentBox = boxes[row][column];
                if (currentBox.isHasLeft()) {
                    System.out.println("Invalid move, Try again!");
                    return false;
                }
                currentBox.setHasLeft(true);
                if (isBoxSurrounded(row, column)) {
                    currentBox.setOwner(playerName);
                    givePlayerAnotherMove = true;
                }
            } else if (move >= ((n + 1) * n) + n * n) {
                //Right
                column = n - 1;
                currentBox = boxes[row][column];
                if (currentBox.isHasRight()) {
                    System.out.println("Invalid move, Try again!");
                    return false;
                }
                currentBox.setHasRight(true);
                if (isBoxSurrounded(row, column)) {
                    currentBox.setOwner(playerName);
                    givePlayerAnotherMove = true;
                }
            } else {
                //Middle
                column = (move - ((n + 1) * n) - row) / n;
                currentBox = boxes[row][column];
                if (currentBox.isHasLeft()) {
                    System.out.println("Invalid move, Try again!");
                    return false;
                }
                currentBox.setHasLeft(true);
                if (isBoxSurrounded(row, column)) {
                    currentBox.setOwner(playerName);
                    givePlayerAnotherMove = true;
                }
                column -= 1;
                currentBox = boxes[row][column];
                if (currentBox.isHasRight()) {
                    System.out.println("Invalid move, Try again!");
                    return false;
                }
                currentBox.setHasRight(true);
                if (isBoxSurrounded(row, column)) {
                    currentBox.setOwner(playerName);
                    givePlayerAnotherMove = true;
                }
            }
        }
        return givePlayerAnotherMove;
    }

    /*public boolean applyMoves(int boxNo, String line, String playerName) {
        if (boxNo > n * n || boxNo < 0) return false;
        int currentBoxNo = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (currentBoxNo == boxNo) {
                    Box resultBox = boxes[i][j];
                    if (line.equalsIgnoreCase("top")) {
                        if (resultBox.isHasTop()) {
                            System.out.println("Invalid Move");
                            return false;
                        }
                        resultBox.setHasTop(true);
                        if (isBoxSurrounded(i, j)) {
                            resultBox.setOwner(playerName);
                            givePlayerAnotherMove = true;
                        }
                    } else if (line.equalsIgnoreCase("bottom")) {
                        if (resultBox.isHasBottom()) {
                            System.out.println("Invalid Move");
                            return false;
                        }
                        resultBox.setHasBottom(true);
                        if (isBoxSurrounded(i, j)) {
                            resultBox.setOwner(playerName);
                            givePlayerAnotherMove = true;
                        }
                    } else if (line.equalsIgnoreCase("left")) {
                        if (resultBox.isHasLeft()) {
                            System.out.println("Invalid Move");
                            return false;
                        }
                        resultBox.setHasLeft(true);
                        if (isBoxSurrounded(i, j)) {
                            resultBox.setOwner(playerName);
                            givePlayerAnotherMove = true;
                        }
                    } else if (line.equalsIgnoreCase("right")) {
                        if (resultBox.isHasRight()) {
                            System.out.println("Invalid Move");
                            return false;
                        }
                        resultBox.setHasRight(true);
                        if (isBoxSurrounded(i, j)) {
                            resultBox.setOwner(playerName);
                            givePlayerAnotherMove = true;
                        }
                    }
                }
                currentBoxNo++;
            }
        }
        System.out.println(toString());
        return givePlayerAnotherMove;
    }*/

    public boolean isBoxSurrounded(int row, int column) {
        Box mBox = boxes[row][column];
        return mBox.isHasTop() && mBox.isHasBottom() && mBox.isHasLeft() && mBox.isHasRight();
    }

    public boolean isGameOver() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (boxes[i][j].getOwner().equals("")) {
                    return false;
                }
            }
        }
        return true;
    }

    public int numOfBoxesOwned(String playerName) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (boxes[i][j].getOwner().equals(playerName)) {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        StringBuilder s3 = new StringBuilder();
        StringBuilder s4 = new StringBuilder();
        int currentBoxNo = 0;
         /*
        Top Lines:
        LineNumber = BoxNo;

        Bottom Lines:
        LineNumber = BoxNo + n;

        Left Lines:
        LineNumber = (n+1)*n + current_row * n + current_column
        0,0 n=2 -> 6 + 0 + 0 = 6
        0,1 n=2 -> 6 + 0 + 1 = 7
        1,0 n=2 -> 6 + 2 + 0 = 8
        1,1 n=2 -> 6 + 2 + 1 = 9
        OR
        LineNumber = q + currentBox + row

        Right Lines:
        LineNumber = q + currentBox + row + 1
         */
        for (int i = 0; i < n; i++) {
            s1.setLength(0);
            s2.setLength(0);
            s3.setLength(0);
            s4.setLength(0);
            //Top and Left
            for (int j = 0; j < n; j++) {
                Box currentBox = boxes[i][j];
                if (currentBox.isHasTop()) {
                    s1.append("*-----");
                } else {
                    s1.append("*  ").append(currentBoxNo).append("  ");
                }
                if (currentBox.isHasLeft()) {
                    s2.append("|     ");
                    s3.append("|  ").append(currentBox.getOwner().equals("") ? " " : currentBox.getOwner()).append("  ");
                    s4.append("|     ");
                } else {
                    s2.append("      ");
                    s3.append(((n + 1) * n) + j * n + i).append("     ");
                    s4.append("      ");
                }
                currentBoxNo += 1;
            }
            s1.append("*");
            //Right
            /*
             Right Lines:
        LineNumber = q + currentBox + row + 1
             */
            Box currentBox = boxes[i][n - 1];
            if (currentBox.isHasRight()) {
                s2.append("|");
                s3.append("|");
                s4.append("|");
            } else {
                s2.append(" ");
                s3.append(((n + 1) * n) + n * n + i);
                s4.append(" ");
            }
            result.append(s1).append("\n").append(s2).append("\n").append(s3).append("\n").append(s4).append("\n");
        }
        currentBoxNo = n * n;
        //Bottom
        s1.setLength(0);
        for (int i = 0; i < n; i++) {
            Box currentBox = boxes[n - 1][i];
            if (currentBox.isHasBottom()) {
                s1.append("*-----");
            } else {
                s1.append("*  ").append(currentBoxNo).append("  ");
            }
            currentBoxNo += 1;
        }
        return result.append(s1).append("*\n").toString();
    }
}
