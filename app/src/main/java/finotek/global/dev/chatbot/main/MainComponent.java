package finotek.global.dev.chatbot.main;

import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by magyeong-ug on 21/03/2017.
 */
@Subcomponent(modules = MainComponent.MainModule.class)
public interface MainComponent extends AndroidInjector<MainActivity> {
	@Module
	class MainModule {

		@Provides
		MainView provideMainView(MainActivity mainActivity){
			return mainActivity;
		}

		@Provides
		MainPresenter provideMainPresenter(MainView mainView) {
			return new MainPresenterImpl(mainView);
		}
	}
	@Subcomponent.Builder
	abstract class Builder extends AndroidInjector.Builder<MainActivity>{}
}
