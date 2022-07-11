package pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    @FindBy(className = "new-todo")
    WebElement txtToDo;

    @FindBy(partialLinkText = "All")
    WebElement linkAll;

    @FindBy(partialLinkText = "Active")
    WebElement linkActive;

    @FindBy(partialLinkText = "Completed")
    WebElement linkCompleted;

    @FindBy(xpath = "//button[@class='clear-completed']")
    WebElement buttonClearCompleted;

    public HomePage(WebDriver driver) {
        this.driver = driver;
            // This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

    public void addToDo(String todoItem) {
        txtToDo.sendKeys(todoItem);
        txtToDo.sendKeys(Keys.ENTER);
    }

    public boolean isActiveToDo(String todoItem) {
        boolean activeToDoExists = true;
        try{
            driver.findElement(By.xpath("//ul[@class='todo-list']/li[@class='todo']/div/label[contains(text(),'" + todoItem + "'" + ")]")).isDisplayed();
        }catch(NoSuchElementException e){
            activeToDoExists = false;
        }
        return activeToDoExists;
    }

    public boolean isLabelExists(String labelName) {
        boolean labelExists = true;
        try{
            driver.findElement(By.xpath("//label[contains(text(),'" + labelName + "'" + ")]")).isDisplayed();
        }catch(NoSuchElementException e){
            labelExists = false;
        }
        return labelExists;
    }

    public boolean isCompletedToDo(String todoItem) {
        boolean completedToDoExists = true;
        try{
            driver.findElement(By.xpath("//ul[@class='todo-list']/li[@class='todo completed']/div/label[contains(text(),'" + todoItem + "'" + ")]")).isDisplayed();
        }catch(NoSuchElementException e){
            completedToDoExists = false;
        }
        return completedToDoExists;

    }

    public boolean todoCount(String todoLeftCount) {
        boolean todoCountExists = true;
        try{
            driver.findElement(By.xpath("//span[@class = 'todo-count']/strong[contains(text(),'" + todoLeftCount + "'" + ")]")).isDisplayed();
        }catch(NoSuchElementException e){
            todoCountExists = false;
        }
        return todoCountExists;
    }

    public void clickLinkAll() {
        this.linkAll.click();
    }

    public void clickLinkActive() {
        this.linkActive.click();
    }
    public void clickLinkCompleted() {
        this.linkCompleted.click();
    }

    public void clickButtonClearCompleted() {
        this.buttonClearCompleted.click();
    }

}
