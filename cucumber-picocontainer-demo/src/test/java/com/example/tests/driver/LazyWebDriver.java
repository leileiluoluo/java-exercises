package com.example.tests.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.picocontainer.Disposable;

import java.util.List;
import java.util.Set;

public class LazyWebDriver implements WebDriver, Disposable {

    private WebDriver delegate = null;

    public WebDriver getDelegate() {
        if (null == delegate) {
            delegate = new ChromeDriver();
        }
        return delegate;
    }

    @Override
    public void get(String url) {
        getDelegate().get(url);
    }

    @Override
    public String getCurrentUrl() {
        return getDelegate().getCurrentUrl();
    }

    @Override
    public String getTitle() {
        return getDelegate().getTitle();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return getDelegate().findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return getDelegate().findElement(by);
    }

    @Override
    public String getPageSource() {
        return getDelegate().getPageSource();
    }

    @Override
    public void close() {
        getDelegate().close();
    }

    @Override
    public void quit() {
        getDelegate().quit();
    }

    @Override
    public Set<String> getWindowHandles() {
        return getDelegate().getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
        return getDelegate().getWindowHandle();
    }

    @Override
    public TargetLocator switchTo() {
        return getDelegate().switchTo();
    }

    @Override
    public Navigation navigate() {
        return getDelegate().navigate();
    }

    @Override
    public Options manage() {
        return getDelegate().manage();
    }

    @Override
    public void dispose() {
        System.out.println("Closing WebDriver");
        if (null != delegate) {
            delegate.quit();
        }
    }
}
