package com.example.zhenyux.lumohack2018;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class IntroFragment extends Fragment {

private TextView textView;
    public IntroFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_intro, container,false);
        ImageView imageView = (ImageView) view.findViewById(R.id.fragmentImage);
        textView = view.findViewById(R.id.txt_display);
        String message = getArguments().getString("message");
        int position = getArguments().getInt("integer");
        switch (position){
            case 0:
                imageView.setImageResource(R.drawable.stat);
                textView.setText("Towards the beginning of your career, you should get in the habit of starting to get into resilience" +
                        " training to prevent your mental health from deteriorating. As more time passes, this becomes especially important in trying to use whatever resilience you have left to get the most out of life.");
                break;
            default:
                imageView.setImageResource(R.drawable.info);
               // textView.setText("Think of at least 3 accomplishments from the last 7 days");
               // textView.setText("Think of at least 3 things you are thankful for from the last 7 days");
                textView.setText("Interesting Fact:\nEach year, 1 in 4 of us will experience issues with our mental health." +
                        "\n\nApproximately 1% of Canadian men and 2% of Canadian women are clinically depressed at some point in their lives."
                );
                break;
            case 2:
                imageView.setImageResource(R.drawable.dep);
                textView.setText("The severity of depression can vary from person to person but it is crucial to remember that it can lead to life-threatening outcomes. " +
                        "\n\nThe possible symptoms of clinical depression include sudden changes in mood, interest in activities, appetite, sleep, sexual desire, concentration, decision making, social contact, thoughts and hygiene." +
                        "\n\nIf at least 5 of the above symptoms persist for more than two weeks, please contact a mental health provider.");
        }
        //textView.setText(message);
        return view;
    }

}
