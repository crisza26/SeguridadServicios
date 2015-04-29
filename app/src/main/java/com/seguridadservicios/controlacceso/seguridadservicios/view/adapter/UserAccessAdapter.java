package com.seguridadservicios.controlacceso.seguridadservicios.view.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.seguridadservicios.controlacceso.seguridadservicios.R;
import com.seguridadservicios.controlacceso.seguridadservicios.model.UserAccessModel;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Dianita on 26/03/2015.
 */
public class UserAccessAdapter extends ArrayAdapter<UserAccessModel> {
    private Activity activity;
    private List<UserAccessModel> data;
    public Resources res;
    UserAccessModel tempValues = null;
    LayoutInflater inflater;

    public UserAccessAdapter(Activity activity,
                             int textViewResourceId,
                             List<UserAccessModel> objects,
                             Resources resLocal) {
        super(activity, textViewResourceId, objects);
        activity = activity;
        this.data = objects;
        res = resLocal;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ItemViewHolder viewHolder;
        /********** Inflate spinner_rows.xml file for each row ( Defined below ) ************/
        convertView = inflater.inflate(R.layout.item_user_access, parent, false);
        viewHolder = new ItemViewHolder();

        viewHolder.tv_name = (TextView) convertView.findViewById(R.id.id_nombre);
        viewHolder.image = (ImageButton) convertView.findViewById(R.id.id_botom);


        tempValues = (UserAccessModel) data.get(position);

        if (tempValues != null) {
            viewHolder.tv_name.setText(tempValues.nombre);
            Picasso.with(convertView.getContext())
                    .load(R.drawable.about)
                    .into(viewHolder.image);
        }

        return convertView;
    }

    private static class ItemViewHolder {
        ImageView image;
        TextView tv_name;
        TextView tv_total;
    }
}
