package com.hamzadev.uploadreadcsv.service;

import com.hamzadev.uploadreadcsv.helper.CSVHelper;
import com.hamzadev.uploadreadcsv.model.Tutorial;
import com.hamzadev.uploadreadcsv.repository.TutorialRepository;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class CSVService {
    @Autowired
    TutorialRepository tutorialRepository;

    public ByteArrayInputStream load() {
        List<Tutorial> tutorials = tutorialRepository.findAll();

        ByteArrayInputStream in = CSVHelper.tutorialsToCSV(tutorials);
        return in;
    }

    public void save(MultipartFile file) {
        try {
            List<Tutorial> tutorials = CSVHelper.csvToTutorials(file.getInputStream());
            tutorialRepository.saveAll(tutorials);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    public List<Tutorial> getAllTutorials() {
        return tutorialRepository.findAll();
    }

//    public void writeTextFile() throws IOException {
//
//        String string = "Today is a gloomy day.";
//        File myFile = new File("src/main/resources/myFile.txt");
//
//        FileUtils.writeStringToFile(myFile,string, StandardCharsets.UTF_8.name());
//    }

//    public void readTextFile() throws IOException {
//        File myFile = new File("src/main/resources/myFile.txt");
//
//        String contents = FileUtils.readFileToString(myFile,
//                StandardCharsets.UTF_8.name());
//
//        System.out.println(contents);
//    }
}