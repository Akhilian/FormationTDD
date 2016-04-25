package puissance4;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class GridTest {

    @Test
    public void new_shouldHave7Columns() throws Exception {
        Grid grid = new Grid();

        assertThat(grid.getColumnsCount()).isEqualTo(7);
    }

    @Test
    public void new_shouldHave6Rows() throws Exception {
        Grid grid = new Grid();

        assertThat(grid.getRowsCount()).isEqualTo(Column.ROWS_COUNT);
    }

    @Test
    public void getCellState_shouldReturnEMPTY() throws Exception {
        Grid grid = new Grid();

        assertThat(grid.getCellState(0, 0)).isEqualTo(Grid.EMPTY_STATE);
    }



    @Test
    public void addCoin_shouldModifyExpectedColumnState() throws  ColumnFullException {
        int columnIndex = 0;
        Grid grid = new Grid();

        grid.addCoin(columnIndex, Coin.RED);

        assertThat(grid.getColumnFreeSpace(columnIndex)).isEqualTo(5);
    }

    @Test
    public void clear_shouldReturnEmptyGrid() throws  ColumnFullException {
        Grid grid = new Grid();

        for (int columnIndex = 0; columnIndex < Grid.COLUMNS_COUNT; columnIndex++) {
            grid.addCoin(columnIndex, Coin.RED);
        }

        grid.clear();

        for (int columnIndex = 0; columnIndex < Grid.COLUMNS_COUNT; columnIndex++) {
            assertThat(grid.columns.get(columnIndex).getFreeSpaces()).isEqualTo(Column.ROWS_COUNT);
        }
    }
}