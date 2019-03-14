package com.example.zhenyux.lumohack2018;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.zhenyux.lumohack2018.classes.Message;

import java.util.List;

public class botActivity extends AppCompatActivity {
    Message message;
    Handler handler = new Handler();
    EditText responseText;
    Button sendbtn;
    String response;
    ListView messageListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bot);

        message = Message.getInstance();
        responseText =  (EditText) findViewById(R.id.botActivityInputText);
        sendbtn= (Button) findViewById(R.id.botActivitySendBtn);
        messageListView = (ListView) findViewById(R.id.botActivityMessageList);

        if (message.getMessageNumber() == -1) {
            setMessage("Hello", 0);
            handler.postDelayed(new Runnable() {
                public void run() {
                    setMessage("Please answer yes or no for the following questions", 0);
                    afterIntro();
                }
            }, 800);
        }
        else{
            message.setMessageNumber(message.getMessageNumber()-1);
            afterIntro();
        }

    }

    private void afterIntro(){
        setBtn();
        wait_and_ask();
    }

    private void wait_and_ask() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                askQuestion();
            }
        }, 800);
    }

    private void setBtn() {
        sendbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                response = responseText.getText().toString();
                setMessage(response, 1);
                message.setMessageNumber(message.getMessageNumber()-1);
                responseText.getText().clear();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (response.equals("yes")){
                            setMessage("Great", 0);
                        }
                        else if (response.equals("no")){
                            String answer = findRightResponse();
                            setMessage(answer, 0);
                        }
                        else{
                            setMessage("Please answer yes or no", 0);
                            message.setMessageNumber(message.getMessageNumber()-1);
                        }
                        message.setMessageNumber(message.getMessageNumber()-1);
                        wait_and_ask();
                    }
                }, 800);
            }
        });
    }

    private String findRightResponse() {
        String string;
        switch(message.getMessageNumber()){
            case 2:
                string = "Make sure to get 7-8 hours of sleep every night.";
                break;
            case 3:
                string = "Ensure that you follow a balanced and nutritious diet without eating too little or too much.";
                break;
            case 4:
                string = "Dedicate at least an hour a day for your hobbies.";
                break;
            case 5:
                string = "Go out there and meet people but also subject them to enough scrutiny." +
                        " It will take time. Also, be sure to discuss things with your colleagues.";
                break;
            case 6:
                string = "Spend some time everyday trying new things — " +
                        "maybe you will be able to find something you like and maybe get a new career path!";
                break;
            case 7:
                string = "Please seek a counsellor for further advice on your sleep habits.";
                break;
            case 8:
                string = "Visit your local place of worship or spiritual leader for advice or perhaps try meditation.";
                break;
            default:
                string ="";
                break;
        }
        return string;
    }

    public void askQuestion(){
        String string;
        switch (message.getMessageNumber()){
            case 1:
                string = "Have you been getting enough sleep?";
                break;
            case 2:
                string = "Have you been eating well?";
                break;
            case 3:
                string = "Have you been making time for personal things?";
                break;
            case 4:
                string = "Do you feel like you have friends that can rely on?";
                break;
            case 5:
                string = "Are there things about your job that makes you feel as if it is not right for you?";
                break;
            case 6:
                string = "Has your job been inferfering with your sleep?";
                break;
            case 7:
                string = "Is are you feeling well in the spiritual sense? If spiritual well-being is not as important" +
                        " to you, answer 'yes'";
                break;
            default:
                string = "";
                break;
        }
        if (!string.equals("")) {
            setMessage(string, 0);
        }
    }

    public void showListView(){
        List<String> messageList = message.getMessageList();
        myListAdapter adapter = new myListAdapter(this, messageList);
        messageListView.setAdapter(adapter);
    }

    public class myListAdapter extends BaseAdapter{
        private Context context;
        private List<String> items;

        public myListAdapter(Context context, List<String> items){
            this.context = context;
            this.items = items;
        }
        @Override
        public int getViewTypeCount() {
            return 2;
        }

        @Override
        public int getItemViewType(int position) {
            return message.getMessageType(position);
        }

        @Override
        public Object getItem(int i) {
            return items.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            int type = getItemViewType(position);
            TextView textView;
            if (v == null){
                if (type == 0){
                    v = LayoutInflater.from(context).inflate(R.layout.mylistviewbot, parent, false);
                }
                else{
                    v = LayoutInflater.from(context).inflate(R.layout.mylistviewuser, parent, false);
                }
            }
            if (type == 0){
                textView = (TextView) v.findViewById(R.id.mylistviewbot_Text);
            }
            else{
                textView = (TextView) v.findViewById(R.id.mylistviewuser_Text);
            }
            String currentItem = (String) getItem(position);
            textView.setText(currentItem);
            return v;
        }
    }
    public void setMessage(String messageString, int message_number){
        message.setMessageList(messageString);
        message.setMessageType(message_number);
        message.setMessageNumber(message.getMessageNumber()+1);
        showListView();
        scrollMyListViewToBottom();
    }

    private void scrollMyListViewToBottom() {
        messageListView.post(new Runnable() {
            @Override
            public void run() {
                messageListView.setSelection(messageListView.getCount()-1);
            }
        });
    }

    static public Intent makeLaunchIntent(Context context){
        Intent intent = new Intent(context,botActivity.class);
        return intent;
    }
}
