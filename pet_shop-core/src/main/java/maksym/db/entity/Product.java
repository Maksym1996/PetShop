package maksym.db.entity;

/**
 * Product entity
 *
 * @author Maks
 */
public class Product {
    private int id;
    private String name;
    private String price;
    private String description;
    private String amount;
    private String weight;
    private String producer;
    private int type_id;
    private String age;
    private String breed;
    private int pet_id;
    private String photo_link;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getPet_id() {
        return pet_id;
    }

    public void setPet_id(int pet_id) {
        this.pet_id = pet_id;
    }

    public String getPhoto_link() {
        return photo_link;
    }

    public void setPhoto_link(String photo_link) {
        this.photo_link = photo_link;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description
                + ", amount=" + amount + ", weight=" + weight + ", producer=" + producer + ", type_id=" + type_id
                + ", age=" + age + ", breed=" + breed + ", pet_id=" + pet_id + ", photo_link=" + photo_link + "]";
    }
    
    public static Product createProduct(String name, String price, String description, String amount, String weight, String producer,
                                        int type_id, String age, String breed, int pet_id, String photo_link) {
        Product prod = new Product();
        
        prod.setName(name);
        prod.setPrice(price);
        prod.setDescription(description);
        prod.setAmount(amount);
        prod.setWeight(weight);
        prod.setProducer(producer);
        prod.setType_id(type_id);
        prod.setAge(age);
        prod.setBreed(breed);
        prod.setPet_id(pet_id);
        prod.setPhoto_link(photo_link);
            
        return prod;

    }

}
