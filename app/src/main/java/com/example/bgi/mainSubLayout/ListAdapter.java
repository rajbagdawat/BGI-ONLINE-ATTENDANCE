//package com.example.bgi.mainSubLayout;
//
//import android.content.Context;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.CheckBox;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//
//import com.example.bgi.R;
//
//import java.util.ArrayList;
//
//public class ListAdapter extends ArrayAdapter<String> {
//    Context context;
//    int[] imageId = {R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r};
//    String[] stuname = {"Raj Bagdawat", "Ravi", "Raja", "Rajesh ", "Ramu", "Ravan", "Patel", "Illiya", "Vedant", "Kinara", "Vebhav", "Ravan", "Rajput", "Shubham", "Hitakshi", "Chetan", "Shyam", "Himanshu", "Kala", "Mahesh", "Rajaaa", "Rama", "Raj Bagdawat", "Ravi", "Raja", "Rajesh ", "Ramu", "Ravan", "Patel", "Illiya", "Vedant", "Kinara", "Vebhav", "Ravan", "Rajput", "Shubham", "Hitakshi", "Chetan", "Shyam", "Himanshu", "Kala", "Mahesh", "Rajaaa", "Rama"};
//    String[] stuenroll = {"0834CS201001", "0834CS201002", "0834CS201003", "0834CS201004", "0834CS201005", "0834CS201006", "0834CS201007", "0834CS201008", "0834CS201009", "0834CS201010", "0834CS201011", "0834CS201012", "0834CS201013", "0834CS201014", "0834CS201015", "0834CS201016", "0834CS201017", "0834CS201018", "0834CS201019", "0834CS201020", "0834CS201021", "0834CS201022", "0834CS201023", "0834CS201024", "0834CS201025", "0834CS201026", "0834CS201027", "0834CS201028", "0834CS201029", "0834CS201030", "0834CS201031", "0834CS201032", "0834CS201033", "0834CS201034", "0834CS201035", "0834CS201036", "0834CS201037", "0834CS201038", "0834CS201039", "0834CS201040", "0834CS201041", "0834CS201042", "0834CS201043", "0834CS201044"};
//    String[] stuphone = {"0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000"};
//    String[] stuaddress = {"XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ"};
//    CheckBox checkBox;
//    ArrayList<String> altextView1;
//    ArrayList<String> altextView2;
////    public ListAdapter(Context context, int[] image, String name , String enroll , String phoneno , String address) {
////        super(context);
////        this.context = context;
////        this.imageId = image;
////    }
//
//    public ListAdapter(Context c, CheckBox checkBox, ArrayList<String> textView1, ArrayList<String> textView2) {
//        super();
//
//        this.context=c;
//        this.checkBox=checkBox;
//        this.altextView1=textView1;
//        this.altextView2=textView2;
//    }
//
//    @Override
//    public int getCount() {
//        // TODO Auto-generated method stub
//        return altextView1.size();
//    }
//
//    @Override
//    public Object getItem(int arg0) {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    @Override
//    public long getItemId(int arg0) {
//        // TODO Auto-generated method stub
//        return 0;
//    }
//
//    @Override
//    public View getView(int arg0, View arg1, ViewGroup arg2) {
//        // TODO Auto-generated method stub
//
//        View view=arg1;
//        view=LayoutInflater.from(context).inflate(R.layout.list7, null);
//
//        TextView tv1=(TextView)view.findViewById(R.id.tV1);
//        TextView tv2=(TextView)view.findViewById(R.id.tV2);
//        btnView=(Button)findViewById(R.id.btnView);
//        box=(CheckBox)findViewById(R.id.cB);
//
//        tv1.setText(altextView1.get(arg0));
//        tv2.setText(altextView2.get(arg0));
//
//
//        return view;
//    }
//
//
//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);
//    }
//}
