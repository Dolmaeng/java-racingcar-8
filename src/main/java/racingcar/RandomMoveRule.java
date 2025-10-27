package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

final class RandomMoveRule implements MoveRules {

    @Override
    public boolean shouldMove() {
        int value = Randoms.pickNumberInRange(0, 9);
        if (value >= 4) {
            return true;
        }
        return false;
    }
}
