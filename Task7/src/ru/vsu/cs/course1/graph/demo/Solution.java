package ru.vsu.cs.course1.graph.demo;

import ru.vsu.cs.course1.graph.Graph;
import ru.vsu.cs.course1.graph.GraphAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.IntPredicate;

public class Solution {

    public static boolean solution(Graph graph, int start) {
        return GraphAlgorithms.dfsRecursionConnection(graph, start, new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
            }
        });
    }

}