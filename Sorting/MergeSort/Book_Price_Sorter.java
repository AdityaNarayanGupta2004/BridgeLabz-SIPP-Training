package MergeSort;

import java.util.ArrayList;
import java.util.List;

// Merge Sort - Sort an Array of Book Prices
// Problem Statement:
// A bookstore maintains a list of book prices in an array. Implement Merge Sort to sort the prices in ascending order.
// Hint:
// Divide the array into two halves recursively.
// Sort both halves individually.
// Merge the sorted halves by comparing elements.
public class Book_Price_Sorter {

    public static void main(String[] args) {
        int[] prices = {500, 1, 900, 64, 8979, 546, 2, 45, 0};

        System.out.println("Original Book Prices:");
        printArray(prices);

        int ans[] = sort(prices, 0, prices.length - 1);

        System.out.println("\nSorted Book Prices (Ascending):");
        printArray(ans);
    }

    // Recursively divides the array and sorts each half
     public static int [] sort(int arr[],int s,int e){
        if(s==e){//base condition
            int a[]=new int[1];// initialize the array at base condtion
            a[0]=arr[s];
            return a;
        }
        int mid=s+(e-s)/2;
        int a1[]=sort(arr,s,mid);
        int a2[]=sort(arr,mid+1,e);
        return merge(a1,a2);//merging of two arrays
    }

    // Merges two sorted subarrays into a single sorted segment
     public static int [] merge(int a1[],int a2[]){
        List<Integer> l=new ArrayList<>();
        int i=0,j=0;
        while(i<a1.length && j<a2.length){
            if(a1[i]<a2[j]){
                l.add(a1[i]);
                i++;
            }
            else{
                l.add(a2[j]);
                j++;
            }
        }
        while(i<a1.length){
            l.add(a1[i++]);
        }
        while(j<a2.length){
            l.add(a2[j++]);
        }
        int ans[]=new int[l.size()];
        for(int k=0;k<l.size();k++){
            ans[k]=l.get(k);
        }
        return ans;
    }
    // Prints the elements of the array
    public static void printArray(int[] arr) {
        for (int price : arr) {
            System.out.print(price + " ");
        }
        System.out.println();
    }
}
