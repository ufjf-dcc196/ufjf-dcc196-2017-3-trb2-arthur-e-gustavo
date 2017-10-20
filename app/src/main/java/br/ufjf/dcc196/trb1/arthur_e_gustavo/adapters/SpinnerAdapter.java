package br.ufjf.dcc196.trb1.arthur_e_gustavo.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.Comparator;
import java.util.List;

import br.ufjf.dcc196.trb1.arthur_e_gustavo.R;

public class SpinnerAdapter<T> extends ArrayAdapter<T> {

    private static final Comparator<? super Object> comparator = new Comparator<Object>() {
        public int compare(Object o1, Object o2) {
            return o1.toString().compareTo(o2.toString());
        }
    };

    public SpinnerAdapter(Context context, int resource, List<T> list) {
        super(context, resource, list);
        this.sort(comparator);
        list.add(0, (T) getContext().getResources().getString(R.string.spn_select));
    }

    @Override
    public boolean isEnabled(int position) {
        if (position == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View view = super.getDropDownView(position, convertView, parent);
        TextView tv = (TextView) view;
        if (position == 0) {
            tv.setTextColor(Color.GRAY);
        } else {
            tv.setTextColor(Color.BLACK);
        }
        return view;
    }

    public void finish() {
        this.remove(this.getItem(0));
    }
}