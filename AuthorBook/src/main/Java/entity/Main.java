package entity;

import java.sql.*;
import java.util.Scanner;

public class Main {

    private static Connection getDBConnection() {
        Connection dbConnection = null;
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection("jdbc:h2:~/test7", "username","");
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //
        return dbConnection;
    }

    private static void CreateTableAuthor() throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;

        String createTableSQL = "Create table Author (Id int primary key auto_increment, FirstName varchar(50), LastName varchar(50), Year int)";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            statement.execute(createTableSQL);
            System.out.println("Table \"Author\" is created!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }

    private static void CreateTableBook() throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;

        String createTableSQL = "Create table Book (Id int primary key auto_increment, Name varchar(50), description varchar(50), " +
                "Published varchar(50), Year int)";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            // выполнить SQL запрос
            statement.execute(createTableSQL);
            System.out.println("Table \"Book\" is created!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }

    private static void ShowTableAuthor() throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;

        String selectTableSQL = "SELECT * from Author;";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            ResultSet rs = statement.executeQuery(selectTableSQL);

            byte c = 0;
            while (rs.next()) {
                c++;
                String Id = rs.getString("Id");
                String Name = rs.getString("Name");
                String FirstName = rs.getString("FirstName");
                String LastName = rs.getString("LastName");
                String Year = rs.getString("Year");

                System.out.println("Id : " + Id);
                System.out.println("Name : " + Name);
                System.out.println("FirstName : " + FirstName);
                System.out.println("LastName : " + LastName);
                System.out.println("Year : " + Year);
                System.out.println();
            }
            if (c == 0) System.out.println("empty");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void ShowTableBook() throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;

        String selectTableSQL = "SELECT * from Book;";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            ResultSet rs = statement.executeQuery(selectTableSQL);

            byte c = 0;
            while (rs.next()) {
                c++;
                String Id = rs.getString("Id");
                String Name = rs.getString("Name");
                String Description = rs.getString("Description");
                String Published = rs.getString("Published");
                String Year = rs.getString("Year");

                System.out.println("Id : " + Id);
                System.out.println("Name : " + Name);
                System.out.println("Description : " + Description);
                System.out.println("Published : " + Published);
                System.out.println("Year : " + Year);
                System.out.println();
            }
            if (c == 0) System.out.println("empty");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void InsertTableAuthor(String FirstName, String LastName, int Year) throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;

        String selectTableSQL = "Insert into Author (FirstName, LastName, Year) values ('" + FirstName + "', '" + LastName + "', " + Year + " );";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            statement.executeUpdate(selectTableSQL);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void InsertTableBook(String Name, String Description, String Published, int Year) throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;

        String selectTableSQL = "Insert into Book (Name, Description, Published, Year) values ('" + Name + "', '" +
                Description + "', '" + Published + "', " + Year + " );";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            statement.executeUpdate(selectTableSQL);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void DeleteTable(int Id, String Name) throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;

        String selectTableSQL = "delete " + Name + " where id = " + Id + ";";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            statement.executeUpdate(selectTableSQL);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void EditTableAuthor(int Id, String FirstName, String LastName, int Year) throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;

        String selectTableSQL = "update Author set FirstName = '" + FirstName + "', '" + LastName + "', " +
                Year + " where id = '" + Id + "';";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            statement.executeUpdate(selectTableSQL);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void EditTableBook(int Id, String Name, String Description, String Published, int Year) throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;

        String selectTableSQL = "update Book set Name = '" + Name + "', '" + Description + "', '" +
               Published + "', " + Year + " where id = '" + Id + "';";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            statement.executeUpdate(selectTableSQL);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void menu(){
        System.out.println("------------------------------");
        System.out.println("add Author, press key: 1");
        System.out.println("Edit Author, press key: 2");
        System.out.println("delete Author, press key: 3");
        System.out.println("Show All Author, press key: 4");
        System.out.println("------------------------------");
        System.out.println("add Book, press key: 5");
        System.out.println("Edit Book, press key: 6");
        System.out.println("delete Book, press key: 7");
        System.out.println("Show All Book, press key: 8");
        System.out.println("------------------------------");
        System.out.println("Exit, press key: 9");
        System.out.println("------------------------------");
        System.out.println();
    }

    private static boolean Ans(){
        while (true) {
            System.out.println();
            System.out.println("continue? y/n");
            String ans = scanner.next();
            System.out.println();
            if (ans.equals("n")) return false;
            if (ans.equals("y")) return true;
        }
    }

    private static int InsertId(String Names){
        System.out.println("Enter "+ Names +": ");
        int Id = scanner.nextInt();
        return Id;
    }

    private static String InsertName(String Names){
        System.out.println("Enter "+ Names +": ");
        String Name = scanner.next();
        return Name;
    }

    private static int DeleteId(){
        System.out.println("Enter Id: ");
        int Id = scanner.nextInt();
        return Id;
    }

    private static int EditId(String Names){
        System.out.println("Enter edit " + Names + ": ");
        int Id = scanner.nextInt();
        return Id;
    }

    private static String EditName(String Names){
        System.out.println("Enter edit " + Names + ": ");
        String Name = scanner.next();
        return Name;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main (String[] args) throws ClassNotFoundException, SQLException {
        try {
            //CreateTableAuthor();
            //CreateTableBook();
            while (true) {
                menu();
                int change = scanner.nextInt();
                switch (change) {
                    case 1:
                        String FirstName = InsertName("FirstName");
                        String LastName = InsertName("LastName");
                        int Year = InsertId("Year");
                        InsertTableAuthor(FirstName, LastName, Year);
                        if(!Ans()) return;
                        break;
                    case 2:
                        int id = EditId("Id");
                        FirstName = EditName("FirstName");
                        LastName = EditName("LastName");
                        Year = EditId("Year");
                        EditTableAuthor(id, FirstName, LastName, Year );
                        if(!Ans()) return;
                        break;
                    case 3:
                        id = DeleteId();
                        DeleteTable(id, "Author");
                        if(!Ans()) return;
                        break;
                    case 4:
                        ShowTableAuthor();
                        if(!Ans()) return;
                        break;
                    case 5:
                        String Name = InsertName("Name");
                        String Description = InsertName("Description");
                        String Puplished = InsertName("Puplished");
                        Year = InsertId("Year");
                        InsertTableBook(Name, Description, Puplished, Year);
                        if(!Ans()) return;
                        break;
                    case 6:
                        id = EditId("Id");
                        Name = EditName("Name");
                        Description = EditName("Description");
                        Puplished = EditName("Puplished");
                        Year = EditId("Year");
                        EditTableBook(id, Name, Description, Puplished, Year );
                        if(!Ans()) return;
                        break;
                    case 7:
                        id = DeleteId();
                        DeleteTable(id, "Book");
                        if(!Ans()) return;
                        break;
                    case 8:
                        ShowTableBook();
                        if(!Ans()) return;
                        break;
                    case 9:
                        return;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        scanner.close();
    }

}