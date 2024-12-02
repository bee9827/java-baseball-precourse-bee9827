package baseball.view;

import java.util.Map;

public class OutputView {
    public static final String ERROR_HEADER = "[ERROR] ";

    public void printMap(Map<String, Integer> countWithResult) {
        for (Map.Entry<String, Integer> entry : countWithResult.entrySet()) {
            if(entry.getValue() == 0) { continue;}
            System.out.print(entry.getValue() + entry.getKey() + " ");
        }
        System.out.println();
    }

    public void printString(String result){
        System.out.println(result);
    }

    public void printError(String errorMessage){
        System.out.println(ERROR_HEADER + errorMessage);
    }

    public void printCorrect(Integer numberCount) {
        System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료", numberCount);
    }

}
