

public class CoffeeShop {
    public static void main(String[] args) {


        Customer joseph = new Customer("Joseph", 200);
        Customer peter = new Customer("Peter");
        Customer unknown = new Customer(); 
        peter.addPoints(200);
        peter.addPoints(20);
        
        System.out.println("\n=== Reward Redemption ===");
        joseph.redeemReward();
        peter.redeemReward();
        unknown.redeemReward();


        System.out.println("\n=== Customer Information ===");
        joseph.displayCustomerInfo();
        peter.displayCustomerInfo();
        unknown.displayCustomerInfo();
        Customer.displayTotalCustomers();
        
        
        Customer diane = new Customer("Diane");
        diane.addPoints(50);
        diane.displayCustomerInfo();
        Customer.displayTotalCustomers();
        
        System.out.println("\n=== Reward Opportunities ===");
        Customer.getAllowedRewardsRedemption(joseph);
        Customer.getAllowedRewardsRedemption(peter);
        Customer.getAllowedRewardsRedemption(unknown);
        Customer.getAllowedRewardsRedemption(diane);
    }
}