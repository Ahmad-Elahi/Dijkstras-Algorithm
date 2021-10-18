import java.util.Random;

public class Sort {
  
 // swap the ith element with the jth elements.
 private void  swap(int[] a, int i, int j){
  int temp; 
  temp = a[i]; a[i] = a[j]; a[j] = temp;
 }
 
 // initialize the array a with elements from 0 to size-1. 
 public void  initializeArray(int[] a, int size){
  for (int i=0; i<size; i++){
   a[i]=i;
  }
 }
 
 // display the elements in the array a, rowSize elements per row. 
 public void  displayArray(int[] a, int size){
  int rowSize=100;
  for (int i=0; i<size; i++){
   if(i%rowSize==0){
    System.out.println();
   }
   System.out.print(a[i]+ " ");
  }
  System.out.println();
 }
 
  // randomly swap two elements in a for SWAPTIMES times. 
  public void randomizeArray(int[] a, int size){
  final int SWAPTIMES = 10000;
  Random r = new Random();
        int j, k;
        for(int i=0; i< SWAPTIMES; i++){
         j = r.nextInt(size);
         k = r.nextInt(size);
         this.swap(a,  j, k);
        }
 }
 
  // insertion sort
 public void insertionSort(int[] a, int size){
   int key;
   int i;
   // 1: for j <- 2 to length[A]
   for (int j=1; j<size; j++){ 
     // 2: key <- A[j]
     key = a[j]; 
     // 3: i <- j-1
     i = j-1;
     // 4: while i>0 and A[i] > key
     while (i>0 && a[i]>key){ 
       // 5: A[i+1] <- A[i]
       a[i+1] = a[i];
       // 6: i <- i-1
       i = i-1;
     }
     // 7: A[i+1] <- key
     a[i+1] = key;
   }
 }
 
 // selectionSort
 public void selectionSort(int a[], int size){
  int i, j, min, minIndex;
  for (j=0; j<size-1; j++){// select jth element.
   minIndex=j; min = a[j]; 
   for (i=j+1; i<size; i++){
    if(a[i] < min ){minIndex=i; min = a[i];}
   }
   this.swap(a, j, minIndex);
  }
 }
 
 // QuickSort
 public void quickSort(int [] a, int high, int low){
   // 1: if |S| <=1 return S 
   if(low >= high){ 
     return; 
   }
   // 2: select pivot p in S 
   int p = a[low]; // selected pivot (first element)
   // 3: partition elements of S
   int part = partition(a, low, high, p);
   quickSort(a, low, part-1);
   quickSort(a, part+1, high);
 }
 
 // Partition
 private int partition(int [] a, int low, int high, int p){
   while(low <= high){
     while(a[low] < p){
       low++;
     }
     while(a[high] > p){
       high = high - 1;
     }
     if(low <= high){
       swap(a, low, high);
       low++;
       high = high - 1;
     }
   }
   return low;
 }
 
 // randomizedQuickSort
 public void randomizedQuickSort(int [] a, int high, int low){
   Random ran = new Random();
   // 1: if |S| <=1 return S 
   if(low >= high){
     return;
   }
   int num = high - low;
   int rand = ran.nextInt(num)+low; // selects a random index from the array to use as pivot
   // 2: select pivot p in S 
   int p = a[rand]; // selected pivot (random element)
   // 3: partition elements of S
   int part = partition(a, low, high, p);
   quickSort(a, low, part-1);
   quickSort(a, part+1, high);
 }
}