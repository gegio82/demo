package uk.co.news.valma.junit;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import uk.co.news.valma.service.DataModelService;
import uk.co.news.valma.service.DataModelServiceStub;
import uk.co.news.valma.service.HeadlineService;
import uk.co.news.valma.service.HeadlineServiceImpl;
import uk.co.news.valma.service.MethodeService;
import uk.co.news.valma.service.MethodeServiceStub;

@Configuration
public class TestAppConfig {
@Inject Environment env;
	
	@Bean
	DataModelService dataModelServiceCurrentTitle() {
		Map<String, String> heads = new HashMap<String, String>();
		heads.put("JUST_IN_CURRENT", "CURRENT: JUST_IN_CURRENT");
		heads.put("IN_BOTH_TITLES", "CURRENT: IN_BOTH_TITLES");
		heads.put("EVERYWHERE", "CURRENT: EVERYWHERE");
		return new DataModelServiceStub(heads);
	}
	@Bean
	DataModelService dataModelServiceOtherTitle() {
		Map<String, String> heads = new HashMap<String, String>();
		heads.put("IN_BOTH_TITLES", "OTHER: IN_BOTH_TITLES");
		heads.put("JUST_IN_OTHER", "OTHER: JUST_IN_OTHER");
		heads.put("JUST_IN_OTHER_AND_METHODE", "OTHER: JUST_IN_OTHER_AND_METHODE");
		heads.put("EVERYWHERE", "OTHER: EVERYWHERE");
		return new DataModelServiceStub(heads);
	}
	
	
	@Bean
	MethodeService methodeService() {
		Map<String, String> heads = new HashMap<String, String>();
		heads.put("JUST_IN_METHODE", "METHODE: JUST_IN_METHODE");
		heads.put("EVERYWHERE", "METHODE: EVERYWHERE");
		heads.put("JUST_IN_OTHER_AND_METHODE", "METHODE: JUST_IN_OTHER_AND_METHODE");
		return new MethodeServiceStub(heads);
	}
	
	@Bean
	HeadlineService headlineService() {
		return new HeadlineServiceImpl();
	}
		
}
