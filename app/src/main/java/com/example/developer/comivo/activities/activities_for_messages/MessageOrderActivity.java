package com.example.developer.comivo.activities.activities_for_messages;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.developer.comivo.R;


public class MessageOrderActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_order_activity);
        initViews();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);

        SearchManager searchManager = (SearchManager) MessageOrderActivity.this.getSystemService(Context.SEARCH_SERVICE);

        SearchView searchView = null;
        if (searchItem != null) {
            searchView = (SearchView) searchItem.getActionView();
        }

        if (searchView != null) {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(MessageOrderActivity.this.getComponentName()));
        }

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return super.onOptionsItemSelected(item);
    }

    private void initViews(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_tool_bar);
        TextView tittle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        tittle.setText(R.string.order_benzoic);
        ImageView leftButton = (ImageView) toolbar.findViewById(R.id.left_button);
        ImageView sendMess = (ImageView) findViewById(R.id.send_mess);

        RelativeLayout lay111 = (RelativeLayout) findViewById(R.id.relativeLayout111);
        RelativeLayout lay222 = (RelativeLayout) findViewById(R.id.relativeLayout222);

        LinearLayout info4 = (LinearLayout) findViewById(R.id.info_layout4);
        final ImageView iv_info = (ImageView) findViewById(R.id.iv_info);
        LinearLayout btnLayout2 = (LinearLayout) findViewById(R.id.layout_for_buttons2);

        final LinearLayout layout_for_pending = (LinearLayout) findViewById(R.id.layout_for_pending);
        final LinearLayout layout_for_signed = (LinearLayout) findViewById(R.id.layout_for_signed);
        final LinearLayout layout_for_process = (LinearLayout) findViewById(R.id.layout_for_process);
        final LinearLayout layout_for_closed = (LinearLayout) findViewById(R.id.layout_for_closed);

        final TextView pending_tv = (TextView) findViewById(R.id.pending_tv);
        final TextView signed_tv = (TextView) findViewById(R.id.signed_tv);
        final TextView process_tv = (TextView) findViewById(R.id.process_tv);
        final TextView closed_tv = (TextView) findViewById(R.id.closed_tv);

        final ImageView imageView92 = (ImageView) findViewById(R.id.imageView92);
        final ImageView imageView93 = (ImageView) findViewById(R.id.imageView93);
        final ImageView imageView94 = (ImageView) findViewById(R.id.imageView94);

        leftButton.setImageResource(R.drawable.ic_icon_arrow);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);




        lay111.setVisibility(View.VISIBLE);
        lay222.setVisibility(View.VISIBLE);

        info4.setVisibility(View.VISIBLE);
        btnLayout2.setVisibility(View.VISIBLE);

        iv_info.setClickable(false);
        info4.setClickable(false);

        layout_for_pending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout_for_pending.setBackgroundColor(getResources().getColor(R.color.green_color));
                pending_tv.setTextColor(getResources().getColor(R.color.white_color));
                layout_for_signed.setClickable(true);
                layout_for_process.setClickable(false);
                layout_for_closed.setClickable(false);
            }
        });

        layout_for_signed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout_for_signed.setBackgroundColor(getResources().getColor(R.color.green_color));
                signed_tv.setTextColor(getResources().getColor(R.color.white_color));
                imageView92.setVisibility(View.VISIBLE);
                layout_for_process.setClickable(true);
                layout_for_pending.setClickable(false);
                layout_for_closed.setClickable(false);

            }
        });

        layout_for_process.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout_for_process.setBackgroundColor(getResources().getColor(R.color.green_color));
                process_tv.setTextColor(getResources().getColor(R.color.white_color));
                imageView93.setVisibility(View.VISIBLE);
                layout_for_closed.setClickable(true);
                layout_for_pending.setClickable(false);
                layout_for_signed.setClickable(false);
            }
        });

        layout_for_closed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout_for_closed.setBackgroundColor(getResources().getColor(R.color.green_color));
                closed_tv.setTextColor(getResources().getColor(R.color.white_color));
                imageView94.setVisibility(View.VISIBLE);
                layout_for_process.setClickable(false);
                layout_for_pending.setClickable(false);
                layout_for_signed.setClickable(false);
                iv_info.setClickable(true);

                iv_info.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MessageOrderActivity.this, MessageOrderDetailActivity.class);
                        startActivity(intent);
                    }
                });

            }
        });



        sendMess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MessageOrderActivity.this, R.string.options_in, Toast.LENGTH_SHORT).show();
            }
        });

        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MessageOrderActivity.this, MessageOfferActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
