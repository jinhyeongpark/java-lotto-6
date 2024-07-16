package lotto.lottodomain;

import lotto.lottoExceptions.ExceptionMessages;

import java.io.*;
import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private static void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println(numbers.size());
            System.out.println("로또 번호 수 오류");
            throw new IllegalArgumentException(ExceptionMessages.NUM_SIZE);
        }
        for(int num: numbers) {
            if(num > 45 || num < 1) {
                System.out.println("로또 숫자 범위 오류");
                throw new IllegalArgumentException(ExceptionMessages.NUM_RANGE);
            }
        }
        if(new HashSet<Integer>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException(ExceptionMessages.WINNINGNUM_DUPLICATION);
        }
    }

    public List<Integer> getNumbers() {return numbers;} //당첨 번호 반환

    public Integer get(int i) {return numbers.get(i);}
    public boolean contains(int num) {return numbers.contains(num);}
    public String toString() {return numbers.toString();}
}