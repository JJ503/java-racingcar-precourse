### 미션 흐름에 따른 문제 이해

1. 게임 시작
    1. 경주 할 자동차 이름 입력
        - 이름은 쉼표(,) 기준으로 구분
        - 이름은 5자 이하만 가능
        - 입력 값 유효성 검사
            - 입력 값이 존재해야 한다
            - 구분 문자는 쉼표(,)를 사용해야 한다
            - 각 자동차 이름은 5자 이하여야 한다
            - 위 사항에 부합하지 않는 경우 예외 발생
                - 에러 문구는 “[ERROR]”로 시작되어야 한다
    2. 시도할 횟수 입력
        - 숫자를 입력해야 함
        - 숫자가 아닌 경우 예외 발생
            - 에러 문구는 “[ERROR]”로 시작되어야 한다

1. 시도 횟수만큼 자동차 경주 게임 진행
    1. 각 자동차의 전진 여부 결정
        - 각 자동차마다 0 ~ 9 사이의 무작위 값 선정
        - 4 이상인 경우 : 전진
        - 4 미만인 경우 : 그 자리
    2. 각 차수별 실행 결과 출력
        - 각 자동차의 위치 출력
            - **예시**

                ```
                pobi : --
                woni : ----
                jun : ---
                ```


1. 최종 우승자 출력
    - 단독 우승자인 경우
        - 우승자 이름 출력

            ```
            최종 우승자 : pobi
            ```

    - 우승자가 여러 명일 경우
        - 이름은 쉼표로 구분

            ```
            최종 우승자 : pobi, jun
            ```

<br>

---
## 기능에 따른 분류
### RacingCarGameController

> 게임을 한 번 수행했을 때에 대한 절차를 관리하는 클래스

- [ ]  게임 진행
    - [ ]  객체 초기화
    - [ ]  자동차 이름 입력 받기
    - [ ]  시도할 횟수 입력 받기
    - [ ]  시도 횟수만큼 RacingCarGame 호출
    - [ ]  최종 우승자 출력

### RacingCarGame

> 한 차수의 실행에 대한 절차를 관리하는 클래스

- [ ]  각 자동차별로 무작위 값 구하기
- [ ]  4 이상인 경우 해당 자동차 전진시키기

### Car

> 자동차 하나에 대한 정보를 담는 객체로 자동차의 이름과 전진 위치를 관리하는 클래스

- [ ]  객체 초기화
    - [ ]  자동차 이름 저장
    - [ ]  전진 위치를 0으로 초기화
- [ ]  한 칸 전진시키기
- [ ]  전진 위치 반환
    - [ ]  `Collections.unmodifiableList()`을 통해 외부에서 변경하지 못하도록 하기

### Racing**RandomNumberGenerator**

> 0에서 9 사이에서 무작위 값을 생성해주는 클래스

- [ ]  0 ~ 9 사이의 무작위 값 생성

### **InputView**

> 사용자가 입력해야 하는 기능을 모아둔 클래스

- [x]  경주할 자동차의 이름 입력
- [ ]  시도할 횟수 입력
    - [ ]  입력 값이 숫자가 아니라면 예외 발생
        - 에러 문구는 “[ERROR]”로 시작되어야 한다

          → ex) `[ERROR] 시도 횟수는 숫자여야 한다.`


### **OutputView**

> 사용자에게 출력되는 기능들을 모아둔 클래스

- [ ]  차수별 실행 결과 출력
- [ ]  최종 우승자 출력