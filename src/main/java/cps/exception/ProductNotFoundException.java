package cps.exception;

public class ProductNotFoundException extends Exception {

    private Long id;

    public ProductNotFoundException(Long id){
        super(String.format("Product is not found with id : '%s'", id));
    }

}
