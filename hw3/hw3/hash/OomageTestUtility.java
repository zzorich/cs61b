package hw3.hash;

import java.util.ArrayList;
import java.util.List;

public class OomageTestUtility {
    public static boolean haveNiceHashCodeSpread(List<Oomage> oomages, int M) {
        ArrayList<Oomage>[] buckets = new ArrayList[M];
        for (int i = 0; i < M; i++) {
            buckets[i] = new ArrayList();
        }
        for (Oomage oomage: oomages) {
            int index = (oomage.hashCode() & 0x7FFFFFFF) % M;
            buckets[index].add(oomage);
        }
        for (ArrayList bucket: buckets) {
            if (bucket.size() > oomages.size() / 2.5 || bucket.size() < oomages.size() / 50) {
                return false;
            }
        }
        return true;
    }
}
