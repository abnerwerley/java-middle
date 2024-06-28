package com.token.services.service;

import com.token.services.dto.FamilyNames;
import com.token.services.repository.ParentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FamilyService {

    private final ParentRepository parentRepository;

    public List<String> findAllFatherNames() {
        return parentRepository.findAllFatherNames();
    }

    public List<String> findFathersWithMoreThanOneChild() {
        return parentRepository.findFathersWithMoreThanOneChild();
    }

    public List<FamilyNames> findFamilyNames() {
        return parentRepository.findFamilyNames();
    }

    public int countJohnsChildren() {
        return parentRepository.countJohnsChildren();
    }

    public int countMarysChildren() {
        return parentRepository.countMarysChildren();
    }

}
