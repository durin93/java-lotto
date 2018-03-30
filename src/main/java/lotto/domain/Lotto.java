package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Lotto {
	static final int LOTTO_SIZE = 6;
	private List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public static void check(List<Integer> userNum) {
		LottoNo.check(userNum);
	}

	public static List<Integer> makeLottoNum(List<Integer> temp) {
		List<Integer> numbers = new ArrayList<>();
		for (int i = 0; i < LOTTO_SIZE; i++) {
			numbers.add(temp.get(i));
		}
		Collections.sort(numbers);
		check(numbers);
		return numbers;
	}

	public String numbers() {
		return numbers.toString();
	}

	public int countOfMatch(UserLotto beforeWinLotto) {
		int countOfMatch = 0;
		for (Integer no : numbers) {
			countOfMatch += beforeWinLotto.countOfMatch(no);
		}
		return countOfMatch;
	}

	public int countOfMatch(int no) {
		if (haveNumber(no)) {
			return 1;
		}
		return 0;
	}

	public boolean haveNumber(int no) {
		return numbers.contains(no);
	}

}
