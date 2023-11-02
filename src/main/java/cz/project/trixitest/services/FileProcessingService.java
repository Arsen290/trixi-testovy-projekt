package cz.project.trixitest.services;

import cz.project.trixitest.models.CastObce;
import cz.project.trixitest.models.Obec;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.stereotype.Service;

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

    public void unparsingXMLFile() throws IOException {
        Path root = Paths.get(""); // Оставляем пустую строку для использования текущей директории проекта
        //Search .xml files in directory
        Files.walk(root)
                .filter(Files::isRegularFile)
                .filter(path -> path.getFileName().toString().endsWith(".xml"))
                .forEach(xmlFile -> {
                    try {
                        // Using DOM to parse xml
                        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                        DocumentBuilder builder = factory.newDocumentBuilder();
                        Document document = builder.parse(xmlFile.toFile());

                        // Parsing data for Obec
                        NodeList obecElements = document.getElementsByTagName("vf:Obec");
                        for (int i = 0; i < obecElements.getLength(); i++) {
                            Element obecElement = (Element) obecElements.item(i);

                            String codeStr = obecElement.getElementsByTagName("obi:Kod").item(0).getTextContent().trim();
                            int code = 0;
                            codeStr = codeStr.replaceAll("[^0-9]", "");
                            try {
                                code = Integer.parseInt(codeStr);
                            } catch (NumberFormatException e) {

                            }

                            String name = obecElement.getElementsByTagName("obi:Nazev").item(0).getTextContent();

                            Obec obec = new Obec(code, name);
                        }
                        // Parsing data for CastObec
                        NodeList castObceElements = document.getElementsByTagName("vf:CastObce");
                        for (int i = 0; i < castObceElements.getLength(); i++) {
                            Element castObceElement = (Element) castObceElements.item(i);

                            String codeStr = castObceElement.getElementsByTagName("coi:Kod").item(0).getTextContent().trim();
                            int code = 0;
                            codeStr = codeStr.replaceAll("[^0-9]", "");
                            try {
                                code = Integer.parseInt(codeStr);
                            } catch (NumberFormatException e) {

                            }

                            String name = castObceElement.getElementsByTagName("coi:Nazev").item(0).getTextContent();

                            String obecCodeStr = castObceElement.getElementsByTagName("coi:Obec")
                                    .item(0).getTextContent();
                            int obecCode = 0;
                            obecCodeStr = obecCodeStr.replaceAll("[^0-9]", "");
                            try {
                                obecCode = Integer.parseInt(obecCodeStr);
                            } catch (NumberFormatException e) {

                            }

                            CastObce castObce = new CastObce(code, name, obecCode);

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });



    }

}
