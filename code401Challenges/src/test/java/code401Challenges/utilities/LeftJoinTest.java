package code401Challenges.utilities;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class LeftJoinTest {

  HashMap<String, String> synonyms;
  HashMap<String, String> antonyms;
  HashMap<String, String[]> results;

  @Before
  public void setUp() throws Exception {
    synonyms = new HashMap<>();
    synonyms.put("fond", "enamored");
    synonyms.put("wrath", "anger");
    synonyms.put("diligent", "employed");
    synonyms.put("outfit", "garb");
    synonyms.put("guide", "usher");
    antonyms = new HashMap<>();
    antonyms.put("fond", "averse");
    antonyms.put("wrath", "delight");
    antonyms.put("diligent", "idle");
    antonyms.put("guide", "follow");
    antonyms.put("flow", "jam");
  }

  @Test
  public void happyTest() {
    results = LeftJoin.leftJoin(synonyms, antonyms);
    assertArrayEquals(new String[]{"enamored", "averse"}, results.get("fond"));
  }

  @Test
  public void expectedMap2DoesNotContain() {
    results = LeftJoin.leftJoin(synonyms, antonyms);
    assertArrayEquals(new String[]{"garb", null}, results.get("outfit"));
  }
}