package puissance4;

import java.util.ArrayList;
import java.util.List;

public class Grid {

    public static final int COLUMNS_COUNT = 7;
    public static final String EMPTY_STATE = "EMPTY";

    List<Column> columns;

    public Grid() {
        columns = new ArrayList<Column>();

        for (int i = 0; i < COLUMNS_COUNT; i++) {
            columns.add(new Column());
        }
    }

    public int getColumnsCount() {
        return COLUMNS_COUNT;
    }

    public int getRowsCount() {
        return Column.ROWS_COUNT;
    }

    public String getCellState(int column, int row) {
        return EMPTY_STATE;
        /*return columns.get(column).getAt(row);*/
    }

    public void addCoin(int column, String color) throws ColumnFullException {
        this.columns.get(column).addCoin(new Coin(color));
    }

    public int getColumnFreeSpace(int columnIndex) {
        return this.columns.get(columnIndex).getFreeSpaces();
    }

    public void clear() {
        columns.stream().forEach(column -> column.clear());
    }
}
