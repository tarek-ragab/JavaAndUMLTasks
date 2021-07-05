package Day2_Ex2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public interface PyramidDao {
    ArrayList<String> getAllPyramidsName();
    ArrayList<Pyramid> allPyramids() throws IOException;
    Pyramid getPyramid(String name);
    void deletePyramid(String name);
    void sortedPyramids();
    HashMap<String,Integer> groupByPlaces ();
}
