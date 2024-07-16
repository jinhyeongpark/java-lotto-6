package lotto.controller;

import lotto.lottodomain.Lotto;
import lotto.lottoNumManager.LottoNumsGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private static List<Lotto> savedLottos = new ArrayList<Lotto>();
    private static Lotto winningNumbers;
    private static int myBonusNum;
    public LottoGenerator(int num) throws IOException {
        for(int i = 0; i < num; i++) {
            LottoNumsGenerator lottonumgenerator = new LottoNumsGenerator();
            Lotto lotto = lottonumgenerator.getLotto();
            savedLottos.add(lotto);
            System.out.println(lotto.toString());
        }
    }
    public List<Lotto> getLottos(){
        return this.savedLottos;
    }
}
