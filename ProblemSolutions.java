/******************************************************************
 *
 *   Piotr Slezak / Section 1
 *
 *   This java file contains the problem solutions of isSubSet, findKthLargest,
 *   and sort2Arrays methods. You should utilize the Java Collection Framework for
 *   these methods.
 *
 ********************************************************************/

import java.util.*;

class ProblemSolutions {

    /**
     * Method: isSubset()
     *
     * Given two arrays of integers, A and B, return whether
     * array B is a subset if array A. Example:
     *      Input: [1,50,55,80,90], [55,90]
     *      Output: true
     *      Input: [1,50,55,80,90], [55,90, 99]
     *      Output: false
     *
     * The solution time complexity must NOT be worse than O(n).
     * For the solution, use a Hash Table.
     *
     * @param list1 - Input array A
     * @param list2 - input array B
     * @return      - returns boolean value B is a subset of A.
     */

    public boolean isSubset(int list1[], int list2[]) {

        Hashtable<Integer, Boolean> compare = new Hashtable<>();

        for(int i : list1){ //puts list1 into Hashtable
            compare.put(i , true);
        } //time complexity of O(n)

        for(int j : list2){
            if(!compare.containsKey(j)){ //if compare doesn't have key, return false
                return false;
            }
        } //time complexity of O(n)

        // O(n) + O(n) still equals O(n)
        return true;
    }


    /**
     * Method: findKthLargest
     *
     * Given an Array A and integer K, return the k-th maximum element in the array.
     * Example:
     *      Input: [1,7,3,10,34,5,8], 4
     *      Output: 7
     *
     * @param array - Array of integers
     * @param k     - the kth maximum element
     * @return      - the value in the array which is the kth maximum value
     */

    public int findKthLargest(int[] array, int k) {

        PriorityQueue<Integer> pQueue = new PriorityQueue<>();

        for(int i : array){ //adds entire array to PriorityQueue
            pQueue.add(i);
        }

        for(int  j = array.length; j > k; j--){ //Priority queues are minHeaps if unaltered, so we start from the back.
            pQueue.poll(); //polls (pops) off smallest integers until reaches desired kth.
        }

        return pQueue.peek();
    }


    /**
     * Method: sort2Arrays
     *
     * Given two arrays A and B with n and m integers respectively, return
     * a single array of all the elements in A and B in sorted order. Example:
     *      Input: [4,1,5], [3,2]
     *      Output: 1 2 3 4 5
     *
     * @param array1    - Input array 1
     * @param array2    - Input array 2
     * @return          - Sorted array with all elements in A and B.
     */

    public int[] sort2Arrays(int[] array1, int[] array2) {

        PriorityQueue<Integer> pQueue = new PriorityQueue<>();

        for(int i : array1){ //adds all of array1 to pQueue
            pQueue.add(i);
        }

        for(int j : array2){ //adds all of array2 to pQueue
            pQueue.add(j);
        }

        int[] sortedArray = new int[pQueue.size()]; //creates new array size of pQueue
        int index = 0;

        while(pQueue.peek() != null){ //checks if pQueue has any elements
            sortedArray[index] = pQueue.poll(); //adds smallest to array
            index++; //iterates
        }

        return sortedArray;
    }

}