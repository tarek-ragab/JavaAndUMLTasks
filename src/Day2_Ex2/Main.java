package Day2_Ex2;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String pyramidName="Pyramid Lepsius I";
        printPyramidDetails(pyramidName);
        sortPyramids();
        pyramidsPerPlace();
        deletePyramid(pyramidName);
    }

    public static void printPyramidDetails(String name) throws IOException {
        PyramidDaoImp pyramidDaoImp = new PyramidDaoImp();
        System.out.println(
                name+" was built by "+
                pyramidDaoImp.getPyramid(name).getPharohName()+
                "\nit is located in "+
                pyramidDaoImp.getPyramid(name).getPyramidLocation()+
                "\nits height is "+
                pyramidDaoImp.getPyramid(name).getPyramidHeight());
    }

    public static void deletePyramid(String name) throws IOException {
        PyramidDaoImp pyramidDaoImp = new PyramidDaoImp();
        System.out.println("Before deletion "+pyramidDaoImp.getAllPyramidsName());
        pyramidDaoImp.deletePyramid(name);
        System.out.println("After deletion "+pyramidDaoImp.getAllPyramidsName());
    }

    public static void sortPyramids() throws IOException {
        PyramidDaoImp pyramidDaoImp = new PyramidDaoImp();
        pyramidDaoImp.sortedPyramids();
        System.out.println(pyramidDaoImp.getAllPyramidsName());
    }

    public static void pyramidsPerPlace() throws IOException {
        PyramidDaoImp pyramidDaoImp = new PyramidDaoImp();
        System.out.println(pyramidDaoImp.groupByPlaces());
    }
}
