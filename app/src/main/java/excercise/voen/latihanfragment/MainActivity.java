package excercise.voen.latihanfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static excercise.voen.latihanfragment.MainFragment.FragmentBundleKey.BUNDLE_KEY;

// implement callback interface from fragment to activity
public class MainActivity extends AppCompatActivity implements MainFragment.FragmentCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.bt_attach);
        Button btNextActivity = findViewById(R.id.bt_next_activity);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                MessageItem item = new MessageItem("Title di Main Activity", "Content di Main Activity", R.drawable.ic_camera_black_24dp);
                bundle.putParcelable(BUNDLE_KEY,item);
                Fragment fragment = MainFragment.newInstance(bundle);
                getSupportFragmentManager().beginTransaction().add(R.id.container_2,fragment).commit();
            }
        });

        btNextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onIconClick() {
        Toast.makeText(this, "Haloo Dunia", Toast.LENGTH_SHORT).show();
    }
}
