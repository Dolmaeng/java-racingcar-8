package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        List<String> names = readNames();
        int rounds = readRounds();

        RacingGame game = new RacingGame(names, rounds);

        printExecutionHeader();
        runRounds(game.getCars(), rounds);
//        printFinalResult(game.getCars());
        printWinners(game.getCars());
    }

    // 사용자 입력 - 이름, 시도 횟수
    private static List<String> readNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String namesLine = Console.readLine();
        return InputParser.parseNames(namesLine);
    }

    private static int readRounds() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String roundsLine = Console.readLine();
        return InputParser.parseRounds(roundsLine);
    }

    // 게임 과정 조회
    private static void printExecutionHeader() {
        System.out.println();
        System.out.println("실행 결과");
    }

    private static void runRounds(List<Car> cars, int rounds) {
        for (int r = 1; r <= rounds; r = r + 1) {
            playOneRound(cars);
            printRound(cars);
            System.out.println();
        }
    }

    private static void playOneRound(List<Car> cars) {
        for (Car car : cars) {
            boolean shouldMove = drawAndDecide();
            if (shouldMove) {
                car.move();
            }
        }
    }

    private static boolean drawAndDecide() {
        int value = Randoms.pickNumberInRange(0, 9);
        if (value >= 4) {
            return true;
        }
        return false;
    }

    private static void printRound(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName());
            System.out.print(" : ");
            printDashes(car.getPosition());
            System.out.println();
        }
    }

    private static void printDashes(int count) {
        for (int i = 0; i < count; i = i + 1) {
            System.out.print("-");
        }
    }

    private static void printFinalResult(List<Car> cars) {
        System.out.println("==== GAME RESULT ====");
        for (Car car : cars) {
            System.out.print(car.getName());
            System.out.print(" : ");
            printDashes(car.getPosition());
            System.out.println();
        }
        System.out.println("=====================");
    }

    private static void printWinners(List<Car> cars) {
        int max = findMaxPosition(cars);
        List<String> winnerNames = collectWinners(cars, max);
        System.out.println("최종 우승자 : " + joinByCommaAndSpace(winnerNames));
    }

    // ---------- helpers ----------
    private static int findMaxPosition(List<Car> cars) {
        int max = 0;
        for (Car car : cars) {
            if (car.getPosition() > max) {
                max = car.getPosition();
            }
        }
        return max;
    }

    private static List<String> collectWinners(List<Car> cars, int max) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == max) {
                winners.add(car.getName());
            }
        }
        return winners;
    }


    private static String joinByCommaAndSpace(List<String> names) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < names.size(); i = i + 1) {
            sb.append(names.get(i));
            if (i < names.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
