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
        System.out.println("Test Inputs: " + rounds); /* 시도 횟수 입력 테스트 */

    }
}
