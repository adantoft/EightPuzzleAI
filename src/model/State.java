package model;

import java.util.ArrayList;

public class State {

    private int[] state;
    private int blankLocation;
    private String hashString;
    private Integer hashInt;

    public State(int[] arr){
        this.state = new int[9];
        StringBuilder sb = new StringBuilder(); //used to compute hash at obj build time

        for (int i = 0; i < 9; i++) { //used a single array to minimize space requirements
            state[i] = arr[i];
            if (arr[i] == 0) {
                blankLocation = i+1;
            }
            sb.append(arr[i]);
        }
        hashString = sb.toString(); //calculates hashes at obj creation since they will always be used
        hashInt = Integer.parseInt(hashString); //uses Int hash for faster computation (I'm guessing...)
    }
    public int getBlankLocation (){
        return blankLocation;
    }

    public int[] getStateArrayCopy(){ //creates copy of int array
        int[] arrCopy = new int[9];

        for (int i = 0; i < 9; i++) {
            arrCopy[i] = state[i];
        }
        return arrCopy;
    }
    public ArrayList<Integer> getStateArrayListCopy(){  //creates copy of int array in ArrayList form
        ArrayList<Integer> arrCopy = new ArrayList<Integer>();
        for (int i = 0; i < 9; i++) {
            arrCopy.add(state[i]);
        }
        return arrCopy;
    }

    public int[] getStateArray(){
        return state;
    }

    public State getCopy(){ //gets copy of state
        int[] newState = new int[9];

        for (int i = 0; i < 9; i++) {
            newState[i] = state[i];
        }
        return new State(newState);
    }

    @Override
    public int hashCode(){
        return hashInt;
    }
    @Override
    public String toString(){
        return hashString;
    }

}
