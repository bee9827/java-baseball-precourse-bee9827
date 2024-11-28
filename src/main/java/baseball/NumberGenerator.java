package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    public static List<Integer> getBaseBallNumbers(){
        List<Integer> baseBallNumbers = new ArrayList<>();

        while(baseBallNumbers.size() < Baseball.NUMBER_SIZE) {
            Integer number = getRandomNumber();

            if(baseBallNumbers.contains(number)) {continue;}
            baseBallNumbers.add(number);
        }

        return baseBallNumbers;
    }

    private static int getRandomNumber() {
        return Randoms.pickNumberInRange(Baseball.MIN, Baseball.MAX);
    }
}
