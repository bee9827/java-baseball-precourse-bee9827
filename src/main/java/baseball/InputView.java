package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    private static final String INVALID_INPUT_EXCEPTION = "잘못된 입력";
    private static final String CONTINUE = "1";
    private static final String STOP = "2";
    private static final String INVALID_RESTART_INPUT_EXCEPTION = "1또는 2만 입력해주세요.";
    private Pattern pattern = Pattern.compile("^(\\d)(\\d)(\\d)$");

    public List<Integer> askNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String numbers = Console.readLine();
        Matcher matcher = pattern.matcher(numbers);

        valid(matcher);
        List<Integer> result = new ArrayList<>();

        if (matcher.matches()) {
            for (int i = 1; i <= matcher.groupCount(); i++) {
                result.add(toInteger(matcher.group(i)));
            }
        }

        return result;
    }

    public boolean askContinue() {
        System.out.printf("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.%n", CONTINUE, STOP);
        String numbers = Console.readLine();
        if (numbers.equals(CONTINUE)) {
            return true;
        }
        if (numbers.equals(STOP)) {
            return false;
        }
        throw new IllegalArgumentException(INVALID_RESTART_INPUT_EXCEPTION);
    }

    private Integer toInteger(String input) throws IllegalArgumentException {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_EXCEPTION);
        }
    }

    private void valid(Matcher matcher) throws IllegalArgumentException {
        if (!matcher.matches()) {
            throw new IllegalArgumentException(INVALID_INPUT_EXCEPTION);
        }
    }
}
