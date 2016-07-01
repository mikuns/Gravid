package com.demo.fragments;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import com.demo.gravid.ExpandableAdapter;
import com.demo.gravid.Item;
import com.demo.gravid.R;

public class QandA extends Fragment {
	ImageView image;
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

		View v = inflater.inflate(R.layout.fragment_qanda, container, false);


		ListView lvItems = (ListView) v.findViewById(R.id.lv_items);

		ExpandableAdapter adapter = getAdapter();

		lvItems.setAdapter(adapter);
		lvItems.setPadding(0, 0, 0, 0);
		lvItems.setBackgroundColor(getResources().getColor(R.color.text_title));
		lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				ExpandableAdapter adapter = (ExpandableAdapter) parent.getAdapter();

				Item item = (Item) adapter.getItem(position);
				if(item != null){
					if(item.isExpanded){
						item.isExpanded = false;

					}else{
						item.isExpanded = true;
					}
				}

				adapter.notifyDataSetChanged();
			}
		});

		return v;
	}

	private ExpandableAdapter getAdapter(){
		Resources res = getResources();
		String[] questions = res.getStringArray(R.array.questions_all);
		String[] answers = res.getStringArray(R.array.answers_all);




		List<Item> items = new ArrayList<>();

		for(int i = 0; i < 19; i++){
			Item item = new Item();
//			item.question = "Question " + i;
//			item.answer = "Answer "+ i;
			item.question = questions[i];
			item.answer = answers[i];


			item.isExpanded = false;

			items.add(item);
		}

		return new ExpandableAdapter(getActivity(), items);
	}
}


