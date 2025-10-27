package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
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

        // 게임 생성
        RacingGame game = new RacingGame(names, rounds);


        // 라운드별 게임 진행 및 목표 포맷에 맞게 출력
        System.out.println();
        System.out.println("실행 결과");

        for (int r = 1; r <= rounds; r = r + 1) {
            // 각 차에 대해 난수 생성 및 이동 판단
            for (Car car : game.getCars()) {
                int value = Randoms.pickNumberInRange(0, 9);
                boolean shouldMove = value >= 4;
                if (shouldMove) {
                    car.move();
                }
            }

            // 라운드 결과 출력
            for (Car car : game.getCars()) {
                System.out.print(car.getName());
                System.out.print(" : ");
                int pos = car.getPosition();
                for (int i = 0; i < pos; i = i + 1) {
                    System.out.print("-");
                }
                System.out.println();
            }
            System.out.println();
        }

        // Winner 출력
        int max = 0;
        for (Car car : game.getCars()) {
            if (car.getPosition() > max) {
                max = car.getPosition();
            }
        }
        List<String> winnerNames = new ArrayList<>();
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
