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

    interface FragmentCallback {
        void onIconClick();
    }

    static MainFragment newInstance(Bundle bundle) {
        MainFragment mainFragment = new MainFragment();
        mainFragment.setArguments(bundle);
        return mainFragment;
    }

    FragmentCallback callback;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

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

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callback = (FragmentCallback) context;
    }

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
