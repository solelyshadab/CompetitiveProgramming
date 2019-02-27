package JavaInterviewRelated.UseMultiThreadToBatchProcess;

public class Customer {
    private int discount;
    private int customerID;

    public Customer(int customerID, int discount){
        this.customerID = customerID;
        this.discount = discount;
    }

    public void setDiscount(){
        discount *= 0.5;
    }

    public int getDiscount(){
        return discount;
    }

    public int getCustomerID(){
        return customerID;
    }

}
