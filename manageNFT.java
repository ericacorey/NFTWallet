
public class manageNFT {

    NFT NFT1 = new NFT("Mike", 100, true);

    public boolean verifyNFT(NFT NFT1) { // if NFT is locked, return 1, else return 2.
        if (NFT1.lock_status == true) {
            return true;
        } else {
            return false;
        }

    }

    public boolean LockNFT(NFT NFT1) {
        this.NFT1.lock_status = false;
        return (this.NFT1.lock_status);
    }

}

/**
 * 
 * public class JDBConnection {
 * public static void main(String[] args) {
 * // AllTables();
 * 
 * 
 * 
 * boolean run = true;
 * 
 * while (run) {
 * // runApp()
 * // call a big method that calls other methods based on userinput
 * Scanner scanner = new Scanner(System.in);
 * 
 * System.out.println("Choose a function: 1.Display all tables; 2. Employee
 * Info; 3.Plane Info; 4. Passenger Info, 5. Exit");
 * int userInput = scanner.nextInt();
 * switch(userInput) {
 * case 1:
 * RunApp();
 * break;
 * case 2:
 * EmployeeInfo();
 * break;
 * case 3:
 * AllPlanes();
 * 
 * case 4:
 * PassengerInfo();
 * default:
 * run = false;
 * 
 * }
 * 
 * }
 * // if statement here
 * // System.out.println("Your input was.." + userInput);// remove this line
 * after putting if statement
 * 
 * }
 * 
 * 
 * 
 * public static void RunApp() {
 * AllTables(false);
 * }
 * 
 * 
 * 
 * public static void EmployeeInfo() {
 * 
 * 
 * try {
 * 
 * // Line 20 is a custom based on your local database. Remove "airportdb" and
 * // replace with the db that your using. Likewise, use the username and
 * password
 * // you used when setting up your database connection.
 * 
 * // System.out.println("Connection Sucessful!.......");
 * Connection connection =
 * DriverManager.getConnection("jdbc:mysql://localhost:3306/airportdb", "root",
 * "taco");
 * 
 * System.out.println("Connection Sucessful!.......");
 * 
 * 
 * Statement statement = connection.createStatement();
 * 
 * ResultSet resultSet = statement.executeQuery("select * from employees");
 * 
 * while (resultSet.next()) {
 * System.out.println(resultSet.getString("EmployeeID"));
 * System.out.println(resultSet.getString("FirstName"));
 * System.out.println(resultSet.getString("LastName"));
 * System.out.println("-------------------");
 * 
 * 
 * }
 * statement.close();
 * } catch (Exception e) {
 * e.printStackTrace();
 * }
 * 
 * }
 * 
 * public static void AllTables(boolean run) {
 * try {
 * run = false;
 * 
 * Connection connection =
 * DriverManager.getConnection("jdbc:mysql://localhost:3306/airportdb", "root",
 * "taco");
 * 
 * System.out.println("Connection Sucessful!.......");
 * Statement statement = connection.createStatement();
 * 
 * ResultSet resultSet = statement.executeQuery("Show tables");
 * System.out.println("Tables in the current database: ");
 * while (resultSet.next()) {
 * System.out.print(resultSet.getString(1));
 * System.out.println();
 * }
 * } catch (Exception e) {
 * e.printStackTrace();
 * }
 * 
 * System.out.println("-------------------------");
 * }
 * 
 * public static void AllPlanes(){
 * 
 * try {
 * 
 * // Line 20 is a custom based on your local database. Remove "airportdb" and
 * // replace with the db that your using. Likewise, use the username and
 * password
 * // you used when setting up your database connection.
 * 
 * // System.out.println("Connection Sucessful!.......");
 * Connection connection =
 * DriverManager.getConnection("jdbc:mysql://localhost:3306/airportdb", "root",
 * "taco");
 * 
 * System.out.println("Connection Sucessful!.......");
 * 
 * 
 * Statement statement = connection.createStatement();
 * 
 * ResultSet resultSet = statement.executeQuery("select * from Planes");
 * 
 * while (resultSet.next()) {
 * System.out.println(resultSet.getString("TailCode"));
 * System.out.println(resultSet.getString("Manufacturer"));
 * System.out.println(resultSet.getString("Model"));
 * System.out.println(resultSet.getString("MaxPassengers"));
 * System.out.println(resultSet.getString("AirlineID"));
 * System.out.println("-------------------");
 * 
 * 
 * 
 * // System.out.println(resultSet.getString("LastName"));
 * 
 * }
 * statement.close();
 * } catch (Exception e) {
 * e.printStackTrace();
 * }
 * 
 * }
 * 
 * 
 * public static void PassengerInfo(){
 * try {
 * 
 * // Line 20 is a custom based on your local database. Remove "airportdb" and
 * // replace with the db that your using. Likewise, use the username and
 * password
 * // you used when setting up your database connection.
 * 
 * // System.out.println("Connection Sucessful!.......");
 * Connection connection =
 * DriverManager.getConnection("jdbc:mysql://localhost:3306/airportdb", "root",
 * "taco");
 * 
 * System.out.println("Connection Sucessful!.......");
 * 
 * 
 * Statement statement = connection.createStatement();
 * 
 * ResultSet resultSet = statement.executeQuery("select * from Passengers");
 * 
 * while (resultSet.next()) {
 * System.out.println(resultSet.getString("PassID"));
 * System.out.println(resultSet.getString("FirstName"));
 * System.out.println(resultSet.getString("LastName"));
 * System.out.println("-------------------");
 * 
 * 
 * 
 * // System.out.println(resultSet.getString("LastName"));
 * 
 * }
 * statement.close();
 * } catch (Exception e) {
 * e.printStackTrace();
 * }
 * }
 * 
 * }
 * 
 */