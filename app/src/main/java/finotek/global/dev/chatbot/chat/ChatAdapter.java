package finotek.global.dev.chatbot.chat;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import io.reactivex.Observable;

/**
 * Created by magyeong-ug on 2017. 9. 29..
 */

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatVH> {

	private Observable<ChatItem> chatItems;
	ChatAdapter(Observable<ChatItem> chatItems) {
		this.chatItems = chatItems;
	}

	@Override
	public ChatVH onCreateViewHolder(ViewGroup parent, int viewType) {
		return null;
	}

	@Override
	public void onBindViewHolder(ChatVH holder, int position) {

	}


	@Override
	public int getItemCount() {
		return 0;
	}

	class ChatVH extends RecyclerView.ViewHolder {

		public ChatVH(View itemView) {
			super(itemView);
		}
	}


}
