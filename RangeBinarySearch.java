
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
        while (low <= high) {               // Stop when low and high meet
            if (low == high) return low;
            int mid = (low + high) / 2;     // Check middle of subarray
            if (comparator.compare(a[mid], key) < 0) {
                low = mid + 1;              // In right half
            } else {
                high = mid;             // In left half
            }
        }
        return -1; // Search value not in array
    }

    // Returns the index of the *last* element in `a` that equals the search key,
    // according to the given comparator, or -1 if there are is matching element.
    // Precondition: `a` is sorted according to the given comparator.
    // Complexity: O(log N) comparisons where N is the length of `a`
    public static<T> int lastIndexOf(T[] a, T key, Comparator<T> comparator) {
        // TODO
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {               // Stop when low and high meet
            if (low == high) return low;
            int mid = (low + high) / 2;     // Check middle of subarray
            if (comparator.compare(a[mid], key) > 0) {
                high = mid;           // In right half
            } else {
                low = mid+1; // In left half
            }
        }
        return -1; // Search value not in array
    }

//answer is 2 and 3 ?
    // For testing purposes.
    public static void main(String[] args) throws IOException {
            // Here you can write some tests if you want.
            Term t1 = new Term("abc", 20);
            Term t2 = new Term("ABCD", 30);
            Term t3 = new Term("abd", 25);
            Term t4 = new Term("abd", 15);
            Term[] terms = {t1, t2, t3, t4};
            Term[] terms2 = {t1, t3, t2, t4};

            ParsedInput parsedInput = new ParsedInput(new String[]{"dictionaries/gp2011.txt", "20000"});
            Term[] dictionary = parsedInput.dictionary;
            Arrays.sort(dictionary, Term.byLexicographicOrder);
            Term key = new Term("Göteborg",0);


            System.out.println("First index is: " + firstIndexOf(dictionary,key,Term.byLexicographicOrder));
            System.out.println("Last index is: " + lastIndexOf(dictionary,key,Term.byLexicographicOrder));
            /*System.out.println("First index is: " + firstIndexOf(terms,key,Term.byLexicographicOrder));
            System.out.println("First index is: " + firstIndexOf(terms2,key,Term.byLexicographicOrder));
            System.out.println("Last index is: " + lastIndexOf(terms,key,Term.byLexicographicOrder));
            System.out.println("Last index is: " + lastIndexOf(terms2,key,Term.byLexicographicOrder));*/
    }
}
