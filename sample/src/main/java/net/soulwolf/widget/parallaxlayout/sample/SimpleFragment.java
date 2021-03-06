/**
 * <pre>
 * Copyright (C) 2015  Soulwolf Universal-PullToZoomView
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </pre>
 */
package net.soulwolf.widget.parallaxlayout.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import net.soulwolf.widget.parallaxlayout.ParallaxLayoutPresenter;
import net.soulwolf.widget.parallaxlayout.widget.ParallaxListView;

/**
 * author : Soulwolf Create by 2015/7/30 17:12
 * email  : ToakerQin@gmail.com.
 */
public class SimpleFragment extends Fragment {

    static final String POSITION = "position";

    ParallaxListView mListView;

    int mPosition;

    public static SimpleFragment newInstance(int position){
        SimpleFragment instance = new SimpleFragment();
        Bundle args = new Bundle();
        args.putInt(POSITION,position);
        instance.setArguments(args);
        return instance;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPosition = getArguments().getInt(POSITION);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.simple_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mListView = (ParallaxListView) view.findViewById(R.id.list1);
        ParallaxLayoutPresenter.attachParallaxScrollable(getActivity(),mPosition,mListView);
        mListView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return 50;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView textView;
                if(convertView == null){
                    textView = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.simple_text,null);
                }else {
                    textView = (TextView) convertView;
                }
                textView.setText("SimpleFragment : " + position + ",pager:" + mPosition);
                return textView;
            }
        });
    }


}
