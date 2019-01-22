import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_test {
    public static void main(String[] args) throws ClassNotFoundException {
        String sql = "SELECT * FROM sample ORDER BY id ASC";

        //DB接続時、DB接続種類選択
        Class.forName("org.sqlite.JDBC");
        //try-with-resources try文のあとのカッコ内が自動でcloseされる
        String db_path = new File(".").getAbsoluteFile().getParent();
        db_path = db_path + "/db/dbtest.sqlite3";
        try (
            Connection connection = DriverManager.getConnection("jdbc:sqlite:" + db_path);
            Statement statement = connection.createStatement()){
            statement.setQueryTimeout(30);

            //sqlに入っているSQL文を実行
            ResultSet rs = statement.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next()) {
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    System.out.print(rs.getString(i));
                    System.out.print(i < rsmd.getColumnCount() ? "," : "");
                }
                System.out.print(System.getProperty("line.separator"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}