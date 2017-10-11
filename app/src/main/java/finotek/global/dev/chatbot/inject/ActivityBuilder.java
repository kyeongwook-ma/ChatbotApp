package finotek.global.dev.chatbot.inject;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import finotek.global.dev.chatbot.main.MainActivity;
import finotek.global.dev.chatbot.main.MainComponent;

/**
 * Created by magyeong-ug on 2017. 9. 13..
 */
@Module
public abstract class ActivityBuilder {

	@ContributesAndroidInjector(modules = MainComponent.MainModule.class)
	abstract MainActivity bindMainActivity();


}
