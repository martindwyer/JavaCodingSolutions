public class GasTank {
        private double amount = 0.0;
        private double capacity = 0.0;

        public GasTank(double d) {
            this.capacity = d;
        }

        public void addGas(double add) {
            if (amount + add > capacity) {
                amount = capacity;
            } else {
                amount += add;
            }
        }

        public void useGas(double less) {
            if (amount - less < 0) {
                amount = 0;
            } else {
                amount -= less;
            }
        }

        public boolean isEmpty() {
            if(amount < 0.1) {
                return true;
            } else {
                return false;
            }
        }

        public boolean isFull() {
            if(amount > capacity -0.1) {
                return true;
            } else {
                return false;
            }
        }

        public double getGasLevel() {
            return amount;
        }

        public double fillUp() {
            double amountAdded = capacity - amount;
            amount = capacity;
            return amountAdded;
        }

}
