package com.herokuapp.theinternet.uploadtests;

import com.herokuapp.theinternet.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.pages.FileUploaderPage;

import java.io.File;

public class UploadTests extends BaseTest {

    @DataProvider(name="data")
    public Object [][] dataProviderMethod () {
        return new Object [] [] {{"2", "src/test/resources/documents/somefile.txt", "somefile.txt"}};
    }

    @Test(dataProvider = "data")
    public void fileUploadTest(String no, String filePath, String fileName) {
        log.info("Starting fileUploadTest #" + no + " for " + filePath);

        // open File Uploader Page
        FileUploaderPage fileUploaderPage = new FileUploaderPage(driver, log);
        fileUploaderPage.openPage();

        // Select file
        File file = new File(filePath);
        fileUploaderPage.selectFile(file.getAbsolutePath());

        // Push upload button
        fileUploaderPage.pushUploadButton();

        // Get uploaded files
        String fileNames = fileUploaderPage.getUploadedFilesNames();

        // Verify selected file uploaded
        Assert.assertTrue(fileNames.contains(fileName),
                "Our file (" + fileName + ") is not one of the uploaded (" + fileNames + ")");
    }
}
