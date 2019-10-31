public class Selection {

    public static void selection(int[] a) {
        int min;
        int border = 0;
        int temp;
        while(border < a.length) {
          min = border;
          for(int i = border+ 1; i < a.length; i++) {
            if(a[i] < a[min]) {
              min = i;
            }
          }
          temp = a[border];
          a[border] = a[min];
          a[min] = temp;
          border++;
        }
    }

}
