plugins {
    id("java")
    id("io.qameta.allure") version "2.11.2"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val allureVersion = "2.25.0"
val junitVersion = "5.10.2"

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    //JUnit 5 (Jupiter): Основной фреймворк для написания тестов.
    testImplementation("org.junit.jupiter:junit-jupiter:$junitVersion")
    // Selenide (включает Selenium WebDriver и менеджер драйверов)
    testImplementation("com.codeborne:selenide:7.18.2")
    testImplementation("com.codeborne:selenide-selenium:7.18.2")
    //Allure JUnit 5: Интеграция Allure-отчетов с JUnit 5.
    testImplementation("io.qameta.allure:allure-junit5:$allureVersion")
}

//Связываем плагин Allure с версией зависимостей
allure {
version.set(allureVersion)
}

tasks.test {
    useJUnitPlatform()
}