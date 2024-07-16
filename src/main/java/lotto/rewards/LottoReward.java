package lotto.rewards;

import java.util.Iterator;
import java.util.List;

public class LottoReward {
    public void output(List<Integer> ranks) { // 등수 리스트를 매개변수로 받아 결과 출력
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + getNumOfMatches(ranks, Rewards.FIFTH_PRIZE.getLabel()) + "개");
        System.out.println("4개 일치 (50,000원) - " + getNumOfMatches(ranks, Rewards.FOURTH_PRIZE.getLabel()) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + getNumOfMatches(ranks, Rewards.THIRD_PRIZE.getLabel()) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + getNumOfMatches(ranks, Rewards.SECOND_PRIZE.getLabel()) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + getNumOfMatches(ranks, Rewards.FIRST_PRIZE.getLabel()) + "개");
    }

    private int getNumOfMatches(List<Integer> ranks, int targetRank) {
        return (int) ranks.stream()
                .filter(rank -> rank == targetRank)
                .count();
    }
    public long totalMoney(List<Integer> ranks) {
        long totalRewardMoney = 0;
        for (int rank : ranks) {
            totalRewardMoney += Rewards.getPrizeAmount(rank);
        }
        return totalRewardMoney;
    }


    public enum Rewards { //등수와 상금을 가진 enum
        FIFTH_PRIZE( 5, "5,000"),
        FOURTH_PRIZE( 4, "50,000"),
        THIRD_PRIZE( 3, "1,500,000"),
        SECOND_PRIZE( 2, "30,000,000"),
        FIRST_PRIZE( 1, "2,000,000,000");


        private final int label;
        private final String prizeAmount;

        Rewards(int label, String prizeAmount) {
            this.label = label;
            this.prizeAmount = prizeAmount;
        }

        public int getLabel() {
            return label;
        }

        public String getPrizeAmount() {
            return prizeAmount;
        }

        public static long getPrizeAmount(int rank) {
            for (Rewards reward : values()) {
                if (reward.label == rank) {
                    return Long.parseLong(reward.prizeAmount.replaceAll(",", ""));
                }
            }
            return 0;
        }
    }

}
