package org.skypro.skyshop.article;

import org.skypro.skyshop.searchable.Searchable;

import java.util.Objects;

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
        return "Название статьи: " + getArticleName().toLowerCase() + ", текст статьи:" + getArticleText();
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String getName() {
        return getArticleName();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(articleName, article.articleName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(articleName);
    }
}
