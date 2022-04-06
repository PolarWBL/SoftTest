package com.ctgu.class05.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author Boliang Weng
 */
public class Demo {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\Work Space\\IdeaProjects\\SoftTest\\Class_05\\src\\main\\resources\\chromedriver.exe");
        //初始化浏览器名为driver
        WebDriver chrome = new ChromeDriver();
        //窗口最大化
        chrome.manage().window ().maximize ();
        //使用get()方法，打开百度网址
        chrome.get ("./index.html" );
        //关闭并退出浏览器
//        chrome.quit ();
    }
}
