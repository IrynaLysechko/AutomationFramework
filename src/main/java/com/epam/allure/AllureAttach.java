package com.epam.allure;

import com.epam.factory.DriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AllureAttach {

    @Attachment(value = "Failed test screenshot", type = "image/png")
    public static byte[] takeScreenshotToAttachOnAllureReport() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "logs", type = "text/plain", fileExtension = ".log")
    public static byte[] addFileToAllure(String path) throws IOException {
        File file = new File(path);
        return Files.readAllBytes(Paths.get(file.getPath()));
    }

}
