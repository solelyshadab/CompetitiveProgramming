package JavaInterviewRelated.UseMultiThreadToBatchProcess;

import java.util.List;

class CustomerMaintenanceConventionalWay
{
    // a collection of Customer objects that we need to process
    List<Customer> mCustomerList;
    // Constructor. User passes in the collection of Customer
    // objects to process.
    public CustomerMaintenanceConventionalWay(List<Customer> customerList)
    {
        mCustomerList = customerList;
    }
    // Update method applies all the business transformations
    // to the Customer objects, one at a time.
    public void Update()
    {
        mCustomerList.forEach(Customer::setDiscount);

    }
}
