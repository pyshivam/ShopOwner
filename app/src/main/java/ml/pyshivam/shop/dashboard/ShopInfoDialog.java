package ml.pyshivam.shop.dashboard;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import ml.pyshivam.shop.R;
import ml.pyshivam.shop.utils.Common;
import ml.pyshivam.shop.utils.SharedPrefs;

public class ShopInfoDialog extends DialogFragment {

    TextView shop_name_dailog_text, shop_address_dialog_text, shop_phone_dialog,
            owner_name_dialog_text, owner_email_dialog, owner_phone;

    Button close;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dailog_shop_info, container, false);
        shop_name_dailog_text = view.findViewById(R.id.shop_name_dailog_text);
        shop_address_dialog_text = view.findViewById(R.id.shop_address_dialog_text);
        shop_phone_dialog = view.findViewById(R.id.shop_phone_dialog);
        owner_name_dialog_text = view.findViewById(R.id.owner_name_dialog_text);
        owner_email_dialog = view.findViewById(R.id.owner_email_dialog);
        owner_phone = view.findViewById(R.id.owner_phone);
        close = view.findViewById(R.id.close_dialog_btn);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(Common.MAIN, 0);
        SharedPrefs sharedPrefs = new SharedPrefs(sharedPreferences);
        shop_name_dailog_text.setText(sharedPrefs.getString(Common.SHOP_NAME));
        shop_address_dialog_text.setText(sharedPrefs.getString(Common.SHOP_ADD));
        shop_phone_dialog.setText(sharedPrefs.getString(Common.SHOP_PHONE));

        owner_email_dialog.setText(sharedPrefs.getString(Common.OWNER_EMAIL));
        owner_name_dialog_text.setText(sharedPrefs.getString(Common.OWNER_NAME));
        owner_phone.setText(sharedPrefs.getString(Common.OWNER_PHONE));

        return view;

    }
}
