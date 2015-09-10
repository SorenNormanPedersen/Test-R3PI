package com.test;

import es.usc.citius.hipster.algorithm.Algorithm;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Soren on 09/09/2015.
 */
public class ShortestPathAsDijkstraTest {

    @Test
    public void verifyShortestPathSearchWithASingleHop() throws Exception {
        // Given
        ShortestPathAsDijkstra shortestPath = new ShortestPathAsDijkstra();
        shortestPath.init();
        // When
        Algorithm.SearchResult actual = shortestPath.search("B", "C");
        // Then
        List<String> expected = new ArrayList<>();
        expected.add("B");
        expected.add("C");
        assertThat(actual.getOptimalPaths().get(0), is(expected));
    }

    @Test
    public void verifyShortestPathSearchWithMultipleHops() throws Exception {
        // Given
        ShortestPathAsDijkstra shortestPath = new ShortestPathAsDijkstra();
        shortestPath.init();
        // When
        Algorithm.SearchResult actual = shortestPath.search("A", "E");
        // Then
        List<String> expected = new ArrayList<>();
        expected.add("A");
        expected.add("C");
        expected.add("F");
        expected.add("E");
        assertThat(actual.getOptimalPaths().get(0), is(expected));
    }
}