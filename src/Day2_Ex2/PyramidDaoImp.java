package Day2_Ex2;

import java.util.ArrayList;
import java.io.*;
import java.util.Comparator;
import java.util.HashMap;

public class PyramidDaoImp implements PyramidDao {

    ArrayList<Pyramid> pyramids;

    PyramidDaoImp() throws IOException {
        allPyramids();
    }

    @Override
    public ArrayList<String> getAllPyramidsName() {
        ArrayList<String> arrayList = new ArrayList<String>();
        for (Pyramid pyramid : pyramids){
           arrayList.add(pyramid.getPyrmidName());
        }
        return arrayList;
    }

    @Override
    public ArrayList<Pyramid> allPyramids() throws IOException {
        pyramids = new ArrayList<Pyramid>();
        BufferedReader br = new BufferedReader(new FileReader("Day2_Ex1_Pyramids.csv"));
        String line = br.readLine();
        while (line != null) {
            line = br.readLine();
            if (line != null){
                String[] lineData = line.split(",");
                Pyramid pyramid = new Pyramid();
                pyramid.setPharohName(lineData[0]);
                pyramid.setPyrmidName(lineData[2]);
                pyramid.setPyramidLocation(lineData[4]);
                if (lineData[7].equals("")){
                    pyramid.setPyramidHeight(0);
                }else {
                    pyramid.setPyramidHeight(Float.parseFloat(lineData[7]));
                }
                pyramids.add(pyramid);
            }
        }
        br.close();
        return pyramids;
    }

    @Override
    public Pyramid getPyramid(String name) {
        for (Pyramid pyramid : pyramids){
            if (pyramid.getPyrmidName().equals(name)){
                return pyramid;
            }
        }
        return null;
    }

    @Override
    public void deletePyramid(String name) {
        pyramids.removeIf(pyramid -> pyramid.getPyrmidName().equals(name));
    }

    @Override
    public void sortedPyramids() {
        pyramids.sort(Comparator.comparingDouble(Pyramid::getPyramidHeight));
    }

    @Override
    public HashMap<String, Integer> groupByPlaces() {
        HashMap<String,Integer> hashMap = new HashMap<>();
        for (Pyramid pyramid : pyramids){
            if (!hashMap.containsKey(pyramid.getPyramidLocation())){
                hashMap.put(pyramid.getPyramidLocation(),1);
            }
            else {
                hashMap.replace(pyramid.getPyramidLocation(),hashMap.get(pyramid.getPyramidLocation())+1);
            }
        }
        return hashMap;
    }

}
