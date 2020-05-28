package maksym.db;

import maksym.db.entity.Product;
import maksym.db.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/petshop?useUnicode=true&serverTimezone=UTC&user=Maksym&password=pwEzhF258YPjZUG8";
    private static final String SQL_INSERT_USER = "INSERT INTO users VALUES(DEFAULT,?,?,?,?,?,?)";
    private static final String GET_USER_FOR_EMAIL = "SELECT * FROM users WHERE email = ?";
    private static final String CHECK_USER_FOR_EMAIL_AND_PASS = "SELECT * FROM users WHERE email = ? and pass = ?";
    private static final String GET_ALL_USERS = "SELECT * FROM users";

    private static UserDAO instance;
    public static synchronized UserDAO getInstance() {
        if (instance == null) {
            instance = new UserDAO();
        }
        return instance;
    }

   public List<User> getAllUsers (){
        List<User> allUser = new ArrayList<>();
        Connection connect = null;
        Statement stat = null;
        ResultSet rs = null;

        try{
            connect = DriverManager.getConnection(CONNECTION_URL);
            stat = connect.createStatement();
            rs = stat.executeQuery(GET_ALL_USERS);
            while (rs.next()) {
                allUser.add(extrationUser(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connect);
        }
        return allUser;
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

    public boolean insertUser(User user)  {
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
            prep.setInt(k, user.getRole())
            ;

            if (prep.executeUpdate() > 0) {
                rs = prep.getGeneratedKeys();
                res = true;
                if (rs.next()) {
                    int userID = rs.getInt(1);
                    user.setId(userID);
                }
            }

        } catch (SQLException e) {
           new Exception ();
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
        user.setRole(rs.getInt(k));

        return user;
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
