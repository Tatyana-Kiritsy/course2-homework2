package org.skypro.skyshop.searchable;


import java.util.Arrays;

public class SearchEngine {
    private final Searchable[] searches;
    int size;

    public SearchEngine(int size) {
        searches = new Searchable[size];
    }

    public Searchable[] search(String text) {
        Searchable[] searchable = new Searchable[size];
        for (int i = 0; i < searches.length; i++) {
            if (searches[i] != null &&
                    searches[i].getSearchedTerm().toLowerCase().contains(text)) {
                if (i < size) {
                    searchable[i] = searches[i];
                }
            }
        }
        return searchable;
    }

    public void add(Searchable search) {
        if (searches[size] == null) {
            searches[size] = search;
            size++;
        }
    }

    public Searchable getSuitableSearchedItem(String item) throws BestResultNotFoundException {
        Searchable searchedItem = null;
        int countMatches = 0;
        for (Searchable search : searches) {
            if (search != null) {
                int currentCountMatches = countMatches(search.getSearchedTerm(), item);
                if (currentCountMatches > countMatches) {
                    searchedItem = search;
                    countMatches = currentCountMatches;
                }
            }
        }
        if (searchedItem == null) {
            throw new BestResultNotFoundException("Совпадений для '" + item + "' не найдено");
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
                "searches=" + Arrays.toString(searches) +
                '}';
    }
}



