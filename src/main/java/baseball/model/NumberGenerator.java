package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    private static final String GENERATOR_NUMBER_DUPLICATE_EXCEPTION = "제너레이터 중복된 숫자";

    public static List<Integer> getBaseBallNumbers(int size){
        List<Integer> baseBallNumbers = new ArrayList<>();
        
        while(baseBallNumbers.size() < size) {
            Integer number = getRandomNumber();

            if(baseBallNumbers.contains(number)) {continue;}
            baseBallNumbers.add(number);
        }
        
        validDuplicate(baseBallNumbers);

        return baseBallNumbers;
    }

    private static void validDuplicate(List<Integer> baseBallNumbers) {
        if(baseBallNumbers.stream().distinct().count() != baseBallNumbers.size()) {
            throw new IllegalStateException(GENERATOR_NUMBER_DUPLICATE_EXCEPTION);
        }
    }

    private static int getRandomNumber() {
        return Randoms.pickNumberInRange(Baseball.MIN, Baseball.MAX);
    }
}
