package excercise.voen.latihanfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by voen on 28/03/18.
 */

public class SecondActivity extends AppCompatActivity implements MainFragment.FragmentCallback {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    @Override
    public void onIconClick() {

    }
}
