package com.example.taskAssistant.service;

import com.example.taskAssistant.dto.TaskDto;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

public class FileExporter {

    public static ResponseEntity<List<TaskDto>> exportTasksToFile() {
       // exportTasksToFile();

        return new ResponseEntity<>(HttpStatus.OK);
    }

     private void exportToFile(List<TaskDto> tasks) throws FileNotFoundException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("iTextHelloWorld.pdf"));

        document.open();
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
        Chunk chunk = new Chunk("Hello World", font);

        document.add(chunk);
        document.close();
    }
}
