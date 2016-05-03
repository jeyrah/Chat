package com.example.ama.chat;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

/**
 * Created by Ama on 03.05.2016.
 */
public class Presenter {
    private Model mModel = new Model();
    private List<String> mListMessages = mModel.getListMessages();
    private Context view;

    public Presenter(Context c){
        view = c;
    }

    public void changeListMessage(ListView listView, ArrayAdapter<String> arrayAdapter){
        listView.setAdapter(arrayAdapter);
    }
    public List<String> getListMessages(){
        return mListMessages;
    }
    public void addMessageToListMessages(String s){
        mListMessages.add(s);
    }
    public ArrayAdapter<String> setAdapter(List<String> list){
        ArrayAdapter<String> listAdapter = new ArrayAdapter<>(
                view, android.R.layout.simple_list_item_1, list);
        return listAdapter;
    }

}
