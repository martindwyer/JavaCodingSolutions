public class Counter {
    private int counter = 0;
    private int counterID;
    private int limit = 0;
    private static int nCounters = 0;

    public Counter(int n) {
        this.counter = n;
        nCounters ++;
        counterID = nCounters;
    }

    public Counter(int n1, int n2) {
        this.counter = n1;
        this.limit = n2;
        nCounters ++;
    }

    public void increment() {
        if (this.counter < this.limit) {
            this.counter ++;
        }
    }

    public void decrement() {
        if (this.counter > 0) {
            this.counter --;
        }
    }


    public int getValue() {
        return this.counter;
    }

    public int getCounterID() {
        return counterID;
    }

    public static int getNCounters() {
        return nCounters;
    }
}
