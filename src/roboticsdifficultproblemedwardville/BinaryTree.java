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
    public int length = 0;
    public int y = 0;

    public BinaryTree(int numberofnodes, int numberofedges) { //number of edges refers to the number of connections a node can have
        tree = new int[numberofnodes][numberofedges][2];
    }

    public void setNode(int position, int value) {
        tree[position][0][0] = value;
    }

    public void setNode(int value) {
        tree[length][0][0] = value;
        length++;
    }
    public void setDistance(int position,int value){
        tree[position][0][1]=value;
    }
    public void setEdge(int nodea, int nodeb) {
        int a;
        for (a = 0; tree[nodea][a][0] != 0; a++) {
        }
        tree[nodea][a][0]=nodeb;
        tree[nodea][a][1]=1;
        for (a = 0; tree[nodeb][a][0] != 0; a++) {
        }
        tree[nodeb][a][0] = nodea;
        tree[nodeb][a][1]= 2;
    }
    //1 is true
    //2 is false
}
