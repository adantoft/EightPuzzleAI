package model;

import utility.Utility;
import java.util.ArrayList;
import java.util.Comparator;

import static utility.Utility.getStateSpace;

public class Node implements Comparator<Node> {

    private State state;
    private Node parentNode;
    private Node childNodeLeft;
    private Node childNodeRight;
    private Node childNodeUp;
    private Node childNodeDown; //think of children in relation to the blank space on the board
    private Integer pathCost;
    private Integer runningPathCost;
    private Integer depth;
    private Utility.Direction action;
    private boolean expanded; //TODO find use for this...

    public Node(Node parentNode, State state, Utility.Direction action, Integer pathCost, Integer runningPathCost, Integer depth){
        this.parentNode = parentNode;
        this.state = state;
        this.action = action;
        this.pathCost = pathCost;
        this.runningPathCost = runningPathCost;
        this.depth = depth;

    }
    public State getState(){
        return state;
    }
    public Utility.Direction getAction(){
        return action;
    }
    public Integer getPathCost(){
        return pathCost;
    }
    public Integer getRunningPathCost(){
        return runningPathCost;
    }
    public Node getParent(){
        return parentNode;
    }
    public Integer getDepth(){
        return depth;
    }
    public ArrayList<Node> getSuccessorStates(){ //returns list of successor states (children of this node); excludes already visited states
        makeChildren();

        ArrayList<Node> successorStates = new ArrayList<Node>();

        if (childNodeLeft != null && !getStateSpace().contains(childNodeLeft.getState().hashCode())){
            getStateSpace().add(childNodeLeft.getState().hashCode());
            successorStates.add(childNodeLeft);
        }
        if (childNodeRight != null && !getStateSpace().contains(childNodeRight.getState().hashCode())){
            getStateSpace().add(childNodeRight.getState().hashCode());
            successorStates.add(childNodeRight);
        }
        if (childNodeUp != null && !getStateSpace().contains(childNodeUp.getState().hashCode())){
            getStateSpace().add(childNodeUp.getState().hashCode());
            successorStates.add(childNodeUp);
        }
        if (childNodeDown != null && !getStateSpace().contains(childNodeDown.getState().hashCode())){
            getStateSpace().add(childNodeDown.getState().hashCode());
            successorStates.add(childNodeDown);
        }
        return successorStates;
    }

    private void makeChildren(){ //makes children (all possible moves) from current state (blank space)
        //this function finds the next states based on current state and direction to move the blank piece
        //illegal moves cause yield null child nodes

        int blankSpot = state.getBlankLocation();

        //MOVE BLANK LEFT
        if (blankSpot == 1 || blankSpot == 4 || blankSpot == 7) {   //illegal moves
            childNodeLeft = null;
        } else {
            int[] newArr = state.getStateArrayCopy();
            int tmp = newArr[blankSpot - 2];                //grab number to left also path cost
            newArr[blankSpot - 2] = newArr[blankSpot - 1];  //make number to left set to blank spot
            newArr[blankSpot - 1] = tmp;                    //make blank spot set to number to left
            childNodeLeft = new Node(this, new State(newArr), Utility.Direction.LEFT, tmp, this.pathCost + tmp, depth + 1);
        }
        //MOVE BLANK RIGHT
        if (blankSpot == 3 || blankSpot == 6 || blankSpot == 9) {   //illegal moves
            childNodeRight = null;
        } else {
            int[] newArr = state.getStateArrayCopy();
            int tmp = newArr[blankSpot];                //grab number to right also path cost
            newArr[blankSpot] = newArr[blankSpot-1];    //make number to right set to blank spot
            newArr[blankSpot-1] = tmp;                  //make blank spot set to number to right
            childNodeRight = new Node(this, new State(newArr), Utility.Direction.RIGHT, tmp, this.pathCost + tmp, depth + 1);
        }
        //MOVE BLANK UP
        if (blankSpot == 1 || blankSpot == 2 || blankSpot == 3) {   //illegal moves
            childNodeUp = null;
        } else {
            int[] newArr = state.getStateArrayCopy();
            int tmp = newArr[blankSpot-4];                //grab number above also path cost
            newArr[blankSpot-4] = newArr[blankSpot-1];    //make number above set to blank spot
            newArr[blankSpot-1] = tmp;                    //make blank spot set to number above
            childNodeUp = new Node(this, new State(newArr), Utility.Direction.UP, tmp, this.pathCost + tmp, depth + 1);
        }
        //MOVE BLANK DOWN
        if (blankSpot == 7 || blankSpot == 8 || blankSpot == 9) {   //illegal moves
            childNodeDown = null;
        } else {
            int[] newArr = state.getStateArrayCopy();
            int tmp = newArr[blankSpot+2];                //grab number below also path cost
            newArr[blankSpot+2] = newArr[blankSpot-1];    //make number below set to blank spot
            newArr[blankSpot-1] = tmp;                    //make blank spot set to number below
            childNodeDown = new Node(this, new State(newArr), Utility.Direction.DOWN, tmp, this.pathCost + tmp, depth + 1);
        }
        expanded = true;
    }
    @Override
    public String toString(){
        return "State: " + state + " Action: " + action.toString() + " Cost: " + pathCost;
    }

    @Override
    public int compare(Node n1, Node n2){
        if (n1.runningPathCost < n2.runningPathCost){
            return -1;
        }else if (n1.runningPathCost > n2.runningPathCost){
            return 1;
        }
        return 0;
    }
}
