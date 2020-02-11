# Inserion Sort
Insertion Sort is a sorting algorithm that iterates through the array from beginning to end. During each iteration, the current value is compared to the values before it until it either reaches the beginning of the array or it reaches a value that is less than the current value. When all iterations are complete, the array is in sorted order.

## Pseudocode
    InsertionSort(int[] arr)
  
        FOR i = 1 to arr.length
        
          int j <-- i - 1
          int temp <-- arr[i]
          
          WHILE j >= 0 AND temp < arr[j]
            arr[j + 1] <-- arr[j]
            j <-- j - 1
            
          arr[j + 1] <-- temp
      
## Trace
Sample array: [8, 4, 23, 42, 16, 15]

| For Loop Iteration |  i  |  j  |  temp  | While Loop Iteration | Array                      |
|--------------------|:---:|:---:|:------:|:--------------------:|---------------------------:|
| 1                  | 1   | -1  | 4      | 1                    | [**8, 8**, 23, 42, 16, 15] |
| 1                  | 1   | -1  | 4      |                      | [**4**, 8, 23, 42, 16, 15] | 
| 2                  | 2   | 1   | 23     |                      | [4, 8, 23, 42, 16, 15]     |
| 3                  | 3   | 2   | 42     |                      | [4, 8, 23, 42, 16, 15]     |
| 4                  | 4   | 3   | 16     | 1                    | [4, 8, 23, **42, 42**, 15] |
| 4                  | 4   | 2   | 16     | 2                    | [4, 8, **23, 23**, 42, 15] |
| 4                  | 4   | 1   | 16     |                      | [4, 8, **16**, 23, 42, 15] |
| 5                  | 5   | 4   | 15     | 1                    | [4, 8, 16, 23, **42, 42**] |
| 5                  | 5   | 3   | 15     | 2                    | [4, 8, 16, **23, 23**, 42] |
| 5                  | 5   | 2   | 15     | 3                    | [4, 8, **16, 16**, 23, 42] |
| 5                  | 5   | 1   | 15     |                      | [4, 8, **15**, 16, 23, 42] |

Sorted Array: [4, 8, 15, 16, 23, 42]

## Efficiency
* O(n^2) time complexity. The algorithm traverses n elements n times to complete the sort.
* O(1) space complexity. The algorithm creates sorts the array in place.

  