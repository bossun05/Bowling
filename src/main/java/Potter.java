import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Potter {

    List<Integer> shoppingCart = new ArrayList<>();
    private int bookA;
    private int bookB;
    private int bookC;
    private int bookD;
    private int bookE;
    private double subtotal = 0;
    private double total = 0;

    public void setBookA(int bookA) {
        this.bookA = bookA;
    }

    public void setBookB(int bookB) {
        this.bookB = bookB;
    }

    public void setBookC(int bookC) {
        this.bookC = bookC;
    }

    public void setBookD(int bookD) {
        this.bookD = bookD;
    }

    public void setBookE(int bookE) {
        this.bookE = bookE;
    }

    public double computePrice() {
        sortBookOrders();
        shoppingCart.forEach(bookOrder -> {
            if (bookOrder > 0){
                for (int book = bookOrder; book > 0; book--){
                    addDiscountedBooksToSubtotal();
                }
            }
        });


        return this.subtotal;
    }

    private void addDiscountedBooksToSubtotal() {
        int price = this.shoppingCart.stream().filter(bookOrder -> bookOrder > 0).sorted().collect(Collectors.toList()).size();
        if (price == 1) {
            this.subtotal = this.subtotal + 8;
        } else if (price == 2) {
            this.subtotal = this.subtotal + 15.2;
        } else if (price == 3) {
            this.subtotal = this.subtotal + 21.6;
        } else if (price == 4) {
            this.subtotal = this.subtotal + 25.6;
        } else if (price == 5) {
            this.subtotal = this.subtotal + 32;
        }
        this.shoppingCart = this.shoppingCart.stream().map(bookOrder -> bookOrder-1).collect(Collectors.toList());
    }

    public void sortBookOrders() {
        this.shoppingCart.add(bookA);
        this.shoppingCart.add(bookB);
        this.shoppingCart.add(bookC);
        this.shoppingCart.add(bookD);
        this.shoppingCart.add(bookE);
        this.shoppingCart = this.shoppingCart.stream().filter(bookOrder -> bookOrder > 0).sorted().collect(Collectors.toList());
    }
}
