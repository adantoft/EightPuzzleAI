package main;

import search.*;
import utility.Utility;

public class main {

    public static void main(String[] args) {
        System.out.println("------ STARTING BrFS EASY MODE ------");
        Utility.printPathGrid(BreadthFirst.run(Utility.getEasyStartNode()));
        Utility.resetSearchProblem();
        System.out.println("------ STARTING BrFS MEDIUM MODE ------");
        Utility.printPathGrid(BreadthFirst.run(Utility.getMediumStartNode()));
        Utility.resetSearchProblem();
        System.out.println("------ STARTING BrFS HARD MODE ------");
        Utility.printPathGrid(BreadthFirst.run(Utility.getHardStartNode()));
        Utility.resetSearchProblem();

        System.out.println("------ STARTING DFS EASY MODE ------");
        Utility.printPathGrid(DepthFirst.run(Utility.getEasyStartNode()));
        Utility.resetSearchProblem();
        System.out.println("------ STARTING DFS MEDIUM MODE ------");
        Utility.printPathGrid(DepthFirst.run(Utility.getMediumStartNode()));
        Utility.resetSearchProblem();
        System.out.println("------ STARTING DFS HARD MODE ------");
        Utility.printPathGrid(DepthFirst.run(Utility.getHardStartNode()));
        Utility.resetSearchProblem();

        System.out.println("------ STARTING IDFS EASY MODE ------");
        Utility.printPathGrid(IterativeDepthFirst.run(Utility.getEasyStartNode()));
        Utility.resetSearchProblem();
        System.out.println("------ STARTING IDFS MEDIUM MODE ------");
        Utility.printPathGrid(IterativeDepthFirst.run(Utility.getMediumStartNode()));
        Utility.resetSearchProblem();
        System.out.println("------ STARTING IDFS HARD MODE ------");
        Utility.printPathGrid(IterativeDepthFirst.run(Utility.getHardStartNode()));
        Utility.resetSearchProblem();

        System.out.println("------ STARTING UCS EASY MODE ------");
        Utility.printPathGrid(UniformCost.run(Utility.getEasyStartNode()));
        Utility.resetSearchProblem();
        System.out.println("------ STARTING UCS MEDIUM MODE ------");
        Utility.printPathGrid(UniformCost.run(Utility.getMediumStartNode()));
        Utility.resetSearchProblem();
        System.out.println("------ STARTING UCS HARD MODE ------");
        Utility.printPathGrid(UniformCost.run(Utility.getHardStartNode()));
        Utility.resetSearchProblem();

        System.out.println("------ STARTING BeFS EASY MODE ------");
        Utility.printPathGrid(BestFirst.run(Utility.getEasyStartNode()));
        Utility.resetSearchProblem();
        System.out.println("------ STARTING BeFS MEDIUM MODE ------");
        Utility.printPathGrid(BestFirst.run(Utility.getMediumStartNode()));
        Utility.resetSearchProblem();
        System.out.println("------ STARTING BeFS HARD MODE ------");
        Utility.printPathGrid(BestFirst.run(Utility.getHardStartNode()));
        Utility.resetSearchProblem();

        System.out.println("------ STARTING A*1 EASY MODE ------");
        Utility.printPathGrid(Astar1.run(Utility.getEasyStartNode()));
        Utility.resetSearchProblem();
        System.out.println("------ STARTING A*1 MEDIUM MODE ------");
        Utility.printPathGrid(Astar1.run(Utility.getMediumStartNode()));
        Utility.resetSearchProblem();
        System.out.println("------ STARTING A*1 HARD MODE ------");
        Utility.printPathGrid(Astar1.run(Utility.getHardStartNode()));
        Utility.resetSearchProblem();

        System.out.println("------ STARTING A*2 EASY MODE ------");
        Utility.printPathGrid(Astar2.run(Utility.getEasyStartNode()));
        Utility.resetSearchProblem();
        System.out.println("------ STARTING A*2 MEDIUM MODE ------");
        Utility.printPathGrid(Astar2.run(Utility.getMediumStartNode()));
        Utility.resetSearchProblem();
        System.out.println("------ STARTING A*2 HARD MODE ------");
        Utility.printPathGrid(Astar2.run(Utility.getHardStartNode()));
        Utility.resetSearchProblem();

        System.out.println("------ STARTING A*3 EASY MODE ------");
        Utility.printPathGrid(Astar3.run(Utility.getEasyStartNode()));
        Utility.resetSearchProblem();
        System.out.println("------ STARTING A*3 MEDIUM MODE ------");
        Utility.printPathGrid(Astar3.run(Utility.getMediumStartNode()));
        Utility.resetSearchProblem();
        System.out.println("------ STARTING A*3 HARD MODE ------");
        Utility.printPathGrid(Astar3.run(Utility.getHardStartNode()));
        Utility.resetSearchProblem();
    }
}
