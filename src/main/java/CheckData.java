
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CheckData {

    //驱动程序名
    static String driver = "com.mysql.cj.jdbc.Driver";
    //URL指向要访问的数据库名mydata
    static String url = "jdbc:mysql://mysql.medbanks-test.com:3306/smo_paiwork";
    //MySQL配置时的用户名
    static String user = "test_rw";
    //MySQL配置时的密码
    static String password = "Kyig&pnlGnaHaJ";

    static String projectNumbers = "";

    public static void main(String[] args) {
        //声明Connection对象
        Connection con;

        try {
            //加载驱动程序
            Class.forName(driver);
            //1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url, user, password);
            if (!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            //2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            //要执行的SQL语句
            String sql_table = "SELECT\n" +
                    "\ttable_name \n" +
                    "FROM\n" +
                    "\tinformation_schema.COLUMNS \n" +
                    "WHERE\n" +
                    "\tTABLE_SCHEMA = 'smo_paiwork' \n" +
                    "\tAND COLUMN_NAME = 'project_number'";
            //3.ResultSet类，用来存放获取的结果集！！
            ResultSet rs = statement.executeQuery(sql_table);

            List<String> table_name_list = new ArrayList<>();
            while (rs.next()) {
                table_name_list.add(rs.getString("table_name"));
            }
            for (int i = 0; i < table_name_list.size(); i++) {
                String table_name = table_name_list.get(i);
//                String sql_column = "UPDATE " + table_name + "qr \n" +
//                        "SET qr.delete_flag = 1 \n" +
//                        "WHERE\n" +
//                        "\tproject_number IN (" + projectNumbers + ")";
//                int rs1 = statement.executeUpdate(sql_column);
//                if (rs1 > 0) {
                    System.out.println("操作成功表:" + table_name_list.get(i));
//                }
            }
            rs.close();
            con.close();//关闭连接
        } catch (ClassNotFoundException e) {
            //数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        } catch (SQLException e) {
            //数据库连接失败异常处理
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }
}
