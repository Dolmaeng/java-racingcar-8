package racingcar;

@FunctionalInterface
interface MoveRules {
    /**
     * @return true if the car should move forward this turn
     */
    boolean shouldMove();
}