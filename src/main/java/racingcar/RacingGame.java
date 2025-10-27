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
        this.rounds = rounds;
    }

    /**
     * rounds 만큼 진행하며 MoveRules 에 따라 각 Car 의 position 을 업데이트
     */
    void play(MoveRules rule) {
        if (rule == null) {
            throw new IllegalArgumentException("MoveRules 가 null 입니다.");
        }

        for (int r = 0; r < rounds; r = r + 1) {
            playOneRound(rule);
        }
    }

    // Car 마다 rule 체크 후, move
    private void playOneRound(MoveRules rule) {
        for (Car car : cars) {
            boolean shouldMove = rule.shouldMove();
            if (shouldMove) {
                car.move();
            }
        }
    }

    // get 메소드
    List<Car> getCars() {
        return new ArrayList<>(cars);
    }
}
