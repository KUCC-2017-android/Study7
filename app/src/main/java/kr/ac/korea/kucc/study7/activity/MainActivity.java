package kr.ac.korea.kucc.study7.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import kr.ac.korea.kucc.study7.R;
import kr.ac.korea.kucc.study7.adapter.ItemAdapter;
import kr.ac.korea.kucc.study7.fragment.AddDialogFragment;
import kr.ac.korea.kucc.study7.fragment.InfoDialogFragment;

public class MainActivity extends AppCompatActivity {

    private List<String> itemList = new ArrayList<>();
    private ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        adapter = new ItemAdapter(itemList);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.item_list);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    public void onResultButtonClick(View v) {
        if (itemList.size() == 0) {
            Toast.makeText(this, "리스트가 비어있습니다", Toast.LENGTH_LONG).show();
            return;
        }

        Random random = new Random();
        String result = itemList.get(random.nextInt(itemList.size()));
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra(ResultActivity.KEY_RESULT, result);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                makeAddDialog();
                return true;

            case R.id.action_info:
                makeInfoDialog();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void makeAddDialog() {
        AddDialogFragment fragment = new AddDialogFragment();
        fragment.setOnPositiveButtonClickListener(new AddDialogFragment.OnPositiveButtonClickListener() {
            @Override
            public void onPositiveButtonClick(String result) {
                itemList.add(0, result);
                adapter.notifyItemInserted(0);
            }
        });
        fragment.show(getSupportFragmentManager(), "info");
    }

    private void makeInfoDialog() {
        InfoDialogFragment fragment = new InfoDialogFragment();
        fragment.show(getSupportFragmentManager(), "info");
    }
}
