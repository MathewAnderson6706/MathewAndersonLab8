package mathew.anderson.n01436706;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class ShareFragment extends Fragment {

    public ShareFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_share, container, false);

        ImageButton imageButton = view.findViewById(R.id.matImageButton2);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox checkBox = view.findViewById(R.id.checkBox);
                EditText emailEditText = view.findViewById(R.id.matEditEmail);
                EditText idEditText = view.findViewById(R.id.matEditID);

                String email = emailEditText.getText().toString().trim();
                String id = idEditText.getText().toString().trim();

                if (!isValidEmail(email)) {
                    emailEditText.setError(getString(R.string.invalid_email));
                    clearFields(emailEditText, idEditText);
                    return;
                }

                if (id.length() < 6) {
                    idEditText.setError(getString(R.string.id_must_be_at_least_6_digits));
                    clearFields(emailEditText, idEditText);
                    return;
                }

                SharedPreferences sharedPreferences = requireActivity().getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("isChecked", checkBox.isChecked());
                editor.putString("email", email);
                editor.putString("id", id);
                editor.apply();

                String userInfo = checkBox.isChecked() + "\n" +
                        email + " " + id;
                Toast.makeText(requireContext(), userInfo, Toast.LENGTH_LONG).show();

                emailEditText.setText("");
                idEditText.setText("");
            }
        });

        return view;
    }

    private boolean isValidEmail(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void clearFields(EditText emailEditText, EditText idEditText) {
        emailEditText.setText("");
        idEditText.setText("");
    }
}