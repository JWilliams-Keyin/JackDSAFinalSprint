package com.keyin.rest;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
public class Tree {
    @Id
    @SequenceGenerator(name = "tree_sequence", sequenceName = "tree_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "tree_sequence")
    private long id;

    private ArrayList<Integer> treeNumbers;
    private String treeJson;

    public long getId() {
        return id;
    }

    public ArrayList<Integer> getTreeNumbers() {
        return treeNumbers;
    }

    public String getTreeJson() {
        return treeJson;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTreeNumbers(ArrayList<Integer> treeNumbers) {
        this.treeNumbers = treeNumbers;
    }

    public void setTreeJson(String treeJson) {
        this.treeJson = treeJson;
    }
}
