package lotto.lottoMatching;

public class RewardMatching {
    public int ranking(int cnt, boolean bonus) {
        if (cnt == 6) return 1;
        if (cnt == 5 && bonus) return 2;
        if (cnt == 5) return 3;
        if (cnt == 4) return 4;
        if (cnt == 3) return 5;
        return 0;
    }
}
