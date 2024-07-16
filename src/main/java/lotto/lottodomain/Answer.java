package lotto.lottodomain;

import lotto.lottodomain.Lotto;

public class Answer {
    private Lotto winningNum;
    private int bonus;
    public Answer(Lotto winningNum, int bonus){
        this.winningNum = winningNum;
        this.bonus = bonus;
    }
    public Lotto getWinningNum(){
        return winningNum;
    }
    public int getBonus(){
        return bonus;
    }
}
