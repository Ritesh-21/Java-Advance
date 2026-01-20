import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

        String url = "jdbc:mysql://localhost:3306/my_db";
        String username = "root";
        String password = "Ritesh2131";
//        String image_path = "C:\\Users\\HI\\Downloads\\imagefolder\\6140889397839645184.jpg"; dalne ke liye
//        String query = "INSERT INTO image_table(image_data) VALUES (?)";

        String image_folder = "C:\\Users\\HI\\Downloads\\imagefolder\\";
        String query = "select image_data from image_table where image_id =(?);";



        try {
            // Step 1: Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("✅ JDBC Driver loaded successfully!");
        } catch (ClassNotFoundException e) {
            System.out.println("❌ JDBC Driver not found: " + e.getMessage());
        }

        try {

//            FileInputStream fileInputStream = new FileInputStream(image_path);
//            byte [] image_data = new byte[fileInputStream.available()];
//            fileInputStream.read(image_data);
//            PreparedStatement preparedStatement = con.prepareStatement(query);
//            preparedStatement.setBytes(1,image_data);
//
//            int affectedrows = preparedStatement.executeUpdate();
//
//            if(affectedrows>0){
//                System.out.println("Image Inaserted Successful");
//            }
//            else {
//                System.out.println("Image insertion failed");
//            }
// ye uper wala code image ko pehle folder se java progra mai lana fir database mai dalne ka hai aur neeche wala databse se laake javaprogram mai fir uss hi folder mai
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established ");

            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1,1);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                byte[] image_data = resultSet.getBytes("image_data");
                String image_path = image_folder+"Extracted_iamge.jpg";
                OutputStream outputStream = new FileOutputStream(image_path);
                outputStream.write(image_data);

            }
            else {
                System.out.println("image failed");
            }


        }

        catch (SQLException e) {
            System.out.println("jhol jhaal "+e.getMessage());
        }
    }
}