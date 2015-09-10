package com.test;

import es.usc.citius.hipster.algorithm.Algorithm;
import es.usc.citius.hipster.graph.GraphSearchProblem;
import es.usc.citius.hipster.graph.HipsterGraph;
import es.usc.citius.hipster.model.problem.SearchProblem;

import static es.usc.citius.hipster.algorithm.Hipster.createDijkstra;
import static es.usc.citius.hipster.graph.GraphBuilder.create;

/**
 * Created by Soren on 09/09/2015.
 */
public class ShortestPathAsDijkstra {
    private HipsterGraph graph;

    public void init() {
        graph = create()
                .connect("A").to("B").withEdge(7)
                .connect("A").to("C").withEdge(9)
                .connect("A").to("F").withEdge(14)
                .connect("B").to("C").withEdge(10)
                .connect("B").to("D").withEdge(15)
                .connect("C").to("D").withEdge(11)
                .connect("C").to("F").withEdge(2)
                .connect("D").to("E").withEdge(6)
                .connect("E").to("F").withEdge(9)
                .buildUndirectedGraph();
    }

    public Algorithm.SearchResult search(String from, String to){
        SearchProblem p = GraphSearchProblem
                .startingFrom(from)
                .in(graph)
                .takeCostsFromEdges()
                .build();

        Algorithm.SearchResult actual = createDijkstra(p).search(to);

        return actual;
    }
}
