import java.sql.*;
public class Connect {
    public static void main(String[] args) throws ClassNotFoundException {

        String url = "jdbc:mysql://localhost:3306/my_db";
        String username = "root";
        String password = "Ritesh2131";

        String query = "select * from student;";

        try {
            // Step 1: Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("✅ JDBC Driver loaded successfully!");
        } catch (ClassNotFoundException e) {
            System.out.println("❌ JDBC Driver not found: " + e.getMessage());
        }

        try{

           Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("Connection established ");
            Statement smt = con.createStatement();
          ResultSet res =  smt.executeQuery(query);

            String url = "jdbc:mysql://localhost:3306/my_db";
            String username = "root";
            String password = "Ritesh2131";

            String query = "select * from student;";

            try {
                // Step 1: Load the MySQL JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                System.out.println("✅ JDBC Driver loaded successfully!");
            } catch (ClassNotFoundException e) {
                System.out.println("❌ JDBC Driver not found: " + e.getMessage());
            }

            try{

                Connection con = DriverManager.getConnection(url,username,password);
                System.out.println("Connection established ");

          while (res.next()){

              int id = res.getInt("id");
              String name = res.getString("name");
              String job_title = res.getString("job_title");
              double salary = res.getDouble("salary");

              System.out.println();
              System.out.println("------------------------------------------------");
              System.out.println("Id: "+id);
              System.out.println("Name: "+name);
              System.out.println("Job_Title: "+job_title);
              System.out.println("Salary: "+salary);

          }

          res.close();
          smt.close();
          con.close();


        } catch (SQLException e) {
            System.out.println();
        }

    }

}