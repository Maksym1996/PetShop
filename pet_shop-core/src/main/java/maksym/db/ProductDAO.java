package maksym.db;

import maksym.db.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/petshop?useUnicode=true&serverTimezone=UTC&user=Maksym&password=pwEzhF258YPjZUG8";

    private static final String SQL_INSERT_PRODUCT = "INSERT INTO products VALUES(DEFAULT, ?,?,?,?,?,?,?,?,?,?,?)";
    private static final String GET_PRODUCT_FOR_ID = "SELECT * FROM products WHERE id = ?";
    private static final String GET_PRODUCTS_FOR_PETS = "SELECT * FROM products WHERE pet_id = ?";
    private static final String GET_PRODUCTS_FOR_PETID_AND_TYPE = "SELECT * FROM products WHERE pet_id = ? and type_id = ?";
    private static final String UPDATE_PRODUCT = "UPDATE products SET name=?, price=?, description=?, amount=?, weight=?, producer=?, type_id=?, age=?, breed=?, pet_id=?, photo_link=? WHERE id = ? ";
    private static final String UPDATE_PRODUCT_FOR_AMOUNT = "UPDATE products WHERE id = ? SET amount = amount-?";

    private ProductDAO() {

    }

    private static ProductDAO instance;
    public static synchronized ProductDAO getInstance() {
        if (instance == null) {
            instance = new ProductDAO();
        }
        return instance;
    }

    public boolean insertProduct(Product prod) throws Exception{
        boolean res = false;
        Connection connect = null;
        PreparedStatement prep = null;
        ResultSet rs = null;

        try {
            connect = DriverManager.getConnection(CONNECTION_URL);
            prep = connect.prepareStatement(SQL_INSERT_PRODUCT, Statement.RETURN_GENERATED_KEYS);
            int k = 1;
            prep.setString(k++, prod.getName());
            prep.setString(k++, prod.getPrice());
            prep.setString(k++, prod.getDescription());
            prep.setString(k++, prod.getAmount());
            prep.setString(k++, prod.getWeight());
            prep.setString(k++, prod.getProducer());
            prep.setInt(k++, prod.getType_id());
            prep.setString(k++, prod.getAge());
            prep.setString(k++, prod.getBreed());
            prep.setInt(k++, prod.getPet_id());
            prep.setString(k, prod.getPhoto_link());


            if (prep.executeUpdate() > 0) {
                rs = prep.getGeneratedKeys();
                res = true;
                if (rs.next()) {
                    int prodID = rs.getInt(1);
                    prod.setId(prodID);
                }
            }

        } catch (Exception e) {
           new Exception();
        } finally {
            close(connect);

        }

        return res;

    }



    public Product getProductForId(int id) throws Exception {
        Product prod = null;
        Connection connect = null;
        PreparedStatement prep = null;
        ResultSet rs = null;

        try {
            connect = DriverManager.getConnection(CONNECTION_URL);
            prep = connect.prepareStatement(GET_PRODUCT_FOR_ID);
            prep.setInt(1, id);
            rs = prep.executeQuery();

            if (rs.next()) {
                prod = extractionProduct(rs);
            }
        } catch (Exception e) {
            new Exception();
        } finally {
            close(connect);
        }

        return prod;

    }

    public List<Product> getProductsForPetId(int petid) throws Exception{
        List<Product> allProd = new ArrayList<>();
        Connection connect = null;
        PreparedStatement prep = null;
        ResultSet rs = null;

        try {
            connect = DriverManager.getConnection(CONNECTION_URL);
            prep = connect.prepareStatement(GET_PRODUCTS_FOR_PETS);
            prep.setInt(1, petid);
            rs = prep.executeQuery();

            while (rs.next()) {
                allProd.add(extractionProduct(rs));
            }
        } catch (Exception e) {
            new Exception();
        } finally {
            close(connect);
        }

        return allProd;

    }

    public List<Product> getProductsForTypeAndPetId(int petid, int type) throws Exception{
        List<Product> allProd = new ArrayList<>();
        Connection connect = null;
        PreparedStatement prep = null;
        ResultSet rs = null;

        try {
            connect = DriverManager.getConnection(CONNECTION_URL);
            prep = connect.prepareStatement(GET_PRODUCTS_FOR_PETID_AND_TYPE);
            prep.setInt(1, petid);
            prep.setInt(2, type);
            rs = prep.executeQuery();

            while (rs.next()) {
                allProd.add(extractionProduct(rs));
            }
        } catch (Exception e) {
            new Exception();
        } finally {
            close(connect);
        }

        return allProd;
    }

    public boolean updateProduct( String name, String price, String description, String amount, String weight, String producer,
                                  String type_id, String age, String breed, String pet_id, String photo_link, int id) throws Exception {
        boolean result = false;
        Connection connect = null;
        PreparedStatement prep = null;

        try {
            connect = DriverManager.getConnection(CONNECTION_URL);
            prep = connect.prepareStatement(UPDATE_PRODUCT);
            int k = 1;

            prep.setString(k++, name);
            prep.setString(k++, price);
            prep.setString(k++, description);
            prep.setString(k++, amount);
            prep.setString(k++, weight);
            prep.setString(k++, producer);
            prep.setString(k++, type_id);
            prep.setString(k++, age);
            prep.setString(k++, breed);
            prep.setString(k++, pet_id);
            prep.setString(k++, photo_link);
            prep.setInt(k, id);

            if(prep.executeUpdate()>0){
                result = true;
            }
        } catch (Exception e) {
           new Exception();
        } finally {
            close(connect);
        }
        return result;



    }

    public boolean updateProductAmount(Product prod, int amount) throws Exception{
        boolean result = false;
        Connection connect = null;
        PreparedStatement prep = null;

        try {
            connect = DriverManager.getConnection(CONNECTION_URL);
            prep = connect.prepareStatement(UPDATE_PRODUCT_FOR_AMOUNT);
            prep.setInt(1, prod.getId());
            prep.setInt(2, amount);
            if(prep.executeUpdate()>0){
                result = true;
            }
        } catch (Exception e) {
            new Exception();
        } finally {
            close(connect);
        }
        return result;
    }

    private static Product extractionProduct(ResultSet rs) throws Exception {
        Product prod = new Product();
        int k = 1;

        prod.setId(rs.getInt(k++));
        prod.setName(rs.getString(k++));
        prod.setPrice(rs.getString(k++));
        prod.setDescription(rs.getString(k++));
        prod.setAmount(rs.getString(k++));
        prod.setWeight(rs.getString(k++));
        prod.setProducer(rs.getString(k++));
        prod.setType_id(rs.getInt(k++));
        prod.setAge(rs.getString(k++));
        prod.setBreed(rs.getString(k++));
        prod.setPet_id(rs.getInt(k++));
        prod.setPhoto_link(rs.getString(k));

        return prod;
    }

    private static void close(Connection con)throws Exception {
        if (con == null) {
            return;
        }

        try {
            con.close();
        } catch (Exception e) {
            new Exception();
        }
    }

}
