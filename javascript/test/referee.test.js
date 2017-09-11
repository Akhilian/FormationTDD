const should = require('chai').should();
const sinon = require('sinon');

const Analyser = require('../app/Analyser');
const Referee = require('../app/Referee');
const Grid = require('../app/Grid');
const Logger = require('../app/Logger');


describe.only('Referee', () => {
    it.skip('should', () => {

        const analyser = new Analyser();
        sinon.stub(analyser, 'hasWinner').returns(43);

        const result = analyser.hasWinner();

        result.should.equal(43);

    });

    it('should make yellow play as the first player', () => {
        // Given
        const grid = new Grid();
        const gridMock = sinon.mock(grid);
        const logger = new Logger();
        gridMock.expects("addToken").once().withArgs("YELLOW", 5);
        const referee = new Referee(grid, null, logger);

        // When
        referee.play(5);

        // Then
        gridMock.verify();
    });

    it('should tells us that game is ended when there is a draw', () => {
        const grid = new Grid();
        const analyser = new Analyser(grid);
        sinon.stub(analyser, "isDraw").returns(true)
        const referee = new Referee(grid, analyser);

        const gameEnded = referee.isGameEnded();

        gameEnded.should.equal(true);
    });

    it('should tells us that game is running', () => {
        const grid = new Grid();
        const analyser = new Analyser(grid);
        sinon.stub(analyser, "isDraw").returns(false);
        sinon.stub(analyser, "hasWinner").returns(true);
        const referee = new Referee(grid, analyser);

        const gameEnded = referee.isGameEnded();

        gameEnded.should.equal(true);
    });

    it('should write grid state in a file', () => {
        const grid = new Grid();
        const analyser = new Analyser(grid);
        const logger = new Logger();
        const loggerMock = sinon.mock(logger);
        loggerMock.expects("writeGridStateInFile").once().withArgs(grid);
        const referee = new Referee(grid, analyser, logger);

        referee.play(5);

        loggerMock.verify();
    })


    // Stub => Quand l'inventaire me répond 10
    // Stub => Quand l'inventaire me répond 5
    // Mock => Combien dans l'inventaire ?
});