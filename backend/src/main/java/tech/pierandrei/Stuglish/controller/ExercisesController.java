package tech.pierandrei.Stuglish.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tech.pierandrei.Stuglish.dto.*;
import tech.pierandrei.Stuglish.service.ExercisesService;
import java.io.IOException;

@RestController
@RequestMapping("/api/exercises")
public class ExercisesController {
    private final ExercisesService exercisesService;

    public ExercisesController(ExercisesService exercisesService) {
        this.exercisesService = exercisesService;
    }

    @PostMapping("/vocabulary/generate")
    public ResponseEntity<VocabularyResponseDTO> generateVocabulary(@RequestBody RequestDto request) throws IOException {
        return ResponseEntity.ok(exercisesService.generateWords(request));
    }

    @PostMapping("/sentence/generate")
    public ResponseEntity<?> generateSentence(@RequestBody SentenceCompletionDTO request) throws IOException {
        return ResponseEntity.ok(exercisesService.generateSentences(request));
    }





}