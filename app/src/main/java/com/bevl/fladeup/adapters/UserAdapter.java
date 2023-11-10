package com.bevl.fladeup.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.bevl.fladeup.R;
import com.bevl.fladeup.dto.User.UserModelDTO;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends ArrayAdapter<UserModelDTO> implements View.OnClickListener{

    private List<UserModelDTO> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView txtFirstname;
        TextView txtLastName;
    }

    public UserAdapter(List<UserModelDTO> data, Context context) {
        super(context, R.layout.user_listitem, data);
        this.dataSet = data;
        this.mContext=context;

    }

    @Override
    public void onClick(View v) {

        int position=(Integer) v.getTag();
        Object object= getItem(position);
        UserModelDTO dataModel=(UserModelDTO)object;


    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        UserModelDTO dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.user_listitem, parent, false);
            viewHolder.txtFirstname = (TextView) convertView.findViewById(R.id.firstname);
            viewHolder.txtLastName = (TextView) convertView.findViewById(R.id.lastname);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        viewHolder.txtFirstname.setText(dataModel.getFirstName());
        viewHolder.txtLastName.setText(dataModel.getLastName());
        // Return the completed view to render on screen
        return convertView;
    }


}