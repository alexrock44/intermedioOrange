package Orange.BaseDatos;

        import Orange.Pages.PimPage;
        import org.openqa.selenium.WebDriver;

        import java.sql.Connection;
        import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.sql.Statement;

public class InsertEmployee {

    private ConectionBd conectionBd;
    private WebDriver driver;
    private PimPage pimPage;

    public InsertEmployee() {
        this.conectionBd = new ConectionBd();
        this.driver = driver;
        this.pimPage = new PimPage(driver);

    }

    public static void insertAddEmployee(String name, String lastName) throws SQLException {
        Connection testCon = ConectionBd.getConnection();

        String insertSql = "INSERT INTO newEmployee (firstName, lastName) VALUES"
                + "('" + name + "', '" + lastName + "')";

        ResultSet resultSet = null;

        try (Connection connection = ConectionBd.getConnection();
             PreparedStatement prepsInsertProduct = connection.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);) {

            prepsInsertProduct.execute();
            // Retrieve the generated key from the insert.
            resultSet = prepsInsertProduct.getGeneratedKeys();

            // Print the ID of the inserted row.
            while (resultSet.next()) {
                System.out.println("Generated: " + resultSet.getString(1));
            }
        }
        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }

    }

}