package Mission2.demo.Exceptions;

public class BrandNoFoundException extends RuntimeException {
    public BrandNoFoundException(String brand)
    {
        super(brand+" does not exist in product list");
    }
}
