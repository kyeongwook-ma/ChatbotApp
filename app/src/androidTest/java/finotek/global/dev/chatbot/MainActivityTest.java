package finotek.global.dev.chatbot;

import android.support.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import finotek.global.dev.chatbot.app.DaggerTestAppComponent;
import finotek.global.dev.chatbot.main.MainActivity;

/**
 * Created by magyeong-ug on 2017. 9. 18..
 */
@RunWith(MockitoJUnitRunner.class)
public class MainActivityTest {

	@Rule
	public ActivityTestRule<MainActivity>
	activityRule = new ActivityTestRule<MainActivity>(MainActivity.class);

	@Before
	public void setUp() {
		TestApp app = null;
		DaggerTestAppComponent.builder().build().inject(app);
	}

	@Test
	public void onNextMove() {
		activityRule.getActivity().presenter.moveToNextActivity();


	}

}
