# java-racingcar-precourse



## Constraints 
- **JDK 21** 기준, 엔트리포인트: `racingcar.Application.main`.
- **mission-utils** 라이브러리의 `Console`, `Randoms` API만 사용 가능.
- Indent 깊이 **최대 2단계**, 삼항 연산자 금지. -> 메소드를 최대한 쪼개면 뎁스 낮출 수  있음
- [Java Style Guide](https://github.com/woowacourse/woowacourse-docs/blob/main/styleguide/java) 준수.
- `build.gradle` 수정 금지, 외부 라이브러리 추가 금지.

## Architecture
- **Application**
    - 프로그램의 시작점. 입력 → 게임 실행 → 출력 순서로 흐름 제어.
- **InputParser**
    - `parseNames(String)` → `List<String>` (빈 문자열, 5자 초과 이름 검증)
    - `parseRounds(String)` → `int` (양의 정수 검증)
- **Car**
    - `name`, `position`, `move()` 보유.
- **MoveRules** (Functional Interface)
    - `boolean shouldMove()` 정의.
    - **RandomMoveRule**: `Randoms.pickNumberInRange(0,9) >= 4` 일 때 true 반환.
- **RacingGame**
    - `play(List<Car> cars, int rounds, MoveRules rule)`
    - 주어진 라운드 수만큼 반복하며 position 업데이트.
- **ResultView**
    - `printRound(List<Car>)` : `"name : ---"` 형태 출력.
    - `printWinners(List<String>)` : `"최종 우승자 : pobi, jun"` 출력.
- **WinnerFinder**
    - `findWinners(List<Car>)` → `List<String>` (최대 position 기준 복수 우승자 처리)

> 목적: 입력, 게임 로직, 규칙, 출력 단계를 완전히 분리하여 **작은 메서드** 중심으로 설계.

## Feautres (커밋 단위)
이름 입력/검증  
시도 횟수 입력/검증  
이동 로직 (≥4 시 전진)  
n라운드 실행 & 위치 업데이트  
라운드 단위 출력
우승자 계산/출력  
입력 예외 처리 (IllegalArgumentException)  
단일 책임화 및 indent ≤ 2 유지 (리팩토링)  
테스트 (JUnit5 + AssertJ)
g