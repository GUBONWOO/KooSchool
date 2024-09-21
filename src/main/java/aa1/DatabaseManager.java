package aa1;

import java.sql.*;

public class DatabaseManager {
    private final String url = "jdbc:mysql://localhost:3306/subway_management"; // 데이터베이스 URL
    private final String user = "root"; // MySQL 사용자
    private final String password = "1539"; // MySQL 비밀번호

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    // 데이터 삽입 메서드
    public void insertTransport(String name, String dsn, int date, int price) {
        String query = "INSERT INTO transports (name, dsn, date, price) VALUES (?, ?, ?, ?)"; // 실제 테이블명 사용
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, name);
            stmt.setString(2, dsn);
            stmt.setInt(3, date);
            stmt.setInt(4, price);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 데이터 조회 메서드
    public void getInf(int month) {
        String query = "SELECT * FROM transports WHERE date = " + month;
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                String name = rs.getString("name");
                String dsn = rs.getString("dsn");
                int date = rs.getInt("date");
                int price = rs.getInt("price");
                System.out.println("이름: " + name + ", 목적지: " + dsn + ", 월: " + date + ", 금액: " + price);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
