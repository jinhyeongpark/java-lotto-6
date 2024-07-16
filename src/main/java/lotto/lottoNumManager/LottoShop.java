package lotto.lottoNumManager;


import lotto.lottoExceptions.ExceptionMessages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LottoShop {
    private int money;
    public LottoShop(){ //로또 구매에 지불한 금액을 반환
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            try {
                int inputmoney = Integer.parseInt(br.readLine());
                if (inputmoney % 1000 != 0) {
                    System.out.println(ExceptionMessages.MONEY_NOT_DIVIDED_BY_1000);
                    continue;
                }
                money = inputmoney;
                return;
            } catch (NumberFormatException e) { //숫자 입력이 아닌 경우 예외처리 후 반복
                System.out.println(ExceptionMessages.NUM_FORMAT);
            } catch (IOException e) {
                System.out.println("오류 !");
                throw new RuntimeException(e);
            }
        }
    }

    public int calculateNumOfLotto() { //지불한 금액으로 구매한 로또 갯수
        int numOfLotto = money / 1000;
        System.out.println();
        System.out.println(numOfLotto + "개를 구매했습니다.");
        return  numOfLotto; //로또 갯수 반환
    }
}


