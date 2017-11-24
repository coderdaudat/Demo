package com.godev.demo.presentation.listview.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.godev.demo.R;
import com.godev.demo.presentation.listview.model.User;

import java.util.List;

/**
 * Created by truongnguyen on 11/24/17.
 */

public class UserAdapter extends ArrayAdapter<User> {

    private Context mContext;
    private int mResource;
    private LayoutInflater mInflater;

    public UserAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<User> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;

        mInflater = ((Activity) mContext).getLayoutInflater();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null) {
            convertView = mInflater.inflate(mResource, null);
            holder = new ViewHolder();
            holder.textUsername = (TextView) convertView.findViewById(R.id.text_username);
            holder.imageAvatar = (ImageView) convertView.findViewById(R.id.image_avatar);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        User user = getItem(position);

        holder.textUsername.setText(user.getUsername());

        if(!TextUtils.isEmpty(user.getAvatar())){
            Glide.with(mContext).load(user.getAvatar())
                    .thumbnail(0.5f)
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.imageAvatar);
        }

        return convertView;
    }

    static class ViewHolder {
        private TextView textUsername;
        private ImageView imageAvatar;
    }
}
