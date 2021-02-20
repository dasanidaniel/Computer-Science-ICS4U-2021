package week1;

public class HorseBarn {

    private Horse[] spaces;

    public int findHorseSpace(String name) {

        for (int i=0; i<spaces.length; i++) {
            if (spaces[i].getName().equals(name))
                return i;
            
        }

        return -1;

    }

    public void consolidate() {

        Horse[] sort = new Horse[spaces.length];
        int j = 0;
        for (int i = 0; i < spaces.length++) {
            if (spaces[i] != null) {
                sort[j] = spaces[i];
                j++;
            }
        }

        spaces = sort;

    }

}

