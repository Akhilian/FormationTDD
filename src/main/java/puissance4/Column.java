package puissance4;

import java.util.LinkedList;
import java.util.List;

class Column {

    static final int ROWS_COUNT = 6;

    private static final String EMPTY_CELL = "EMPTY";

    private List<Coin> coins = null;

    Column() {
        this.coins = new LinkedList<>();
    }

    int getSize() {
        return  ROWS_COUNT;
    }

    void addCoin(Coin coin) throws ColumnFullException {
        if(this.getFreeSpaces() > 0) {
            this.coins.add(coin);
        } else {
            throw new ColumnFullException();
        }
    }

    int getFreeSpaces() {
        return ROWS_COUNT - coins.size();
    }

    String getState(int cellIndex) {
        if(coins.get(cellIndex) != null) {
            return coins.get(cellIndex).getColor();
        } else {
            return EMPTY_CELL;
        }
    }

    void clear() {
        this.coins.clear();
    }


}
