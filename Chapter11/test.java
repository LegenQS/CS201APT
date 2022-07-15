public class test {
    public static void main(String[] args) {
        Internet c = new Internet();
        String[] a = {"1 7 12 13 15",
        "0 2 6 4 7",
        "3 5 6 1",
        "4 5 2",
        "3 1",
        "3 2",
        "2 1",
        "1 0 8",
        "7 9 10 11",
        "10 11 8",
        "9 8",
        "9 8",
        "0 13",
        "0 12 14 15",
        "13",
        "13 0"};

        System.out.println(c.articulationPoints(a));
    }
}
