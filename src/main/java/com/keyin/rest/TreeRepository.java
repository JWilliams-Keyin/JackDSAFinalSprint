package com.keyin.rest;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface TreeRepository extends CrudRepository<Tree, Long> {
    public Tree findByTreeNumbers(String treeNumbers);
}
