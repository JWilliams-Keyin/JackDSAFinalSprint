package com.keyin.rest;

import com.keyin.bst.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TreeService {
    @Autowired
    private TreeRepository treeRepository;

    public Tree findByTreeNumbers(ArrayList<Integer> treeNumbers) {
        return treeRepository.findByTreeNumbers(treeNumbers);
    }

    public List<Tree> getAllTrees() {
        return (List<Tree>) treeRepository.findAll();
    }

    public Tree getTreeById(long id) {
        Optional<Tree> treeOptional = treeRepository.findById(id);

        return treeOptional.orElse(null);
    }

    public void deleteTreeById(long id) {
        treeRepository.deleteById(id);
    }

    public Tree createTree(Tree newTree) {
        return treeRepository.save(newTree);
    }

    public Tree updateTree(long id, Tree updatedTree) {
        Optional<Tree> treeToUpdateOptional = treeRepository.findById(id);

        if (treeToUpdateOptional.isPresent()) {
            Tree treeToUpdate = treeToUpdateOptional.get();

            if (updatedTree.getTreeNumbers() != null) {
                treeToUpdate.setTreeNumbers(updatedTree.getTreeNumbers());
            }

            if (updatedTree.getTreeJson() != null) {
                treeToUpdate.setTreeJson(updatedTree.getTreeJson());
            }

            return treeRepository.save(treeToUpdate);
        }

        return null;
    }
}
