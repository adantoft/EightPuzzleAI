package search;

import model.Node;

import static utility.Utility.*;

public class IterativeDepthFirst {

    public static Node run(Node rootNode) {
        getQueue().add(rootNode);
        for (int i = 1; i <= getMaxDepth(); i++){
            while (!getQueue().isEmpty()) {
                Node currentNode = getQueue().poll();//grab next item on queue and remove
                incrementTimeCost();
//                System.out.println(getTotalTimeCost());
                if (testGoalState(currentNode)) {
                    return currentNode;
                }
                    if (currentNode.getDepth() == i){// do nothing if successor nodes are equal to the current iterative depth
                    }else{
                        for (Node x : currentNode.getSuccessorStates()) { //only states in which have not been visited
                            getQueue().addFirst(x); //add to begin of queue
                        }
                    }
                updateMaxSpaceCost();
            }
            getQueue().clear(); // resets the queue for next iteration
            getStateSpace().clear(); //resets visited nodes for next iteration
            getQueue().add(rootNode); //re-adds root node
        }

        throw new Error(); //Search Failed
    }
}
