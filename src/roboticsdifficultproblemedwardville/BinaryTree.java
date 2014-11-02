package roboticsdifficultproblemedwardville;

public class BinaryTree {

    private int tree[][][];
    private int values[];
    private int numEdges[];
    private int distances[][];
    private int distancecounter[];
    public int length;
    public int y = 0;

    //number of edges refers to the number of connections a node can have
    public BinaryTree(int numberofnodes, int numberofedges) {
        length = numberofnodes;
        tree = new int[numberofnodes][numberofedges * 2][2];
        numEdges = new int[numberofnodes];
    }

    public BinaryTree(int numberofnodes, int numberofedges, int maxvalue, int maxdistance) {
        length = numberofnodes;
        tree = new int[numberofnodes][numberofedges * 2][2];
        values = new int[maxvalue];
        distances = new int[maxdistance][numberofedges];
        distancecounter = new int[maxdistance];
        numEdges = new int[numberofnodes];
    }

    public void setValue(int position, int value) {
        tree[position][0][0] = value;
    }

    public int numberOfNodes() {
        return tree.length;
    }

    public int getValue(int position) {
        return tree[position][0][0];
    }

    //Edge num should be from 0 to the number of nodes - 1
    public int findEdgeConnection(int position, int edgenum) {
        return tree[position][edgenum ][0];
    }

    public int findEdgeValue(int position, int edgenum) {
        if (tree[position][edgenum][1] < 0) {
            return -tree[position][edgenum][1];
        } else {
            return tree[position][edgenum][1];
        }
    }

    public boolean edgeDirection(int position, int edgenum) {
        if (tree[position][edgenum][1] < 0) {
            return false;
        } else {
            return true;
        }
    }
//    public int getDistance(int position) {
//        return tree[position][0][1];
//    }
//    public int findPosition(int value) {
//        for (int x = 0; x < tree.length; x++) {
//            if (tree[x][0][0] == value) {
//                return x;
//            }
//        }
//        return -1;
//    }
//    public int findPosition(int distance) {
//        if (distances[distance][0] != 0) {
//            return distances[distance][0];
//        }
//        for (int x = 0; x < tree.length; x++) {
//            if (tree[x][0][1] == distance) {
//                return x;
//            }
//        }
//        return -1;
//    }
// Note: The "position" of each node will be equivalent to the "distance"
// it is from the intial stop
//    public void setNode(int value) {
//        tree[length][0][0] = value;
//        values[length] = value;
//        length++;
//    }

    public boolean setEdge(int nodea, int nodeb, int cost) {
        int a;
        for (a = 0; tree[nodea][a][0] != 0; a++) {
        }
        tree[nodea][a][0] = nodeb; //0 is which other node it is connected to
        tree[nodea][a][1] = cost;  //1 is the cost of the train to get to the other node
        numEdges[nodea] = a+1;
//        for (a = 0; tree[nodeb][a][0] != 0; a++) {
//        }
//        tree[nodeb][a][0] = nodea;
//        tree[nodeb][a][1] = -cost;
//        numEdges[nodeb] = a+1;
        return true;
    }

    public int findnumEdges(int node) {
        return numEdges[node];
    }
    //positive is true
    //negative is false
}
