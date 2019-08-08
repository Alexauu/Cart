package pojo;

/**
 * @ClassName:
 * @Description:
 * @author: Ouzl
 * @create: 2019-08-07 18:06
 */

public class OrderItem {
    private int id;
    private Product product;
    private int num;
    private Order order;

    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }

    public OrderItem(int id, Product product, int num) {
        this.id = id;
        this.product = product;
        this.num = num;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
}
