
public class Customer {

    private String name;
    private int points;

    private static int totalCustomers = 0;



    public Customer() {
        this.name = "Unknown";
        this.points = 0;
        totalCustomers++;
    }
    public Customer(String name, int points) {
        this.name = name;
        this.points = points;
        totalCustomers++;
    }
    public Customer(String name) {
        this.name = name;
        this.points = 0;
        totalCustomers++;
    }
    public void addPoints(int earnedPoints) {
        this.points += earnedPoints;
        System.out.println(this.name + " earned " + earnedPoints + " points. Total points: " + this.points);
    }


    public void redeemReward() {
        if (this.points >= 100) {
            this.points -= 100;
            System.out.println("Congratulations " + this.name + "! You redeemed a free drink!");
            System.out.println("Remaining points: " + this.points);
        } else {
            System.out.println(this.name + " does not have enough points to redeem a drink.");
        }
    }


    public void displayCustomerInfo() {
        System.out.println("Customer: " + this.name);
        System.out.println("Points: " + this.points);
        System.out.println("------------------------------------------------");
    }


    public static void displayTotalCustomers() {
        System.out.println("Total Registered Customers: " + totalCustomers);
    }


    public static void getAllowedRewardsRedemption(Customer customer) {
        int possible = customer.points / 100;
        System.out.println(customer.name + " can redeem " + possible + " reward(s)");
    }
}