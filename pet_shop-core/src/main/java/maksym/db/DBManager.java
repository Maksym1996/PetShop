package maksym.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import maksym.db.entity.Order;
import maksym.db.entity.Product;
import maksym.db.entity.User;
import maksym.db.entity.UserRole;

/**
 * DB manager. Works with MySQL.
 *
 * @author Maks
 */
public class DBManager {
    private static final String URL_FILENAME = "dbConnect.properties";
    private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/petshop?useUnicode=true&serverTimezone=UTC&user=Maksym&password=pwEzhF258YPjZUG8";

    private static final String SQL_INSERT_USER = "INSERT INTO users VALUES(DEFAULT,?,?,?,?,?,?)";
    private static final String SQL_INSERT_ORDER = "INSERT INTO orders VALUES(DEFAULT, ?,?,?)";
    private static final String SQL_INSERT_PRODUCT = "INSERT INTO products VALUES(DEFAULT, ?,?,?,?,?,?,?,?,?,?,?)";
    private static final String GET_PRODUCT_FOR_ID = "SELECT * FROM products WHERE id = ?";
    private static final String CHECK_USER_FOR_EMAIL_AND_PASS = "SELECT * FROM users WHERE email = ? and pass = ?";
    private static final String GET_PRODUCTS_FOR_PETS = "SELECT * FROM products WHERE pet_id = ?";
    private static final String UPDATE_PRODUCT_FOR_AMOUNT = "UPDATE products WHERE id = ? SET amount = amount-?";
    private static final String UPDATE_PRODUCT_FOR_NAME = "UPDATE products WHERE name = ? SET ";

    private static final String GET_USER_FOR_EMAIL = "SELECT * FROM users WHERE email = ?";
    private static DBManager instance;

    private DBManager() {

    }

    public static synchronized DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }

    public static Properties propURL() {
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(new File(URL_FILENAME)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
    public boolean updateProductAmount(Product prod, int amount){
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
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connect);
        }
        return result;
    }

    public User getUserForEmail(String email) {
        User user = null;
        Connection connect = null;
        PreparedStatement prep = null;
        ResultSet rs = null;

        try {
            connect = DriverManager.getConnection(CONNECTION_URL);
            prep = connect.prepareStatement(GET_USER_FOR_EMAIL);
            prep.setString(1, email);
            rs = prep.executeQuery();

            if (rs.next()) {
                user = extrationUser(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connect);
        }

        return user;
    }

    public boolean insertUser(User user) {
        boolean res = false;
        Connection connect = null;
        PreparedStatement prep = null;
        ResultSet rs = null;

        try {
            connect = DriverManager.getConnection(CONNECTION_URL);
            prep = connect.prepareStatement(SQL_INSERT_USER, Statement.RETURN_GENERATED_KEYS);
            int k = 1;
            prep.setString(k++, user.getName());
            prep.setString(k++, user.getSurname());
            prep.setString(k++, user.getPass());
            prep.setString(k++, user.getPhone());
            prep.setString(k++, user.getEmail());

            UserRole userRole = user.getRole();
            int roleId = userRole != null ? userRole.getRoleId() : UserRole.USER.getRoleId();
            prep.setInt(k, roleId);

            if (prep.executeUpdate() > 0) {
                rs = prep.getGeneratedKeys();
                res = true;
                if (rs.next()) {
                    int userID = rs.getInt(1);
                    user.setId(userID);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connect);

        }

        return res;

    }
    
    

    private static User extrationUser(ResultSet rs) throws SQLException {
        User user = new User();
        int k = 1;
        user.setId(rs.getInt(k++));
        user.setName(rs.getString(k++));
        user.setSurname(rs.getString(k++));
        user.setPass(rs.getString(k++));
        user.setPhone(rs.getString(k++));
        user.setEmail(rs.getString(k++));
        user.setRole(UserRole.fromId(rs.getInt(k)));

        return user;
    }

    public boolean insertOrder(Order order) {
        boolean res = false;
        Connection connect = null;
        PreparedStatement prep = null;
        ResultSet rs = null;

        try {
            connect = DriverManager.getConnection(CONNECTION_URL);
            prep = connect.prepareStatement(SQL_INSERT_ORDER, Statement.RETURN_GENERATED_KEYS);
            int k = 1;
            prep.setInt(k++, order.getUser_id());
            prep.setInt(k++, order.getProdut_id());
            prep.setInt(k, order.getCount_product());

            if (prep.executeUpdate() > 0) {
                rs = prep.getGeneratedKeys();
                res = true;
                if (rs.next()) {
                    int userID = rs.getInt(1);
                    order.setId(userID);
                }
            }
            if (rs != null && rs.next()) {
                extrationOrder(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connect);

        }

        return res;

    }

    private static Order extrationOrder(ResultSet rs) throws SQLException {
        Order order = new Order();
        int k = 1;
        order.setId(rs.getInt(k++));
        order.setUser_id(rs.getInt(k++));
        order.setProdut_id(rs.getInt(k++));
        order.setCount_product(rs.getInt(k));

        return order;
    }
    
    public boolean insertProduct(Product prod) {
        boolean res = false;
        Connection connect = null;
        PreparedStatement prep = null;
        ResultSet rs = null;

        try {
            connect = DriverManager.getConnection(CONNECTION_URL);
            prep = connect.prepareStatement(SQL_INSERT_PRODUCT, Statement.RETURN_GENERATED_KEYS);
            int k = 1;
            prep.setString(k++, prod.getName());
            prep.setInt(k++, prod.getPrice());
            prep.setString(k++, prod.getDescription());
            prep.setInt(k++, prod.getAmount());
            prep.setInt(k++, prod.getWeight());
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

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connect);

        }

        return res;

    }
    


    public Product getProductForId(int id) {
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
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connect);
        }

        return prod;

    }

    public List<Product> getProductsForPetId(int petid) {
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
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connect);
        }

        return allProd;

    }

    private static Product extractionProduct(ResultSet rs) throws SQLException {
        Product prod = new Product();
        int k = 1;

        prod.setId(rs.getInt(k++));
        prod.setName(rs.getString(k++));
        prod.setPrice(rs.getInt(k++));
        prod.setDescription(rs.getString(k++));
        prod.setAmount(rs.getInt(k++));
        prod.setWeight(rs.getInt(k++));
        prod.setProducer(rs.getString(k++));
        prod.setType_id(rs.getInt(k++));
        prod.setAge(rs.getString(k++));
        prod.setBreed(rs.getString(k++));
        prod.setPet_id(rs.getInt(k++));
        prod.setPhoto_link(rs.getString(k));

        return prod;
    }

    public boolean checkUserForEmailPass(String email, String pass) {
        boolean result = false;
        Connection connect = null;
        PreparedStatement prep = null;
        ResultSet rs = null;

        try {
            connect = DriverManager.getConnection(CONNECTION_URL);
            prep = connect.prepareStatement(CHECK_USER_FOR_EMAIL_AND_PASS);
            int k = 1;

            prep.setString(k++, email);
            prep.setString(k, pass);

            rs = prep.executeQuery();
            result = rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connect);
        }

        return result;
    }

    private static void close(Connection con) {
        if (con == null) {
            return;
        }

        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
