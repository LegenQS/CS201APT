// To celebrate the upcoming Thought Challenge Olympics, you are going 
// to follow tradition and light candles. On the first night of the 
// event, you will light one candle. At the end of the night, you will 
// extinguish the candle. On each subsequent night, you will light one 
// more candle than you did on the previous night, so that on the n-th 
// night (indexed from 1) you will light n candles (and extinguish them 
// all in the morning). Each night that you light a candle, its height 
// will decrease by 1 inch; once its height reaches 0 inches, you cannot 
// use it anymore.

// You are given a int[] candles, the i-th element of which is the height 
// of the i-th candle that you own. Return the maximum number of nights 
// you can celebrate the event without going to the store to get more 
// candles. For example, if you have three candles of height 2, you can 
// light one the first night, the other two on the second night, and then 
// all three candles on the third night.

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