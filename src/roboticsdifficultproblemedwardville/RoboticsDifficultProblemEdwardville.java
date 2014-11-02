package roboticsdifficultproblemedwardville;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class RoboticsDifficultProblemEdwardville {

    public static void main(String[] args) throws FileNotFoundException {
        RoboticsDifficultProblemEdwardville recursion = new RoboticsDifficultProblemEdwardville();
        int trains[][] = input();
        BinaryTree trainfile = binarytree(trains);
        System.out.println(treeSolver(trainfile));
    }

    public static int treeSolver(BinaryTree file) {
        int x = 0;
        int y = file.numberOfNodes() - 2;
        int[] sorter;
        int[] cheapest = new int[file.numberOfNodes()];
        while (y >= 0) {
            x = 0;
            sorter = new int[file.findnumEdges(y)];
            while (x < file.findnumEdges(y)) {
                if (file.edgeDirection(y, x)) {
                    sorter[x] = file.findEdgeValue(y, x) + 
                            cheapest[file.findEdgeConnection(y, x)];
                }
                x++;
            }
            if (file.findnumEdges(y) > 0) {
                Arrays.sort(sorter);
                if (sorter[0] == 0&&sorter.length>1) {
                    cheapest[y] = sorter[1];
                } else {
                    cheapest[y] = sorter[0];
                }
            }
            y--;
        }
        return cheapest[0];
    }
//    public int treeSolver(BinaryTree file, int position) {
//        int costs[] = new int[file.findnumEdges(position)];
//        int cheapest;
//        if (file.findnumEdges(position) == 0) {
//            return file.findEdgeValue(position, 0);
//        }
//        for (int x = 0; x < file.findnumEdges(position); x++) {
//            if (file.edgeDirection(position, x) && file.findEdgeConnection(position, x) != file.numberOfNodes()) {
//                costs[x] = treeSolver(file, file.findEdgeConnection(position, x));
//            } else {
//                costs[x] = file.findEdgeValue(position, x);
//            }
//        }
//        Arrays.sort(costs);
//        cheapest = costs[0];
//        return cheapest;
//    }
// Apparently recursion is bad...lol

    public static BinaryTree binarytree(int trainfile[][]) {
//        int[][][] buffer = converter(trainfile);
// Hopefully the above line will not be implemented, but I'm not sure whether
// it has to be implemented eventually or not
        BinaryTree file = new BinaryTree(trainfile[0].length + 1, trainfile.length / 2);
        file.setValue(0, 0);
        for (int a = 0; a < trainfile.length / 2; a++) {
            for (int counter = 0; counter < trainfile[0].length
                    && trainfile[a * 2][counter + 1] != 0; counter++) {
                file.setEdge(trainfile[a * 2][counter], trainfile[a * 2][counter + 1],
                        trainfile[a * 2 + 1][counter]);
            }
        }
        return file;
    }

//    public static int[][][] converter(int trainfile[][]) {
//        int file[][][] = new int[2][trainfile.length / 2][trainfile.length];
//        for (int a = 0; a < file.length; a++) {
//            int buffer = 0;
//            for (int b = 0; trainfile[a][b] != 0; b++) {
//                file[0][a][trainfile[a][b]] = trainfile[a * 2 + 1][b];
//                if (b != 0) {
//                    file[1][a][trainfile[a][buffer]] = b;
//                }
//                buffer = b;
//            }
//        }
//        return file;
//        // the 0 part of the array is the distance+train section
//        //the 1 part is the part to help search
//    }
    public static int[][] input() throws FileNotFoundException {
        Scanner reader = new Scanner(new FileInputStream("trainfile.txt"));
        int x;
        int y;
        int z;
        x = reader.nextInt(); //x is number of train lines
        y = reader.nextInt(); //y is the total distance
        int file[][] = new int[2 * x][y];
        for (x = 0; x < file.length && reader.hasNextInt(); x += 2) {
            z = reader.nextInt();
            for (y = 0; y < z && reader.hasNextInt(); y++) {
                file[x][y] = reader.nextInt();
            }
            for (y = 0; y < z - 1 && reader.hasNextInt(); y++) {
                file[x + 1][y] = reader.nextInt();
            }
        }
        return file;
    }
}
//    public static double[][] efficiency(int[][] trains) {
//        int x = 0;
//        int y = 0;
//        double[][] trainefficiency = new double[trains.length / 2][trains[0].length];
//        for (x = 0; x < trains.length - 1; x++) {
//            for (y = 0; y < trains[0].length - 1; y++) {
//                trainefficiency[x][y] = (trains[x][y + 1] - trains[x][y]) / trains[x + 1][y];
//            }
//        }
//        return trainefficiency;
//    }
