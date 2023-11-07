package com.example.postgresql.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.postgresql.model.Tutorial;
import com.example.postgresql.repository.TutorialRepository;

public class TutorialControllerTest {

	@Mock
	TutorialRepository tutorialRepository;
	
	@InjectMocks
	TutorialController tutorialController;
	
    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(this); 
    }
	
	@Test
	public void getAllTutorialsWithNullStringTest() {
		List<Tutorial> tutorialsTest = Collections.singletonList(new Tutorial("title", "description", true));
		ResponseEntity<List<Tutorial>> responseEntityTest = new ResponseEntity<>(tutorialsTest, HttpStatus.OK);
		
		Mockito.when(tutorialRepository.findAll()).thenReturn(tutorialsTest);
        assertEquals(responseEntityTest, tutorialController.getAllTutorials(null));
	}
}
