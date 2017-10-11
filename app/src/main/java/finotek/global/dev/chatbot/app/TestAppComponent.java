package finotek.global.dev.chatbot.app;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import finotek.global.dev.chatbot.inject.AppComponent;

/**
 * Created by magyeong-ug on 2017. 9. 18..
 */

@Component(modules = {
		AndroidInjectionModule.class,
		TestActivityModule.class
})
public interface TestAppComponent extends AppComponent {
}
