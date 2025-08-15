package com.keyin.rest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TreeServiceTest {
    @Mock
    TreeRepository treeRepository;
    @InjectMocks
    private TreeService treeService;

    private Tree testTree1 = new Tree();
    private Tree testTree2 = new Tree();

    @BeforeEach
    public void setUp() {
        /* Had to put an L at the end of id because for
        *  some reason findById wouldn't just take 1 */
        testTree1.setId(1L);
        testTree1.setTreeNumbers("[1,2,3]");
        /* The tree JSON is messy, but it was a response from the /previous-trees
        *  endpoint, so I want to make sure the test works by using the same style of JSON */
        testTree1.setTreeJson("""
        {\\"value\\":1,\\"left\\":null,\\"right\\":{\\"value\\":2,\\"left\\":null,\\"right\\":{\\"value\\":3,\\"left\\":null,\\"right\\":null}
        """);

        testTree2.setId(2L);
        testTree2.setTreeNumbers("[4,5,6]");
        testTree2.setTreeJson("""
        {\\"value\\":4,\\"left\\":null,\\"right\\":{\\"value\\":5,\\"left\\":null,\\"right\\":{\\"value\\":6,\\"left\\":null,\\"right\\":null}
        """);
    }

    @Test
    public void testGetAllTrees() {
        when(treeRepository.findAll()).thenReturn(List.of(testTree1, testTree2));

        List<Tree> searchResults = treeService.getAllTrees();

        assertEquals(2, searchResults.size());
        assertEquals(testTree1, searchResults.get(0));
        assertEquals(testTree2, searchResults.get(1));
    }

    @Test
    public void testFindByTreeNumbers() {
        when(treeRepository.findByTreeNumbers("[4,5,6]")).thenReturn(testTree2);

        Tree searchResult = treeService.findByTreeNumbers("[4,5,6]");

        assertNotNull(searchResult);
        assertEquals(testTree2, searchResult);
    }

    @Test
    public void testGetTreeById() {
        when(treeRepository.findById(1L)).thenReturn(Optional.of(testTree1));

        Tree searchResult = treeService.getTreeById(1);

        assertNotNull(searchResult);
        assertEquals(testTree1, searchResult);
    }
}
