package com.example.seleniumprueba;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
import static org.junit.jupiter.api.Assertions.*;

import static com.codeborne.selenide.Selenide.*;

public class MainPageTest {

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x1000"; // Screen resolution
        SelenideLogger.addListener("allure", new AllureSelenide()); // Open browser
    }

    @BeforeEach
    public void setUp() {
        open("http://localhost:3000/");     // Url that will be open
    }

    @Test
    public void createMessage() {
        // Test to comprobate the main buttons and create a message on the Forum

        $("button[data-test='mainBtn']").click();
        $("button[data-test='football']").click();
        $("button[data-test='backBtn']").click();
        $("button[data-test='gym']").click();
        $("button[data-test='titleFormBtn']").click();
        $("[data-test='warningEmptyField']").shouldBe(visible);
        $("input[data-test='titleForm']").setValue("Holii");
        $("input[data-test='titleForm']").shouldHave(attribute("value","Holii"));
        $("button[data-test='titleFormBtn']").click();
        $("[data-test='textArea']").setValue("Lorem ipsum dolor etc etc.");
        $("button[data-test='checkBtn']").shouldBe(interactable);
        $("button[data-test='checkBtn']").click();
        $("button[data-test='submitBtn']").shouldBe(interactable);
        $("button[data-test='submitBtn']").click();
    }
}
