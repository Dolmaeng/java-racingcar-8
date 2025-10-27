package racingcar;

final class Car {
    private final String name;
    private int position = 0;

    Car(String name) {
        if (name == null) {
            throw new IllegalArgumentException("자동차 이름이 null입니다.");
        }
        String trimmed = name.trim();
        if (trimmed.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름이 비어 있습니다.");
        }
        this.name = trimmed;
    }

    String getName() {
        return name;
    }

    int getPosition() {
        return position;
    }

    void move() {
        position = position + 1;
    }
}
