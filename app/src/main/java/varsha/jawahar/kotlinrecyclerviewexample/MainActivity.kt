package varsha.jawahar.kotlinrecyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var blogAdapter : BlogRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        addDataSet()
    }

    private fun addDataSet(){
        val data = DataSource.createDataSet() //companion object, getting arraylist of data
        blogAdapter.submitList(data) //submitting data to blogadapter

    }

    private fun initRecyclerView(){
//        recycler_view.layoutManager = LinearLayoutManager(this@MainActivity)
//        blogAdapter = BlogRecyclerAdapter()
//        recycler_view.adapter = blogAdapter

        //Or can use below where you just don't need to explicitly call recycler_view, it's implied
        recycler_view.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)

            //adding spacing
            val topSpacingDecoration = TopSpacingItemDecoration(30)
            addItemDecoration(topSpacingDecoration)


            blogAdapter = BlogRecyclerAdapter()
            adapter = blogAdapter
        }
    }
}
