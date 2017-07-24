package pe.edu.upc.quyawar.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.List;

import pe.edu.upc.quyawar.R;

/**
 * Created by pcfx on 23/07/2017.
 */

public class BloodTypeAdapter extends BaseAdapter implements SpinnerAdapter {
    private List<String> items;
    private List<Long> values;
    private Activity activity;
    Context context;

    public BloodTypeAdapter(Context context) {
        this.context = context;
    }
    public void setItems(List<String> items) {
        this.items = items;
    }

    public void setValues(List<Long> values) {
        this.values = values;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public String getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int pos) {
        return values.get(pos);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView text = new TextView(context);
        text.setTextColor(Color.BLACK);
        text.setText(items.get(position));
        return text;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        TextView text = new TextView(context);
        text.setTextColor(Color.BLACK);
        text.setText(String.valueOf(items.get(position)));
        return text;
    }
}
