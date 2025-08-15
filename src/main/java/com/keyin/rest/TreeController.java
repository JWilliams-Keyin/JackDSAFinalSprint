package com.keyin.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class TreeController {
    @Autowired
    private TreeService treeService;

    @GetMapping("/previous-trees")
    public List<Tree> getAllTrees() {
        return treeService.getAllTrees();
    }

    @GetMapping("/tree_search")
    public List<Tree> searchTrees(@RequestParam(value = "tree_numbers", required = false) String treeNumbers) {
        List<Tree> searchResults = new ArrayList<>();

        if (treeNumbers != null) {
            Tree treeFound = treeService.findByTreeNumbers(treeNumbers);

            searchResults.add(treeFound);
        }

        return searchResults;
    }

    @PostMapping("/process-numbers")
    public Tree createTree(@RequestBody List<Integer> treeNumbers) throws JsonProcessingException {
        return treeService.processNewTree(treeNumbers);
    }
}
