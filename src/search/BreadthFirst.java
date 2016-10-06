package search;

import model.Node;

import static utility.Utility.*;

public class BreadthFirst {

    public static Node run(Node rootNode) {
        getQueue().add(rootNode);

        while (!getQueue().isEmpty()) {
            Node currentNode = getQueue().poll(); //grab next item on queue and remove
            incrementTimeCost();
            if (testGoalState(currentNode)) {
                return currentNode;
            }
            for (Node x : currentNode.getSuccessorStates()) { //only states in which have not been visited
                getQueue().add(x); //add to end of queue
            }
            updateMaxSpaceCost();
        }
        throw new Error(); //Search Failed
    }
}
