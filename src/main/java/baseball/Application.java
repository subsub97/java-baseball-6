package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        while (true) {
            System.out.println("숫자 야구 게임을 시작합니다.");

            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }

            //System.out.printf("%d%d%d\n", computer.get(0), computer.get(1), computer.get(2));

            while (true) {
                String input = Console.readLine();
                int strikeCount = 0;
                int ballCount = 0;
                if (input.length() != 3) {
                    System.out.println("길이가 길어서 예외 발생합니다...");
                }
                List<Integer> enter = new ArrayList<>();
                // 비교하기
                for (int i = 0; i < 3; i++) {
                    // 입력 숫자 받아줄 리스트
                    enter.add(Character.getNumericValue(input.charAt(i)));
                    //스트라이크 카운트 세기
                    if (computer.get(i) == enter.get(i)) {
                        strikeCount++;
                    }
                }


                for (int i = 0; i < 3; i++) {
                    if (computer.contains(enter.get(i))) {
                        //포함하고있는 경우 ball인지 판단
                        if (computer.get(i) == enter.get(i)) {
                            continue;
                        }
                        ballCount++;
                    }
                }
                if(strikeCount == 0 && ballCount ==0) {
                    System.out.println("낫싱");
                } else if (strikeCount == 3) {
                    //System.out.println("정답입니다~~~ 추키포카 \n \\(__)/ \\(__)/ \\(__)/  \n");
                    System.out.printf("%d스트라이크\n",strikeCount);
                    System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
                    break;

                } else if (strikeCount == 0 && ballCount >0) {
                    System.out.printf("%d볼\n",ballCount);

                } else if (strikeCount >0 && ballCount ==0) {
                    System.out.printf("%d스트라이크\n",strikeCount);
                } else {
                    System.out.printf("%d볼 %d스트라이크 입니다.\n",ballCount, strikeCount);
                }

            }
            String askRegame = Console.readLine();
            if(askRegame.equals("2")){
                //System.out.println("게임을 종료합니다 :)");
                break;
            }
            //System.out.println("게임을 재시작 합니다 :(");



        }
    }
}
