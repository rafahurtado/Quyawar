package pe.edu.upc.quyawar.adapters;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.quyawar.models.Local;

/**
 * Created by rhurtado on 25/07/2017.
 */

public class LocalsAdapter implements SpinnerAdapter {

    private List<Local> locals;

    public LocalsAdapter setLocals(List<Local> locals) {
        this.locals = locals;
        return this;
    }

    public LocalsAdapter() {
        this.locals = new ArrayList<>();
    }

    @Override
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        return null;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public int getCount() {
        return locals.size();
    }

    @Override
    public Object getItem(int i) {
        return locals.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }

    @Override
    public int getItemViewType(int i) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return locals.size()==0;
    }
}
