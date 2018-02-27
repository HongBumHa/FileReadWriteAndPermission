package kr.or.dgit.bigdata.filereadwriteandpermission;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_file);

        TextView textView = (TextView)findViewById(R.id.fileResult);

        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/myApp/myfile.txt");

        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuffer buffer = new StringBuffer();
            String line;
            while((line=reader.readLine()) !=null){
                buffer.append(line);
            }
            textView.setText(buffer.toString());
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
