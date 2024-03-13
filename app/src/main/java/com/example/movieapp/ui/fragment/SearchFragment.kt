package com.example.movieapp.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.databinding.FragmentSearchBinding
import com.example.movieapp.ui.activity.DetailMovieActivity
import com.example.movieapp.ui.adapter.PosterMovieAdapter
import com.example.movieapp.ui.dialog.LoadingProgressDialog
import com.example.movieapp.ui.listener.MovieRecyclerListener
import com.example.movieapp.util.Constants
import com.example.movieapp.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment(), MovieRecyclerListener {

    private lateinit var binding: FragmentSearchBinding
    private lateinit var loadingProgressDialog: LoadingProgressDialog
    private lateinit var searchMovieAdapter: PosterMovieAdapter
    private lateinit var progressBar: LoadingProgressDialog
    private var adatperFlag = false
    private var clickFlag = false
    private var paginFlag = false
    private var query =""
    private var page = 1
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setSearchMovieAdapter()
        setPaging()
        initObserve()
        initListener()
    }

    private fun initObserve() {

        viewModel.searchMovie.observe(viewLifecycleOwner) {
            if (adatperFlag) {
                adatperFlag = false
                binding.llEmpty.visibility = View.INVISIBLE
                binding.rvSearch.visibility = View.VISIBLE
                searchMovieAdapter.setData(it.movies)
            }
        }

        viewModel.movieDetails.observe(viewLifecycleOwner) {
            if (clickFlag) {
                clickFlag = false
                val intent = Intent(requireActivity(), DetailMovieActivity::class.java)
                intent.putExtra(Constants.INTENT_KEY_MOVIE_DETAIL, it)
                startActivity(intent)
            }
        }

        viewModel.addSearchMovie.observe(viewLifecycleOwner) {
            if (paginFlag) {
                paginFlag = false
                searchMovieAdapter.addData(it.movies)
                progressBar.dismiss()
            }

        }
    }

    private fun initListener() {
        binding.btnSearch.setOnClickListener {
            if(binding.etSearch.text.toString().isNotBlank()){
                adatperFlag = true
                query=binding.etSearch.text.toString()
                viewModel.requestSearchMovie(
                    binding.etSearch.text.toString(),
                    page,
                    Constants.PAGE_SEARCH_FALSE
                )
            }
        }
        binding.etSearch.setOnEditorActionListener { textView, actionId, keyEvent ->
            when (actionId) {
                EditorInfo.IME_ACTION_SEARCH -> {
                    loadingProgressDialog.show()
                    if (textView.text.isNullOrBlank()) {
                        false
                    } else {
                        adatperFlag = true
                        query=binding.etSearch.text.toString()
                        viewModel.requestSearchMovie(
                            textView.text.toString(),
                            page,
                            Constants.PAGE_SEARCH_FALSE
                        )
                        true
                    }
                }
                else -> {
                    false
                }
            }
        }
    }

    private fun setSearchMovieAdapter() {
        searchMovieAdapter =
            PosterMovieAdapter(this)
        val searchMovieManager =
            GridLayoutManager(requireActivity(), 2)
        binding.rvSearch.apply {
            layoutManager = searchMovieManager
            adapter = searchMovieAdapter
            scrollToPosition(0)
        }

    }

    override fun onMovieItemClick(movieId: Int) {
        clickFlag = true
        query=""
        binding.etSearch.text.clear()
        viewModel.requestMovieDetails(movieId)
    }


    private fun setPaging() {
        progressBar = LoadingProgressDialog(requireActivity())
        binding.rvSearch.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val lastVisibleItemPosition =
                    (recyclerView.layoutManager as GridLayoutManager).findLastCompletelyVisibleItemPosition()

                val itemTotalCount = recyclerView.adapter?.let {
                    it.itemCount
                }

                if (!binding.rvSearch.canScrollVertically(1) && lastVisibleItemPosition + 1 == itemTotalCount) {
                    if (page < Constants.LAST_PAGE) {
                        page++
                        progressBar.show()
                        paginFlag=true
                        viewModel.requestSearchMovie(
                            query,
                            page,
                            Constants.PAGE_SEARCH_TRUE
                        )
                    }
                }
            }
        })
    }
}