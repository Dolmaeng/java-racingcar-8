package racingcar;

import java.util.ArrayList;
import java.util.List;

final class RacingGame {
    private final List<Car> cars = new ArrayList<>();
    private final int rounds;

    RacingGame(List<String> names, int rounds) {
        if (names == null || names.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름 목록이 비어 있습니다.");
        }
        if (rounds <= 0) {
            throw new IllegalArgumentException("라운드 수는 1 이상의 정수여야 합니다.");
        }

        for (String n : names) {
            cars.add(new Car(n));
        }
        this.rounds = rounds; //테스트용 보관
    }

    /** 자동차 조회 get메소드 */
    List<Car> getCars() {
        return new ArrayList<>(cars);
    }

    /** round 조회 */
    int getRounds() {
        return rounds;
    }
}
