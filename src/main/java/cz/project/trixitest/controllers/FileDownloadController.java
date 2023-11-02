package cz.project.trixitest.controllers;


import cz.project.trixitest.services.FileProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private FileProcessingService fileProcessingService;

    final String downloadUrl = "https://www.smartform.cz/download/kopidlno.xml.zip";

    @GetMapping("/download") // Обратите внимание на URL-путь "/download"
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void downloadFile() throws IOException {
        try {
            URL url = new URL(downloadUrl);
            try (BufferedInputStream in = new BufferedInputStream(url.openStream());
                 FileOutputStream fileOutputStream = new FileOutputStream("kopidlno.xml.zip")) {
                byte dataBuffer[] = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                    fileOutputStream.write(dataBuffer, 0, bytesRead);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    // Unzip
    fileProcessingService.unpackingArchive();
    fileProcessingService.unparsingXMLFile();
    }
}
