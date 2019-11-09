public class Selection {

    // Danje Petersen 379748
    // Maximilian Petri 405602

    public static void selection(int[] a) {

        for (int n = 0; n < a.length; n++) {
            int i_min = n;

            // find i_min
            for (int i = n; i < a.length; i++) {
                if (a[i] < a[i_min]) {
                    i_min = i;
                }
            }

            // switch i_min with n
            int temp = a[n];
            a[n] = a[i_min];
            a[i_min] = temp;
        }
    }
}