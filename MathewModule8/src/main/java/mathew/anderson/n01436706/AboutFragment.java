package mathew.anderson.n01436706;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class AboutFragment extends Fragment {

    public AboutFragment() {
        // Required empty public constructor
    }

    private int counter = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        counter++;
        String message = getString(R.string.name) + " " + counter;
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show();
    }
}