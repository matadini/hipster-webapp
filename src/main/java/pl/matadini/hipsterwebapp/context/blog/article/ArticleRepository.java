package pl.matadini.hipsterwebapp.context.blog.article;

import pl.matadini.hipsterwebapp.shared.jpa.JpaRepository;

interface ArticleRepository extends JpaRepository<Article, Long> {

}