package com.BitGo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BitGo {
	@Test
	private void urlPage() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.get(" https://blockstream.info/block/000000000000000000076c036ff5119e5a5a74df77abf64203473364509f7732");
		d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		WebElement tx = d.findElement(By.xpath("//div[@class='transactions']"));
		System.out.println(tx.isDisplayed());
		List<WebElement> findElements = d.findElements(By.xpath("//div[@class='txn']"));
		for (WebElement webElement : findElements) {
			
			System.out.println(webElement.getText());
		}
		WebElement firstin = d.findElement(By.xpath("(//div[@class='txn'])[1]"));
		System.out.println(firstin.getText());
		WebElement firstout = d.findElement(By.xpath("//div[@class='block-hash']"));
		System.out.println(firstout.getText());
	}

}
