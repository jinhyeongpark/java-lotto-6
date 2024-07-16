package lotto.lottoMatching;

import lotto.lottodomain.Lotto;

public class LottoNumMatch {
    public int countMatchedNums(Lotto winLotto, Lotto lottoForCompare) { //매칭된 로또 번호의 수
        int cnt = 0;
        for(int i = 0; i < 6; i++) {
            if(winLotto.get(i) == lottoForCompare.get(i)) cnt++;
        }
        return cnt;
    }
    //위 메서드에서 cnt가 5인 경우 호출하여 다른 번호 하나가 보너스번호와 같은지 판단
    public boolean presenceOfBonus(Lotto winLotto, Lotto lottoForCompare, int bonusNum) { //보너스 번호 매칭 여부
        int numForMatchWithBonus = 0; //초기에 0으로 초기화, 1~45이므로 겹칠 일이 없음
        for(int j = 0; j < 6; j++) {
            if(winLotto.get(j) != lottoForCompare.get(j)) { //5개가 일치하는 상황에서 일치하지 않는 하나으 번호를 찾음
                numForMatchWithBonus = lottoForCompare.get(j); //해당 번호를 보너스 번호와의 비교를 위한 번호로 지정
                break;
            }
        } return bonusNum == numForMatchWithBonus; //위 번호와 보너스 번호의 일치 여부를 반환
    }
}
