import java.sql.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

     // Batch Processing in JDBC

        String url = "jdbc:mysql://localhost:3306/my_db";
        String username = "root";
        String password = "Ritesh2131";


        try {
            // Step 1: Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("✅ JDBC Driver loaded successfully!");
        } catch (ClassNotFoundException e) {
            System.out.println("❌ JDBC Driver not found: " + e.getMessage());
        }


        try {

            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established ");

            // Batch execution by single STATEMENT
//            Statement statement = con.createStatement();
//            statement.addBatch("INSERT INTO student (id, name, job_title, salary) VALUES (4 , 'Om','Analyst', 25000)");
//            statement.addBatch("INSERT INTO student (id, name, job_title, salary) VALUES (5 , 'Shara','CyberSecurity', 5000)");
//            statement.addBatch("INSERT INTO student (id, name, job_title, salary) VALUES (6 , 'Avni','DataScientist', 55000)");
//            statement.addBatch("INSERT INTO student (id, name, job_title, salary) VALUES (7 , 'Mayank','Youtuber', 65000)");
//
//            int a [] =statement.executeBatch();
//            con.commit();
//            System.out.println("Batch Executed Successfully !!");

            con.setAutoCommit(false);

            // Batch execution by single  PREPARED-STATEMENT
             String query = "INSERT INTO student (id, name, job_title, salary) VALUES( ?,?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            Scanner sc = new Scanner(System.in);

            while (true){

                System.out.print("Enter Id ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter name ");
                String name = sc.nextLine();

                System.out.print("Enter job_title ");
                String job_title = sc.nextLine();

                System.out.print("Enter salary ");
                double salary = sc.nextDouble();
                sc.nextLine();


                preparedStatement.setInt(1,id);
                preparedStatement.setString(2,name);
                preparedStatement.setString(3,job_title);
                preparedStatement.setDouble(4,salary);

                preparedStatement.addBatch();

                System.out.println("do you want add more Values Y/N");

                String decision = sc.nextLine();

                if (decision.toUpperCase().equals("N")){
                    break;
                }

            }

            int a [] = preparedStatement.executeBatch();
            con.commit();
            System.out.println("Batch executed Successfully by PrePread Statement");




        } catch (SQLException e) {
            System.out.println("Something went wrong"+e.getMessage());
        }



    }
}