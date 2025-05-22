package org.skypro.skyshop.article;

import org.skypro.skyshop.searchable.Searchable;

public final class Article implements Searchable {
    private String articleName;
    private String articleText;

    public Article(String articleName, String articleText) {
        this.articleName = articleName;
        this.articleText = articleText;
    }

    public String getArticleName() {
        return articleName;
    }

    public String getArticleText() {
        return articleText;
    }

    @Override
    public String toString() {
        return "Название статьи: " + articleName + ", текст статьи:" + articleText;
    }

    @Override
    public String getSearchedTerm() {
        return "Название статьи: " + getArticleName() + ", текст статьи:" + getArticleText();
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String getName() {
        return getArticleName();
    }
}
