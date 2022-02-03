
import org.w3c.dom.ranges.Range;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class RangeBinarySearch {
    // Returns the index of the *first* element in `a` that equals the search key,
    // according to the given comparator, or -1 if there is no matching element.
    // Precondition: `a` is sorted according to the given comparator.
    // Complexity: O(log N) comparisons where N is the length of `a`
    public static<T> int firstIndexOf(T[] a, T key, Comparator<T> comparator) {
        // TODO
       int low = 0;
       int high = a.length - 1;
       int currentMatch = -1;
       while (low <= high) {
           int mid = (low + high) / 2;
           int comparison = comparator.compare(a[mid], key);
           if (comparison == 0) {
               currentMatch = mid;
               high = mid - 1;              // In right half
           } else if (comparison < 0) {
               low = mid+1;
           } else {
               high = mid-1;             // In left half or the same
           }
       }
       return currentMatch; // Search value not in array
    }

    // Returns the index of the *last* element in `a` that equals the search key,
    // according to the given comparator, or -1 if there are is matching element.
    // Precondition: `a` is sorted according to the given comparator.
    // Complexity: O(log N) comparisons where N is the length of `a`
   public static<T> int lastIndexOf(T[] a, T key, Comparator<T> comparator) {
        // TODO
       int low = 0;
       int high = a.length - 1;
       int currentMatch = -1;
       while (low <= high) {
           int mid = (low + high) / 2;
           int comparison = comparator.compare(a[mid], key);
           if (comparison == 0) {
               currentMatch = mid;
               low = mid+1;              // In right half
           } else if (comparison < 0) {
               low = mid+1;
           } else {
               high = mid-1;             // In left half or the same
           }
       }
       return currentMatch; // Search value not in array
    }

    // 1,3,3,3,4,5,6,7,8,9

    /*
    initial: lo= 0 hi=8
    1st: mid=4
    hi=3, lo=0
    2nd: mid=1
    hi=3, lo=2
    3rd: mid=2
    hi=3, lo=3
    4th: mid=3
    hi=3, lo=3
    */


//answer is 2 and 3 ?
    // For testing purposes.
    public static void main(String[] args) throws IOException {
            // Here you can write some tests if you want.
            Term t1 = new Term("a", 20);
            Term t2 = new Term("ABCD", 30);
            Term t3 = new Term("abd", 25);
            Term t4 = new Term("abd", 15);
            Term t5 = new Term("abd", 15);
            Term t6 = new Term("hej", 15);


            Term[] terms = {t1, t2, t3, t4, t5, t6};
            Term[] terms2 = {t1, t3, t2, t4};

            ParsedInput parsedInput = new ParsedInput(new String[]{"dictionaries/gp2011.txt", "20000"});
            Term[] dictionary = parsedInput.dictionary;
            Arrays.sort(dictionary, Term.byLexicographicOrder);
            Term key = new Term("abd",0);


            Integer[] a = {0, 1};
            Integer[] b = {0, 2};

            System.out.println(firstIndexOf(a, 0, Comparator.naturalOrder()));
            System.out.println(lastIndexOf(a, 0, Comparator.naturalOrder()));
            System.out.println(firstIndexOf(b, -1, Comparator.naturalOrder()));
            System.out.println(lastIndexOf(b, -1, Comparator.naturalOrder()));

            /*System.out.println("First index is: " + firstIndexOf(dictionary,key,Term.byLexicographicOrder));
            System.out.println("Last index is: " + lastIndexOf(dictionary,key,Term.byLexicographicOrder));*/
            System.out.println("First index is: " + firstIndexOf(terms,key,Term.byLexicographicOrder));
            /*System.out.println("First index is: " + firstIndexOf(terms2,key,Term.byLexicographicOrder));*/
            System.out.println("Last index is: " + lastIndexOf(terms,key,Term.byLexicographicOrder));
           /* System.out.println("Last index is: " + lastIndexOf(terms2,key,Term.byLexicographicOrder));*/
    }
}
