package org.skypro.skyshop.searchable;


import java.util.*;

public class SearchEngine {
    private final Map<String, Searchable> searches;

    public SearchEngine() {
        searches = new HashMap<>();
    }


    public Map<String, Searchable> search(String text) {
        Map<String, Searchable> searchableItems = new TreeMap<>();
        for (Searchable searchable : searches.values()) {
            if (searchable != null && searchable.getSearchedTerm().contains(text)) {
                searchableItems.put(searchable.getName(), searchable);
            }
        }
        return searchableItems;
    }

    public void add(Searchable search) {
        searches.put(search.getName(), search);
    }


    public Searchable getSuitableSearchedItem(String item) throws BestResultNotFoundException {
        Searchable searchedItem = null;
        int countMatches = 0;
        int countMatch = 0;
        for (Map.Entry<String, Searchable> searchTable : searches.entrySet()) {
            if (searchTable.getKey().contains(item)) {
                countMatch++;
            }
            if (searchTable.getValue().toString().toLowerCase().contains(item)) {
                Searchable search = searchTable.getValue();
                int currentCountMatches = countMatches(search.getSearchedTerm(), item) + countMatch;
                if (currentCountMatches > countMatches) {
                    searchedItem = search;
                    countMatches = currentCountMatches;
            }
        }
    }
            if(searchedItem ==null)

    {
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




