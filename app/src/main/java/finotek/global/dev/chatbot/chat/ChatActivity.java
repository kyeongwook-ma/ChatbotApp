package finotek.global.dev.chatbot.chat;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import dagger.android.AndroidInjection;
import finotek.global.dev.chatbot.R;
import finotek.global.dev.chatbot.databinding.ActivityChatBinding;
import io.reactivex.Observable;

public class ChatActivity extends AppCompatActivity implements ChatView {

	private ActivityChatBinding binding;
	private ChatAdapter chatAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		AndroidInjection.inject(this);
		super.onCreate(savedInstanceState);
		binding = DataBindingUtil.setContentView(this, R.layout.activity_chat);


	}

	@Override
	public void setChatList(Observable<ChatItem> items) {
		items.subscribe(
				chatItem -> chatAdapter = new ChatAdapter(items),
				throwable -> System.err.println(throwable.getMessage()),
				() -> binding.chatRcvChat.setAdapter(chatAdapter)
		);
	}


}
