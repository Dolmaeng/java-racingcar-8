package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        //자동차 이름 입력
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String namesLine = Console.readLine();
        List<String> names = InputParser.parseNames(namesLine);
//        System.out.println("Test Inputs: " + names); /* 이름 입력 테스트 */

        //시도 횟수 입력
        System.out.println("시도할 횟수는 몇 회인가요?");
        String roundsLine = Console.readLine();
        int rounds = InputParser.parseRounds(roundsLine);
//        System.out.println("Test Inputs: " + rounds); /* 시도 횟수 입력 테스트 */

        //경주 실행
        RacingGame game = new RacingGame(names, rounds);
        MoveRules rule = new RandomMoveRule();
        game.play(rule);

        /*************************/
//        // 출력 테스트용 (game.play(rule) 주석 처리 후 실행)
//        System.out.println();
//        System.out.println("==== GAME START ====");
//        for (int r = 1; r <= rounds; r = r + 1) {
//            System.out.println("[Round " + r + "]");
//            for (Car car : game.getCars()) {
//                int value = Randoms.pickNumberInRange(0, 9);
//                boolean shouldMove = value >= 4;
//                System.out.println("  " + car.getName() + " → random: " + value
//                        + (shouldMove ? " (move)" : " (stay)"));
//                if (shouldMove) {
//                    car.move();
//                }
//            }
//            System.out.println();
//        }

        System.out.println("==== GAME RESULT ====");
        for (Car car : game.getCars()) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getPosition(); i = i + 1) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println("=====================");
        /*************************/

        //최종 Winner 출력
        int max = 0;
        for (Car car : game.getCars()) {
            if (car.getPosition() > max) {
                max = car.getPosition();
            }
        }
        java.util.List<String> winnerNames = new java.util.ArrayList<>();
        for (Car car : game.getCars()) {
            if (car.getPosition() == max) {
                winnerNames.add(car.getName());
            }
        }

        StringBuilder winnersLine = new StringBuilder();
        for (int i = 0; i < winnerNames.size(); i = i + 1) {
            winnersLine.append(winnerNames.get(i));
            if (i < winnerNames.size() - 1) {
                winnersLine.append(", ");
            }
        }
        System.out.println("최종 우승자 : " + winnersLine.toString());
    }
}
