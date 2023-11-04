package Task2.Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Hashtable;

public class TaskDAO {
    public boolean insert(Hashtable<String, String> data) {
        int count;
        try{
            Connection conn = getConnection();
            PreparedStatement stmt = insertStatement(conn,data);
            count = stmt.executeUpdate();
            if (count == 0){
                stmt = insertStatement(conn,data);
                count = stmt.executeUpdate();
            }
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
            return false;
        }
        return count > 0;
    }

    private PreparedStatement insertStatement(Connection conn, Hashtable<String,String> data) throws SQLException {
        String query = "insert into tasks(task_description,is_completed) values(?,?);";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1,data.get("task_description"));
        stmt.setString(2,data.get("is_completed"));
        return stmt;
    }

    public boolean delete(Integer id) {
        int count;
        try{
            Connection conn = getConnection();
            PreparedStatement stmt = deleteStatement(conn,id);
            count = stmt.executeUpdate();
        } catch(SQLException ex){
            return false;
        }
        return count > 0;
    }

    private PreparedStatement deleteStatement(Connection conn,Integer id) throws SQLException{
        String query = "delete from tasks where task_id = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1,id.toString());
        return stmt;
    }

    public ArrayList<Hashtable<String, String>> load() {
        ArrayList<Hashtable<String,String>> data = new ArrayList<>();
        String query = "select task_id,task_description,is_completed from tasks";
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Hashtable<String,String> o = new Hashtable<>();
                o.put("task_id", rs.getString("task_id"));
                o.put("task_description", rs.getString("task_description"));
                if(Boolean.getBoolean(rs.getString("is_completed")))
                    o.put("is_completed", "true");
                else
                    o.put("is_completed", "false");

                data.add(o);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    }

    private static Connection getConnection()
            throws SQLException
    {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/task_manager", "root", "DragonBall1!");
    }
}
