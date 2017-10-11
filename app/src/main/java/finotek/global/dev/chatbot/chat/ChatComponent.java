package finotek.global.dev.chatbot.chat;

import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import finotek.global.dev.chatbot.main.MainActivity;
import finotek.global.dev.chatbot.main.MainPresenter;
import finotek.global.dev.chatbot.main.MainPresenterImpl;
import finotek.global.dev.chatbot.main.MainView;

/**
 * Created by magyeong-ug on 2017. 9. 29..
 */

public interface ChatComponent {
	@Module
	class ChatModule {

		@Provides
		ChatView provideChatView(ChatActivity chatActivity){
			return chatActivity;
		}

		@Provides
		MainPresenter provideMainPresenter(MainView mainView) {
			return new MainPresenterImpl(mainView);
		}
	}
	@Subcomponent.Builder
	abstract class Builder extends AndroidInjector.Builder<MainActivity>{}
}
