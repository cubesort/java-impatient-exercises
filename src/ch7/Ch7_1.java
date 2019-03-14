package ch7;

import java.util.*;

public class Ch7_1 {
    public static void main(String[] args) {
        Integer[] primes = findPrimes(10);
        System.out.println(Arrays.toString(primes));
        Integer[] primes2 = findPrimesBitSet(10);
        System.out.println(Arrays.toString(primes2));
    }

    public static Integer[] findPrimes(int n) {
        Set<Integer> set = new HashSet<>(n - 1);
        for (int i = 2; i <= n; i++) {
            set.add(i);
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (set.contains(i)) {
                int factor = 1;
                while (i * factor <= n) {
                    set.remove(i * factor);
                    factor++;
                }
            }
        }

        return set.toArray(new Integer[0]);
    }

    public static Integer[] findPrimesBitSet(int n) {
        BitSet set = new BitSet(n + 1);
        set.set(2, n + 1);

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (set.get(i)) {
                int factor = 1;
                while (i * factor <= n) {
                    set.set(i * factor, false);
                    factor++;
                }
            }
        }

        Integer[] primes = new Integer[set.cardinality()];
        Integer current = set.nextSetBit(0);
        for (int i = 0; i < primes.length; i++) {
            primes[i] = current;
            current = set.nextSetBit(current + 1);
        }

        return primes;
    }
}
