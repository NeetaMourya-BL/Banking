public class SavingAccount{
    private static double annualInterestRate = 0.0;
    private double savingsBalance = 0.0;
    public SavingAccount(double savingsBalance){
        setSavingsBalance(savingsBalance);
    }
    public void setSavingsBalance(double savingsBalance){
        this.savingsBalance = savingsBalance;
    }
    public static void modifyInterestRate(double newInterestRate){
        if(newInterestRate >= 0.0)
            annualInterestRate = newInterestRate;
        else
            throw new IllegalArgumentException("interest rate must be >= 0.0");
    }
    public double getSavingsBalance(){
        return this.savingsBalance;
    }
    public static double getAnnualInterestRate(){
        return annualInterestRate;
    }
    public void calculateMonthlyInterest(){
        savingsBalance += (savingsBalance * annualInterestRate) / 12;
    }
    public String toString(){
        return String.format("%.2f", getSavingsBalance());
    }
    public static void main(String[] args) {
        SavingAccount saver1, saver2;
        saver1 = new SavingAccount (2000.0);
        saver2= new SavingAccount (3000.0);
        int total = 0;
        SavingAccount.modifyInterestRate (0.04);
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();
        System.out.println("This month:\nSaver 1 balance= "+ saver1.getSavingsBalance());
        System.out.println("Saver 2 balance= "+ saver2.getSavingsBalance());
        SavingAccount.modifyInterestRate(0.05);
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();
        System.out.println("Next month:\nSaver 1 balance= "+ saver1.getSavingsBalance());
        System.out.println("Saver 2 balance= "+ saver2.getSavingsBalance());

    }
}