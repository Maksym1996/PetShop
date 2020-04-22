package maksym.db.entity;

/**
 * Order entity
 *
 * @author Maks
 */
public class Order {
    private int id;
    private int user_id;
    private int produt_id;
    private int count_product;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getProdut_id() {
        return produt_id;
    }

    public void setProdut_id(int produt_id) {
        this.produt_id = produt_id;
    }

    public int getCount_product() {
        return count_product;
    }

    public void setCount_product(int count_product) {
        this.count_product = count_product;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", user_id=" + user_id + ", produt_id=" + produt_id + ", count_product="
                + count_product + "]";
    }

}
