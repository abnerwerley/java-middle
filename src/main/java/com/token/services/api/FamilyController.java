package com.token.services.api;

import com.token.services.dto.FamilyNames;
import com.token.services.service.FamilyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class FamilyController {

    private final FamilyService service;

    @GetMapping("/parent/father")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<String>> findAllFatherNames() {
        List<String> response = service.findAllFatherNames();
        return response.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(response);
    }

    @GetMapping("/parent/father/many-children")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<String>> findFathersWithMoreThanOneChild() {
        List<String> response = service.findFathersWithMoreThanOneChild();
        return response.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(response);
    }

    @GetMapping("/family/names")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<FamilyNames>> findFamilyNames() {
        List<FamilyNames> response = service.findFamilyNames();
        return response.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(response);
    }

    @GetMapping("/parent/father/John")
    @ResponseStatus(HttpStatus.OK)
    int countJohnsChildren() {
        return service.countJohnsChildren();
    }

    @GetMapping("/parent/mother/Mary")
    @ResponseStatus(HttpStatus.OK)
    int countMarysChildren() {
        return service.countMarysChildren();
    }
}
