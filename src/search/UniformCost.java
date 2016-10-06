package search;

import model.Node;

import java.util.Comparator;
import java.util.PriorityQueue;

import static utility.Utility.*;

public class UniformCost {

    public static Node run(Node rootNode) {

        PriorityQueue<Node> myQ = new PriorityQueue<Node>(new Comparator<Node>() {

            public int compare(Node n1, Node n2) {
                if (n1.getRunningPathCost()  < n2.getRunningPathCost()){ //comparitors compares the cost traversed for nodes
                    return -1;
                }else if (n1.getRunningPathCost() > n2.getRunningPathCost()){
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


}
