package racingcar;

import java.util.ArrayList;
import java.util.List;

final class InputParser {
    private static final int MAX_NAME_LENGTH = 5;

    private InputParser() {
        // utility class
    }

    /** 이름 입력 처리 */
    static List<String> parseNames(String line) {
        if (line == null) {
            throw new IllegalArgumentException("이름 입력이 null입니다.");
        }

        String trimmed = line.trim();
        if (trimmed.isEmpty()) {
            throw new IllegalArgumentException("이름을 한 개 이상 입력해야 합니다.");
        }

        String[] parts = trimmed.split(",");
        List<String> names = new ArrayList<>();

        for (String raw : parts) {
            String name = "";
            if (raw != null) {
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

    /** 라운드 입력 처리 */
    static int parseRounds(String line) {
        if (line == null) {
            throw new IllegalArgumentException("라운드 입력이 null입니다.");
        }

        String trimmed = line.trim();
        if (trimmed.isEmpty()) {
            throw new IllegalArgumentException("라운드는 1 이상의 정수여야 합니다.");
        }

        // 숫자만 허용
        for (int i = 0; i < trimmed.length(); i = i + 1) {
            char ch = trimmed.charAt(i);
            if (!Character.isDigit(ch)) {
                throw new IllegalArgumentException("라운드는 숫자만 입력해야 합니다: " + trimmed);
            }
        }

        int rounds;
        try {
            rounds = Integer.parseInt(trimmed);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("라운드 파싱에 실패했습니다: " + trimmed);
        }

        if (rounds <= 0) {
            throw new IllegalArgumentException("라운드는 1 이상의 정수여야 합니다.");
        }
        return rounds;
    }
}
