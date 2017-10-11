package finotek.global.dev.chatbot.main;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jakewharton.rxbinding2.view.RxView;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import finotek.global.dev.chatbot.R;
import finotek.global.dev.chatbot.chat.ChatActivity;
import finotek.global.dev.chatbot.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity implements MainView {

	@Inject
	public
	MainPresenter presenter;
	private ActivityMainBinding binding;

	public void onCreate(Bundle savedInstanceState) {
		AndroidInjection.inject(this);
		super.onCreate(savedInstanceState);


		binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

		setContentView(R.layout.activity_main);

		RxView.clicks(binding.mainButton)
				.throttleFirst(200, TimeUnit.MILLISECONDS)
				.subscribe(o -> presenter.moveToNextActivity());

	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	@Override
	public void moveToNextActivity() {
		startActivity(new Intent(this, ChatActivity.class));
	}
}