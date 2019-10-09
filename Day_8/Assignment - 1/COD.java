public class COD extends BankAccount {
    private String expiry ;

    public COD (String expiry){
        this.expiry = expiry ;
    }

    public void setExpiry(String expiry){
        this.expiry = expiry;
    }

    public String getExpiry(){
        return expiry;
    }
}