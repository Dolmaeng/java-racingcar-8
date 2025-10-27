package racingcar;

import java.util.ArrayList;
import java.util.List;

final class InputParser {
    private static final int MAX_NAME_LENGTH = 5;

    private InputParser() {
        // utility class
    }

    /*이름 입력 처리 메소드*/
    static List<String> parseNames(String line) {
        //널 체크
        if (line == null) {
            throw new IllegalArgumentException("이름 입력이 null입니다.");
        }

        //공백 제거
        String trimmed = line.trim();
        if (trimmed.isEmpty()) {
            throw new IllegalArgumentException("이름을 한 개 이상 입력해야 합니다.");
        }

        // 콤마 기준으로 스플릿
        String[] parts = trimmed.split(",");
        List<String> names = new ArrayList<>();


        for (String raw : parts) {
            String name;
            if (raw == null) {
                name = "";
            } else {
                name = raw.trim();
            }

            if (name.isEmpty()) {
                throw new IllegalArgumentException("빈 이름은 허용되지 않습니다.");
            }
            if (name.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException("이름은 5자 이하여야 합니다: " + name);
            }
            names.add(name);
        }
        return names;
    }

    /* 시도 횟수 입력 처리 메소드 */
    static int parseRounds(String line) {
        if (line == null) {
            throw new IllegalArgumentException("시도 횟수 입력이 null입니다.");
        }

        String trimmed = line.trim();
        if (trimmed.isEmpty()) {
            throw new IllegalArgumentException("시도 횟수는 1 이상의 정수여야 합니다.");
        }

        // 숫자만 허용
        for (int i = 0; i < trimmed.length(); i++) {
            char ch = trimmed.charAt(i);
            if (!Character.isDigit(ch)) {
                throw new IllegalArgumentException("시도 횟수는 숫자만 입력해야 합니다: " + trimmed);
            }
        }

        int rounds;
        try {
            rounds = Integer.parseInt(trimmed);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("시도 횟수 파싱에 실패했습니다: " + trimmed);
        }

        if (rounds <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상의 정수여야 합니다.");
        }
        return rounds;
    }

}
