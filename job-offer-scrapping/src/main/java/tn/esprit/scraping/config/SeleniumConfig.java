package tn.esprit.scraping.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.net.MalformedURLException;
import java.net.URL;

@Configuration
public class SeleniumConfig {

    @Value("${selenium.remote.url}")
    private String seleniumRemoteUrl;

    @Bean
    public WebDriver webDriver() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
        return new RemoteWebDriver(new URL(seleniumRemoteUrl), options);
    }
}
