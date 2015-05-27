package kz.aibol.schoolfeed;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseInstallation;

/**
 * SchoolFeed
 * Created by Aibol Kussain on 5/27/2015.
 * For support information write kussain@aibol.kz
 */
public class App extends Application {
    @Override
    public void onCreate() {
        Parse.initialize(this, "FPurIFJDpDQJeQkNeO1auNzvddazCIZX7Z4GhVFi", "iQ2pEoT6COEboyjx0wSY6S0XdsoKnIce9EuLSJfF");
        ParseInstallation.getCurrentInstallation().saveInBackground();
    }
}
