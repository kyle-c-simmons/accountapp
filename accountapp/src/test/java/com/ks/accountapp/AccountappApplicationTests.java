package com.ks.accountapp;

import com.ks.accountapp.AccountController;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountappApplicationTests {

    private ExtentReports report = new ExtentReports("~/Documents/accountapp/src/api-testing.html", true);
    private ExtentTest test;

    @Autowired
    private AccountController controller;

    private TestRestTemplate restTemplate = new TestRestTemplate();
    private HttpHeaders headers = new HttpHeaders();

    @Test
    public void contextLoads() {
        try {
            test = report.startTest("Content Loads");
            assertThat(controller).isNotNull();
            test.log(LogStatus.INFO, "Controller class found");
            test.log(LogStatus.PASS, "Content loaded");

        } catch (Exception e) {
            test.log(LogStatus.INFO, "Controller class not found");
            test.log(LogStatus.FAIL, "Content NOT loaded");
        } finally { }
    }

    @Test
    public void testRetrieveAccountById() {
        try {
            HttpEntity<String> entity = new HttpEntity<String>(null, headers);

            ResponseEntity<String> response = restTemplate.exchange(
                    createURLWithPort("/accounts/5b6ff136bd2afa7b58cce9db"),
                    HttpMethod.GET, entity, String.class);

            String expected = "{firstname:Kyle,surname:Simmons,accountnumber:1234}";

            JSONAssert.assertEquals(expected, response.getBody(), true);
            test.log(LogStatus.INFO, "Getting url...");
            test.log(LogStatus.PASS, "Account retrieved");

        } catch (Exception e) {
            test.log(LogStatus.INFO, "Retrieving Account by id of: 5b6ff136bd2afa7b58cce9db...");
            test.log(LogStatus.FAIL, "Account could not be retrieved");
        } finally {
            report.flush();
        }


    }

    private String createURLWithPort(String uri) {
        return "http://localhost:8090" + uri;
    }
}