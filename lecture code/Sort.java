public class Sort {
   public void sort(String[] x) {
       sortHelper(x, 0);
   } 

   private int smallestElement(String[] x) {
       int smallestIndex = 0;
       for(int i = 0; i < x.length; i++) {
           if(x[i].compareTo(x[smallestIndex]) < 0) {
               smallestIndex = i;
           }
       }
       return i;
   }

   private void sortHelper(String[] x, int start) {
       if(x.length == 1) {
           return;
       }
       else {
           int minIndex = smallestElement(x);
           
           //Swaps the smallest element and the front of the array
           int temp = x[start];
           x[start] = x[minIndex];
           x[minIndex] = temp;

           //Recursively sorts the rest of the list;
           sortHelper(x, start-1);
       }
   }
    
}
