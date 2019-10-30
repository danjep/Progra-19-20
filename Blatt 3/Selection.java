public class Selection {

    // Danje Petersen 379748
    // Maximilian Petri 405602

    public static void selection(int[] a) {

        for (int n = 1; n < a.length; n++) {
            int i_min = n - 1;

            // find i_min
            for (int i = n; i < a.length; i++) {
                if (a[i] < a[i_min]) {
                    i_min = i;
                }
            }

            // switch i_min with n-1
            int temp = a[n - 1];
            a[n - 1] = a[i_min];
            a[i_min] = temp;
        }
    }
}