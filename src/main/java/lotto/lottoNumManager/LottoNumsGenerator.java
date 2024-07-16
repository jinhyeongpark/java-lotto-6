package lotto.lottoNumManager;

import lotto.lottodomain.Lotto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LottoNumsGenerator {
    private Lotto lotto;
    public LottoNumsGenerator() throws IOException {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        while (list.size() < 6) { //로또 리스트의 크기가 6이 안되는 동안 반복
            int number = random.nextInt(45) + 1; // 1부터 45까지의 난수 생성
            // 난수말고 진짜 랜덤.
            if (!list.contains(number)) { //중복 방지를 위한 조건문
                list.add(number);
            }
        }
        lotto = new Lotto(list);
    }
    public Lotto getLotto(){
        return lotto;
    }
}
