// Mathew Anderson, n01436706
package mathew.anderson.n01436706;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.snackbar.Snackbar;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    private ImageView imageView;
    private Button button;
    private int imageIndex = 0;
    private int clickCount = 1;
    private final int[] imageResources = {R.drawable.image1, R.drawable.image2, R.drawable.bunni, R.drawable.aklogo1};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        imageView = view.findViewById(R.id.matImageView);
        button = view.findViewById(R.id.matButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Update ImageView with the next image
                imageView.setImageResource(imageResources[imageIndex]);
                // Rotate to the next image
                imageIndex = (imageIndex + 1) % imageResources.length;

                Snackbar.make(view, getString(R.string.name) + clickCount, Snackbar.LENGTH_SHORT).show();

                clickCount++;
            }
        });

        return view;
    }
}