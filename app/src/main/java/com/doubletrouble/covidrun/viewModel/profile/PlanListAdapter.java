package com.doubletrouble.covidrun.viewModel.profile;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.doubletrouble.covidrun.R;
import com.doubletrouble.covidrun.db.AppDatabase;
import com.doubletrouble.covidrun.model.Plan;

import java.util.List;

public class PlanListAdapter extends BaseAdapter {

    private final List<Plan> idsPlanesHechos;
    private final Context context;

    public PlanListAdapter(List<Plan> planes, Context context) {
        this.idsPlanesHechos = planes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return idsPlanesHechos.size();
    }

    @Override
    public Object getItem(int position) {
        return idsPlanesHechos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return idsPlanesHechos.get(position).getId();
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Plan plan = idsPlanesHechos.get(position);
        View convertedView;
        convertedView = LayoutInflater.from(context).inflate(R.layout.profile_planitem, null);
        TextView nombrePlan = (TextView) convertView.findViewById(R.id.nombrePlan);
        TextView descPlan = (TextView) convertView.findViewById(R.id.cuerpoPlan);

        nombrePlan.setText(plan.getShortName());
        String salida = plan.getDescription() + " (+" + Math.round(plan.getExperiencePoints()) + ")";
        descPlan.setText(salida);
        convertView = convertedView;
        return convertView;
    }
}
