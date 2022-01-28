
import org.w3c.dom.ranges.Range;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class RangeBinarySearch {
    // Returns the index of the *first* element in `a` that equals the search key,
    // according to the given comparator, or -1 if there is no matching element.
    // Precondition: `a` is sorted according to the given comparator.
    // Complexity: O(log N) comparisons where N is the length of `a`
    public static<T> int firstIndexOf(T[] a, T key, Comparator<T> comparator) {
        // TODO


        int min = 0;
        int max = a.length - 1;

        while (true) {
            /*
            int mid = (lo+hi)/2;
            if (comparator.compare(a[mid], key) < 0) {        // if true key is in right part of array
                lo = mid + 1;
            } else if (comparator.compare(a[mid], key) > 0) {  // if true key is in left part of array
                hi = mid - 1;
            } else if (comparator.compare(a[mid], key) == 0) {  // mid == key
                return mid;
            }*/
            int mid = (min + max) / 2;
            if (min == max) return min;
            System.out.println("min != max");
            System.out.println(min+" "+mid+" "+max);
            if (comparator.compare(a[mid], key) == -1) { // if true key is in right part of array
                System.out.println("mid < key");
                min = mid + 1;
            } else {                                    // if true key is in left part of array
                System.out.println("hi > key");
                max = mid;
            }
        }
    }
/*
        if (min == max) return min;
        int mid = (lo+hi+1)/2;
        if (comparator.compare(a[mid], key) == 1) {  // if true key is in right part of array
            hi = mid - 1;
        } else {                                    // if true key is in left part of array
            lo = mid;
        }
        return -1;
    }
*/
    // Returns the index of the *last* element in `a` that equals the search key,
    // according to the given comparator, or -1 if there are is matching element.
    // Precondition: `a` is sorted according to the given comparator.
    // Complexity: O(log N) comparisons where N is the length of `a`
    public static<T> int lastIndexOf(T[] a, T key, Comparator<T> comparator) {
        // TODO

        int lo = a.length-1;
        int hi = 0;
        while (lo >= hi) {
            int mid = (lo+hi)/2;
            if (comparator.compare(a[mid], key) > 0) {        // if true key is in right part of array
                lo = mid + 1;
            } else if (comparator.compare(a[mid], key) < 0) {  // if true key is in left part of array
                hi = mid - 1;
            } else if (comparator.compare(a[mid], key) == 0) {  // mid == key
                return mid;
            }
        }
        return -1;
    }


    // For testing purposes.
    public static void main(String[] args) throws IOException {
        // Here you can write some tests if you want.
        Comparator<Object> lexiComp = new Comparator<Object>() {
            public int compare(Object o1, Object o2) {
                if(o1.getClass() == Term.class && o2.getClass() == Term.class){
                    Term t1 = (Term) o1;
                    Term t2 = (Term) o2;
                    return t1.getWord().compareToIgnoreCase(t2.getWord());
                }
                return -8;
            }
        };

        ParsedInput parsedInput = new ParsedInput(new String[]{"/Users/arminbalesic/IdeaProjects/lab-2/dictionaries/gp2011.txt", "340000"});
        int result = RangeBinarySearch.firstIndexOf(parsedInput.dictionary, "hos", lexiComp);
        System.out.println(result);
    }
}
