package lotto.controller;

import lotto.rewards.LottoProfit;
import lotto.rewards.LottoReward;

import java.util.List;

public class LottoRewarding {
    public LottoRewarding(int num, List<Integer> ranks) {
        //등수 기반 상금을 주는 기능
        LottoReward lottoReward = new LottoReward();
        lottoReward.output(ranks); //랭킹 리스트를 기반으로 출력
        long totalRewardMoney = lottoReward.totalMoney(ranks); //상금
        //수익률 계산
        LottoProfit lottoProfit = new LottoProfit();
        lottoProfit.rateOfReturn(num*1000, totalRewardMoney); //지불 금액과 상금을 매개변수로 수익률 계산
    }
}
