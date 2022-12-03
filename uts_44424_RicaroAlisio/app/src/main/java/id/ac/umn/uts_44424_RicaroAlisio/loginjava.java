package id.ac.umn.uts_44424_RicaroAlisio;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class loginjava extends AppCompatDialogFragment{

    public static final String EXTRA_NAME = "name";
    private EditText namalogin;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.login, null);
        builder.setView(view)
                .setTitle("Login")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        namalogin = (EditText) getDialog().findViewById(R.id.loginNama);
                        String nama = namalogin.getText().toString();
                        if (nama.trim().equals("")) {
                            Toast.makeText(getActivity(),"Gaboleh Kosong !",Toast.LENGTH_SHORT).show();
                            return;
                        }
                        Intent intent = new Intent(getActivity(), LibraryActivity.class);
                        intent.putExtra(EXTRA_NAME, nama);
                        startActivity(intent);
                    }

                    private void pindahactivitylibrary() {

                    }
                });

        namalogin = view.findViewById(R.id.loginNama);

        return builder.create();


    }

}
