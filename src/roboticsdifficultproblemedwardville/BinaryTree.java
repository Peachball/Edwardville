/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roboticsdifficultproblemedwardville;

/**
 *
 * @author chen
 */
public class BinaryTree {

    private int tree[][][];
    private int values[];
    private int distances[][];
    private int distancecounter[];
    public int length = 0;
    public int y = 0;

    //number of edges refers to the number of connections a node can have
    public BinaryTree(int numberofnodes, int numberofedges) {
        length = 0;
        tree = new int[numberofnodes][numberofedges][2];
    }

    public BinaryTree(int numberofnodes, int numberofedges, int maxvalue, int maxdistance) {
        length = 0;
        tree = new int[numberofnodes][numberofedges][2];
        values = new int[maxvalue];
        distances = new int[maxdistance][numberofedges];
        distancecounter = new int[maxdistance];
    }

    public BinaryTree(int numberofnodes, int numberofedges, int maxdistance) {
        length = 0;
        tree = new int[numberofnodes][numberofedges][2];
        distances = new int[maxdistance][numberofnodes];
        distancecounter = new int[maxdistance];
    }

    public void setValue(int position, int value) {
        tree[position][0][0] = value;
    }

    public int getValue(int position) {
        return tree[position][0][0];
    }

    public int getDistance(int position) {
        return tree[position][0][1];
    }

//    public int findPosition(int value) {
//        for (int x = 0; x < tree.length; x++) {
//            if (tree[x][0][0] == value) {
//                return x;
//            }
//        }
//        return -1;
//    }
    public int findPosition(int distance) {
        if (distances[distance][0] != 0) {
            return distances[distance][0];
        }
        for (int x = 0; x < tree.length; x++) {
            if (tree[x][0][1] == distance) {
                return x;
            }
        }
        return -1;
    }

    public void setNode(int value) {
        tree[length][0][0] = value;
        values[length] = value;
        length++;
    }

    public void setDistance(int position, int value) {
        tree[position][0][1] = value;
        distances[value][distancecounter[position]] = position;
        distancecounter[position]++;
    }

    public void setEdge(int nodea, int nodeb, int cost) {
        int a;
        for (a = 0; tree[nodea][a][0] != 0; a++) {
        }
        tree[nodea][a][0] = nodeb;
        tree[nodea][a][1] = cost;
        for (a = 0; tree[nodeb][a][0] != 0; a++) {
        }
        tree[nodeb][a][0] = nodea;
        tree[nodeb][a][1] = -cost;
    }
    //positive is true
    //negative is false
}
