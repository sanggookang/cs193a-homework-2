package com.example.sanggookang.myapplication;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import java.util.*;

public class ToDoList extends AppCompatActivity implements AdapterView.OnItemLongClickListener, AdapterView.OnItemClickListener {
    private ArrayList<String> ToDo;
    private ArrayAdapter<String> ToDoadapter;
    //Bundle SaveState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //onRestoreInstanceState(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);
        ListView TitleList = (ListView) findViewById(R.id.ToDoList);
        TitleList.setOnItemClickListener(this);
        TitleList.setOnItemLongClickListener(this);
        ToDo = new ArrayList<>();
        ToDoadapter = new ArrayAdapter<String>(this, R.layout.listlayout, R.id.itemTitle, ToDo);
        TitleList.setAdapter(ToDoadapter);
        ToDo.clear();
        ToDoadapter.notifyDataSetChanged();
    }

    public void addToDo(View view) {
        TextView input = (TextView) findViewById(R.id.Input);
        String text = input.getText().toString();
        if(ToDo.contains(text)){
            return;
        }
        ToDo.add(text);
        ToDoadapter.notifyDataSetChanged();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        ListView taskList = (ListView) findViewById(R.id.ToDoList);
        String text = taskList.getItemAtPosition(position).toString();
        if(!ToDo.contains(text)){
            return true;
        }
        ToDo.remove(text);
        ToDoadapter.notifyDataSetChanged();
        return true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList("ToDoList", ToDo);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        ToDo = savedInstanceState.getStringArrayList("ToDoList");
        ToDoadapter = new ArrayAdapter<String>(this, R.layout.listlayout, R.id.itemTitle, ToDo);
        ListView TitleList = (ListView) findViewById(R.id.ToDoList);
        TitleList.setAdapter(ToDoadapter);
        ToDoadapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        return;
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onStop() {
        super.onStop();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
