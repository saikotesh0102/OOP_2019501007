public class Checking extends BankAccount {
    private double limit ;

    public Checking (double limit){
        this.limit = limit ;
    }

    public void setLimit(double limit){
        this.limit = limit;
    }

    public double getLimit(){
        return limit;
    }
}