package baseball;

import java.util.*;

public class Baseball {
    public static final String INVALID_NUMBER_RANGE = "숫자 범위 초과";
    private static final String INVALID_NUMBER_DUPLICATE = "숫자 중복";
    public static final Integer MIN = 1;
    public static final Integer MAX = 9;
    public static final Integer NUMBER_SIZE = 3;
    public static final String INVALID_STATE = "잘못된 호출";
    private final List<Integer> numbers;

    public Baseball(List<Integer> numbers) {
        this.numbers = numbers;
        valid();
    }

    public Map<String, Integer> getCountWithResult(Baseball person) {
        Map<String, Integer> result = new LinkedHashMap<>();

        if (checkNothing(person)) {
            throw new IllegalStateException(INVALID_STATE);
        }
        if(getBallCount(person) != 0)
            result.put(ResultType.Ball.getName(), getBallCount(person));
        if(getStrikeCount(person) != 0)
            result.put(ResultType.Strike.getName(), getStrikeCount(person));

        return result;
    }

    public boolean checkNothing(Baseball person) {
        return getMatchCount(person) == 0;
    }

    public int getStrikeCount(Baseball person) {
        int count = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (Objects.equals(person.numbers.get(i), numbers.get(i))) {
                count++;
            }
        }

        return count;
    }

    public int getBallCount(Baseball person) {
        return getMatchCount(person) - getStrikeCount(person);
    }

    private int getMatchCount(Baseball person) {
        int matchCount = 0;
        for (Integer number : numbers) {
            if (person.numbers.contains(number)) {
                matchCount++;
            }
        }

        return matchCount;
    }

    private void valid() {
        for (Integer number : numbers) {
            validRange(number);
        }

        // validDuplicate(numbers);
    }

    private void validDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != NUMBER_SIZE) {
            throw new IllegalArgumentException(INVALID_NUMBER_DUPLICATE + " : " + numbers.stream().distinct().count());
        }
    }

    private void validRange(Integer number) {
        if (number < MIN || number > MAX) throw new IllegalArgumentException(INVALID_NUMBER_RANGE);
    }
}
