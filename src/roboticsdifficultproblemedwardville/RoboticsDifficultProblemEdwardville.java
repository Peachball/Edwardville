package roboticsdifficultproblemedwardville;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class RoboticsDifficultProblemEdwardville {

    public static void main(String[] args) throws FileNotFoundException {
        int trains[][] = input();
    }
    public static void binarytree(int trainfile[][]){
        BinaryTree file = new BinaryTree(trainfile[0].length,trainfile.length);
        file.setNode(0,0);
    }
    public static void binarysearch(){
        
    }
    public static int[][] input() throws FileNotFoundException {
        Scanner reader = new Scanner(System.in);
        int x;
        int y;
        int z;
        x = reader.nextInt();
        y = reader.nextInt();
        int file[][] = new int[2 * x][y];
        for ( x = 0; x < file.length; x++) {
            z=reader.nextInt();
            for(y=0;y<z;y++){
                file[x][y] = reader.nextInt();
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