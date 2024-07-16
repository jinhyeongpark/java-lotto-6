package lotto.lottoExceptions;

public class ExceptionMessages {
    //로또 번호가 1~45를 벗어나는 경우
    //로또 번호 갯수가 6개가 아닌 경우
    //로또 입력에 숫자 외의 것이 들어오는 경우
    public static final String NUM_RANGE = "[ERROR] 숫자는 1~45 범위 안에 있어야 합니다.";
    public static final String NUM_SIZE = "[ERROR] 복권 번호는 6개여야 합니다.";
    public static final String NUM_FORMAT = "[ERROR] 잘못된 형식의 입력입니다.";
    public static final String NUM_DUPLICATION = "[ERROR] 당첨 번호와 중복되는 숫자입니다.";
    public static final String WINNINGNUM_DUPLICATION = "[ERROR] 중복되는 숫자가 존재합니다.";
    public static final String MONEY_NOT_DIVIDED_BY_1000 =  "[ERROR] 구입금액은 1000원 단위로 입력해주세요.";

}
