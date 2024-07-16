package lotto.controller;

import lotto.lottoExceptions.ExceptionMessages;
import lotto.lottodomain.Answer;
import lotto.lottodomain.Lotto;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GetAnswer {
    private Answer answer;
    public GetAnswer() throws IOException {
        List<Integer> listwinning = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Lotto winnum = null;

        while (true) {
            System.out.println("당첨 번호를 입력해 주세요.");
            String str = br.readLine();
            str = str.replaceAll("\\s", "");
            String[] stringlist = str.split(",");
            try {
                for (String s : stringlist) {
                    listwinning.add(Integer.parseInt((s)));
                }
                winnum = new Lotto(listwinning);
                break;
            } catch (NumberFormatException e) {
                System.out.println(ExceptionMessages.NUM_FORMAT);
                listwinning.clear();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                listwinning.clear();
            }
        }
        System.out.println();
        // 보너스 입력
        int bonus = 0;
        while (true) {
            System.out.println("보너스 번호를 입력해 주세요.");
            try {
                String inputbonus = br.readLine();
                bonus = Integer.parseInt(inputbonus);
                check(listwinning, bonus);
                break;
            } catch (NumberFormatException e) {
                System.out.println(ExceptionMessages.NUM_FORMAT);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println();
        answer = new Answer(winnum, bonus);
    }
    public Answer getAnswer(){
        return answer;
    }
    public void check(List<Integer>listwinning, int bonus) {
        if((listwinning.contains(bonus))) {
            throw new IllegalArgumentException(ExceptionMessages.NUM_DUPLICATION);
        }
        if(bonus > 45 || bonus < 1) {
            throw new IllegalArgumentException((ExceptionMessages.NUM_RANGE));
        }

    }

}
