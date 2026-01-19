import java.sql.*;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        // Pre_Parared Statement in JDBC

        String url = "jdbc:mysql://localhost:3306/my_db";
        String username = "root";
        String password = "Ritesh2131";

        String query = "select * from student where name = ? ;";

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

            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1 ,"Ritesh");
            ResultSet  resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){

                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String job_title = resultSet.getString("job_title");
                double salary = resultSet.getDouble("salary");

                System.out.println("id"+id);
                System.out.println("name"+name);
                System.out.println("job_title"+job_title);
                System.out.println("salary"+salary);



            }



            con.close();
            resultSet.close();
            preparedStatement.close();


            System.out.println("Run effeciently");
        }
        catch (SQLException e) {
            System.out.println("jhol jhaal "+e.getMessage());
        }


}

}