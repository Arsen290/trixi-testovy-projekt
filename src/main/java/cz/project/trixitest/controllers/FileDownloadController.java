package cz.project.trixitest.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;


import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

@Controller
public class FileDownloadController {
    final String downloadUrl = "https://www.smartform.cz/download/kopidlno.xml.zip";
    // Creat func to download zip file from certain URL
    @GetMapping()
    // Sets the HTTP response status code to 204 (No Content)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void downloadFile() throws IOException{
        try (BufferedInputStream in = new BufferedInputStream(new URL(downloadUrl).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream("kopidlno.xml.zip")) {
            byte dataBuffer[] = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
        }
    }
}
