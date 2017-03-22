package uk.co.news.valma.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import uk.co.news.valma.service.HeadlineService;
import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestAppConfig.class, loader = AnnotationConfigContextLoader.class)
public class HeadelineTest {

	@Autowired
	private HeadlineService headlineService;
	
	@Test
	public void testCurrentTitle() {
		String title = headlineService.getHeadline("JUST_IN_CURRENT");
		assertEquals("CURRENT: JUST_IN_CURRENT", title);	
	}
	
	@Test
	public void testOtherTitle() {
		String title = headlineService.getHeadline("JUST_IN_OTHER");
		assertEquals("OTHER: JUST_IN_OTHER", title);
	}

	@Test
	public void testInMethode() {
		String title = headlineService.getHeadline("JUST_IN_METHODE");
		assertEquals("METHODE: JUST_IN_METHODE", title);
	}
	
	@Test
	public void testEverywhere() {
		String title = headlineService.getHeadline("EVERYWHERE");
		assertEquals("CURRENT: EVERYWHERE", title);
	}
	
	@Test
	public void testInAllTitle() {
		String title = headlineService.getHeadline("IN_BOTH_TITLES");
		assertEquals("CURRENT: IN_BOTH_TITLES", title);
	}
	
	@Test
	public void testInOtherTitleAndMethode() {
		String title = headlineService.getHeadline("JUST_IN_OTHER_AND_METHODE");
		assertEquals("OTHER: JUST_IN_OTHER_AND_METHODE", title);
	}
	@Test
	public void testNotFound() {
		String title = headlineService.getHeadline("NOTPRESENT");
		assertNull(title);
	}
}
