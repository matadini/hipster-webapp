package pl.matadini.hipsterwebapp.context.blog.article;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import pl.matadini.hipsterwebapp.context.blog.article.dto.write.ArticleSaveDto;

public class ArticleBean {

	static ModelMapper modelMapper() {
		
		/**
		 * Workaround to bug: https://github.com/modelmapper/modelmapper/issues/473
		 */
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new PropertyMap<ArticleSaveDto, Article>() {
			@Override
			protected void configure() {
				skip(destination.getArticleId());
			}
		});

		return modelMapper;
	}

}
