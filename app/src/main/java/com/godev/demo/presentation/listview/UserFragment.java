package com.godev.demo.presentation.listview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.godev.demo.R;
import com.godev.demo.presentation.listview.adapter.UserAdapter;
import com.godev.demo.presentation.listview.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by truongnguyen on 11/24/17.
 */

public class UserFragment extends Fragment {

    public static UserFragment getInstance(){
        return new UserFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        ListView listUser = view.findViewById(R.id.list_view_user);

        List<User> users = new ArrayList<>();
        users.add(new User("ethan", "https://dantricdn.com/k:2016/photo-2-1470195841830/4hotgirllaivuagiaucoxinhdeplaihocratgioi.jpg"));
        users.add(new User("cobenguoigo", "https://dantricdn.com/k:2016/photo-2-1470195841830/4hotgirllaivuagiaucoxinhdeplaihocratgioi.jpg"));
        users.add(new User("cobelolem", "https://dantricdn.com/k:2016/photo-2-1470195841830/4hotgirllaivuagiaucoxinhdeplaihocratgioi.jpg"));

        UserAdapter userAdapter = new UserAdapter(getContext(), R.layout.item_user, users);
        listUser.setAdapter(userAdapter);
        return view;
    }
}
