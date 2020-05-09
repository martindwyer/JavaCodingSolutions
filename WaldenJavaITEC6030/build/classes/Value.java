public class Value {
    private boolean modified = false;
    private int val;

    public Value(int n) {
        this.val = n;
    }

    public int getVal() {
        return this.val;
    }

    public void setVal(int n) {
        this.val = n;
        this.modified = true;
    }

    public boolean wasModified() {
        return this.modified;
    }

}
