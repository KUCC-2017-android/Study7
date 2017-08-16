package kr.ac.korea.kucc.study7.fragment;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import kr.ac.korea.kucc.study7.R;

public class AddDialogFragment extends DialogFragment {
    private OnPositiveButtonClickListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_add, null);
        final EditText editText = (EditText) view.findViewById(R.id.edit_new_item);
        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(view);
        builder.setTitle(R.string.dialog_title_add)
                .setPositiveButton(R.string.add, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                        listener.onPositiveButtonClick(editText.getText().toString());
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        return builder.create();
    }

    public void setOnPositiveButtonClickListener(OnPositiveButtonClickListener listener) {
        this.listener = listener;
    }

    public interface OnPositiveButtonClickListener {
        void onPositiveButtonClick(String result);
    }
}
