public class Accumulator {
    private int sum = 0;

    public Accumulator(int n) {
        this.sum = n;
    }

    public int getSum() {
        return this.sum;
    }

    public void add(int i) {

        this.sum += i;

    }

}
