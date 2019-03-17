package com.example.vikas.NewsApp.fragement;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.vikas.NewsApp.R;
import com.example.vikas.NewsApp.adpter.NoticeAdapter;
import com.example.vikas.NewsApp.news.NewsMvpView;
import com.example.vikas.NewsApp.news.NewsPresenterImpl;
import com.example.vikas.NewsApp.pojo.Sources;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link NewsCategoryFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link NewsCategoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewsCategoryFragment extends Fragment implements NewsMvpView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public NewsPresenterImpl newsPresenter;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    String category;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ProgressBar progressBar;
    public NewsCategoryFragment() {
        // Required empty public constructor
    }
    public NewsCategoryFragment(String category) {
        this.category = category;
    }


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NewsCategoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NewsCategoryFragment newInstance(String param1, String param2) {
        NewsCategoryFragment fragment = new NewsCategoryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return view(inflater.inflate(R.layout.fragment_news_category, container, false));
    }

    private View view(View inflate) {
        recyclerView = (RecyclerView) inflate.findViewById(R.id.recyclerView);
        swipeRefreshLayout = (SwipeRefreshLayout) inflate.findViewById(R.id.swiperefresh);
        progressBar = (ProgressBar) inflate.findViewById(R.id.progressBar);
        newsPresenter = new NewsPresenterImpl(this);
        newsPresenter.getData(category);
        swipeRefreshLayout.setRefreshing(false);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(true);
                newsPresenter.getData(category);
            }
        });
        return inflate;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);


    }

    @Override
    public void dismissProgress() {
        progressBar.setVisibility(View.GONE);
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void bindDataList(List<Sources> list) {
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        NoticeAdapter adapter = new NoticeAdapter(list, getContext());
        recyclerView.setAdapter(adapter);
        dismissProgress();
        //  Toast.makeText(this, category+" Data updated", Toast.LENGTH_SHORT).show();

    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
