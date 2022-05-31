package Orange.Definitions;

import Orange.Pages.LoginPage;
import Orange.Pages.PimPage;
import org.openqa.selenium.WebDriver;
import Orange.Steps.Connection;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import java.sql.SQLException;

public class DefinitionsSteps {

    private WebDriver driver;
    private Connection conexion = new Connection();
    private LoginPage loginPage;
    private PimPage pimPage;


    @Given("^open browser$")
    public void open_browser() {
        this.conexion = new Connection();
        this.driver = this.conexion.abrirNavegador();
    }

    @And("^diligenciar user (.*) y contrasena (.*)$")
    public void diligenciarLogin(String user, String pass) throws SQLException {
        this.loginPage = new LoginPage(driver);
        this.loginPage.diligenciarLogin(user, pass);
    }

    @And("^llegar a la opcion agregar empleado$")
    public void llegarAddEmployee() {
        this.pimPage = new PimPage(driver);
        this.pimPage.llegarAddEmployee();
    }

    @When("^diligenciie name (.*) y apellido (.*)$")
    public void diligenciarEmployee(String name, String lastName) throws SQLException {
        this.pimPage = new PimPage(driver);
        this.pimPage.diligenciarEmployee(name, lastName);

    }

}