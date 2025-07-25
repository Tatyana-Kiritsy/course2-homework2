package org.skypro.skyshop.searchable;


import java.util.*;

public class SearchEngine {
    private final Set<Searchable> searches;

    public SearchEngine() {
        searches = new HashSet<>();
    }


    public Set<Searchable> search(String text) {
        Set<Searchable> searchableItems = new TreeSet<>(new SearchableComparator());
        for (Searchable searchable : searches) {
            if (searchable != null && searchable.getSearchedTerm().contains(text)) {
                searchableItems.add(searchable);
            }
        }
        return searchableItems;
    }

    public void add(Searchable search) {
        searches.add(search);
    }


    public Searchable getSuitableSearchedItem(String item) throws BestResultNotFoundException {
        Searchable searchedItem = null;
        int countMatches;
        int counter = 0;
        for (Searchable searchTable : searches) {
            if (searchTable.getSearchedTerm().contains(item)) {
                countMatches = countMatches(searchTable.getSearchedTerm(), item);
                if (countMatches > counter) {
                    searchedItem = searchTable;
                    counter = countMatches;
                }
            }
        }
        if (searchedItem == null) {
            throw new BestResultNotFoundException("Совпадений для '" + item + "' не найдено!");
        }
        return searchedItem;
    }

    private int countMatches(String text, String item) {
        int count = 0;
        int index = 0;
        while ((index = text.indexOf(item, index)) >= 0) {
            count++;
            index = index + item.length();
        }

        return count;
    }

    @Override
    public String toString() {
        return "SearchEngine{" +
                "searches=" + searches +
                '}';
    }
}




