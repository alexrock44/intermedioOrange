package Orange.Pages;

import Orange.Steps.ButtonPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PimPage {

    private ButtonPages buttonPges;

    @FindBy(how = How.ID, using = "firstName")
    private WebElement txtName;

    @FindBy(how = How.ID, using = "lastName")
    private WebElement txtApellido;

    public PimPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.buttonPges = new ButtonPages(driver);

    }

    public void llegarAddEmployee(){
        buttonPges.btnPim();
        buttonPges.setBtnAddEmployee();
    }

    public void diligenciarEmployee(String name,String lastName){
        txtName.sendKeys(name);
        txtApellido.sendKeys(lastName);
        buttonPges.btnSave();
    }

}
