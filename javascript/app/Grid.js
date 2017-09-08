const { EMPTY } = require('./CellState');

class Grid {

    constructor() {
        this.clean();

    }

    getColumnsCount() {
        return 7;
    }

    getRowsCount() {
        return 6;
    }

    clean() {
        this._grid = [
            [EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY],
            [EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY],
            [EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY],
            [EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY],
            [EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY],
            [EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY],
            [EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY],
        ];
    }

    addToken(token, column) {
        let emptyRow = null;
        let cellState;

        for(let rowIndex = 0; rowIndex < this.getRowsCount(); rowIndex++) {
            cellState = this._grid[column][rowIndex];

            if(cellState === EMPTY && emptyRow == null) {
                emptyRow = rowIndex;
            }
        }

        if(emptyRow == null) {
            throw new Error('La colonne est pleine.');
        } else {
            this._grid[column][emptyRow] = token;
        }
    }

    getCellState(column, row) {
        return this._grid[column][row];
    }
}

module.exports = Grid;