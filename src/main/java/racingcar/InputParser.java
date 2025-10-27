package racingcar;

import java.util.ArrayList;
import java.util.List;

final class InputParser {
    private static final int MAX_NAME_LENGTH = 5;

    private InputParser() {
        // utility class
    }

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
//            String name = raw == null ? "" : raw.trim();
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
}
