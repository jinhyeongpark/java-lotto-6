package lotto.controller;

import  lotto.lottoMatching.LottoNumMatch;
import lotto.lottoMatching.RewardMatching;
import lotto.lottodomain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class RankList {

    private static List<Integer> ranks;

    public RankList(List<Lotto> savedLottos, Lotto winNums, int bonusNums) {
        ranks = new ArrayList<>();
        LottoNumMatch lottoNumMatch = new LottoNumMatch();
        RewardMatching rewardMatching = new RewardMatching();

        for(Lotto lotto: savedLottos) { //로또 리스트를 순회

            int cnt = lottoNumMatch.countMatchedNums(winNums, lotto);
            boolean bonus = lottoNumMatch.presenceOfBonus(winNums, lotto, bonusNums);
            ranks.add(rewardMatching.ranking(cnt, bonus)); //랭킹 리스트를 생성

        }
    }

    public static List<Integer> getRanks() {
        return ranks; //랭킹 리스트 반환
    }
}
