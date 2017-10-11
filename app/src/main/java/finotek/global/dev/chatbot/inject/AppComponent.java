package finotek.global.dev.chatbot.inject;

import android.app.Application;


import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import finotek.global.dev.chatbot.app.MyApplication;


@Component(modules = { AndroidInjectionModule.class, AppModule.class, ActivityBuilder.class })
public interface AppComponent {

	@Component.Builder
	interface Builder {
		@BindsInstance
		Builder	application(Application application);
		AppComponent build();
	}

	void inject(MyApplication app);
}
