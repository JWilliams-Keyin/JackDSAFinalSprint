package com.keyin.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.keyin.bst.BinarySearchTree;
import com.keyin.bst.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("process-numbers")
    public Tree createTree(@RequestBody List<Integer> treeNumbers) throws JsonProcessingException {
        return treeService.processNewTree(treeNumbers);
    }
}
