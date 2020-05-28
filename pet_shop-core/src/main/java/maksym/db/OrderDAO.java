package maksym.db;

import maksym.db.entity.Order;

import java.sql.*;

public class OrderDAO {
    private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/petshop?useUnicode=true&serverTimezone=UTC&user=Maksym&password=pwEzhF258YPjZUG8";
    private static final String SQL_INSERT_ORDER = "INSERT INTO orders VALUES(DEFAULT, ?,?,?)";

    private static OrderDAO instance;
    public static synchronized OrderDAO getInstance() {
        if (instance == null) {
            instance = new OrderDAO();
        }
        return instance;
    }


    public boolean insertOrder(Order order)   {
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

        } catch (Exception e) {
            new Exception();
        } finally {
            close(connect);

        }

        return res;

    }

    private static Order extrationOrder(ResultSet rs) throws Exception {
        Order order = new Order();
        int k = 1;
        order.setId(rs.getInt(k++));
        order.setUser_id(rs.getInt(k++));
        order.setProdut_id(rs.getInt(k++));
        order.setCount_product(rs.getInt(k));

        return order;
    }

    private static void close(Connection con)  {
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
