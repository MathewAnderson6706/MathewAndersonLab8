// Mathew Anderson, n01436706
package mathew.anderson.n01436706;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

//import mathew.anderson.n01436706.databinding.ActivityMainBinding;

public class SettingsFragment extends Fragment {

    public SettingsFragment() {
        // Required empty public constructor
    }

    private ImageView imageView;
    private Button button;
    ActivityResultLauncher<Intent> imageLauncher;
    //ActivityMainBinding mainBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        button = view.findViewById(R.id.matAccessButton);
        imageView = view.findViewById(R.id.matImageView2);

        // Registers a photo picker activity launcher in single-select mode.
        ActivityResultLauncher<PickVisualMediaRequest> pickMedia =
                registerForActivityResult(new ActivityResultContracts.PickVisualMedia(), uri -> {
                    // Callback is invoked after the user selects a media item or closes the
                    // photo picker.
                    if (uri != null) {
                        imageView.setImageURI(uri);
                    } else {
                        Log.d("PhotoPicker", "No media selected");
                    }
                });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickMedia.launch(new PickVisualMediaRequest.Builder()
                        .setMediaType(ActivityResultContracts.PickVisualMedia.ImageAndVideo.INSTANCE)
                        .build());
            }
        });
        return view;
    }
}