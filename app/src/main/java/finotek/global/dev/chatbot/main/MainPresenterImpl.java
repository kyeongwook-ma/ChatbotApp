package finotek.global.dev.chatbot.main;



import javax.inject.Inject;

public class MainPresenterImpl implements MainPresenter {

	@Inject
	MainView mainView;

	@Inject
	public MainPresenterImpl(MainView mainView) {
		this.mainView = mainView;
	}

	@Override
	public void moveToNextActivity() {
		mainView.moveToNextActivity();
	}
}
