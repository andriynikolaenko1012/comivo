package com.example.developer.comivo.activities.activities_for_sellers_acc;

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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.developer.comivo.R;
import com.example.developer.comivo.activities.activities_for_messages.MessageActivity;
import com.example.developer.comivo.activities.activities_for_messages.MessageOfferDetailsActivity;
import com.example.developer.comivo.activities.activities_for_messages.MessageOrderActivity;
import com.example.developer.comivo.activities.activities_for_messages.MessageRemindingActivity;


public class OpportunityDetailsActivity extends AppCompatActivity{

    public RelativeLayout relative_666;
    public TextView tv_666, tv_react2;
    public Button btn_ignore22, btn_request22;
    public LinearLayout linear_react2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opportunity_details);
        initViews();


    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);

        SearchManager searchManager = (SearchManager) OpportunityDetailsActivity.this.getSystemService(Context.SEARCH_SERVICE);

        SearchView searchView = null;
        if (searchItem != null) {
            searchView = (SearchView) searchItem.getActionView();
        }

        if (searchView != null) {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(OpportunityDetailsActivity.this.getComponentName()));
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
        tittle.setText(R.string.opportunities);
        ImageView leftButton = (ImageView) toolbar.findViewById(R.id.left_button);

        leftButton.setImageResource(R.drawable.ic_icon_arrow);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        relative_666 = (RelativeLayout) findViewById(R.id.relative_666);
        tv_666 = (TextView) findViewById(R.id.tv_666);
        btn_ignore22 = (Button) findViewById(R.id.btn_ignore22);
        btn_request22 = (Button) findViewById(R.id.btn_request22);
        linear_react2 = (LinearLayout) findViewById(R.id.linear_react2);
        tv_react2 = (TextView) findViewById(R.id.tv_react2);

        btn_ignore22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_request22.setClickable(false);
                relative_666.setVisibility(View.GONE);
                tv_666.setVisibility(View.GONE);
                btn_request22.setBackgroundColor(getResources().getColor(R.color.colorSecondary));
                btn_ignore22.setBackgroundColor(getResources().getColor(R.color.colorSecondary));

                linear_react2.setVisibility(View.VISIBLE);

            }
        });

        tv_react2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_request22.setClickable(false);
                relative_666.setVisibility(View.VISIBLE);
                tv_666.setVisibility(View.VISIBLE);
                btn_request22.setBackgroundColor(getResources().getColor(R.color.colorMain));
                btn_ignore22.setBackgroundColor(getResources().getColor(R.color.colorMain));

                linear_react2.setVisibility(View.GONE);
            }
        });

        btn_request22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OpportunityDetailsActivity.this, OpportunityUpdateQuoteActivity.class);
                startActivity(intent);
                finish();
            }
        });

        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OpportunityDetailsActivity.this, SellersAccActivity.class);
                startActivity(intent);
                finish();
            }
        });



    }
}
