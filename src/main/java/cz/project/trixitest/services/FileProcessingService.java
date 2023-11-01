package cz.project.trixitest.services;

import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.io.FileOutputStream;

@Service
public class FileProcessingService {
    String zipFileName = "kopidlno.xml.zip";
    // Unzip file to XML
    public void unpackingArchive(){
        try(ZipInputStream zin = new ZipInputStream(new FileInputStream(zipFileName)))
        {
            ZipEntry entry;
            while((entry=zin.getNextEntry())!=null){
                String fileName = entry.getName();
                FileOutputStream fout = new FileOutputStream(fileName);

                byte[] buffer = new byte[1024];
                int len;
                while ((len = zin.read(buffer)) > 0) {
                    // Read data from the ZIP archive and write it to the file
                    fout.write(buffer, 0, len);
                }

                fout.flush();
                zin.closeEntry();
                fout.close();
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

}
