package search;

import model.Node;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import static utility.Utility.*;

public class Astar3 {

    public static Node run(Node rootNode) {

        PriorityQueue<Node> myQ = new PriorityQueue<Node>(new Comparator<Node>() {

            public int compare(Node n1, Node n2) { //comparitors compares the heuristic cost for nodes
                if (evalFunc(n1) < evalFunc(n2)){
                    return -1;
                }else if (evalFunc(n1) > evalFunc(n2)){
                    return 1;
                }
                return 0;
            }
        });
        myQ.add(rootNode);

        while (!myQ.isEmpty()) {

            Node currentNode = myQ.poll(); //grab next item on queue and remove
            incrementTimeCost();
            if (testGoalState(currentNode)) {
                return currentNode;
            }
            if (currentNode.getDepth() <= getMaxDepth()) { //by default, will not go beyond a depth of 50
                for (Node x : currentNode.getSuccessorStates()) { //only states in which have not been visited
                    myQ.add(x); //add to end of queue
                }
            }
            updateMaxSpaceCost(myQ.size());
        }
        throw new Error(); //Search Failed
    }

    public static int evalFunc(Node n){
        return n.getRunningPathCost() + heuristic(n);
    } //combines path traveled and heuristic values

    public static int heuristic(Node n){ //computes manhatten distance - see below

        ArrayList<Integer> goal = getGoalState().getStateArrayListCopy(); //gets array of ints of goal state
        ArrayList<Integer> current = n.getState().getStateArrayListCopy();//gets array of ints of current state
        int heur = 0;
        int tmp = 0;
        boolean trig1 = false; //used below to modify the heuristic
        boolean trig2 = false; //used below to modify the heuristic

        //this heuristics is a modified version of the manhatten distance
        //every 2 moves that need to go across the board (i.e. swap), an extra pathcost is added equal to the piece being moved
        //the idea is that if 2 pieces need to be moved across the board, ithere will be extra moves as they cannot flow through one another

        for (int i = 0; i < goal.size(); i++){
            if (goal.indexOf(i) != current.indexOf(i)){ //compares the two to figure out if not in right position
                tmp = Math.abs(goal.indexOf(i) - current.indexOf(i)); //finds absolute value of grid position difference
            }
            switch (tmp) { // then looks up the grid position difference to determine how many moves are needed
                case 8: heur =+ 4; break;
                case 7: heur =+ 3; break;
                case 6: heur =+ 2;
                    if (trig1){ //if trig is reached twice, it adds additional co
                        heur += n.getPathCost();
                        trig1 = false;
                    }else {
                        trig1 = true;
                    }
                    break;
                case 5: heur =+ 3; break;
                case 4: heur =+ 2; break;
                case 3: heur =+ 1; break;
                case 2: heur =+ 2;
                if (trig2){
                    heur += n.getPathCost();
                    trig2 = false;
                }else {
                    trig2 = true;
                }
                break;
                case 1: heur =+ 1; break;
            }
        }
        return heur; //returns manhatten distance plus the w
    }
}
