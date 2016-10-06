package search;

import model.Node;
import static utility.Utility.*;

public class DepthFirst {

    public static Node run(Node rootNode) {
        getQueue().add(rootNode);

        while (!getQueue().isEmpty()) {
            Node currentNode = getQueue().poll();//grab next item on queue and remove
            incrementTimeCost();
            if (testGoalState(currentNode)) {
                return currentNode;
            }
            if (currentNode.getDepth() <= getMaxDepth()){ //by default, will not go beyond a depth of 50
                for (Node x : currentNode.getSuccessorStates()) { //only states in which have not been visited
                    getQueue().addFirst(x); //add to begin of queue
                }
            }
            updateMaxSpaceCost();
        }
        throw new Error(); //Search Failed
    }
}
