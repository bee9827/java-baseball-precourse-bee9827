package baseball.controller;

import baseball.model.ResultType;
import baseball.model.Baseball;
import baseball.model.NumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.Objects;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;

    }

    public void playBaseBallGame() {
        Baseball machine = new Baseball(NumberGenerator.getBaseBallNumbers(Baseball.NUMBER_SIZE));
        //machine 명칭

        while (true) {
            Baseball person = new Baseball(inputView.askNumbers());
            printResult(machine, person);

            if (checkThreeStrike(machine, person)) break;
        }
        outputView.printCorrect(Baseball.NUMBER_SIZE);

        if (inputView.askContinue())
            playBaseBallGame();
    }

    private void printResult(Baseball machine, Baseball person) {
        if (machine.checkNothing(person)) {
            outputView.printString(ResultType.Nothing.getName());
        } else {
            outputView.printMap(machine.getCountWithResult(person));
        }
    }

    private boolean checkThreeStrike(Baseball machine, Baseball person) {
        return Objects.equals(machine.getStrikeCount(person), Baseball.NUMBER_SIZE);
    }


}
