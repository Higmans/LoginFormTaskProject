package lungo.biz.LoginFormTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    int counter = 0;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.generatedPassword);
    }
    public void onClick(View view) {
        if (counter%2 == 0)
            text.setText(generatePasswordA());
        else
            text.setText(generatePasswordB());
        counter++;
    }

    private String generatePasswordB() {
        StringBuilder passwordBuilder = new StringBuilder();
        int length = 13;
        for (int i = 0; i < length; i++){
            if (i == 5 || i == 8)
                passwordBuilder.append('-');
            else{
                char newChar = (char) ((int)(Math.random() * (126 - 33) + 33));
                if ((passwordBuilder + "").contains(newChar + "")){
                    i--;
                    continue;
                }
                passwordBuilder.append(newChar);
            }
        }
        return passwordBuilder + "";
    }

    private String generatePasswordA() {
        int length = (int) ((Math.random() * (10 - 5) + 5));
        StringBuilder passwordBuilder = new StringBuilder();
        for (int i = 0; i < length; i++){
            passwordBuilder.append((char) ((int)(Math.random() * (127 - 33) + 33)));
        }
        return passwordBuilder + "";
    }
}
