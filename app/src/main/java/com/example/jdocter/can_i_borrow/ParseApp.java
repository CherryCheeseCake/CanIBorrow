package com.example.jdocter.can_i_borrow;

import android.app.Application;

import com.example.jdocter.can_i_borrow.model.Post;
import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(Post.class);

        final Parse.Configuration configuration = new Parse.Configuration.Builder(this)
                .applicationId("jd_parstagram")
                .clientKey("qwe123!@#")
                .server("http://jd-parstagram.herokuapp.com/parse")
                .build();

        Parse.initialize(configuration);
    }

}
