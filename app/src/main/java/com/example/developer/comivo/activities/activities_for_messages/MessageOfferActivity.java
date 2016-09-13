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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.developer.comivo.R;


public class MessageOfferActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_offer_activity);
        initViews();


    }


    private void initViews(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_tool_bar);
        TextView tittle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        tittle.setText(R.string.quote_benzoic);
        ImageView rightButton = (ImageView) findViewById(R.id.right_button);
        rightButton.setImageResource(R.drawable.ic_search_button);
        ImageView leftButton = (ImageView) toolbar.findViewById(R.id.left_button);
        leftButton.setImageResource(R.drawable.ic_icon_arrow);
        ImageView sendMess = (ImageView) findViewById(R.id.send_mess);


        final RelativeLayout tony_sit_layout = (RelativeLayout) findViewById(R.id.tony_sit_layout);
        final RelativeLayout lay111 = (RelativeLayout) findViewById(R.id.relativeLayout111);
        final RelativeLayout lay222 = (RelativeLayout) findViewById(R.id.relativeLayout222);
        final RelativeLayout lay333 = (RelativeLayout) findViewById(R.id.relativeLayout333);

        final LinearLayout info = (LinearLayout) findViewById(R.id.info_layout);
        final ImageView iv_info = (ImageView) findViewById(R.id.iv_info);
        final LinearLayout btnLayout = (LinearLayout) findViewById(R.id.btn_layout);


        final TextView change_price = (TextView) findViewById(R.id.change_price);
        final TextView change_price2 = (TextView) findViewById(R.id.change_price2);
        final TextView change_price3 = (TextView) findViewById(R.id.change_price3);
        final TextView change_price4 = (TextView) findViewById(R.id.change_price4);

        final ImageView iv_change = (ImageView) findViewById(R.id.iv_change);
        final ImageView iv_change2 = (ImageView) findViewById(R.id.iv_change2);

        final ImageView offer1 = (ImageView) findViewById(R.id.offer1);
        final ImageView offer2 = (ImageView) findViewById(R.id.offer2);
        final ImageView offer3 = (ImageView) findViewById(R.id.offer3);

        final Button btn_ignore = (Button) findViewById(R.id.btn_ignore);
        final Button btn_request = (Button) findViewById(R.id.btn_request);
        final Button btn_make_order = (Button) findViewById(R.id.btn_make_order);

        offer1.setImageResource(R.drawable.ic_online_status);
        offer2.setImageResource(R.drawable.ic_offline_status);
        offer3.setImageResource(R.drawable.ic_offline_status);

        info.setClickable(true);
        iv_info.setClickable(true);

        iv_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MessageOfferActivity.this, MessageOfferDetailsActivity.class);
                startActivity(intent);
            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MessageOfferActivity.this, MessageOfferDetailsActivity.class);
                startActivity(intent);
            }
        });

        btn_request.setClickable(true);
        btn_request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MessageOfferActivity.this, MessageRemindingActivity.class);
                startActivity(intent);
            }
        });

        btn_make_order.setClickable(true);
        btn_make_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MessageOfferActivity.this, MessageOrderActivity.class);
                startActivity(intent);
            }
        });

        btn_ignore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_ignore.setBackgroundColor(getResources().getColor(R.color.colorBackground));
                btn_ignore.setClickable(false);
                btn_request.setBackgroundColor(getResources().getColor(R.color.colorBackground));
                btn_request.setClickable(false);
                btn_make_order.setBackgroundColor(getResources().getColor(R.color.colorBackground));
                btn_make_order.setClickable(false);


                btn_request.setText(R.string.request_update);

                info.setClickable(false);
                offer1.setClickable(false);
                iv_info.setClickable(false);

                tony_sit_layout.setVisibility(View.VISIBLE);
                lay333.setVisibility(View.VISIBLE);
                info.setVisibility(View.VISIBLE);
                lay111.setVisibility(View.GONE);
                lay222.setVisibility(View.GONE);

                btnLayout.setVisibility(View.VISIBLE);

                change_price.setText("$1010.00/Ton");
                change_price2.setVisibility(View.VISIBLE);
                change_price2.setTextColor(getResources().getColor(R.color.text_color_up));
                iv_change.setVisibility(View.VISIBLE);
                iv_change.setImageResource(R.drawable.ic_up);

                change_price3.setText("$100.000.00");
                change_price4.setVisibility(View.VISIBLE);
                change_price4.setTextColor(getResources().getColor(R.color.text_color_up));
                iv_change2.setVisibility(View.VISIBLE);
                iv_change2.setImageResource(R.drawable.ic_up);

            }
        });

        offer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                offer1.setImageResource(R.drawable.ic_offline_status);
                offer2.setImageResource(R.drawable.ic_online_status);
                offer3.setImageResource(R.drawable.ic_offline_status);

                btn_request.setText(R.string.request_update);

                tony_sit_layout.setVisibility(View.GONE);
                lay333.setVisibility(View.GONE);
                lay111.setVisibility(View.VISIBLE);
                lay222.setVisibility(View.VISIBLE);
                info.setVisibility(View.VISIBLE);


                info.setClickable(true);
                offer1.setClickable(true);
                iv_info.setClickable(true);

                btnLayout.setVisibility(View.VISIBLE);


                iv_info.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        btnLayout.setVisibility(View.GONE);
                        info.setVisibility(View.GONE);

                        offer1.setImageResource(R.drawable.ic_online_status);
                        offer2.setImageResource(R.drawable.ic_offline_status);
                        offer3.setImageResource(R.drawable.ic_offline_status);

                        Intent intent = new Intent(MessageOfferActivity.this, MessageOfferDetailsActivity.class);
                        startActivity(intent);
                    }
                });

                info.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        btnLayout.setVisibility(View.GONE);

                        info.setVisibility(View.GONE);

                        offer1.setImageResource(R.drawable.ic_online_status);
                        offer2.setImageResource(R.drawable.ic_offline_status);
                        offer3.setImageResource(R.drawable.ic_offline_status);

                        Intent intent = new Intent(MessageOfferActivity.this, MessageOfferDetailsActivity.class);
                        startActivity(intent);
                    }
                });

                btn_ignore.setBackgroundColor(getResources().getColor(R.color.colorMain));
                btn_ignore.setClickable(true);
                btn_request.setBackgroundColor(getResources().getColor(R.color.colorMain));
                btn_request.setClickable(true);
                btn_make_order.setBackgroundColor(getResources().getColor(R.color.colorMain));
                btn_make_order.setClickable(true);

                change_price.setText("$990.00/Ton");
                change_price2.setVisibility(View.VISIBLE);
                change_price2.setTextColor(getResources().getColor(R.color.text_color_down));
                iv_change.setVisibility(View.VISIBLE);
                iv_change.setImageResource(R.drawable.ic_down);

                change_price3.setText("$99.000.00");
                change_price4.setVisibility(View.VISIBLE);
                change_price4.setTextColor(getResources().getColor(R.color.text_color_down));
                iv_change2.setVisibility(View.VISIBLE);
                iv_change2.setImageResource(R.drawable.ic_down);

                btn_request.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MessageOfferActivity.this, MessageRemindingActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });

        offer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                offer1.setImageResource(R.drawable.ic_offline_status);
                offer2.setImageResource(R.drawable.ic_offline_status);
                offer3.setImageResource(R.drawable.ic_online_status);

                btn_request.setText(R.string.request_update);

                tony_sit_layout.setVisibility(View.VISIBLE);
                lay333.setVisibility(View.VISIBLE);
                lay111.setVisibility(View.GONE);
                lay222.setVisibility(View.GONE);

                info.setVisibility(View.VISIBLE);

                btnLayout.setVisibility(View.VISIBLE);

                info.setClickable(true);
                offer1.setClickable(true);
                iv_info.setClickable(true);

                iv_info.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        btnLayout.setVisibility(View.GONE);

                        info.setVisibility(View.GONE);

                        offer1.setImageResource(R.drawable.ic_online_status);
                        offer2.setImageResource(R.drawable.ic_offline_status);
                        offer3.setImageResource(R.drawable.ic_offline_status);

                        Intent intent = new Intent(MessageOfferActivity.this, MessageOfferDetailsActivity.class);
                        startActivity(intent);
                    }
                });

                info.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        btnLayout.setVisibility(View.GONE);

                        info.setVisibility(View.GONE);

                        offer1.setImageResource(R.drawable.ic_online_status);
                        offer2.setImageResource(R.drawable.ic_offline_status);
                        offer3.setImageResource(R.drawable.ic_offline_status);

                        Intent intent = new Intent(MessageOfferActivity.this, MessageOfferDetailsActivity.class);
                        startActivity(intent);
                    }
                });

                btn_ignore.setBackgroundColor(getResources().getColor(R.color.colorMain));
                btn_ignore.setClickable(true);
                btn_request.setBackgroundColor(getResources().getColor(R.color.colorMain));
                btn_request.setClickable(true);
                btn_make_order.setBackgroundColor(getResources().getColor(R.color.colorMain));
                btn_make_order.setClickable(true);

                change_price.setText("$1010.00/Ton");
                change_price2.setVisibility(View.VISIBLE);
                change_price2.setTextColor(getResources().getColor(R.color.text_color_up));
                iv_change.setVisibility(View.VISIBLE);
                iv_change.setImageResource(R.drawable.ic_up);

                change_price3.setText("$100.000.00");
                change_price4.setVisibility(View.VISIBLE);
                change_price4.setTextColor(getResources().getColor(R.color.text_color_up));
                iv_change2.setVisibility(View.VISIBLE);
                iv_change2.setImageResource(R.drawable.ic_up);

                btn_request.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MessageOfferActivity.this, MessageRemindingActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });

        offer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                offer1.setImageResource(R.drawable.ic_online_status);
                offer2.setImageResource(R.drawable.ic_offline_status);
                offer3.setImageResource(R.drawable.ic_offline_status);

                btn_request.setText(R.string.request_update);

                tony_sit_layout.setVisibility(View.VISIBLE);
                lay333.setVisibility(View.VISIBLE);
                lay111.setVisibility(View.GONE);
                lay222.setVisibility(View.GONE);

                info.setVisibility(View.VISIBLE);

                btnLayout.setVisibility(View.VISIBLE);

                info.setClickable(true);
                offer1.setClickable(true);
                iv_info.setClickable(true);

                iv_info.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        btnLayout.setVisibility(View.GONE);

                        offer1.setImageResource(R.drawable.ic_online_status);
                        offer2.setImageResource(R.drawable.ic_offline_status);
                        offer3.setImageResource(R.drawable.ic_offline_status);

                        Intent intent = new Intent(MessageOfferActivity.this, MessageOfferDetailsActivity.class);
                        startActivity(intent);
                    }
                });

                info.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        btnLayout.setVisibility(View.GONE);

                        offer1.setImageResource(R.drawable.ic_online_status);
                        offer2.setImageResource(R.drawable.ic_offline_status);
                        offer3.setImageResource(R.drawable.ic_offline_status);

                        Intent intent = new Intent(MessageOfferActivity.this, MessageOfferDetailsActivity.class);
                        startActivity(intent);
                    }
                });

                btn_ignore.setBackgroundColor(getResources().getColor(R.color.colorMain));
                btn_ignore.setClickable(true);
                btn_request.setBackgroundColor(getResources().getColor(R.color.colorMain));
                btn_request.setClickable(true);
                btn_make_order.setBackgroundColor(getResources().getColor(R.color.colorMain));
                btn_make_order.setClickable(true);

                change_price.setText("$1010.00/Ton");
                change_price2.setVisibility(View.VISIBLE);
                change_price2.setTextColor(getResources().getColor(R.color.text_color_up));
                iv_change.setVisibility(View.VISIBLE);
                iv_change.setImageResource(R.drawable.ic_up);

                change_price3.setText("$100.000.00");
                change_price4.setVisibility(View.VISIBLE);
                change_price4.setTextColor(getResources().getColor(R.color.text_color_up));
                iv_change2.setVisibility(View.VISIBLE);
                iv_change2.setImageResource(R.drawable.ic_up);

                btn_request.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MessageOfferActivity.this, MessageRemindingActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });

        leftButton.setImageResource(R.drawable.ic_icon_arrow);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        sendMess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MessageOfferActivity.this, R.string.options_in, Toast.LENGTH_SHORT).show();
            }
        });

        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MessageOfferActivity.this, MessageActivity.class);
                startActivity(intent);
                finish();
            }
        });



    }
}
