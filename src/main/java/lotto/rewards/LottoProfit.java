package lotto.rewards;

public class LottoProfit {
    public void rateOfReturn(int inputMoney, long reward) {
        if (reward == 0) {
            System.out.println("보상이 없으므로 수익률을 계산할 수 없습니다.");
            return; }
        double rate = ((double)(reward - inputMoney) / inputMoney * 100);
        System.out.format("총 수익률은 %.2f%% 입니다.", rate);


    }
}
