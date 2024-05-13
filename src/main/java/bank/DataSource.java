package bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataSource {
  public static Connection connect() {
    String db_file = "jdbc:sqlite:resources/bank.db";
    Connection connection = null;
    try {
      connection = DriverManager.getConnection(db_file);
      System.out.println("we are connected");
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return connection;
  }

  public static Customer getCustomer(String username) {
    String sql = "select * from customers where username = ?";
    Customer customer = null;
    try (Connection connection = connect();
        PreparedStatement statement = connection.prepareStatement(sql)) {
      statement.setString(1, username);
      try (ResultSet rs = statement.executeQuery()) {
        customer = new Customer(
            rs.getInt("id"),
            rs.getString("username"),
            rs.getString("name"),
            rs.getString("password"),
            rs.getInt("account_id"));
      }
      ;

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return customer;
  }

  public static void main(String[] args) {
    Customer customer = getCustomer("agrzelewskimt@intel.com");
    System.out.println(customer.getName());
  }
}
