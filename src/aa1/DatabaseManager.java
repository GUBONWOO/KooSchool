import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private final String url = "jdbc:mysql://localhost:3306/subway_management"; // 데이터베이스 URL
    private final String user = "root"; // MySQL 사용자
    private final String password = "password"; // MySQL 비밀번호

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public static void main(String[] args) {
        DatabaseManager dbManager = new DatabaseManager();
        try (Connection conn = dbManager.connect()) {
            if (conn != null) {
                System.out.println("데이터베이스에 연결되었습니다!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
