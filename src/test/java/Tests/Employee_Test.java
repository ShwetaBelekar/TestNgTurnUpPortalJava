package Tests;

import Pages.EmployeeHomePage;
import Pages.EmployeePage;
import Pages.LoginPage;
import Utilities.CommonDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;



public class Employee_Test extends CommonDriver
{

    @BeforeTest
    public void SetUpSteps() throws InterruptedException
    {

        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver();

        driver = new ChromeDriver(options);

        LoginPage loginPageObj = new LoginPage();
        loginPageObj.LoginActions(driver);

        //User has logged in successfully
        loginPageObj.VerifyUserInHomePage(driver);

        EmployeeHomePage employeeHomePageObj = new EmployeeHomePage();
        employeeHomePageObj.NavigateToEmployeesPage(driver);

    }

    @Test
    public void CreateEmployee_Test() throws InterruptedException
    {
        EmployeePage employeePageObj = new EmployeePage();
        employeePageObj.CreateEmployeeRecord(driver);
    }

    @Test
    public void EditEmployee_Test() throws InterruptedException
    {
        EmployeePage employeePageObj = new EmployeePage();
        employeePageObj.EditEmployeeRecord(driver);

    }

    @Test
    public void DeleteEmployee_Test() throws InterruptedException
    {
        EmployeePage employeePageObj = new EmployeePage();
        employeePageObj.DeleteEmployeeRecord(driver);

    }

    @AfterTest
    public void CloseTestRun()
    {
        driver.quit();

    }

}

