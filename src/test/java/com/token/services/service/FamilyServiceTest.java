package com.token.services.service;

import com.token.services.dto.FamilyNames;
import com.token.services.repository.ParentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FamilyServiceTest {

    @InjectMocks
    private FamilyService service;

    @Mock
    private ParentRepository parentRepository;

    @BeforeEach
    void setup() {
        this.service = new FamilyService(parentRepository);
    }

    @Test
    void shouldFindAllFatherNames() {
        List<String> names = List.of("John", "Andrew", "Daniel");
        when(parentRepository.findAllFatherNames()).thenReturn(names);
        List<String> response = service.findAllFatherNames();
        assertEquals(names.size(), response.size());
        assertEquals(names, response);

        when(parentRepository.findAllFatherNames()).thenReturn(List.of());
        List<String> emptyResponse = service.findAllFatherNames();
        assertEquals(0, emptyResponse.size());
    }

    @Test
    void shouldFindFathersWithMoreThanOneChild() {
        List<String> names = List.of("John", "Andrew", "Daniel");
        when(parentRepository.findFathersWithMoreThanOneChild()).thenReturn(names);
        List<String> response = service.findFathersWithMoreThanOneChild();
        assertEquals(names.size(), response.size());
        assertEquals(names, response);

        when(parentRepository.findFathersWithMoreThanOneChild()).thenReturn(List.of());
        List<String> emptyResponse = service.findFathersWithMoreThanOneChild();
        assertEquals(0, emptyResponse.size());
    }

    @Test
    void shouldFindFamilyNames() {
        FamilyNames family1 = new FamilyNames("John", "Mark", "July");
        FamilyNames family2 = new FamilyNames("Claire", null, "Jude");
        FamilyNames family3 = new FamilyNames("Kennedy", null, null);
        List<FamilyNames> families = List.of(family1, family2, family3);
        when(parentRepository.findFamilyNames()).thenReturn(families);
        List<FamilyNames> response = service.findFamilyNames();
        assertEquals(families.size(), response.size());
        assertEquals(families, response);

        when(parentRepository.findFamilyNames()).thenReturn(List.of());
        List<FamilyNames> emptyResponse = service.findFamilyNames();
        assertEquals(0, emptyResponse.size());
    }

    @Test
    void shouldCountJohnsChildren() {
        when(parentRepository.countJohnsChildren()).thenReturn(1);
        int response = service.countJohnsChildren();
        assertEquals(1, response);
    }

    @Test
    void shouldCountMarysChildren() {
        when(parentRepository.countMarysChildren()).thenReturn(2);
        int response = service.countMarysChildren();
        assertEquals(2, response);
    }

}
