package finotek.global.dev.chatbot;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import finotek.global.dev.chatbot.main.MainPresenter;
import finotek.global.dev.chatbot.main.MainPresenterImpl;
import finotek.global.dev.chatbot.main.MainView;

/**
 * Created by magyeong-ug on 2017. 9. 18..
 */
@org.junit.runner.RunWith(MockitoJUnitRunner.class)
public class MainPresenterTest {

	@Mock
	private MainView view;

	private MainPresenter presenter;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		presenter = new MainPresenterImpl(view);
	}

	@Test
	public void whenMoveToNextActivity() {
		presenter.moveToNextActivity();
	}

}
