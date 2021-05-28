package com.exam.namelist.view;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.exam.namelist.R;
import com.exam.namelist.model.PersonDetails;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    private ArrayList<PersonDetails> personDetails;
    private int i;
    public RecyclerViewAdapter(ArrayList<PersonDetails> personDetails) {
        this.personDetails = personDetails;
    }

    @NonNull
    @NotNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        View pView = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_details, parent, false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(pView);

        return recyclerViewHolder;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerViewAdapter.RecyclerViewHolder holder, int position) {
        i= position;

        holder.pLabel.setText("First Name:");
        holder.pDetail.setText(personDetails.get(position).getFname());

        holder.pLabelTwo.setText("Last Name:");
        holder.pDetailTwo.setText(personDetails.get(position).getLname());

        holder.pLabelThr.setText("Birthday:");
        holder.pDetailThr.setText(personDetails.get(position).getBday());

        holder.pLabelFur.setText("Age:");
        holder.pDetailFur.setText(String.valueOf(computeAge()));

        holder.pLabelFve.setText("Email Address:");
        holder.pDetailFve.setText(personDetails.get(position).getEmail());

        holder.pLabelSix.setText("Mobile Number:");
        holder.pDetailSix.setText(personDetails.get(position).getMobileNum());

        holder.pLabelSvn.setText("Address:");
        holder.pDetailSvn.setText(personDetails.get(position).getAddress());

        holder.pLabelEgt.setText("Contact Person:");
        holder.pDetailEgt.setText(personDetails.get(position).getCntctPrsn());

        holder.pLabelNne.setText("Contact Person's Phone Number:");
        holder.pDetailNne.setText(personDetails.get(position).getCntctPrsnNum());

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private int computeAge() {
        String getBday = personDetails.get(i).getBday();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
        LocalDate bdate = LocalDate.parse(getBday, formatter);

        LocalDate today = LocalDate.now();
        LocalDate birthday = bdate;

        Period p = Period.between(birthday, today);
        int age = p.getYears();
        return age;
    }

    @Override
    public int getItemCount() {
        return personDetails.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        public TextView pLabel;
        public TextView pDetail;
        public TextView pLabelTwo;
        public TextView pDetailTwo;
        public TextView pLabelThr;
        public TextView pDetailThr;
        public TextView pLabelFur;
        public TextView pDetailFur;
        public TextView pLabelFve;
        public TextView pDetailFve;
        public TextView pLabelSix;
        public TextView pDetailSix;
        public TextView pLabelSvn;
        public TextView pDetailSvn;
        public TextView pLabelEgt;
        public TextView pDetailEgt;
        public TextView pLabelNne;
        public TextView pDetailNne;


        public RecyclerViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            pLabel = (TextView)itemView.findViewById(R.id.label);
            pDetail = (TextView)itemView.findViewById(R.id.detail);
            pLabelTwo = (TextView)itemView.findViewById(R.id.label2);
            pDetailTwo = (TextView)itemView.findViewById(R.id.detail2);
            pLabelThr = (TextView)itemView.findViewById(R.id.label3);
            pDetailThr = (TextView)itemView.findViewById(R.id.detail3);
            pLabelFur = (TextView)itemView.findViewById(R.id.label4);
            pDetailFur = (TextView)itemView.findViewById(R.id.detail4);
            pLabelFve = (TextView)itemView.findViewById(R.id.label5);
            pDetailFve = (TextView)itemView.findViewById(R.id.detail5);
            pLabelSix = (TextView)itemView.findViewById(R.id.label6);
            pDetailSix = (TextView)itemView.findViewById(R.id.detail6);
            pLabelSvn = (TextView)itemView.findViewById(R.id.label7);
            pDetailSvn = (TextView)itemView.findViewById(R.id.detail7);
            pLabelEgt = (TextView)itemView.findViewById(R.id.label8);
            pDetailEgt = (TextView)itemView.findViewById(R.id.detail8);
            pLabelNne = (TextView)itemView.findViewById(R.id.label9);
            pDetailNne = (TextView)itemView.findViewById(R.id.detail9);

        }
    }
}
