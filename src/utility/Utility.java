package utility;

import model.Node;
import model.State;
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class Utility {  //this is a class of static functions the other classes use

                //most of the functions are self explanatory based on their names

    private static HashSet<Integer> stateSpace = new HashSet();
    private static State goalState = getGoalState();
    private static ArrayList<Node> successPath = new ArrayList<Node>();
    private static LinkedBlockingDeque<Node> myQ = new LinkedBlockingDeque<Node>(); //this was used because items can be put on both ends
    private static int spaceCost;
    private static int timeCost;
    private static int moveCost;
    private static int maxDepth = 50; //by default, max depth is 50

    public static final State getGoalState(){
        int[] state = {1,2,3,8,0,4,7,6,5};
        return new State(state);
    }
    public static final Node getEasyStartNode(){
        int[] state = {1,3,4,8,6,2,7,0,5};
        return new Node(null, new State(state), null, 0, 0, 1);
    }
    public static final Node getMediumStartNode(){
        int[] state = {2,8,1,0,4,3,7,6,5};
        return new Node(null, new State(state), null, 0, 0, 1);
    }
    public static final Node getHardStartNode(){
        int[] state = {5,6,7,4,0,8,3,2,1};
        return new Node(null, new State(state), null, 0, 0, 1);
    }
    public static boolean testGoalState(Node node){
        return node.getState().hashCode() == goalState.hashCode();
    }
    public static HashSet<Integer> getStateSpace(){
        return stateSpace;
    }
    public static int getTotalSpaceCost(){
        return spaceCost;
    }
    public static void updateMaxSpaceCost(){
        spaceCost = Math.max(spaceCost,myQ.size());
    }
    public static void updateMaxSpaceCost(int n){
        spaceCost = Math.max(spaceCost,n);
    }
    public static int getTotalTimeCost(){
        return timeCost;
    }
    public static void incrementTimeCost(){
        timeCost++;
    }
    public static int getTotalMoveCost(){
        return moveCost;
    }
    public static int updateTotalMoveCost(int cost){
        moveCost += cost;
        return moveCost;
    }
    public static LinkedBlockingDeque<Node> getQueue(){
        return myQ;
    }
    public static int getMaxDepth(){
        return maxDepth;
    }
    public static void setMaxDepth(int n){
        maxDepth =n;
    }
    public static void resetSearchProblem(){
        stateSpace.clear();
        myQ.clear();
        successPath.clear();
        spaceCost = 0;
        timeCost = 0;
        moveCost = 0;
        maxDepth = 50;
    }


    //below is simple print out that is commented out as printPathGrid looks nicer!
//    public static void printPath(Node n){ //when given node n, the path from start to finish is calculated and printed out
//        int totalSteps = -1;
//        if (successPath.isEmpty()){
//            calcSuccessPath(n);
//        }
//        for (Node x : successPath){
//            totalSteps += 1;
//            moveCost += x.getPathCost();
//            System.out.println(x.getAction() + ", Move Cost = " + x.getPathCost() + ", Total Move Cost = " + moveCost + ", Total Steps (length) = " + totalSteps);
//            System.out.println(x.getState());
//        }
//        System.out.print("FINAL STATS: Total Steps (length) = " + totalSteps);
//        printStats();
//    }
    public static void printPathGrid(Node n){ //when given node n, the path from start to finish is calculated and printed out
        int totalSteps = -1;                  //this is a nicer output that prints a grid
        if (successPath.isEmpty()){
            calcSuccessPath(n);
        }
        for (Node x : successPath){
            totalSteps += 1;
            moveCost += x.getPathCost();
            System.out.println(x.getAction() + ", Move Cost = " + x.getPathCost() + ", Cumm. Move Cost = " + moveCost + ", Cumm. Steps (length) = " + totalSteps);
            StringBuilder sb = new StringBuilder();
            sb.append('|');
            int cnt =0;
            for (char ch : x.getState().toString().toCharArray()){

                if (ch == '0') ch = ' '; //replaces zero with blank
                if (cnt < 3){
                    sb.append(ch + "|");
                    cnt++;
                } else {
                    sb.append(" \n|" + ch + "|");
                    cnt = 1;
                }
            }
            System.out.println(sb);
        }
        System.out.println("------------ FINAL STATS ------------\nTotal Steps (length) = \t" + totalSteps);
        printStats();
    }


    public static void printStats(){
        System.out.println("Total Move Cost = \t\t" + moveCost);
        System.out.println("Total Time Cost = \t\t" + timeCost);
        System.out.println("Total Space Cost = \t\t" + spaceCost);
    }
    private static Node calcSuccessPath(Node n){  //recursive function to navigate from end state back up to start state
        successPath.add(0,n);
        if (n.getParent() == null){
            return n;
        } else {
            return calcSuccessPath(n.getParent());
        }
    }

    public enum Direction{ //enumeration for directions; string functionality makes printout look nice
        LEFT("Left"),
        RIGHT("Right"),
        DOWN("Down"),
        UP("Up");

        private String str;

        Direction(String name) {
            str = name;
        }

        @Override
        public String toString() {
            return str;
        }
    }

}
