package finotek.global.dev.chatbot.inject;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import finotek.global.dev.chatbot.main.MainComponent;

/**
 * Created by kwm on 2017. 3. 6..
 */
@Module(subcomponents = {
		MainComponent.class
})
public class AppModule {

	@Provides
	@Singleton
	Context provideContext(Application application) {
		return application;
	}

}
