package mathew.anderson.n01436706;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class AboutFragment extends Fragment {

    public AboutFragment() {
        // Required empty public constructor
    }

    private int counter = 0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        boolean isChecked = sharedPreferences.getBoolean("isChecked", false);
        String email = sharedPreferences.getString("email", "NO DATA");
        String id = sharedPreferences.getString("id", "NO DATA");
        //editor.clear();
        //editor.apply();

        TextView checkboxTextView = view.findViewById(R.id.matBoxCheck);
        TextView emailTextView = view.findViewById(R.id.matEmailCheck);
        TextView idTextView = view.findViewById(R.id.matIDCheck);

        ToggleButton toggleButton = view.findViewById(R.id.matToggleButton);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Lock orientation to portrait
                    getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                } else {
                    // Set to auto orientation
                    getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
                }
            }
        });


        if (isChecked) {
            checkboxTextView.setText(getString(R.string.iftrue));
        } else {
            checkboxTextView.setText(getString(R.string.iffalse));
        }
        emailTextView.setText(email);
        idTextView.setText(id);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        counter++;
        String message = getString(R.string.name) + " " + counter;
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show();
    }
}