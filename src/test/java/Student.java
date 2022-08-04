import java.sql.*;
import java.util.*;


public class Student {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/test";
        String user = "root";
        String pwd = "Guru@1508";
        Connection  connection=null;

        try {
            //Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, pwd);
            System.out.println("Connection is successful");

        } catch (SQLException throwables) {

            throwables.printStackTrace();
        }
        System.out.println("enter 1 to insert and 2 to display");
        Scanner inp = new Scanner(System.in);
        int choice=inp.nextInt();
        if(choice==1){
            System.out.print("enter the id");
            int id = inp.nextInt();
            System.out.print("enter the name");
            String name = inp.next();
            String Q1 = "insert into student values(?,?)";
            PreparedStatement ps = connection.prepareStatement(Q1);
            ps.setInt(1,id);
            ps.setString(2,name);
            ps.execute();
            System.out.println("data entered successfully");
        }
      else if(choice==2){
            String Q="select * from student";
            Statement s1= connection.createStatement();
            ResultSet r=s1.executeQuery(Q);
            int id;
            String name;
            while(r.next())
            {
               id=r.getInt(1);
                name=r.getString(2);
                System.out.println(id+""+name);
            }

        }
    connection.close();



}

}

