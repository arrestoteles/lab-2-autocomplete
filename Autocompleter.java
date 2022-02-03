import org.w3c.dom.ranges.Range;

import java.util.Arrays;

public class Autocompleter {
    private final Term[] dictionary;

    // Initializes the dictionary from the given array of terms.
    public Autocompleter(Term[] dictionary) {
        this.dictionary = dictionary;
        sortDictionary();
    }

    // Sorts the dictionary in *case-insensitive* lexicographic order.
    // Complexity: O(N log N) where N is the number of dictionary terms
    private void sortDictionary(){
        Arrays.sort(dictionary, Term.byLexicographicOrder);
    }

    // Returns the number of terms that start with the given prefix.
    // Precondition: the internal dictionary is in lexicographic order.
    // Complexity: O(log N) where N is the number of dictionary terms
    public int numberOfMatches(String prefix) {
        // TODO
        int[] startAndEndIndices = findPrefix(prefix);
        int start = startAndEndIndices[0];
        int end = startAndEndIndices[1];
        return (start != -1 && end != -1) ? end - start + 1 : 0;
    }

    private int[] findPrefix(String prefix){
        Term prefixTerm = new Term(prefix, 0);
        int startIndex = RangeBinarySearch.firstIndexOf(dictionary, prefixTerm, Term.byPrefixOrder(prefix.length()));
        int endIndex = RangeBinarySearch.lastIndexOf(dictionary, prefixTerm, Term.byPrefixOrder(prefix.length()));
        return new int[]{startIndex, endIndex};
    }

    // Returns all terms that start with the given prefix, in descending order of weight.
    // Precondition: the internal dictionary is in lexicographic order.
    // Complexity: O(log N + M log M) where M is the number of matching terms
    public Term[] allMatches(String prefix) {
        // TODO
        if(numberOfMatches(prefix) > 0){
            int[] startAndEndIndices = findPrefix(prefix);
            Term[] prefixTerms = Arrays.copyOfRange(dictionary, startAndEndIndices[0], startAndEndIndices[1] + 1);
            Arrays.sort(prefixTerms,Term.byReverseWeightOrder);
            return prefixTerms;
        }
        return new Term[]{};
    }
}
