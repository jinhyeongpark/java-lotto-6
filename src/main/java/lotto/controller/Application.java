package lotto.controller;

import lotto.lottodomain.Answer;
import lotto.lottodomain.Lotto;
import lotto.lottoNumManager.LottoShop;

import java.io.IOException;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IOException {
        LottoShop lottoshop = new LottoShop();
        int num = lottoshop.calculateNumOfLotto();

        LottoGenerator lottogenerator = new LottoGenerator(num);
        List<Lotto> lottos = lottogenerator.getLottos();
        System.out.println();

        GetAnswer getAnswer = new GetAnswer(); //답을 받아오는 기계
        Answer receiveAnswer = getAnswer.getAnswer(); // 받아서 저장
        Lotto winlotto = receiveAnswer.getWinningNum();
        int winbonus = receiveAnswer.getBonus();

        RankList rankList = new RankList(lottos, winlotto, winbonus); //로또 당첨 매칭
        List<Integer> ranks = rankList.getRanks();
        LottoRewarding lottoRewarding = new LottoRewarding(num, ranks); //매칭 결과에 따른 보상과 수익률
    }

}
