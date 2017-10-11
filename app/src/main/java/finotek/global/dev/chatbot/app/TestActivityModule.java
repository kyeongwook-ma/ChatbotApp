package finotek.global.dev.chatbot.app;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;
import finotek.global.dev.chatbot.main.MainActivity;
import finotek.global.dev.chatbot.main.MainPresenter;

import static org.mockito.Mockito.mock;

/**
 * Created by magyeong-ug on 2017. 9. 18..
 */
@Module
public abstract class TestActivityModule {
	@ContributesAndroidInjector(modules = TestMainModule.class)
	abstract MainActivity mainActivityInjector();
	@Module
	static class TestMainModule {
		@Provides
		MainPresenter providesMainPresenter() {
			return mock(MainPresenter.class);
		}
	}
}
