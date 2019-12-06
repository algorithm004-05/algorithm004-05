import java.util.*;

class LeetCode_847_495 {

    public static void main(String[] args) {
        System.out.println(new LeetCode_847_495().robotSim(new int[] {4,-1,4,-2,4}, new int[][] {
          new int[] {2,4}
        }));
    }

    public int robotSim(int[] commands, int[][] obstacles) {
        Set<Cord> obscles = new HashSet<>();
        for (int i = 0; i < obstacles.length; i++) {
        	obscles.add(new Cord(obstacles[i][0], obstacles[i][1]));
        }
       	int orient = 0;
       	int[] position = {0, 0};
       	int max = 0;
       	for (int i = 0; i < commands.length; i++) {
       		if (commands[i] == -1 || commands[i] == -2) {
       			orient = turn(orient, commands[i]);
       		} else {
       			walk(position, orient, commands[i], obscles);
       		}
       		max = maxUD(position, max);
       	}
       	return max;
    }

    private static int maxUD(int[] position, int currMax) {
    	return Math.max(currMax, position[0] * position[0] + position[1] * position[1]);
    }

    private static void walk(int[] position, int orient, int steps, Set<Cord> obscles) {
    	while (steps > 0) {
	    	switch (orient) {
	    		case 0:
	    			if (!obscles.contains(new Cord(position[0], position[1] + 1))) {
	    				position[1] = position[1] + 1;
	    			} else {
	    				return;
	    			}
	    			break;
	    		case 1:
	    			if (!obscles.contains(new Cord(position[0] + 1, position[1]))) {
	    				position[0] = position[0] + 1;
	    			} else {
	    				return;
	    			}
	    			break;
	    		case 2:
	    			if (!obscles.contains(new Cord(position[0], position[1] - 1))) {
	    				position[1] = position[1] - 1;
	    			} else {
	    				return;
	    			}
	    			break;
	    		case 3:
	    			if (!obscles.contains(new Cord(position[0] - 1, position[1]))) {
	    				position[0] = position[0] - 1;
	    			} else {
	    				return;
	    			}
	    			break;
	    	}
	    	steps = steps - 1;
    	}
    }

    private static int turn(int raw, int direction) {
    	if (direction == -1) {
    		raw = raw + 1;
    	} else if (direction == -2) {
    		raw = raw - 1;
    	}
    	if (raw >= 4) {
    		raw = 0;
    	} else if (raw < 0) {
    		raw = 3;
    	}
    	return raw;
    }

    private static class Cord {
    	public int x;
    	public int y;

    	Cord(int X, int Y) {
    		x = X;
    		y = Y;
    	}

    	@Override
    	public int hashCode() {
    		int hash = 17;
    		hash = hash * 31 + x;
    		hash = hash * 31 + y;
    		return hash;
    	}

    	@Override
    	public boolean equals(Object o) {
    		if (this == o) {
    			return true;
    		}
    		return this.x == ((Cord) o).x && this.y == ((Cord) o).y;
    	}
    }
}
