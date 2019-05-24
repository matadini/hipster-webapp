package pl.matadini.hipsterwebapp.context.blog.article;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.pmw.tinylog.Logger;

import pl.matadini.hipsterwebapp.context.blog.article.dto.write.ArticleSaveDto;

public class ModelMapperBugTest {

	ModelMapper modelMapper;

	@BeforeEach
	void beforeEach() {
		modelMapper = new ModelMapper();
		modelMapper.addMappings(new PropertyMap<ArticleSaveDto, Article>() {
            @Override
            protected void configure() {
                skip(destination.getArticleId());
            }
        });
	}

	@Test
	void test() {

		ArticleSaveDto dto = ArticleSaveDto.builder().articleAuthorId(1L).build();
		Article entity = modelMapper.map(dto, Article.class);
		ArticlePOJO entity0 = modelMapper.map(dto, ArticlePOJO.class);
		Logger.info("{} \n {} \n {}", dto, entity, entity0);

	}
}
