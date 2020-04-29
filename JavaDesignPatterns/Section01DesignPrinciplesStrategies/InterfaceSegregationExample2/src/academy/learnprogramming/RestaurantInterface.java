package academy.learnprogramming;

public interface RestaurantInterface {
    public  void acceptOnlineOrder();
    public  void takeTelephoneOrder();
    public  void payOnline();
    public  void walkInCustomerOrder();
    public  void payInPerson();
}

class OnlineClientImpl implements RestaurantInterface
{
    @Override
    public void acceptOnlineOrder() {
        //logic for placing online order
    }
    @Override
    public void takeTelephoneOrder() {
        //Not Applicable for Online Order
        throw new UnsupportedOperationException();
    }
    @Override
    public void payOnline() {
        //logic for paying online
    }

    @Override
    public void walkInCustomerOrder() {
        //Not Applicable for Online Order
        throw new UnsupportedOperationException();
    }

    @Override
    public void payInPerson() {
        //Not Applicable for Online Order
        throw new UnsupportedOperationException();
    }
}
