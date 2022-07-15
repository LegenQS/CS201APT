import java.util.*;

public class OlympicCandles {
	public int numberOfNights(int[] candles) {
		ArrayList<Integer> candlesList = new ArrayList<>();
		for (int s: candles) {
			candlesList.add(s);
		}
		Collections.sort(candlesList, Collections.reverseOrder());
		int day = 1;
		while (true) {
			for (int i = 0; i < day; i++) {
				candlesList.set(i, candlesList.get(i) - 1);
			}
			Collections.sort(candlesList, Collections.reverseOrder());
			if ((day == candlesList.size()) || (candlesList.get(day) == 0)) {
				return day;
			}
			day += 1;
		}
	}
}