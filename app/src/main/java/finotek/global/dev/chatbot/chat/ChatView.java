package finotek.global.dev.chatbot.chat;

import io.reactivex.Observable;

/**
 * Created by magyeong-ug on 2017. 9. 29..
 */

public interface ChatView {
	void setChatList(Observable<ChatItem> items);
}
