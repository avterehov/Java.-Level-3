import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

public class Main {

    private static Connection connection;
    private static Statement stmt;

    public static void main(String[] args) {

       try {
            connect();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            deleteTable();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            createTable();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            addData("Anton", "100");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            readData("1");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        updateScoreData("1", "300");
        try {
            readData("2");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            readData("1");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        try {
            updatefromFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            readData("1");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            deleteEntry("1");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }




    }
    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:main1.db");
        stmt = connection.createStatement();
        System.out.println("Connected to DB");
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTable () throws SQLException{
        stmt.executeUpdate("CREATE TABLE students (\n" +
                "    id    INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    name  TEXT,\n" +
                "    score INTEGER\n" +
                ");");
        System.out.println("Table created");

            }


      private static void addData (String name, String score) throws SQLException{

        String sql = String.format("INSERT INTO students (name, score) VALUES ('Bob1', '100')", name, score);
        stmt.executeUpdate(sql);
           sql = String.format("INSERT INTO students (name, score) VALUES ('Bob2', '200')", name, score);
          stmt.executeUpdate(sql);
          sql = String.format("INSERT INTO students (name, score) VALUES ('Bob3', '200')", name, score);
          stmt.executeUpdate(sql);
        System.out.println("Data added");

        }

        private static void readData (String id) throws SQLException{
            try {
                String sql = String.format("SELECT * FROM students where id = %s", id);
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()){
                    System.out.println(rs.getString("name" )+ " " + rs.getString("score" ));
                }
            }  catch (SQLException e) {
                e.printStackTrace();
            }
        }



        public static void updateScoreData (String id, String score){
            String sql = String.format("UPDATE students SET score = '%s' where id = %s", score, id);
            try {
                stmt.executeUpdate(sql);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }

        public static void deleteEntry (String id ) throws SQLException {
        String sql = String.format("DELETE FROM students where id = %s", id);
        stmt.executeUpdate(sql);
        System.out.println("Entry " + id + " deleted");
        }

     public static void deleteTable() throws SQLException{
        stmt.executeUpdate( "DROP TABLE students");
        System.out.println("table deleted");
     }

     public static void updatefromFile() throws FileNotFoundException{
         FileInputStream fileInputStream = new FileInputStream("text.txt");
         Scanner sc = new Scanner(fileInputStream);

         while (sc.hasNext()) {
             String []  arr = sc.nextLine().split(" ");
             updateScoreData(arr[0], arr[2]);
         }

     }



}
