# Left Join
Function used to perform a left join on two Hashmaps.

## Approach & Efficiency
1. At a minimum, create tests for a happy case, a case where there are no matches, cases where either table is empty, and any other edge cases.
2. Crate a new Hashmap to store the common key and an array as a value to store the value in the first table as the first element and the value in the second table as the second element.
2. Iterate through the keys of the first table.
   * If a corresponding key exists in the second Hashmaps, grab its value.
   * Create an array that store the values from each table.
   * Store that array with the key in the new Hashmap.
4. Return the new Hashmap.
3. Test

## Link to Code
* [LeftJoin.java](../src/main/java/code401Challenges/utilities/LeftJoin.java)
