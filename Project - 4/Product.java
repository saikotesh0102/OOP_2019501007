class Product {

    String productID;
    String productName;
    int productQuantity;
    double productPrice;

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public Product(String productID, String productName, int productQuantity, double productPrice) {
        this.productID = productID;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
    }
    
}