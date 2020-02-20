package code401Challenges.utilities;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LeftJoin {
  public static HashMap<String, String[]> leftJoin(HashMap<String, String> map1, HashMap<String, String> map2) {
    // new HashMap for results of left join
    HashMap<String, String[]> result = new HashMap<>();

    // iterate through map1 to get all key, value pairs
    Iterator<Map.Entry<String, String>> iterator = map1.entrySet().iterator();
    while(iterator.hasNext()) {
      // get the current entry
      Map.Entry<String, String> entry = iterator.next();
      // grab the value of the current entry
      String map1Value = entry.getValue();
      // grab the corresponding value from map2. This may be null
      String map2Value = map2.get(entry.getKey());
      // create an array with the joined values
      String[] joinedValues = {map1Value, map2Value};
      // store the joined values in the results map
      result.put(entry.getKey(), joinedValues);
    }
    return result;
  }
}
