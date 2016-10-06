package search;

import model.Node;

import java.util.Comparator;
import java.util.PriorityQueue;

import static utility.Utility.*;

public class Astar1 {

    public static Node run(Node rootNode) {

        PriorityQueue<Node> myQ = new PriorityQueue<Node>(new Comparator<Node>() {

            public int compare(Node n1, Node n2) {
                if (heuristic(n1) < heuristic(n2)){
                    return -1;
                }else if (heuristic(n1) > heuristic(n2)){ //comparitors compares the heuristic cost for nodes
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

    public static int evalFunc(Node n){ //combines path traveled and heuristic values
        return n.getRunningPathCost() + heuristic(n);
    }

    public static int heuristic(Node n){

        int [] goal = getGoalState().getStateArray(); //gets array of ints of goal state
        int [] current = n.getState().getStateArray(); //gets array of ints of current state
        int heur = 0;

        for (int i = 0; i < goal.length; i++){
            if (goal[i] - current[i] != 0){ //compares the two to figure out if not in right position
                heur ++;
            }
        }
        return heur;
    }
}
