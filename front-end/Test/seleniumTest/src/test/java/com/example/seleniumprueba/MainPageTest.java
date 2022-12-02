package com.example.seleniumprueba;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPageTest {
    MainPage mainPage = new MainPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x1000"; // Resolución pantalla que se va a abrir
        SelenideLogger.addListener("allure", new AllureSelenide()); // Abrir pantallaa
    }

    @BeforeEach
    public void setUp() {
        open("http://localhost:3000/");     // Página que va a abrirse
    }

    @Test
    public void search() {
        $("button[data-test='mainBtn']").click();
        $("button[data-test='football']").click();
        $("button[data-test='football']").click();
        $("search-input[data-test='titleForm']").sendKeys("Holii");
        $("button[data-test='titleFormBtn']").click();

        //mainPage.searchButton.click();  // Aquí busca un botón usando el asistente y le hace click
        //$("button[data-test='full-search-button']").click();  // Busca especificamente un botón y le clicka

        //$("input[data-test='search-input']").shouldHave(attribute("value", "Selenium"));
        // En caso de no encontrar algún elemento de lo que busca salta error
    }

    /*@Test
    public void toolsMenu() {
        mainPage.toolsMenu.click();

        $("div[data-test='main-submenu']").shouldBe(visible);  // Busca que el main menú sea visible
    }

    @Test
    public void navigationToAllTools() {
        mainPage.seeAllToolsButton.click();

        $("#products-page").shouldBe(visible);  // Busca la página y ve si es visible

        assertEquals("All Developer Tools and Products by JetBrains", Selenide.title());
        // Mira que el título de la página sea el siguiente
    }*/
}
