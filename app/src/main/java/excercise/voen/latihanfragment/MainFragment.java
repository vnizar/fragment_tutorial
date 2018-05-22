package excercise.voen.latihanfragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import static excercise.voen.latihanfragment.MainFragment.FragmentBundleKey.BUNDLE_KEY;

/**
 * Created by voen on 28/03/18.
 */

public class MainFragment extends Fragment {
    interface FragmentBundleKey {
        String BUNDLE_KEY = "item_key";
    }

    // step 4 : learn about callback concept
    interface FragmentCallback {
        void onIconClick();
    }

    // step 3 : learn how pass data from activity to fragment 
    static MainFragment newInstance(Bundle bundle) {
        MainFragment mainFragment = new MainFragment();
        mainFragment.setArguments(bundle);
        return mainFragment;
    }

    FragmentCallback callback;

    // step 1 : learn how to create fragment's view
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    // step 2 : learn how to handle data from bundle / modify default values from created view   
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        if (bundle != null) {
            setupFragmentWithBundle(view, bundle);
        } else {
            TextView tvTitle = view.findViewById(R.id.tv_title);
            TextView tvContent = view.findViewById(R.id.tv_content);
            ImageView ivProfile = view.findViewById(R.id.iv_profile);

            tvTitle.setText("Default Title");
            tvContent.setText("Content Default karena tidak ada Bundle");
            ivProfile.setImageResource(R.drawable.ic_copyright_black_24dp);

            ivProfile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callback.onIconClick();
                }
            });
        }
    }

    // step 5 : learn how to attach callback from activity
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callback = (FragmentCallback) context;
    }

    // step 6 : learn how to handle callback
    private void setupFragmentWithBundle(View view, Bundle bundle) {
        MessageItem item = bundle.getParcelable(BUNDLE_KEY);

        TextView tvTitle = view.findViewById(R.id.tv_title);
        TextView tvContent = view.findViewById(R.id.tv_content);
        ImageView ivProfile = view.findViewById(R.id.iv_profile);

        tvTitle.setText(item.title);
        tvContent.setText(item.content);
        ivProfile.setImageResource(item.image);

        ivProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onIconClick();
            }
        });
    }
}
