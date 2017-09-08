const assert = require('assert');
const expect = require('chai').expect;
const should = require('chai').should();
const Grid = require('../app/Grid');
const Cell = require('../app/Cell');
const CellState = require('../app/CellState');

function _assertThatGridIsEmpty(grid) {
    for (let columnIndex = 0; columnIndex < grid.getColumnsCount(); columnIndex++) {
        for (let rowIndex = 0; rowIndex < grid.getRowsCount(); rowIndex++) {
            grid.getCellState(columnIndex, rowIndex).should.equal(CellState.EMPTY);
        }
    }
}

describe('Grid', () => {

    it('should have 7 columns', () =>{
        const grid = new Grid();

        grid.getColumnsCount().should.equal(7);
    } );
    it('should have 6 rows', () => {
        const grid = new Grid();

        grid.getRowsCount().should.equal(6);
    });

    it('should have 42 cells that should be empty', () => {
        const grid = new Grid();

        _assertThatGridIsEmpty(grid);
    });

    it('can add a token in a column and place at the bottom', () => {
        const grid = new Grid();
        let firstCellInColumn = 0;
        let column = 0;

        grid.addToken(CellState.RED, column);

        grid.getCellState(column, firstCellInColumn).should.equal(CellState.RED);
    });

    it('can be empty', () => {
        // Given
        const grid = new Grid();
        let column = 2;
        grid.addToken(CellState.YELLOW, column);

        // When
        grid.clean();

        // Then
        _assertThatGridIsEmpty(grid);
    });

    it('should preserve token order', () => {
        const grid = new Grid();
        const column = 1;

        grid.addToken(CellState.YELLOW, column);
        grid.addToken(CellState.RED, column);

        const firstCellInColumn = 0;
        const secondCellInColumn = 1;

        grid.getCellState(column, firstCellInColumn).should.equal(CellState.YELLOW);
        grid.getCellState(column, secondCellInColumn).should.equal(CellState.RED);
    });

    it('should prevent adding a token in a full column', () => {
        //Given
        const grid = new Grid();
        const column = 5;

        for(let i = 0; i < grid.getRowsCount(); i++) {
            grid.addToken(CellState.RED, column);
        }

        try {
            //When
            grid.addToken(CellState.RED, column);
            assert.fail('Should not be reached');
        } catch (err) {
            //Then
            err.message.should.equal('La colonne est pleine.');
        }
    });
});

describe('Cell', () => {
    it('should have an empty state by default', () => {
        const cell = new Cell();

        cell.getState().should.equal(CellState.EMPTY);
    });
});
