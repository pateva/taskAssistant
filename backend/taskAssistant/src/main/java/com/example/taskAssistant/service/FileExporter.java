package com.example.taskAssistant.service;

import com.example.taskAssistant.dto.TaskDto;
import com.example.taskAssistant.exceptions.ResourceNotFoundException;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

public class FileExporter {

    public static ResponseEntity<List<TaskDto>> exportTasksToFile(List<TaskDto> tasks) {
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream("Tasks.pdf"));
        } catch (DocumentException | FileNotFoundException e) {
            throw new ResourceNotFoundException("Resource is currently unavailable");
        }

        document.open();
        Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN, 16, BaseColor.BLACK);

        for (TaskDto task : tasks) {
            try {
                document.add(new Paragraph(task.toString(), font));
            } catch (DocumentException e) {
                e.printStackTrace();
            }
        }
        document.close();

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
