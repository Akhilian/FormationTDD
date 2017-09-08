const CellState = require('./CellState');

class Cell {

    constructor() {

    }

    getState() {
        return CellState.EMPTY;
    }
}

module.exports = Cell;