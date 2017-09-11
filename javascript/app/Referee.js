class Referee {

    constructor(grid, analyser, logger) {
        this.grid = grid;
        this.analyser = analyser;
        this.logger = logger;
    }

    play(column) {
        this.logger.writeGridStateInFile(this.grid);
        this.grid.addToken("YELLOW", column);
    }

    isGameEnded() {
        return this.analyser.isDraw() || this.analyser.hasWinner();
    }

}
module.exports = Referee;